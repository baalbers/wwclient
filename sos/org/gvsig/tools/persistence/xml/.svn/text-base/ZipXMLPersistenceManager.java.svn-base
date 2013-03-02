/* gvSIG. Geographic Information System of the Valencian Government
*
* Copyright (C) 2007-2008 Infrastructures and Transports Department
* of the Valencian Government (CIT)
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA  02110-1301, USA.
*
*/

/*
* AUTHORS (In addition to CIT):
* 2009 IVER T.I   {{Task}}
*/

/**
 *
 */
package org.gvsig.tools.persistence.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentStateServices;
import org.gvsig.tools.persistence.xml.exception.PersistenceMissingEntryInZIPException;
import org.gvsig.tools.persistence.xml.exception.PersistenceUnssuportedDefinitionTypeException;

/**
 * @author jmvivo
 *
 */
public class ZipXMLPersistenceManager extends XMLPersistenceManager {

	private static final String PERSISTENT_ZIP_ENTRY_NAME =
			"state.xml";
	private static final String BASE_SCHEMA_ENTRY_NAME = "state_base.xsd";

	public PersistentState loadState(InputStream in)
			throws PersistenceException {

		ZipInputStream zIn = new ZipInputStream(in);
		
		ZipEntry zEntry;
		try {
			while ((zEntry = zIn.getNextEntry()) != null) {

				if (zEntry.getName().equals(PERSISTENT_ZIP_ENTRY_NAME)) {
					return super.loadState(zIn);
				}
			}
		} catch (IOException e) {
			throw new PersistenceException(e);
		}
		throw new PersistenceMissingEntryInZIPException(PERSISTENT_ZIP_ENTRY_NAME);
	}

	public void saveState(PersistentState state, OutputStream out)
			throws PersistenceException, PersistenceValidateExceptions {

		ZipOutputStream zOut = new ZipOutputStream(out);
		List exceptions = new ArrayList();


		PersistentContextServices context = (PersistentContextServices) state.getContext();
		try{
			// insert data
			if( this.getAutoValidation() != DISABLED ) {
				try {
					context.validate(this.getAutoValidation());
				} catch(PersistenceValidateExceptions ex) {
					exceptions.add(ex);
				}
			}
			zOut.putNextEntry(new ZipEntry(PERSISTENT_ZIP_ENTRY_NAME));
			XMLPersistentStateWriter xmlWriter = getWriterInstance();

			xmlWriter.write((PersistentStateServices) state, zOut, this
					.getDomains());

			zOut.putNextEntry(new ZipEntry(BASE_SCHEMA_ENTRY_NAME));


			// insert base schema
			InputStream baseSchemaIs = ZipXMLPersistenceManager.class
					.getResourceAsStream("persistentState_base.xsd");
			byte[] buff = new byte[1024*5];
			int readed;
			while ((readed = baseSchemaIs.read(buff)) > 0) {
				zOut.write(buff, 0, readed);
			}
			baseSchemaIs.close();

			// insert registered schemas
			Map domains = this.getDomains();
			Entry entry;
			Iterator iterDomainsEntry = domains.entrySet().iterator();
			while (iterDomainsEntry.hasNext()) {
				entry = (Entry) iterDomainsEntry.next();
				zOut.putNextEntry(new ZipEntry(entry.getKey()+".xsd"));
				try {
				writeSchema(zOut, (String) entry.getKey(), (String) entry
						.getValue());
				} catch(CantGenerateXMLSchemaForDomainException ex) {
					exceptions.add(ex);
				}
			}

			zOut.finish();

		} catch (Exception e) {
			exceptions.add(e);
		}
		if( exceptions.size()>0 ) {
			if( context.getCollectErrors() ) {
				context.addError(new CantSaveStateException(exceptions));
			} else {
				throw new CantSaveStateException(exceptions);
			}
		}

	}

	private void writeSchema(OutputStream out, String domainName,
			String domainURL) throws PersistenceException  {
		PrintWriter printer = new PrintWriter(out);
		printer.println(MessageFormat.format(
				ZipXMLSchemaConstants.XSD_HEAD_VALUE,
				new Object[] {
						domainName, domainURL }));


		List exceptions = new ArrayList();

		List domainDefinitions = getDomainDefinitions(domainName);
		Iterator iter = domainDefinitions.iterator();
		while (iter.hasNext()) {
			DynStruct definition = (DynStruct) iter.next();
			try {
				writeClassDefinitionSchema(printer, definition.getName(), definition);
			} catch(CantGenerateXMLSchemaForDefinitionException ex) {
				exceptions.add(ex);
			}
		}

		printer.println(ZipXMLSchemaConstants.XSD_END);
		printer.flush();
		if( exceptions.size()>0 ) {
			throw new CantGenerateXMLSchemaForDomainException(domainName, exceptions);
		}

	}

	private void writeClassDefinitionSchema(PrintWriter printer,
			String className, DynStruct definition) throws PersistenceException {

		List exceptions = new ArrayList();
		
		printer.print(MessageFormat.format(
				ZipXMLSchemaConstants.XSD_START_CLASS_VALUE,
				new Object[] { className }));

		DynField[] fields = definition.getDynFields();
		DynField field;
		String typeId = "";

		boolean allowNull;

		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			if (!field.isPersistent()) {
				continue;
			}
			allowNull = field.isMandatory() && field.getDefaultValue() == null;
			
			if (field.getDataType().isObject()
					|| field.getDataType().isDynObject()) {
				if (allowNull) {
					typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_OBJECT;
				} else {
					typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_OBJECT_NOTNULL;
				}
			} else {
				switch (field.getType()) {
				case DataTypes.STRING:
				case DataTypes.FILE:
				case DataTypes.FOLDER:
				case DataTypes.URL:
				case DataTypes.URI:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_STRING;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_STRING_NOTNULL;
					}
					break;
				case DataTypes.BOOLEAN:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_BOOLEAN;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_BOOLEAN_NOTNULL;
					}
					break;
				case DataTypes.INT:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_INTEGER;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_INTEGER_NOTNULL;
					}
					break;
	
				case DataTypes.LONG:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_LONG;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_LONG_NOTNULL;
					}
					break;
	
				case DataTypes.FLOAT:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_FLOAT;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_FLOAT_NOTNULL;
					}
					break;
	
				case DataTypes.DOUBLE:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_FLOAT;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_FLOAT_NOTNULL;
					}
					break;
	
				case DataTypes.SET:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_SET;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_SET_NOTNULL;
					}
					break;
	
				case DataTypes.LIST:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_LIST;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_LIST_NOTNULL;
					}
					break;
	
				case DataTypes.ARRAY:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_ARRAY;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_ARRAY_NOTNULL;
					}
					break;
	
				case DataTypes.MAP:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_MAP;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_MAP_NOTNULL;
					}
					break;
	
				case DataTypes.DATE:
					if (allowNull) {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_DATE;
					} else {
						typeId = ZipXMLSchemaConstants.XSD_ATTRUBUTE_TYPE_DATE_NOTNULL;
					}
					break;
	
				default:
					exceptions.add(new PersistenceUnssuportedDefinitionTypeException(className, definition, field));
				}
			}
			
			if (field.isMandatory()) {
				printer.print(MessageFormat.format(
						ZipXMLSchemaConstants.XSD_ATTRUBUTE_MANDATORY_VALUE,
						new String[] { field.getName(), typeId }));
			} else {
				printer.print(MessageFormat.format(
						ZipXMLSchemaConstants.XSD_ATTRUBUTE_VALUE,
						new String[] { field.getName(), typeId }));
			}
		}

		printer.println(ZipXMLSchemaConstants.XSD_END_CLASS);
		if( exceptions.size()>0 ) {
			throw new CantGenerateXMLSchemaForDefinitionException(className, exceptions);
		}
	}

	public class CantGenerateXMLSchemaForDefinitionException extends PersistenceException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2828756207089264709L;
		
		CantGenerateXMLSchemaForDefinitionException(String className, List exceptions) {
			super(
					"Can't generate xml schema definition for the class %(classname).",
					"_Cant_generate_xml_schema_definition_for_the_class_XclassnameX",
					serialVersionUID
			);
			this.addAll(exceptions);
			setValue("classname",className);
		}
	}
	public class CantGenerateXMLSchemaForDomainException extends PersistenceException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2828756207089264709L;
		
		CantGenerateXMLSchemaForDomainException(String domainName, List exceptions) {
			super(
					"Can't generate xml schema definition for domain '%(domain).",
					"_Cant_generate_xml_schema_definition_for_domain_XdomainX",
					serialVersionUID
			);
			this.addAll(exceptions);
			setValue("domain",domainName);
		}
	}
	public class CantSaveStateException extends PersistenceException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7255882015705477288L;

		CantSaveStateException(List exceptions) {
			super(
					"Can't save state.",
					"_Cant_save_state",
					serialVersionUID
			);
			this.addAll(exceptions);
		}
	}
}

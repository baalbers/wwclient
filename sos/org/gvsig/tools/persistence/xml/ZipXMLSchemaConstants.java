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

import java.text.MessageFormat;

/**
 * @author jmvivo
 *
 */
public interface ZipXMLSchemaConstants {

	/**
	 * <ol>
	 * <li>domain name</li>
	 * <li>domain URL</li>
	 * </ol>
	 */
	public static final String XSD_IMPORT_SCHEMA_VALUE =
		"<xs:import namespace=\"{1}\" schemaLocation=\"{0}\"/>\n\n";

	/**
	 * Current Schema file name.
	 */
	public static final String BASE_SCHEMA_FILE_NAME = MessageFormat.format(
			XMLPersistentConstants.SCHEMA_FILE_NAME_VALUE,
			new Object[] { "persistentState_base" });

	/**
	 * <ol>
	 * <li>domain name</li>
	 * <li>domain URL</li>
	 * </ol>
	 */
	public static final String XSD_HEAD_VALUE =
			"<?xml version=\"1.0\"?>\n"+
			"<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"\n"+
			"  targetNamespace=\"{1}\"\n" +
			"  xmlns:tools=\""+XMLPersistentConstants.BASE_DOMIAN_URL+"\"\n"+
			"  xmlns:{0}=\"{1}\"\n"+
			"  elementFormDefault=\"qualified\"\n"+
			"  attributeFormDefault=\"qualified\">\n\n"+
			MessageFormat.format(
				XSD_IMPORT_SCHEMA_VALUE,
				new Object[] {
					BASE_SCHEMA_FILE_NAME,
					XMLPersistentConstants.BASE_DOMIAN_URL }) + "\n\n";

	public static final String XSD_END = "</xs:schema>";

	/**
	 * <ol>
	 * <li>class name</li>
	 * </ol>
	 */
	public static final String XSD_START_CLASS_VALUE =
		"    <xs:element name=\"{0}\">\n" +
        "      <xs:complexType>\n" +
        "        <xs:all>\n";


	public static final String XSD_END_CLASS =
		"        </xs:all>\n" +
		"        <xs:attributeGroup ref=\"tools:state_attributes\"/>\n"+
        "      </xs:complexType>\n" +
		"    </xs:element>\n";

	/**
	 * <ol>
	 * <li>attribute name</li>
	 * <li>attribute type (use
	 *   {@link #XSD_ATTRUBUTE_TYPE_INTEGER},
	 *   {@link #XSD_ATTRUBUTE_TYPE_LONG},
	 *   {@link #XSD_ATTRUBUTE_TYPE_NULL},
	 *   etc..
	 *    ) </li>
	 * </ol>
	 */
	public static final String XSD_ATTRUBUTE_VALUE =
		"          <xs:element name=\"{0}\" type=\"{1}\"/>\n";

	/**
	 * <ol>
	 * <li>attribute name</li>
	 * <li>attribute type (use {@link #XSD_ATTRUBUTE_TYPE_INTEGER},
	 * {@link #XSD_ATTRUBUTE_TYPE_LONG}, {@link #XSD_ATTRUBUTE_TYPE_STRING},
	 * etc.. )</li>
	 * </ol>
	 */
	public static final String XSD_ATTRUBUTE_MANDATORY_VALUE =
		"          <xs:element name=\"{0}\" type=\"{1}\" minOccurs=\"1\"/>\n";


	public static final String XSD_ATTRUBUTE_TYPE_NULL = "tools:state_attribute_Null";
	public static final String XSD_ATTRUBUTE_TYPE_STRING = "tools:state_attribute_String";
	public static final String XSD_ATTRUBUTE_TYPE_BOOLEAN = "tools:state_attribute_Boolean";
	public static final String XSD_ATTRUBUTE_TYPE_INTEGER = "tools:state_attribute_Integer";
	public static final String XSD_ATTRUBUTE_TYPE_LONG = "tools:state_attribute_Long";
	public static final String XSD_ATTRUBUTE_TYPE_FLOAT = "tools:state_attribute_Float";
	public static final String XSD_ATTRUBUTE_TYPE_DOUBLE = "tools:state_attribute_Double";
	public static final String XSD_ATTRUBUTE_TYPE_LIST = "tools:state_attribute_List";
	public static final String XSD_ATTRUBUTE_TYPE_ARRAY = XSD_ATTRUBUTE_TYPE_LIST;
	public static final String XSD_ATTRUBUTE_TYPE_SET = "tools:state_attribute_Set";
	public static final String XSD_ATTRUBUTE_TYPE_MAP = "tools:state_attribute_Map";
	public static final String XSD_ATTRUBUTE_TYPE_OBJECT = "tools:state_attribute_ObjectReference";
	public static final String XSD_ATTRUBUTE_TYPE_DATE = "tools:state_attribute_Date";


	public static final String XSD_ATTRUBUTE_TYPE_STRING_NOTNULL = "tools:state_attribute_String_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_BOOLEAN_NOTNULL = "tools:state_attribute_Boolean_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_INTEGER_NOTNULL = "tools:state_attribute_Integer_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_LONG_NOTNULL = "tools:state_attribute_Long_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_FLOAT_NOTNULL = "tools:state_attribute_Float_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_DOUBLE_NOTNULL = "tools:state_attribute_Double_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_LIST_NOTNULL = "tools:state_attribute_List_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_ARRAY_NOTNULL = XSD_ATTRUBUTE_TYPE_LIST_NOTNULL;
	public static final String XSD_ATTRUBUTE_TYPE_SET_NOTNULL = "tools:state_attribute_Set_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_MAP_NOTNULL = "tools:state_attribute_Map_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_OBJECT_NOTNULL = "tools:state_attribute_ObjectReference_notNull";
	public static final String XSD_ATTRUBUTE_TYPE_DATE_NOTNULL = "tools:state_attribute_Date_notNull";



}

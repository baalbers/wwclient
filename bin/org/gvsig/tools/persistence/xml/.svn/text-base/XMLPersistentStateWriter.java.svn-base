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

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.persistence.PersistenceFactory;
import org.gvsig.tools.persistence.PersistentContext;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceTypeNotSupportedException;
import org.gvsig.tools.persistence.spi.PersistentContextServices.ObjectReference;
import org.gvsig.tools.persistence.spi.PersistentStateServices;

/**
 * @author jmvivo
 *
 */
public class XMLPersistentStateWriter implements XMLPersistentConstants {

	private static Method getCharSetMethod = null;
	private static Method getCharSetNameMethod = null;

	private XMLPersistenceManager manager;
	private PrintWriter print;
	private boolean useCsMap = false;
	private boolean useDomains = false;

	private final static Pattern DOT_PATTERN = Pattern.compile("[.]");

    /**
     * The Unix separator character.
     */
    private static final char UNIX_SEPARATOR = '/';

    /**
     * Is it a Unix-like system?
     */
    private final static boolean UNIX_SYSTEM =
        File.separatorChar == UNIX_SEPARATOR;

    /**
     * The Windows separator character.
     */
    private static final char WINDOWS_SEPARATOR = '\\';

	public XMLPersistentStateWriter(XMLPersistenceManager persistenceManager) {
		this.manager = persistenceManager;
	}

	public void write(PersistentStateServices state, OutputStream out)
			throws PersistenceException {
		write(state, out, null);
	}

	public void write(PersistentStateServices state, OutputStream out,
			Map domains)
			throws PersistenceException {
		PersistentStateServices  root = state;
		String rootId = root.getId().toString();
		PersistentContext context = state.getContext();
		OutputStreamWriter outWrite = new OutputStreamWriter(out);
		print = new PrintWriter(out);

		// XML header (<?xml ....?>)
		print.println(MessageFormat.format(XML_HEADER,
				new String[] { getCharset(outWrite.getEncoding()) }));

		// Prepare schema
		String rootAttributes = "";
		if (domains != null && domains.size() > 0) {
			useDomains = true;
			StringBuffer buffRootAttr = new StringBuffer();

			buffRootAttr.append('\n');
			buffRootAttr.append(MessageFormat.format(
					DOMAIN_NAME_ATTRIBUTE_VALUE, new Object[] {
							BASE_DOMIAN_NAME, BASE_DOMIAN_URL }));
			Iterator iter = domains.entrySet().iterator();
			Entry entry;
			while (iter.hasNext()) {
				entry = (Entry) iter.next();
				buffRootAttr.append('\n');
				buffRootAttr.append(MessageFormat.format(DOMAIN_NAME_ATTRIBUTE_VALUE,
						new Object[] { entry.getKey(), entry.getValue() }));
			}
			iter = domains.entrySet().iterator();
			StringBuffer buffSchemas = new StringBuffer();

			buffSchemas.append('\n');
			buffSchemas.append(MessageFormat.format(SCHEMA_DEFINITON_VALUE,
					new Object[] { BASE_DOMIAN_NAME, BASE_DOMIAN_URL }));
			while (iter.hasNext()) {
				entry = (Entry) iter.next();
				buffSchemas.append('\n');
				buffSchemas.append(MessageFormat.format(SCHEMA_DEFINITON_VALUE,
						new Object[] { entry.getValue(), entry.getKey() }));
			}
			buffRootAttr.append('\n');
			buffRootAttr.append(MessageFormat.format(DEFAULT_SCHEMA_ATTRIBUTE_VALUE,
					new Object[] { buffSchemas.toString() }));
			rootAttributes = buffRootAttr.toString();
		}

		// Root tag:
//		if (useDomains) {
//			print.println(MessageFormat.format(ROOT_VALUE, new Object[] {
//					BASE_DOMIAN_NAME + ":", rootAttributes }));
//		} else {
			print.println(MessageFormat.format(ROOT_VALUE,
					new Object[] { "",
					rootAttributes }));
//		}

		// Version
		print.println(MessageFormat.format(VERSION_VALUE,
				new Object[] { manager.version() }));

		// add root state id
		print.println(MessageFormat.format(ROOTSTATE_VALUE,
				new String[] { rootId }));

		PersistentStateServices curState;
		Iterator itStates = context.iterator();

		// States tag:
		print.println(STATES_START);

		// iter all states
		while (itStates.hasNext()) {
			curState = (PersistentStateServices) itStates.next();
			writeState(curState);

		}
		// States end:
		print.println(STATES_END);

		// Root end:
//		if (useDomains) {
//			print.println(MessageFormat.format(ROOT_END_VALUE,
//					new Object[] { BASE_DOMIAN_NAME + ":" }));
//		} else {
			print.println(MessageFormat.format(ROOT_END_VALUE,
					new Object[] { "" }));
//		}

		print.flush();

	}

	private void writeState(PersistentStateServices curState)
			throws PersistenceException {
		Iterator itNames;
		String name;
		Object value;

		itNames = curState.getNames();
		String theClassName = curState.getTheClassName();
		String tagName = getXMLValidName( theClassName);
		DynStruct definition = curState.getDefinition();
		if( definition != null ) {
			tagName = getXMLValidName(  curState.getDefinition().getFullName() );			
		}

		String domainName = "";
		if (useDomains) {
			PersistenceFactory factory =  manager.getFactories().get(theClassName);
			domainName = factory.getDomainName() + ":";
		}

		// add state start
		print.println(MessageFormat.format(STATE_START, new Object[] {
				domainName, tagName, curState.getId() }));

		boolean useNameAsTag;
		String format, type;
		StringBuffer strb;
		// iter all property names
		while (itNames.hasNext()) {
			name = (String) itNames.next();
			
			value = curState.getValue(name);
			strb = new StringBuffer();
			type = transformValue(value, strb);

			useNameAsTag = VALID_TAG_PATTERN.matcher(name).matches();

			if (useNameAsTag) {
				format = VALUE_ITEM;
			} else {
				format = VALUE_ITEM_GENERIC;
			}

			print.println(MessageFormat.format(format, new String[] { name,
					type, strb.toString() }));

		}

		// add state end
		print.println(MessageFormat.format(STATE_END, new Object[] {
				domainName, tagName, curState.getId() }));

	}

	public static String getXMLValidName(String theClassName) {
		String name = theClassName;
		// Remove all $ chars for inner class names
		int pos = 0;
		while ((pos = name.indexOf('$')) > 0) {
			name =
					name.substring(0, pos).concat("..").concat(
							name.substring(pos + 1));
		}
		while ((pos = name.indexOf(':')) > 0) {
			name =
					name.substring(0, pos).concat("__").concat(
							name.substring(pos + 1));
		}
		return name;
	}

	private String transformValue(Object value, StringBuffer strb)
			throws PersistenceTypeNotSupportedException {
		if (value instanceof String) {
			return transformValue((String) value, strb);
		} else if (value instanceof Number) {
			return transformValue((Number) value, strb);
		} else if (value instanceof ObjectReference) {
			return transformValue((ObjectReference) value, strb);
		} else if (value instanceof List) {
			return transformValue((List) value, strb);
		} else if (value instanceof Set) {
			return transformValue((Set) value, strb);
		} else if (value instanceof Map) {
			return transformValue((Map) value, strb);
		} else if (value instanceof Boolean) {
			return transformValue((Boolean) value, strb);
		} else if (value instanceof Date) {
			return transformValue((Date) value, strb);
		} else if (value instanceof File) {
			return transformValue((File) value, strb);
		} else if (value instanceof URL) {
			return transformValue((URL) value, strb);
		} else if (value instanceof URI) {
			return transformValue((URI) value, strb);
		} else if (value == null) {
			return transformNullValue(strb);
		} else {
			throw new PersistenceTypeNotSupportedException(value.getClass());
		}
	}

	private String transformValue(String value, StringBuffer strb) {
		if (!VALID_VALUE_PATTERN.matcher(value).matches()) {
			strb.append(CDATA_START);
			strb.append(value);
			strb.append(CDATA_END);
		} else {
			strb.append(value);
		}
		return TYPE_STRING;
	}

	private String transformValue(File value, StringBuffer strb) {
		String data;
		data = value.getPath();
        if (!UNIX_SYSTEM) {
            // Always use UNIX separator as it's allowed in both system
            data = data.replace(WINDOWS_SEPARATOR, UNIX_SEPARATOR);
        }
		if (!VALID_VALUE_PATTERN.matcher(data).matches()) {
			strb.append(CDATA_START);
			strb.append(data);
			strb.append(CDATA_END);
		} else {
			strb.append(data);
		}
		return TYPE_FILE;
	}

	private String transformValue(URL value, StringBuffer strb) {
		String data;
		data = value.toExternalForm();
		if (!VALID_VALUE_PATTERN.matcher(data).matches()) {
			strb.append(CDATA_START);
			strb.append(data);
			strb.append(CDATA_END);
		} else {
			strb.append(data);
		}
		return TYPE_URL;
	}

	private String transformValue(URI value, StringBuffer strb) {
		String data;
		data = value.toASCIIString();
		if (!VALID_VALUE_PATTERN.matcher(data).matches()) {
			strb.append(CDATA_START);
			strb.append(data);
			strb.append(CDATA_END);
		} else {
			strb.append(data);
		}
		return TYPE_URI;
	}
	
	private String transformNullValue(StringBuffer strb) {
		return TYPE_NULL;
	}

	private String transformValue(Number value, StringBuffer strb) {
		strb.append(value);
		String[] classname = split(value.getClass().getName(), DOT_PATTERN);
		return classname[classname.length - 1].toLowerCase();
	}

//	private String[] split(String txt, String pattern) {
//		return Pattern.compile(pattern).split(txt, 0);
//	}

	private String[] split(String txt, Pattern pattern) {
		return pattern.split(txt, 0);
	}

	private String transformValue(Boolean value, StringBuffer strb) {
		strb.append(value);
		return TYPE_BOOLEAN;
	}

	private String transformValue(Date value, StringBuffer strb) {
		strb.append(value.getTime());
		return TYPE_DATE;
	}

	private String transformValue(ObjectReference value, StringBuffer strb) {
		strb.append(MessageFormat.format(REFERENCE_VALUE, new Object[] { value
				.getId() }));
		strb.append('\n');
		strb.append(INDENDT_2);
		return TYPE_REFERENCE;
	}

	private String transformValue(List value, StringBuffer strb)
			throws PersistenceTypeNotSupportedException {
		Iterator iter = value.iterator();
		String type;
		StringBuffer itemStrb;
		while (iter.hasNext()) {
			strb.append('\n');
			itemStrb = new StringBuffer();
			type = transformValue(iter.next(), itemStrb);
			if( TYPE_REFERENCE.equalsIgnoreCase(type)) {
				strb.append(MessageFormat.format(LISTITEM_VALUE, new String[] {
						type, itemStrb.toString()+INDENDT_1 }));
			} else {
				strb.append(MessageFormat.format(LISTITEM_VALUE, new String[] {
						type, itemStrb.toString() }));
			}
		}
		strb.append('\n');
		strb.append(INDENDT_2);

		return TYPE_LIST;
	}

	private String transformValue(Set value, StringBuffer strb)
			throws PersistenceTypeNotSupportedException {
		Iterator iter = value.iterator();
		String type;
		StringBuffer itemStrb;
		while (iter.hasNext()) {
			itemStrb = new StringBuffer();
			type = transformValue(iter.next(), itemStrb);
			strb.append(MessageFormat.format(SETITEM_VALUE, new String[] {
					type, itemStrb.toString() }));
		}

		return TYPE_SET;
	}

	private String transformValue(Map value, StringBuffer strb)
			throws PersistenceTypeNotSupportedException {
		Iterator iter = value.entrySet().iterator();
		Entry entry;
		String keyType, valueType;
		StringBuffer valueStrb, keyStrb;
		while (iter.hasNext()) {
			entry = (Entry) iter.next();
			// transform key
			keyStrb = new StringBuffer();
			keyType = transformValue(entry.getKey(), keyStrb);
			// transform value
			valueStrb = new StringBuffer();
			valueType = transformValue(entry.getValue(), valueStrb);

			strb.append(MessageFormat.format(MAPITEM_VALUE, new String[] {
					keyType, keyStrb.toString(), valueType,
					valueStrb.toString() }));
		}

		return TYPE_MAP;
	}

	private String getCharsetByNio(String csName) {
		Object charSet;
		if (getCharSetNameMethod == null) {
			Class charsetClass = null;
			try {
				charsetClass = Class.forName("java.nio.charset.Charset");
			} catch (ClassNotFoundException e) {
				useCsMap = true;
				return null;
			}
			try {
				getCharSetMethod = charsetClass.getMethod("forName",
						new Class[] { String.class });
			} catch (Exception e) {
				useCsMap = true;
				return null;
			}
			try {
				getCharSetNameMethod = charsetClass.getMethod("displayName",
						new Class[] {});
			} catch (Exception e) {
				useCsMap = true;
				return null;
			}

		}
		try {
			charSet = getCharSetMethod.invoke(null, new Object[] { csName });
		} catch (Exception e) {
			useCsMap = true;
			return null;
		}

		try {
			return (String) getCharSetNameMethod.invoke(charSet,
					new Object[] {});
		} catch (Exception e) {
			useCsMap = true;
			return null;
		}
	}

	private String getCharset(String csName) {
		if (!useCsMap) {
			String name = this.getCharsetByNio(csName);
			if (name != null) {
				return name;
			}
		}
		return (String) ChasetMap.getMap().get(csName);
	}
}

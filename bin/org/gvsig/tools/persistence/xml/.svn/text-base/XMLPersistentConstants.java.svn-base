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

package org.gvsig.tools.persistence.xml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public interface XMLPersistentConstants {

	/**
	 * XML Header fomat.<br>
	 * Parameters:
	 *  <ol>
	 *  	<li>encoding</li>
	 *  </ol>
	 */
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"{0}\"?>";

	// Indentations
	/**
	 * Indentation string
	 */
	public static final String INDENDT_1 = "  ";
	/**
	 * Indentation string
	 */
	public static final String INDENDT_2 = "    ";
	/**
	 * Indentation string
	 */
	public static final String INDENDT_3 = "      ";
	/**
	 * Indentation string
	 */
	public static final String INDENDT_4 = "        ";



	// XML ROOT ITEM
	/**
	 * XML Root item tag name
	 */
	public static final String ROOT_TAG = "XMLPersitence";

	/**
	 * XML Root item format.<br>
	 * Parameters:
	 * <ol>
	 * <li>domain notation (Ej. 'tools:')</li>
	 * <li>additional definitions</li>
	 * </ol>
	 */
	public static final String ROOT_VALUE = "<{0}" + ROOT_TAG
			+ " xmlns:xlink=\"http://www.w3.org/1999/xlink\" {1}>";

	public static final String BASE_DOMIAN_URL = "http://www.gvsig.org/libTools";
	public static final String BASE_DOMIAN_NAME = "tools";

	/**
	 * Schema File name format. <br>
	 * Parameters:
	 * <ol>
	 * <li>schema name</li>
	 * </ol>
	 *
	 */
	public static final String SCHEMA_FILE_NAME_VALUE = "{0}.xsd";

	/**
	 * Schema definition format<br>
	 * Parameters:
	 * <ol>
	 * <li>domain URL</li>
	 * <li>domain name</li>
	 * </ol>
	 */
	public static final String SCHEMA_DEFINITON_VALUE = "{0} {1}.xsd \n";

	/**
	 * SCHEMA attribute for ROOT tag.<br>
	 * Parameters:
	 * <ol>
	 * <li>Schema definition list</li>
	 * </ol>
	 */
	public static final String DEFAULT_SCHEMA_ATTRIBUTE_VALUE = INDENDT_3
			+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
			+ "xsi:SchemaLocation=\"{0}\"";


	/**
	 * domain Name definition format. Parameters:
	 * <ol>
	 * <li>domain name</li>
	 * <li>domain URL</li>
	 * </ol>
	 */
	public static final String DOMAIN_NAME_ATTRIBUTE_VALUE = INDENDT_3
			+ "xmlns:{0}=\"{1}\"";

	/**
	 * XML Root item end.<br>
	 * <ol>
	 * <li>domain definition (Ej.: "tools:")</li>
	 * </ol>
	 */
	public static final String ROOT_END_VALUE = "</{0}" + ROOT_TAG + ">";


	// Version definition
	/**
	 * Persistence library version tag name
	 */
	public static final String VERSION_TAG = "persistence_xml_version";
	/**
	 * Persistence library version item format.<br>
	 * Parameters:
	 * <ol>
	 * <li>id root state</li>
	 * </ol>
	 */
	public static final String VERSION_VALUE = "<" + VERSION_TAG + ">{0}</"
			+ VERSION_TAG + ">";


	// Root state item definition
	/**
	 * Root state tag name
	 */
	public static final String ROOTSTATE_TAG = "rootState";

	/**
	 * Root state id attribute name
	 */
	public static final String ROOSTATE_ID_ATTR = "id_state";

	/**
	 * States tag name
	 */
	public static final String STATES_TAG = "states";

	/**
	 * Root state item format.<br>
	 * Parameters:
	 *  <ol>
	 *  	<li>id root state</li>
	 *  </ol>
	 */
	public static final String ROOTSTATE_VALUE = INDENDT_1 + "<"
			+ ROOTSTATE_TAG + " " + ROOSTATE_ID_ATTR
			+ "=\"{0}\" xlink:type=\"simple\""
			+ " xlink:href=\"" + STATES_TAG
			+ "#id(''{0}'')\" />";




	// State item definition

	/**
	 * States item start
	 */
	public static final String STATES_START = "<" + STATES_TAG + ">";
	/**
	 * States item end
	 */
	public static final String STATES_END = "</" + STATES_TAG + ">";

	/**
	 * State id attribute name
	 */
	public static final String STATE_ID_ATTR = "id";

	/**
	 * State item start format.<br>
	 * Parameters:
	 * <ol>
	 * <li>domain prefix (ex: 'aDomain:')</li>
	 * <li>theClassName</li>
	 * <li>id state</li>
	 * </ol>
	 */
	public static final String STATE_START = INDENDT_1 + "<{0}{1} "
			+ STATE_ID_ATTR + "=\"{2}\">";

	/**
	 * State item end format.<br>
	 * Parameters:
	 * <ol>
	 * <li>domain prefix (ex: 'aDomain:')</li>
	 * <li>theClassName</li>
	 * <li>id state</li>
	 * </ol>
	 */
	public static final String STATE_END = INDENDT_1 + "</{0}{1}>";



	// Value item definition
	/**
	 * Value item tag name for generic (when name of value is not a valid xml
	 * tag name)
	 */
	public static final String VALUE_TAG = "value";
	/**
	 * type attribute name for value item
	 */
	public static final String VALUE_TYPE_ATTR = "type";
	/**
	 * name item tag name of Value item for generic (when name of value is
	 * not a valid xml tag name)
	 */
	public static final String NAMEVALUE_TAG = "name";
	/**
	 * data item tag name of Value item for generic (when name of value is
	 * not a valid xml tag name)
	 */
	public static final String DATAVALUE_TAG = "data";
	/**
	 * Value format.<br>
	 * Parameters:
	 *  <ol>
	 *  	<li>name</li>
	 *  	<li>typeName</li>
	 *      <li>string representation of data</li>
	 *  </ol>
	 */
	public static final String VALUE_ITEM = INDENDT_2
			+ "<{0} "
			+ VALUE_TYPE_ATTR + "=\"{1}\">{2}</{0}>";
	/**
	 * Value format for generic (when name of value is
	 * not a valid xml tag name).<br>
	 * Parameters:
	 *  <ol>
	 *  	<li>name</li>
	 *  	<li>typeName</li>
	 *      <li>string representation of data</li>
	 *  </ol>
	 */
	public static final String VALUE_ITEM_GENERIC = INDENDT_2 + "<" + VALUE_TAG
			+ " " + VALUE_TYPE_ATTR + "=\"{1}\">\n" + INDENDT_3 + "<"
			+ NAMEVALUE_TAG + ">{0}</"
			+ NAMEVALUE_TAG + ">\n" + INDENDT_3 + "<" + DATAVALUE_TAG
			+ ">{2}</" + DATAVALUE_TAG + ">\n" + INDENDT_2 + "</" + VALUE_TAG
			+ ">";




	// Final Value data formating
	/**
	 * reference item tag name of data of Value item for references values.
	 */
	public static final String REFERENCE_TAG = "reference";
	/**
	 * type attribute name for value item
	 */
	public static final String REFERENCE_ID_ATTR = "id_state";
	/**
	 * ReferenceValue format.<br>
	 * Parameters:
	 *  <ol>
	 *  	<li>id reference</li>
	 *  </ol>
	 */
	public static final String REFERENCE_VALUE = "\n" + INDENDT_4 + "<"
			+ REFERENCE_TAG + " " + REFERENCE_ID_ATTR
			+ "=\"{0}\" xlink:type=\"simple\""
			+ " xlink:href=\"" + STATES_TAG
			+ "#id(''{0}'')\" />";
	/**
	 * list item tag name of data of Value item for list values.
	 */
	public static final String LISTITEM_TAG = "item";
	/**
	 * List value item format.<br>
	 * Parameters:
	 * <ol>
	 * <li>typeName</li>
	 * <li>string representation of data</li>
	 * </ol>
	 */
	public static final String LISTITEM_VALUE = INDENDT_3 + "<"
			+ LISTITEM_TAG
			+ " " + VALUE_TYPE_ATTR + "=\"{0}\">{1}</" + LISTITEM_TAG + ">";
	/**
	 * set item tag name of data of Value item for list values.
	 */
	public static final String SETITEM_TAG = "item";
	/**
	 * Set value item format.<br>
	 * Parameters:
	 * <ol>
	 * <li>typeName</li>
	 * <li>string representation of data</li>
	 * </ol>
	 */
	public static final String SETITEM_VALUE = INDENDT_3 + "<"
			+ SETITEM_TAG
			+ " " + VALUE_TYPE_ATTR + "=\"{0}\">{1}</" + SETITEM_TAG + ">";
	/**
	 * Map item tag name of data of Value item for list values.
	 */
	public static final String MAPITEM_TAG = "mapitem";
	/**
	 * Key Map item tag name of data of Value item for list values.
	 */
	public static final String MAPKEY_TAG = "key";
	/**
	 * Value Map item tag name of data of Value item for list values.
	 */
	public static final String MAPVALUE_TAG = "value";
	/**
	 * Map item format.<br>
	 * Parameters:
	 * <ol>
	 * *
	 * <li>key typeName</li>
	 * <li>string representation of key</li>
	 * <li>value typeName</li>
	 * <li>string representation of value</li>
	 * </ol>
	 */
	public static final String MAPITEM_VALUE = "\n" + INDENDT_3 + "<"
			+ MAPITEM_TAG
			+ ">\n" + INDENDT_4 + "<" + MAPKEY_TAG + " type=\"{0}\">{1}</"
			+ MAPKEY_TAG + ">\n" + INDENDT_4 + "<" + MAPVALUE_TAG
			+ " type=\"{2}\">{3}</"
			+ MAPVALUE_TAG + ">\n" + INDENDT_3 + "</" + MAPITEM_TAG
			+ ">\n";


	public static final String TYPE_NULL = "null";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_MAP = "map";
	public static final String TYPE_SET = "set";
	public static final String TYPE_LIST = "list";
	public static final String TYPE_REFERENCE = "reference";
	public static final String TYPE_BOOLEAN = "boolean";
	public static final String TYPE_INTEGER = "integer";
	public static final String TYPE_LONG = "long";
	public static final String TYPE_FLOAT = "float";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_DATE = "date";
	public static final String TYPE_FILE = "file";
	public static final String TYPE_URL = "url";
	public static final String TYPE_URI = "uri";
	public static final List TYPES_NUMBER = Collections.unmodifiableList(Arrays
			.asList(new String[] { TYPE_INTEGER, TYPE_LONG, TYPE_FLOAT,
					TYPE_DOUBLE }));

	// Validation patters of xml elements
	/**
	 * Pattern matches with valid xml item names (tag name)
	 */
	public static final Pattern VALID_TAG_PATTERN = Pattern
			.compile("[\\w][\\d\\w_]*");
	/**
	 * Pattern matches with valid xml item text values (text content between tag)
	 */
	public static final Pattern VALID_VALUE_PATTERN = Pattern.compile("[^<&]*");


	// CDATA constants
	/**
	 * CDATA element start
	 */
	public static final String CDATA_START = "<![CDATA[";
	/**
	 * CDATA element end
	 */
	public static final String CDATA_END = "]]>";


}
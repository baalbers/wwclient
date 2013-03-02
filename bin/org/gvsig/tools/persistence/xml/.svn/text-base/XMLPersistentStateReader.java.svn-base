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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceRuntimeException;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentIdentifier;
import org.gvsig.tools.persistence.spi.PersistentStateServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices.ObjectReference;
import org.gvsig.tools.persistence.xml.exception.PersistenceEndOfDocumentException;
import org.gvsig.tools.persistence.xml.exception.PersistenceInvalidValueException;
import org.gvsig.tools.persistence.xml.exception.PersistenceMissingAttributeException;
import org.gvsig.tools.persistence.xml.exception.PersistenceParserException;
import org.gvsig.tools.persistence.xml.exception.PersistenceUnknowTypeException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * @author jmvivo
 *
 */
public class XMLPersistentStateReader implements XMLPersistentConstants {
	private XMLPersistenceManager manager;
	private XmlPullParser parser;
	private PersistentContextServices context;

	public XMLPersistentStateReader(XMLPersistenceManager persistenceManager) {
		this.manager = persistenceManager;
	}

	public void read(PersistentContextServices context, XmlPullParser parser)
			throws PersistenceException {
		this.parser = parser;
		this.context = context;

		try {
			parser.nextTag();
			parser.require(XmlPullParser.START_TAG, null, ROOT_TAG);
			parser.nextTag();
			this.parser.require(XmlPullParser.START_TAG, null, VERSION_TAG);
			String persistenceVersion = this.parser.nextText();
			if (!persistenceVersion.trim().equals(manager.version().trim())) {
				// TODO handle version
			}
			parser.require(XmlPullParser.END_TAG, "", VERSION_TAG);

			parser.nextTag();
			parser.require(XmlPullParser.START_TAG, "", ROOTSTATE_TAG);

			String rootStateIdStr = this.parser.getAttributeValue("",	ROOSTATE_ID_ATTR);
			if (rootStateIdStr == null){
				throw new PersistenceMissingAttributeException(this.parser, ROOSTATE_ID_ATTR);
			}
			parser.nextTag();
			this.parser.require(XmlPullParser.END_TAG, "", ROOTSTATE_TAG);

			parser.nextTag();
			this.parser.require(XmlPullParser.START_TAG, "", STATES_TAG);
			parser.nextTag();

			PersistentStateServices state;
			String curTagName, curIdstr, curClassName;
			//PersistentIdentifier curId;
			String namespace, stateTagName;

			while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
					.getName().equals(STATES_TAG))) {
				checkDocumentEnd();
				parser.require(XmlPullParser.START_TAG, null, null);

				stateTagName = parser.getName();
				namespace = parser.getNamespace();

				curIdstr = parser.getAttributeValue(null, STATE_ID_ATTR);
				if (curIdstr == null){
					throw new PersistenceMissingAttributeException(parser, STATE_ID_ATTR); 
				}

				
				state = this.manager.createPersistentState(context, this.context.getIdentifier(curIdstr));
				curClassName = getClassNameFromTag(stateTagName);
				state.setFactory(this.manager.getFactories().get(curClassName));
				state.setTheClassName(curClassName);				
				context.add(state,null);
				
				
				parser.nextTag();

				parser.require(XmlPullParser.START_TAG, null, null);
				while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
						.getName().equals(stateTagName))) {
					curTagName = parser.getName();
					if (VALUE_ITEM_GENERIC.equals(parser.getName())) {
						// Load value with name and value within tags
						loadGenericTagValue(state);
					} else {
						loadTagValue(state);
					}
					parser.require(XmlPullParser.END_TAG, null, curTagName);
					parser.nextTag();
					checkDocumentEnd();
				}
				parser.require(XmlPullParser.END_TAG, namespace, stateTagName);
				parser.nextTag();

			}

			context.setRootId( context.getIdentifier(rootStateIdStr));
			parser.nextTag();
			this.parser.require(XmlPullParser.END_TAG, "", ROOT_TAG);
			parser.next();
			this.parser.require(XmlPullParser.END_DOCUMENT, null, null);
		} catch (PersistenceException e) {
			throw e;
		} catch (PersistenceRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new PersistenceParserException(this.parser,  e);
		}
	}

	public static String getClassNameFromTag(String stateTagName) {
		String className = stateTagName;
		// Remove domain name from the tag
		int index = className.indexOf(":");
		if (index > -1) {
			className = className.substring(index + 1);
		}
		// Replace .. with the $ char for inner class names
		while ((index = className.indexOf("..")) > 0) {
			className =
					className.substring(0, index).concat("$").concat(
							className.substring(index + 2));
		}
		while ((index = className.indexOf("__")) > 0) {
			className =
					className.substring(0, index).concat(":").concat(
							className.substring(index + 2));
		}

		return className;
	}

	private void loadTagValue(PersistentStateServices state)
			throws XmlPullParserException, IOException, PersistenceException {
		String type = parser.getAttributeValue(null, VALUE_TYPE_ATTR);
		if (type == null) {
			throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);
		}
		String name = parser.getName();
		state.setValue(name, getValue(type));
		// position end tag of {name}

	}

	private void loadGenericTagValue(PersistentStateServices state)
			throws XmlPullParserException, IOException, PersistenceException {
		String type = parser.getAttributeValue(null, VALUE_TYPE_ATTR);
		if (type == null) {
			throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);

		}
		parser.nextTag();
		parser.require(XmlPullParser.START_TAG, "", NAMEVALUE_TAG);
		String name = parser.nextText();
		parser.require(XmlPullParser.END_TAG, "", NAMEVALUE_TAG);
		parser.nextTag();
		parser.require(XmlPullParser.START_TAG, "", DATAVALUE_TAG);
		state.setValue(name, getValue(type));
		parser.require(XmlPullParser.END_TAG, "", DATAVALUE_TAG);
		parser.nextTag();
		// position end tag 'value'
	}

	private Object getValue(String type) throws XmlPullParserException,
			IOException, PersistenceException {
		if (type.equals(TYPE_NULL)) {
			parser.nextTag();
			return null;
		} else if (type.equals(TYPE_STRING)) {
			return parser.nextText();
		} else if (type.equals(TYPE_BOOLEAN)) {
			return getValueBoolean();
		} else if (type.equals(TYPE_DATE)) {
			return getValueDate();
		} else if (type.equals(TYPE_FILE)) {
			return getValueFile();
		} else if (type.equals(TYPE_URL)) {
			return getValueURL();
		} else if (type.equals(TYPE_URI)) {
			return getValueURI();
		} else if (TYPES_NUMBER.contains(type)) {
			return getValueNumber(type);
		} else if (type.equals(TYPE_REFERENCE)) {
			return getValueReference();
		} else if (type.equals(TYPE_LIST)) {
			return getValueList();
		} else if (type.equals(TYPE_SET)) {
			return getValueSet();
		} else if (type.equals(TYPE_MAP)) {
			return getValueMap();
		} else {
			throw new PersistenceUnknowTypeException(this.parser, type);
		}

	}


	private Boolean getValueBoolean() throws XmlPullParserException,
			IOException {
		String value = parser.nextText();
		// XXX: do any check for valid values ???
		return new Boolean(value);
	}

	private File getValueFile() throws XmlPullParserException, IOException {
		String value = parser.nextText();
		return new File(value);
	}

	private URL getValueURL() throws XmlPullParserException, IOException {
		String value = parser.nextText();
		return new URL(value);
	}

	private URI getValueURI() throws XmlPullParserException, IOException,
			PersistenceException {
		String value = parser.nextText();
		try {
			return new URI(value);
		} catch (URISyntaxException e) {
			throw new PersistenceParserException(this.parser, e);
		}
	}

	private Date getValueDate() throws XmlPullParserException,
			IOException {
		String value = parser.nextText();
		Long time;
		try {
			time = new Long(value);
		} catch (NumberFormatException e) {
			throw new PersistenceInvalidValueException(this.parser, TYPE_DATE, value, e);
		}
		return new Date(time.longValue());
	}

	private Number getValueNumber(String type) throws XmlPullParserException,
			IOException {
		String value = parser.nextText().trim();
		Number number = null;
		try {
			if (TYPE_INTEGER.equals(type)){
				number = new Integer(value);
			} else if (TYPE_LONG.equals(type)) {
				number = new Long(value);
			} else if (TYPE_FLOAT.equals(type)) {
				number = new Float(value);
			} else if (TYPE_DOUBLE.equals(type)) {
				number = new Double(value);
			}

		} catch (NumberFormatException e) {
			throw new PersistenceInvalidValueException(this.parser, type, value, e);
		}

		return number;
	}
	private ObjectReference getValueReference() throws XmlPullParserException,
			IOException, PersistenceException {
		parser.nextTag();
		parser.require(XmlPullParser.START_TAG, "", REFERENCE_TAG);
		String idstr = parser.getAttributeValue("", REFERENCE_ID_ATTR);
		if (idstr == null) {
			throw new PersistenceMissingAttributeException(this.parser, REFERENCE_ID_ATTR);
		}
		PersistentIdentifier id;
		id = context.getIdentifier(idstr);
		parser.nextTag();
		parser.require(XmlPullParser.END_TAG, "", REFERENCE_TAG);
		parser.nextTag();
		return context.add(id);
	}

	private List getValueList() throws XmlPullParserException, IOException,
			PersistenceException {
		parser.nextTag();
		List list = new ArrayList();
		String type;
		while (parser.getEventType() == XmlPullParser.START_TAG
				&& LISTITEM_TAG.equals(parser.getName())) {

			type = parser.getAttributeValue("", VALUE_TYPE_ATTR);
			if (type == null) {
				throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);
			}

			list.add(getValue(type));


			parser.require(XmlPullParser.END_TAG, "", LISTITEM_TAG);
			parser.nextTag();
		}
		return manager.getWrappedList(list, context);
	}

	private Set getValueSet() throws XmlPullParserException, IOException,
			PersistenceException {
		parser.nextTag();
		Set set = new LinkedHashSet();
		String type;
		while (parser.getEventType() == XmlPullParser.START_TAG
				&& SETITEM_TAG.equals(parser.getName())) {

			type = parser.getAttributeValue("", VALUE_TYPE_ATTR);
			if (type == null) {
				throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);
			}

			set.add(getValue(type));

			parser.require(XmlPullParser.END_TAG, "", SETITEM_TAG);
			parser.nextTag();
		}
		return manager.getWrappedSet(set, context);

	}

	private void checkDocumentEnd() throws XmlPullParserException {
		if (parser.getEventType() == XmlPullParser.END_DOCUMENT) {
			throw new PersistenceEndOfDocumentException(this.parser);
		}

	}


	private Map getValueMap() throws XmlPullParserException, IOException,
			PersistenceException {
		parser.nextTag();
		Map map = new LinkedHashMap();
		String keyType, valueType;
		Object key, value;
		while (parser.getEventType() == XmlPullParser.START_TAG
				&& MAPITEM_TAG.equals(parser.getName())) {

			parser.nextTag();
			parser.require(XmlPullParser.START_TAG, "", MAPKEY_TAG);
			keyType = parser.getAttributeValue("", VALUE_TYPE_ATTR);
			if (keyType == null) {
				throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);

			}
			key = getValue(keyType);

			parser.require(XmlPullParser.END_TAG, "", MAPKEY_TAG);
			parser.nextTag();
			parser.require(XmlPullParser.START_TAG, "", MAPVALUE_TAG);

			valueType = parser.getAttributeValue("", VALUE_TYPE_ATTR);
			if (valueType == null) {
				throw new PersistenceMissingAttributeException(this.parser, VALUE_TYPE_ATTR);
			}

			value = getValue(valueType);

			parser.require(XmlPullParser.END_TAG, "", MAPVALUE_TAG);
			parser.nextTag();

			map.put(key, value);

			parser.require(XmlPullParser.END_TAG, "", MAPITEM_TAG);
			parser.nextTag();
		}
		return manager.getWrappedMap(map, context);
	}
}


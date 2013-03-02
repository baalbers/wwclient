package org.gvsig.tools.dynobject.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynClassName;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynObjectRuntimeException;
import org.gvsig.tools.dynobject.DynObjectValueItem;
import org.gvsig.tools.dynobject.exception.DynFieldIsNotAContainerException;
import org.gvsig.tools.exception.BaseRuntimeException;
import org.gvsig.tools.exception.ListBaseException;

public class DynClassImportHelper {

	private static final Logger LOG = LoggerFactory
			.getLogger(DynClassImportHelper.class);

	private static final String VERSION_VALUE = "1.0.0";

	private static final String DEFINITIONS_TAG = "definitions";
	private static final String VERSION_TAG = "version";
	private static final String CLASSES_TAG = "classes";

	private static final String CLASS_TAG = "class";
	private static final String CLASS_NAME_TAG = "name";
	private static final String CLASS_NAMESPACE_TAG = "namespace";
	private static final String CLASS_DESCRIPTION_TAG = "description";
	private static final String CLASS_SUPERCLASSNAMES_TAG = "superClassNames";
	private static final String CLASS_SUPERCLASSNAME_TAG = "superClassName";
	private static final String CLASS_EXTENDS_TAG = "extends";
	private static final String CLASS_EXTENDS_CLASS_TAG = "class";
	private static final String CLASS_FIELDS_TAG = "fields";

	private static final String FIELD_TAG = "field";
	private static final String FIELD_NAME_TAG = "name";
	private static final String FIELD_DESCRIPTION_TAG = "description";
	private static final String FIELD_SUBTYPE_TAG = "subtype";
	private static final String FIELD_TYPE_TAG = "type";
	private static final String FIELD_ISMANDATORY_TAG = "mandatory";
	private static final String FIELD_ISPERSISTENT_TAG = "persistent";
	private static final String FIELD_MINVALUE_TAG = "minValue";
	private static final String FIELD_MAXVALUE_TAG = "maxValue";
	private static final String FIELD_CLASSOFVALUE_TAG = "classOfValue";
	private static final String FIELD_CLASSOFITEMS_TAG = "classOfItems";
	private static final String FIELD_DEFAULTVALUE_TAG = "defaultValue";
	// private static final String FIELD_TYPEOFAVALILABLEVALUES_TAG =
	// "typeOfAvailableValues";
	private static final String FIELD_AVALILABLEVALUES_TAG = "availableValues";
	private static final String FIELD_GROUP_TAG = "group";
	private static final String FIELD_ORDER_TAG = "order";
	private static final String FIELD_HIDDEN_TAG = "hidden";

	private static final String VALUEITEM_TAG = "valueItem";
	private static final String VALUEITEM_LABEL_TAG = "label";
	private static final String VALUEITEM_VALUE_TAG = "value";

	private DynObjectManager manager = ToolsLocator.getDynObjectManager();

	private String getNullWhenEmptyString(String value) {
		if (value != null) {
			if (value.trim().length() == 0) {
				return null;
			}
		}
		return value;

	}

	private String nextText(XmlPullParser parser)
			throws XmlPullParserException, IOException {
		return getNullWhenEmptyString(parser.nextText());
	}

	private String getAttributeValue(XmlPullParser parser, int i)
			throws XmlPullParserException, IOException {
		return getNullWhenEmptyString(parser.getAttributeValue(i));
	}

	public Map importDefinitions(InputStream resource, ClassLoader loader,
			String defaultNamespace) throws XmlPullParserException, IOException {

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance(
				ToolsLocator.getInstance().getXmlPullParserFactoryClassNames(),
				null);

		XmlPullParser parser = factory.newPullParser();

		parser.setInput(resource, null);

		return importDefinitions(parser, loader, defaultNamespace);
	}

	private class Definitions extends HashMap implements Map {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3322643637478345069L;

		public Object put(Object key, Object value) {
			return super.put(((String) key).toLowerCase(), value);
		}

		public Object get(Object theName) {
			DynClass definition;
			definition = (DynClass) super.get(((String) theName).toLowerCase());
			if (definition != null) {
				return definition;
			}
			// No ha encontrado la clase pedida, podria ser que el namespace
			// no coincida, vamos a buscarla ignorando el namespace en caso
			// de que este no se haya indicado.
			DynClassName name = manager.createDynClassName((String) theName);
			if (name.getNamespace() == null) {
				// No han especificado namespace, asi que busco la primera
				// que tenga como nombre el indicado independientemente del
				// namespace que tenga.
				Iterator it = this.values().iterator();
				while (it.hasNext()) {
					definition = (DynClass) it.next();
					if (definition.getName().equalsIgnoreCase(name.getName())) {
						return definition;
					}
				}
			} else {
				// Han especificaso un namespace, asi que voy a buscar una que
				// no tenga namespace y su nombre concuerde.
				Iterator it = this.values().iterator();
				while (it.hasNext()) {
					definition = (DynClass) it.next();
					if (definition.getNamespace() == null
							&& definition.getName().equalsIgnoreCase(
									name.getName())) {
						return definition;
					}
				}
			}
			return null;
		}

		public boolean containsKey(Object key) {
			String lowerKey = ((String) key).toLowerCase();
			if (super.containsKey(lowerKey)) {
				return true;
			}
			Object value = this.get(lowerKey);
			return value != null;
		}
	}

	public Map importDefinitions(XmlPullParser parser, ClassLoader loader,
			String defaultNamespace) throws XmlPullParserException, IOException {
		Map dynClasses = new Definitions();
		String version = null;

		if (loader == null) {
			loader = this.getClass().getClassLoader();
		}
		parser.nextTag();
		parser.require(XmlPullParser.START_TAG, null, DEFINITIONS_TAG);
		for (int i = 0; i < parser.getAttributeCount(); i++) {
			String name = parser.getAttributeName(i);
			if (name.equalsIgnoreCase(VERSION_TAG)) {
				version = this.getAttributeValue(parser, i);
			} else {
				throw new WrongVersionException(parser);
			}
		}
		parser.nextTag();
		if (parser.getName().equalsIgnoreCase(VERSION_TAG)) {
			parser.require(XmlPullParser.START_TAG, null, VERSION_TAG);
			version = parser.nextText();
			if (!version.trim().equals(VERSION_VALUE)) {
				throw new UnsupportedClassVersionError();
			}
			parser.require(XmlPullParser.END_TAG, "", VERSION_TAG);
			parser.nextTag();
		}

		parser.require(XmlPullParser.START_TAG, "", CLASSES_TAG);
		parser.nextTag();
		while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
				.getName().equals(CLASSES_TAG))) {
			checkEndDocument(parser);
			DynClass dynClass = importDynClass(parser, loader,
					defaultNamespace, dynClasses);
			try {
				((DefaultDynClass) dynClass).check();
			} catch (ListBaseException e) {
				throw new DynObjectRuntimeException(e);
			}
			if (dynClasses.get(dynClass.getFullName()) != null) {
				throw new DuplicateDynClassException(parser,
						dynClass.getFullName());
			}
			dynClasses.put(dynClass.getFullName(), dynClass);
		}
		parser.require(XmlPullParser.END_TAG, "", CLASSES_TAG);
		parser.nextTag();

		parser.require(XmlPullParser.END_TAG, "", DEFINITIONS_TAG);
		parser.next();

		parser.require(XmlPullParser.END_DOCUMENT, null, null);
		LOG.debug("Imported classes {}", new Object[] { getKeys(dynClasses) });
		return dynClasses;
	}

	private String getKeys(Map theMap) {
		List l = new ArrayList(theMap.keySet());
		return l.toString();
	}

	private DynClass importDynClass(XmlPullParser parser, ClassLoader loader,
			String defaultNamespace, Map classes)
			throws XmlPullParserException, IOException {
		DynObjectManager manager = ToolsLocator.getDynObjectManager();
		DynClass dynClass;
		List superClasses = new ArrayList();
		Map values = new HashMap();

		parser.require(XmlPullParser.START_TAG, null, CLASS_TAG);
		//
		// Collect class attributes from tag attributes
		//
		for (int i = 0; i < parser.getAttributeCount(); i++) {
			values.put(parser.getAttributeName(i),
					this.getAttributeValue(parser, i));
		}
		parser.nextTag();

		while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
				.getName().equals(CLASSES_TAG))) {
			checkEndDocument(parser);

			parser.require(XmlPullParser.START_TAG, null, null);
			String tagName = parser.getName();
			if (tagName.equalsIgnoreCase(CLASS_DESCRIPTION_TAG)) {
				values.put(CLASS_DESCRIPTION_TAG, this.nextText(parser));

			} else if (tagName.equalsIgnoreCase(CLASS_NAME_TAG)) {
				values.put(CLASS_NAME_TAG, this.nextText(parser));

			} else if (tagName.equalsIgnoreCase(CLASS_NAMESPACE_TAG)) {
				values.put(CLASS_NAMESPACE_TAG, this.nextText(parser));

			} else if (tagName.equalsIgnoreCase(CLASS_SUPERCLASSNAMES_TAG)) {
				parser.nextTag();
				while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
						.getName().equals(CLASS_SUPERCLASSNAMES_TAG))) {
					checkEndDocument(parser);
					parser.require(XmlPullParser.START_TAG, "",
							CLASS_SUPERCLASSNAME_TAG);
					superClasses.add(manager.createDynClassName(
							defaultNamespace, this.nextText(parser)));
					parser.require(XmlPullParser.END_TAG, null,
							CLASS_SUPERCLASSNAME_TAG);
					parser.nextTag();
				}

			} else if (tagName.equalsIgnoreCase(CLASS_EXTENDS_TAG)) {
				parser.nextTag();
				while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
						.getName().equals(CLASS_EXTENDS_TAG))) {
					checkEndDocument(parser);
					superClasses
							.add(importSuperClass(parser, defaultNamespace));
					parser.nextTag();
				}
			} else {
				break;
			}
			parser.require(XmlPullParser.END_TAG, null, tagName);
			parser.nextTag();
		}
		parser.require(XmlPullParser.START_TAG, null, CLASS_FIELDS_TAG);
		parser.nextTag();

		//
		// Create dynclass
		//
		if (values.get(CLASS_NAME_TAG) == null) {
			throw new NeedTagOrAttributeException(parser, CLASS_NAME_TAG);
		}
		if (values.get(CLASS_NAMESPACE_TAG) == null) {
			values.put(CLASS_NAMESPACE_TAG, defaultNamespace);
		}
		dynClass = manager.createDynClass(
				(String) values.get(CLASS_NAMESPACE_TAG),
				(String) values.get(CLASS_NAME_TAG),
				(String) values.get(CLASS_DESCRIPTION_TAG));
		for (int i = 0; i < superClasses.size(); i++) {
			DynClassName superClass = (DynClassName) superClasses.get(i);
			if (superClass.getName() == null) {
				throw new NeedTagOrAttributeException(parser, CLASS_NAME_TAG);
			}
			DynClass superDynClass = (DynClass) classes.get(superClass
					.getFullName());
			if (superDynClass == null) {
				superDynClass = ToolsLocator.getDynObjectManager().get(
						superClass.getNamespace(), superClass.getName());
				if (superDynClass == null) {
					throw new CantLocateDynClassException(parser,
							superClass.getFullName());
				}
			}
			dynClass.extend(superDynClass);
		}

		//
		// Parse and load fields of dynclass
		//
		while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
				.getName().equals(CLASS_FIELDS_TAG))) {
			checkEndDocument(parser);
			importDynField(parser, dynClass, loader);
			parser.nextTag();
		}
		parser.require(XmlPullParser.END_TAG, null, CLASS_FIELDS_TAG);
		parser.nextTag();

		parser.require(XmlPullParser.END_TAG, null, CLASS_TAG);
		parser.nextTag();
		return dynClass;
	}

	private DynClassName importSuperClass(XmlPullParser parser,
			String defaultNamespace) throws XmlPullParserException, IOException {

		String name = null;
		String namespace = defaultNamespace;

		parser.require(XmlPullParser.START_TAG, null, CLASS_EXTENDS_CLASS_TAG);
		for (int i = 0; i < parser.getAttributeCount(); i++) {
			String attrname = parser.getAttributeName(i);
			if (attrname.equalsIgnoreCase(CLASS_NAME_TAG)) {
				name = this.getAttributeValue(parser, i);
			} else if (attrname.equalsIgnoreCase(CLASS_NAMESPACE_TAG)) {
				namespace = this.getAttributeValue(parser, i);
			} else {
				throw new UnexpectedTagOrAttributeException(parser, attrname);
			}
		}
		if (name == null) {
			name = this.nextText(parser);
		} else {
			parser.nextTag();
		}
		parser.require(XmlPullParser.END_TAG, null, CLASS_EXTENDS_CLASS_TAG);
		DynClassName dynClassName = manager.createDynClassName(namespace, name);
		return dynClassName;
	}

	private void importDynField(XmlPullParser parser, DynClass dynClass,
			ClassLoader loader) throws XmlPullParserException, IOException {
		DynField field;
		List availableValues = null;
		Map values = new HashMap();

		parser.require(XmlPullParser.START_TAG, null, FIELD_TAG);
		//
		// Collect field attributes from tag attributes
		//
		for (int i = 0; i < parser.getAttributeCount(); i++) {
			values.put(parser.getAttributeName(i),
					this.getAttributeValue(parser, i));
		}
		parser.nextTag();

		//
		// Collect field attributes from tags
		//
		while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
				.getName().equals(FIELD_TAG))) {
			checkEndDocument(parser);

			parser.require(XmlPullParser.START_TAG, null, null);
			String name = parser.getName();
			if (name.equalsIgnoreCase(FIELD_NAME_TAG)) {
				values.put(FIELD_NAME_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_DESCRIPTION_TAG)) {
				values.put(FIELD_DESCRIPTION_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_TYPE_TAG)) {
				values.put(FIELD_TYPE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_SUBTYPE_TAG)) {
				values.put(FIELD_SUBTYPE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_GROUP_TAG)) {
				values.put(FIELD_GROUP_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_ORDER_TAG)) {
				values.put(FIELD_ORDER_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_ISMANDATORY_TAG)) {
				values.put(FIELD_ISMANDATORY_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_ISPERSISTENT_TAG)) {
				values.put(FIELD_ISPERSISTENT_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_MINVALUE_TAG)) {
				values.put(FIELD_MINVALUE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_MAXVALUE_TAG)) {
				values.put(FIELD_MAXVALUE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_CLASSOFVALUE_TAG)) {
				values.put(FIELD_CLASSOFVALUE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_CLASSOFITEMS_TAG)) {
				values.put(FIELD_CLASSOFITEMS_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_DEFAULTVALUE_TAG)) {
				values.put(FIELD_DEFAULTVALUE_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_HIDDEN_TAG)) {
				values.put(FIELD_HIDDEN_TAG, this.nextText(parser));

			} else if (name.equalsIgnoreCase(FIELD_AVALILABLEVALUES_TAG)) {
				parser.nextTag();
				availableValues = new ArrayList();
				while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
						.getName().equals(FIELD_AVALILABLEVALUES_TAG))) {
					checkEndDocument(parser);
					availableValues.add(importValueItem(parser));
					parser.nextTag();
				}

			} else {
				break;
			}
			parser.require(XmlPullParser.END_TAG, null, name);
			parser.nextTag();
		}
		parser.require(XmlPullParser.END_TAG, null, FIELD_TAG);

		if (values.get(FIELD_NAME_TAG) == null) {
			throw new NeedTagOrAttributeException(parser, FIELD_NAME_TAG);
		}

		//
		// Create the field
		//
		field = dynClass.addDynField((String) values.get(FIELD_NAME_TAG));

		//
		// Setting type and subtype first
		//

		String name = FIELD_TYPE_TAG;
		String value = (String) values.get(name);
		if (value != null) {
			int type = ToolsLocator.getDataTypesManager().getType(value);
			if (type == DataTypes.INVALID) {
				throw new InvalidFieldTypeException(parser, value);
			}
			field.setType(type);
			name = FIELD_CLASSOFVALUE_TAG;
			value = (String) values.get(name);
			if (value != null) {
				try {
					Class klass;
					LOG.info("Intentando cargar clase '" + value + "'.");
					klass = Class.forName(value, true, loader);
					field.setClassOfValue(klass);
				} catch (DynFieldIsNotAContainerException e) {
					LOG.warn("No se ha encontrado la clase '" + value + "'.", e);
					throw new IncompatibleAttributeValueException(parser,
							FIELD_NAME_TAG);
				} catch (ClassNotFoundException e) {
					LOG.warn("No se ha encontrado la clase '" + value + "'.", e);
					throw new CantLocateClassException(parser, FIELD_NAME_TAG);
				}
			}
			name = FIELD_CLASSOFITEMS_TAG;
			value = (String) values.get(name);
			if (value != null) {
				try {
					Class klass;
					klass = Class.forName(value, true, loader);
					field.setClassOfValue(klass);
				} catch (DynFieldIsNotAContainerException e) {
					throw new IncompatibleAttributeValueException(parser,
                        FIELD_NAME_TAG, value);
				} catch (ClassNotFoundException e) {
                    throw new CantLocateClassException(parser, FIELD_NAME_TAG,
                        value);
				}
			}
		}

		name = FIELD_SUBTYPE_TAG;
		value = (String) values.get(name);
		if (value != null) {
			try {
				field.setSubtype(value);
			} catch (IllegalArgumentException e) {
				// Ignore exception
			}
		}

		//
		// Load other values in the field
		//
		Iterator names = values.keySet().iterator();
		while (names.hasNext()) {
			name = (String) names.next();
			value = (String) values.get(name);
			if (value == null) {
				continue;
			}
			if (name.equalsIgnoreCase(FIELD_NAME_TAG)) {
				// Do nothing

			} else if (name.equalsIgnoreCase(FIELD_DESCRIPTION_TAG)) {
				field.setDescription(value);

			} else if (name.equalsIgnoreCase(FIELD_TYPE_TAG)) {
				// Do nothing
			} else if (name.equalsIgnoreCase(FIELD_SUBTYPE_TAG)) {
				// Do nothing
			} else if (name.equalsIgnoreCase(FIELD_GROUP_TAG)) {
				field.setGroup(value);

			} else if (name.equalsIgnoreCase(FIELD_ORDER_TAG)) {
				field.setOrder(Integer.parseInt(value));

			} else if (name.equalsIgnoreCase(FIELD_ISMANDATORY_TAG)) {
				field.setMandatory(new Boolean(value).booleanValue());

			} else if (name.equalsIgnoreCase(FIELD_ISPERSISTENT_TAG)) {
				field.setPersistent(new Boolean(value).booleanValue());

			} else if (name.equalsIgnoreCase(FIELD_HIDDEN_TAG)) {
				field.setHidden(new Boolean(value).booleanValue());

			} else if (name.equalsIgnoreCase(FIELD_MINVALUE_TAG)) {
				field.setMinValue(value);

			} else if (name.equalsIgnoreCase(FIELD_MAXVALUE_TAG)) {
				field.setMaxValue(value);
				
			} else if (name.equalsIgnoreCase(FIELD_DEFAULTVALUE_TAG)) {
				field.setDefaultFieldValue(value);

			} else if (name.equalsIgnoreCase(FIELD_AVALILABLEVALUES_TAG)) {
				// Do nothing

			} else if (name.equalsIgnoreCase(FIELD_CLASSOFVALUE_TAG)) {
				// Do nothing

			} else if (name.equalsIgnoreCase(FIELD_CLASSOFITEMS_TAG)) {
				// Do nothing

			} else {
				throw new UnexpectedTagOrAttributeException(parser, name);
			}
		}

		try {
			//
			// Coerce the min/max/default/available values to the type of
			// the field
			//
			if (availableValues != null && !availableValues.isEmpty()) {
				for (int i = 0; i < availableValues.size(); i++) {
					PairValueLabel pair = (PairValueLabel) availableValues
							.get(i);
					if (pair.label == null) {
						if (pair.value == null) {
							pair.label = "null";
						} else {
							pair.label = pair.value.toString();
						}
					}
					availableValues.set(i,
							new DynObjectValueItem(field.coerce(pair.value),
									pair.label));
				}
				field.setAvailableValues(availableValues);
			}
			field.setMaxValue(field.coerce(values.get(FIELD_MAXVALUE_TAG)));
			field.setMinValue(field.coerce(values.get(FIELD_MINVALUE_TAG)));
			field.setDefaultFieldValue(field.coerce(values
					.get(FIELD_DEFAULTVALUE_TAG)));
		} catch (CoercionException e) {
			throw new ParseCoerceException(e, parser);
		}
	}

	private class PairValueLabel {
		String label = null;
		String value = null;
	}

	private PairValueLabel importValueItem(XmlPullParser parser)
			throws XmlPullParserException, IOException {
		PairValueLabel pair = new PairValueLabel();

		if (parser.getName().equalsIgnoreCase(VALUEITEM_TAG)) {
			parser.require(XmlPullParser.START_TAG, null, VALUEITEM_TAG);
			for (int i = 0; i < parser.getAttributeCount(); i++) {
				String name = parser.getAttributeName(i);
				if (name.equalsIgnoreCase(VALUEITEM_LABEL_TAG)) {
					pair.label = this.getAttributeValue(parser, i);
				} else if (name.equalsIgnoreCase(VALUEITEM_VALUE_TAG)) {
					pair.value = this.getAttributeValue(parser, i);
				} else {
					throw new UnexpectedTagOrAttributeException(parser, name);
				}
			}
			parser.nextTag();

			while (!(parser.getEventType() == XmlPullParser.END_TAG && parser
					.getName().equals(VALUEITEM_TAG))) {
				checkEndDocument(parser);
				parser.require(XmlPullParser.START_TAG, null, null);
				String name = parser.getName();
				if (name.equalsIgnoreCase(VALUEITEM_LABEL_TAG)) {
					pair.label = this.nextText(parser);
				} else if (name.equalsIgnoreCase(VALUEITEM_VALUE_TAG)) {
					pair.value = this.nextText(parser);
				} else {
					break;
				}
				parser.require(XmlPullParser.END_TAG, null, name);
				parser.nextTag();
			}
			parser.require(XmlPullParser.END_TAG, null, VALUEITEM_TAG);
		} else {
			parser.require(XmlPullParser.START_TAG, null, VALUEITEM_VALUE_TAG);
			for (int i = 0; i < parser.getAttributeCount(); i++) {
				String name = parser.getAttributeName(i);
				if (name.equalsIgnoreCase(VALUEITEM_LABEL_TAG)) {
					pair.label = parser.getAttributeValue(i);
				} else {
					throw new UnexpectedTagOrAttributeException(parser, name);
				}
			}
			pair.value = parser.nextText();
			parser.require(XmlPullParser.END_TAG, null, VALUEITEM_VALUE_TAG);
		}
		return pair;
	}

	private void checkEndDocument(XmlPullParser parser)
			throws XmlPullParserException {
		if (parser.getEventType() == XmlPullParser.END_DOCUMENT) {
			throw new UnexpectedTagOrAttributeException(parser,
					"(end-of-document)");
		}

	}

	public static abstract class ImportDynClassesException extends
			BaseRuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3346283395112730192L;

		/**
		 * Don't call this constructor form subclasses.
		 * 
		 * @param parser
		 */
		public ImportDynClassesException(XmlPullParser parser) {
			super(
					"Error importing classes from file at line %(line) column %(column).",
					"_Error_importing_classes_from_file_at_line_XlineX_column_XcolumnX",
					serialVersionUID);
		}

		protected ImportDynClassesException(XmlPullParser parser, String msg,
				String key, long code) {
			super(
					"Error importing classes from file at line %(line) column %(column). "
							+ msg, key, code);
			this.setValue("line", new Integer(parser.getLineNumber()));
			this.setValue("column", new Integer(parser.getColumnNumber()));
		}
	}

	public static class DuplicateDynClassException extends
			ImportDynClassesException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3653024321140806121L;

		public DuplicateDynClassException(XmlPullParser parser, String name) {
			super(parser, "Duplicate DynClass definition for '%(name)'.",
					"_Duplicate_DynClass_definition_for_XnameX",
					serialVersionUID);
			this.setValue("name", name);
		}
	}

	public static class InvalidFieldTypeException extends
			ImportDynClassesException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8501343258053356775L;

		public InvalidFieldTypeException(XmlPullParser parser, String value) {
			super(parser, "Invalid field type '%(value)'.",
					"_Invalid_field_type_XvalueX", serialVersionUID);
			this.setValue("value", value);
		}
	}

	public static class UnexpectedTagOrAttributeException extends
			ImportDynClassesException {
		/**
		 * 
		 */
		private static final long serialVersionUID = -808282903423455613L;

		public UnexpectedTagOrAttributeException(XmlPullParser parser,
				String tag) {
			super(parser, "Unexpected tag or attribute '%(tag)'.",
					"_Unexpected_tag_or_attribute_XtagX", serialVersionUID);
			this.setValue("tag", tag);
		}
	}

	public static class NeedTagOrAttributeException extends
			ImportDynClassesException {
		/**
		 * 
		 */
		private static final long serialVersionUID = -808282903423455613L;

		public NeedTagOrAttributeException(XmlPullParser parser, String tag) {
			super(parser, "Need tag or attribute '%(tag)'.",
					"_Need_tag_or_attribute_XtagX", serialVersionUID);
			this.setValue("tag", tag);
		}
	}

	public static class CantLocateClassException extends
			ImportDynClassesException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5733585544096433612L;

        public CantLocateClassException(XmlPullParser parser, String tagname) {
            super(parser, "Can't locate class named in attribute '%(name)'.",
                "_Cant_locate_class_XnameX", serialVersionUID);
            this.setValue("name", tagname);
        }

        public CantLocateClassException(XmlPullParser parser, String tagname,
            String className) {
            super(parser, "Can't locate class named in attribute '%(name)' "
                + "whose name is '%(className)'.", "_Cant_locate_class_XnameX",
                serialVersionUID);
            this.setValue("name", tagname);
            this.setValue("className", className);
        }
	}

	public static class CantLocateDynClassException extends
			ImportDynClassesException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6286170415562358806L;

		public CantLocateDynClassException(XmlPullParser parser, String tagname) {
			super(parser,
					"Can't locate DynClass '%(name). Look at the extends tag.",
					"_Cant_locate_DynClass_XnameX", serialVersionUID);
			this.setValue("name", tagname);
		}
	}

	public static class IncompatibleAttributeValueException extends
			ImportDynClassesException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2646530094487375049L;

		public IncompatibleAttributeValueException(XmlPullParser parser,
				String name) {
            super(parser, "Incompatible attribute value for field '%(name)'.",
					"_Incompatible_attribute_value_for_field_XnameX",
					serialVersionUID);
			this.setValue("name", name);
		}

        public IncompatibleAttributeValueException(XmlPullParser parser,
            String name, String value) {
            super(
                parser,
                "Incompatible attribute value '%(value)', for field '%(name)'.",
                "_Incompatible_attribute_value_for_field_XnameX",
                serialVersionUID);
            this.setValue("name", name);
            this.setValue("value", value);
        }
	}

	public static class ParseCoerceException extends ImportDynClassesException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1447718822981628834L;

		public ParseCoerceException(Throwable cause, XmlPullParser parser) {
			super(parser, "Can't convert value.", "_Cant_convert_value",
					serialVersionUID);
			this.initCause(cause);
		}
	}

	public static class WrongVersionException extends ImportDynClassesException {

		private static final long serialVersionUID = 6620589308398698367L;

		public WrongVersionException(XmlPullParser parser) {
			super(parser, "Wrong format version.", "_Wrong_format_version",
					serialVersionUID);
		}
	}

}

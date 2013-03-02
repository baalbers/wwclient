package org.gvsig.tools.dataTypes.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.Timestamp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataType;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dataTypes.DataTypesManager;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToBoolean;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToByte;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToDate;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToDateTime;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToDouble;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToFile;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToFloat;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToInt;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToLong;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToString;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToTime;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToURI;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToURL;
import org.gvsig.tools.dataTypes.impl.coercion.CoerceToTimestamp;
import org.gvsig.tools.dynobject.DynObject;

public class DefaultDataTypesManager implements DataTypesManager, DataTypes {

    private static final Logger LOG = LoggerFactory
        .getLogger(DefaultDataTypesManager.class);

    private static final int NEWINDEXES_AT = OBJECT + 1;

    private DataType[] types = new DefaultDataType[MAX_TYPE_VALUE];

    public DefaultDataTypesManager() {

        this.addtype(BOOLEAN, null, "Boolean", Boolean.class,
            new CoerceToBoolean());
        this.addtype(BYTE, null, "Byte", Byte.class, new CoerceToByte());
        this.addtype(CHAR, null, "Char", Character.class, new CoerceToString());
        this.addtype(INT, null, "Integer", Integer.class, new CoerceToInt());
        this.addtype(LONG, null, "Long", Long.class, new CoerceToLong());
        this.addtype(FLOAT, null, "Float", Float.class, new CoerceToFloat());
        this.addtype(DOUBLE, null, "Double", Double.class, new CoerceToDouble());
        this.addtype(STRING, null, "String", String.class, new CoerceToString());
        this.addtype(DATE, SUBTYPE_DATE, "Date", Date.class, new CoerceToDate());
        this.addtype(TIME, SUBTYPE_DATE, "Time", Date.class, new CoerceToTime());
        this.addtype(TIMESTAMP, null, "Timestamp", Timestamp.class, new CoerceToTimestamp());

        this.addtype(BYTEARRAY, null, "ByteArray", null, null);
        this.addtype(FILE, SUBTYPE_FILE, "File", File.class, new CoerceToFile());
        this.addtype(FOLDER, SUBTYPE_FOLDER, "Folder", File.class,
            new CoerceToFile());
        this.addtype(DYNOBJECT, null, "DynObject", DynObject.class, null);
        this.addtype(URL, null, "URL", URL.class, new CoerceToURL());
        this.addtype(URI, null, "URI", URI.class, new CoerceToURI());

        this.addtype(ARRAY, null, "Array", null, null);
        this.addtype(LIST, null, "List", List.class, null);
        this.addtype(SET, null, "Set", Set.class, null);
        this.addtype(MAP, null, "Map", Map.class, null);

        this.addtype(OBJECT, null, "Object", null, null);
    }

    public synchronized int addtype(int type, String subtype, String name,
        Class defaultClass, Coercion coercion) {
        if (type == INVALID) {
            type = getNewObjectIndexType();
        }
        if (type < 1 || type > MAX_TYPE_VALUE) {
            throw new IllegalArgumentException("Wrong type "
                + Integer.toHexString(type).toUpperCase() + ".");
        }

        try {
            // Check if the type has been already registereds
            get(type);
            throw new IllegalArgumentException("type "
                + Integer.toHexString(type).toUpperCase() + ", name " + name
                + ", already registered as " + getTypeName(type) + ".");
        } catch (IllegalArgumentException e) {
            // OK, the type is still not registered.
        }

        DataType dataType =
            new DefaultDataType(type, subtype, name, defaultClass, coercion);
        types[type] = dataType;
        LOG.debug("Registered data type {}.", dataType.toString());
        return type;
    }

    private int getNewObjectIndexType() {
        for (int i = NEWINDEXES_AT; i <= MAX_TYPE_VALUE; i++) {
            if (types[i] == null) {
                return i;
            }
        }
        return DataTypes.INVALID;
    }

    public DataType get(int type) {
        DataType dataType = null;
        if (type > 0 && type <= MAX_TYPE_VALUE) {
            dataType = types[type];
        }

        if (dataType == null) {
            throw new IllegalArgumentException("DataType " + type
                + " not registered");
        }

        return dataType;
    }

    public boolean isValidType(int type) {
        return type > 0 && type <= MAX_TYPE_VALUE && this.types[type] != null;
    }

    public boolean isObject(int type) {
        return (type & DataTypes.OBJECT) == DataTypes.OBJECT;
    }

    public boolean isContainer(int type) {
        return (type & DataTypes.CONTAINER) == DataTypes.CONTAINER;
    }

    public int getType(String name) {
        if (name != null) {
            for (int i = 0; i < types.length; i++) {
                if (types[i] != null
                    && name.equalsIgnoreCase(types[i].getName())) {
                    return i;
                }
            }
        }
        return DataTypes.INVALID;
    }

    public String getTypeName(int type) {
        DataType dataType = get(type);
        String name = dataType.getName();
        if (name == null) {
            return "unknow";
        }
        return name;
    }

    public Class getDefaultClass(int type) {
        DataType dataType = get(type);
        return dataType.getDefaultClass();
    }

    public String getSubtype(int type) {
        DataType dataType = get(type);
        return dataType.getSubtype();
    }

    public Coercion getCoercion(int type) {
        DataType dataType = get(type);
        return dataType.getCoercion();
    }

    public void setCoercion(int type, Coercion coercion) {
        DataType dataType = get(type);
        dataType.setCoercion(coercion);
    }

    public void addCoercion(int type, Coercion coercion) {
        DataType dataType = get(type);
        dataType.addCoercion(coercion);
    }

    public Object coerce(int type, Object value) throws CoercionException {
        DataType dataType = get(type);
        return dataType.coerce(value);
    }

    public Iterator iterator() {
        List list = new ArrayList();
        DataType type = null;
        for (int i = 0; i < this.types.length; i++) {
            type = this.types[i];
            if (type != null)
                list.add(this.types[i]);
        }
        return list.iterator();
    }

    public DataType getDataType(Class defaultClass) {
        // First look for a class with exact match
        for (int i = 0; i < types.length; i++) {
            if (types[i] != null) {
                Class typeClass = types[i].getDefaultClass();
                if (typeClass != null && typeClass.equals(defaultClass)) {
                    return types[i];
                }
            }
        }
        // Then look for a class which is an interface or parent
        for (int i = 0; i < types.length; i++) {
            if (types[i] != null) {
                Class typeClass = types[i].getDefaultClass();
                if (typeClass != null
                    && typeClass.isAssignableFrom(defaultClass)) {
                    return types[i];
                }
            }
        }
        throw new IllegalArgumentException(
            "There is not any registered data type with the class or a "
                + "parent of the class: " + defaultClass);
    }
}

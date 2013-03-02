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
package org.gvsig.tools.dynobject.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dataTypes.DataTypesManager;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynClassName;
import org.gvsig.tools.dynobject.DynField;
import org.gvsig.tools.dynobject.DynMethod;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectException;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynObjectValueItem;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.exception.DynClassNotFoundException;
import org.gvsig.tools.dynobject.exception.DynFieldNotFoundException;
import org.gvsig.tools.dynobject.exception.DynFieldValidateException;
import org.gvsig.tools.dynobject.exception.DynMethodException;
import org.gvsig.tools.dynobject.exception.DynObjectValidateException;
import org.gvsig.tools.exception.ListBaseException;

public class DefaultDynClass implements DynClass {

    public class FieldAndIndex {

        DefaultDynField field;
        int index;

        FieldAndIndex(DynField field, int index) {
            this.field = (DefaultDynField) field;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public DefaultDynField getDynField() {
            return this.field;
        }
    }

    public class MethodAndIndex {

        DynMethod method;
        int index;

        MethodAndIndex(DynMethod method, int index) {
            this.method = method;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public DynMethod getDynMethod() {
            return this.method;
        }
    }

    DynObjectManager manager;

    private DynClassName name;
    private String description;

    private boolean isAnonymous;

    private Map classes;
    private Map declaredFieldsMap;
    private Map declaredMethodsMap;

    // This attributes are calculated by consolide method
    private DefaultDynClass[] superClasses;
    private Map superClassesMap;
    private DynField[] declaredFields;
    private Map fieldsMap;
    private DynField[] fields;
    private DynMethod[] declaredMethods;
    private Map methodsMap;
    private DynMethod[] methods;

    public DefaultDynClass(DynObjectManager manager, String name,
        String description) {
        this(manager, null, name, description);
    }

    public DefaultDynClass(DynObjectManager manager, String namespace,
        String name, String description) {
        this(manager, manager.createDynClassName(namespace, name), description);
    }

    public DefaultDynClass(DynObjectManager manager, DynClassName name,
        String description) {
        this.isAnonymous = false;
        this.classes = new LinkedHashMap();
        this.declaredFieldsMap = new HashMap();
        this.declaredMethodsMap = new HashMap();

        this.forceConsolide();

        this.manager = manager;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name.getName();
    }

    public String getNamespace() {
        return this.name.getNamespace();
    }

    public String getFullName() {
        return this.name.getFullName();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("DynClass").append("[").append(this.hashCode())
            .append("]").append("( ").append("name='")
            .append(this.getFullName()).append("', ").append("fields='")
            .append(this.declaredFieldsMap.toString()).append(" )");
        return buffer.toString();
    }

    public DefaultDynClass(DynObjectManager manager, String name,
        String description, DynClass[] superClases) {
        this(manager, name, description);
        for (int i = 0; i < superClases.length; i++) {
            DynClass dynClass = superClases[i];
            if (!this.classes.containsKey(dynClass.getFullName())) {
                this.classes.put(dynClass.getFullName(), dynClass);
            }
        }
    }

    public DynObjectManager getManager() {
        return this.manager;
    }

    public void consolide() {
        // Use classes and decalredFieldsMap to update all.

        // Updates superClasses array
        this.superClasses =
            (DefaultDynClass[]) buildSuperDynClassSet().toArray(
                new DefaultDynClass[] {});

        // Updates declaredFields array
        this.declaredFields =
            (DynField[]) this.declaredFieldsMap.values().toArray(
                new DynField[] {});

        // Updates declaredMethods array
        this.declaredMethods =
            (DynMethod[]) this.declaredMethodsMap.values().toArray(
                new DynMethod[] {});

        // Updates fieldsMap
        this.fieldsMap = new LinkedHashMap();
        int index = 0;
        for (int i = 0; i < this.declaredFields.length; i++) {
            this.fieldsMap.put(this.declaredFields[i].getName().toLowerCase(),
                new FieldAndIndex(this.declaredFields[i], index++));
        }
        for (int i = 0; i < this.superClasses.length; i++) {
            Iterator it =
                this.superClasses[i].declaredFieldsMap.values().iterator();
            while (it.hasNext()) {
                DynField field = (DynField) it.next();
                if (!this.fieldsMap.containsKey(field.getName().toLowerCase())) {
                    this.fieldsMap.put(field.getName().toLowerCase(),
                        new FieldAndIndex(field, index++));
                }
            }
        }

        // Updates methodsMap
        this.methodsMap = new LinkedHashMap();
        index = 0;
        for (int i = 0; i < this.declaredMethods.length; i++) {
            this.methodsMap.put(this.declaredMethods[i].getName(),
                new MethodAndIndex(this.declaredMethods[i], index++));
        }
        for (int i = 0; i < this.superClasses.length; i++) {
            Iterator it =
                this.superClasses[i].declaredMethodsMap.values().iterator();
            while (it.hasNext()) {
                DynMethod method = (DynMethod) it.next();
                if (!this.methodsMap.containsKey(method.getName())) {
                    this.methodsMap.put(method.getName(), new MethodAndIndex(
                        method, index++));
                }
            }
        }

        // Updates fields array
        this.fields = new DynField[this.fieldsMap.size()];
        int i = 0;
        Iterator it = this.fieldsMap.values().iterator();
        while (it.hasNext()) {
            FieldAndIndex findex = (FieldAndIndex) it.next();
            DynField field = findex.getDynField();
            fields[i++] = field;
        }

        // Updates methods array
        this.methods = new DynMethod[this.methodsMap.size()];
        i = 0;
        it = this.methodsMap.values().iterator();
        while (it.hasNext()) {
            MethodAndIndex mindex = (MethodAndIndex) it.next();
            DynMethod method = mindex.getDynMethod();
            methods[i++] = method;
        }

        // Updates superClassesMap
        this.superClassesMap = new HashMap();
        for (i = 0; i < this.superClasses.length; i++) {
            this.superClassesMap.put(this.superClasses[i].getFullName(),
                this.superClasses[i]);
        }
    }

    private void forceConsolide() {
        this.superClasses = null;
        this.superClassesMap = null;
        this.declaredFields = null;
        this.fieldsMap = null;
        this.fields = null;
        this.declaredMethods = null;
        this.methodsMap = null;
        this.methods = null;
    }

    private Set buildSuperDynClassSet() {
        Set dynClassParents = new LinkedHashSet();
        buildSuperDynClassList(this, dynClassParents);
        return dynClassParents;
    }

    private void buildSuperDynClassList(DefaultDynClass dynClass, Set allParents) {
        Collection values = dynClass.classes.values();
        Iterator it = values.iterator();
        while (it.hasNext()) {
            DynClass dc = (DynClass) it.next();
            allParents.add(dc);
        }
        it = values.iterator();
        while (it.hasNext()) {
            DefaultDynClass dc = (DefaultDynClass) it.next();
            buildSuperDynClassList(dc, allParents);
        }
    }

    // public Object[] createValues(Object[] oldvalues) {
    // if (this.fields == null) {
    // consolide();
    // }
    // if (oldvalues != null && oldvalues.length >= this.fields.length) {
    // return oldvalues;
    // }
    // Object[] extended = new Object[this.fields.length];
    // if (oldvalues != null) {
    // System.arraycopy(oldvalues, 0, extended, 0, oldvalues.length);
    // }
    // return extended;
    // }

    public Map createValues(Map oldValues) {
        if (this.fields == null) {
            consolide();
        }
        HashMap extended = new HashMap();
        if (oldValues != null) {
            extended.putAll(oldValues);
        }
        return extended;
    }

    public void extendAll(String[] structNames) {
        if (structNames == null)
            return;

        for (int i = 0; i < structNames.length; i++) {
            DynStruct dynStruct = manager.get(structNames[i]);
            if (dynStruct == null) {
                throw new DynClassNotFoundException(structNames[i]);
            }
            if (this.classes.containsKey(dynStruct.getFullName())) {
                continue;
            }
            this.classes.put(dynStruct.getFullName(), dynStruct);
        }

        this.forceConsolide();
    }

    public void extend(DynStruct dynStruct) {
        if (this.classes.containsKey(dynStruct.getFullName())) {
            return;
        }
        this.classes.put(dynStruct.getFullName(), dynStruct);
        this.forceConsolide();
    }

    public void extend(String structName) {
        DynClass dynClass = manager.get(structName);
        if (dynClass == null) {
            throw new DynClassNotFoundException(structName);
        }
        extend(dynClass);
    }

    public void extend(String namespace, String structame) {
        DynClass dynClass = manager.get(namespace, structame);
        if (dynClass == null) {
            throw new DynClassNotFoundException(new DefaultDynClassName(
                structame).getFullName());
        }
        extend(dynClass);
    }

    public int getFieldIndex(String name) {
        if (this.fieldsMap == null) {
            consolide();
        }
        FieldAndIndex f =
            (FieldAndIndex) this.fieldsMap.get(name.toLowerCase());
        if (f == null) {
            return -1;
        }
        return f.index;
    }

    public DynField getDeclaredDynField(String name) {
        return (DynField) this.declaredFieldsMap.get(name.toLowerCase());
    }

    public DynField[] getDeclaredDynFields() {
        return this.declaredFields;
    }

    public String getDescription() {
        return this.description;
    }

    public DynField getDynField(String name) {
        if (this.fieldsMap == null) {
            consolide();
        }
        FieldAndIndex findex =
            (FieldAndIndex) fieldsMap.get(name.toLowerCase());
        return findex == null ? null : findex.getDynField();
    }

    public FieldAndIndex getDynFieldAndIndex(String name) {
        if (this.fieldsMap == null) {
            consolide();
        }
        return (FieldAndIndex) this.fieldsMap.get(name.toLowerCase());
    }

    public DynField[] getDynFields() {
        if (this.fields == null) {
            consolide();
        }
        return this.fields;
    }

    public DynField addDynField(String name) {
        DynField field = new DefaultDynField(name);
        return this.addDynField(field);
    }

    public DynField addDynField(DynField field) {
        declaredFieldsMap.put(field.getName().toLowerCase(), field);
        this.forceConsolide();
        return field;
    }

    public DynClass[] getSuperDynClasses() {
        if (this.superClasses == null) {
            consolide();
        }
        return this.superClasses;
    }

    public DynStruct[] getSuperDynStructs() {
        return this.getSuperDynClasses();
    }

    public DynObject newInstance() {
        return this.manager.createDynObject(this);
    }

    public boolean isInstance(DynObject dynObject) {
        if (this.superClassesMap == null) {
            consolide();
        }
        DefaultDynClass objClass = (DefaultDynClass) dynObject.getDynClass();
        if (this.superClassesMap.containsKey(objClass.getFullName())) {
            return true;
        }
		if (this.getFullName().equals(objClass.getFullName())) {
			return true;
		}
        if (objClass.isAnonymous) {
            Iterator it = objClass.classes.values().iterator();
            while (it.hasNext()) {
                DynClass dc = (DynClass) it.next();
                if (this.superClassesMap.containsKey(dc.getFullName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeDynField(String name) {
        this.declaredFieldsMap.remove(name.toLowerCase());
        this.forceConsolide();
    }

    public void setAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DynClass) {
            return this.getFullName().equals(((DynClass) obj).getFullName());
        }
        return false;
    }

    public void addDynMethod(DynMethod dynMethod) {
        this.manager.registerDynMethod(this, dynMethod);
    }

    void addMethod(DynMethod dynMethod) {
        declaredMethodsMap.put(dynMethod.getName(), dynMethod);
        this.forceConsolide();
    }

    public DynMethod getDeclaredDynMethod(String name) {
        return (DynMethod) this.declaredMethodsMap.get(name);
    }

    public DynMethod[] getDeclaredDynMethods() {
        if (this.declaredMethods == null) {
            consolide();
        }
        return this.declaredMethods;
    }

    public DynMethod getDynMethod(String name) throws DynMethodException {
        if (this.methodsMap == null) {
            consolide();
        }
        MethodAndIndex mindex = (MethodAndIndex) methodsMap.get(name);
        return mindex == null ? null : mindex.getDynMethod();
    }

    public DynMethod getDynMethod(int code) throws DynMethodException {
        return this.manager.getDynMethod(code);
    }

    public DynMethod[] getDynMethods() {
        if (this.methods == null) {
            consolide();
        }
        return this.methods;
    }

    public void removeDynMethod(String name) {
        // TODO Auto-generated method stub
    }

    public void validate(DynObject object) throws DynObjectValidateException {
        DynField fields[] = this.getDynFields();
        DynObjectValidateException exceptions =
            new DynObjectValidateException(this.getFullName());
        for (int i = 0; i < fields.length; i++) {
            DynField field = fields[i];
            try {
                field.validate(object.getDynValue(field.getName()));
            } catch (DynFieldValidateException e) {
                exceptions.add(e);
            } catch (DynFieldNotFoundException e) {
                exceptions.add(e);
            }
        }
        if (exceptions.size() > 0) {
            throw exceptions;
        }
    }

    public DynField addDynFieldString(String name) {
        return addDynField(name).setType(DataTypes.STRING);
    }

    public DynField addDynFieldDate(String name) {
        return addDynField(name).setType(DataTypes.DATE);
    }

    public DynField addDynFieldInt(String name) {
        return addDynField(name).setType(DataTypes.INT);
    }

    public DynField addDynFieldLong(String name) {
        return addDynField(name).setType(DataTypes.LONG);
    }

    public DynField addDynFieldDouble(String name) {
        return addDynField(name).setType(DataTypes.DOUBLE);
    }

    public DynField addDynFieldFloat(String name) {
        return addDynField(name).setType(DataTypes.FLOAT);
    }

    public DynField addDynFieldBoolean(String name) {
        return addDynField(name).setType(DataTypes.BOOLEAN);
    }

    public DynField addDynFieldFolder(String name) {
        DataTypesManager datamanager = ToolsLocator.getDataTypesManager();
        return addDynField(name).setType(datamanager.get(DataTypes.FOLDER));
    }

    public DynField addDynFieldFile(String name) {
        DataTypesManager datamanager = ToolsLocator.getDataTypesManager();
        return addDynField(name).setType(datamanager.get(DataTypes.FILE));
    }

    public DynField addDynFieldURL(String name) {
        DataTypesManager datamanager = ToolsLocator.getDataTypesManager();
        return addDynField(name).setType(datamanager.get(DataTypes.URL));
    }

    public DynField addDynFieldURI(String name) {
        DataTypesManager datamanager = ToolsLocator.getDataTypesManager();
        return addDynField(name).setType(datamanager.get(DataTypes.URI));
    }

    public DynField addDynFieldObject(String name) {
        return addDynField(name).setType(DataTypes.OBJECT);
    }
    
    public DynField addDynFieldObject(String name, String dynObjectFullName) {
        return addDynField(name).setType(DataTypes.DYNOBJECT).setSubtype(dynObjectFullName);
    }

    public DynField addDynFieldObjectList(String name, String fullDynObjectName) {
        DynField listDynField = this.addDynFieldList(name)
            .setElementsType(DataTypes.DYNOBJECT)
            .setSubtype(fullDynObjectName);
        return listDynField;
    }

    public DynField addDynFieldArray(String name) {
        return addDynField(name).setType(DataTypes.ARRAY);
    }

    public DynField addDynFieldList(String name) {
        return addDynField(name).setType(DataTypes.LIST);
    }

    public DynField addDynFieldMap(String name) {
        return addDynField(name).setType(DataTypes.MAP);
    }

    public DynField addDynFieldSet(String name) {
        return addDynField(name).setType(DataTypes.SET);
    }

    public DynField addDynFieldChoice(String name, int type,
        Object defaultValue, DynObjectValueItem[] values) {
        return addDynFieldChoice(name, type, defaultValue, values, false, true);
    }

    public DynField addDynFieldChoice(String name, int type,
        Object defaultValue, DynObjectValueItem[] values, boolean mandatory,
        boolean persistent) {
        return addDynField(name).setType(type)
            .setDefaultFieldValue(defaultValue).setMandatory(mandatory)
            .setPersistent(persistent).setAvailableValues(values)
            .setDescription(description);
    }

    public DynField addDynFieldRange(String name, int type,
        Object defaultValue, Object min, Object max) {
        return addDynFieldRange(name, type, defaultValue, min, max, false, true);
    }

    public DynField addDynFieldRange(String name, int type,
        Object defaultValue, Object min, Object max, boolean mandatory,
        boolean persistent) {
        return addDynField(name).setType(type)
            .setDefaultFieldValue(defaultValue).setMandatory(mandatory)
            .setPersistent(persistent).setMinValue(min).setMaxValue(max);
    }

    public DynField addDynFieldSingle(String name, int type, Object defaultValue) {
        return addDynFieldSingle(name, type, defaultValue, false, true);
    }

    public DynField addDynFieldSingle(String name, int type,
        Object defaultValue, boolean mandatory, boolean persistent) {
        return addDynField(name).setType(type)
            .setDefaultFieldValue(defaultValue).setMandatory(mandatory)
            .setPersistent(persistent);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNamespace(String namespace) {
        this.name.setNamespace(namespace);
    }

    public void check() throws ListBaseException {
        ListBaseException exceptions = null;

        if (name == null) {
            exceptions =
                CheckDynClassListException.add(exceptions, name, "name", name);
        }
        DynField[] fields = this.getDynFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                DefaultDynField field = (DefaultDynField) fields[i];
                field.check();
            } catch (Exception ex) {
                exceptions =
                    CheckDynClassListException.add(exceptions, name, ex);
            }
        }
        if (exceptions != null) {
            throw exceptions;
        }
    }

    public static class CheckDynClassListException extends ListBaseException {

        /**
		 * 
		 */
        private static final long serialVersionUID = 9042601577056507657L;

        public static class CheckDynClassException extends DynObjectException {

            /**
			 * 
			 */
            private static final long serialVersionUID = -1447120375445458639L;

            public CheckDynClassException(String attrname, Object attrvalue) {
                super("Wrong value %(value) for attribute %(name).",
                    "Wrong_value_XvalueX_for_attribute_XnameX",
                    serialVersionUID);
            }
        }

        public CheckDynClassListException(DynClassName name) {
            super("Inconsistent DynClass %(name) definition.",
                "_Inconsistent_DynClass_XnameX_definition", serialVersionUID);
            String s;
            if (name == null) {
                s = "[unknow]";
            } else {
                s = name.getFullName();
            }
            setValue("name", s);
        }

        public static ListBaseException add(ListBaseException exceptions,
            DynClassName name, String attrname, Object attrvalue) {
            if (exceptions == null) {
                exceptions = new CheckDynClassListException(name);
            }
            exceptions.add(new CheckDynClassException(attrname, attrvalue));
            return exceptions;
        }

        public static ListBaseException add(ListBaseException exceptions,
            DynClassName name, Exception ex) {
            if (exceptions == null) {
                exceptions = new CheckDynClassListException(name);
            }
            exceptions.add(ex);
            return exceptions;
        }
    }

    private boolean isExtendable(Set superClassesSet, DynStruct dynStruct) {

        if ((superClassesSet == null) || (superClassesSet.isEmpty())) {
            return true;
        }

        if (superClassesSet.contains(dynStruct)) {
            return false;
        }

        return true;
    }

    public boolean isExtendable(DynStruct dynStruct) {

        if (dynStruct == null) {
            return false;
        }

        if (this.fieldsMap == null) {
            consolide();
        }
        Set superClassesSet = buildSuperDynClassSet();
        return isExtendable(superClassesSet, dynStruct);
    }

    private void removeDynStruct(DynStruct superDynStruct) {
        if (this.classes.containsKey(superDynStruct.getFullName())) {
            this.classes.remove(superDynStruct.getFullName());
        }
    }

    public void remove(DynStruct superDynStruct) {
        if (superDynStruct != null) {
            this.removeDynStruct(superDynStruct);
            this.forceConsolide();
        }
    }

    public void removeAll(DynStruct[] superDynStruct) {
        if (superDynStruct != null) {
            for (int i = 0; i < superDynStruct.length; i++) {
                removeDynStruct(superDynStruct[i]);
            }
            this.consolide();
        }
    }

    public void extend(DynStruct[] structs) {
        if (structs != null) {
            for (int i = 0; i < structs.length; i++) {
                extend(structs[i]);
            }
            this.consolide();
        }
    }
}

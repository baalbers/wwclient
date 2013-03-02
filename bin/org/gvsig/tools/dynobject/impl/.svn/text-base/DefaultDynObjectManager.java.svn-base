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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import org.gvsig.tools.ToolsLocator;
import org.gvsig.tools.dynobject.DynClass;
import org.gvsig.tools.dynobject.DynClassName;
import org.gvsig.tools.dynobject.DynMethod;
import org.gvsig.tools.dynobject.DynObject;
import org.gvsig.tools.dynobject.DynObjectManager;
import org.gvsig.tools.dynobject.DynObjectPagingHelper;
import org.gvsig.tools.dynobject.DynObjectRuntimeException;
import org.gvsig.tools.dynobject.DynObjectSet;
import org.gvsig.tools.dynobject.DynStruct;
import org.gvsig.tools.dynobject.exception.DuplicateDynClassException;
import org.gvsig.tools.dynobject.exception.DynMethodException;
import org.gvsig.tools.dynobject.exception.DynMethodIllegalCodeException;
import org.gvsig.tools.dynobject.exception.DynMethodNotSupportedException;
import org.gvsig.tools.dynobject.exception.IllegalDynMethodException;
import org.gvsig.tools.dynobject.exception.IllegalDynMethodInvocationException;
import org.gvsig.tools.exception.BaseException;

/**
 * Default {@link DynObjectManager} implementation.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public class DefaultDynObjectManager implements DynObjectManager {

    private final static Logger LOG = LoggerFactory
        .getLogger(DefaultDynObjectManager.class);

    private static DefaultDynObjectManager manager = null;

    private class MethodInfo {

        int code;
        DynClass dynClass;
        DynMethod dynMethod;
        Class theClass;

        MethodInfo(Class theClass, DynClass dynClass, DynMethod dynMethod,
            int code) {
            this.code = code;
            this.dynClass = dynClass;
            this.dynMethod = dynMethod;
            this.theClass = theClass;
        }

        String getKey() {
            return DefaultDynObjectManager
                .getKey(theClass, dynClass, dynMethod);
        }

        void check(Class theClass, int code) throws DynMethodException {
            if (code != this.code) {
                throw new DynMethodIllegalCodeException(dynMethod.getName(),
                    this.code, code);
            }
            if (theClass != null) {
                if (this.theClass == null) {
                    throw new IllegalDynMethodInvocationException(
                        dynMethod.getName(), theClass);
                }
                if (!this.theClass.isAssignableFrom(theClass)) {
                    throw new IllegalDynMethodInvocationException(
                        dynMethod.getName(), theClass);
                }
            }
        }

        void check(DynClass dynClass, int code) throws DynMethodException {
            if (code != this.code) {
                throw new DynMethodIllegalCodeException(dynMethod.getName(),
                    this.code, code);
            }
            if (dynClass != null) {
                if (this.dynClass == null) {
                    throw new IllegalDynMethodInvocationException(
                        dynMethod.getName(), dynClass);
                }
                if (dynClass != this.dynClass
                    || !dynClass.getName().equalsIgnoreCase(
                        this.dynClass.getName())) {
                    throw new IllegalDynMethodInvocationException(
                        dynMethod.getName(), dynClass);
                }
            }
        }
    }

    private class ClassesNamespaces {

        private Map defaultNamespace;
        private Map namespaces;

        ClassesNamespaces() {
            this.namespaces = new HashMap();
            this.defaultNamespace = new HashMap();
        }

        public Map addNamespace(String name) {
            Map namespace = new HashMap();
            this.namespaces.put(name.toLowerCase(), namespace);
            return namespace;
        }

        public Map getNamespace(String name) {
            return (Map) this.namespaces.get(name.toLowerCase());
        }

//        public void clear() {
//            this.defaultNamespace.clear();
//            this.namespaces.clear();
//        }

        public boolean containsClass(String name) {
            name = name.toLowerCase();
            if (this.defaultNamespace.containsKey(name)) {
                return true;
            }

            Iterator it = this.namespaces.values().iterator();
            while (it.hasNext()) {
                Map names = (Map) it.next();
                if (names.containsKey(name)) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsClass(String namespace, String name) {
            name = name.toLowerCase();
            if (namespace == null) {
                return this.defaultNamespace.containsKey(name);
            }
            Map space = this.getNamespace(namespace);
            if (space == null) {
                return false;
            }
            return space.containsKey(name);
        }

//        public boolean containsClass(DynClass dynClass) {
//            if (this.defaultNamespace.containsValue(dynClass)) {
//                return true;
//            }
//
//            Iterator it = this.namespaces.values().iterator();
//            while (it.hasNext()) {
//                Map names = (Map) it.next();
//                if (names.containsValue(dynClass)) {
//                    return true;
//                }
//            }
//            return false;
//        }

        public DynClass get(String name, String namespace) {
            if (namespace == null) {
                return (DynClass) this.defaultNamespace.get(name.toLowerCase());
            }
            Map space = this.getNamespace(namespace);
            if (space == null) {
                return null;
            }
            DynClassName className = new DefaultDynClassName(name);
            if (className.getNamespace()==null){
                return (DynClass) space.get(name.toLowerCase());
            }
            if (!namespace.equalsIgnoreCase(className.getNamespace())){
            	return null;
            }
            return (DynClass) space.get(className.getName().toLowerCase());
        }

        public Set keySet() {
            Set keyset = new HashSet();
            Iterator it = this.iterator();
            while (it.hasNext()) {
                DynClass dynClass = (DynClass) it.next();
                keyset.add(dynClass.getFullName());
            }
            return keyset;
        }

        public Iterator iterator() {
            final class MyIterator implements Iterator {

                Iterator current;
                Iterator others;

                MyIterator(Iterator main, Iterator others) {
                    this.current = main;
                    this.others = others;
                }

                public boolean hasNext() {
                    if (this.current.hasNext()) {
                        return true;
                    }
                    while (this.others.hasNext()) { 
                        Object obj = others.next();
                        this.current = (Iterator) ((HashMap) obj).values().iterator();
                        if (this.current.hasNext()) {
                            return true;
                        }
                    }
                    return false;
                }

                public Object next() {
                    if (this.current.hasNext()) {
                        return this.current.next();
                    }
                    while (this.others.hasNext()) {
                        Object obj = others.next();
                        this.current = (Iterator) ((HashMap) obj).values().iterator();
                        if (this.current.hasNext()) {
                            return this.current.next();
                        }
                    }
                    return null;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            return new MyIterator(this.defaultNamespace.values().iterator(),
                this.namespaces.values().iterator());
        }

        public Object add(DynStruct dynClass) {
            String name = dynClass.getName().toLowerCase();
            Map namespace;
            if (dynClass.getNamespace() != null) {
                namespace = (Map) this.getNamespace(dynClass.getNamespace());
                if (namespace == null) {
                    namespace = this.addNamespace(dynClass.getNamespace());
                }
            } else {
                namespace = this.defaultNamespace;
            }
            if (namespace.containsKey(name)) {
                throw new DuplicateDynClassException(dynClass);
            }
            return namespace.put(name, dynClass);
        }

        public void remove(DynStruct dynClass) {
            String name = dynClass.getName().toLowerCase();
            Map namespace;
            if (dynClass.getNamespace() != null) {
                namespace = (Map) this.getNamespace(dynClass.getNamespace());
                if (namespace == null) {
                    namespace = this.addNamespace(dynClass.getNamespace());
                }
            } else {
                namespace = this.defaultNamespace;
            }
            if (namespace.containsKey(name)) {
                namespace.remove(name);
            }
        }

        public int size() {
            int count = this.defaultNamespace.size();

            Iterator it = this.namespaces.values().iterator();
            while (it.hasNext()) {
                Map names = (Map) it.next();
                count += names.size();
            }
            return count;
        }

    }

    private Map anonymousClasses;
    private ClassesNamespaces classes;
    private Map methodsMap;
    private MethodInfo[] methods;

    public static DefaultDynObjectManager getManager() {
        if (manager == null) {
            manager = new DefaultDynObjectManager();
        }
        return manager;
    }

    static String getKey(Class theClass, DynClass dynClass, DynMethod dynMethod) {
        return DefaultDynObjectManager.getKey(theClass, dynClass,
            dynMethod.getName());
    }

    static String getKey(Class theClass, DynClass dynClass, String methodName) {
        if (dynClass == null) {
            return theClass.getName() + ":" + methodName;
        } else {
            return dynClass.getName() + ":" + methodName;
        }
    }

    public DefaultDynObjectManager() {
        this.classes = new ClassesNamespaces();
        this.anonymousClasses = new HashMap();
        this.methodsMap = new HashMap();
        this.methods = null;
    }

    public DynClass createDynClass(String name, String description) {
        return new DefaultDynClass(this, name, description);
    }

    public DynClass createDynClass(String namespace, String name,
        String description) {
        return new DefaultDynClass(this, namespace, name, description);
    }

    public void add(DynClass dynClass) {
        try {
            ((DefaultDynClass) dynClass).check();
        } catch (Exception ex) {
            throw new DynObjectRuntimeException(ex);
        }
        this.classes.add(dynClass);
        LOG.trace("Add DynClass definition {}.",
            new Object[] { dynClass.getFullName() });

    }

    public DynClass add(String name, String description) {
        DynClass dynClass =
            (DynClass) this.classes.get(name.toLowerCase(), null);
        if (dynClass == null) {
            dynClass = this.createDynClass(name, description);
            this.add(dynClass);
        }
        return dynClass;
    }

    public DynClass add(String name) {
        return this.add(name, null);
    }

    public void remove(DynStruct dynClass) {
        this.classes.remove(dynClass);
    }

    // public static String getFullName(String namespace, String name) {
    // if( namespace == null ) {
    // return name;
    // }
    // return namespace + ":" + name;
    // }
    // public static String[] splitFullName(String fullname) {
    // String[] name = new String[] { null, fullname };
    // int x=fullname.indexOf(':');
    // if( x>-1 ) {
    // name[0] = fullname.substring(0, x);
    // name[1] = fullname.substring(x+1);
    // }
    // return name;
    //
    // }

    public DynClass get(String theName) {
        DynClassName name = createDynClassName(theName);
        return this.get(name.getNamespace(), name.getName());
    }

    public DynClass get(String namespace, String name) {
        return (DynClass) this.classes.get(name, namespace);
    }

    public DynClass get(DynClass[] superClasses) {
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < superClasses.length; i++) {
            name.append(superClasses[i].getName()).append("+");
        }
        DefaultDynClass dynClass =
            (DefaultDynClass) this.anonymousClasses.get(name.toString());
        if (dynClass == null) {
            dynClass =
                new DefaultDynClass(this, name.toString(), null, superClasses);
            dynClass.setAnonymous(true);
        }
        return dynClass;
    }

    public int getCount() {
        return this.classes.size();
    }

    public List getNames() {
        String[] names = (String[]) this.classes.keySet().toArray();
        Arrays.sort(names);
        return Collections.unmodifiableList(Arrays.asList(names));
    }

    public boolean has(String name) {
        return this.classes.containsClass(name);
    }

    public boolean has(String namespace, String name) {
        return this.classes.containsClass(namespace, name);
    }

    public Iterator iterator() {
        return this.classes.iterator();
    }

    public DynObject createDynObject(String dynClassName) {
        DynClassName name = createDynClassName(dynClassName);
        return this.createDynObject(name.getName(), name.getNamespace());
    }

    public DynObject createDynObject(String dynClassName, String namespace) {

        DynClass dynClass =
            (DynClass) this.classes.get(dynClassName, namespace);
        if (dynClass == null) {
            throw new IllegalArgumentException("Can't locate class '"
                + createDynClassName(namespace, dynClassName).getFullName()
                + "'.");
        }
        return this.createDynObject(dynClass);
    }

    public DynObject createDynObject(DynStruct dynClass) {
        return new DefaultDynObject(dynClass);
    }

    public void consolide() {
        Iterator it = this.classes.iterator();
        while (it.hasNext()) {
            DefaultDynClass dc = (DefaultDynClass) it.next();
            dc.consolide();
        }
        it = this.anonymousClasses.values().iterator();
        while (it.hasNext()) {
            DefaultDynClass dc = (DefaultDynClass) it.next();
            dc.consolide();
        }
    }

    public int registerDynMethod(DynClass dynClass, DynMethod dynMethod) {
        ((DefaultDynClass) dynClass).addMethod(dynMethod);
        return registerDynMethod(null, dynClass, dynMethod);
    }

    public int registerDynMethod(Class theClass, DynMethod dynMethod) {
        return registerDynMethod(theClass, null, dynMethod);
    }

    int registerDynMethod(Class theClass, DynClass dynClass, DynMethod dynMethod) {
        MethodInfo info = new MethodInfo(theClass, dynClass, dynMethod, 0);
        MethodInfo oldInfo = (MethodInfo) methodsMap.get(info.getKey());
        if (oldInfo != null) {
            // Update the method info
            oldInfo.dynClass = dynClass;
            oldInfo.dynMethod = dynMethod;
            return oldInfo.code;
        }
        if (methods == null) {
            methods = new MethodInfo[1];
            info.code = 0;
        } else {
            MethodInfo[] temp1 = new MethodInfo[methods.length + 1];
            System.arraycopy(methods, 0, temp1, 0, methods.length);
            info.code = temp1.length - 1;
            methods = temp1;
        }
        methods[info.code] = info;
        methodsMap.put(info.getKey(), info);

        return info.code;
    }

    public Object invokeDynMethod(Object self, int code, DynObject context)
        throws DynMethodException {

        try {
            /*
             * Intentamos ejecutar la operacion, y si peta ya haremos las
             * comprobaciones oportunas para lanzar la excepcion que toque.
             * 
             * Asi evitamos codigo de comprobacion para los casos que valla bien
             * que deberian ser la mayoria.
             */
            return methods[code].dynMethod.invoke(self, context);
        } catch (RuntimeException e) {
            getDynMethod(self, code);
            throw e;
        } catch (DynMethodException e) {
            getDynMethod(self, code);
            throw e;
        }

    }

    public int getDynMethodCode(DynClass dynClass, String methodName)
        throws DynMethodException {
        String key = DefaultDynObjectManager.getKey(null, dynClass, methodName);
        MethodInfo info = (MethodInfo) methodsMap.get(key);
        if (info == null) {
            throw new IllegalDynMethodException(methodName, dynClass);
        }
        info.check(dynClass, info.code);
        return info.code;
    }

    public int getDynMethodCode(Class theClass, String methodName)
        throws DynMethodException {
        String key = DefaultDynObjectManager.getKey(theClass, null, methodName);
        MethodInfo info = (MethodInfo) methodsMap.get(key);
        if (info == null) {
            throw new IllegalDynMethodException(methodName, theClass);
        }
        info.check(theClass, info.code);
        return info.code;
    }

    public DynMethod getDynMethod(int code) throws DynMethodException {
        if (code >= methods.length) {
            throw new DynMethodNotSupportedException(code, "{null}");
        }
        MethodInfo info = methods[code];
        info.check((Class) null, code);
        return info.dynMethod;
    }

    public DynMethod getDynMethod(Object obj, int code)
        throws DynMethodException {
        return getDynMethod(obj.getClass(), code);
    }

    public DynMethod getDynMethod(Class theClass, int code)
        throws DynMethodException {
        if (code >= methods.length) {
            throw new DynMethodNotSupportedException(code, theClass.getName());
        }
        MethodInfo info = methods[code];
        info.check(theClass, code);
        return info.dynMethod;
    }

    public DynMethod getDynMethod(DynClass dynClass, int code)
        throws DynMethodException {
        if (code >= methods.length) {
            throw new DynMethodNotSupportedException(code, dynClass.getName());
        }
        MethodInfo info = methods[code];
        info.check(dynClass, code);
        return info.dynMethod;
    }

    public DynMethod getDynMethod(DynObject dynObject, int code)
        throws DynMethodException {
        return getDynMethod(dynObject.getDynClass(), code);
    }

    public void validate(DynObject object) {
        // TODO
        return;
    }

    public Class getDefaultClassOfType(int type) {
        return ToolsLocator.getDataTypesManager().getDefaultClass(type);
    }

    public Map importDynClassDefinitions(InputStream resource,
        ClassLoader loader) throws XmlPullParserException, IOException {
        return new DynClassImportHelper().importDefinitions(resource, loader,
            null);
    }

    public Map importDynClassDefinitions(XmlPullParser parser,
        ClassLoader loader, String defaultNamespace)
        throws XmlPullParserException, IOException {
        return new DynClassImportHelper().importDefinitions(parser, loader,
            defaultNamespace);
    }

    public Map importDynClassDefinitions(InputStream resource,
        ClassLoader loader, String defaultNamespace)
        throws XmlPullParserException, IOException {
        return new DynClassImportHelper().importDefinitions(resource, loader,
            defaultNamespace);
    }

    public DynObjectPagingHelper createDynObjectPagingHelper(DynObjectSet set)
        throws BaseException {
        return new DefaultDynObjectPagingHelper(set); 
    }

    public DynObjectPagingHelper createDynObjectPagingHelper(DynObjectSet set,
        int pageSize) throws BaseException {
        return new DefaultDynObjectPagingHelper(set, pageSize);
    }

    public DynClassName createDynClassName(String namespace, String name) {
        return new DefaultDynClassName(namespace, name);
    }

    public DynClassName createDynClassName(String name) {
        return new DefaultDynClassName(name);
    }

    public Iterator iterator(String nameSpace) {
        return iterator(nameSpace, false);
    }

    private Iterator iterator(String nameSpace, boolean exactMatchingRequired) {

        List list = new ArrayList();
        Iterator it = this.classes.iterator();

        if (nameSpace == null) {
            nameSpace = "";
        }

        while( it.hasNext() ) {
            
            Object obj = it.next();
            DynStruct dynStruct = (DynStruct) obj;
            String dynNameSpace = dynStruct.getNamespace();
            if ((dynNameSpace == null) || (dynNameSpace.equals(""))) {
                dynNameSpace = null;
            } else {
                dynNameSpace = dynNameSpace.toLowerCase();
            }
            nameSpace = nameSpace.toLowerCase();
            if (exactMatchingRequired) {
                if (nameSpace.equalsIgnoreCase(dynNameSpace)) {
                    list.add(dynStruct);
                }
            } else {
                if ((dynNameSpace != null)
                    && (nameSpace.indexOf(dynNameSpace) > -1)) {
                    list.add(dynStruct);
                }
            }
        }
        return list.iterator();
    }


}

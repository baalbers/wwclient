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
package org.gvsig.tools.dynobject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import org.gvsig.tools.dynobject.exception.DuplicateDynClassException;
import org.gvsig.tools.dynobject.exception.DynMethodException;
import org.gvsig.tools.dynobject.exception.DynObjectValidateException;
import org.gvsig.tools.exception.BaseException;

/**
 * Manager for the DynObject tools library. This is the main entry point to the
 * tools dynobjects API.
 * 
 * @author gvSIG Team
 * @version $Id$
 */
public interface DynObjectManager {

    /**
     * Null value for method id.
     * 
     * This value not is a value valid for a code of method.
     */
    public int NULLCODE = -1;

    /**
     * Create a instance of DynClass with the name and description
     * Indicated as parameters.
     * 
     * @param name
     *            , the name used for DynClass name.
     * @param description
     *            , the description associated to the
     *            new DynClass.
     * 
     * @return the DynClass created.
     */
    public DynClass createDynClass(String name, String description);

    /**
     * Create a instance of DynClass with the name and description
     * Indicated as parameters.
     * 
     * @param namespace
     *            , the namespace used for the new DynClass.
     * 
     * @param name
     *            , the name used for the new DynClass.
     * 
     * @param description
     *            , the description associated to the
     *            new DynClass.
     * 
     * @return the DynClass created.
     * 
     */
    public DynClass createDynClass(String namespace, String name,
        String description);

    /**
     * Load the classes defined in the resource and return a Map
     * with its.
     * The classes do not be registered in the manager.
     * 
     * @param resource
     *            , XML with the definition of dynamic
     *            classes.
     * 
     * @param loader
     *            , loader used to load classes used in
     *            "classOfValue" in the resource.
     * 
     * @param defaultNamespace
     *            , namespace used in classes that do not
     *            specify a namespace in the resource.
     * 
     * @return The Map of loaded dynamic classes
     * 
     * @throws XmlPullParserException
     * @throws IOException
     */
    public Map importDynClassDefinitions(InputStream resource,
        ClassLoader loader, String defaultNamespace)
        throws XmlPullParserException, IOException;

    /**
     * Load the classes defined in the resource.
     * When the class do not specify a namespace this is set
     * to null.
     * 
     * The classes do not be registered in the manager.
     * 
     * @param resource
     *            , XML with the definition of dynamic
     *            classes.
     * 
     * @param loader
     *            , loader used to load classes used in
     *            "classOfValue" in the resource.
     * 
     * @return The Map of loaded dynamic classes
     * 
     * @throws XmlPullParserException
     * @throws IOException
     */
    public Map importDynClassDefinitions(InputStream resource,
        ClassLoader loader) throws XmlPullParserException, IOException;

    /**
     * Load the classes defined in the resource.
     * When the class do not specify a namespace this is set
     * to null.
     * 
     * The classes do not be registered in the manager.
     * 
     * @param parser
     *            , XML parser used in the definition of dynamic
     *            classes.
     * 
     * @param loader
     *            , loader used to load classes used in
     *            "classOfValue" in the resource.
     * 
     * @param defaultNamespace
     *            , namespace used in classes that do not
     *            specify a namespace in the resource.
     * 
     * @return The Map of loaded dynamic classes
     * 
     * @throws XmlPullParserException
     * @throws IOException
     */
    public Map importDynClassDefinitions(XmlPullParser parser,
        ClassLoader loader, String defaultNamespace)
        throws XmlPullParserException, IOException;

    /**
     * Añade la dynClass a la lista de clases registradas.
     * Falla lanzando una excepcion si ya existe una clase registrada con ese
     * nombre en ese namespace.
     * 
     * @param dynClass
     * @throws DuplicateDynClassException
     */
    public void add(DynClass dynClass) throws DuplicateDynClassException;

    /**
     * Create and add to the manager a class with the name
     * passed as parameter in the default namespace.
     * 
     * @param name
     * @param description
     * @return the new class created.
     */
    public DynClass add(String name, String description);

    /**
     * Create and add to the manager a class with the name
     * passed as parameter in the default namespace.
     * 
     * @param name
     * @param description
     * @return the new class created.
     */
    public DynClass add(String name);

    public void remove(DynStruct dynClass);

    /**
     * Obtiene la clase asociado al nombre indicado.
     * 
     * Si se indica un nombre con namespace la buscara en
     * ese namespace. if not se usara el namespace por
     * defecto.
     * 
     * @param name
     *            , nombre de la clase que queremos obtener.
     * @return la clase requerida.
     */
    public DynClass get(String name);

    /**
     * Obtiene el la clase asociado al nombre indicado dentro del
     * namespace pedido.
     * 
     * @param name
     *            , nombre de la clase que queremos obtener.
     * @return la clase requerida.
     */
    public DynClass get(String namespace, String name);

    /**
     * Comprueba si esta registrada una clase.
     * 
     * @return true si la clase "name" esta registrada, false si no.
     */
    public boolean has(String name);

    /**
     * Comprueba si esta registrada una clase.
     * 
     * @return true si la clase "name" esta registrada, false si no.
     */
    public boolean has(String namespace, String name);

    /**
     * Return the count of registered DynClass.
     * 
     * @return count of DynClass
     */
    public int getCount();

    /**
     * Return an iterator over all registered DynClass.
     * 
     * @return the iterator.
     */
    public Iterator iterator();

    /**
     * Return an iterator over all registered DynClass with the same namespace.
     * 
     * @return the iterator.
     */
    public Iterator iterator(String namespace);

    /**
     * Return the list of names of all registered DynClass.
     * 
     * @return list of DynClass names.
     */
    public List getNames();

    /**
     * Create a new DynObject associated to the DynStruct or DynClass
     * passed as parameter.
     * 
     * @param dynStruct
     *            or dynClass to use for create the dynObject
     * @return the new DynObject
     */
    public DynObject createDynObject(DynStruct dynStruct);

    /**
     * Crea un nuevo objeto asociandole como clase base la indicada que tiene el
     * nombre indicado.
     * 
     * @param dynClassName
     * @return el nuevo DynObject
     */
    public DynObject createDynObject(String classname);

    /**
     * Crea un nuevo objeto asociandole como clase base la indicada que tiene el
     * nombre indicado.
     * 
     * @param dynClassName
     * @return el nuevo DynObject
     */
    public DynObject createDynObject(String namespace, String classname);

    /**
     * Actualiza todas las DynClasses registradas para reflejar la
     * herencia de forma adecuada.
     */
    public void consolide();

    /**
     * Register the method in the dynClass.
     * 
     * @param dynClass
     *            class over the method is registred
     * @param dynMethod
     *            method to registry
     * @return unique code of method
     */
    public int registerDynMethod(DynClass dynClass, DynMethod dynMethod);

    /**
     * Register the method in the class.
     * 
     * @param theClass
     *            class over the method is registred
     * @param dynMethod
     *            method to registry
     * @return unique code of method
     */
    public int registerDynMethod(Class theClass, DynMethod dynMethod);

    /**
     * Obtain the method for the indicated code of the dynObject.
     * 
     * @param dynObject
     * @param code
     *            code of the requeted method
     * @return the required DynMethod
     * 
     * @throws DynMethodException
     */
    public DynMethod getDynMethod(DynObject dynObject, int code)
        throws DynMethodException;

    public DynMethod getDynMethod(DynClass dynClass, int code)
        throws DynMethodException;

    public DynMethod getDynMethod(Object obj, int code)
        throws DynMethodException;

    public DynMethod getDynMethod(Class theClass, int code)
        throws DynMethodException;

    public DynMethod getDynMethod(int code) throws DynMethodException;

    /**
     * Invoke the method of the indicated code for the object self, with
     * parameters in context.
     * 
     * @param self
     *            object over the method is invoked
     * @param code
     *            code for the method to invoke
     * @param context
     *            paramters of method
     * @return return value for the method
     * @throws DynMethodException
     */
    public Object invokeDynMethod(Object self, int code, DynObject context)
        throws DynMethodException;

    void validate(DynObject object) throws DynObjectValidateException;

    /**
     * @deprecated use DataTypesManager.getDefaultClass
     */
    Class getDefaultClassOfType(int type);

    /**
     * Creates a new {@link DynObjectPagingHelper} to page the data of a
     * {@link DynObjectSet}.
     * 
     * @param set
     *            to page the data of
     * @return a {@link DynObjectPagingHelper}
     * @throws BaseException
     *             if there is an error creating the paging helper, usually
     *             because of an error getting the data of the
     *             {@link DynObjectSet}
     */
    DynObjectPagingHelper createDynObjectPagingHelper(DynObjectSet set)
        throws BaseException;

    /**
     * Creates a new {@link DynObjectPagingHelper} to page the data of a
     * {@link DynObjectSet}.
     * 
     * @param set
     *            to page the data of
     * @param pageSize
     *            the size of the page to load using the helper
     * @return a {@link DynObjectPagingHelper}
     * @throws BaseException
     *             if there is an error creating the paging helper, usually
     *             because of an error getting the data of the
     *             {@link DynObjectSet}
     */
    DynObjectPagingHelper createDynObjectPagingHelper(DynObjectSet set,
        int pageSize) throws BaseException;

    /**
     * Creates a {@link org.gvsig.tools.dynobject.DynClassName} with a DynClass
     * name and its namespace.
     * 
     * @param namespace
     *            where the {@link DynClass} belongs to
     * @param name
     *            of the {@link DynClass}
     * @return a new {@link org.gvsig.tools.dynobject.DynClassName}
     */
    DynClassName createDynClassName(String namespace, String name);

    /**
     * Creates a {@link org.gvsig.tools.dynobject.DynClassName} with a DynClass
     * name or fullname
     * 
     * @param name
     *            of the {@link DynClass}. It might be a simple name or a
     *            composed full name (namespace and name)
     * @return a new {@link org.gvsig.tools.dynobject.DynClassName}
     */
    DynClassName createDynClassName(String name);
}

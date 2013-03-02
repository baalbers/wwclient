package org.gvsig.tools.dynobject;

import java.util.List;

import org.gvsig.tools.dataTypes.CoercionException;
import org.gvsig.tools.dataTypes.DataType;
import org.gvsig.tools.dataTypes.DataTypes;
import org.gvsig.tools.dynobject.exception.DynFieldIsNotAContainerException;
import org.gvsig.tools.dynobject.exception.DynFieldValidateException;

/**
 * A field of a {@link DynObject}.
 * <p>
 * A field will be persisted only if it is set as persistent (@see
 * {@link DynField#isPersistent()}, which is the default value.
 * </p>
 * 
 * @author <a href="mailto:jjdelcerro@gvsig.org">Joaqu�n Jos� del Cerro</a>
 */
public interface DynField {

	/**
	 * Return the name of the field.
	 * 
	 * @return name of the field
	 */
	public String getName();

	/**
	 * Return the type used in this field. 
	 * The values of type is the same of {@link DataTypes}
	 * 
	 * @return
	 */
	public int getType();

	public DataType getDataType();
	
	/**
	 * Return the subtype associated to this field.
	 * The subtype is a string used for the cliente of the
	 * field.
	 * 
	 * When the field is of type #{@link DataTypes#DYNOBJECT},
	 * the subtype are the fullname of the DynClass.
	 *  
	 * @return the subtype of the field.
	 */
	public String getSubtype();
	
	/**
	 * Return the descripcion associated to this field.
	 * 
	 * @return the description of the field.
	 */
	public String getDescription();

	/**
	 * Return the default value used in creation of new objects
	 * with this field.
	 * 
	 * @return defaulr value to use for this field.
	 */
	public Object getDefaultValue();

	/**
	 * Return a string that identify a group for this field.
	 * The groups are defined by the client of the field.
	 * 
	 * @return the group of the field
	 */
	public String getGroup();
	
	/**
	 * Return the ordinal that identify the order of this field
	 * in the {@link DynObject}.
	 * 
	 * @return the order of field in the {@link DynObject} 
	 */
	public int getOder();

	/**
	 * Return true if this field is mandatory.
	 * 
	 */
	public boolean isMandatory();
	
	/**
	 * Returns if the field is persistent or volatile. The meaning of being
	 * persistent depends on how is persisted, but any persistence mechanism
	 * must avoid persisting this field value.
	 * 
	 * @return if the field is to be persisted or not
	 */
	boolean isPersistent();

	/**
	 * Inform if this field can be visible or not for the user.
	 * This value don't affect the access through the API.
	 *  
	 * @return true if the field is hidden for the user.
	 */
	boolean isHidden();

	/**
	 * Returns if the field is readOnly or not. The meaning of being
	 * readOnly allows to know if the user input to any graphic component associated
	 * to this field should be allowed or not.
	 * 
	 * @return if the graphic component associated to this field should be readOnly or not
	 */
	public boolean isReadOnly();
	
	/**
	 * Return true if the value of this field is a container.
	 * This method uses the same criteria of the {@link DataType}
	 *  
	 * @return true if the field type is a container
	 */
	public boolean isContainer();

	/**
	 * Return the available values for this field.
	 * When assign a value to the field, this value need that
	 * exists in this list.
	 * 
	 * @return an array of the available values for the field.
	 */
	public DynObjectValueItem[] getAvailableValues();

	public Object getMinValue();

	public Object getMaxValue();

	/**
	 * Return the java class of the value of the field.
	 * 
	 * @return the class of the value
	 */
	Class getClassOfValue();

	/**
	 * If the field is a container (List, Map or Set) return
	 * the java class of its items.
	 * 
	 * @return the class of the items
	 */
	Class getClassOfItems();

	
	
	
	
	
	
	
	
	/**
	 * Sets the description asociated to this field.
	 * 
	 * @param description
	 * 
	 * @return this same {@link DynField} object
	 */
	DynField setDescription(String description);

	/**
	 * Sets the type of the field.
	 * The values used are the specified in {@link DataTypes}.
	 * 
	 * This method assign the default values of the type for
	 * "ClassOfValue" and "subType". 
	 * 
	 * @param type
	 * 
	 * @return this same {@link DynField} object
	 */
	DynField setType(int type);
	
	DynField setType(DataType type);

	/**
	 * Strings used as subtype for this field.
	 * This value is used by the client of the object.
	 * 
	 * When the field is a #{@link DataTypes#DYNOBJECT},
	 * the subtype is the fullname of the DynStruct.
	 *  
	 * @param subtype
	 * 
	 * @return this same {@link DynField} object
	 */
	DynField setSubtype(String subtype);

	/**
	 * Set the default value used for this field when a new
	 * object with this field is created.
	 *  
	 * @param defaultValue
	 * 
	 * @return this same {@link DynField} object
	 */
	DynField setDefaultFieldValue(Object defaultValue);

	DynField setGroup(String groupName);

	DynField setOrder(int order);

	DynField setMandatory(boolean mandatory);

	DynField setHidden(boolean hidden);

	/**
	 * Sets if the field must be persisted or not.
	 * @see #isPersistent()
	 * @param persistent if the field must be persisted or not
	 * @return this same {@link DynField} object
	 */
	DynField setPersistent(boolean persistent);

	DynField setAvailableValues(DynObjectValueItem[] values);

	DynField setAvailableValues(List values);

	DynField setMinValue(Object minValue);

	DynField setMaxValue(Object maxValue);
	
	/**
	 * Sets the class used for the values of the field.
	 *  
	 * @param theClass
	 * 
	 * @return this same {@link DynField} object
	 * 
	 * @throws DynFieldIsNotAContainerException
	 */
	DynField setClassOfValue(Class theClass) throws DynFieldIsNotAContainerException;
	
	/**
	 * If field type is List, Set or Map, this class is the class of items.
	 * 
	 * @param theClass
	 * 
	 * @return this same {@link DynField} object
	 * 
	 * @throws DynFieldIsNotAContainerException
	 */
	DynField setClassOfItems(Class theClass) throws DynFieldIsNotAContainerException;
	
	/**
	 * Sets if the field is readOnly or not. The meaning of being
	 * readOnly allows to know if the user input to any graphic component associated
	 * to this field should be allowed or not.
	 * @param isReadOnly
	 *    if the graphic component associated to this field should be readOnly or not
	 *    
	 * @return DynField that define the type of elements.
	 */
	public DynField setReadOnly(boolean isReadOnly);	


	
	
	
	
	
	/**
	 * When a field is of type container, this method return a DynClass
	 * that define the type of elements. 
 	 * When the type is DYNOBJECT return the DynClass associated
 	 * to this.
	 * 
	 * Return null if the type not is a container.
	 * 
	 * @return DynField that define the type of elements.
	 */
	public DynField getElementsType();

	/**
 	 * Set the type of items when the field is a container.
 	 * 
 	 * El  tipo de los elementos de un container esta definido
 	 * mediante un DynField, que crea con el tipo pasado por
 	 * parametro y lo devuelve este metodo.
 	 * 
	 * @param tipo de los elementos
	 * @return this same {@link DynField} object
	 * @throws DynFieldIsNotAContainerException
	 */
	public DynField setElementsType(int type) throws DynFieldIsNotAContainerException ;

	/**
 	 * Set the type of items when the field is a container.
 	 * 
 	 * Metodo de utilidad que establece el typo de DYNOBJECT y
 	 * methe como subtipo el DynStruct pasado como parametro.
 	 *  
	 * @param tipo de los elementos
	 * @return this same {@link DynField} object
	 * @throws DynFieldIsNotAContainerException
	 */
	public DynField setElementsType(DynStruct type) throws DynFieldIsNotAContainerException ;

	
	
	/**
	 * Validate that the value match the properties of the field.
	 * 
	 * @param value
	 * @throws DynFieldValidateException
	 */
	void validate(Object value) throws DynFieldValidateException;

	/**
	 * Force the type of value to the type of the field.
	 * 
	 * @param value
	 * @return new value
	 * @throws CoercionException 
	 */
	Object coerce(Object value) throws CoercionException;
		
	/**
	 * If the field value can be any possible value, for its type.
	 * 
	 * @deprecated now autodetect the mode of use
	 */
	static final int ANY = 1;

	/**
	 * If the field value must be one of a list of posible values.
	 * 
	 * @deprecated usado automaticamente al asignar AvailableValues 
	 */
    static final int CHOICE = 2;

	/**
	 * If the field value must pertain to a range of possible values.
	 * 
	 * @deprecated usado automaticamente al asignar minValue/maxValue
	 */
    static final int RANGE = 3;

	/**
	 * @deprecated don't use, check minValue/maxValue and getAvailableValues instead 
	 */
	int getTheTypeOfAvailableValues(); // SINGLE, CHOICE o RANGE

	/**
	 * @deprecated use instead {@link #setDefaultFieldValue(Object)}
	 */
	DynField setDefaultDynValue(Object defaultValue);

	/**
	 * @deprecated don't use, set minValue/maxValue and availableValues instead 
	 */
	DynField setTheTypeOfAvailableValues(int type);

}

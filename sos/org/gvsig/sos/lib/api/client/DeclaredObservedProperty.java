package org.gvsig.sos.lib.api.client;

/**
 * This interface provides access to the identifier of an observed property as 
 * declared in the capabilities document. 
 * @author lrodriguez
 */
public interface DeclaredObservedProperty {

	/**
	 * Gives the identifier of the observed property (usually but not necessarily an URI).
	 * @return the identifier of the observed property.
	 */
	public abstract String getIdentifier();

}
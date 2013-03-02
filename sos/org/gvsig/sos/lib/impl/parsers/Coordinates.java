package org.gvsig.sos.lib.impl.parsers;

import java.io.Serializable;

/**
 * Coordinates used in some position properties. When the coordinates refer to geographical coordinates. 
 * Its components contain information about the latitude, longitude and altitude.
 * @author lrodriguez
 *
 */
public class Coordinates implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8802929532378327559L;
	private double x = 0;
    private double y = 0;
    private double z = 0;
    
    /**
     * Returns the X component of the coordinates. In some cases it is the latitude, when the coordinates 
     * refer to geographical coordinates.
     * @return
     */
	public double getX() {
		return x;
	}
	/**
	 * Sets the X component of the coordinates.
	 * @param x the coordinate component value.
	 */

	public void setX(double x) {
		this.x = x;
	}
	
	/**
     * Returns the Y component of the coordinates. In some cases it is the longitude, when the coordinates 
     * refer to geographical coordinates.
     * @return
     */
	
	public double getY() {
		return y;
	}

	/**
	 * Sets the Y component of the coordinates.
	 * @param y the coordinate component value.
	 */

	public void setY(double y) {
		this.y = y;
	}

	/**
     * Returns the Z component of the coordinates. In some cases it is the altitude, when the coordinates 
     * refer to geographical coordinates.
     * @return
     */
	
	public double getZ() {
		return z;
	}
	/**
	 * Sets the Z component of the coordinates.
	 * @param z the coordinate component value.
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	 
	public String toString(){
		return String.format("(%s, %s, %s)", getX(), getY(), getZ());
	}
}


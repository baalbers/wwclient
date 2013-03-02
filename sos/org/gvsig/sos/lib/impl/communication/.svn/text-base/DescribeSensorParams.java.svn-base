package org.gvsig.sos.lib.impl.communication;

/**
 * Class for configuring the parameters to be used in the DescribeSensor operation.
 * @author lrodriguez
 *
 */
public class DescribeSensorParams extends RequestParameters{

	private String procedure;
	//Default value for output format
	private String postOutputFormat ="text/xml;subtype=&quot;sensorML/1.0.1&quot;";
	private String getOutputFormat ="text/xml;subtype=\"sensorML/1.0.1\"";
	private String outputFormat = postOutputFormat;

	/**
	 * Gets the procedure identifier configured in this parameters.
	 * @return the procedure id.
	 */
	public String getProcedure() {
		return procedure;
	}

	/**
	 * Sets the procedure to be requested in the DescribeSensor operation.
	 * @param procedure
	 */
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	/**
	 * Gets the output format to be configured for the DescribeSensor operation.
	 * @return a string with the output format 
	 */
	public String getOutputFormat() {
		return outputFormat;
	}

	/**
	 * Sets the output format for the result of the DescribeSensor operation.
	 * @param outputFormat
	 */
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}
}

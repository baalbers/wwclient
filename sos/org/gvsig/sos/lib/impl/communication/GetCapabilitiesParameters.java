package org.gvsig.sos.lib.impl.communication;

/**
 * Class containing the parameters that can be configured in a GetCapabilities 
 * operation request. 
 * @author lrodriguez
 *
 */

public class GetCapabilitiesParameters extends RequestParameters{
	//private String acceptVersions[];
	private String sections[];
	//private AcceptFormatsType formats[];
	private String updateSequence;
	
	//private int insertVersionAt = -1;
	private int insertSectionAt = -1;
	
	/*public String[] getAcceptVersions() {
		return acceptVersions;
	}
	public void setAcceptVersions(String[] acceptVersions) {
		this.acceptVersions = acceptVersions;
	}*/
	public String[] getSections() {
		return sections;
	}
	public void setSections(String[] sections) {
		this.sections = sections;
	}
	public String getUpdateSequence() {
		return updateSequence;
	}
	public void setUpdateSequence(String updateSequence) {
		this.updateSequence = updateSequence;
	}
	
	/*public void initAcceptVersions(int size){
		acceptVersions = new String[size];
	}
	
	public void addVersion(String version){
		assert insertVersionAt != -1;
		acceptVersions[insertVersionAt++] = version;	
	}*/
	
	public void initSections(int size){
		sections = new String[size];
	}
	
	public void addSections(String version){
		assert insertSectionAt != -1;
		sections[insertSectionAt++] = version;	
	}
}

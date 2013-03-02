package org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

public class NameResolver{
	
	public static final String XML_NAMESPACE_PREFIX = "xmlns";
	public static final String XML_PREFIX = "xml";
	public static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
	
	public static final List<Map<String, String>> allNamespaces = new ArrayList<Map<String, String>>();
	

	
	public static int createdCounter = 0;
	public static int destroyedCounter = 0;
	
	public static String getParserNextTag(XmlPullParser parser){
		parseTagNamespaces(parser);	
		String fullName = getFullName(parser.getName());
		return fullName;
	}
	
	public static String getFullName(String name) {
		String prefix = "";
		String tag = name;
		
		if (name.indexOf(":")!=-1){
			String temp[] = name.split(":");
			prefix = temp[0];
			tag = temp[1];
		} 
		
		return getNameForPrefix(prefix) + ":" + tag;
	}

    public static String getFullNameForAttr(String name) {
		String prefix;
		String tag;

		if (name.indexOf(":")!=-1){
			String temp[] = name.split(":");
			prefix = temp[0];
			tag = temp[1];
                        return getNameForPrefix(prefix) + ":" + tag;
		} else {
                    return name;
                }
	}


	
	private static String getNameForPrefix(String prefix) {

		if (prefix.equals(XML_PREFIX))
			return XML_NAMESPACE;
		
		for(int i = 0; i < allNamespaces.size(); i++){
			if (allNamespaces.get(i).containsKey(prefix)){
				return allNamespaces.get(i).get(prefix);
			}
		}
		return null;
	}

	protected static void parseTagNamespaces(XmlPullParser parser){
		Map<String, String> namespaces = new HashMap<String, String>();
		
		for (int i=0 ; i<parser.getAttributeCount() ; i++){
			String attName = parser.getAttributeName(i);
			if (attName.startsWith(XML_NAMESPACE_PREFIX)){
				int index = attName.indexOf(":");
				if (index > 0){
					namespaces.put(attName.substring(index+1, attName.length()),parser.getAttributeValue(i));
				} else {
					namespaces.put("", parser.getAttributeValue(i));
				}
			}
		}	
		allNamespaces.add(0, namespaces);
		//System.out.println("Inserting " + (++createdCounter));
		/*for (String prefix: namespaces.keySet()){
			System.out.println(String.format("%s - %s:%s", parser.getName(), prefix, namespaces.get(prefix)));
		}
		if (namespaces.size()>0) System.out.println();*/

	}
	
	public static void cleanLastNamespaceList(){
		allNamespaces.remove(0);
		//System.out.println("Deleting " + (++destroyedCounter));
	}
	
	public static void insertNamespaces(Map<String, String> map){
		allNamespaces.add(map);
	}
}

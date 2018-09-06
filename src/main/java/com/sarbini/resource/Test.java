package com.sarbini.resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class Test {

	public static void main(String[] args) {
		SampleObject obj = (SampleObject) toObject("<com.sarbini.resource.SampleObject><name>Test</name><testInt>9</testInt></com.sarbini.resource.SampleObject>");
		int i = obj.getTestInt();
		System.out.println(i);
	}

	public Object toObject(File xmlFile) throws IOException { 
		XStream xstream = new XStream();  
        xstream.ignoreUnknownElements(); 
        return xstream.fromXML(new FileReader(xmlFile));  
    }
	
	public static Object toObject(String xml) {  
		XStream xstream = new XStream();  
        xstream.ignoreUnknownElements(); 
        return (Object) xstream.fromXML(xml);  
    } 
}

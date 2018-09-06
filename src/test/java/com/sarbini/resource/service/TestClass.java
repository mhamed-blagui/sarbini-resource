package com.sarbini.resource.service;

import static org.junit.Assert.assertThat;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.ElementSelectors;

import com.google.common.base.Stopwatch;
import com.thoughtworks.xstream.XStream;

public class TestClass {

	private XStream xstream = null;  
    
	private Product product;
	
	@Test
	public void testXmlUnit() {
		Stopwatch stopwatch = Stopwatch.createStarted();
		String myControlXML = "<test><dd>k</dd><elem>a</elem><elem>c</elem><elem>b</elem></test>";
		String expected = "<test><dd>k</dd><elem>a</elem><elem>c</elem><elem>b</elem></test>";
		assertThat(myControlXML,
				isSimilarTo(expected).withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText)));
		// In case you wan't to ignore whitespaces add
		// ignoreWhitespace().normalizeWhitespace()
		isSimilarTo(myControlXML);
		assertThat(myControlXML, isSimilarTo(expected).ignoreWhitespace().normalizeWhitespace()
				.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText)));
	}

	@Test
	public void testXmlToObject() throws JAXBException, FileNotFoundException {
		File file = new File("product.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		product = (Product) unmarshaller.unmarshal(file);
		System.out.println(product);
	}
	
	public Object toObject(File xmlFile) throws IOException { 
		xstream = new XStream();  
        xstream.ignoreUnknownElements(); 
        return xstream.fromXML(new FileReader(xmlFile));  
    } 
}

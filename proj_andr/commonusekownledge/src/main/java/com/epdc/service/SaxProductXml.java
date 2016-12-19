package com.epdc.service;

import com.epdc.model.Product;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Epdc on 2015/9/14.
 */
public class SaxProductXml extends DefaultHandler {

    private List<Product> products;
    private Product product;

    private StringBuffer buffer;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        products = new ArrayList<>();
        buffer = new StringBuffer();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equals("product")) {
            product = new Product();
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("product")) {
            products.add(product);
        }
        if (localName.equals("name")) {
            product.setName(buffer.toString());
        }
        if (localName.equals("type")) {
            product.setType(buffer.toString());
        }
        buffer.setLength(0);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start,length);
        super.characters(ch, start, length);
    }

    public List<Product> getProducts() {
        return products;
    }
}

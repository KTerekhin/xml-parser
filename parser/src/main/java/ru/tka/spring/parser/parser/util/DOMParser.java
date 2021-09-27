package ru.tka.spring.parser.parser.util;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DOMParser {
    private final String FILEPATH = "test_file.xml";
    private final String TAG_USER = "User";
    private final String TAG_NAME = "name";
    private final String TAG_MIDDLENAME = "middleName";
    private final String TAG_SURNAME = "surname";

    private Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(FILEPATH);
    }

    private List<String> getElementsByMainTag() throws IOException, SAXException, ParserConfigurationException {
        List<String> list = new ArrayList<>();
        String s;
        Document document = getDocument();
        Node main = document.getFirstChild();
        String mainName = main.getNodeName();

        if (!mainName.equals(TAG_USER)) {
            return null;
        }
        NodeList mainChilds = main.getChildNodes();
        for (int i = 0; i < mainChilds.getLength(); i++) {
            if (mainChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            s = mainChilds.item(i).getNodeName();
            list.add(s);
        }
        return list;
    }

    private String getContentFromTag(String tag) throws IOException, SAXException, ParserConfigurationException {
        String result = "";
        Document document = getDocument();
        Node main = document.getFirstChild();
        NodeList mainChilds = main.getChildNodes();

        for (int i = 0; i < mainChilds.getLength(); i++) {
            if (mainChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (mainChilds.item(i).getNodeName().equals(tag)) {
                result = mainChilds.item(i).getTextContent();
            }
        }
        return result;
    }
}

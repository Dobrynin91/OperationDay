package ru.dobrynin91;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReadXML {
    public static void main(String[] args) {
        String pathFile = "CHER__tmp_20180113.xml";
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(pathFile);
        try {
            Document document = saxBuilder.build(xmlFile);
            Element element = document.getRootElement();
            List<Element> elementList = element.getChildren();
            int count = 0;
            for (Element el : elementList) {
                if (el.getChildTextNormalize("OrderDeleted").equals("NOT_DELETED")) {
                    if (!el.getChildTextNormalize("DishServicePrintTime").equals("")) {
                        if (el.getChildTextNormalize("OperationType").equals("PAYMENT")
                                || el.getChildTextNormalize("OperationType").equals("NO_PAYMENT")) {
                            if (el.getChildTextNormalize("RemovalType").equals("") & el.getChildTextNormalize("Storned").equals("")) {
                                if (el.getChildTextNormalize("OrderNum").equals("14914")) {
                                    System.out.println(el.getChildTextNormalize("OrderNum") + " " + el.getChildTextNormalize("UniqOrderId.Id"));
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        } catch (JDOMException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
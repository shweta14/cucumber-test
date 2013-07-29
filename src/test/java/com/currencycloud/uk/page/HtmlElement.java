package com.currencycloud.uk.page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Shweta
 * Date: 29/07/13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public enum HtmlElement {
    FIRST_NAME("First Name","input_1","field_1_1"),
    LAST_NAME("Last Name","input_10","field_1_10"),
    COMPANY("Company","input_2","field_1_2"),
    POSITION("Position","input_3","field_1_3"),
    ADDRESS("Address","input_4","field_1_4"),
    POSTCODE("Postcode","input_5","field_1_5"),
    EMAIL("Email","input_9","field_1_9"),
    PHONE_NUMBER("Phone No","input_7","field_1_7"),
    CONTACT_US_SUBMIT("Submit","gform_submit_button_1",""),
    NATURE_OF_ENQUIRY("Nature of your enquiry","input_8","field_1_8")
    ;
    private final String name;
    private final String id;
    private final String parentId;

    static Map<String,HtmlElement> nameIdMap = new HashMap<String, HtmlElement>();
    static {
        for(HtmlElement element:values()){
            nameIdMap.put(element.name,element);
        }
    }

    HtmlElement(String name, String id,String parentId) {
        this.name = name;
        this.parentId = parentId;
        this.id = id;
    }

    public static HtmlElement getElementByName(String name){
        return nameIdMap.get(name);
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getId() {
        return id;
    }
}

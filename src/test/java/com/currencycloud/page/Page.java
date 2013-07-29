package com.currencycloud.page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Shweta
 * Date: 28/07/13
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public enum Page {
    CURRENCY_CLOUD("The Currency Cloud","http://www.thecurrencycloud.com/","International Currency Exchange and Conversion | The Currency Cloud"),
    CONTACT_US("Contact Us","http://www.thecurrencycloud.com/contact-us/","Contact The Currency Cloud | Office Address and Map Location");

    private static Map<String,Page> pageNameMap = new HashMap<String, Page>();
    static {
        for(Page page:values()){
            pageNameMap.put(page.getPageName(),page);
        }
    }

    private final String pageName;
    private final String pageUrl;
    private final String pageTitle;

    Page(String pageName, String pageUrl,String pageTitle) {
        //To change body of created methods use File | Settings | File Templates.
        this.pageName = pageName;
        this.pageUrl = pageUrl;
        this.pageTitle = pageTitle;
    }


    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageName() {
        return pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public static Page getPageByName(String pageName){
        return pageNameMap.get(pageName);
    }
}


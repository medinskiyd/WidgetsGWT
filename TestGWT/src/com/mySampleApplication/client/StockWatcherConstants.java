package com.mySampleApplication.client;

import com.google.gwt.i18n.client.Constants;

/**
 * @author dmme1016
 * @since 10/26/2016
 */
public interface StockWatcherConstants extends Constants { //ConstantsWithLookup - is similar to Constants except that it also contains methods for looking up a localized string dynamically by name at runtime.
    @DefaultStringValue("StockWatcher")
    String stockWatcher();

    @DefaultStringValue("Symbol")
    String symbol();

    @DefaultStringValue("Price")
    String price();

    @DefaultStringValue("Change")
    String change();

    @DefaultStringValue("Remove")
    String remove();

    @DefaultStringValue("Add")
    String add();

    @DefaultStringValue("Input max 10 characters")
    String valid();

    @DefaultStringValue("Test GWT by Dmytryj")
    String test();

    @DefaultStringValue("GWT application")
    String gwt();
}

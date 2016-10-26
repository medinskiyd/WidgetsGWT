package com.mySampleApplication.client;

import com.google.gwt.i18n.client.Messages;
import java.util.Date;

/**
 * @author dmme1016
 * @since 10/26/2016
 */

public interface StockWatcherMessages extends Messages {
    @DefaultMessage("''{0}'' is not a valid symbol.")
    String invalidSymbol(String symbol);

    @DefaultMessage("Last update: {0,date,medium} {0,time,medium}")
    String lastUpdate(Date timestamp);

}

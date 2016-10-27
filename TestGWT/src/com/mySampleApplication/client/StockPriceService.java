package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * dmme1016
 * 10/26/2016
 */
@RemoteServiceRelativePath("stockPrices")
public interface StockPriceService extends RemoteService {

    StockPrice[] getPrices(String[] symbols) throws DelistedException;
}

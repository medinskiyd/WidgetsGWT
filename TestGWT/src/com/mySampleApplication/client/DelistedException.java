package com.mySampleApplication.client;

import java.io.Serializable;

/**
 * dmme1016
 * 10/26/2016
 */

public class DelistedException extends Exception implements Serializable {

    private String symbol;

    public DelistedException() {
    }

    public DelistedException(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

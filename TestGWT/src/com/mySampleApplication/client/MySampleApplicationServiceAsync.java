package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MySampleApplicationServiceAsync {

    // Sample interface method of remote interface
    void getMessage(String msg, String answer, AsyncCallback<String> async);
}

package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.MySampleApplicationService;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg, String answer) {
        return "Client said: \"" + msg + "\"<br>Server answered: " + answer;
    }
}
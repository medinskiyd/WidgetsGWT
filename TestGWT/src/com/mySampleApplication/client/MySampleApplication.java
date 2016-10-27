package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.http.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    private static final int REFRESH_INTERVAL = 5000; // ms
    private static final String JSON_URL = GWT.getModuleBaseURL() + "stockPricesJSON?q=";

    private Button button = new Button("Click me");
    private Button button1 = new Button("Test button");
    private Label label = new Label();

    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable stocksFlexTable = new FlexTable();
    private HorizontalPanel addPanel = new HorizontalPanel();
    private TextBox newSymbolTextBox = new TextBox();
    private Button addStockButton = new Button("Add");
    private Label lastUpdatedLabel = new Label();

    private ArrayList<String> stocks = new ArrayList<>();

    private StockPriceServiceAsync stockPriceSvc = GWT.create(StockPriceService.class);
    private Label errorMsgLabel = new Label();

    private StockWatcherConstants constants = GWT.create(StockWatcherConstants.class);
    private StockWatcherMessages messages = GWT.create(StockWatcherMessages.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
//                if (label.getText().equals("")) {
                MySampleApplicationService.App.getInstance().getMessage("Hello, World!", "You clicked button \"Click me\"", new MyAsyncCallback(label));
//                } else {
//                    label.setText("");
//                }
            }
        });

        button1.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                MySampleApplicationService.App.getInstance().getMessage("TEST TEST TEST", "You clicked button \"Just a com.mySampleApplication.test.\"", new MyAsyncCallback(label));
            }
        });

        // Set the window title, the header text, and the Add button text.
        Window.setTitle(constants.stockWatcher());
        RootPanel.get("appTitle").add(new Label(constants.stockWatcher()));
        RootPanel.get("valid").add(new Label(constants.valid()));
        RootPanel.get("com/mySampleApplication/test").add(new Label(constants.test()));
        RootPanel.get("gwt").add(new Label(constants.gwt()));

        addStockButton = new Button(constants.add());

        // Create table for stock data.
        stocksFlexTable.setText(0, 0, constants.symbol());
        stocksFlexTable.setText(0, 1, constants.price());
        stocksFlexTable.setText(0, 2, constants.change());
        stocksFlexTable.setText(0, 3, constants.remove());

        // Add styles to elements in the stock list table.
        stocksFlexTable.setCellPadding(6);

        // Add styles to elements in the stock list table.
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        stocksFlexTable.addStyleName("watchList");
        stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");

        // Assemble Add Stock horizontal panel.
        addPanel.add(newSymbolTextBox);
        addPanel.add(addStockButton);
        addPanel.addStyleName("addPanel");

        // Assemble Main panel.
        errorMsgLabel.setStyleName("errorMessage");
        errorMsgLabel.setVisible(false);

        mainPanel.add(errorMsgLabel);
        mainPanel.add(stocksFlexTable);
        mainPanel.add(addPanel);
        mainPanel.add(lastUpdatedLabel);

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(button1);
        RootPanel.get("slot3").add(label);

        // Associate the Main panel with the HTML host page.
        RootPanel.get("stockList").add(mainPanel);

        // Move cursor focus to the input box.
        newSymbolTextBox.setFocus(true);

        // Setup timer to refresh list automatically.
        Timer refreshTimer = new Timer() {
            @Override
            public void run() {
                refreshWatchList();
            }
        };

        refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

        // Listen for mouse events on the Add button.
        addStockButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addStock();
            }
        });

        // Listen for keyboard events in the input box.
        newSymbolTextBox.addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    addStock();
                }
            }
        });


    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }

    /**
     * Add stock to FlexTable. Executed when the user clicks the addStockButton or
     * presses enter in the newSymbolTextBox.
     */
    private void addStock() {
        final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
        newSymbolTextBox.setFocus(true);

        // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
        if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
            Window.alert(messages.invalidSymbol(symbol));
            newSymbolTextBox.selectAll();
            return;
        }

        newSymbolTextBox.setText("");

        int row = stocksFlexTable.getRowCount();
        stocks.add(symbol);
        stocksFlexTable.setText(row, 0, symbol);
        stocksFlexTable.setWidget(row, 2, new Label());
        stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");

        Button removeStockButton = new Button("x");
        removeStockButton.addStyleDependentName("remove");
        removeStockButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                int removedIndex = stocks.indexOf(symbol);
                stocks.remove(removedIndex);
                stocksFlexTable.removeRow(removedIndex + 1);
            }
        });
        stocksFlexTable.setWidget(row, 3, removeStockButton);

        // Get the stock price.
        refreshWatchList();

    }


    /**
     * Generate random stock prices (JSON example version).
     */
    private void refreshWatchList() {
        if (stocks.size() == 0) {
            return;
        }

        String url = JSON_URL;

        // Append watch list stock symbols to query URL.
        Iterator<String> iter = stocks.iterator();
        while (iter.hasNext()) {
            url += iter.next();
            if (iter.hasNext()) {
                url += "+";
            }
        }

        url = URL.encode(url);

        //Create new builder for GET request.
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

        try {
            //Create new request.
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    displayError("Couldn't retrieve JSON");
                }

                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        updateTable(JsonUtils.<JsArray<StockData>>safeEval(response.getText()));
                    } else {
                        displayError("Couldn't retrieve JSON (" + response.getStatusText()
                                + ")");
                    }
                }
            });
        } catch (RequestException e) {
            displayError("Couldn't retrieve JSON");
        }
    }

    /**
     * Generate random stock prices (AJAX, RPC - async version).
     */
//    private void refreshWatchList() {
//        // Initialize the service proxy.
//        if (stockPriceSvc == null) {
//            stockPriceSvc = GWT.create(StockPriceService.class);
//        }
//
//        // Set up the callback object.
//        AsyncCallback<StockPrice[]> callback = new AsyncCallback<StockPrice[]>() {
//            public void onFailure(Throwable caught) {
//                // If the stock code is in the list of delisted codes, display an error message.
//                String details = caught.getMessage();
//                if (caught instanceof DelistedException) {
//                    details = "Company '" + ((DelistedException)caught).getSymbol() + "' was delisted";
//                }
//
//                errorMsgLabel.setText("Error: " + details);
//                errorMsgLabel.setVisible(true);
//            }
//
//            public void onSuccess(StockPrice[] result) {
//                updateTable(result);
//            }
//        };
//
//        // Make the call to the stock price service.
//        stockPriceSvc.getPrices(stocks.toArray(new String[0]), callback);
//    }

//    /**
//     * Ajax RPC example.
//     *
//     * Update the Price and Change fields all the rows in the stock table.
//     *
//     * @param prices
//     *          Stock data for all rows.
//     */
//    private void updateTable(StockPrice[] prices) {
//        for (int i = 0; i < prices.length; i++) {
//            updateTable(prices[i]);
//        }
//
//        // Display timestamp showing last refresh.
//        lastUpdatedLabel.setText("Last update : " +
//                new Date());
//
//        // Clear any errors.
//        errorMsgLabel.setVisible(false);
//    }
    private void updateTable(JsArray<StockData> prices) {
        for (int i = 0; i < prices.length(); i++) {
            updateTable(prices.get(i));
        }

        // Display timestamp showing last refresh.
        lastUpdatedLabel.setText("Last update : " +
                new Date());

        // Clear any errors.
        errorMsgLabel.setVisible(false);
    }

    /**
     * AJAX RCP eample.
     *
     * Update a single row in the stock table.
     *
     * @param price Stock data for a single row.
     */
//    private void updateTable(StockPrice price) {
//        // Make sure the stock is still in the stock table.
//        if (!stocks.contains(price.getSymbol())) {
//            return;
//        }
//
//        // Display timestamp showing last refresh.
//        DateTimeFormat dateFormat = DateTimeFormat.getFormat(
//                DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
//        lastUpdatedLabel.setText(messages.lastUpdate(new Date()));
//
//        int row = stocks.indexOf(price.getSymbol()) + 1;
//
//        // Format the data in the Price and Change fields.
//        String priceText = NumberFormat.getFormat("#,##0.00").format(
//                price.getPrice());
//        NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
//        String changeText = changeFormat.format(price.getChange());
//        String changePercentText = changeFormat.format(price.getChangePercent());
//
//        // Populate the Price and Change fields with new data.
//        stocksFlexTable.setText(row, 1, priceText);
//        Label changeWidget = (Label)stocksFlexTable.getWidget(row, 2);
//        changeWidget.setText(changeText + " (" + changePercentText + "%)");
//
//        // Change the color of text in the Change field based on its value.
//        String changeStyleName = "noChange";
//        if (price.getChangePercent() < -0.1f) {
//            changeStyleName = "negativeChange";
//        }
//        else if (price.getChangePercent() > 0.1f) {
//            changeStyleName = "positiveChange";
//        }
//
//        changeWidget.setStyleName(changeStyleName);
//    }

    /**
     * JSON example.
     * <p>
     * Update a single row in the stock table.
     *
     * @param price Stock data for a single row.
     */
    private void updateTable(StockData price) {
        // Make sure the stock is still in the stock table.
        if (!stocks.contains(price.getSymbol())) {
            return;
        }

        // Display timestamp showing last refresh.
        DateTimeFormat dateFormat = DateTimeFormat.getFormat(
                DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
        lastUpdatedLabel.setText(messages.lastUpdate(new Date()));

        int row = stocks.indexOf(price.getSymbol()) + 1;

        // Format the data in the Price and Change fields.
        String priceText = NumberFormat.getFormat("#,##0.00").format(
                price.getPrice());
        NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
        String changeText = changeFormat.format(price.getChange());
        String changePercentText = changeFormat.format(price.getChangePercent());

        // Populate the Price and Change fields with new data.
        stocksFlexTable.setText(row, 1, priceText);
        Label changeWidget = (Label) stocksFlexTable.getWidget(row, 2);
        changeWidget.setText(changeText + " (" + changePercentText + "%)");

        // Change the color of text in the Change field based on its value.
        String changeStyleName = "noChange";
        if (price.getChangePercent() < -0.1f) {
            changeStyleName = "negativeChange";
        } else if (price.getChangePercent() > 0.1f) {
            changeStyleName = "positiveChange";
        }

        changeWidget.setStyleName(changeStyleName);
    }

    /**
     * If can't get JSON, display error message.
     *
     * @param error
     */
    private void displayError(String error) {
        errorMsgLabel.setText("Error: " + error);
        errorMsgLabel.setVisible(true);
    }


}

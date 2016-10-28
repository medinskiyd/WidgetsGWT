package com.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Widgets implements EntryPoint {

    private VerticalPanel panel = new VerticalPanel();
    private Constants constants = GWT.create(Constants.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        RootPanel.get("title").add(new Label(constants.title()));

        /** //////////////////////////////////
         ///////////  [LABEL] ////////////////
         ///////////////////////////////////*/
        // create two Labels
        Label label1 = new Label("This is first GWT Label");
        Label label2 = new Label("This is second GWT Label");

        // use UIObject methods to set label properties.
        label1.setTitle("Title for first Lable");
        label1.addStyleName("gwt-Green-Border");
        label2.setTitle("Title for second Lable");
        label2.addStyleName("gwt-Blue-Border");

        panel.add(new Label(constants.checkbox()));
        panel.add(label1);
        panel.add(label2);
        /** //////////////////////////////////
         ///////////  [LABEL] ////////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [CHECKBOX] ///////////////
         ///////////////////////////////////*/
        CheckBox checkBox1 = new CheckBox("Check Me!");
        CheckBox checkBox2 = new CheckBox("Check Me!");

        // set check box as selected
        checkBox1.setValue(false);

        //disable a checkbox
        checkBox2.setEnabled(false);

        checkBox1.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CheckBox checkBox = (CheckBox)event.getSource();
                Window.alert("CheckBox is " +
                        (checkBox.getValue() ? "" : "not") + " checked");
            }
        });

        panel.add(new Label(constants.checkbox()));
        panel.add(checkBox1);
        panel.add(checkBox2);
        /** //////////////////////////////////
         /////////  [CHECKBOX] ///////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [RADIOBUTTON]  ///////////
         ///////////////////////////////////*/
        // Create some radio buttons, all in one group 'radioGroup'.
        RadioButton radioButton1 = new RadioButton("radioGroup", "First");
        RadioButton radioButton2 = new RadioButton("radioGroup", "Second");

        // Check 'First' by default.
        radioButton1.setValue(false);

        //disable 'Second' radio button
        radioButton2.setEnabled(false);

        // Add toggle button to the root panel.
        panel.add(new Label(constants.radiobutton()));
        panel.add(radioButton1);
        panel.add(radioButton2);
        /** //////////////////////////////////
         /////////  [RADIOBUTTON]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////////  [TREE]  //////////////
         ///////////////////////////////////*/
        //create a label
        final Label labelMessage = new Label();
        labelMessage.setWidth("300");

        // Create a root tree item as department
        TreeItem department = new TreeItem();
        department.addTextItem("Department");

        //create other tree items as department names
        TreeItem salesDepartment = new TreeItem();
        salesDepartment.addTextItem("Sales");
        TreeItem marketingDepartment = new TreeItem();
        marketingDepartment.addTextItem("Marketing");

        //create other tree items as employees
        TreeItem employee1 = new TreeItem();
        employee1.addTextItem("Robert");

        TreeItem employee2 = new TreeItem();
        marketingDepartment.addTextItem("Dima");

        //add employees to sales department
        salesDepartment.addItem(employee1);
        salesDepartment.addItem(employee2);

        //add departments to department item
        department.addItem(salesDepartment);
        department.addItem(marketingDepartment);

        //create the tree
        Tree tree = new Tree();

        //add root item to the tree
        tree.addItem(department);

        tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                labelMessage.setText("Selected Value: "
                        + event.getSelectedItem().getText());
            }
        });

        panel.add(new Label(constants.tree()));
        panel.add(tree);
        /** //////////////////////////////////
         /////////////  [TREE]  //////////////
         ///////////////////////////////////*/




        /** ////  [MAIN_PANEL]  ////////////*/
        RootPanel.get("panel").add(panel);
    }

}

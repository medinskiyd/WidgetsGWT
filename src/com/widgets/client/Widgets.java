package com.widgets.client;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
         ///////////  [IMAGE] ////////////////
         ///////////////////////////////////*/
        // Create a Image widget
        Image image = new Image();

        //set image source
        image.setUrl("http://blog.arcbees.com/wp-content/uploads/2015/05/gwt2015_11.png");

        // Add image to the root panel.
        panel.add(image);
        /** //////////////////////////////////
         ///////////  [IMAGE] ////////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ///////////  [ANCHOR] ///////////////
         ///////////////////////////////////*/
        Anchor anchor = new Anchor("Google web toolkit",
                false,
                "http://www.gwtproject.org",
                "_blank");
        // Add anchor to the root panel.
        HorizontalPanel hPanel1 = new HorizontalPanel();
        hPanel1.add(new Label(constants.anchor()));
        hPanel1.add(anchor);
        panel.add(hPanel1);
        /** //////////////////////////////////
         ///////////  [ANCHOR] ///////////////
         ///////////////////////////////////*/


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

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(new Label(constants.label()));
        hPanel.add(label1);
        hPanel.add(label2);

        panel.add(hPanel);
        /** //////////////////////////////////
         ///////////  [LABEL] ////////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ///////////  [BUTTON] ///////////////
         ///////////////////////////////////*/
        //create buttons
        Button redButton = new Button("Red");
        Button greenButton = new Button("Green");
        Button blueButton = new Button("Blue");

        // use UIObject methods to set button properties.
        redButton.setWidth("100px");
        greenButton.setWidth("100px");
        blueButton.setWidth("100px");
        greenButton.addStyleName("gwt-Green-Button");
        blueButton.addStyleName("gwt-Blue-Button");

        //add a clickListener to the button
        redButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Red Button clicked!");
            }
        });

        //add a clickListener to the button
        greenButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Green Button clicked!");
            }
        });

        //add a clickListener to the button
        blueButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Blue Button clicked!");
            }
        });

        // Add button to the root panel.
        HorizontalPanel hPanel3 = new HorizontalPanel();
        hPanel3.add(new Label(constants.label()));
        hPanel3.add(redButton);
        hPanel3.add(greenButton);
        hPanel3.add(blueButton);
        panel.add(hPanel3);
        /** //////////////////////////////////
         ///////////  [BUTTON] ///////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [PUSH_BUTTON] /////////////
         ///////////////////////////////////*/
        //create a push button
        PushButton pushButton = new PushButton("Click Me!");

        //create a push button
        PushButton pushButton1 = new PushButton("Click Me!");

        //disable a push button
        pushButton1.setEnabled(false);

        //add a clickListener to the push button
        pushButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Hello World!");
            }
        });

        // Add push buttons to the root panel.
        HorizontalPanel hPanel4 = new HorizontalPanel();
        hPanel4.add(new Label(constants.pushButton()));
        hPanel4.add(pushButton);
        hPanel4.add(pushButton1);
        panel.add(hPanel4);
        /** //////////////////////////////////
         ////////  [PUSH_BUTTON] /////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [TOGGLE_BUTTON] ///////////
         ///////////////////////////////////*/
        //create toggle buttons
        ToggleButton toggleButton = new ToggleButton("Click Me!");
        ToggleButton toggleButton1 = new ToggleButton("Click Me!");

        //disable a toggle button
        toggleButton1.setEnabled(false);

        //add a clickListener to the toggle button
        toggleButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Hello World!");
            }
        });

        // Add toggle button to the root panel.
        HorizontalPanel hPanel6 = new HorizontalPanel();
        hPanel6.add(new Label(constants.toggleButton()));
        hPanel6.add(toggleButton);
        hPanel6.add(toggleButton1);
        panel.add(hPanel6);
        /** //////////////////////////////////
         ////////  [TOGGLE_BUTTON] ///////////
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
                CheckBox checkBox = (CheckBox) event.getSource();
                Window.alert("CheckBox is " +
                        (checkBox.getValue() ? "" : "not") + " checked");
            }
        });

        HorizontalPanel hPanel2 = new HorizontalPanel();
        hPanel2.add(new Label(constants.checkbox()));
        hPanel2.add(checkBox1);
        hPanel2.add(checkBox2);

        panel.add(hPanel2);
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
        HorizontalPanel hPanel5 = new HorizontalPanel();
        hPanel5.add(new Label(constants.radiobutton()));
        hPanel5.add(radioButton1);
        hPanel5.add(radioButton2);
        panel.add(hPanel5);
        /** //////////////////////////////////
         /////////  [RADIOBUTTON]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [LISTBOX]  ///////////
         ///////////////////////////////////*/
        // Make a new list box, adding a few items to it.
        ListBox listBox1 = new ListBox();
        listBox1.addItem("First");
        listBox1.addItem("Second");
        listBox1.addItem("Third");
        listBox1.addItem("Fourth");
        listBox1.addItem("Fifth");

        // Make a new list box, adding a few items to it.
        ListBox listBox2 = new ListBox();
        listBox2.addItem("First");
        listBox2.addItem("Second");
        listBox2.addItem("Third");
        listBox2.addItem("Fourth");
        listBox2.addItem("Fifth");

        // Make enough room for all five items
        listBox1.setVisibleItemCount(5);

        //setting itemcount value to 1 turns listbox into a drop-down list.
        listBox2.setVisibleItemCount(1);

        // Add listboxes to the root panel.
        HorizontalPanel hPanel7 = new HorizontalPanel();
        hPanel7.add(new Label(constants.listBox()));
        hPanel7.setSpacing(10);
        hPanel7.add(listBox1);
        hPanel7.add(listBox2);
        panel.add(hPanel7);
        /** //////////////////////////////////
         /////////  [LISTBOX]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [SUGGESTBOX]  ///////////
         ///////////////////////////////////*/
        //create the suggestion data
        MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
        oracle.add("A");
        oracle.add("AB");
        oracle.add("ABC");
        oracle.add("ABCD");
        oracle.add("B");
        oracle.add("BC");
        oracle.add("BCD");
        oracle.add("BCDE");
        oracle.add("C");
        oracle.add("CD");
        oracle.add("CDE");
        oracle.add("CDEF");
        oracle.add("D");
        oracle.add("DE");
        oracle.add("DEF");
        oracle.add("DEFG");

        //create the suggestion box and pass it the data created above
        SuggestBox suggestionBox = new SuggestBox(oracle);

        //set width to 200px.
        suggestionBox.setWidth("200");

        // Add suggestionbox to the root panel.
        HorizontalPanel hPanel8 = new HorizontalPanel();
        hPanel8.add(new Label(constants.suggestBox()));
        hPanel8.add(suggestionBox);
        panel.add(hPanel8);
        /** //////////////////////////////////
         /////////  [SUGGESTBOX]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////////  [TREE]  //////////////
         ///////////////////////////////////*/
        //create a label
        final Label labelMessage = new Label();
        labelMessage.setWidth("300");
        labelMessage.setVisible(false);

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
                labelMessage.setText("Selected Value: " + event.getSelectedItem().getText());
                labelMessage.setVisible(true);
            }
        });

        HorizontalPanel hPanel9 = new HorizontalPanel();
        hPanel9.add(new Label(constants.tree()));
        hPanel9.add(tree);
        panel.add(hPanel9);
        /** //////////////////////////////////
         /////////////  [TREE]  //////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////////  [TEXTBOX]  ///////////
         ///////////////////////////////////*/
        //create textboxes
        TextBox textBox1 = new TextBox();
        TextBox textBox2 = new TextBox();

        //add text to text box
        textBox2.setText("Hello World!");

        //set textbox as readonly
        textBox2.setReadOnly(true);

        // Add text boxes to the root panel.
        HorizontalPanel hPanel10 = new HorizontalPanel();
        hPanel10.add(new Label(constants.textBox()));
        hPanel10.add(textBox1);
        hPanel10.add(textBox2);
        panel.add(hPanel10);
        /** //////////////////////////////////
         /////////////  [TEXTBOX]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [PASSWORW_TEXT_BOX]  //////
         ///////////////////////////////////*/
        //create password textboxes
        PasswordTextBox passwordTextBox1 = new PasswordTextBox();
        PasswordTextBox passwordTextBox2 = new PasswordTextBox();

        //add text to text box
        passwordTextBox2.setText("hell@W@rld");

        //set textbox as readonly
        passwordTextBox2.setReadOnly(true);

        // Add text boxes to the root panel.
        HorizontalPanel hPanel11 = new HorizontalPanel();
        hPanel11.add(new Label(constants.passBox()));
        hPanel11.add(passwordTextBox1);
        hPanel11.add(passwordTextBox2);
        panel.add(hPanel11);
        /** //////////////////////////////////
         ////////  [PASSWORW_TEXT_BOX]  //////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [TEXT_AREA]  //////////////
         ///////////////////////////////////*/
        //create textarea elements
        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();

        //set width as 10 characters
        textArea1.setCharacterWidth(20);
        textArea2.setCharacterWidth(20);

        //set height as 5 lines
        textArea1.setVisibleLines(5);
        textArea2.setVisibleLines(5);

        //add text to text area
        textArea2.setText(" Hello World! \n Be Happy! \n Stay Cool!");

        //set textbox as readonly
        textArea2.setReadOnly(true);

        // Add text boxes to the root panel.
        HorizontalPanel hPanel12 = new HorizontalPanel();
        hPanel12.add(new Label(constants.textAreaBox()));
        hPanel12.add(textArea1);
        hPanel12.add(textArea2);
        panel.add(hPanel12);
        /** //////////////////////////////////
         ////////  [TEXT_AREA]  //////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [RICH_TEXT_AREA]  /////////
         ///////////////////////////////////*/
        //create RichTextArea elements
        RichTextArea richTextArea = new RichTextArea();

        richTextArea.setHeight("200");
        richTextArea.setWidth("500");

        //add text to text area
        richTextArea.setHTML("<b>Hello World!</b> <br/> <br/>" +
                "<i>Be Happy!</i> </br> <br/> <u>Stay Cool!</u>");

        // Add text boxes to the root panel.
        HorizontalPanel hPanel13 = new HorizontalPanel();
        hPanel13.add(new Label(constants.richTextAreaBox()));
        hPanel13.add(richTextArea);
        panel.add(hPanel13);
        /** //////////////////////////////////
         ////////  [RICH_TEXT_AREA]  /////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ////////  [FILE_UPLOAD]  ////////////
         ///////////////////////////////////*/
        HorizontalPanel hPanel14 = new HorizontalPanel();

        hPanel14.add(new Label(constants.uploadFile()));

        final FormPanel form = new FormPanel();
        //create a file upload widget
        final FileUpload fileUpload = new FileUpload();
        //create labels
        Label selectLabel = new Label("Select a file:");
        //create upload button
        Button uploadButton = new Button("Upload File");
        //pass action to the form to point to service handling file
        //receiving operation.
        form.setAction("http://www.tutorialspoint.com/gwt/myFormHandler");
        // set form to use the POST method, and multipart MIME encoding.
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        //add a label
        hPanel14.add(selectLabel);
        //add fileUpload widget
        hPanel14.add(fileUpload);
        //add a button to upload the file
        hPanel14.add(uploadButton);
        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //get the filename to be uploaded
                String filename = fileUpload.getFilename();
                if (filename.length() == 0) {
                    Window.alert("No File Specified!");
                } else {
                    //submit the form
                    form.submit();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // When the form submission is successfully completed, this
                //event is fired. Assuming the service returned a response
                //of type text/html, we can get the result text here
                Window.alert(event.getResults());
            }
        });

        // Add form to the root panel.
        panel.add(hPanel14);
        /** //////////////////////////////////
         ////////  [FILE_UPLOAD]  ////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ///////////  [MENU_BAR]  ////////////
         ///////////////////////////////////*/

        HorizontalPanel hPanel15 = new HorizontalPanel();
        hPanel15.add(new Label(constants.menuBar()));

        // Create a menu bar
        MenuBar menu = new MenuBar();

        menu.setAutoOpen(true);
        menu.setWidth("100px");
        menu.setAnimationEnabled(true);

        // Create the file menu
        MenuBar fileMenu = new MenuBar(true);
        fileMenu.setAnimationEnabled(true);

        fileMenu.addItem("New", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("New");
            }
        });
        fileMenu.addItem("Open", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Open");
            }
        });
        fileMenu.addSeparator();
        fileMenu.addItem("Exit", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Exit");
            }
        });

        // Create the edit menu
        MenuBar editMenu = new MenuBar(true);
        editMenu.setAnimationEnabled(true);

        editMenu.addItem("Undo", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Undo");
            }
        });
        editMenu.addItem("Redo", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Redo");
            }
        });
        editMenu.addItem("Cut", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Cut");
            }
        });
        editMenu.addItem("Copy", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Copy");
            }
        });
        editMenu.addItem("Paste", new Command() {
            @Override
            public void execute() {
                showSelectedMenuItem("Paste");
            }
        });

        menu.addItem(new MenuItem("File", fileMenu));
        menu.addSeparator();
        menu.addItem(new MenuItem("Edit", editMenu));
        hPanel15.add(menu);
        panel.add(hPanel15);
        /** //////////////////////////////////
         ///////////  [MENU_BAR]  ////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [DATE_PICKER]  ///////////
         ///////////////////////////////////*/
        // Create a basic date picker
        DatePicker datePicker = new DatePicker();
        final Label text = new Label();

        // Set the value in the text box when the user selects a date
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                String dateString =
                        DateTimeFormat.getFormat("MM/dd/yyyy").format(date);
                text.setText(dateString);
            }
        });
        // Set the default value
        datePicker.setValue(new Date(), true);

        // Create a DateBox
        DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
        DateBox dateBox = new DateBox();
        dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

        Label selectLabel1 = new Label("Permanent DatePicker:");
        Label selectLabel2 = new Label("DateBox with popup DatePicker:");
        // Add widgets to the root panel.
        HorizontalPanel hPanel16 = new HorizontalPanel();
        hPanel16.add(new Label(constants.datePicker()));
        VerticalPanel hPanel17 = new VerticalPanel();
        hPanel17.add(selectLabel1);
        hPanel17.add(text);
        hPanel17.add(datePicker);
        hPanel16.add(hPanel17);
        VerticalPanel hPanel18 = new VerticalPanel();
        hPanel18.add(selectLabel2);
        hPanel18.add(dateBox);
        hPanel16.add(hPanel18);
        panel.add(hPanel16);
        /** //////////////////////////////////
         /////////  [DATE_PICKER]  ///////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [CELL_TABLE]  ////////////
         ///////////////////////////////////*/
        // Create a CellTable.
        CellTable<Contact> table = new CellTable<>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        // Add a text column to show the name.
        TextColumn<Contact> nameColumn =
                new TextColumn<Contact>() {
                    @Override
                    public String getValue(Contact object) {
                        return object.name;
                    }
                };
        table.addColumn(nameColumn, "Name");

        // Add a date column to show the birthday.
        DateCell dateCell = new DateCell();
        Column<Contact, Date> dateColumn
                = new Column<Contact, Date>(dateCell) {
            @Override
            public Date getValue(Contact object) {
                return object.birthday;
            }
        };
        table.addColumn(dateColumn, "Birthday");

        // Add a text column to show the address.
        TextColumn<Contact> addressColumn
                = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact object) {
                return object.address;
            }
        };
        table.addColumn(addressColumn, "Address");

        // Add a selection model to handle user selection.
        final SingleSelectionModel<Contact> selectionModel
                = new SingleSelectionModel<Contact>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        Contact selected = selectionModel.getSelectedObject();
                        if (selected != null) {
                            Window.alert("You selected: " + selected.name);
                        }
                    }
                });

        // Set the total row count. This isn't strictly necessary,
        // but it affects paging calculations, so its good habit to
        // keep the row count up to date.
        table.setRowCount(CONTACTS.size(), true);

        // Push the data into the widget.
        table.setRowData(0, CONTACTS);

        HorizontalPanel hPanel19 = new HorizontalPanel();
        VerticalPanel cellPanel = new VerticalPanel();
        cellPanel.setBorderWidth(1);
        cellPanel.setWidth("400");
        cellPanel.add(table);
        hPanel19.add(new Label(constants.cellTable()));
        hPanel19.add(cellPanel);
        panel.add(hPanel19);
        /** //////////////////////////////////
         /////////  [CELL_TABLE]  ////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////////  [PLOW_PANEL]  ////////////
         ///////////////////////////////////*/
        // Create a flow panel
        FlowPanel flowPanel = new FlowPanel();

        // Add CheckBoxes to flow Panel
        for(int i = 1;  i <= 10; i++){
            CheckBox checkBox = new CheckBox("Item" + i);
            flowPanel.add(checkBox);
        }

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.setWidth("500");
        decoratorPanel.add(flowPanel);

        HorizontalPanel hPanel20 = new HorizontalPanel();
        hPanel20.add(new Label(constants.flowPanel()));
        hPanel20.add(flowPanel);
        panel.add(hPanel20);
        /** //////////////////////////////////
         /////////  [PLOW_PANEL]  ////////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////  [HORIZONTAL_PANEL]  //////////
         ///////////////////////////////////*/
        // Create a horizontal panel
        HorizontalPanel horizontalPanel = new HorizontalPanel();

        // Add CheckBoxes to horizontal Panel
        for(int i = 1;  i <= 10; i++){
            CheckBox checkBox = new CheckBox("Item" + i);
            horizontalPanel.add(checkBox);
        }

        DecoratorPanel decoratorPanel1 = new DecoratorPanel();
        decoratorPanel1.setWidth("500");
        decoratorPanel1.add(horizontalPanel);

        HorizontalPanel hPanel21 = new HorizontalPanel();
        hPanel21.add(new Label(constants.horPanel()));
        hPanel21.add(decoratorPanel1);
        panel.add(hPanel21);
        /** //////////////////////////////////
         /////  [HORIZONTAL_PANEL]  //////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         /////  [VERTICAL_PANEL]  //////////
         ///////////////////////////////////*/
        // Create a vertical panel
        VerticalPanel verticalPanel = new VerticalPanel();

        // Add CheckBoxes to vertical Panel
        for(int i = 1;  i <= 5; i++){
            CheckBox checkBox = new CheckBox("Item" + i);
            verticalPanel.add(checkBox);
        }

        DecoratorPanel decoratorPanel2 = new DecoratorPanel();
        decoratorPanel2.add(verticalPanel);

        HorizontalPanel hPanel22 = new HorizontalPanel();
        hPanel22.add(new Label(constants.verPanel()));
        hPanel22.add(decoratorPanel2);
        panel.add(hPanel22);
        /** //////////////////////////////////
         /////  [VERTICAL_PANEL]  //////////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ///  [HORIZONTAL_SPLIT_PANEL]  //////
         ///////////////////////////////////*/
        // Create a Horizontal Split Panel
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSize("300px", "200px");
        horizontalSplitPanel.setSplitPosition("30%");

        // Add some content
        String randomText = "This is a sample text.";
        for (int i = 0; i < 2; i++) {
            randomText += randomText;
        }
        horizontalSplitPanel.setRightWidget(new HTML(randomText));
        horizontalSplitPanel.setLeftWidget(new HTML(randomText));

        DecoratorPanel decoratorPanel3 = new DecoratorPanel();
        decoratorPanel3.add(horizontalSplitPanel);
        HorizontalPanel hPanel23 = new HorizontalPanel();
        hPanel23.add(new Label(constants.horSplitPanel()));
        hPanel23.add(decoratorPanel3);
        panel.add(hPanel23);
        /** //////////////////////////////////
         ///  [HORIZONTAL_SPLIT_PANEL]  //////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         ///??  [VERTICAL_SPLIT_PANEL]  //////
         ///////////////////////////////////*/
        // Create a Vertical Split Panel
        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
        verticalSplitPanel.setSize("300px", "200px");
        verticalSplitPanel.setSplitPosition("35%");

        // Add some content
        String randomText1 = "This is a sample text.";
        for (int i = 0; i < 2; i++) {
            randomText1 += randomText1;
        }
        verticalSplitPanel.setBottomWidget(new HTML(randomText));
        verticalSplitPanel.setTopWidget(new HTML(randomText));

        DecoratorPanel decoratorPanel4 = new DecoratorPanel();
        decoratorPanel4.add(verticalSplitPanel);
        HorizontalPanel hPanel24 = new HorizontalPanel();
        hPanel24.add(new Label(constants.verSplitPanel()));
        hPanel24.add(decoratorPanel4);
        panel.add(hPanel24);
        /** //////////////////////////////////
         ////// [VERTICAL_SPLIT_PANEL]  //////
         ///////////////////////////////////*/


        /** //////////////////////////////////
         //////////// [GRID]  ////////////////
         ///////////////////////////////////*/
        // Create a grid
        Grid grid = new Grid(2, 2);

        // Add images to the grid
        int numRows = grid.getRowCount();
        int numColumns = grid.getColumnCount();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                grid.setWidget(row, col,
                        new Image("https://cdn1.iconfinder.com/data/icons/all_google_icons_symbols_by_carlosjj-du/128/gwt.png"));
            }
        }

        DecoratorPanel decoratorPanel5 = new DecoratorPanel();
        decoratorPanel5.add(grid);
        HorizontalPanel hPanel25 = new HorizontalPanel();
        hPanel25.add(new Label(constants.grid()));
        hPanel25.add(decoratorPanel5);
        panel.add(hPanel25);
        /** //////////////////////////////////
         //////////// [GRID]  ////////////////
         ///////////////////////////////////*/


        /** ////  [MAIN_PANEL]  ////////////*/
        RootPanel.get("panel").add(panel);
    }

    private void showSelectedMenuItem(String menuItemName){
        Window.alert("Menu item: "+menuItemName+" selected");
    }




    /**
     * A simple data type that represents a contact.
     */
    private static class Contact {
        private final String address;
        private final Date birthday;
        private final String name;

        public Contact(String name, Date birthday, String address) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
        }
    }

    /**
     * The list of data to display.
     */
    private static final List<Contact> CONTACTS = Arrays.asList(
            new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
            new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
            new Contact("George",new Date(46, 6, 6),"1600 Pennsylvania Avenue"));
}

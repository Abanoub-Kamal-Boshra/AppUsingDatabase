/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package databaseapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Abanoub Kamal
 */
public class DatabaseApp extends Application {

    Label id;
    TextField idField;
    Label fname;
    TextField fnameField;
    Label lname;
    TextField lnameField;
    Label email;
    TextField emailField;
    Label phone;
    TextField phoneField;

    Button newBtn;
    Button updateBtn;
    Button deleteBtn;
    Button firstBtn;
    Button previousBtn;
    Button nextBtn;
    Button lastBtn;

    FlowPane lapelPane;
    FlowPane textFieldPane;
    FlowPane buttonsPane;
    BorderPane rootPane;
     
    Scene myScene;

    public void init(){
        idField = new TextField();
        idField.setPrefWidth(300);
        id = new Label("ID: ");
        id.setPrefWidth(100);
        fnameField = new TextField();        
        fname = new Label("First Name: ");
        lnameField = new TextField();
        lname = new Label("Last Name:  ");
        emailField = new TextField();
        email = new Label("Email: ");
        phoneField = new TextField();
        phone = new Label("Phone: ");
//        phone.setContentDisplay(ContentDisplay.RIGHT);

        newBtn = new Button("New");
        updateBtn = new Button("Update");
        deleteBtn = new Button("Delete");
        firstBtn = new Button("First");
        previousBtn = new Button("Previous");
        nextBtn = new Button("Next");
        lastBtn = new Button("Last");

 
        lapelPane = new FlowPane(Orientation.VERTICAL , id, fname, lname, email, phone);
//        lapelPane.setAlignment(Pos.TOP_LEFT);
        lapelPane.setVgap(22);
        lapelPane.setPadding(new Insets(10, 0, 10, 20));
        textFieldPane = new FlowPane(Orientation.VERTICAL , idField, fnameField, lnameField, emailField, phoneField);
        textFieldPane.setVgap(10);
        textFieldPane.setPadding(new Insets(10, 10, 10, 10));
//        textFieldPane.setAlignment(Pos.TOP_LEFT);
        buttonsPane = new FlowPane(newBtn, updateBtn, deleteBtn, firstBtn, previousBtn, nextBtn, lastBtn);
        buttonsPane.setHgap(10);

        rootPane = new BorderPane();
        rootPane.setLeft(lapelPane);
        rootPane.setCenter(textFieldPane);
        rootPane.setBottom(buttonsPane);

        myScene = new Scene(rootPane, 465, 270);
        ContactDAO.initForMoveBetweenContacts();
    }


    @Override
    public void start(Stage primaryStage) {

        firstBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactDAO contactDao = new ContactDAO();
                ContactPerson firstContact = contactDao.getContactPerson("FIRST_BUTTON");
                if(firstContact != null){
                    idField.setText(new Integer(firstContact.getId()).toString());
                    fnameField.setText(firstContact.getfName());
                    lnameField.setText(firstContact.getlName());
                    emailField.setText(firstContact.getEmail());
                    phoneField.setText(new Integer(firstContact.getPhone()).toString());
                }
            }
        });

        lastBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactDAO contactDao = new ContactDAO();
                ContactPerson lastContact = contactDao.getContactPerson("LAST_BUTTON");
                if(lastContact != null){
                    idField.setText(new Integer(lastContact.getId()).toString());
                    fnameField.setText(lastContact.getfName());
                    lnameField.setText(lastContact.getlName());
                    emailField.setText(lastContact.getEmail());
                    phoneField.setText(new Integer(lastContact.getPhone()).toString());
                }
            }
        });

        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactDAO contactDao = new ContactDAO();
                ContactPerson nextContact = contactDao.getContactPerson("NEXT_BUTTON");
                if(nextContact != null){
                    idField.setText(new Integer(nextContact.getId()).toString());
                    fnameField.setText(nextContact.getfName());
                    lnameField.setText(nextContact.getlName());
                    emailField.setText(nextContact.getEmail());
                    phoneField.setText(new Integer(nextContact.getPhone()).toString());
                }else{}
            }
        });

        previousBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactDAO contactDao = new ContactDAO();
                ContactPerson previousContact = contactDao.getContactPerson("PREVIOUS_BUTTON");
                if(previousContact != null){
                    idField.setText(new Integer(previousContact.getId()).toString());
                    fnameField.setText(previousContact.getfName());
                    lnameField.setText(previousContact.getlName());
                    emailField.setText(previousContact.getEmail());
                    phoneField.setText(new Integer(previousContact.getPhone()).toString());
                }
            }
        });

//            newBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ContactDAO.closeTheConnection();
//                ContactDAO contactDao = new ContactDAO();
//                ContactPerson previousContact = contactDao.getContactPerson("PREVIOUS_BUTTON");
//                if(previousContact != null){
//                    idField.setText(new Integer(previousContact.getId()).toString());
//                    fnameField.setText(previousContact.getfName());
//                    lnameField.setText(previousContact.getlName());
//                    emailField.setText(previousContact.getEmail());
//                    phoneField.setText(new Integer(previousContact.getPhone()).toString());
//                }
//            }
//        });
        
        primaryStage.setTitle("Personal Details!");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        Platform.exit();
        ContactDAO.closeTheConnection();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}

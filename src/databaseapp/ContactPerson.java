/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseapp;

/**
 *
 * @author Abanoub Kamal
 */
public class ContactPerson {
    
    private int id;
    private String fName;
    private String lName;
    private String email;
    private int phone;

    public ContactPerson(){
        this.id = 0;
        this.fName = "";
        this.lName = "";
        this.email = "";
        this.phone = 0;
    }

    public ContactPerson(int id, String fName, String lName, String email, int phone) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }


}

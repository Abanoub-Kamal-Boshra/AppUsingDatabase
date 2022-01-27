/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abanoub Kamal
 */
public class ContactDAO {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "root";

    private static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<ContactPerson> getContacts() {
        List<ContactPerson> listContacts = new ArrayList<ContactPerson>();
        try{
            Connection con = connect();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String queryString = new String("SELECT * FROM public.personaldata");
            ResultSet rs = stmt.executeQuery(queryString);
            while(rs.next()){
                ContactPerson contact = new ContactPerson();
                contact.setId(rs.getInt("id"));
                contact.setfName(rs.getString("fname"));
                contact.setlName(rs.getString("lname"));
                contact.setEmail(rs.getString("email"));
                contact.setPhone(rs.getInt("phone"));

                listContacts.add(contact);
            }
            stmt.close();
            con.close();
        }catch(SQLException ex){}

        return listContacts;
    }

    public List<ContactPerson> getContactsForName(String name){
        List<ContactPerson> listContacts = new ArrayList<ContactPerson>();
        try{
            Connection con = connect();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String queryString = new String("SELECT * FROM public.personaldata where fname = '"+name+"' ;");
            ResultSet rs = stmt.executeQuery(queryString);
            while(rs.next()){
                ContactPerson contact = new ContactPerson();
                contact.setId(rs.getInt("id"));
                contact.setfName(rs.getString("fname"));
                contact.setlName(rs.getString("lname"));
                contact.setEmail(rs.getString("email"));
                contact.setPhone(rs.getInt("phone"));

                listContacts.add(contact);
            }
            stmt.close();
            con.close();
        }catch(SQLException ex){}

        return listContacts;
    }


////////////////////////////////////////////////////////////////////////////
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static ContactPerson contact;

    public static void initForMoveBetweenContacts(){
        contact = new ContactPerson();
            try{
                con = connect();
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String queryString = new String("SELECT * FROM public.personaldata");
                rs = stmt.executeQuery(queryString);
            }catch(SQLException ex){}
    }

    public static void closeTheConnection(){
        try{
            stmt.close();
            con.close();
        }catch(SQLException ex){}
    }

    public ContactPerson getContactPerson(String buttonPressedName){
        boolean status;
        try{
           switch (buttonPressedName) {
               case "FIRST_BUTTON":
                   status =rs.first();
//                   status = true;
                   break;
                case "LAST_BUTTON":
                   status =rs.last();
//                   status = true;
                   break;
                case "NEXT_BUTTON":
                   status =rs.next();
//                   status = true;
                   break;
                case "PREVIOUS_BUTTON":
                   status =rs.previous();
//                   status = true;
                   break;
               default:
                   status = false;
                   throw new AssertionError();
           }
            if(status){
                System.out.println("databaseapp.ContactDAO.getContactPerson()");
                contact.setId(rs.getInt("id"));
                contact.setfName(rs.getString("fname"));
                contact.setlName(rs.getString("lname"));
                contact.setEmail(rs.getString("email"));
                contact.setPhone(rs.getInt("phone"));
            }else{
                return null;
            }
        }catch(SQLException ex){}

        return contact;
    }

}

package com.example;

import java.sql.*;
import java.util.*;

public class App 
{
    

    private static final String connUrl = "jdbc:mysql://localhost:3306/newDatabase";
    private static final String username =  "mypc";
    private static final String pass = "admin@123";
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        try{
        //Class.forName(com.mysql.jdbc.Driver);
        Connection conn = DriverManager.getConnection(connUrl,username,pass);
        boolean exit = false;
        while(exit != true){
            System.out.println("Menu");
            int choice = 0;
            System.out.println("1.Add user, 2.Remove User, 3.List of Users, 4.End Session");
            choice = scan.nextInt();
            switch(choice){
                case 1: addPerson(conn);
                        break;
                case 2: delPerson(conn);
                        break;
                case 3: displayPersons(conn);
                        break;
                case 4: System.out.println("Session Ended");
                        exit= true;
                        break;
                default: System.out.println("Select valid option");
            }
        }
        }catch(Exception e){System.out.println(e);}

    }

    static void addPerson(Connection conn){
        try{
        Scanner scan = new Scanner(System.in);
        PreparedStatement prsmt = conn.prepareStatement("INSERT INTO Person values(?,?)");

        System.out.print("Enter USERID(Integer value): ");
        int id = scan.nextInt();
        System.out.println();

        System.out.print("Enter Name: ");
        String name = scan.next();
        System.out.println();

        prsmt.setInt(1, id);
        prsmt.setString(2, name);

        prsmt.executeUpdate();
        System.out.println("Inserted....");
        }catch(Exception e){System.out.println(e);}

    }

    static void delPerson(Connection conn){
        try{
        Scanner scan = new Scanner(System.in);
        PreparedStatement prsmt = conn.prepareStatement("DELETE FROM Person WHERE id=?");

        System.out.print("Enter USERID(Integer value): ");
        int id = scan.nextInt();
        System.out.println();

        prsmt.setInt(1, id);

        prsmt.executeUpdate();
        System.out.println("Deleted the Record....");
        }catch(Exception e){System.out.println(e);}

    }

    static void displayPersons(Connection conn){
        try{
        Statement stmt = conn.createStatement();

        System.out.println("List of USERS: ");
        ResultSet rs = stmt.executeQuery("SELECT * FROM Person");
        System.out.println(rs);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.println("ID: "+id+" Name: "+name);
            }
        }catch(Exception e){System.out.println(e);}

    }
}

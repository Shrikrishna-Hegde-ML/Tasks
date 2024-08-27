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
            System.out.println("1.Add user, 2.Remove User, 3.List of Users, 4.End Session, 5. Average Salary");
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
                case 5: AverageSalary(conn);
                        break;
                default: System.out.println("Select valid option");
            }
        }
        }catch(Exception e){System.out.println(e);}

    }

    static void AverageSalary(Connection conn){
        try {
            CallableStatement callst = conn.prepareCall("{call avg_salary()}");
            ResultSet rs = callst.executeQuery();
            rs.next();
            System.out.println("Average Salary = "+rs.getLong(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void addPerson(Connection conn){
        try{
        Scanner scan = new Scanner(System.in);
        PreparedStatement prsmt = conn.prepareStatement("INSERT INTO Employee values(?,?,?)");

        System.out.print("Enter USERID(Integer value): ");
        int id = scan.nextInt();
        System.out.println();

        System.out.print("Enter Name: ");
        String name = scan.next();
        System.out.println();

        System.out.print("Enter Salary(Integer value): ");
        int salary= scan.nextInt();
        System.out.println();

        prsmt.setInt(1, id);
        prsmt.setString(2, name);
        prsmt.setInt(3, salary);

        prsmt.executeUpdate();
        System.out.println("Inserted....");
        }catch(Exception e){System.out.println(e);}

    }

    static void delPerson(Connection conn){
        try{
        Scanner scan = new Scanner(System.in);
        PreparedStatement prsmt = conn.prepareStatement("DELETE FROM Employee WHERE id=?");

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
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
        System.out.println(rs);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");

            System.out.println("ID: "+id+" Name: "+name+"Salary: "+salary);
            }
        }catch(Exception e){System.out.println(e);}

    }

    // static void sendMail(Connection conn){
    //     Scanner scan = new Scanner(System.in);
    //     try{
    //     PreparedStatement preStmt = conn.prepareStatement("SELECT name FROM Person WHERE name = ?");
    //     System.out.println("Enter username you want to send birthday wishes");
    //     String bName = scan.next();

    //     preStmt.setString(1, bName);

    //     ResultSet rs = preStmt.executeQuery();
    //     if(rs.next() != null){
    //         rs.next();
    //         System.out.println("Happy Birthday "+rs.getString(1));
    //     }
    //     else{
    //         System.out.println("Sorry we dont have that employee , Anyways Happy Birthday");
    //     }
        
    // }catch(Exception e){System.out.println(e);}
    // }
}

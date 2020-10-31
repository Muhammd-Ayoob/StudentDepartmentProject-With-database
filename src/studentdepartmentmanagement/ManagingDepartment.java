/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdepartmentmanagement;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class ManagingDepartment {
    static Connection con=DbConnection.getConnection();
    static Scanner s=new Scanner(System.in);
     static Department d=new Department();
    
    public void addDepartment(Department department)
    {
        try
        {
        
       String addQuery="insert into Department(d_id,d_name,d_code) values(?,?,?)";
       
       PreparedStatement smt=con.prepareStatement(addQuery);
       smt.setInt(1,department.getId());
       smt.setString(2,department.getName());
       smt.setString(3,department.getCode());
       
       smt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        menu();
    }
    
    public void getAll()
    {
        try{
        String query="select *from Department";
        PreparedStatement smt=con.prepareCall(query);
        smt.executeQuery();
        ResultSet r=smt.executeQuery();
        
        while(r.next())
        {
            System.out.println("id           name           code");
            System.out.print(r.getInt("d_id"));
            System.out.print("            "+r.getString("d_name"));
            System.out.println("          "+r.getString("d_code"));
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void update(Department department)
    {
         try
        {
        
       String query="update Department set d_name=? where d_id=?";
       
       PreparedStatement smt=con.prepareStatement(query);
       smt.setString(1,department.getName());
       smt.setInt(2,department.getId());
       //smt.setString(3,department.getCode());
       
       smt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(int d_id)
    {
        try
        {
            String query="delete from Department where d_id=?";
            PreparedStatement smt=con.prepareStatement(query);
            smt.setInt(1,d_id);
            smt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        menu();
    }
    
    public void exit()
    {}
    
    public void getSingle(int id)
    {
        try{
           // Statement smt=con.createStatement();
        String query="select *from Department where d_id=?";
       PreparedStatement smt=con.prepareStatement(query);
       smt.setInt(1, id);
       //smt.executeQuery();
        ResultSet r=smt.executeQuery();
        
        while(r.next())
        {
            if(id!=r.getInt("d_id"))
            {
                System.out.println("Not fond");
            }
            System.out.println("id           name           code");
            System.out.print(r.getInt("d_id"));
            System.out.print("            "+r.getString("d_name"));
            System.out.println("          "+r.getString("d_code"));
            
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
   public void deleteAll()
    {
        try{
        String query="delete from Department";
        PreparedStatement smt=con.prepareStatement(query);
        smt.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void menu()
    {
        System.out.println("ENTER:");
        System.out.println("        1:Add Department:");
        System.out.println("        2:Update Department:");
        System.out.println("        3:Delete Department:");
        System.out.println("        4:delete All:");
        System.out.println("        5:getSingle");
        System.out.println("        6:getAll:");
        System.out.println("Enter any random number to exit program:");
        System.out.println("ENTER YOUR CHOICE");
        int n=s.nextInt();
        if(n==1)
        {
        System.out.println("Enter id");
        int id=s.nextInt();
        
        System.out.println("Enter name");
        String name=s.next();
        
        System.out.println("Enter code");
        String code=s.next();
        
        
        d.setId(id);
        d.setName(name);
        d.setCode(code);
        addDepartment(d);
        }
        else if(n==2)
        {
            System.out.println("Enter Department new name");
            String name=s.next();
            
            System.out.println("Enter department id which you want to update");
            int id=s.nextInt();
            
            d.setName(name);
            d.setId(id);
            update(d);
        }
        else if(n==3)
        {
            System.out.println("Enter Department id to delete:");
            int id=s.nextInt();
            
            d.setId(id);
            delete(id);
            if(d.getId()!=id)
            {
                System.out.println("Does not exist");
            }
        }
        else if(n==4)
        {
        deleteAll();
        }
        else if(n==5)
        {
          
            System.out.println("Enter id to get Department");
            int id=s.nextInt();
           
            d.setId(id);
            getSingle(id);
        }
        else if(n==6)
        {
            getAll();
        }
        else
        {
            exit();
        }
    } 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdepartmentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class ManagingStudent1 {
    static Connection con=DbConnection.getConnection();
    static Scanner s=new Scanner(System.in);
     Student st=new Student();
     
     public void addStudent(Student student)
     {
         try{
         String query="insert into Student(s_id,s_name,roll_no,d_id) values(?,?,?,?)";
         PreparedStatement sm=con.prepareStatement(query);
         sm.setInt(1,st.getId());
         sm.setString(2,st.getName());
         sm.setString(3,st.getRollno());
         sm.setInt(4,st.getD_id());
         sm.executeUpdate();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }
     
     public void getAll()
     {
         try{
         String query="SELECT s_id,s_name,roll_no,d_name FROM Student s INNER JOIN Department d ON s.d_id=d.d_id;";
         PreparedStatement sm=con.prepareStatement(query);
         sm.executeQuery();
         ResultSet r=sm.executeQuery();
         
         while(r.next())
         {
             System.out.println(r.getInt("s_id"));
             System.out.println(r.getString("s_name"));
             System.out.println(r.getString("roll_no"));
             System.out.println(r.getString("d_name"));
         }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
     }
     
     public void menu()
     {
         System.out.println("ENTER:");
         System.out.println("      1:add Student:");
         System.out.println("      2:getAll Students");
         System.out.println("Enter your choice:");
         int n=s.nextInt();
         if(n==1)
         {
         System.out.println("Enter Student id");
         int id=s.nextInt();
         System.out.println("Enter Student name");
         String name=s.next();
         
         System.out.println("Enter Roll no");
         String rollno=s.next();
         
         System.out.println("Enter Department id");
         int dId=s.nextInt();
         
         st.setId(id);
         st.setName(name);
         st.setRollno(rollno);
         st.setD_id(dId);
         addStudent(st);
         }
         else if(n==2)
         {
             getAll();
         }
         //addStudent(st);
     }
    
    
}

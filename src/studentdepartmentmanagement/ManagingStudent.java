/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdepartmentmanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class ManagingStudent {
    static Connection con=DbConnection.getConnection();
    static Scanner s=new Scanner(System.in);
     static Student st=new Student();
     
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
         menu();
     }
     
     public void getAll()
     {
         String query="SELECT s_id,s_name,roll_no,d_name FROM Student s INNER JOIN Department d ON s.d_id=d.d_id;";
         
     }
     
     public void menu()
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
         //addStudent(st);
     }
    
}

   

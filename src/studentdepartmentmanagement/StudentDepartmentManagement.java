/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdepartmentmanagement;

import java.sql.Connection;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class StudentDepartmentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ManagingStudent1 st=new ManagingStudent1();
            //ManagingStudents st=new ManagingStudents();
                ManagingDepartment md=new ManagingDepartment();
                //md.menu();
                st.menu();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

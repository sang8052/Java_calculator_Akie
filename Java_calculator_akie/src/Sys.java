/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MR_SZH
 */

import javax.swing.*;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  


public class Sys 
{
    public String SYS_VERSION ="1.0.0.1.beta";
    public String SYS_WRITTER ="ɣ���";
    public String SYS_TIME ="2017.11.16";
   
    
    public String DATA_URL="jdbc:mysql://www.szhcloud.cn/java";  //���ݿ��ַ
    public String DATA_USER="java"; //���ݿ��û���
    public String DATA_PASS="3WZBW46sWW"; //���ݿ�����
    public static final String name = "com.mysql.jdbc.Driver";  
    
    public Connection conn = null;  
    public PreparedStatement pst = null; 
    
    
      public void CONN(String sql) {  
        try {  
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(DATA_URL,DATA_USER,DATA_PASS);//��ȡ����  
            String gbk="SET NAMES 'GBK'";
           pst=conn.prepareStatement(gbk);
            pst = conn.prepareStatement(sql);//׼��ִ�����  
              
        } catch (Exception e) {  
               JOptionPane.showMessageDialog(null,"���ݿ�����ʧ�ܣ�" );
            e.printStackTrace();  
            
        }  
    }  
  
      public void CLOSE() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
       } 
      
      
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MR_SZH
 */
import java.sql.ResultSet;  
import java.sql.SQLException;  
import javax.swing.JOptionPane;

public class Res {
   
    
    static ResultSet ret = null;  
  
    public String [] GetRes(String sql) {  
        
         Sys db1 = new Sys();//����Sys����  
         db1.CONN(sql);
                String[] data = new String[3]; 
               data[0]=null; 
        try {  
            ret = db1.pst.executeQuery();//ִ����䣬�õ������  
            while (ret.next()) { 
                
                data[0]= ret.getString(1);  
                data[1] = ret.getString(2);  
                data[2]= ret.getString(3);  
               
            }//��ʾ����  
            ret.close();  
            db1.CLOSE();//�ر�����  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return data;
    }  
     
    public boolean  VERSION_CHECK(String SQL)
    {   Sys info=new Sys();
        String [] res_data=this.GetRes(SQL);
        if(res_data[2].equals(info.SYS_VERSION))
        {return false;}
        return true;
    }
    public boolean  SERVER_CHECK(String SQL)
    {   Sys info=new Sys();
        String str="����";
        String [] res_data=this.GetRes(SQL);
        if(res_data[2].equals(str))
        {return false;}
       SQL="select * from calcu where keyword='"+"serveroff'";
       String [] res_data_2=this.GetRes(SQL);
        JOptionPane.showMessageDialog(null,res_data_2[2] );
        return true;
    }
    public boolean  MESSAGE_CHECK()
    {    Sys info=new Sys();
        String str="�ر�";
        String SQL="select * from calcu where keyword='"+"messagefun'";
        String [] res_data=this.GetRes(SQL);
        if(res_data[2].equals(str))
        {return false;}
       SQL="select * from calcu where keyword='"+"message'";
       String [] res_data_2=this.GetRes(SQL);
        JOptionPane.showMessageDialog(null,res_data_2[2] );
       
        return true;
    }
    
}

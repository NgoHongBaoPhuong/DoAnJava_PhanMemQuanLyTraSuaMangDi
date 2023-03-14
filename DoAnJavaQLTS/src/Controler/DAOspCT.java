/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.SanphamCT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class DAOspCT {
    private Connection conn;
    public DAOspCT ()
    {
        try{
            String url="jdbc:mysql://localhost:3306/quanly";
            String user="root";
            String password="root";
            conn = DriverManager.getConnection(url,user,password);
        }catch(Exception e){
             e.printStackTrace();
        }
    }
    
    public ArrayList<SanphamCT> getListSP(){
        ArrayList<SanphamCT> list=new ArrayList<>();
        String sql="select * from tblctsanpham";
        try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                SanphamCT s=new SanphamCT();                
                s.setId(rs.getInt("ID"));
                s.setMasp(rs.getString("MASP"));
                s.setSoluong(rs.getInt("SOLUONG")); 
                s.setGia(rs.getInt("GIA"));                
                list.add(s);                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
    }
    public void AddSP(SanphamCT sp)
    {
        String sql=" insert into tblctsanpham(`MASP`,`SOLUONG`,`GIA`) VALUES "
                + "(?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,sp.getMasp());
            ps.setInt(2,sp.getSoluong());                       
            ps.setInt(3,sp.getGia());
            ps.executeUpdate();
            
            
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public void DeleteSP(int id){
        String sql="delete from tblctsanpham where id=?";
        try{
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new DAOspCT();        
    } 
}

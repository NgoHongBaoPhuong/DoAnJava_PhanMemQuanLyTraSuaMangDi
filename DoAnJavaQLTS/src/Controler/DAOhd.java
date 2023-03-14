/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Hoadon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DAOhd {
    private Connection conn;
    public DAOhd ()
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
    public ArrayList<Hoadon> getListHD(){
        ArrayList<Hoadon> list=new ArrayList<>();
        String sql="select * from tblhoadon";
        try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                Hoadon hd=new Hoadon();                
                hd.setMaHD(rs.getInt("ID"));
                hd.setDateOrder(rs.getString("DATE"));                            
                hd.setThanhtien(rs.getInt("Thanhtien"));
                list.add(hd);
                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
    }
    public void AddHD(Hoadon hd)
    {
        String sql=" insert into tblhoadon(`Date`, `Thanhtien`) VALUES "
                + "(?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,hd.getDateOrder());
            ps.setInt(2,hd.getThanhtien());           
            ps.executeUpdate();
            
            
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public void DeleteSP(int id){
        String sql="delete from tblhoadon where id=?";
        try{
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public ArrayList<Hoadon> findbyDate(String Date)
    {
        ArrayList<Hoadon> list=new ArrayList<>();
        String sql="select * from tblhoadon where DATE like ?";
         try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,"%"+Date+"%");
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {               
                Hoadon hd=new Hoadon();                
                hd.setMaHD(rs.getInt("ID"));
                hd.setDateOrder(rs.getString("DATE"));                            
                hd.setThanhtien(rs.getInt("Thanhtien"));
                list.add(hd);
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
        
    }
    public static void main(String[] args)
    {
        new DAOhd();        
    } 
}

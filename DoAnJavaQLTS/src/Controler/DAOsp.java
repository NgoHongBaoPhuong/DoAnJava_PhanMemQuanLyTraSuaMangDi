/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;



import Model.sanpham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DAOsp 
{
    private Connection conn;
    public DAOsp ()
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
    public ArrayList<sanpham> getListSP(){
        ArrayList<sanpham> list=new ArrayList<>();
        String sql="select * from tblsanpham";
        try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                sanpham s=new sanpham();                
                s.setId(rs.getInt("ID"));
                s.setMasp(rs.getString("MASP"));
                s.setTensp(rs.getString("NAME"));
                s.setLoai(rs.getString("LOAI"));                
                s.setTrangthai(rs.getString("TRANGTHAI")); 
                s.setGia(rs.getInt("GIA"));                
                list.add(s);                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
    }
    public void AddSP(sanpham sp)
    {
        String sql=" insert into tblsanpham(`MASP`,`NAME`,`LOAI`,`TRANGTHAI`,`GIA`) VALUES "
                + "(?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,sp.getMasp());
            ps.setString(2,sp.getTensp());
            ps.setString(3,sp.getLoai());
            ps.setString(4,sp.getTrangthai());            
            ps.setInt(5,sp.getGia());
            ps.executeUpdate();
            
            
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public void DeleteSP(int id){
        String sql="delete from tblsanpham where id=?";
        try{
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public ArrayList<sanpham> findbyName(String NAME)
    {
        ArrayList<sanpham> list=new ArrayList<>();
        String sql="select * from tblsanpham where NAME like ?";
         try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,"%"+NAME+"%");
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                sanpham s=new sanpham();                
                s.setId(rs.getInt("ID"));
                s.setMasp(rs.getString("MASP"));
                s.setTensp(rs.getString("NAME"));
                s.setLoai(rs.getString("LOAI"));                
                s.setTrangthai(rs.getString("TRANGTHAI")); 
                s.setGia(rs.getInt("GIA"));                
                list.add(s);   
                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
        
    }
    public static void main(String[] args)
    {
        new DAOsp();        
    } 

    
}

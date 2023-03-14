/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;
import Model.Nhanvien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */

public class DAOnv 
{
    private Connection conn;
    public DAOnv ()
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
    public ArrayList<Nhanvien> getListNV(){
        ArrayList<Nhanvien> list=new ArrayList<>();
        String sql="select * from tblnhanvien";
        try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                Nhanvien n=new Nhanvien();                
                n.setId(rs.getInt("ID"));
                n.setManv(rs.getString("MANV"));
                n.setTennv(rs.getString("NAME"));
                n.setChucvu(rs.getString("CHUCVU"));
                n.setDate(rs.getString("NGAYSINH"));
                n.setGt(rs.getString("GIOITINH"));
                n.setDiachi(rs.getString("DIACHI"));
                n.setSDT(rs.getString("SODIENTHOAI"));
                n.setEmail(rs.getString("EMAIL"));
                n.setLuong(rs.getInt("LUONG"));
                list.add(n);
                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
    }
    public void AddNV(Nhanvien n)
    {
        String sql=" insert into tblnhanvien(`MANV`,`NAME`,`CHUCVU`,`NGAYSINH`,`GIOITINH`,`DIACHI`,`SODIENTHOAI`,`EMAIL`,`LUONG`) VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,n.getManv());
            ps.setString(2,n.getTennv());
            ps.setString(3,n.getChucvu());
            ps.setString(4,n.getDate());
            ps.setString(5,n.getGt());
            ps.setString(6,n.getDiachi());
            ps.setString(7,n.getSDT());
            ps.setString(8,n.getEmail());
            ps.setInt(9,n.getLuong());
            ps.executeUpdate();
            
            
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    public void DeleteNV(int id){
        String sql="delete from tblnhanvien where id=?";
        try{
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }
    
    public ArrayList<Nhanvien> findbyName(String NAME)
    {
        ArrayList<Nhanvien> list=new ArrayList<>();
        String sql="select * from tblnhanvien where NAME like ?";
         try{
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,"%"+NAME+"%");
             ResultSet rs=ps.executeQuery();
             while(rs.next())
            {
                Nhanvien n=new Nhanvien();                
                n.setId(rs.getInt("ID"));
                n.setManv(rs.getString("MANV"));
                n.setTennv(rs.getString("NAME"));
                n.setChucvu(rs.getString("CHUCVU"));
                n.setDate(rs.getString("NGAYSINH"));
                n.setGt(rs.getString("GIOITINH"));
                n.setDiachi(rs.getString("DIACHI"));
                n.setSDT(rs.getString("SODIENTHOAI"));
                n.setEmail(rs.getString("EMAIL"));
                n.setLuong(rs.getInt("LUONG"));
                list.add(n);
                
            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return list;
        
    }
    public static void main(String[] args)
    {
        new DAOnv();        
    } 

   
    
}

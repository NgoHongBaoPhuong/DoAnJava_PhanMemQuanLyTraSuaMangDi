/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Nhanvien 
{
     int id;
     String Manv,Tennv,Chucvu,Date,Gt,Diachi,SDT,Email;
     int Luong;

    public Nhanvien() {
    }

    public Nhanvien(String Manv, String Tennv, String Chucvu, String Date, String Gt, String Diachi, String SDT, String Email, int Luong) {
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Chucvu = Chucvu;
        this.Date = Date;
        this.Gt = Gt;
        this.Diachi = Diachi;
        this.SDT = SDT;
        this.Email = Email;
        this.Luong = Luong;
    }

    public Nhanvien(int id, String Manv, String Tennv, String Chucvu, String Date, String Gt, String Diachi, String SDT, String Email, int Luong) {
        this.id = id;
        this.Manv = Manv;
        this.Tennv = Tennv;
        this.Chucvu = Chucvu;
        this.Date = Date;
        this.Gt = Gt;
        this.Diachi = Diachi;
        this.SDT = SDT;
        this.Email = Email;
        this.Luong = Luong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getGt() {
        return Gt;
    }

    public void setGt(String Gt) {
        this.Gt = Gt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
    
}

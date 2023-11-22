package com.vn.orderapp.add_data;

public class NguoiDung {
    private String sdt;
    private String hoTen;
    private String email;

    public NguoiDung(String sdt, String hoTen, String email) {
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }
}

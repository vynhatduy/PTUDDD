package com.vn.orderapp.add_data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddData {
    // tham chiếu đến realtime database
    public FirebaseDatabase database =FirebaseDatabase.getInstance();
    public void Add_NguoiDung(String sdt,String hoTen,String email){
        DatabaseReference nguoiDungRef = database.getReference("NguoiDung");
        NguoiDung nguoiDung = new NguoiDung(sdt,hoTen,email);
        nguoiDungRef.child(nguoiDung.getSdt()).setValue(nguoiDung);
    }
}

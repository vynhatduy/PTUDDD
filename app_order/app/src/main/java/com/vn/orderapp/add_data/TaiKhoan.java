package com.vn.orderapp.add_data;
public class TaiKhoan {
    private String sdt;
    private String mk;
    private int Diem;


    public void setDiem(int diem) {
        Diem = diem;
    }

    public String getSdt() {
        return sdt;
    }

    public String getMk() {
        return mk;
    }

    public int getDiem() {
        return Diem;
    }

    public TaiKhoan(String sdt, String mk, int diem) {
        this.sdt = sdt;
        this.mk = mk;
        Diem = diem;
    }

 /*   public class PasswordUtils {

        private BCryptPasswordEncoder passwordEncoder;

        public PasswordUtils() {
            passwordEncoder = new BCryptPasswordEncoder();
        }

        public String hashPassword(String password) {
            return passwordEncoder.encode(password);
        }

        public boolean checkPassword(String rawPassword, String encodedPassword) {
            return passwordEncoder.matches(rawPassword, encodedPassword);
        }
    }

  */
}


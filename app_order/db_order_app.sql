Create DataBase Order_app
Use Order_app

CREATE TABLE NguoiDung (
    SDT VARCHAR(15) PRIMARY KEY,
    HoTen VARCHAR(100),
    Email VARCHAR(50)
);

CREATE TABLE TaiKhoan (
    SDT VARCHAR(15) PRIMARY KEY,
    MatKhau VARCHAR(50),
    Diem INT,
    ChuoiNgauNhien VARCHAR(50),
    FOREIGN KEY (SDT) REFERENCES NguoiDung(SDT)
);

CREATE TABLE DiaChi (
    SDT VARCHAR(15),
    DiaChi VARCHAR(200),
    SDTLayHang VARCHAR(15),
    PRIMARY KEY (SDT, DiaChi),
    FOREIGN KEY (SDT) REFERENCES NguoiDung(SDT)
);

CREATE TABLE HangHoa (
    Ma INT PRIMARY KEY,
    Ten VARCHAR(100),
    MoTa TEXT,
    Gia FLOAT
);

CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY,
    SDT VARCHAR(15),
    NgayLap DATE,
    FOREIGN KEY (SDT) REFERENCES NguoiDung(SDT)
);

CREATE TABLE ChiTietHoaDon (
    MaHoaDon INT,
    MaHangHoa INT,
    SoLuong INT,
    Diem INT,
    PRIMARY KEY (MaHoaDon, MaHangHoa),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaHangHoa) REFERENCES HangHoa(Ma)
);

CREATE TABLE TrangThai (
    MaHoaDon INT,
    SDT VARCHAR(15),
    TrangThai VARCHAR(50),
    PRIMARY KEY (MaHoaDon),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (SDT) REFERENCES NguoiDung(SDT)
);

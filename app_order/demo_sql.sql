create database OrderApp_demo
use OrderApp_demo

create table NguoiDung(
ID nchar(5) not null primary key, /* mỗi người dùng có 1 id duy nhất dựa vào id để lấy dữ liệu */
HoTen nvarchar(30) not null,
SDT nchar(10) not null, 
DiaChi nvarchar(30),
Diem int /* điểm dùng để đổi các phần thưởng hoặc giảm một phần giá trị sản phẩm */
)

create table TaiKhoan(
ID nchar(5) not null primary key,
username nvarchar(20) not null,
passwork nchar(50) not null,
XAST nchar(20), /* sinh chuỗi ngầu nhiên để bảo mật dữ liệu cùng với hàm băm */
MaNguoiDung nchar(5) references NguoiDung(ID)
)

create table Loai(
ID nchar(2) not null primary key,
TenLoai nvarchar(20) not null
)

create table SanPham(
ID nchar(5) not null primary key,
Ten nvarchar(30) not null,
MaLoai nchar(2) references Loai(ID),
Gia int,
DVT int
)

create table ComBo(
ID nchar(5) not null primary key,
Ten nvarchar(30) not null,
Gia int
)

create table Sale(
ID nchar(5) not null primary key,
Ten nvarchar(30) not null,
sale int not null,
LoaiSale nvarchar(2) not null,
DieuKien nvarchar(20)
)

create table HoaDon(
ID nchar(5) not null primary key,
Ngay date,
TongGia int
)

create table CTHoaDon(
ID nchar(5) not null primary key,
MaHoaDon nchar(5) references HoaDon(ID),
Ngay date,
MaSanPham nchar(5) references SanPham(ID),
MaComBo nchar(5) references ComBo(ID),
MaNguoiDung nchar(5) references NguoiDung(ID),
DonGia int,
MaSale nchar(5) references Sale(ID),
DVT int,
ThanhTien int
)
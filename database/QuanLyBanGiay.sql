USE master;
DROP DATABASE IF EXISTS QuanLyCuaHangBanGiay;
CREATE DATABASE QuanLyCuaHangBanGiay;
USE QuanLyCuaHangBanGiay;

CREATE TABLE TaiKhoan (
    TenTK NVARCHAR(100) PRIMARY KEY,
    MatKhau NVARCHAR(100),
    ChucVu NVARCHAR(50),
    MaNV INT
);

CREATE TABLE KhachHang (
    MaKH INT IDENTITY PRIMARY KEY,
    TenKH NVARCHAR(100), 
    GioiTinh NVARCHAR(10), 
    DiaChi NVARCHAR(200),
    Email NVARCHAR(50), 
    SoDT NVARCHAR(10)
);

CREATE TABLE HoaDon (
    MaHD INT IDENTITY PRIMARY KEY,
    MaKH INT NOT NULL,
	MaNV INT NOT NULL,
    NgayMua DATE NOT NULL,
    TrangThai NVARCHAR(50),
    PTTT NVARCHAR(40),
    TongTien DECIMAL(18, 2) NOT NULL
);

CREATE TABLE ChiTietHoaDon (
    MaCTHD INT IDENTITY PRIMARY KEY,
    MaHD INT NOT NULL,
    MaSP INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGiaBan DECIMAL(18, 2) NOT NULL
);

CREATE TABLE DanhMuc (
    MaDM INT IDENTITY PRIMARY KEY,
    TenDM NVARCHAR(100)
);

CREATE TABLE SanPham (
    MaSP INT IDENTITY PRIMARY KEY,
    TenSP NVARCHAR(100),
    DonGiaNhap DECIMAL(18, 2),
    DonGiaBan DECIMAL(18, 2),
    MaDM INT
);

CREATE TABLE NhanVien (
    MaNV INT IDENTITY PRIMARY KEY,
    TenNV NVARCHAR(100),
    GioiTinh NVARCHAR(10), 
    DiaChi NVARCHAR(200),
    Email NVARCHAR(50), 
    SoDT NVARCHAR(10)
);

CREATE TABLE NhaCungCap (
    MaNCC INT IDENTITY PRIMARY KEY,
    TenNCC NVARCHAR(50),
    DiaChi NVARCHAR(200),
    Email NVARCHAR(50), 
    SoDT NVARCHAR(10)
);

CREATE TABLE HoaDonNhap (
    MaHDN INT IDENTITY PRIMARY KEY,
    MaNCC INT NOT NULL, 
    NgayNhap DATE NOT NULL,
    TongTien DECIMAL(18, 2) NOT NULL
);

CREATE TABLE ChiTietHoaDonNhap (
    MaCTHDN INT IDENTITY PRIMARY KEY,
    MaHDN INT NOT NULL, 
    MaSP INT NOT NULL,  
    SoLuong INT NOT NULL, 
    DonGiaNhap DECIMAL(18, 2) NOT NULL
);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_ChiTietHoaDon_HoaDon
FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_ChiTietHoaDon_SanPham
FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE TaiKhoan 
ADD CONSTRAINT FK_TaiKhoan_NhanVien
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE SanPham 
ADD CONSTRAINT FK_SanPham_DanhMuc
FOREIGN KEY (MaDM) REFERENCES DanhMuc(MaDM)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDonNhap
ADD CONSTRAINT FK_HoaDonNhap_NhaCungCap
FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE ChiTietHoaDonNhap
ADD CONSTRAINT FK_ChiTietHoaDonNhap_HoaDonNhap
FOREIGN KEY (MaHDN) REFERENCES HoaDonNhap(MaHDN)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE ChiTietHoaDonNhap
ADD CONSTRAINT FK_ChiTietHoaDonNhap_SanPham
FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (TenNV, GioiTinh, DiaChi, Email, SoDT) VALUES
(N'Trần Văn A', N'Nam', N'123 Nguyễn Văn Linh, Q7, TP HCM', N'tranvana@gmail.com', N'0909123456'),
(N'Nguyễn Thị B', N'Nữ', N'456 Lê Lợi, Q1, TP HCM', N'nguyenthib@gmail.com', N'0909765432'),
(N'Phạm Văn C', N'Nam', N'789 Hai Bà Trưng, Q3, TP HCM', N'phamvanc@gmail.com', N'0909123457'),
(N'Lê Thị D', N'Nữ', N'321 Điện Biên Phủ, Q10, TP HCM', N'lethid@gmail.com', N'0909765433'),
(N'Vũ Văn E', N'Nam', N'654 Cách Mạng Tháng 8, Q10, TP HCM', N'vuvane@gmail.com', N'0909123458'),
(N'Ngô Thị F', N'Nữ', N'987 Trần Hưng Đạo, Q5, TP HCM', N'ngothif@gmail.com', N'0909765434'),
(N'Đặng Văn G', N'Nam', N'123 Võ Văn Kiệt, Q1, TP HCM', N'dangvang@gmail.com', N'0909123459'),
(N'Bùi Thị H', N'Nữ', N'456 Lê Văn Sỹ, Q3, TP HCM', N'buithih@gmail.com', N'0909765435'),
(N'Phan Văn I', N'Nam', N'789 Nguyễn Thị Minh Khai, Q1, TP HCM', N'phanvani@gmail.com', N'0909123460'),
(N'Trịnh Thị K', N'Nữ', N'321 Võ Thị Sáu, Q3, TP HCM', N'trinhthik@gmail.com', N'0909765436');

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (TenTK, MatKhau, ChucVu, MaNV) VALUES
(N'admin', N'123', N'Quản lý', 1),
(N'tk2', N'123', N'Nhân viên', 2),
(N'tk3', N'123', N'Nhân viên', 3),
(N'tk4', N'123', N'Nhân viên', 4),
(N'tk5', N'123', N'Nhân viên', 5),
(N'tk6', N'123', N'Nhân viên', 6),
(N'tk7', N'123', N'Nhân viên', 7),
(N'tk8', N'123', N'Nhân viên', 8),
(N'tk9', N'123', N'Nhân viên', 9),
(N'tk10', N'123', N'Nhân viên', 10);

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (TenKH, GioiTinh, DiaChi, Email, SoDT) VALUES
(N'Nguyễn Văn L', N'Nam', N'123 Lý Thường Kiệt, Q10, TP HCM', N'nguyenvanl@gmail.com', N'0909123461'),
(N'Phạm Thị M', N'Nữ', N'456 Phan Đăng Lưu, Q5, TP HCM', N'phamthim@gmail.com', N'0909765437'),
(N'Lê Văn N', N'Nam', N'789 Đinh Tiên Hoàng, Q1, TP HCM', N'levann@gmail.com', N'0909123462'),
(N'Trần Thị O', N'Nữ', N'321 Võ Văn Tần, Q3, TP HCM', N'tranthio@gmail.com', N'0909765438'),
(N'Vũ Văn P', N'Nam', N'654 Nguyễn Văn Cừ, Q5, TP HCM', N'vuvanp@gmail.com', N'0909123463'),
(N'Ngô Thị Q', N'Nữ', N'987 Lạc Long Quân, Q11, TP HCM', N'ngothiq@gmail.com', N'0909765439'),
(N'Đặng Văn R', N'Nam', N'123 Trường Chinh, Q12, TP HCM', N'dangvanr@gmail.com', N'0909123464'),
(N'Bùi Thị S', N'Nữ', N'456 Âu Cơ, Q11, TP HCM', N'buithis@gmail.com', N'0909765440'),
(N'Phan Văn T', N'Nam', N'789 Phạm Văn Đồng, Q9, TP HCM', N'phanvant@gmail.com', N'0909123465'),
(N'Trịnh Thị U', N'Nữ', N'321 Hoàng Văn Thụ, Q10, TP HCM', N'trinhthiu@gmail.com', N'0909765441');

-- Thêm dữ liệu vào bảng DanhMuc
INSERT INTO DanhMuc (TenDM) VALUES
(N'Giày nam'),
(N'Giày nữ'),
(N'Giày trẻ em'),
(N'Giày thể thao'),
(N'Giày búp bê'),
(N'Giày cao gót'),
(N'Giày lười'),
(N'Giày tây'),
(N'Dép xỏ ngón'),
(N'Dép lê');

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO SanPham (TenSP, DonGiaNhap, DonGiaBan, MaDM) VALUES
(N'Giày nam da bò', 800000, 1000000, 1),
(N'Giày nữ cao gót', 700000, 900000, 6),
(N'Giày thể thao nam', 600000, 750000, 4),
(N'Giày búp bê nữ', 500000, 650000, 5),
(N'Giày trẻ em', 300000, 450000, 3),
(N'Dép xỏ ngón', 100000, 200000, 9),
(N'Dép lê', 50000, 100000, 10),
(N'Giày lười nam', 400000, 550000, 7),
(N'Giày tây nam', 1200000, 1500000, 8),
(N'Giày nữ thời trang', 900000, 1200000, 2);

-- Thêm dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (TenNCC, DiaChi, SoDT, Email) VALUES
(N'CTCP Giày ABC', N'123 Nguyễn Văn Linh, Q7, TP HCM', N'0909123451', N'giayabc@gmail.com'),
(N'CTCP Giày XYZ', N'456 Lê Lợi, Q1, TP HCM', N'0909123452', N'giayxyz@gmail.com'),
(N'CTCP Giày DEF', N'789 Hai Bà Trưng, Q3, TP HCM', N'0909123453', N'giaydef@gmail.com'),
(N'CTCP Giày GHI', N'321 Điện Biên Phủ, Q10, TP HCM', N'0909123454', N'giayghi@gmail.com'),
(N'CTCP Giày JKL', N'654 Cách Mạng Tháng 8, Q10, TP HCM', N'0909123455', N'giayjkl@gmail.com'),
(N'CTCP Giày MNO', N'987 Trần Hưng Đạo, Q5, TP HCM', N'0909123456', N'giaymno@gmail.com'),
(N'CTCP Giày PQR', N'123 Võ Văn Kiệt, Q1, TP HCM', N'0909123457', N'giaypqr@gmail.com'),
(N'CTCP Giày STU', N'456 Lê Văn Sỹ, Q3, TP HCM', N'0909123458', N'giaystu@gmail.com'),
(N'CTCP Giày VWX', N'789 Nguyễn Thị Minh Khai, Q1, TP HCM', N'0909123459', N'giayvwx@gmail.com'),
(N'CTCP Giày YZ', N'321 Võ Thị Sáu, Q3, TP HCM', N'0909123460', N'giayyz@gmail.com');

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaKH, MaNV, NgayMua, TrangThai, PTTT, TongTien) VALUES
(1, 1, '2024-12-01', N'Đã thanh toán', N'Tiền mặt', 1000000),
(2, 2, '2024-12-02', N'Đã thanh toán', N'Tiền mặt', 2000000),
(3, 3, '2024-12-03', N'Đã thanh toán', N'Tiền mặt', 1500000),
(4, 4, '2024-12-04', N'Đã thanh toán', N'Tiền mặt', 2500000),
(5, 5, '2024-12-05', N'Đã thanh toán', N'Chuyển khoản', 3000000),
(6, 6, '2024-12-06', N'Đã thanh toán', N'Tiền mặt', 3500000),
(7, 7, '2024-12-07', N'Đã thanh toán', N'Chuyển khoản', 4000000),
(8, 8, '2024-12-08', N'Đã thanh toán', N'Tiền mặt', 4500000),
(9, 9, '2024-12-09', N'Đã thanh toán', N'Tiền mặt', 5000000),
(10, 10, '2024-12-10', N'Đã thanh toán', N'Tiền mặt', 5500000);

-- Thêm dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, DonGiaBan) VALUES
(1, 1, 2, 500000),
(2, 2, 1, 2000000),
(3, 3, 3, 500000),
(4, 4, 2, 1250000),
(5, 5, 1, 3000000),
(6, 6, 2, 1750000),
(7, 7, 1, 4000000),
(8, 8, 3, 1500000),
(9, 9, 2, 2500000),
(10, 10, 1, 5500000);

-- Thêm dữ liệu vào bảng HoaDonNhap
INSERT INTO HoaDonNhap (MaNCC, NgayNhap, TongTien) VALUES
(1,'2024-12-01', 5000000),
(2,'2024-12-02', 6000000),
(3,'2024-12-03', 7000000),
(4,'2024-12-04', 8000000),
(5,'2024-12-05', 9000000),
(6,'2024-12-06', 10000000),
(7,'2024-12-07', 11000000),
(8,'2024-12-08', 12000000),
(9,'2024-12-09', 13000000),
(10,'2024-12-10', 14000000);

-- Thêm dữ liệu vào bảng ChiTietHoaDonNhap
INSERT INTO ChiTietHoaDonNhap (MaHDN, MaSP, SoLuong, DonGiaNhap) VALUES
(1, 1, 10, 500000),
(2, 2, 15, 400000),
(3, 3, 20, 350000),
(4, 4, 25, 300000),
(5, 5, 30, 300000),
(6, 6, 35, 285000),
(7, 7, 40, 250000),
(8, 8, 45, 220000),
(9, 9, 50, 200000),
(10, 10, 60, 190000);
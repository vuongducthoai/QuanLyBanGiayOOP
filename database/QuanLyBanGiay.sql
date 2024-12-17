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
    GioiTinh BIT, 
    DiaChi NVARCHAR(200),
    Email NVARCHAR(50), 
    SoDT NVARCHAR(10)
);

CREATE TABLE HoaDon (
    MaHD INT IDENTITY PRIMARY KEY,
    MaKH INT, 
    MaSP INT,
    NgayMua DATE,
    SoLuong INT,
    DonGiaBan DECIMAL(18, 2),
    TrangThai NVARCHAR(50), 
    PTTT NVARCHAR(40)
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
    GioiTinh BIT, 
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
    MaNCC INT,
    MaNV INT, 
    MaSP INT,
    NgayNhap DATE,
    SoLuong INT,
    DonGiaNhap DECIMAL(18, 2),
    TrangThai NVARCHAR(50),
);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_SanPham
FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDonNhap
ADD CONSTRAINT FK_HoaDonNhap_SanPham
FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDonNhap
ADD CONSTRAINT FK_HoaDonNhap_NhanVien
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE HoaDonNhap
ADD CONSTRAINT FK_HoaDonNhap_NhaCungCap
FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE TaiKhoan 
ADD CONSTRAINT Fk_NV_TK
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

ALTER TABLE SanPham 
ADD CONSTRAINT Fk_SP_DM
FOREIGN KEY (MaDM) REFERENCES DanhMuc(MaDM);

-- Thêm dữ liệu vào bảng DanhMuc
INSERT INTO DanhMuc (TenDM) VALUES 
(N'Giày Nam'),
(N'Giày Nữ'),
(N'Giày Thể Thao'),
(N'Giày Công Sở'),
(N'Giày Dã Ngoại');

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO SanPham (TenSP, DonGiaNhap, DonGiaBan, MaDM) VALUES 
(N'Giày Adidas Nam', 500000, 800000, 1),
(N'Giày Nike Nữ', 600000, 900000, 2),
(N'Giày Puma Thể Thao', 700000, 1100000, 3),
(N'Giày Vina Giày Công Sở', 450000, 650000, 4),
(N'Giày Converse Dã Ngoại', 550000, 750000, 5);

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (TenNV, GioiTinh, DiaChi, Email, SoDT) VALUES 
(N'Nguyễn Văn A', 1, N'Hà Nội', 'nguyenvana@example.com', '0987654321'),
(N'Trần Thị B', 0, N'Hồ Chí Minh', 'tranb@example.com', '0932123456'),
(N'Phan Văn C', 1, N'Đà Nẵng', 'phanvc@example.com', '0909876543'),
(N'Lê Thị D', 0, N'Cần Thơ', 'lethid@example.com', '0912345678');

-- Thêm dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (TenNCC, DiaChi, Email, SoDT) VALUES 
(N'Công Ty Giày ABC', N'Hà Nội', 'abc@giay.com', '0241234567'),
(N'Công Ty Giày XYZ', N'Hồ Chí Minh', 'xyz@giay.com', '0287654321');

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (TenKH, GioiTinh, DiaChi, Email, SoDT) VALUES 
(N'Nguyễn Văn E', 1, N'Hà Nội', 'nguyenvane@example.com', '0987654321'),
(N'Trần Thị F', 0, N'Hồ Chí Minh', 'tranf@example.com', '0932123456'),
(N'Phan Nguyễn G', 1, N'Đà Nẵng', 'phang@example.com', '0909876543'),
(N'Lê Thị H', 0, N'Cần Thơ', 'lethih@example.com', '0912345678');

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaKH, MaSP, NgayMua, SoLuong, DonGiaBan, TrangThai, PTTT) VALUES 
(1, 1, '2024-12-15', 2, 800000, N'Đã thanh toán', N'Chuyển khoản'),
(2, 2, '2024-12-16', 1, 900000, N'Chưa thanh toán', N'Tiền mặt'),
(3, 3, '2024-12-17', 1, 1100000, N'Đã thanh toán', N'Chuyển khoản'),
(4, 4, '2024-12-18', 3, 650000, N'Đã thanh toán', N'Tiền mặt');

-- Thêm dữ liệu vào bảng HoaDonNhap
INSERT INTO HoaDonNhap (MaNCC, MaNV, MaSP, NgayNhap, SoLuong, DonGiaNhap, TrangThai) VALUES 
(1, 1, 1, '2024-12-14', 100, 500000, N'Nhập kho thành công'),
(2, 2, 2, '2024-12-15', 200, 600000, N'Nhập kho thành công'),
(1, 3, 3, '2024-12-16', 150, 700000, N'Nhập kho thành công');

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (TenTK, MatKhau, ChucVu, MaNV) VALUES 
('admin', '123', N'Quản lý', 1),
('user1', '123', N'Nhân viên', 2),
('user2', '123', N'Nhân viên', 3);

SELECT * FROM TaiKhoan JOIN NhanVien ON TaiKhoan.MaNV = NhanVien.MaNV WHERE TaiKhoan.TenTK = 'admin';

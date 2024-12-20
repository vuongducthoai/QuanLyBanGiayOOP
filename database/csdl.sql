USE [master]
GO
/****** Object:  Database [QuanLyCuaHangBanGiay]    Script Date: 21/12/2024 8:15:56 SA ******/
CREATE DATABASE [QuanLyCuaHangBanGiay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyCuaHangBanGiay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyCuaHangBanGiay.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyCuaHangBanGiay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyCuaHangBanGiay_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyCuaHangBanGiay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyCuaHangBanGiay', N'ON'
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyCuaHangBanGiay]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaCTHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGiaBan] [decimal](18, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonNhap]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonNhap](
	[MaCTHDN] [int] IDENTITY(1,1) NOT NULL,
	[MaHDN] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGiaNhap] [decimal](18, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDM] [int] IDENTITY(1,1) NOT NULL,
	[TenDM] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[NgayMua] [date] NOT NULL,
	[TrangThai] [nvarchar](50) NULL,
	[PTTT] [nvarchar](40) NULL,
	[TongTien] [decimal](18, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonNhap]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonNhap](
	[MaHDN] [int] IDENTITY(1,1) NOT NULL,
	[MaNCC] [int] NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[TongTien] [decimal](18, 2) NULL,
	[MaNV] [int] NULL,
	[TrangThai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[TenKH] [nvarchar](100) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [int] IDENTITY(1,1) NOT NULL,
	[TenNCC] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] IDENTITY(1,1) NOT NULL,
	[TenNV] [nvarchar](100) NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Email] [nvarchar](50) NULL,
	[SoDT] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [int] IDENTITY(1,1) NOT NULL,
	[TenSP] [nvarchar](100) NULL,
	[DonGiaNhap] [decimal](18, 2) NULL,
	[DonGiaBan] [decimal](18, 2) NULL,
	[MaDM] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 21/12/2024 8:15:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTK] [nvarchar](100) NOT NULL,
	[MatKhau] [nvarchar](100) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[MaNV] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[TenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (1, 1, 1, 2, CAST(1000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (2, 2, 2, 1, CAST(900.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (3, 3, 3, 3, CAST(500.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (4, 4, 4, 2, CAST(1250.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (5, 5, 5, 1, CAST(450.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (6, 6, 6, 2, CAST(200.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (7, 7, 7, 1, CAST(100.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (8, 8, 8, 3, CAST(550.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (9, 9, 9, 2, CAST(1500.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (10, 10, 10, 1, CAST(1200.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (11, 2, 1, 1, CAST(1000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (12, 13, 1, 2, CAST(1000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (13, 13, 5, 1, CAST(450.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (15, 12, 10, 1, CAST(1200.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (16, 14, 11, 2, CAST(1000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [DonGiaBan]) VALUES (17, 14, 10, 2, CAST(1200.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDonNhap] ON 

INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (40, 37, 1, 10, CAST(800.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (41, 38, 2, 15, CAST(700.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (42, 39, 3, 20, CAST(300.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (43, 40, 4, 25, CAST(500.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (44, 41, 5, 30, CAST(300.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (45, 42, 6, 35, CAST(100.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (46, 43, 7, 40, CAST(50.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (47, 44, 8, 45, CAST(400.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (48, 45, 9, 50, CAST(1200.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (49, 46, 10, 60, CAST(900.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (50, 38, 14, 100, CAST(10000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (51, 38, 15, 100, CAST(10000.00 AS Decimal(18, 2)))
INSERT [dbo].[ChiTietHoaDonNhap] ([MaCTHDN], [MaHDN], [MaSP], [SoLuong], [DonGiaNhap]) VALUES (52, 38, 16, 100, CAST(10000.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[ChiTietHoaDonNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[DanhMuc] ON 

INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (1, N'Giày nam')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (2, N'Giày nữ')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (3, N'Giày trẻ em')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (4, N'Giày thể thao')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (5, N'Giày búp bê')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (6, N'Giày cao gót')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (7, N'Giày lười')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (8, N'Giày tây')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (9, N'Dép xỏ ngón')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (10, N'Dép lê')
SET IDENTITY_INSERT [dbo].[DanhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (1, 1, 1, CAST(N'2024-12-01' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(2000.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (2, 2, 2, CAST(N'2024-12-02' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(1900.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (3, 3, 3, CAST(N'2024-12-03' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(1500.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (4, 4, 4, CAST(N'2024-12-04' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(2500.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (5, 5, 5, CAST(N'2024-12-05' AS Date), N'Đã thanh toán', N'Chuyển khoản', CAST(450.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (6, 6, 6, CAST(N'2024-12-06' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(400.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (7, 7, 7, CAST(N'2024-12-07' AS Date), N'Đã thanh toán', N'Chuyển khoản', CAST(100.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (8, 8, 8, CAST(N'2024-12-08' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(1650.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (9, 9, 9, CAST(N'2024-12-09' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(3000.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (10, 10, 10, CAST(N'2024-12-10' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(1200.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (12, 10, 10, CAST(N'2024-12-10' AS Date), N'Chưa thanh toán', N'Chuyển khoản', CAST(1200.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (13, 10, 10, CAST(N'2024-12-02' AS Date), N'Đã thanh toán', N'Tiền mặt', CAST(2450.00 AS Decimal(18, 2)))
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayMua], [TrangThai], [PTTT], [TongTien]) VALUES (14, 1, 1, CAST(N'2024-12-20' AS Date), N'Đã thanh toán', N'Chuyển khoản', CAST(4400.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonNhap] ON 

INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (37, 1, CAST(N'2024-12-01' AS Date), CAST(8000.00 AS Decimal(18, 2)), 1, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (38, 2, CAST(N'2024-12-02' AS Date), CAST(3010500.00 AS Decimal(18, 2)), 2, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (39, 3, CAST(N'2024-12-03' AS Date), CAST(6000.00 AS Decimal(18, 2)), 3, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (40, 4, CAST(N'2024-12-04' AS Date), CAST(12500.00 AS Decimal(18, 2)), 4, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (41, 5, CAST(N'2024-12-05' AS Date), CAST(9000.00 AS Decimal(18, 2)), 5, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (42, 6, CAST(N'2024-12-06' AS Date), CAST(3500.00 AS Decimal(18, 2)), 6, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (43, 7, CAST(N'2024-12-07' AS Date), CAST(2000.00 AS Decimal(18, 2)), 7, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (44, 8, CAST(N'2024-12-08' AS Date), CAST(18000.00 AS Decimal(18, 2)), 8, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (45, 9, CAST(N'2024-12-09' AS Date), CAST(60000.00 AS Decimal(18, 2)), 9, N'ĐÃ THANH TOÁN')
INSERT [dbo].[HoaDonNhap] ([MaHDN], [MaNCC], [NgayNhap], [TongTien], [MaNV], [TrangThai]) VALUES (46, 10, CAST(N'2024-12-10' AS Date), CAST(540000.00 AS Decimal(18, 2)), 10, N'ĐÃ THANH TOÁN')
SET IDENTITY_INSERT [dbo].[HoaDonNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (1, N'Nguyễn Văn L', N'Nam', N'123 Lý Thường Kiệt, Q10, TP HCM', N'nguyenvanl@gmail.com', N'0909123461')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (2, N'Phạm Thị M', N'Nữ', N'456 Phan Đăng Lưu, Q5, TP HCM', N'phamthim@gmail.com', N'0909765437')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (3, N'Lê Văn N', N'Nam', N'789 Đinh Tiên Hoàng, Q1, TP HCM', N'levann@gmail.com', N'0909123462')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (4, N'Trần Thị O', N'Nữ', N'321 Võ Văn Tần, Q3, TP HCM', N'tranthio@gmail.com', N'0909765438')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (5, N'Vũ Văn P', N'Nam', N'654 Nguyễn Văn Cừ, Q5, TP HCM', N'vuvanp@gmail.com', N'0909123463')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (6, N'Ngô Thị Q', N'Nữ', N'987 Lạc Long Quân, Q11, TP HCM', N'ngothiq@gmail.com', N'0909765439')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (7, N'Đặng Văn R', N'Nam', N'123 Trường Chinh, Q12, TP HCM', N'dangvanr@gmail.com', N'0909123464')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (8, N'Bùi Thị S', N'Nữ', N'456 Âu Cơ, Q11, TP HCM', N'buithis@gmail.com', N'0909765440')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (9, N'Phan Văn T', N'Nam', N'789 Phạm Văn Đồng, Q9, TP HCM', N'phanvant@gmail.com', N'0909123465')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (10, N'Trịnh Thị U', N'Nữ', N'321 Hoàng Văn Thụ, Q10, TP HCM', N'trinhthiu@gmail.com', N'0909765441')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (1, N'CTCP Giày ABC', N'123 Nguyễn Văn Linh, Q7, TP HCM', N'giayabc@gmail.com', N'0909123451')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (2, N'CTCP Giày XYZ', N'456 Lê Lợi, Q1, TP HCM', N'giayxyz@gmail.com', N'0909123452')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (3, N'CTCP Giày DEF', N'789 Hai Bà Trưng, Q3, TP HCM', N'giaydef@gmail.com', N'0909123453')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (4, N'CTCP Giày GHI', N'321 Điện Biên Phủ, Q10, TP HCM', N'giayghi@gmail.com', N'0909123454')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (5, N'CTCP Giày JKL', N'654 Cách Mạng Tháng 8, Q10, TP HCM', N'giayjkl@gmail.com', N'0909123455')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (6, N'CTCP Giày MNO', N'987 Trần Hưng Đạo, Q5, TP HCM', N'giaymno@gmail.com', N'0909123456')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (7, N'CTCP Giày PQR', N'123 Võ Văn Kiệt, Q1, TP HCM', N'giaypqr@gmail.com', N'0909123457')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (8, N'CTCP Giày STU', N'456 Lê Văn Sỹ, Q3, TP HCM', N'giaystu@gmail.com', N'0909123458')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (9, N'CTCP Giày VWX', N'789 Nguyễn Thị Minh Khai, Q1, TP HCM', N'giayvwx@gmail.com', N'0909123459')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [Email], [SoDT]) VALUES (10, N'CTCP Giày YZ', N'321 Võ Thị Sáu, Q3, TP HCM', N'giayyz@gmail.com', N'0909123460')
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (1, N'Trần Văn A', N'Nam', N'123 Nguyễn Văn Linh, Q7, TP HCM', N'tranvana@gmail.com', N'0909123456')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (2, N'Nguyễn Thị B', N'Nữ', N'456 Lê Lợi, Q1, TP HCM', N'nguyenthib@gmail.com', N'0909765432')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (3, N'Phạm Văn C', N'Nam', N'789 Hai Bà Trưng, Q3, TP HCM', N'phamvanc@gmail.com', N'0909123457')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (4, N'Lê Thị D', N'Nữ', N'321 Điện Biên Phủ, Q10, TP HCM', N'lethid@gmail.com', N'0909765433')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (5, N'Vũ Văn E', N'Nam', N'654 Cách Mạng Tháng 8, Q10, TP HCM', N'vuvane@gmail.com', N'0909123458')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (6, N'Ngô Thị F', N'Nữ', N'987 Trần Hưng Đạo, Q5, TP HCM', N'ngothif@gmail.com', N'0909765434')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (7, N'Đặng Văn G', N'Nam', N'123 Võ Văn Kiệt, Q1, TP HCM', N'dangvang@gmail.com', N'0909123459')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (8, N'Bùi Thị H', N'Nữ', N'456 Lê Văn Sỹ, Q3, TP HCM', N'buithih@gmail.com', N'0909765435')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (9, N'Phan Văn I', N'Nam', N'789 Nguyễn Thị Minh Khai, Q1, TP HCM', N'phanvani@gmail.com', N'0909123460')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [Email], [SoDT]) VALUES (10, N'Trịnh Thị K', N'Nữ', N'321 Võ Thị Sáu, Q3, TP HCM', N'trinhthik@gmail.com', N'0909765436')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (1, N'Giày nam da bò', CAST(800.00 AS Decimal(18, 2)), CAST(1000.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (2, N'Giày nữ cao gót', CAST(700.00 AS Decimal(18, 2)), CAST(900.00 AS Decimal(18, 2)), 6)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (3, N'Giày thể thao nam', CAST(300.00 AS Decimal(18, 2)), CAST(500.00 AS Decimal(18, 2)), 4)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (4, N'Giày búp bê nữ', CAST(500.00 AS Decimal(18, 2)), CAST(1250.00 AS Decimal(18, 2)), 5)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (5, N'Giày trẻ em', CAST(300.00 AS Decimal(18, 2)), CAST(450.00 AS Decimal(18, 2)), 3)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (6, N'Dép xỏ ngón', CAST(100.00 AS Decimal(18, 2)), CAST(200.00 AS Decimal(18, 2)), 9)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (7, N'Dép lê', CAST(50.00 AS Decimal(18, 2)), CAST(100.00 AS Decimal(18, 2)), 10)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (8, N'Giày lười nam', CAST(400.00 AS Decimal(18, 2)), CAST(550.00 AS Decimal(18, 2)), 7)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (9, N'Giày tây nam', CAST(1200.00 AS Decimal(18, 2)), CAST(1500.00 AS Decimal(18, 2)), 8)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (10, N'Giày nữ thời trang', CAST(900.00 AS Decimal(18, 2)), CAST(1200.00 AS Decimal(18, 2)), 2)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (11, N'Giày Chelsea boots cổ cao', CAST(500.00 AS Decimal(18, 2)), CAST(1000.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (14, N'Giay adidas nam', CAST(10000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (15, N'Giay adidas nu', CAST(10000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [DonGiaNhap], [DonGiaBan], [MaDM]) VALUES (16, N'Giay thể thao', CAST(10000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), 1)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'admin', N'123', N'Quản lý', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk10', N'123', N'Nhân viên', 10)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk2', N'123', N'Nhân viên', 2)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk3', N'123', N'Nhân viên', 3)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk4', N'123', N'Nhân viên', 4)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk5', N'123', N'Nhân viên', 5)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk6', N'123', N'Nhân viên', 6)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk7', N'123', N'Nhân viên', 7)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk8', N'123', N'Nhân viên', 8)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tk9', N'123', N'Nhân viên', 9)
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDonNhap_HoaDonNhap] FOREIGN KEY([MaHDN])
REFERENCES [dbo].[HoaDonNhap] ([MaHDN])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDonNhap] CHECK CONSTRAINT [FK_ChiTietHoaDonNhap_HoaDonNhap]
GO
ALTER TABLE [dbo].[ChiTietHoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDonNhap_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDonNhap] CHECK CONSTRAINT [FK_ChiTietHoaDonNhap_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMuc] FOREIGN KEY([MaDM])
REFERENCES [dbo].[DanhMuc] ([MaDM])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMuc]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QuanLyCuaHangBanGiay] SET  READ_WRITE 
GO

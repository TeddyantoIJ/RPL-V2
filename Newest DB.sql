USE [master]
GO
/****** Object:  Database [PT_KMF]    Script Date: 16/06/2020 21:07:08 ******/
CREATE DATABASE [PT_KMF]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PT_KMF', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\PT_KMF.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PT_KMF_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\PT_KMF_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PT_KMF] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PT_KMF].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PT_KMF] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PT_KMF] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PT_KMF] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PT_KMF] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PT_KMF] SET ARITHABORT OFF 
GO
ALTER DATABASE [PT_KMF] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PT_KMF] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PT_KMF] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PT_KMF] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PT_KMF] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PT_KMF] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PT_KMF] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PT_KMF] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PT_KMF] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PT_KMF] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PT_KMF] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PT_KMF] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PT_KMF] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PT_KMF] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PT_KMF] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PT_KMF] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PT_KMF] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PT_KMF] SET RECOVERY FULL 
GO
ALTER DATABASE [PT_KMF] SET  MULTI_USER 
GO
ALTER DATABASE [PT_KMF] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PT_KMF] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PT_KMF] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PT_KMF] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PT_KMF] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PT_KMF] SET QUERY_STORE = OFF
GO
USE [PT_KMF]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [PT_KMF]
GO
/****** Object:  Table [dbo].[Bagging]    Script Date: 16/06/2020 21:07:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bagging](
	[id_bagging] [varchar](18) NOT NULL,
	[jumlah] [int] NULL,
	[berat] [int] NULL,
	[tanggal] [date] NULL,
	[status_bagging] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_bagging] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CargoManifest]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CargoManifest](
	[id_cargo_manifest] [varchar](10) NOT NULL,
	[nomor_registrasi] [varchar](15) NULL,
	[nomor_penerbangan] [varchar](15) NULL,
	[kota_asal] [varchar](25) NULL,
	[kota_tujuan] [varchar](25) NULL,
	[tanggal_pemberangkatan] [date] NULL,
	[waktu_pemberangkatan] [time](7) NULL,
	[tanggal_sampai] [date] NULL,
	[waktu_sampai] [time](7) NULL,
	[jumlah_kantong] [int] NULL,
	[berat_barang_total] [int] NULL,
	[total_biaya] [money] NULL,
	[status] [varchar](6) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_cargo_manifest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Connote]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Connote](
	[id_connote] [varchar](16) NOT NULL,
	[id_pemesanan] [varchar](21) NULL,
	[kantor_cabang] [varchar](20) NULL,
	[tgl_connote] [date] NULL,
	[status_pengiriman] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_connote] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerService]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerService](
	[id_staff] [varchar](10) NOT NULL,
	[nama_staff] [varchar](20) NOT NULL,
	[alamat_staff] [varchar](50) NOT NULL,
	[tgl_lahir] [date] NOT NULL,
	[no_telphone] [varchar](13) NOT NULL,
	[email] [varchar](25) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status_aktif] [varchar](10) NULL,
	[id_dept] [varchar](10) NULL,
	[kode_kantor_cabang] [varchar](10) NULL,
 CONSTRAINT [PK_CustomerSevice] PRIMARY KEY CLUSTERED 
(
	[id_staff] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DataBarangPelanggan]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DataBarangPelanggan](
	[id_pemesanan] [varchar](21) NOT NULL,
	[id_pelanggan] [varchar](10) NOT NULL,
	[jenis_barang] [varchar](20) NULL,
	[berat_barang] [int] NULL,
	[keterangan_barang] [varchar](100) NULL,
	[jns_id] [varchar](10) NOT NULL,
	[nama_penerima] [varchar](30) NULL,
	[alamat_penerima] [varchar](100) NULL,
	[kota_penerima] [varchar](25) NULL,
	[no_telphone_penerima] [varchar](13) NULL,
	[keterangan] [varchar](100) NULL,
	[pickup] [varchar](10) NULL,
	[tanggal] [date] NULL,
	[waktu] [time](7) NULL,
	[total_harga] [int] NULL,
	[keterangan_pembayaran] [varchar](5) NULL,
	[status_barang] [varchar](50) NULL,
	[id_staff] [varchar](10) NOT NULL,
	[kode_kantor_cabang] [varchar](10) NOT NULL,
 CONSTRAINT [PK_DataBarangPelanggan] PRIMARY KEY CLUSTERED 
(
	[id_pemesanan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departement]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departement](
	[id_dept] [varchar](10) NOT NULL,
	[nama_dept] [varchar](50) NULL,
	[pass_dept] [varchar](25) NULL,
 CONSTRAINT [PK_Departement] PRIMARY KEY CLUSTERED 
(
	[id_dept] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detailBagging]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detailBagging](
	[number] [int] IDENTITY(1,1) NOT NULL,
	[id_bagging] [varchar](18) NULL,
	[id_connote] [varchar](16) NULL,
	[status_barang_bagging] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detailCargo]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detailCargo](
	[number] [int] IDENTITY(1,1) NOT NULL,
	[id_bagging] [varchar](18) NULL,
	[id_cargo_manifest] [varchar](10) NULL,
	[status_barang_cargo] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detailPickUp]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detailPickUp](
	[ID_Staff] [varchar](10) NULL,
	[id_pemesanan] [varchar](21) NULL,
	[keterangan] [varchar](100) NULL,
	[alamat_penjemputan] [varchar](100) NULL,
	[kota_penjemputan] [varchar](25) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Driver]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Driver](
	[ID_Staff] [varchar](10) NOT NULL,
	[nama_staff] [varchar](25) NOT NULL,
	[alamat_staff] [varchar](50) NOT NULL,
	[tgl_lahir] [date] NOT NULL,
	[no_telphone] [varchar](13) NOT NULL,
	[email] [varchar](25) NOT NULL,
	[Status_pickup] [varchar](20) NOT NULL,
	[status_aktif] [varchar](10) NULL,
	[kode_kantor_cabang] [varchar](10) NULL,
	[id_dept] [varchar](10) NULL,
 CONSTRAINT [PK_Driver] PRIMARY KEY CLUSTERED 
(
	[ID_Staff] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JenisPaket]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JenisPaket](
	[jns_id] [varchar](10) NOT NULL,
	[jns_nama] [varchar](20) NULL,
	[jns_est] [int] NULL,
	[jns_harga] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[jns_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KantorCabang]    Script Date: 16/06/2020 21:07:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KantorCabang](
	[kode_kantor_cabang] [varchar](10) NOT NULL,
	[nama_kantor] [varchar](25) NOT NULL,
	[telphone] [varchar](13) NOT NULL,
	[alamat] [varchar](50) NOT NULL,
	[status_aktif] [varchar](10) NULL,
	[kota] [varchar](4) NULL,
 CONSTRAINT [PK_KantorCabang] PRIMARY KEY CLUSTERED 
(
	[kode_kantor_cabang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KotaKabupaten]    Script Date: 16/06/2020 21:07:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KotaKabupaten](
	[singkatan] [char](4) NOT NULL,
	[nama_kota] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[singkatan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pelanggan]    Script Date: 16/06/2020 21:07:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pelanggan](
	[id_pelanggan] [varchar](10) NOT NULL,
	[nama_pelanggan] [varchar](50) NULL,
	[alamat_pelanggan] [varchar](50) NULL,
	[provinsi_pelanggan] [varchar](25) NULL,
	[no_telphone] [varchar](13) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_pelanggan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Riwayat]    Script Date: 16/06/2020 21:07:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Riwayat](
	[id_riwayat] [int] IDENTITY(1,1) NOT NULL,
	[tanggal_riwayat] [date] NULL,
	[jam] [time](7) NULL,
	[keterangan_riwayat] [varchar](50) NULL,
	[id_pemesanan] [varchar](21) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_riwayat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 16/06/2020 21:07:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[id_staff] [varchar](10) NOT NULL,
	[nama_staff] [varchar](20) NOT NULL,
	[alamat_staff] [varchar](50) NOT NULL,
	[tgl_lahir] [date] NOT NULL,
	[no_telphone] [varchar](13) NOT NULL,
	[email] [varchar](25) NOT NULL,
	[status_aktif] [varchar](10) NULL,
	[kode_kantor_cabang] [varchar](10) NULL,
	[id_dept] [varchar](10) NULL,
 CONSTRAINT [PK_Staff] PRIMARY KEY CLUSTERED 
(
	[id_staff] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Bagging] ([id_bagging], [jumlah], [berat], [tanggal], [status_bagging]) VALUES (N'KC003-202006120001', 1, 3, CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[CargoManifest] ([id_cargo_manifest], [nomor_registrasi], [nomor_penerbangan], [kota_asal], [kota_tujuan], [tanggal_pemberangkatan], [waktu_pemberangkatan], [tanggal_sampai], [waktu_sampai], [jumlah_kantong], [berat_barang_total], [total_biaya], [status]) VALUES (N'CRG-0001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Sampai')
INSERT [dbo].[CargoManifest] ([id_cargo_manifest], [nomor_registrasi], [nomor_penerbangan], [kota_asal], [kota_tujuan], [tanggal_pemberangkatan], [waktu_pemberangkatan], [tanggal_sampai], [waktu_sampai], [jumlah_kantong], [berat_barang_total], [total_biaya], [status]) VALUES (N'CRG-0002', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Sampai')
INSERT [dbo].[CargoManifest] ([id_cargo_manifest], [nomor_registrasi], [nomor_penerbangan], [kota_asal], [kota_tujuan], [tanggal_pemberangkatan], [waktu_pemberangkatan], [tanggal_sampai], [waktu_sampai], [jumlah_kantong], [berat_barang_total], [total_biaya], [status]) VALUES (N'CRG-0003', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Gagal')
INSERT [dbo].[CargoManifest] ([id_cargo_manifest], [nomor_registrasi], [nomor_penerbangan], [kota_asal], [kota_tujuan], [tanggal_pemberangkatan], [waktu_pemberangkatan], [tanggal_sampai], [waktu_sampai], [jumlah_kantong], [berat_barang_total], [total_biaya], [status]) VALUES (N'CRG-0004', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Sampai')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061201490001', N'2020061121060001-BKSI', NULL, CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061201490002', N'2020061200340001-BGOR', NULL, CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061201490003', N'2020061201370001-AMBN', NULL, CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061211170004', N'2020061211150001-PMLG', N'KC001', CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061211180005', N'2020061211160001-PMLG', N'KC001', CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[Connote] ([id_connote], [id_pemesanan], [kantor_cabang], [tgl_connote], [status_pengiriman]) VALUES (N'2020061211180006', N'2020061211170001-PMLG', N'KC001', CAST(N'2020-06-12' AS Date), N'Belum')
INSERT [dbo].[CustomerService] ([id_staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [username], [password], [status_aktif], [id_dept], [kode_kantor_cabang]) VALUES (N'CS-0001', N'RAFLI', N'JAKARTA', CAST(N'2000-01-01' AS Date), N'08888888', N'RAFLI@AB.C', N'rafli', N'rafli123', N'Aktif', NULL, N'KC001')
INSERT [dbo].[CustomerService] ([id_staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [username], [password], [status_aktif], [id_dept], [kode_kantor_cabang]) VALUES (N'CS-0002', N'satria', N'jaktim', CAST(N'2020-06-19' AS Date), N'0888888', N'asds@gmail.com', N'satria', N'satria123', N'Aktif', NULL, N'KC001')
INSERT [dbo].[CustomerService] ([id_staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [username], [password], [status_aktif], [id_dept], [kode_kantor_cabang]) VALUES (N'CS-0003', N'Teddy', N'Kauman', CAST(N'2000-09-27' AS Date), N'0895606425999', N'teddyanto.ij@gmail.com', N'Teddy', N'Teddy123', N'Aktif', N'DPT-0005', N'KC002')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061121060001-BKSI', N'PLGN-0001', N'Elektronik', 2, N'-', N'PKT-0001', N'Jamal', N'Tambun', N'Bekasi', N'0895606425999', N'Tidak Sama, berat berlebihan', N'Non-Pickup', CAST(N'2020-11-06' AS Date), CAST(N'09:06:48' AS Time), 50000, N'LUNAS', N'Barang siap berangkat', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061200340001-BGOR', N'PLGN-0001', N'asd', 1, N'asd', N'PKT-0001', N'asd', N'asd', N'Bogor', N'123', N'asd', N'Non-Pickup', CAST(N'2020-12-06' AS Date), CAST(N'12:35:17' AS Time), 25000, N'LUNAS', N'Barang siap berangkat', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061201370001-AMBN', N'PLGN-0001', N'A', 1, N'A', N'PKT-0001', N'A', N'A', N'Ambon', N'0', N'-', N'Non-Pickup', CAST(N'2020-12-06' AS Date), CAST(N'01:37:23' AS Time), 25000, N'LUNAS', N'Barang siap berangkat', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061211150001-PMLG', N'PLGN-0001', N'Elektronik', 3, N'-', N'PKT-0001', N'Jamal', N'Comal', N'Pemalang', N'0895606425999', N'-', N'Non-Pickup', CAST(N'2020-12-06' AS Date), CAST(N'11:15:53' AS Time), 75000, N'LUNAS', N'Diterima oleh Jamal', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061211160001-PMLG', N'PLGN-0001', N'FURNITURE', 4, N'-', N'PKT-0002', N'Andini', N'Ulujami', N'Pemalang', N'08888', N'', N'Non-Pickup', CAST(N'2020-12-06' AS Date), CAST(N'11:16:25' AS Time), 72000, N'LUNAS', N'Diterima oleh Rini RT Setempat', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061211170001-PMLG', N'PLGN-0001', N'Kendaraan', 11, N'-', N'PKT-0004', N'Kori', N'Ujunggede', N'Pemalang', N'088888', N'-', N'Non-Pickup', CAST(N'2020-12-06' AS Date), CAST(N'11:17:08' AS Time), 132000, N'LUNAS', N'Diterima oleh Kori', N'CS-0001', N'KC001')
INSERT [dbo].[DataBarangPelanggan] ([id_pemesanan], [id_pelanggan], [jenis_barang], [berat_barang], [keterangan_barang], [jns_id], [nama_penerima], [alamat_penerima], [kota_penerima], [no_telphone_penerima], [keterangan], [pickup], [tanggal], [waktu], [total_harga], [keterangan_pembayaran], [status_barang], [id_staff], [kode_kantor_cabang]) VALUES (N'2020061620440001-JKRT', N'PLGN-0001', N'Barang Percobaan', 3, N'Ini percobaan aja', N'PKT-0001', N'Jamal', N'Jakarta Kota', N'Jakarta', N'0888888888888', N'-', N'Pickup', CAST(N'2020-06-16' AS Date), CAST(N'08:44:39' AS Time), 85000, N'BELUM', N'-', N'CS-0001', N'KC001')
INSERT [dbo].[Departement] ([id_dept], [nama_dept], [pass_dept]) VALUES (N'DPT-0001', N'Dispatch', N'Dispatch123')
INSERT [dbo].[Departement] ([id_dept], [nama_dept], [pass_dept]) VALUES (N'DPT-0002', N'Driver', N'')
INSERT [dbo].[Departement] ([id_dept], [nama_dept], [pass_dept]) VALUES (N'DPT-0003', N'Pencetak Connote', N'Connote123')
INSERT [dbo].[Departement] ([id_dept], [nama_dept], [pass_dept]) VALUES (N'DPT-0004', N'Staff', N'Staff123')
INSERT [dbo].[Departement] ([id_dept], [nama_dept], [pass_dept]) VALUES (N'DPT-0005', N'Customer Service', N'')
SET IDENTITY_INSERT [dbo].[detailBagging] ON 

INSERT [dbo].[detailBagging] ([number], [id_bagging], [id_connote], [status_barang_bagging]) VALUES (1, N'KC003-202006120001', N'2020061211170004', N'Akan dikirim')
SET IDENTITY_INSERT [dbo].[detailBagging] OFF
SET IDENTITY_INSERT [dbo].[detailCargo] ON 

INSERT [dbo].[detailCargo] ([number], [id_bagging], [id_cargo_manifest], [status_barang_cargo]) VALUES (1, N'KC003-202006120001', N'CRG-0004', N'Akan dikirim')
INSERT [dbo].[detailCargo] ([number], [id_bagging], [id_cargo_manifest], [status_barang_cargo]) VALUES (2, N'KC003-202006120001', N'CRG-0004', N'Akan dikirim')
INSERT [dbo].[detailCargo] ([number], [id_bagging], [id_cargo_manifest], [status_barang_cargo]) VALUES (3, N'KC003-202006120001', N'CRG-0004', N'Akan dikirim')
SET IDENTITY_INSERT [dbo].[detailCargo] OFF
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0001', N'TEDDY', N'JAKARTA', CAST(N'2000-09-22' AS Date), N'089560642599', N'teddyanto.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0002', N'SATRIA', N'PALEMBANG', CAST(N'2001-09-22' AS Date), N'089123324599', N'tasdo.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0003', N'RAFLI', N'JOGJA', CAST(N'2003-07-22' AS Date), N'08956a123259', N'tsdyanto.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0004', N'PURAM', N'BEKASI', CAST(N'2005-06-10' AS Date), N'089560144219', N'tedt2snto.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0005', N'TREY', N'TAMBUN', CAST(N'2003-05-09' AS Date), N'089560124214', N'ted23to.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0006', N'IZZAH', N'BOGOR', CAST(N'2003-04-14' AS Date), N'089555555559', N'teddyacasij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[Driver] ([ID_Staff], [nama_staff], [alamat_staff], [tgl_lahir], [no_telphone], [email], [Status_pickup], [status_aktif], [kode_kantor_cabang], [id_dept]) VALUES (N'DRV-0007', N'MR. X', N'BANDUNG', CAST(N'2002-10-03' AS Date), N'084444444449', N't5.ij@gmail.com', N'Tidak aktif', N'Aktif', N'KC001', NULL)
INSERT [dbo].[JenisPaket] ([jns_id], [jns_nama], [jns_est], [jns_harga]) VALUES (N'PKT-0001', N'Expres Super', 1, 25000.0000)
INSERT [dbo].[JenisPaket] ([jns_id], [jns_nama], [jns_est], [jns_harga]) VALUES (N'PKT-0002', N'Express', 3, 18000.0000)
INSERT [dbo].[JenisPaket] ([jns_id], [jns_nama], [jns_est], [jns_harga]) VALUES (N'PKT-0003', N'Normal', 5, 12000.0000)
INSERT [dbo].[JenisPaket] ([jns_id], [jns_nama], [jns_est], [jns_harga]) VALUES (N'PKT-0004', N'Kilat', 1, 12000.0000)
INSERT [dbo].[KantorCabang] ([kode_kantor_cabang], [nama_kantor], [telphone], [alamat], [status_aktif], [kota]) VALUES (N'KC001', N'KMF JKT', N'0888888888001', N'Jakarta Selatan', N'1', N'JKRT')
INSERT [dbo].[KantorCabang] ([kode_kantor_cabang], [nama_kantor], [telphone], [alamat], [status_aktif], [kota]) VALUES (N'KC002', N'KMF TAMBUN', N'0888888888002', N'Tambun Selatan', N'1', N'BKSI')
INSERT [dbo].[KantorCabang] ([kode_kantor_cabang], [nama_kantor], [telphone], [alamat], [status_aktif], [kota]) VALUES (N'KC003', N'KMF PEMALANG', N'0888888888003', N'Pemalang', N'1', N'PMLG')
INSERT [dbo].[KantorCabang] ([kode_kantor_cabang], [nama_kantor], [telphone], [alamat], [status_aktif], [kota]) VALUES (N'KC004', N'KMF PALEMBANG', N'0888888888004', N'Palembang', N'1', N'PLMB')
INSERT [dbo].[KotaKabupaten] ([singkatan], [nama_kota]) VALUES (N'BKSI', N'Bekasi')
INSERT [dbo].[KotaKabupaten] ([singkatan], [nama_kota]) VALUES (N'JKRT', N'Jakarta')
INSERT [dbo].[KotaKabupaten] ([singkatan], [nama_kota]) VALUES (N'PLMB', N'Palembang')
INSERT [dbo].[KotaKabupaten] ([singkatan], [nama_kota]) VALUES (N'PMLG', N'Pemalang')
INSERT [dbo].[Pelanggan] ([id_pelanggan], [nama_pelanggan], [alamat_pelanggan], [provinsi_pelanggan], [no_telphone]) VALUES (N'PLGN-0001', N'TEDDY', N'', N'', N'')
INSERT [dbo].[Pelanggan] ([id_pelanggan], [nama_pelanggan], [alamat_pelanggan], [provinsi_pelanggan], [no_telphone]) VALUES (N'PLGN-0002', N'', N'', N'', N'')
INSERT [dbo].[Pelanggan] ([id_pelanggan], [nama_pelanggan], [alamat_pelanggan], [provinsi_pelanggan], [no_telphone]) VALUES (N'PLGN-0003', N'', N'', N'', N'')
INSERT [dbo].[Pelanggan] ([id_pelanggan], [nama_pelanggan], [alamat_pelanggan], [provinsi_pelanggan], [no_telphone]) VALUES (N'PLGN-0004', N'', N'', N'', N'')
SET IDENTITY_INSERT [dbo].[Riwayat] ON 

INSERT [dbo].[Riwayat] ([id_riwayat], [tanggal_riwayat], [jam], [keterangan_riwayat], [id_pemesanan]) VALUES (1, CAST(N'2020-06-15' AS Date), CAST(N'06:06:42' AS Time), N'Diterima oleh Rini RT Setempat', N'2020061211160001-PMLG')
SET IDENTITY_INSERT [dbo].[Riwayat] OFF
ALTER TABLE [dbo].[CustomerService]  WITH CHECK ADD  CONSTRAINT [FK_CustomerService_Departement] FOREIGN KEY([id_dept])
REFERENCES [dbo].[Departement] ([id_dept])
GO
ALTER TABLE [dbo].[CustomerService] CHECK CONSTRAINT [FK_CustomerService_Departement]
GO
ALTER TABLE [dbo].[CustomerService]  WITH CHECK ADD  CONSTRAINT [FK_CustomerService_KantorCabang] FOREIGN KEY([kode_kantor_cabang])
REFERENCES [dbo].[KantorCabang] ([kode_kantor_cabang])
GO
ALTER TABLE [dbo].[CustomerService] CHECK CONSTRAINT [FK_CustomerService_KantorCabang]
GO
ALTER TABLE [dbo].[DataBarangPelanggan]  WITH CHECK ADD  CONSTRAINT [FK_DataBarangPelanggan_JenisPaket] FOREIGN KEY([id_staff])
REFERENCES [dbo].[CustomerService] ([id_staff])
GO
ALTER TABLE [dbo].[DataBarangPelanggan] CHECK CONSTRAINT [FK_DataBarangPelanggan_JenisPaket]
GO
ALTER TABLE [dbo].[DataBarangPelanggan]  WITH CHECK ADD  CONSTRAINT [FK_DataBarangPelanggan_JenisPaket1] FOREIGN KEY([jns_id])
REFERENCES [dbo].[JenisPaket] ([jns_id])
GO
ALTER TABLE [dbo].[DataBarangPelanggan] CHECK CONSTRAINT [FK_DataBarangPelanggan_JenisPaket1]
GO
ALTER TABLE [dbo].[DataBarangPelanggan]  WITH CHECK ADD  CONSTRAINT [FK_DataBarangPelanggan_KantorCabang] FOREIGN KEY([kode_kantor_cabang])
REFERENCES [dbo].[KantorCabang] ([kode_kantor_cabang])
GO
ALTER TABLE [dbo].[DataBarangPelanggan] CHECK CONSTRAINT [FK_DataBarangPelanggan_KantorCabang]
GO
ALTER TABLE [dbo].[DataBarangPelanggan]  WITH CHECK ADD  CONSTRAINT [FK_DataBarangPelanggan_Pelanggan] FOREIGN KEY([id_pelanggan])
REFERENCES [dbo].[Pelanggan] ([id_pelanggan])
GO
ALTER TABLE [dbo].[DataBarangPelanggan] CHECK CONSTRAINT [FK_DataBarangPelanggan_Pelanggan]
GO
ALTER TABLE [dbo].[detailBagging]  WITH CHECK ADD FOREIGN KEY([id_bagging])
REFERENCES [dbo].[Bagging] ([id_bagging])
GO
ALTER TABLE [dbo].[detailBagging]  WITH CHECK ADD FOREIGN KEY([id_connote])
REFERENCES [dbo].[Connote] ([id_connote])
GO
ALTER TABLE [dbo].[detailCargo]  WITH CHECK ADD FOREIGN KEY([id_bagging])
REFERENCES [dbo].[Bagging] ([id_bagging])
GO
ALTER TABLE [dbo].[detailCargo]  WITH CHECK ADD FOREIGN KEY([id_cargo_manifest])
REFERENCES [dbo].[CargoManifest] ([id_cargo_manifest])
GO
ALTER TABLE [dbo].[Driver]  WITH CHECK ADD  CONSTRAINT [FK_Driver_Departement] FOREIGN KEY([id_dept])
REFERENCES [dbo].[Departement] ([id_dept])
GO
ALTER TABLE [dbo].[Driver] CHECK CONSTRAINT [FK_Driver_Departement]
GO
ALTER TABLE [dbo].[Driver]  WITH CHECK ADD  CONSTRAINT [FK_Driver_Driver] FOREIGN KEY([ID_Staff])
REFERENCES [dbo].[Driver] ([ID_Staff])
GO
ALTER TABLE [dbo].[Driver] CHECK CONSTRAINT [FK_Driver_Driver]
GO
ALTER TABLE [dbo].[Driver]  WITH CHECK ADD  CONSTRAINT [FK_Driver_KantorCabang] FOREIGN KEY([kode_kantor_cabang])
REFERENCES [dbo].[KantorCabang] ([kode_kantor_cabang])
GO
ALTER TABLE [dbo].[Driver] CHECK CONSTRAINT [FK_Driver_KantorCabang]
GO
ALTER TABLE [dbo].[Riwayat]  WITH CHECK ADD FOREIGN KEY([id_pemesanan])
REFERENCES [dbo].[DataBarangPelanggan] ([id_pemesanan])
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_Departement] FOREIGN KEY([id_dept])
REFERENCES [dbo].[Departement] ([id_dept])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_Departement]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_KantorCabang] FOREIGN KEY([kode_kantor_cabang])
REFERENCES [dbo].[KantorCabang] ([kode_kantor_cabang])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_KantorCabang]
GO
USE [master]
GO
ALTER DATABASE [PT_KMF] SET  READ_WRITE 
GO

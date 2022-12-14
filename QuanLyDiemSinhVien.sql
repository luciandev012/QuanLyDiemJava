USE [master]
GO
/****** Object:  Database [QuanLyDiemSV]    Script Date: 6/26/2020 10:40:07 PM ******/
CREATE DATABASE [QuanLyDiemSV]
GO
ALTER DATABASE [QuanLyDiemSV] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyDiemSV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyDiemSV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyDiemSV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyDiemSV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyDiemSV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyDiemSV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyDiemSV] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyDiemSV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyDiemSV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyDiemSV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyDiemSV] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QuanLyDiemSV] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyDiemSV', N'ON'
GO
USE [QuanLyDiemSV]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[classCode] [varchar](20) NOT NULL,
	[className] [nvarchar](50) NOT NULL,
	[course] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DynamicClass]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DynamicClass](
	[dcid] [int] IDENTITY(1,1) NOT NULL,
	[dcCode] [varchar](50) NOT NULL,
	[teacherCode] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[dcid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Mark]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Mark](
	[mid] [int] IDENTITY(1,1) NOT NULL,
	[studentCode] [varchar](50) NULL,
	[dcCode] [varchar](50) NULL,
	[subjectName] [nvarchar](50) NULL,
	[markQuantity] [int] NULL DEFAULT ((1)),
	[regularMark1] [int] NULL DEFAULT ((0)),
	[regularMark2] [int] NULL DEFAULT ((0)),
	[regularMark3] [int] NULL DEFAULT ((0)),
	[examMark] [float] NULL DEFAULT ((0.0)),
PRIMARY KEY CLUSTERED 
(
	[mid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RealClass]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RealClass](
	[rcid] [int] IDENTITY(1,1) NOT NULL,
	[dcCode] [varchar](50) NULL,
	[studentCode] [varchar](50) NULL,
	[subjectName] [nvarchar](50) NULL,
	[teacherName] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[rcid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Student](
	[sid] [int] IDENTITY(1,1) NOT NULL,
	[studentCode] [varchar](50) NOT NULL,
	[fullName] [nvarchar](100) NOT NULL,
	[classCode] [varchar](20) NULL,
	[eduSystem] [nvarchar](50) NULL,
	[birthday] [date] NULL,
	[address] [nvarchar](100) NULL,
	[sex] [bit] NULL DEFAULT ((1)),
	[phoneNumber] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Subject](
	[suId] [int] IDENTITY(1,1) NOT NULL,
	[subjectCode] [varchar](20) NOT NULL,
	[subjectName] [nvarchar](50) NOT NULL,
	[credits] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[suId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 6/26/2020 10:40:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Teacher](
	[tid] [int] IDENTITY(1,1) NOT NULL,
	[teacherCode] [varchar](50) NOT NULL,
	[fullName] [nvarchar](100) NOT NULL,
	[subjectCode] [varchar](20) NULL,
	[classCode] [varchar](20) NULL,
	[birthday] [date] NULL,
	[sex] [bit] NULL DEFAULT ((0)),
	[email] [varchar](50) NULL,
	[phoneNumber] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[tid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Class] ON 

INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (1, N'khmt2', N'Khoa học máy tính 2', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (2, N'khmt1', N'Khoa học máy tính 1', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (3, N'cntt1', N'Công nghệ thông tin 1', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (4, N'cntt2', N'Công nghệ thông tin 2', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (5, N'cntt3', N'Công nghệ thông tin 3', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (6, N'httt1', N'Hệ thống thông tin 1', 11)
INSERT [dbo].[Class] ([cid], [classCode], [className], [course]) VALUES (7, N'httt2', N'Hệ thống thông tin 2', 11)
SET IDENTITY_INSERT [dbo].[Class] OFF
SET IDENTITY_INSERT [dbo].[DynamicClass] ON 

INSERT [dbo].[DynamicClass] ([dcid], [dcCode], [teacherCode]) VALUES (1, N'dc001', N'gv001')
INSERT [dbo].[DynamicClass] ([dcid], [dcCode], [teacherCode]) VALUES (2, N'dc002', N'gv002')
SET IDENTITY_INSERT [dbo].[DynamicClass] OFF
SET IDENTITY_INSERT [dbo].[Mark] ON 

INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (1, N'sv001', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (2, N'sv002', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (3, N'sv003', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (6, N'sv004', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (7, N'sv005', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (8, N'sv006', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (9, N'sv007', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (10, N'sv008', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (11, N'sv009', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (14, N'sv010', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
INSERT [dbo].[Mark] ([mid], [studentCode], [dcCode], [subjectName], [markQuantity], [regularMark1], [regularMark2], [regularMark3], [examMark]) VALUES (15, N'sv011', N'dc001', N'Lập trình hướng đối tượng', 1, 0, 0, 0, 0)
SET IDENTITY_INSERT [dbo].[Mark] OFF
SET IDENTITY_INSERT [dbo].[RealClass] ON 

INSERT [dbo].[RealClass] ([rcid], [dcCode], [studentCode], [subjectName], [teacherName]) VALUES (1, N'dc001', N'sv001', N'Lập trình hướng đối tượng', N'Nguyễn Đình Thi')
SET IDENTITY_INSERT [dbo].[RealClass] OFF
SET IDENTITY_INSERT [dbo].[Student] ON 

INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (1, N'sv001', N'Dương Văn Thắng', N'khmt2', N'Đại học', CAST(N'1998-02-12' AS Date), N'Úc Kỳ - Phú Bình - Thái Nguyên', 1, N'0335505858')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (3, N'sv002', N'La Thanh Hảo', N'khmt2', N'Đại học', CAST(N'1998-04-24' AS Date), N'Long Thành - Long Thành - Đồng Nai', 0, N'0985940124')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (4, N'sv003', N'Vũ Minh Quảng', N'khmt1', N'Đại học', CAST(N'1998-05-19' AS Date), N'Tân Khánh - Phú Bình - Thái Nguyên', 0, N'0346715041')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (6, N'sv004', N'Nguyễn Minh Tuấn', N'cntt1', N'Đại học', CAST(N'1998-03-13' AS Date), N'Tân Khánh - Phú Bình - Thái Nguyên', 1, N'0342443784')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (7, N'sv005', N'Dương Minh Trang', N'cntt2', N'Đại học', CAST(N'1998-01-30' AS Date), N'Văn Trì - Bắc Từ Liêm - Hà Nội', 0, N'0323564365')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (16, N'sv006', N'Nguyễn Văn Huấn', N'cntt3', N'Đại học', CAST(N'1998-06-12' AS Date), N'Úc Kỳ - Phú Bình - Thái Nguyên', 1, N'0242439854')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (18, N'sv007', N'Nguyễn Văn Huấn', N'cntt3', N'Cao đẳng', CAST(N'2001-06-12' AS Date), N'Úc Kỳ - Phú Bình - Thái Nguyên', 1, N'0242439854')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (21, N'sv008', N'Dương Văn A', N'cntt1', N'Cao đẳng', CAST(N'1997-06-05' AS Date), N'Long Thành - Thành Long - Hà Nội', 1, N'0374891030')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (22, N'sv009', N'Dương Thị B', N'khmt1', N'Đại học', CAST(N'1997-10-16' AS Date), N'Úc Kỳ - Phú Lê - Thái Nguyên', 0, N'0397441827')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (23, N'sv010', N'Nguyễn Văn C', N'cntt2', N'Đại học', CAST(N'1997-10-16' AS Date), N'Nga My - Phú Bình - Thái Nguyên', 1, N'0394123332')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (24, N'sv011', N'Nguyễn Văn Nam', N'khmt1', N'Cao đẳng', CAST(N'1997-10-16' AS Date), N'Nhã Lộng - Phú Bình - Thái Nguyên', 1, N'0387882929')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (25, N'sv012', N'Nguyễn Thị D', N'khmt2', N'Đại học', CAST(N'1997-10-16' AS Date), N'Tân Khánh - Phú Bình - Thái Nguyên', 0, N'0394882223')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (26, N'sv013', N'Nguyễn Văn E', N'cntt1', N'Đại học', CAST(N'1997-10-16' AS Date), N'Văn Trì - Bắc Từ Liêm - Hà Nội', 1, N'0398448484')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (27, N'sv014', N'Đào Thị F', N'cntt2', N'Cao đẳng', CAST(N'1997-10-16' AS Date), N'Ngọa Long - Bắc Từ Liêm - Hà Nội', 0, N'0293949494')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (40, N'sv015', N'Lò Thị H', N'cntt2', N'Đại học', CAST(N'1997-10-23' AS Date), N'Văn Trì 5 - Thanh Xuân - Bắc Giang', 0, N'0938493840')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (41, N'sv016', N'Lò Thị K', N'khmt1', N'Cao đẳng', CAST(N'1997-10-23' AS Date), N'Vạn Phúc - Hà Đông - Hà Nội', 1, N'0394883930')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (42, N'sv017', N'Đào Thị L', N'khmt2', N'Đại học', CAST(N'1997-10-23' AS Date), N'Vạn Lác - Hà Đông - Hà Nội', 0, N'0392884393')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (50, N'sv018', N'Dương Văn Z', N'khmt1', N'Đại học', CAST(N'1997-10-09' AS Date), N'Tây Hồ - Hồ Tây - Hà Nội', 1, N'0384003939')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (51, N'sv019', N'Nguyễn Thị X', N'khmt1', N'Đại học', CAST(N'1997-10-09' AS Date), N'Hồ Gươm - Thanh Xuân - Hà Nội', 0, N'0394887383')
INSERT [dbo].[Student] ([sid], [studentCode], [fullName], [classCode], [eduSystem], [birthday], [address], [sex], [phoneNumber]) VALUES (52, N'sv020', N'Nguyễn Thị V', N'cntt2', N'Cao đẳng', CAST(N'1997-07-16' AS Date), N'Vạn Thọ - Hà Nam - Hà Nội', 0, N'0493829506')
SET IDENTITY_INSERT [dbo].[Student] OFF
SET IDENTITY_INSERT [dbo].[Subject] ON 

INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (1, N'LTHDT', N'Lập trình hướng đối tượng', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (2, N'Java', N'Lập trình Java', 4)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (3, N'C#', N'Lập trình window', 4)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (4, N'Web', N'Thiết kế web', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (5, N'ASP.Net', N'Lập trình cơ sở dữ liệu trên web', 4)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (6, N'AI', N'Trí tuệ nhân tạo', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (7, N'PMMNM', N'Phần mềm mã nguồn mở', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (8, N'MMT', N'Mạng máy tính', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (9, N'LTCB', N'Lập trình căn bản', 3)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (10, N'KTLT', N'Kỹ thuật lập trình', 4)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (11, N'TUH', N'Tối ưu hóa', 4)
INSERT [dbo].[Subject] ([suId], [subjectCode], [subjectName], [credits]) VALUES (12, N'DHMT', N'Đồ họa máy tính', 3)
SET IDENTITY_INSERT [dbo].[Subject] OFF
SET IDENTITY_INSERT [dbo].[Teacher] ON 

INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (1, N'gv001', N'Nguyễn Đình Thi', N'LTHDT', N'khmt2', CAST(N'1970-03-18' AS Date), 1, N'ndthi@gmail.com', N'0232142942')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (2, N'gv002', N'Từ Huy Cận', N'Java', N'khmt2', CAST(N'1972-04-29' AS Date), 1, N'thcan@gmail.com', N'0423242198')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (4, N'gv003', N'Bùi Xuân Quỳnh', N'Java', N'khmt1', CAST(N'1980-01-23' AS Date), 0, N'bxquynh@gmail.com', N'0344242197')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (5, N'gv004', N'Dương Hoàng Thoa', N'C#', N'cntt1', CAST(N'1985-11-08' AS Date), 0, N'dhthoa@gmai.com', N'0293102734')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (6, N'gv005', N'Hoàng Dược Sư', N'Web', N'cntt2', CAST(N'1981-09-10' AS Date), 1, N'hdsu@gmai.com', N'0425102354')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (7, N'gv006', N'Lê Huy Toàn', N'Web', N'cntt1', CAST(N'1979-09-19' AS Date), 1, N'lhtoan@gmai.com', N'0532034193')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (9, N'gv007', N'Trần Duy Sang', N'Web', N'cntt3', CAST(N'1979-09-19' AS Date), 1, N'tdsang@gmai.com', N'0231932042')
INSERT [dbo].[Teacher] ([tid], [teacherCode], [fullName], [subjectCode], [classCode], [birthday], [sex], [email], [phoneNumber]) VALUES (29, N'gv008', N'Trần Đình Thiện', N'KTLT', N'khmt2', CAST(N'1985-11-20' AS Date), 1, N'tdthien@gmail.com', N'0231052002')
SET IDENTITY_INSERT [dbo].[Teacher] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Class__0257F881B1FF727A]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Class] ADD UNIQUE NONCLUSTERED 
(
	[classCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Class__B030342616939D6F]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Class] ADD UNIQUE NONCLUSTERED 
(
	[className] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__DynamicC__EB6296041C0F21BE]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[DynamicClass] ADD UNIQUE NONCLUSTERED 
(
	[dcCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Mark__0641C6566CD5D41F]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Mark] ADD UNIQUE NONCLUSTERED 
(
	[studentCode] ASC,
	[dcCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Student__48F7EF36B46F843B]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Student] ADD UNIQUE NONCLUSTERED 
(
	[studentCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Subject__97E46C97DA898DB5]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Subject] ADD UNIQUE NONCLUSTERED 
(
	[subjectCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Subject__E5068BFD4FCE0CF1]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Subject] ADD UNIQUE NONCLUSTERED 
(
	[subjectName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Teacher__3644755C6BBD170D]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Teacher] ADD UNIQUE NONCLUSTERED 
(
	[teacherCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Teacher__87C1131F48C9B6C8]    Script Date: 6/26/2020 10:40:08 PM ******/
ALTER TABLE [dbo].[Teacher] ADD UNIQUE NONCLUSTERED 
(
	[subjectCode] ASC,
	[classCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DynamicClass]  WITH CHECK ADD FOREIGN KEY([teacherCode])
REFERENCES [dbo].[Teacher] ([teacherCode])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([dcCode])
REFERENCES [dbo].[DynamicClass] ([dcCode])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([studentCode])
REFERENCES [dbo].[Student] ([studentCode])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([subjectName])
REFERENCES [dbo].[Subject] ([subjectName])
GO
ALTER TABLE [dbo].[RealClass]  WITH CHECK ADD FOREIGN KEY([dcCode])
REFERENCES [dbo].[DynamicClass] ([dcCode])
GO
ALTER TABLE [dbo].[RealClass]  WITH CHECK ADD FOREIGN KEY([studentCode])
REFERENCES [dbo].[Student] ([studentCode])
GO
ALTER TABLE [dbo].[RealClass]  WITH CHECK ADD FOREIGN KEY([subjectName])
REFERENCES [dbo].[Subject] ([subjectName])
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD FOREIGN KEY([classCode])
REFERENCES [dbo].[Class] ([classCode])
GO
ALTER TABLE [dbo].[Teacher]  WITH CHECK ADD FOREIGN KEY([classCode])
REFERENCES [dbo].[Class] ([classCode])
GO
ALTER TABLE [dbo].[Teacher]  WITH CHECK ADD FOREIGN KEY([subjectCode])
REFERENCES [dbo].[Subject] ([subjectCode])
GO
USE [master]
GO
ALTER DATABASE [QuanLyDiemSV] SET  READ_WRITE 
GO

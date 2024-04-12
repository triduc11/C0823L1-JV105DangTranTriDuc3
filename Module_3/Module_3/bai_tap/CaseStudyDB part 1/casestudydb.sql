	create database if not exists CaseStudyDB;
use CaseStudyDB ;
create table vi_tri(
 ma_vi_tri int primary key auto_increment,
 ten_vi_tri varchar(45)
);
create table trinh_do (
ma_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45)
);
create table bo_phan(
ma_bo_phan int primary key auto_increment,
ten_bo_phan varchar (45)
);
create table nhan_vien(
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
ngay_sinh DATE ,
so_cmnd varchar(45),
luong double ,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int ,
ma_bo_phan int ,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table loai_khach (
ma_loai_khach int primary key auto_increment ,
ten_loai_khach varchar(45)
);
create table khach_hang (
ma_khach_hang int primary key auto_increment ,
ho_va_ten varchar(45) ,
ngay_sinh date,
gioi_tinh BIT(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int ,
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);
create table kieu_thue(
ma_kieu_thue int primary key auto_increment ,
ten_kieu_thue varchar(45)
);
create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment ,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
ma_dich_vu int primary key auto_increment ,
ten_dich_vu varchar(45),
dien_tich int ,
chi_phi_thue double ,
so_nguoi_toi_da int ,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double ,
so_tang int ,
dich_vu_mien_phi_di_kem text ,
ma_kieu_thue int ,
ma_loai_dich_vu int ,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue) ,
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key auto_increment ,
ten_dich_vu_di_kem varchar(45),
gia double ,
don_vi varchar(45),
trang_thai varchar(45)
);
create table hop_dong (
ma_hop_dong int primary key auto_increment ,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime ,
tien_dat_coc double ,
ma_nhan_vien int ,
ma_khach_hang int ,
ma_dich_vu int ,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
create table hop_dong_chi_tiet (
ma_hop_dong_chi_tiet int primary key auto_increment ,
so_luong int ,
ma_hop_dong int ,
ma_dich_vu_di_kem int ,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);


-- input data
insert into vi_tri(ten_vi_tri) values ('Quản Lý'),('Nhân Viên') ;
insert into trinh_do(ten_trinh_do) values ('Trung Cấp'),('Cao Đẳng'),('Đại Học'),('Sau Đại Học') ;
insert into bo_phan(ten_bo_phan) values ('Sale-Marketing'),('Hành chính'),('Phục vụ'),('Quản lý');
insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) values 
('Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
('Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
('Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
insert into loai_khach(ten_loai_khach) values ('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');
insert into khach_hang(ho_va_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values
('Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
('Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
('Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
('Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
('Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
('Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
('Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
('Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
('Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
('Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','2 Ngô Quyền, Đà Nẵng',2);
insert into kieu_thue(ten_kieu_thue) values ('year'),('month'),('day'),('hour');
insert into loai_dich_vu(ten_loai_dich_vu) values ('Villa'),('House'),('Room');
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,dich_vu_mien_phi_di_kem,ma_kieu_thue,ma_loai_dich_vu) values
('Villa Beach Front',25000,1000000,10,'vip','Có hồ bơi',500,4,null,3,1),('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,null,2,2),
('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,'1 Xe máy, 1 Xe đạp',4,3),('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,null,3,1),
('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,null,3,2),('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,'1 Xe máy',4,3);
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) values 
('Karaoke',10000,'giờ','tiện nghi, hiện tại'),('Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
('Thuê xe đạp',20000,'chiếc','tốt'),('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) values
('2020-12-08','2020-12-08',0,3,1,3),('2020-07-14','2020-07-21',200000,7,3,1),
('2021-03-15','2021-03-17',50000,3,4,2),('2021-01-14','2021-01-18',100000,7,5,5),
('2021-07-14','2021-07-15',0,7,2,6),('2021-06-01','2021-06-03',0,7,7,6),
('2021-09-02','2021-09-05',100000,7,4,4),('2021-06-17','2021-06-18',150000,3,4,1),
('2020-11-19','2020-11-19',0,3,4,3),('2021-04-12','2021-04-14',0,10,3,5),
('2021-04-25','2021-04-25',0,2,2,1),('2021-05-25','2021-05-27',0,7,10,1);
insert into hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) values
(5,2,4),(8,2,5),(15,2,6),(1,3,1),(11,3,2),(1,1,3),(2,1,2),(2,12,2);



-- bài tập

-- câu 2
select * from nhan_vien where (ho_ten like 'K%' or ho_ten like 'H%' or ho_ten like 'T%' ) and length(ho_ten)<=15 ;

-- câu 3
select * from khach_hang where year(curdate()) - year(ngay_sinh) between 18 and 50 
and (dia_chi like '% Đà Nẵng' or dia_chi like'% Quảng Trị');

-- câu 4
select hd.ma_khach_hang, khach_hang.ho_va_ten ,count(*) as so_lan_dat_phong
from hop_dong hd
inner join khach_hang on hd.ma_khach_hang=khach_hang.ma_khach_hang
inner join loai_khach on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond'
group by hd.ma_khach_hang
order by so_lan_dat_phong asc ;

-- câu 5
select khach_hang.ma_khach_hang, khach_hang.ho_va_ten, loai_khach.ten_loai_khach ,hop_dong.ma_hop_dong, dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc, sum(dich_vu.chi_phi_thue) as tong_tien
from khach_hang 
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join loai_khach on khach_hang.ma_loai_khach= loai_khach.ma_loai_khach
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on dich_vu_di_kem.ma_dich_vu_di_kem = dich_vu.ma_dich_vu
group by khach_hang.ma_khach_hang, khach_hang.ho_va_ten, loai_khach.ten_loai_khach ,hop_dong.ma_hop_dong, dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc;

-- câu 6
SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM dich_vu
LEFT JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
WHERE dich_vu.ma_dich_vu not  IN (
	select hop_dong.ma_dich_vu
    from hop_dong 
    left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
    where  YEAR(hop_dong.ngay_lam_hop_dong) = 2021 and (quarter(hop_dong.ngay_lam_hop_dong)=1) 
)
group by dich_vu.ma_dich_vu ;

-- câu 7
SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu,dich_vu.so_nguoi_toi_da
from dich_vu
left JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu 
WHERE  dich_vu.ma_dich_vu in (
        SELECT distinct ma_dich_vu
        FROM hop_dong
        WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2020 
) 
and dich_vu.ma_dich_vu not in (
        SELECT distinct ma_dich_vu
        FROM hop_dong
        WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021
) ;

-- câu 8
select distinct khach_hang.ho_va_ten
from khach_hang ;
select khach_hang.ho_va_ten
from khach_hang
group by ho_va_ten ;
WITH khach_hang_distinct AS (
    SELECT ho_va_ten, ROW_NUMBER() OVER (PARTITION BY ho_va_ten ORDER BY ho_va_ten) AS row_num
    FROM khach_hang
)
SELECT ho_va_ten
FROM khach_hang_distinct
WHERE row_num = 1 ;

-- câu 9 
SELECT MONTH(ngay_lam_hop_dong) AS thang, COUNT(DISTINCT ma_khach_hang) AS so_luong_khach_hang
FROM hop_dong
WHERE YEAR(ngay_lam_hop_dong) = 2021
GROUP BY MONTH(ngay_lam_hop_dong)
ORDER BY thang ;

-- câu 10 
select hd.ma_hop_dong ,hd.ngay_lam_hop_dong, hd.ngay_ket_thuc ,hd.tien_dat_coc ,sum(hdct.so_luong) as so_luong
from hop_dong hd 
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong,hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,hd.tien_dat_coc 
order by hd.ma_hop_dong asc;

-- câu 11
select dvdk.ma_dich_vu_di_kem ,dvdk.ten_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong 
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where  lk.ten_loai_khach = 'Diamond' AND (kh.dia_chi like '%Vinh' OR kh.dia_chi like '%Quảng Ngãi') ;

-- câu 12
select hd.ma_hop_dong , nv.ho_ten as ho_ten_nhan_vien , kh.ho_va_ten as ho_ten_khach_hang , kh.so_dien_thoai ,dv.ma_dich_vu,dv.ten_dich_vu,sum(hdct.so_luong) as so_luong, hd.tien_dat_coc
from hop_dong hd
left join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
left join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
where dv.ma_dich_vu in (
	select hop_dong.ma_dich_vu
	from hop_dong 
	where quarter(hop_dong.ngay_lam_hop_dong)= 4 and year (hop_dong.ngay_lam_hop_dong) =2020 and hop_dong.ma_dich_vu not in (
		select hop_dong.ma_dich_vu
		from hop_dong 
		where month(hop_dong.ngay_lam_hop_dong)  in (1,2,3,4,5,6) and year (hop_dong.ngay_lam_hop_dong) =2021
        )
 )
 GROUP BY hd.ma_hop_dong, nv.ho_ten, kh.ho_va_ten, kh.so_dien_thoai,dv.ma_dich_vu,dv.ten_dich_vu ;

-- câu 13
CREATE VIEW danh_sach_so_lan_dich_vu_su_dung AS
SELECT dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, SUM(hop_dong_chi_tiet.so_luong) AS so_luong_dich_vu_di_kem 
FROM dich_vu_di_kem
JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem 
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem 
ORDER BY dich_vu_di_kem.ma_dich_vu_di_kem ASC;
SELECT ma_dich_vu_di_kem, ten_dich_vu_di_kem, so_luong_dich_vu_di_kem
FROM danh_sach_so_lan_dich_vu_su_dung
WHERE so_luong_dich_vu_di_kem = (
    SELECT MAX(so_luong_dich_vu_di_kem) 
    FROM danh_sach_so_lan_dich_vu_su_dung
);

-- câu 14
select hop_dong.ma_hop_dong,dich_vu.ten_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong 
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong,dich_vu.ten_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem 
having so_lan_su_dung=1 
order by hop_dong.ma_hop_dong asc;

-- câu 15
SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien nv
JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
WHERE nv.ma_nhan_vien IN (
    SELECT hd.ma_nhan_vien
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
    GROUP BY hd.ma_nhan_vien
    HAVING COUNT(hd.ma_hop_dong) <= 3
);

-- câu 16
DELETE FROM nhan_vien
WHERE nhan_vien.ma_nhan_vien NOT IN (
    SELECT hop_dong.ma_nhan_vien
    FROM hop_dong
    WHERE YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2019 AND 2021
);

-- câu 17


-- câu 18
SELECT khach_hang.ma_khach_hang ,khach_hang.ho_va_ten
FROM khach_hang
JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE YEAR(hop_dong.ngay_lam_hop_dong) < 2021;
DELETE FROM khach_hang
WHERE ma_khach_hang IN (
  SELECT khach_hang.ma_khach_hang
  FROM khach_hang
  JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
  WHERE YEAR(hop_dong.ngay_lam_hop_dong) < 2021
);
-- câu 19
update dich_vu_di_kem
set gia = gia * 2 
where dich_vu_di_kem.ma_dich_vu_di_kem in (
	select dk.ma_dich_vu_di_kem
    FROM dich_vu_di_kem dk
	JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem 
	join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
	where YEAR (hop_dong.ngay_lam_hop_dong) = 2020 
	GROUP BY dk.ma_dich_vu_di_kem 
	having sum(so_luong) >10 
);

-- câu 20
SELECT ma_nhan_vien AS id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM nhan_vien
UNION ALL
SELECT ma_khach_hang AS id, ho_va_ten as ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM khach_hang
group by id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi ;

-- câu 21
create view v_nhan_vien as
select nv.ma_nhan_vien, nv.ho_ten
from nhan_vien nv 
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.dia_chi like "%New York%" and  hd.ngay_lam_hop_dong ='2021-03-15' 
group by nv.ma_nhan_vien ;

-- câu 21
update v_nhan_vien
SET dia_chi = REGEXP_REPLACE(dia_chi, '[^,]+$', 'New York'); 

-- câu 22 










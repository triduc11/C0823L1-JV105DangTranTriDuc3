create database if not exists benhandb;
use benhandb ;
create table thong_tin_benh_an (
	id int primary key auto_increment,
    ma_benh_an varchar(45),
    ma_benh_nhan varchar(45),
    ngay_nhap_vien date ,
    ngay_ra_vien date ,
    ly_do_nhap_vien varchar(45) ,
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan)
);
create table benh_nhan (
	ma_benh_nhan varchar(45) primary key,
    ten_benh_nhan varchar(45)
);
insert into thong_tin_benh_an (ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) values
('BA001','BN001','2024-1-1','2024-2-1','đau bụng'),('BA002','BN002','2023-11-1','2024-2-1','đau dạ dày'),
('BA003','BN003','2024-2-1','2024-3-1','gãy chân'),('BA004','BN004','2022-12-1','2023-2-1','sốt xuất huyết'),
('BA005','BN005','2021-11-1','2022-2-1','viêm ruột thừa');
insert into benh_nhan(ma_benh_nhan,ten_benh_nhan) values
('BN001','Nguyễn Văn A'),('BN002','Nguyễn Văn B'),('BN003','Nguyễn Văn C'),
('BN004','Nguyễn Văn D'),('BN005','Nguyễn Văn E');

select tt.id, tt.ma_benh_an ,tt.ma_benh_nhan , bn.ten_benh_nhan ,tt.ngay_nhap_vien, tt.ngay_ra_vien, tt.ly_do_nhap_vien from thong_tin_benh_an tt join benh_nhan bn on bn.ma_benh_nhan=tt.ma_benh_nhan ;
select* from benh_nhan;
create view full_thong_tin as
select  tt.id, tt.ma_benh_an ,tt.ma_benh_nhan , bn.ten_benh_nhan ,tt.ngay_nhap_vien, tt.ngay_ra_vien, tt.ly_do_nhap_vien 
from thong_tin_benh_an tt
join benh_nhan bn on bn.ma_benh_nhan=tt.ma_benh_nhan ;
insert into full_thong_tin (ma_benh_an,ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) values 
('BA006','BN006','LEVCD','2024-1-1','2022-1-1','ddd');
insert into thong_tin_benh_an (ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) values 
('BA006','BN006','2024-1-1','2022-1-1','ddd');
insert into benh_nhan(ma_benh_nhan,ten_benh_nhan) values
('BN006','LEVCD');

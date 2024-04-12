create database if not exists productfinal ;
use productfinal ;
create table thong_tin_san_pham (
id int primary key auto_increment,
ten_san_pham varchar(45) ,
gia double,
so_luong int ,
mau_sac varchar(45),
mo_ta varchar(45),
ma_danh_muc int,
foreign key (ma_danh_muc) references bang_danh_muc(ma_danh_muc) 
);
create table bang_danh_muc (
 ma_danh_muc int primary key auto_increment,
 danh_muc varchar(45)
);
insert into thong_tin_san_pham (ten_san_pham,gia,so_luong,mau_sac,mo_ta,ma_danh_muc) values
('iPhone 11',799,12,'purple','aaa',1),
('iPhone 12',100,10,'red','aaa',1),
('iPhone 13',800,11,'yellow','aaa',1),
('Smart TV',1000,16,'purple','aaa',2),
('iPhone 15',200,19,'red','aaa',1);
insert into bang_danh_muc (danh_muc) values 
('Phone') ,('TV') ;

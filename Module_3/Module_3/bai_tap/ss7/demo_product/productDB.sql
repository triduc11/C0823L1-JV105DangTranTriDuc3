create database if not exists ProductDB ;
use ProductDB ;
create table thong_tin_sp (
 id int primary key auto_increment,
 ten_san_pham varchar(45) ,
 don_gia double ,
 so_luong int ,
 kich_thuoc int ,
 foreign key (kich_thuoc) references bang_kich_thuoc(ma_kich_thuoc)
);
create table bang_kich_thuoc (
 ma_kich_thuoc int primary key auto_increment ,
 loai_kich_thuoc varchar(45) 
);
insert into thong_tin_sp (ten_san_pham,don_gia,so_luong,kich_thuoc) values 
('Giấy in',10000,10,2),('Bảng đen',15000,20,1),('Phấn bảng',5000,15,3),
('Bút lông',7000,30,4),('Bút chì',11000,10,2),('Cục tẩy',2000,10,1),('Vở',30000,40,3);
insert into bang_kich_thuoc (loai_kich_thuoc) values ('S'),('M'),('L'),('XL') ;
delimiter //
create procedure delete_by_id (IN id INT)
Begin 
	delete from thong_tin_sp
    where thong_tin_sp.id=id;
End //
delimiter ;
call delete_by_id (10);	

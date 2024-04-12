create database if not exists product1 ;
use product1 ;
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

select thong_tin_san_pham.id ,thong_tin_san_pham.ten_san_pham,thong_tin_san_pham.gia ,thong_tin_san_pham.so_luong,thong_tin_san_pham.mau_sac,bang_danh_muc.danh_muc from thong_tin_san_pham
join bang_danh_muc on bang_danh_muc.ma_danh_muc=thong_tin_san_pham.ma_danh_muc ;
select * from bang_danh_muc;
delimiter //
create procedure delete_by_id (IN id INT)
Begin 
	delete from thong_tin_san_pham
    where thong_tin_san_pham.id=id;
End //
delimiter ;
call delete_by_id (10);	
update thong_tin_san_pham set ten_san_pham=?,gia=?,so_luong=?,mau_sac=?,mo_ta=?,ma_danh_muc=? where id=? ;
select thong_tin_san_pham.id ,thong_tin_san_pham.ten_san_pham,thong_tin_san_pham.gia ,thong_tin_san_pham.so_luong,thong_tin_san_pham.mau_sac,bang_danh_muc.danh_muc from thong_tin_san_pham
join bang_danh_muc on bang_danh_muc.ma_danh_muc=thong_tin_san_pham.ma_danh_muc 
where thong_tin_san_pham.ten_san_pham like concat('%','S','%') ;


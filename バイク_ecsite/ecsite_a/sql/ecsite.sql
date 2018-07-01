set names utf8;
set foreign_key_checks = 0;
drop database if exists bike;

create database if not exists bike;
use bike;

drop table if exists login_user_transaction;

create table login_user_transaction(

	id int not null primary key auto_increment,
	login_id varchar(16) unique,

	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	update_date datetime
);

drop  table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,

	item_name varchar(30),
	item_price int,
	engine_cc int,
	style varchar(30),
	item_stock int,
	maker_company varchar(30),
	image_file_path varchar(100),
	insert_date datetime,
	update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

INSERT INTO item_info_transaction(item_name, item_price, engine_cc, style, item_stock, maker_company, image_file_path) VALUES
("バルカン400クラシック", 800,400,"アメリカン",10,"kawasaki","./image/バルカン400クラシック.jpg"),
("ドラッグスター400",500,400,"アメリカン",10,"yamaha","./image/ドラッグスター.jpg"),
("FAT BOY",1000,1745,"アメリカン",5,"harley-davidson","./image/FAT_BOY.jpg"),
("SR400",200,400,"ストリート",8,"yamaha","./image/SR.jpg");

INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("a","aaa","test");






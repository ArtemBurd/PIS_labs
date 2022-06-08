drop schema if exists restaurant;
create schema restaurant;
use restaurant;

create table if not exists dishes(
id bigint auto_increment not null primary key,
name varchar(50) not null,
price decimal(10, 2) not null );

create table if not exists users(
id bigint auto_increment not null primary key,
name varchar(50) not null,
surname varchar(50) not null,
phone varchar(20) not null,
password varchar(50) not null );

create table if not exists orders(
orderId bigint auto_increment not null primary key,
userId bigint not null,
orderStatus varchar(50) not null,
foreign key (userId) references users(id) );

create table if not exists order_dish(
id bigint auto_increment not null primary key,
orderId bigint not null,
dishId bigint not null,
numberOfDishes smallint not null,
foreign key (orderId) references orders(orderId),
foreign key (dishId) references dishes(id) );

insert into dishes(name, price) values
	("Borscht", 50.00),
    ("Varenyky", 60.00),
    ("Cheesecake", 40.00),
    ("Tea", 20.00);
    
insert into users(name, surname, phone, password) values
	("Volodymyr", "Drevnitskyi", "+380671002233", "1111"),
    ("Evheniya", "Dobrovolska", "+380507894561", "2222"),
    ("Olena", "Siruk", "+380981472332", "1111");
    
insert into orders(userId, orderStatus) values
	(1, "paid"),
    (1, "in proccess"),
    (3, "ready");
    
insert into order_dish(orderId, dishId, numberOfDishes) values
	(1, 1, 1),
    (1, 2, 1),
    (1, 2, 2),
    (3, 3, 1),
    (3, 4, 1);
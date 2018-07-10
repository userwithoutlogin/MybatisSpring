create table users(
id int unsigned not null auto_increment primary key,
user_name varchar(10) not null,
password varchar(5) not null 
);

create table author(
id int unsigned not null auto_increment primary key,
real_name varchar(10) not null,
id_card varchar(15) not null,
user_id int unsigned not null,
unique un_ui (user_id),
constraint fk_user  
foreign key (user_id) references users(id)
)

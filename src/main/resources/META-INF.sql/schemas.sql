create table users(
id int unsigned not null auto_increment primary key,
user_name varchar(10) not null,
password varchar(5) not null 
);

create table authors(
id int unsigned not null auto_increment primary key,
real_name varchar(10) not null,
id_card varchar(15) not null,
user_id int unsigned not null,
unique un_ui (user_id),
constraint fk_a_user  
foreign key (user_id) references users(id)
);

create table visitors(
id int unsigned not null auto_increment primary key,
visitor_ip varchar(15) not null,
visit_date Date not null,
user_id int unsigned not null,
constraint fk_v_user 
foreign key (user_id) references users(id)
);
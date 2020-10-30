use lemon_java_18_08;
create table if not exists author(
id int not null primary key auto_increment,
name varchar(500)
);

create table if not exists book(
id int auto_increment,
name varchar(500),
publish date,
description varchar(2000),
primary key (id)
);

create table if not exists author_book(
id int not null primary key auto_increment,
book_id int not null,
author_id int not null
);

# Table for MySQL - you'll come up with your own.
create table pojotable (
	id int(11) not null primary key auto_increment,
	pid varchar(40) not null default "",
	firstname varchar(100) not null default "",
	lastname varchar(100) not null default "",
	deleteflag int(11) not null default -1
);

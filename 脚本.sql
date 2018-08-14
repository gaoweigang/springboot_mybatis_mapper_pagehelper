--创建数据dev
CREATE DATABASE dev;

--切换到数据库dev
USE dev;

--查看当前正在使用的数据库
select DATABASE();

--查看当前库中存在哪些表
show tables;

--创建Student表
create table student(
  id bigint(32) NOT NULL AUTO_INCREMENT,
  name varchar(120),
  age int(11),
  PRIMARY KEY (id)
);

--查询表
SELECT * from student;

--往表中插入记录
insert into student(name, age) values('gaoweigang', '21');
insert into student(name, age) values('gaohongcheng', '22');
insert into student(name, age) values('test', '24');
insert into student(name, age) values('dangdang', '25');
insert into student(name, age) values('demo', '25');
insert into student(name, age) values('admin', '26');
insert into student(name, age) values('super', '23');
insert into student(name, age) values('gao', '26');
insert into student(name, age) values('joe', '27');
insert into student(name, age) values('gang', '27');
insert into student(name, age) values('budong', '32');
insert into student(name, age) values('spring', '42');
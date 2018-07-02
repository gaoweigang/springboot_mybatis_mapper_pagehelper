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
  name varchar(120),
  age int(11)
);

--查询表
SELECT * from student;

--往表中插入记录
insert into student values('gaoweigang', '22');
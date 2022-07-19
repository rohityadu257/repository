create database student_management;
select * from student_details;
insert into student_details values (1,'India','B.Tech','Rohit','Kumar');
insert into student_details values (2,'US','B.Tech','Raames','Singh');
insert into student_details values (3,'Romania','B.Tech','Ram','Sinha');
insert into student_details values (4,'China','B.Tech','Pravin','Jain');
insert into student_details values (5,'Australia','B.Tech','Leon','T');
select* from users;
insert into users values(1,'$2a$12$lddSbxMglM4sMWIigsCxz.EKYxfSYqzpAhevG4DYB/CesFHx8WUwO','USER');
insert into users values(2,'$2a$12$HQi0abS18jH/lN5DL/Pa0.aLhfd2/OrEXaZy6N.ddiqdaYMvYwPmK','ADMIN');
Select * from roles;
insert into roles values (1,'USER');
insert into roles values(2,'ADMIN');

Select * from user_roles;
insert into user_roles values(1,1);
insert into user_roles values(2,1);
insert into user_roles values(2,2);
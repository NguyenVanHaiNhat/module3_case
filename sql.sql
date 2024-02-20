drop database if exists quanlihocsinh;
create database if not exists quanlihocsinh;

use quanlihocsinh;

create table subject(
id int auto_increment primary key,
nameSubject varchar(255)
);

create table class(
id int auto_increment primary key,
nameClass varchar(255)
);

create table student(
id varchar(100) primary key,
nameStudent varchar(255) not null,
dayofbirth date not null,
address varchar(255) not null,
id_class int,
foreign key (id_class) references class(id)
);

create table pointStudent(
id_student varchar(100),
id_subject int,
testMark float not null,
testMark15 float not null,
testMark60 float not null,
midterm float not null,
final float not null,
foreign key (id_student) references student(id),
foreign key (id_subject) references subject(id)
);

select * from class;
insert into class(nameClass) value 
('10A1'), ('10A2'), ('10B1'), ('10B2'), ('10B3'), ('10B4'), ('10B5'),
('11A1'), ('11A2'), ('11B1'), ('11B2'), ('11B3'), ('11B4'), ('11B5'),
('12A1'), ('12A2'), ('12B1'), ('12B2'), ('12B3'), ('12B4'), ('12B5');

select * from subject;
insert into subject(nameSubject) value
('Toán'), ('Lý'), ('Hóa');

select * from student;
insert into student(id, nameStudent, dayofbirth, address, id_class) value
('HS01', 'Nguyễn Văn Hải Nhật', '2003-10-22', 'Quảng Trị', 18),
('HS02', 'Lương Văn Đạt', '2000-10-22', 'Quảng Bình', 17),
('HS03', 'Hồ Công Lãm', '2005-02-03', 'Quảng Trị', 5),
('HS04', 'Hồ Ngọc Hoàng', '2005-04-01', 'Quảng Trị', 6),
('HS05', 'Võ Thành Anh Phước', '2004-06-25', 'Quảng Trị', 12);

select * from pointStudent;
insert into pointStudent(id_student, id_subject, testMark, testMark15, testMark60, midterm, final) value
('HS01', 1, 9.2, 9.5, 10, 8.0, 8.5),
('HS01', 2, 9.3, 8.5, 7.6, 9.9, 8.2),
('HS01', 3, 9.5, 8.6, 8.6, 7.9, 9.2),
('HS02', 1, 9.5, 9.2, 8, 8.7, 5),
('HS02', 2, 9.4, 6.5, 5.6, 7.9, 5.2),
('HS02', 3, 9.7, 6.8, 5.6, 6.9, 5.2);


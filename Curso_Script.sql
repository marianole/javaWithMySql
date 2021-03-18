DROP DATABASE IF EXISTS Curso;
CREATE DATABASE Curso;
use Curso;

create table Alumno(codigo int not null primary key auto_increment,nombre varchar(40), apellido varchar(40), fechaNacimiento date);

create table Curso(codigo int not null primary key auto_increment, nombreCurso varchar(50));

create table Alumno_Curso(codigoAlumno int not null, codigoCurso int not null,
constraint primary key(codigoAlumno, codigoCurso),
constraint foreign key(codigoAlumno) references Alumno(codigo),
constraint foreign key(codigoCurso) references Curso(codigo));

insert into Alumno(codigo, nombre, apellido, fechaNacimiento) values (22, 'Juan', 'Diaz', '1974-08-16');
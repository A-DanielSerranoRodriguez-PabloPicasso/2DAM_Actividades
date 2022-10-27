drop database if exists ej4jdbc;

create database ej4jdbc;
use ej4jdbc;

create table alumno(
	num_matricula int primary key,
    nombre varchar(20),
    fecha_nac date,
    telefono varchar(9),
    constraint check_tlf_alumno check (telefono between 100000000 and 999999999)
);

create table profesor(
	id int primary key auto_increment,
    nif_p varchar(9),
    nombre varchar(20),
    especialidad varchar(20),
    telefono varchar(9),
    constraint check_tlf_prof check (telefono between 100000000 and 999999999)
);

create table asignatura(
	cod_asignatura varchar(10) primary key,
    nombre varchar(50),
    id_profesor int,
    constraint fk_asign_prof foreign key (id_profesor) references profesor(id)
);

create table recibe(
	num_matricula int,
    cod_asignatura varchar(10),
    primary key (num_matricula, cod_asignatura),
    constraint fk_recibe_alumno foreign key (num_matricula) references alumno(num_matricula),
    constraint fk_recibe_asign foreign key (cod_asignatura) references asignatura(cod_asignatura)
);
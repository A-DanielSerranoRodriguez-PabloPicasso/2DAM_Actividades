create database repaso;
#drop database repaso;
use repaso;

create table profesores(
	dni char(9) primary key,
    nombre varchar(20),
    apellidos varchar(50),
    edad tinyint,
    telefono char(9)
);

create table tipo_curso(
	cod_curso int primary key,
    titulo int unique,
    duracion int,
    programa varchar(20)
);

create table cursos(
	n_concreto int primary key,
    fecha_ini date,
    fecha_fin date,
    profesor char(9),
    tipo_curso int,
    constraint fk_cursos_profesores foreign key (profesor) references profesores(dni),
    constraint fk_cursos_tipoCurso foreign key (tipo_curso) references tipo_curso(cod_curso)
);

create table empresas(
	dni char(9) primary key,
    nombre varchar(20) unique,
    apellidos varchar(50),
    edad tinyint,
    telefono char(9)
);

create table alumnos(
	dni char(9) primary key,
    nombre varchar(20),
    apellidos varchar(50),
    edad tinyint,
    telefono char(9),
    empresa char(9),
    constraint fk_alumnos_empresa foreign key (empresa) references empresas(dni)
);

create table asistir(
	alumno char(9),
    curso int,
    nota int,
    constraint pk_asistir primary key (alumno, curso),
    constraint fk_asistir_alumnos foreign key (alumno) references alumnos(dni),
    constraint fk_asistir_cursos foreign key (curso) references cursos(n_concreto)
);
#create database prueba_inicial;
#drop database prueba_inicial;
use prueba_inicial;

-- 1. Crear las tablas sin foreign key
create table compra(
	nif_c int,
    modelo int,
    fechacompra date,
    primary key (nif_c, modelo, fechacompra)
);

create table monta(
	nif_m int,
    modelo int,
    fechamontaje date,
    primary key (nif_m, modelo, fechamontaje)
);

create table cliente(
	nif int primary key,
    nombre varchar(20),
    direccion varchar(100),
    telefono int
);

create table montador(
	nif int primary key,
    nombre varchar(20),
    direccion varchar(100),
    telefono int
);

create table modelodormitorio(
	cod int primary key
);

-- 2. Añadir las foreign key
alter table compra
	add constraint fk_nifc foreign key (nif_c) references cliente(nif),
    add constraint fk_modeloc foreign key (modelo) references modelodormitorio(cod);
alter table monta
    add constraint fk_nifm foreign key (nif_m) references montador(nif),
    add constraint fk_modelom foreign key (modelo) references modelodormitorio(cod);

-- 3. Añadida columna "edad" con restriccion
alter table cliente
	add column edad int after nombre,
    add check (edad between 18 and 99);

-- 4. Modificado direccion
alter table cliente
	modify direccion varchar(150);

-- 5. Creado indice para nombre
alter table cliente
	add index (nombre);

-- Test
insert into cliente values (12, "Dani",20, "Dani34", 56);
insert into cliente values (18, "Dani",12, "Dani34", 56);
insert into cliente values (191, "Dani",109, "Dani34", 56);
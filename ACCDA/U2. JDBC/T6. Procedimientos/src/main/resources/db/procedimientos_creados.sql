use bd_neptuno2;

delimiter $$

drop procedure if exists getCategoriaName $$
create procedure getCategoriaName
	(in idCat int, out cat varchar(255))
begin
	select * into cat
    from categorias
    where id = idCat;
end $$

drop procedure if exists updateCategoriaDesc $$
create procedure updateCategoriaDesc
	(in idCat int, in descrip varchar(255))
begin
	update categorias set descripcion = descrip where id = idCat;
end $$

delimiter ;

select * from categorias;
create database BDCASSUZ;
use BDCASSUZ;


/*tablas Promotor*/
CREATE TABLE tblpromotor(
	
	dnipromotor varchar(8) primary key,
	nompromotor varchar(30) not null,
	apepromotor varchar(100) not null,
	direccpromotor varchar(100),
	telefpromotor varchar(9) not null,
	fechanacimiento date not null,
	recomepromotor varchar(15),
	fechainscpromotor date);

/*Crear PROMOTOR*/
create procedure SP_C_PROMOTOR(
@dnipromotor as varchar(8),
@nompromotor as varchar(30),
@apepromotor as varchar(50),
@direccpromotor as varchar(100),
@telefpromotor as varchar(15),
@fechanacimiento as varchar(50),
@recomepromotor as varchar(15),
@fechainscpromotor as date)
AS
begin

insert into tblpromotor(dnipromotor,nompromotor,apepromotor,direccpromotor,telefpromotor,fechanacimiento,recomepromotor,fechainscpromotor) 
values(@dnipromotor,@nompromotor,@apepromotor,@direccpromotor,@telefpromotor,@fechanacimiento,@recomepromotor,@fechainscpromotor)

end;

/*Modificar promotor*/
create procedure SP_U_PROMOTOR(
@dnipromotor as varchar(8),
@nompromotor as varchar(30),
@apepromotor as varchar(50),
@direccpromotor as varchar(100),
@telefpromotor as varchar(15),
@fechanacimiento as varchar(50),
@recomepromotor as varchar(15))
AS
BEGIN

update tblpromotor set nompromotor=@nompromotor,
					   apepromotor=@apepromotor,
					   direccpromotor=@direccpromotor,
					   telefpromotor=@telefpromotor,
					   fechanacimiento=@fechanacimiento,
					   recomepromotor=@recomepromotor
					   where dnipromotor=@dnipromotor;

END

/*Eliminar Promotor*/
create proc SP_D_PROMOTOR(@dnipromotor as varchar(8))
AS
BEGIN

	delete from tblpromotor where dnipromotor=@dnipromotor 

END;


/* Mostrar Promotores*/
create procedure SP_R_PROMOTOR
as
begin
select * from tblpromotor;
end

drop procedure SP_B_PROMOTOR
/*Buscar Promotor*/
create procedure SP_B_PROMOTOR(@dnipromotor varchar(8))
as
begin

select nompromotor,apepromotor from tblpromotor where dnipromotor=@dnipromotor

end

exec SP_B_PROMOTOR '75484126'


/*tabla Rol*/
create table tblrol(
idrol int primary key identity,
nomrol varchar(50))

insert into tblrol values('Administrador');
insert into tblrol values('Vendedor');


/*mostrar rol*/
create procedure SP_R_ROLUSUARIO
as
begin

select * from tblrol 

end



/*tablas Usuarios*/
create table tblusuario(
nomusuario varchar(150) not null,
apeusuario varchar(150) not null,
telefusuario varchar(9) not  null,
usuariosusuario varchar(100) primary key,
contrausaurio varchar(150) not  null,
idrol int,
foreign key (idrol) references tblrol (idrol));

insert into tblusuario values('Axel','Gutierrez Palomino','959901920','Axl','1234',1)
select tblrol.idrol,nomrol,usuariosusuario from tblusuario inner join tblrol on tblusuario.idrol=tblrol.idrol

drop procedure SP_C_USUARIO
/*Crear Usaurio*/
create procedure SP_C_USUARIO(
@nomusaurio as varchar(150),
@apeusuario as varchar(150),
@telefusuario as varchar(9),
@usuariosusuario as varchar(100),
@contrausaurio as varchar(150),
@idrol as int)
as
begin

insert into tblusuario select @nomusaurio,@apeusuario,@telefusuario,@usuariosusuario,
@contrausaurio,@idrol from tblusuario inner join tblrol on
tblusuario.idrol=tblrol.idrol where nomrol=@nomrol

end

/*Mostrar Usuarios*/
create procedure SP_R_USUARIO
as
begin

select nomusuario,apeusuario,telefusuario,usuariosusuario,contrausaurio,tblrol.nomrol 
from tblusuario inner join tblrol on tblusuario.idrol=tblrol.idrol 

end


/*Modificar Usuario*/
create procedure SP_U_USUARIO(
@nomusuario as varchar(150),
@apeusuario as varchar(150),
@telefusuario as varchar(9),
@usuariosusuario as varchar(100),
@contrausaurio as varchar(150),
@idrol as int)
as
begin

UPDATE tblusuario set nomusuario=@nomusuario,
apeusuario=@apeusuario,
telefusuario=@telefusuario,
contrausaurio=@contrausaurio,
idrol=@idrol
where usuariosusuario=@usuariosusuario;

end

/*Eliminar usuario*/
create procedure SP_D_USUARIO(@usuariosusuario as varchar(150))
as
begin
delete from tblusuario where usuariosusuario=@usuariosusuario;
end

select * from tblcatalogo
/*tablas catalogo*/
drop table tblcatalogo
create table tblcatalogo(
idcatalogo int  primary key Identity,
nomcatalogo varchar(50) not null,
reprecatalogo varchar(150) not null,
telefcatalogo varchar (9),
estadocatalogo varchar(50)
)

/*Crear catalogo*/
create procedure SP_C_CATALOGO(
@estadocatalogo varchar(50),
@nomcatalogo as varchar(50),
@reprecatalogo varchar(150),
@telefcatalogo as varchar(9))
as
begin

insert into tblcatalogo(estadocatalogo,nomcatalogo,reprecatalogo,telefcatalogo) values(@estadocatalogo,@nomcatalogo,@reprecatalogo,@telefcatalogo)

end;

exec SP_C_CATALOGO '2020-06-02','Dolcezza','Irma','959901920'

EXEC SP_D_CATALOGO 1
DROP PROCEDURE SP_R_CATALOGO
/*Mostrar catalogo*/
create procedure SP_R_CATALOGO
as
begin

select idcatalogo,nomcatalogo,reprecatalogo,telefcatalogo,estadocatalogo from tblcatalogo ORDER BY idcatalogo asc

end

EXEC SP_R_CATALOGO

drop procedure SP_U_CA
/*Modificar Catalogo*/
create procedure SP_U_CATALOGO(
@idcatalogo as int,
@estadocatalogo as varchar(50),
@nomcatalogo as varchar(50),
@reprecatalogo as varchar(150),
@telefcatalogo as varchar(9))
as
begin

update tblcatalogo set
estadocatalogo=@estadocatalogo,
nomcatalogo=@nomcatalogo,
reprecatalogo=@reprecatalogo,
telefcatalogo=@telefcatalogo
where idcatalogo=@idcatalogo

end

/*Eliminar catalogo*/
create procedure SP_D_CATALOGO(@idcatalogo as varchar(50))
as
begin

delete from tblcatalogo where idcatalogo=@idcatalogo

end;


/*tabla de listas de precios*/
drop table tbllistaprecio
create table tbllistaprecio(
idproducto int primary key identity,
pagproducto int not null,
marcaproducto varchar(50),
codproducto varchar(50),
colorproducto VARCHAR(50),
preciopublicoproducto decimal(7,2),
preciopromotorproducto decimal(7,2),
nomcatalog int,
foreign key (nomcatalog) references tblcatalogo(idcatalogo));

create procedure SP_C_ListaPrecios(
@pagproducto as int,
@marcaproducto as varchar(50),
@codproducto as varchar(50),
@colorproducto as varchar(50),
@preciopublicoproducto as decimal(7,2),
@preciopromotorproducto as decimal(7,2),
@nomcatalogo as int
)
as
;



/*tabla de pedidos*/
create table tblpedido(
idpedido int primary key identity,
fechapedido date,
pagcatalogo int,
marcaproducto varchar(50),
colorproducto varchar(50),
tallaproducto varchar(5),
precioproducto decimal(7,2),
dnipromotor varchar(8),
codproducto varchar(15),
idcatalogo int,
foreign key (dnipromotor) references tblpromotor(dnipromotor),
foreign key (idcatalogo) references tblcatalogo(idcatalogo))

select * from tblpedido
insert into tblpedido(dnipromotor,idcatalogo,pagcatalogo,codproducto,marcaproducto,colorproducto,tallaproducto,precioproducto,fechapedido) values('75484126',1,'10','154145','m','rojo','x',100,'2021-10-12')
/*Registrar Pedido*/
drop procedure SP_C_PEDIDO
create procedure SP_C_PEDIDO(
@dnipromotor as varchar(8),
@idcatalogo int,
@pagcatalogo int,
@codproducto varchar(15),
@marcaproducto varchar(50),
@colorproducto varchar(50),
@tallaproducto varchar(5),
@precioproducto decimal(3,2),
@fechapedido as date)
as
begin

insert into tblpedido(dnipromotor,idcatalogo,pagcatalogo,codproducto,
			marcaproducto,colorproducto,tallaproducto,precioproducto,
			fechapedido) values(@dnipromotor,@idcatalogo,@pagcatalogo,@codproducto,
			@marcaproducto,@colorproducto,@tallaproducto,@precioproducto,@fechapedido)

end

exec SP_R_CATALOGO

DRop procedure SP_R_PEDIDO
/*Mostrar Pedidos*/
create procedure SP_R_PEDIDO
as
begin 

select idpedido,tblpromotor.dnipromotor,nompromotor,apepromotor,tblcatalogo.nomcatalogo,
pagcatalogo,codproducto,marcaproducto,colorproducto,marcaproducto,precioproducto,fechapedido from tblpedido inner join tblpromotor on tblpedido.dnipromotor=tblpromotor.dnipromotor inner join 
tblcatalogo on tblpedido.idcatalogo=tblcatalogo.idcatalogo order by idpedido asc


end

exec SP_R_PEDIDO
drop procedure SP_U_PEDIDO
/*modificar pedido*/
create procedure SP_U_PEDIDO(
@idpedido int,
@dnipromotor as varchar(8),
@nomcatalogo as varchar(50),
@pagcatalogo int,
@codproducto varchar(15),
@marcaproducto varchar(50),
@colorproducto varchar(50),
@tallaproducto varchar(5),
@precioproducto decimal(7,2))
as
begin

update tblpedido set dnipromotor=@dnipromotor,
					 idcatalogo=(select idcatalogo from tblcatalogo where nomcatalogo=@nomcatalogo),
					 pagcatalogo=@pagcatalogo,
					 codproducto=@codproducto,
					 marcaproducto=@marcaproducto,
					 colorproducto=@colorproducto,
					 tallaproducto=@tallaproducto,
					 precioproducto=@precioproducto
where idpedido=@idpedido

end

/*Eliminar Pedido Store Procedure*/
create procedure SP_D_PEDIDO(@idpedido int)
as
begin

delete from tblpedido where idpedido=@idpedido

end


/*Pruebas de los procedimientos*/

exec SP_R_CATALOGO
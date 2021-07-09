create database BDCASSUZ;
use BDCASSUZ;

drop table tblpromotor
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
drop procedure SP_C_PROMOTOR
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

drop procedure SP_U_PROMOTOR
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
select * from tblpromotor;

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

exec SP_R_ROLUSUARIO
drop procedure SP_R_ROLUSUARIO

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

insert into tblusuario(nomusuario,apeusuario,telefusuario,usuariosusuario,
contrausaurio,idrol) values(@nomusaurio,@apeusuario,@telefusuario,@usuariosusuario,
@contrausaurio,@idrol)

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

drop table tblcatalogo
/*tablas catalogo*/
create table tblcatalogo(
idcatalogo int  primary key Identity,
fechacatalogo date not null,
nomcatalogo varchar(50) not null,
reprecatalogo varchar(150) not null,
telefcatalogo varchar (9)
)

/*Crear catalogo*/
create procedure SP_C_CATALOGO(@fechacatalogo date,@nomcatalogo as varchar(50),
@reprecatalogo varchar(150),
@telefcatalogo as varchar(9))
as
begin

insert into tblcatalogo(fechacatalogo,nomcatalogo,reprecatalogo,telefcatalogo) values(@fechacatalogo,@nomcatalogo,@reprecatalogo,@telefcatalogo)

end;

exec SP_C_CATALOGO '2020-06-02','Dolcezza','Irma','959901920'


/*Mostrar catalogo*/
create procedure SP_R_CATALOGO
as
begin

select idcatalogo,nomcatalogo,reprecatalogo,telefcatalogo,fechacatalogo from tblcatalogo ORDER BY idcatalogo asc

end

EXEC SP_R_CATALOGO


/*Modificar Catalogo*/
create procedure SP_U_CATALOGO(
@idcatalogo as int,
@fechacatalogo as date,
@nomcatalogo as varchar(50),
@reprecatalogo as varchar(150),
@telefcatalogo as varchar(9))
as
begin

update tblcatalogo set
fechacatalogo=@fechacatalogo,
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

DROP TABLE tbllistaprecio
/*tabla de listas de precios*/
create table tbllistaprecio(
idproducto int primary key identity,
pagproducto int not null,
marcaproducto varchar(50),
codproducto nvarchar(50),
colorproducto VARCHAR(50),
preciopublicoproducto decimal(7,2),
preciopromotorproducto decimal(7,2),
nomcatalog varchar(50),
foreign key (nomcatalog) references tblcatalogo(nomcatalogo));


drop table tblpedido
/*tabla de pedidos*/
create table tblpedido(
idpedido int primary key identity,
fechapedido date,
pagcatalogo int,
marcaproducto varchar(50),
colorproducto varchar(50),
tallaproducto varchar(5),
precioproducto decimal(3,2),
dnipromotor varchar(8),
codproducto varchar(15),
idcatalogo int,
foreign key (dnipromotor) references tblpromotor(dnipromotor),
foreign key (idcatalogo) references tblcatalogo(idcatalogo))

drop procedure SP_C_PEDIDO
/*Registrar Pedido*/
create procedure SP_C_PEDIDO(
@dnipromotor varchar(8),
@fechapedido date,
@dnipromotor varchar(8),
@codproducto varchar(4))
as
begin

insert into tblpedido values(@fechapedido,@dnipromotor,@codproducto)


end

drop procedure SP_R_PEDIDO
/*Mostrar Pedidos*/
create procedure SP_R_PEDIDO
as
begin 

select idpedido,tblpromotor.dnipromotor,tblpromotor.nompromotor,
tblpromotor.apepromotor,tblproducto.nomcatalogo,tblproducto.codproducto,colorproducto,talla,precio,
fechainscpromotor
from tblpedido inner join tblpromotor on
tblpromotor.dnipromotor=tblpedido.dnipromotor inner join tblproducto on
tblproducto.codproducto=tblpedido.codproducto

end


/*Pruebas de los procedimientos*/
exec SP_C_CATALOGO 'Fravia','123','959901920'
exec SP_R_CATALOGO
exec SP_U_CATALOGO 'xD','123','123456789' 
exec SP_D_CATALOGO 2
 
 select * from tblusuario
 delete from tblusuario where usuariosusuario='Airton'
exec SP_C_USUARIO '1234','Gutierrez Palomino','959901920','1234','1234',2
exec SP_R_USUARIO 
exec SP_U_USUARIO 'Aasd','adsdss','45677895','Axl','1234',1
exec SP_D_USUARIO 'Axel'


exec SP_C_PROMOTOR '75484124','Axel','Gutierrez Palomino','jr san carlos','959901920','axelgupa18@gmail.com','karin quispe','2026-10-26';
exec SP_R_PROMOTOR;
exec SP_U_PROMOTOR '75484126','Axel','Gutierrez Palomino','jr san carlos','99225646','axelguty@gmail.com','karin quispe';
exec SP_D_PROMOTOR '75484126';
exec SP_B_BUSCAR '75484126'
     
exec SP_R_PRODUCTO
exec SP_R_PEDIDO
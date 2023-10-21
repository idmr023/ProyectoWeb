DROP DATABASE IF EXISTS bdHotelAntares;
CREATE DATABASE bdHotelAntares;

USE  bdHotelAntares;

create table empleados(
    emp_codigo char(9) not null primary key,
    emp_apellido varchar(30),
    emp_nombre varchar(30),
    emp_sexo char(1),
    emp_correo varchar(30),
    emp_celular varchar(15),
    emp_cargo varchar(30));
    

insert into empleados values('U21204083', 'Bermudez', 'Diego', 'M', 'pedro@utp.edu.pe', '970088165', 'Recepcionista');
insert into empleados values('U21225065', 'Manrique', 'Ivan', 'M', 'u21225065@utp.edu.pe', '934584437', 'Recepcionista');
insert into empleados values('U21200225', 'Occ', 'Mario', 'M', 'pedro@utp.edu.pe', '953769439', 'Recepcionista');
insert into empleados values('U21201266', 'Chaname', 'Cristhian', 'M', 'pedro@utp.edu.pe', '900621989', 'Administrador');    

create table clientes(
    cli_dni char(8) not null primary key,
    cli_apellido varchar(30),
    cli_nombre varchar(30),
    cli_sexo char(1),
    cli_celular varchar(15));
    
insert into clientes values('17458522', 'Rios', 'Janet', 'F', '952487587');
insert into clientes values('17654785', 'Lizarraga', 'Alejandra', 'F', '914789852');
insert into clientes values('18547475', 'Lopez', 'Diana', 'F', '987885745');
insert into clientes values('60457845', 'Perez', 'Ernesto', 'M', '925478855');
insert into clientes values('65898589', 'Hurtado', 'Maria', 'F', '987180625');
insert into clientes values('68957845', 'Velasquez', 'Israel', 'M', '988741589');
insert into clientes values('70510917', 'Chaname' , 'Renato', 'M', '980523566');
insert into clientes values('70510918', 'Chaname' , 'Cristhian', 'M', '900621989');
insert into clientes values('74589685', 'Vasquez' , 'Jhayr', 'M', '990852745');

create table habitaciones(
    hab_codigo char(4) not null primary key,
    hab_tipo varchar(12),
    hab_estado varchar(15));
    
insert into habitaciones values('H101', 'Simple', 'Disponible');
insert into habitaciones values('H102', 'Simple', 'Disponible');
insert into habitaciones values('H103', 'Simple', 'Disponible');
insert into habitaciones values('H104', 'Simple', 'Disponible');
insert into habitaciones values('H105', 'Simple', 'Disponible');
insert into habitaciones values('H106', 'Doble', 'Disponible');
insert into habitaciones values('H107', 'Doble', 'Disponible');
insert into habitaciones values('H108', 'Doble', 'Disponible');
insert into habitaciones values('H109', 'Doble', 'Disponible');
insert into habitaciones values('H110', 'Doble', 'Disponible');
insert into habitaciones values('H111', 'Matrimonial', 'Disponible');
insert into habitaciones values('H112', 'Matrimonial', 'Disponible');
insert into habitaciones values('H113', 'Matrimonial', 'Disponible');
insert into habitaciones values('H114', 'Matrimonial', 'Disponible');
insert into habitaciones values('H115', 'Matrimonial', 'Disponible');
insert into habitaciones values('H116', 'Simple', 'Disponible');
insert into habitaciones values('H117', 'Doble', 'Disponible');
insert into habitaciones values('H118', 'Matrimonial', 'Disponible');
insert into habitaciones values('H119', 'Simple', 'Disponible');

create table precioHabitaciones(
    hab_tipo varchar(12) not null primary key,
    hab_precio double);

insert into precioHabitaciones values('Simple', 30);
insert into precioHabitaciones values('Doble', 45);
insert into precioHabitaciones values('Matrimonial', 60);

create table servicios(
    ser_codigo char(4) not null primary key,
    ser_tipo varchar(30),
    ser_precio double);

insert into servicios values('S001', 'Lavanderia', 25);
insert into servicios values('S002', 'Alimentacion', 50);
insert into servicios values('S003', 'Estacionamiento', 30);
insert into servicios values('S004', 'Gimnasio', 25);
insert into servicios values('S005', 'Spa', 60);

create table alquileres(
    alq_codigo char(6) not null primary key,
    hab_codigo char(4),
    cli_dni char(8),
    alq_fechaIngreso date,
    alq_fechaSalida date,
    emp_codigo char(9),
    alq_estado varchar(15));
      
insert into alquileres values('A00001', 'H111', '68957845', '2023-01-07', '2023-01-11', 'U21204083', 'Finalizado');
insert into alquileres values('A00002', 'H102', '17654785', '2022-12-26', '2022-12-31', 'U21204083', 'Finalizado');
insert into alquileres values('A00003', 'H106', '65898589', '2023-02-01', '2023-02-05', 'U21204083', 'Finalizado');
insert into alquileres values('A00004', 'H101', '70510918', '2023-02-19', '2023-02-22', 'U21225065', 'Finalizado');
insert into alquileres values('A00005', 'H116', '70510917', '2023-02-28', '2023-03-01', 'U21225065', 'Finalizado');
insert into alquileres values('A00006', 'H105', '65898589', '2023-02-28', '2023-03-02', 'U21225065', 'Finalizado');
insert into alquileres values('A00007', 'H111', '74589685', '2023-03-01', '2023-03-02', 'U21200225', 'Finalizado');
insert into alquileres values('A00008', 'H110', '18547475', '2023-03-01', '2023-03-02', 'U21200225', 'Finalizado');
insert into alquileres values('A00009', 'H109', '68957845', '2023-03-03', '2023-03-06', 'U21200225', 'Finalizado');
insert into alquileres values('A00010', 'H112', '60457845', '2023-03-03', '2023-03-07', 'U21201266', 'Finalizado');
insert into alquileres values('A00011', 'H108', '17458522', '2023-03-04', '2023-03-08', 'U21201266', 'Finalizado');
insert into alquileres values('A00012', 'H115', '17654785', '2023-03-04', '2023-03-06', 'U21201266', 'Finalizado');

create table alquilerServicio(
    alq_codigo char(6) not null,
    ser_codigo char(4) not null,
    ser_tipo varchar(30),
    alqSer_fechaInicio  date,
    alqSer_fechaFin  date,
    emp_codigo char(9), primary key(alq_codigo, ser_codigo));

insert into alquilerServicio values('A00001', 'S001', 'Lavanderia', '2023-01-07', '2023-01-11', 'U21204083');
insert into alquilerServicio values('A00001', 'S002', 'Alimentacion', '2023-01-07', '2023-01-11', 'U21204083');
insert into alquilerServicio values('A00004', 'S001', 'Lavanderia', '2023-02-19', '2023-02-22', 'U21225065');
insert into alquilerServicio values('A00004', 'S003', 'Estacionamiento', '2023-02-19', '2023-02-22', 'U21225065');
insert into alquilerServicio values('A00004', 'S004', 'Gimnasio', '2023-02-19', '2023-02-22', 'U21225065');
insert into alquilerServicio values('A00007', 'S005', 'Spa', '2023-03-01', '2023-03-02', 'U21200225');
insert into alquilerServicio values('A00010', 'S001', 'Lavanderia', '2023-03-03', '2023-03-07', 'U21201266');
insert into alquilerServicio values('A00010', 'S003', 'Estacionamiento', '2023-03-03', '2023-03-07', 'U21201266');
insert into alquilerServicio values('A00010', 'S004', 'Gimnasio', '2023-03-03', '2023-03-07', 'U21201266');
insert into alquilerServicio values('A00010', 'S005', 'Spa', '2023-03-06', '2023-03-07', 'U21201266');
insert into alquilerServicio values('A00012', 'S003', 'Estacionamiento', '2023-03-04', '2023-03-06', 'U21201266');
insert into alquilerServicio values('A00012', 'S002', 'Alimentacion', '2023-03-04', '2023-03-06', 'U21201266');


create table pagos(
    pa_codigo char(6) not null primary key,
    pa_fecha date,
    alq_codigo char(6),
    cli_dni char(8),
    pa_total double);
    
insert into pagos values('P00001', '2022-12-31', 'A00002', '17654785', 150);
insert into pagos values('P00002', '2023-01-11', 'A00001', '68957845', 540);
insert into pagos values('P00003', '2023-02-05', 'A00003', '65898589', 180);
insert into pagos values('P00004', '2023-02-22', 'A00004', '70510918', 330);
insert into pagos values('P00005', '2023-03-01', 'A00005',  '70510917', 30);
insert into pagos values('P00006', '2023-03-02', 'A00006', '65898589', 60);
insert into pagos values('P00007', '2023-03-02', 'A00007', '74589685', 120);
insert into pagos values('P00008', '2023-03-02', 'A00008', '18547475', 45);
insert into pagos values('P00009', '2023-03-06', 'A00009', '68957845', 135);
insert into pagos values('P00010', '2023-03-06', 'A00012', '17654785', 280);
insert into pagos values('P00011', '2023-03-07', 'A00010', '60457845', 620);
insert into pagos values('P00012', '2023-03-08', 'A00011', '17458522', 180);

create table pagoDetalle(
    pa_codigo char(6),
    alq_codigo char(6),
    paDeta_concepto varchar(30),
    paDeta_dias int);

insert into pagoDetalle values('P00001', 'A00002', 'Habitacion Simple', 5);
insert into pagoDetalle values('P00002', 'A00001', 'Habitacion Matrimonial', 4);
insert into pagoDetalle values('P00002', 'A00001', 'Lavanderia', 4);
insert into pagoDetalle values('P00002', 'A00001', 'Alimentacion', 4);
insert into pagoDetalle values('P00003', 'A00003', 'Habitacion Doble', 4);
insert into pagoDetalle values('P00004', 'A00004', 'Habitacion Simple', 3);
insert into pagoDetalle values('P00004', 'A00004', 'Lavanderia', 3);
insert into pagoDetalle values('P00004', 'A00004', 'Estacionamiento', 3);
insert into pagoDetalle values('P00004', 'A00004', 'Gimnasio', 3);
insert into pagoDetalle values('P00005', 'A00005', 'Habitacion Simple', 1);
insert into pagoDetalle values('P00006', 'A00006', 'Habitacion Simple', 2);
insert into pagoDetalle values('P00007', 'A00007', 'Habitacion Matrimonial', 1);
insert into pagoDetalle values('P00007', 'A00007', 'Spa', 1);
insert into pagoDetalle values('P00008', 'A00008', 'Habitacion Doble', 1);
insert into pagoDetalle values('P00009', 'A00009', 'Habitacion Doble', 3);
insert into pagoDetalle values('P00010', 'A00012', 'Habitacion Matrimonial', 2);
insert into pagoDetalle values('P00010', 'A00012', 'Estacionamiento', 2);
insert into pagoDetalle values('P00010', 'A00012', 'Alimentacion', 2);
insert into pagoDetalle values('P00011', 'A00010', 'Habitacion Matrimonial', 4);
insert into pagoDetalle values('P00011', 'A00010', 'Lavanderia', 4);
insert into pagoDetalle values('P00011', 'A00010', 'Estacionamiento', 4);
insert into pagoDetalle values('P00011', 'A00010', 'Gimnasio', 4);
insert into pagoDetalle values('P00011', 'A00010', 'Spa', 1);
insert into pagoDetalle values('P00012', 'A00011', 'Habitacion Doble', 4);


================================================================================
//PROCEDIMIENTO PARA AGREGAR UN NUEVO ALQUILER
DELIMITER @@
DROP PROCEDURE if exists alqAgregar @@
CREATE PROCEDURE bdhotelantares.alqAgregar
(hab char(4), cliente char(8), ingreso date, salida date, empleado char(9))
begin
declare cuenta int;
declare alq char(6);
select right(max(alq_codigo),5)+1 into cuenta from alquileres;
set alq=concat('A',Lpad(cuenta,5,'0'));
insert into alquileres values(alq,hab,cliente,ingreso,salida, empleado, 'Activo');
update habitaciones set hab_estado='Ocupada' where hab_codigo=hab;
select alq;
end @@ 
DELIMITER ;

//PROCEDIMIENTO PARA AGREGAR UNA NUEVA HABITACION
DELIMITER @@
DROP PROCEDURE if exists habAgregar @@
CREATE PROCEDURE bdhotelantares.habAgregar
(tipo varchar(12), estado varchar(15))
begin
declare cuenta int;
declare hab char(4);
select right(max(hab_numero),3)+1 into cuenta from habitaciones;
set hab=concat('H',cuenta);
insert into habitaciones values(hab,tipo,estado);
select hab;
end @@ 
DELIMITER ;  

//PROCEDIMIENTO PARA AGREGAR UN NUEVO PAGO
DELIMITER @@
DROP PROCEDURE if exists paAgregar @@
CREATE PROCEDURE bdhotelantares.paAgregar
(codAlq char(6), dni char(8), total double)
begin
declare cuenta int;
declare pa char(6);
select right(max(pa_codigo),5)+1 into cuenta from pagos;
set pa=concat('P',Lpad(cuenta,5,'0'));
insert into pagos values(pa,curdate(),codAlq,dni,total);
select pa;
end @@ 
DELIMITER ;   


//Gráfico

use bdhotelantares;
drop procedure if exists spventa;
create procedure spventa(an int)
select month(pa_fecha) mes, sum(pa_total) total
from pagos p join pagodetalle pd 
on p.pa_codigo=pd.pa_codigo
where year(pa_fecha)=an
group by month(pa_fecha);

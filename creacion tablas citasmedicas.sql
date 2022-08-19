Create Database DBCitasMedicas
go
use DBCitasMedicas
go
Create Table TblConsultorios (
	IdConsultorio int IDENTITY(1,1) not null,
	Nombre varchar(50) not null,
	Primary Key (IdConsultorio)
	)

Create Table TblPacientes (
	IdPaciente varchar(12) not null,
	Nombre1 varchar(50) not null,
	Nombre2 varchar(50),
	Apellido1 varchar(50) not null,
	Apellido2 varchar(50),
	Fechanacimiento date not null,
	Sexo char not null check (Sexo in('M','F')),
	Primary key (IdPaciente)
	)

Create Table TblTratamientos (
	IdTratamiento int Identity(1,1) not null,
	FechaAsignado date not null,
	DescripcionTrat text,
	FechaInicio date, 
	FechaFin date,
	ObservacionesTrat text,
	PacienteTrat varchar(12) not null,
	Primary key (IdTratamiento),
	Foreign key (PacienteTrat)
	references TblPacientes(IdPaciente)
	)

Create table TblMedicos(
	IdMedico varchar(12) not null,
	MdNombre1 varchar(50) not null,
	MdNombre2 varchar(50),
	MdApellido1 varchar(50) not null,
	MdApellido2 varchar(50),
	Fechanacimiento date not null,
	MdEspecialidad varchar(50),
	Primary key (IdMedico)
	)

Create Table TblCitas (
   IdCita int IDENTITY(1,1) not null,
   FechaCita date not null,
   HoraCita time not null,
   PacCita varchar(12),
   MdCita varchar(12),
   ConsCita int,
   EstadoCita varchar(12) not null check(EstadoCita in ('Asignada','Solicitada','Cumplida','Cancelada')),
   ObservacionesCita text,
   Primary key (IdCita),
   Foreign key (PacCita) references TblPacientes(IdPaciente),
   Foreign key (MdCita) references TblMedicos (IdMedico),
   Foreign key (ConsCita) references TblConsultorios (IdConsultorio)
   )

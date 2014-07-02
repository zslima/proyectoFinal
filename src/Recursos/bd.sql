CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  categoria VARCHAR(45) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Cliente (
  idCliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NULL,
  apellidos VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono CHAR(9) NULL,
  fecha_nac DATE NULL,
  PRIMARY KEY(idCliente)
);

CREATE TABLE Detalle_Venta (
  idProducto INTEGER UNSIGNED NOT NULL,
  idVenta INTEGER UNSIGNED NOT NULL,
  cantidad INTEGER UNSIGNED NULL,
  descuento DOUBLE(2,1) NULL,
  precio DOUBLE(2,1) NULL
);

CREATE TABLE empleado (
  idempleado INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NULL,
  apellidos VARCHAR(45) NULL,
  sexo CHAR(1) NULL,
  direccion VARCHAR(45) NULL,
  telefono CHAR(9) NULL,
  GradoInstruccion VARCHAR(45) NULL,
  PRIMARY KEY(idempleado)
);

CREATE TABLE previlegios (
  idprevilegios INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INTEGER UNSIGNED NOT NULL,
  idempleado INTEGER UNSIGNED NOT NULL,
  idrol INTEGER UNSIGNED NOT NULL,
  NombreP VARCHAR(45) NULL,
  PRIMARY KEY(idprevilegios)
);

CREATE TABLE Productos (
  idProducto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  producto VARCHAR(25) NULL,
  cantidad INTEGER UNSIGNED NULL,
  precio DOUBLE(4,2) NULL,
  PRIMARY KEY(idProducto)
);

CREATE TABLE rol (
  idrol INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idempleado INTEGER UNSIGNED NOT NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  NombreR VARCHAR(45) NULL,
  PRIMARY KEY(idrol, idempleado, idUsuario)
);

CREATE TABLE Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idempleado INTEGER UNSIGNED NOT NULL,
  usuario VARCHAR(45) NULL,
  clave VARCHAR(45) NULL,
  PRIMARY KEY(idUsuario, idempleado)
);

CREATE TABLE Venta (
  idVenta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idempleado INTEGER UNSIGNED NOT NULL,
  idCliente INTEGER UNSIGNED NOT NULL,
  fecha DATE NULL,
  hora TIME NULL,
  cod_doc INTEGER UNSIGNED NULL,
  tipo_doc CHAR(20) NULL,
  PRIMARY KEY(idVenta)
);



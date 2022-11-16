# jacidiApp

#Instalar mvn 3.8.6: Agregar carpeta descompirmida mvn a C:\home.

#Clonar el proyecto

#Congigurar variables de entorno en sistema.

#Utilizar intellij de preferencia. Realizar comando mvn clean install de ser necesario.
#Ejecutar el proyecto.

#Crear bases de datos solicitadas.
CREATE TABLE `jacidi`.`membership` (
  `id_membership` INT NOT NULL AUTO_INCREMENT,
  `key_membership` VARCHAR(45) NULL,
  `name` VARCHAR(100) NULL,
  `prio` VARCHAR(45) NULL,
  `duration` BIGINT NULL,
  PRIMARY KEY (`idMembership`));


CREATE TABLE `jacidi`.`client` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `dni` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `last_delivery` DATETIME NULL,
  `next_renewal` DATETIME NULL,
  `id_membership` INT NOT NULL,
  PRIMARY KEY (`idClient`),  
    FOREIGN KEY (`id_membership`)
    REFERENCES `jacidi`.`membership` (`idMembership`));


CREATE TABLE `jacidi`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `cost` DECIMAL NULL,
  `min_prio` INT NULL,
  PRIMARY KEY (`idproduct`));

CREATE TABLE `jacidi`.`shipment` (
  `id_shipment` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NOT NULL,
  `total_cost` DECIMAL NOT NULL,
  `deliver_date` DATETIME NULL,
  PRIMARY KEY (`idshipment`),
 FOREIGN KEY (`id_client`)
    REFERENCES `jacidi`.`client` (`idClient`));



CREATE TABLE `jacidi`.`shipment_products` (
  `idshipment_products` INT NOT NULL AUTO_INCREMENT,
  `id_shipment` INT NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`idshipment_products`),
  INDEX `id_product_idx` (`id_product` ASC),
  INDEX `id_shipment_idx` (`id_shipment` ASC),
    FOREIGN KEY (`id_product`)
    REFERENCES `jacidi`.`product` (`idproduct`), 
    FOREIGN KEY (`id_shipment`)
    REFERENCES `jacidi`.`shipment` (`idshipment`)
    );
    
#password db: jacidi
#user db: root

#Probar endPoints creados en los controladores de la aplicacion.

# docker buil -t app-jacidi:1.0 .

# docker run --net=host -p 8080:8080 $idImage
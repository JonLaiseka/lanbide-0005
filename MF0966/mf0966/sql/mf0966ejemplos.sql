-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mf0966ejemplo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mf0966ejemplo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mf0966ejemplo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `mf0966ejemplo` ;

-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(12,2) NOT NULL,
  `descripcion` TEXT(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`clientes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nif` CHAR(9) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `IX_NIF` (`nif` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`empleados` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nif` CHAR(9) NOT NULL,
  `jefe_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `IX_NIF` (`nif` ASC) VISIBLE,
  INDEX `fk_empleados_empleados1_idx` (`jefe_id` ASC) VISIBLE,
  CONSTRAINT `fk_empleados_empleados1`
    FOREIGN KEY (`jefe_id`)
    REFERENCES `mf0966ejemplo`.`empleados` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`facturas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `clientes_id` BIGINT NOT NULL,
  `empleados_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_facturas_clientes1_idx` (`clientes_id` ASC) VISIBLE,
  INDEX `fk_facturas_empleados1_idx` (`empleados_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `mf0966ejemplo`.`clientes` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_facturas_empleados1`
    FOREIGN KEY (`empleados_id`)
    REFERENCES `mf0966ejemplo`.`empleados` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `clientes_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_usuarios_clientes_idx` (`clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `mf0966ejemplo`.`clientes` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mf0966ejemplo`.`facturas_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mf0966ejemplo`.`facturas_has_productos` (
  `facturas_id` BIGINT NOT NULL,
  `productos_id` BIGINT NOT NULL,
  `cantidad` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`facturas_id`, `productos_id`),
  INDEX `fk_facturas_has_productos_productos1_idx` (`productos_id` ASC) VISIBLE,
  INDEX `fk_facturas_has_productos_facturas1_idx` (`facturas_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_has_productos_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `mf0966ejemplo`.`facturas` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_facturas_has_productos_productos1`
    FOREIGN KEY (`productos_id`)
    REFERENCES `mf0966ejemplo`.`productos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

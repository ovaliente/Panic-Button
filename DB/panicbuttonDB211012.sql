SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `PanicButton` ;
CREATE SCHEMA IF NOT EXISTS `PanicButton` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `PanicButton` ;

-- -----------------------------------------------------
-- Table `PanicButton`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PanicButton`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `PanicButton`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `userhash` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PanicButton`.`contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PanicButton`.`contacto` ;

CREATE  TABLE IF NOT EXISTS `PanicButton`.`contacto` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellido` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  `fbmail` VARCHAR(45) NULL ,
  `usuario_id` INT NOT NULL ,
  `contacthash` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_contacto_usuario1_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_contacto_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `PanicButton`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PanicButton`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PanicButton`.`tipo` ;

CREATE  TABLE IF NOT EXISTS `PanicButton`.`tipo` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PanicButton`.`ruta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PanicButton`.`ruta` ;

CREATE  TABLE IF NOT EXISTS `PanicButton`.`ruta` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `fecha` TIMESTAMP NULL ,
  `usuario_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ruta_usuario1` (`usuario_id` ASC) ,
  CONSTRAINT `fk_ruta_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `PanicButton`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PanicButton`.`posicion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PanicButton`.`posicion` ;

CREATE  TABLE IF NOT EXISTS `PanicButton`.`posicion` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `longitud` VARCHAR(45) NULL ,
  `latitud` VARCHAR(45) NULL ,
  `tiempo` DATETIME NULL ,
  `rutahash` VARCHAR(45) NULL ,
  `tipo_id` INT NOT NULL ,
  `ruta_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_posicion_tipo1_idx` (`tipo_id` ASC) ,
  INDEX `fk_posicion_ruta1` (`ruta_id` ASC) ,
  CONSTRAINT `fk_posicion_tipo1`
    FOREIGN KEY (`tipo_id` )
    REFERENCES `PanicButton`.`tipo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_posicion_ruta1`
    FOREIGN KEY (`ruta_id` )
    REFERENCES `PanicButton`.`ruta` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

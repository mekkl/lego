-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lego` ;

-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lego` DEFAULT CHARACTER SET utf8 ;
USE `lego` ;

-- -----------------------------------------------------
-- Table `lego`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`user` (
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `username_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lego`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `placed` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shipped` DATETIME NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_order_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `lego`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Inserting test data
-- -----------------------------------------------------

INSERT INTO user (email,password,role) VALUES 
('kunde@kunde.dk','kunde','customer'),
('ansat@ansat.dk','ansat','employee');

INSERT INTO lego.order (length,width,height,user_email) VALUES
(15,15,3,'kunde@kunde.dk'),
(8,11,4,'kunde@kunde.dk'),
(21,9,6,'kunde@kunde.dk');
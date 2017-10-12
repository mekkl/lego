/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mellem
 * Created: Oct 12, 2017
 */

-- MySQL Workbench Synchronization
-- Generated: 2017-10-12 20:30
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: ML

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `lego`;
CREATE SCHEMA `lego` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `lego`.`user` (
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `username_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `lego`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `shipped` DATETIME NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user1_idx` (`user_email` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `lego`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `lego`.`wall` (
  `id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  `height` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `order_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_wall_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_wall_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `lego`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `lego`.`brickset` (
  `brick_length` INT(11) NOT NULL,
  `brick_amount` INT(11) NOT NULL,
  `wall_id` INT(11) NOT NULL,
  PRIMARY KEY (`brick_length`, `wall_id`),
  INDEX `fk_brickset_wall1_idx` (`wall_id` ASC),
  CONSTRAINT `fk_brickset_wall1`
    FOREIGN KEY (`wall_id`)
    REFERENCES `lego`.`wall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

USE lego;

INSERT INTO user (email,password,role) VALUES 
('kunde@kunde.dk','kunde','customer'),
('ansat@ansat.dk','ansat','employee');
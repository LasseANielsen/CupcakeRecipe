-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CupcakeDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CupcakeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CupcakeDB` DEFAULT CHARACTER SET utf8 ;
USE `CupcakeDB` ;
DROP TABLE IF EXISTS `Product`;
DROP TABLE IF EXISTS `Cart`;
DROP TABLE IF EXISTS `Bottom`;
DROP TABLE IF EXISTS `Toppings`;
DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS `User`;
-- -----------------------------------------------------
-- Table `CupcakeDB`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`User` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `C/A` ENUM('C', 'A') NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CupcakeDB`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`Order` (
  `Id` INT NOT NULL,
  `User_Id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `User_Id_idx` (`User_Id` ASC),
  CONSTRAINT `User_Id`
    FOREIGN KEY (`User_Id`)
    REFERENCES `mydb`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CupcakeDB`.`Toppings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`Toppings` (
  `Id` INT NOT NULL,
  `Price` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CupcakeDB`.`Bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`Bottom` (
  `Id` INT NOT NULL,
  `Price` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CupcakeDB`.`Cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`Cart` (
  `Id` INT NOT NULL,
  `User_Cart_Id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `User_Cart_Id_idx` (`User_Cart_Id` ASC),
  CONSTRAINT `User_Cart_Id`
    FOREIGN KEY (`User_Cart_Id`)
    REFERENCES `CupcakeDB`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CupcakeDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CupcakeDB`.`Product` (
  `Id` INT NOT NULL,
  `Order_Id` INT NOT NULL,
  `Top_Id` INT NOT NULL,
  `Bot_Id` INT NOT NULL,
  `Cart_Id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `Order_idx` (`Order_Id` ASC),
  INDEX `Toppings_idx` (`Top_Id` ASC),
  INDEX `Bottom_idx` (`Bot_Id` ASC),
  INDEX `Cart_idx` (`Cart_Id` ASC),
  CONSTRAINT `Order`
    FOREIGN KEY (`Order_Id`)
    REFERENCES `CupcakeDB`.`Order` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Toppings`
    FOREIGN KEY (`Top_Id`)
    REFERENCES `CupcakeDB`.`Toppings` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Bottom`
    FOREIGN KEY (`Bot_Id`)
    REFERENCES `CupcakeDB`.`Bottom` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Cart`
    FOREIGN KEY (`Cart_Id`)
    REFERENCES `CupcakeDB`.`Cart` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

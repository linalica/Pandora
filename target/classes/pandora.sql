-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pandoradb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pandoradb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pandoradb` DEFAULT CHARACTER SET utf8 ;
USE `pandoradb` ;

-- -----------------------------------------------------
-- Table `pandoradb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_first_name` VARCHAR(255) NULL,
  `user_last_name` VARCHAR(255) NULL,
  `user_username` VARCHAR(255) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL,
  `user_email` VARCHAR(255) NOT NULL,
  `user_enabled` TINYINT(1) NOT NULL DEFAULT 1,
  `user_role` ENUM('role_admin', 'role_verified', 'role_user') NOT NULL DEFAULT 'role_user',
  `user_avatar` LONGBLOB NULL,
  `user_passport` LONGBLOB NULL,
  `user_birthday` DATE NULL,
  `user_creating_time` DATETIME NOT NULL,
  `user_last_login_time` DATETIME NULL,
  `user_language` ENUM('russian', 'english') NOT NULL DEFAULT 'english',
  `user_theme` ENUM('light', 'dark') NOT NULL DEFAULT 'light',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_username_UNIQUE` (`user_username` ASC),
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`projects` (
  `project_id` INT(11) NOT NULL AUTO_INCREMENT,
  `project_name` VARCHAR(255) NULL,
  `project_description` MEDIUMTEXT NULL,
  `project_picture` LONGBLOB NULL,
  `project_creating_time` DATETIME NOT NULL,
  `project_status` ENUM('active', 'financed', 'failed') NOT NULL DEFAULT 'active',
  `project_min_objective_achieved` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`project_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`subscriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`subscriptions` (
  `users_user_id` INT(11) NOT NULL,
  `projects_project_id` INT(11) NOT NULL,
  PRIMARY KEY (`users_user_id`, `projects_project_id`),
  INDEX `fk_users_has_projects_projects1_idx` (`projects_project_id` ASC),
  INDEX `fk_users_has_projects_users_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_users_has_projects_users`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `pandoradb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_projects_projects1`
    FOREIGN KEY (`projects_project_id`)
    REFERENCES `pandoradb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`rating` (
  `users_user_id` INT(11) NOT NULL,
  `projects_project_id` INT(11) NOT NULL,
  `rating_mark` INT NULL,
  PRIMARY KEY (`users_user_id`, `projects_project_id`),
  INDEX `fk_users_has_projects_projects2_idx` (`projects_project_id` ASC),
  INDEX `fk_users_has_projects_users1_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_users_has_projects_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `pandoradb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_projects_projects2`
    FOREIGN KEY (`projects_project_id`)
    REFERENCES `pandoradb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`objectives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`objectives` (
  `objective_id` INT(11) NOT NULL AUTO_INCREMENT,
  `objective_name` VARCHAR(255) NULL,
  `objective_description` MEDIUMTEXT NULL,
  `objective_balance` INT NOT NULL DEFAULT 0,
  `objective_closed` TINYINT(1) NOT NULL DEFAULT 0,
  `objective_min` TINYINT(1) NOT NULL DEFAULT 0,
  `projects_project_id` INT(11) NOT NULL,
  PRIMARY KEY (`objective_id`, `projects_project_id`),
  INDEX `fk_objectives_projects1_idx` (`projects_project_id` ASC),
  CONSTRAINT `fk_objectives_projects1`
    FOREIGN KEY (`projects_project_id`)
    REFERENCES `pandoradb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`tags` (
  `tag_id` INT(11) NOT NULL,
  `tag_value` VARCHAR(255) NULL,
  PRIMARY KEY (`tag_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`projects_has_tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`projects_has_tags` (
  `projects_project_id` INT(11) NOT NULL,
  `tags_tag_id` INT NOT NULL,
  PRIMARY KEY (`projects_project_id`, `tags_tag_id`),
  INDEX `fk_projects_has_tags_tags1_idx` (`tags_tag_id` ASC),
  INDEX `fk_projects_has_tags_projects1_idx` (`projects_project_id` ASC),
  CONSTRAINT `fk_projects_has_tags_projects1`
    FOREIGN KEY (`projects_project_id`)
    REFERENCES `pandoradb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projects_has_tags_tags1`
    FOREIGN KEY (`tags_tag_id`)
    REFERENCES `pandoradb`.`tags` (`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`comments` (
  `users_user_id` INT(11) NOT NULL,
  `projects_project_id` INT(11) NOT NULL,
  `comment_creating_time` DATETIME NULL,
  `comment_text` MEDIUMTEXT NULL,
  PRIMARY KEY (`users_user_id`, `projects_project_id`),
  INDEX `fk_users_has_projects_projects3_idx` (`projects_project_id` ASC),
  INDEX `fk_users_has_projects_users2_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_users_has_projects_users2`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `pandoradb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_projects_projects3`
    FOREIGN KEY (`projects_project_id`)
    REFERENCES `pandoradb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`achievements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`achievements` (
  `achievement_id` INT NOT NULL AUTO_INCREMENT,
  `achievement_name` VARCHAR(255) NULL,
  `achievement_description` MEDIUMTEXT NULL,
  `achievement_big_icon` LONGBLOB NULL,
  `achievement_small_icon` LONGBLOB NULL,
  PRIMARY KEY (`achievement_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pandoradb`.`users_has_achievements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pandoradb`.`users_has_achievements` (
  `users_user_id` INT(11) NOT NULL,
  `achievements_achievement_id` INT NOT NULL,
  PRIMARY KEY (`users_user_id`, `achievements_achievement_id`),
  INDEX `fk_users_has_achievements_achievements1_idx` (`achievements_achievement_id` ASC),
  INDEX `fk_users_has_achievements_users1_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_users_has_achievements_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `pandoradb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_achievements_achievements1`
    FOREIGN KEY (`achievements_achievement_id`)
    REFERENCES `pandoradb`.`achievements` (`achievement_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

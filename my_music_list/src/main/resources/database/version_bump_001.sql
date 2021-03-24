CREATE TABLE `my_music_list`.`music_type` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  `active_indicator` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `my_music_list`.`music_list` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `singer` VARCHAR(55) NULL,
  `created_on` DATETIME NULL,
  `udpated_on` DATETIME NULL,
  `active_indicator` INT NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE `my_music_list`.`music_list` 
ADD COLUMN `music_type_id` BIGINT NULL AFTER `singer`;
CREATE TABLE `my_music_list`.`music_list` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `singer` VARCHAR(55) NULL,
  `created_on` DATETIME NULL,
  `udpated_on` DATETIME NULL,
  `active_indicator` INT NULL,
  PRIMARY KEY (`id`));
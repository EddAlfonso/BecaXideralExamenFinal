CREATE DATABASE  IF NOT EXISTS `players_directory`;

use players_directory;

CREATE TABLE `jugadores_info` (
  `player_id` int NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `sport` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`player_id`)
);
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS `user` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) ,
  `role` varchar(255)
);
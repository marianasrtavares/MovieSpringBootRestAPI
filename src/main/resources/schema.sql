CREATE TABLE `moviedb` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT, 
`title` varchar (45) NOT NULL,
`launchdate` Date NOT NULL, 
`rate` INT NOT NULL, 
`revenue` Double NOT NULL,
PRIMARY KEY (`id`)
);

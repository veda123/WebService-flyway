
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema test_set_tool_db
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `test_set_tool_db` ;

-- -----------------------------------------------------
-- Schema test_set_tool_db
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `test_set_tool_db` DEFAULT CHARACTER SET utf8 ;
-- USE `test_set_tool_db` ;

-- -----------------------------------------------------
-- Table `equipment_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_type` ;

CREATE TABLE IF NOT EXISTS `equipment_type` (
  `equipmentTypeID` INT(11) NOT NULL AUTO_INCREMENT,
  `equipmentType` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`equipmentTypeID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `equipment_type` VALUES (1,'Test Set');
INSERT INTO `equipment_type` VALUES (2,'Manual Bench');
INSERT INTO `equipment_type` VALUES (3,'Cable');
INSERT INTO `equipment_type` VALUES (4,'TUA');
INSERT INTO `equipment_type` VALUES (5,'Tool');
INSERT INTO `equipment_type` VALUES (6,'Calibrated');

-- -----------------------------------------------------
-- Table `equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment` ;

CREATE TABLE IF NOT EXISTS `equipment` (
  `equipmentID` INT(11) NOT NULL AUTO_INCREMENT,
  `equipmentname` VARCHAR(50) NOT NULL,
  `equipmentPartNumber` VARCHAR(50) NOT NULL,
  `equipmenttypeid` INT(11) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`equipmentID`),
  CONSTRAINT `equipmenTypeID`
    FOREIGN KEY (`equipmenttypeid`)
    REFERENCES `equipment_type` (`equipmentTypeID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `equipmenTypeID_idx` ON `equipment` (`equipmenttypeid` ASC);


-- -----------------------------------------------------
-- Table `bill_of_materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bill_of_materials` ;

CREATE TABLE IF NOT EXISTS `bill_of_materials` (
  `billid` INT(11) NOT NULL AUTO_INCREMENT,
  `manufacture` VARCHAR(100) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `equipmentid` INT(11) NOT NULL,
  `lrupartnumber` VARCHAR(255) NOT NULL,
  `equipment_partid` INT(11) NOT NULL,
  PRIMARY KEY (`billid`),
  CONSTRAINT `EqipForeign`
    FOREIGN KEY (`equipmentid`)
    REFERENCES `equipment` (`equipmentID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `EquipPArtFK`
    FOREIGN KEY (`equipment_partid`)
    REFERENCES `equipment` (`equipmentID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `EqipForeignKey` ON `bill_of_materials` (`equipmentid` ASC);

CREATE INDEX `EquipPArtFK_idx` ON `bill_of_materials` (`equipment_partid` ASC);

-- -----------------------------------------------------
-- Table `contract_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contract_type` ;

CREATE TABLE IF NOT EXISTS `contract_type` (
  `contract_type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `contract_type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`contract_type_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `contract_type` VALUES (1,'Calibration');
INSERT INTO `contract_type` VALUES (2,'Lease');
INSERT INTO `contract_type` VALUES (3,'Standard Exchange');


-- -----------------------------------------------------
-- Table `country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `country` ;

CREATE TABLE IF NOT EXISTS `country` (
  `countryID` INT(11) NOT NULL AUTO_INCREMENT,
  `shortname` VARCHAR(5) NOT NULL,
  `countryname` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`countryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


INSERT INTO `country` VALUES (1,'AF','Afghanistan');
INSERT INTO `country` VALUES (2,'AL','Albania');
INSERT INTO `country` VALUES (3,'DZ','Algeria');
INSERT INTO `country` VALUES (4,'AS','American Samoa');
INSERT INTO `country` VALUES (5,'AD','Andorra');
INSERT INTO `country` VALUES (6,'AO','Angola');
INSERT INTO `country` VALUES (7,'AI','Anguilla');
INSERT INTO `country` VALUES (8,'AQ','Antarctica');
INSERT INTO `country` VALUES (9,'AG','Antigua And Barbuda');
INSERT INTO `country` VALUES (10,'AR','Argentina');
INSERT INTO `country` VALUES (11,'AM','Armenia');
INSERT INTO `country` VALUES (12,'AW','Aruba');
INSERT INTO `country` VALUES (13,'AU','Australia');
INSERT INTO `country` VALUES (14,'AT','Austria');
INSERT INTO `country` VALUES (15,'AZ','Azerbaijan');
INSERT INTO `country` VALUES (16,'BS','Bahamas The');
INSERT INTO `country` VALUES (17,'BH','Bahrain');
INSERT INTO `country` VALUES (18,'BD','Bangladesh');
INSERT INTO `country` VALUES (19,'BB','Barbados');
INSERT INTO `country` VALUES (20,'BY','Belarus');
INSERT INTO `country` VALUES (21,'BE','Belgium');
INSERT INTO `country` VALUES (22,'BZ','Belize');
INSERT INTO `country` VALUES (23,'BJ','Benin');
INSERT INTO `country` VALUES (24,'BM','Bermuda');
INSERT INTO `country` VALUES (25,'BT','Bhutan');
INSERT INTO `country` VALUES (26,'BO','Bolivia');
INSERT INTO `country` VALUES (27,'BA','Bosnia and Herzegovina');
INSERT INTO `country` VALUES (28,'BW','Botswana');
INSERT INTO `country` VALUES (29,'BV','Bouvet Island');
INSERT INTO `country` VALUES (30,'BR','Brazil');
INSERT INTO `country` VALUES (31,'IO','British Indian Ocean Territory');
INSERT INTO `country` VALUES (32,'BN','Brunei');
INSERT INTO `country` VALUES (33,'BG','Bulgaria');
INSERT INTO `country` VALUES (34,'BF','Burkina Faso');
INSERT INTO `country` VALUES (35,'BI','Burundi');
INSERT INTO `country` VALUES (36,'KH','Cambodia');
INSERT INTO `country` VALUES (37,'CM','Cameroon');
INSERT INTO `country` VALUES (38,'CA','Canada');
INSERT INTO `country` VALUES (39,'CV','Cape Verde');
INSERT INTO `country` VALUES (40,'KY','Cayman Islands');
INSERT INTO `country` VALUES (41,'CF','Central African Republic');
INSERT INTO `country` VALUES (42,'TD','Chad');
INSERT INTO `country` VALUES (43,'CL','Chile');
INSERT INTO `country` VALUES (44,'CN','China');
INSERT INTO `country` VALUES (45,'CX','Christmas Island');
INSERT INTO `country` VALUES (46,'CC','Cocos (Keeling) Islands');
INSERT INTO `country` VALUES (47,'CO','Colombia');
INSERT INTO `country` VALUES (48,'KM','Comoros');
INSERT INTO `country` VALUES (49,'CG','Congo');
INSERT INTO `country` VALUES (50,'CD','Congo The Democratic Republic Of The');
INSERT INTO `country` VALUES (51,'CK','Cook Islands');
INSERT INTO `country` VALUES (52,'CR','Costa Rica');
INSERT INTO `country` VALUES (53,'CI','Cote D\'Ivoire (Ivory Coast)');
INSERT INTO `country` VALUES (54,'HR','Croatia (Hrvatska)');
INSERT INTO `country` VALUES (55,'CU','Cuba');
INSERT INTO `country` VALUES (56,'CY','Cyprus');
INSERT INTO `country` VALUES (57,'CZ','Czech Republic');
INSERT INTO `country` VALUES (58,'DK','Denmark');
INSERT INTO `country` VALUES (59,'DJ','Djibouti');
INSERT INTO `country` VALUES (60,'DM','Dominica');
INSERT INTO `country` VALUES (61,'DO','Dominican Republic');
INSERT INTO `country` VALUES (62,'TP','East Timor');
INSERT INTO `country` VALUES (63,'EC','Ecuador');
INSERT INTO `country` VALUES (64,'EG','Egypt');
INSERT INTO `country` VALUES (65,'SV','El Salvador');
INSERT INTO `country` VALUES (66,'GQ','Equatorial Guinea');
INSERT INTO `country` VALUES (67,'ER','Eritrea');
INSERT INTO `country` VALUES (68,'EE','Estonia');
INSERT INTO `country` VALUES (69,'ET','Ethiopia');
INSERT INTO `country` VALUES (70,'XA','External Territories of Australia');
INSERT INTO `country` VALUES (71,'FK','Falkland Islands');
INSERT INTO `country` VALUES (72,'FO','Faroe Islands');
INSERT INTO `country` VALUES (73,'FJ','Fiji Islands');
INSERT INTO `country` VALUES (74,'FI','Finland');
INSERT INTO `country` VALUES (75,'FR','France');
INSERT INTO `country` VALUES (76,'GF','French Guiana');
INSERT INTO `country` VALUES (77,'PF','French Polynesia');
INSERT INTO `country` VALUES (78,'TF','French Southern Territories');
INSERT INTO `country` VALUES (79,'GA','Gabon');
INSERT INTO `country` VALUES (80,'GM','Gambia The');
INSERT INTO `country` VALUES (81,'GE','Georgia');
INSERT INTO `country` VALUES (82,'DE','Germany');
INSERT INTO `country` VALUES (83,'GH','Ghana');
INSERT INTO `country` VALUES (84,'GI','Gibraltar');
INSERT INTO `country` VALUES (85,'GR','Greece');
INSERT INTO `country` VALUES (86,'GL','Greenland');
INSERT INTO `country` VALUES (87,'GD','Grenada');
INSERT INTO `country` VALUES (88,'GP','Guadeloupe');
INSERT INTO `country` VALUES (89,'GU','Guam');
INSERT INTO `country` VALUES (90,'GT','Guatemala');
INSERT INTO `country` VALUES (91,'XU','Guernsey and Alderney');
INSERT INTO `country` VALUES (92,'GN','Guinea');
INSERT INTO `country` VALUES (93,'GW','Guinea-Bissau');
INSERT INTO `country` VALUES (94,'GY','Guyana');
INSERT INTO `country` VALUES (95,'HT','Haiti');
INSERT INTO `country` VALUES (96,'HM','Heard and McDonald Islands');
INSERT INTO `country` VALUES (97,'HN','Honduras');
INSERT INTO `country` VALUES (98,'HK','Hong Kong S.A.R.');
INSERT INTO `country` VALUES (99,'HU','Hungary');
INSERT INTO `country` VALUES (100,'IS','Iceland');
INSERT INTO `country` VALUES (101,'IN','India');
INSERT INTO `country` VALUES (102,'ID','Indonesia');
INSERT INTO `country` VALUES (103,'IR','Iran');
INSERT INTO `country` VALUES (104,'IQ','Iraq');
INSERT INTO `country` VALUES (105,'IE','Ireland');
INSERT INTO `country` VALUES (106,'IL','Israel');
INSERT INTO `country` VALUES (107,'IT','Italy');
INSERT INTO `country` VALUES (108,'JM','Jamaica');
INSERT INTO `country` VALUES (109,'JP','Japan');
INSERT INTO `country` VALUES (110,'XJ','Jersey');
INSERT INTO `country` VALUES (111,'JO','Jordan');
INSERT INTO `country` VALUES (112,'KZ','Kazakhstan');
INSERT INTO `country` VALUES (113,'KE','Kenya');
INSERT INTO `country` VALUES (114,'KI','Kiribati');
INSERT INTO `country` VALUES (115,'KP','Korea North');
INSERT INTO `country` VALUES (116,'KR','Korea South');
INSERT INTO `country` VALUES (117,'KW','Kuwait');
INSERT INTO `country` VALUES (118,'KG','Kyrgyzstan');
INSERT INTO `country` VALUES (119,'LA','Laos');
INSERT INTO `country` VALUES (120,'LV','Latvia');
INSERT INTO `country` VALUES (121,'LB','Lebanon');
INSERT INTO `country` VALUES (122,'LS','Lesotho');
INSERT INTO `country` VALUES (123,'LR','Liberia');
INSERT INTO `country` VALUES (124,'LY','Libya');
INSERT INTO `country` VALUES (125,'LI','Liechtenstein');
INSERT INTO `country` VALUES (126,'LT','Lithuania');
INSERT INTO `country` VALUES (127,'LU','Luxembourg');
INSERT INTO `country` VALUES (128,'MO','Macau S.A.R.');
INSERT INTO `country` VALUES (129,'MK','Macedonia');
INSERT INTO `country` VALUES (130,'MG','Madagascar');
INSERT INTO `country` VALUES (131,'MW','Malawi');
INSERT INTO `country` VALUES (132,'MY','Malaysia');
INSERT INTO `country` VALUES (133,'MV','Maldives');
INSERT INTO `country` VALUES (134,'ML','Mali');
INSERT INTO `country` VALUES (135,'MT','Malta');
INSERT INTO `country` VALUES (136,'XM','Man (Isle of)');
INSERT INTO `country` VALUES (137,'MH','Marshall Islands');
INSERT INTO `country` VALUES (138,'MQ','Martinique');
INSERT INTO `country` VALUES (139,'MR','Mauritania');
INSERT INTO `country` VALUES (140,'MU','Mauritius');
INSERT INTO `country` VALUES (141,'YT','Mayotte');
INSERT INTO `country` VALUES (142,'MX','Mexico');
INSERT INTO `country` VALUES (143,'FM','Micronesia');
INSERT INTO `country` VALUES (144,'MD','Moldova');
INSERT INTO `country` VALUES (145,'MC','Monaco');
INSERT INTO `country` VALUES (146,'MN','Mongolia');
INSERT INTO `country` VALUES (147,'MS','Montserrat');
INSERT INTO `country` VALUES (148,'MA','Morocco');
INSERT INTO `country` VALUES (149,'MZ','Mozambique');
INSERT INTO `country` VALUES (150,'MM','Myanmar');
INSERT INTO `country` VALUES (151,'NA','Namibia');
INSERT INTO `country` VALUES (152,'NR','Nauru');
INSERT INTO `country` VALUES (153,'NP','Nepal');
INSERT INTO `country` VALUES (154,'AN','Netherlands Antilles');
INSERT INTO `country` VALUES (155,'NL','Netherlands The');
INSERT INTO `country` VALUES (156,'NC','New Caledonia');
INSERT INTO `country` VALUES (157,'NZ','New Zealand');
INSERT INTO `country` VALUES (158,'NI','Nicaragua');
INSERT INTO `country` VALUES (159,'NE','Niger');
INSERT INTO `country` VALUES (160,'NG','Nigeria');
INSERT INTO `country` VALUES (161,'NU','Niue');
INSERT INTO `country` VALUES (162,'NF','Norfolk Island');
INSERT INTO `country` VALUES (163,'MP','Northern Mariana Islands');
INSERT INTO `country` VALUES (164,'NO','Norway');
INSERT INTO `country` VALUES (165,'OM','Oman');
INSERT INTO `country` VALUES (166,'PK','Pakistan');
INSERT INTO `country` VALUES (167,'PW','Palau');
INSERT INTO `country` VALUES (168,'PS','Palestinian Territory Occupied');
INSERT INTO `country` VALUES (169,'PA','Panama');
INSERT INTO `country` VALUES (170,'PG','Papua new Guinea');
INSERT INTO `country` VALUES (171,'PY','Paraguay');
INSERT INTO `country` VALUES (172,'PE','Peru');
INSERT INTO `country` VALUES (173,'PH','Philippines');
INSERT INTO `country` VALUES (174,'PN','Pitcairn Island');
INSERT INTO `country` VALUES (175,'PL','Poland');
INSERT INTO `country` VALUES (176,'PT','Portugal');
INSERT INTO `country` VALUES (177,'PR','Puerto Rico');
INSERT INTO `country` VALUES (178,'QA','Qatar');
INSERT INTO `country` VALUES (179,'RE','Reunion');
INSERT INTO `country` VALUES (180,'RO','Romania');
INSERT INTO `country` VALUES (181,'RU','Russia');
INSERT INTO `country` VALUES (182,'RW','Rwanda');
INSERT INTO `country` VALUES (183,'SH','Saint Helena');
INSERT INTO `country` VALUES (184,'KN','Saint Kitts And Nevis');
INSERT INTO `country` VALUES (185,'LC','Saint Lucia');
INSERT INTO `country` VALUES (186,'PM','Saint Pierre and Miquelon');
INSERT INTO `country` VALUES (187,'VC','Saint Vincent And The Grenadines');
INSERT INTO `country` VALUES (188,'WS','Samoa');
INSERT INTO `country` VALUES (189,'SM','San Marino');
INSERT INTO `country` VALUES (190,'ST','Sao Tome and Principe');
INSERT INTO `country` VALUES (191,'SA','Saudi Arabia');
INSERT INTO `country` VALUES (192,'SN','Senegal');
INSERT INTO `country` VALUES (193,'RS','Serbia');
INSERT INTO `country` VALUES (194,'SC','Seychelles');
INSERT INTO `country` VALUES (195,'SL','Sierra Leone');
INSERT INTO `country` VALUES (196,'SG','Singapore');
INSERT INTO `country` VALUES (197,'SK','Slovakia');
INSERT INTO `country` VALUES (198,'SI','Slovenia');
INSERT INTO `country` VALUES (199,'XG','Smaller Territories of the UK');
INSERT INTO `country` VALUES (200,'SB','Solomon Islands');
INSERT INTO `country` VALUES (201,'SO','Somalia');
INSERT INTO `country` VALUES (202,'ZA','South Africa');
INSERT INTO `country` VALUES (203,'GS','South Georgia');
INSERT INTO `country` VALUES (204,'SS','South Sudan');
INSERT INTO `country` VALUES (205,'ES','Spain');
INSERT INTO `country` VALUES (206,'LK','Sri Lanka');
INSERT INTO `country` VALUES (207,'SD','Sudan');
INSERT INTO `country` VALUES (208,'SR','Suriname');
INSERT INTO `country` VALUES (209,'SJ','Svalbard And Jan Mayen Islands');
INSERT INTO `country` VALUES (210,'SZ','Swaziland');
INSERT INTO `country` VALUES (211,'SE','Sweden');
INSERT INTO `country` VALUES (212,'CH','Switzerland');
INSERT INTO `country` VALUES (213,'SY','Syria');
INSERT INTO `country` VALUES (214,'TW','Taiwan');
INSERT INTO `country` VALUES (215,'TJ','Tajikistan');
INSERT INTO `country` VALUES (216,'TZ','Tanzania');
INSERT INTO `country` VALUES (217,'TH','Thailand');
INSERT INTO `country` VALUES (218,'TG','Togo');
INSERT INTO `country` VALUES (219,'TK','Tokelau');
INSERT INTO `country` VALUES (220,'TO','Tonga');
INSERT INTO `country` VALUES (221,'TT','Trinidad And Tobago');
INSERT INTO `country` VALUES (222,'TN','Tunisia');
INSERT INTO `country` VALUES (223,'TR','Turkey');
INSERT INTO `country` VALUES (224,'TM','Turkmenistan');
INSERT INTO `country` VALUES (225,'TC','Turks And Caicos Islands');
INSERT INTO `country` VALUES (226,'TV','Tuvalu');
INSERT INTO `country` VALUES (227,'UG','Uganda');
INSERT INTO `country` VALUES (228,'UA','Ukraine');
INSERT INTO `country` VALUES (229,'UAE','United Arab Emirates');
INSERT INTO `country` VALUES (230,'GB','United Kingdom');
INSERT INTO `country` VALUES (231,'US','United States');
INSERT INTO `country` VALUES (232,'UM','United States Minor Outlying Islands');
INSERT INTO `country` VALUES (233,'UY','Uruguay');
INSERT INTO `country` VALUES (234,'UZ','Uzbekistan');
INSERT INTO `country` VALUES (235,'VU','Vanuatu');
INSERT INTO `country` VALUES (236,'VA','Vatican City State (Holy See)');
INSERT INTO `country` VALUES (237,'VE','Venezuela');
INSERT INTO `country` VALUES (238,'VN','Vietnam');
INSERT INTO `country` VALUES (239,'VG','Virgin Islands (British)');
INSERT INTO `country` VALUES (240,'VI','Virgin Islands (US)');
INSERT INTO `country` VALUES (241,'WF','Wallis And Futuna Islands');
INSERT INTO `country` VALUES (242,'EH','Western Sahara');
INSERT INTO `country` VALUES (243,'YE','Yemen');
INSERT INTO `country` VALUES (244,'YU','Yugoslavia');
INSERT INTO `country` VALUES (245,'ZM','Zambia');
INSERT INTO `country` VALUES (246,'ZW','Zimbabwe');


-- -----------------------------------------------------
-- Table `files`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `files` ;

CREATE TABLE IF NOT EXISTS `files` (
  `id` VARCHAR(255) NOT NULL,
  `data` LONGBLOB NULL DEFAULT NULL,
  `file_name` VARCHAR(255) NULL DEFAULT NULL,
  `file_type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `locationID` INT(11) NOT NULL AUTO_INCREMENT,
  `locationName` VARCHAR(50) NOT NULL,
  `address` VARCHAR(1000) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(30) NULL DEFAULT NULL,
  `zipCode` VARCHAR(10) NOT NULL,
  `countryid` INT(11) NOT NULL,
  `timezone` DOUBLE NOT NULL,
  PRIMARY KEY (`locationID`),
  CONSTRAINT `Country`
    FOREIGN KEY (`countryid`)
    REFERENCES `country` (`countryID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `Country_idx` ON `location` (`countryid` ASC);


-- -----------------------------------------------------
-- Table `equipment_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_inventory` ;

CREATE TABLE IF NOT EXISTS `equipment_inventory` (
  `inventory_id` INT(11) NOT NULL AUTO_INCREMENT,
  `manufacture_date` DATE NOT NULL,
  `owner` VARCHAR(50) NOT NULL,
  `ownership` VARCHAR(50) NOT NULL,
  `rev` VARCHAR(10) NULL DEFAULT NULL,
  `serial_number` VARCHAR(50) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `equipmentid` INT(11) NOT NULL,
  `locationid` INT(11) NOT NULL,
  PRIMARY KEY (`inventory_id`),
  CONSTRAINT `Equip`
    FOREIGN KEY (`equipmentid`)
    REFERENCES `equipment` (`equipmentID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `LocationForeignKey`
    FOREIGN KEY (`locationid`)
    REFERENCES `location` (`locationID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `EquipKey` ON `equipment_inventory` (`equipmentid` ASC);

CREATE INDEX `LocationFreKey` ON `equipment_inventory` (`locationid` ASC);


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(50) NOT NULL,
  `contract_start_date` DATE NOT NULL,
  `contract_end_date` DATE NOT NULL,
  `contract_type_id` INT(11) NOT NULL,
  `point_of_contact` VARCHAR(255) NULL DEFAULT NULL,
  `inventory_id` INT(11) NOT NULL,
  `id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `ContractType`
    FOREIGN KEY (`contract_type_id`)
    REFERENCES `contract_type` (`contract_type_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `DbFileFK`
    FOREIGN KEY (`id`)
    REFERENCES `files` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `inventoryFK`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `equipment_inventory` (`inventory_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `ContractType_idx` ON `customer` (`contract_type_id` ASC);

CREATE INDEX `inventoryFK_idx` ON `customer` (`inventory_id` ASC);

CREATE INDEX `DbFK_idx` ON `customer` (`id` ASC);


-- -----------------------------------------------------
-- Table `hibernate_sequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hibernate_sequence` ;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `repair_capability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `repair_capability` ;

CREATE TABLE IF NOT EXISTS `repair_capability` (
  `capability_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cmm` VARCHAR(50) NOT NULL,
  `lrupartnumber` VARCHAR(50) NOT NULL,
  `lrudescription` VARCHAR(100) NOT NULL,
  `equipment_id` INT(11) NOT NULL,
  PRIMARY KEY (`capability_id`),
  CONSTRAINT `RepairCapa`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `equipment` (`equipmentID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `RepairCapa_idx` ON `repair_capability` (`equipment_id` ASC);


-- -----------------------------------------------------
-- Table `location_capability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location_capability` ;

CREATE TABLE IF NOT EXISTS `location_capability` (
  `location_capid` INT(11) NOT NULL AUTO_INCREMENT,
  `established_date` VARCHAR(255) NOT NULL,
  `locationid` INT(11) NOT NULL,
  `capability_id` INT(11) NOT NULL,
  PRIMARY KEY (`location_capid`),
  CONSTRAINT `LocationFK`
    FOREIGN KEY (`locationid`)
    REFERENCES `location` (`locationID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `RepairFK`
    FOREIGN KEY (`capability_id`)
    REFERENCES `repair_capability` (`capability_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `LocFKK` ON `location_capability` (`locationid` ASC);

CREATE INDEX `RepairCapFK` ON `location_capability` (`capability_id` ASC);


-- -----------------------------------------------------
-- Table `location_poc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location_poc` ;

CREATE TABLE IF NOT EXISTS `location_poc` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `contactname` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `phone` VARCHAR(30) NULL DEFAULT NULL,
  `title` VARCHAR(50) NULL DEFAULT NULL,
  `locationid` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `LOCATION`
    FOREIGN KEY (`locationid`)
    REFERENCES `location` (`locationID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `LOCATIONKey` ON `location_poc` (`locationid` ASC);


-- -----------------------------------------------------
-- Table `repair_tools`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `repair_tools` ;

CREATE TABLE IF NOT EXISTS `repair_tools` (
  `repair_tool_id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantity` INT(11) NOT NULL,
  `equipment_id` INT(11) NULL DEFAULT NULL,
  `capability_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`repair_tool_id`),
  CONSTRAINT `TollFK_2`
    FOREIGN KEY (`capability_id`)
    REFERENCES `repair_capability` (`capability_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `ToolFk_1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `equipment` (`equipmentID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `ToolFork_1` ON `repair_tools` (`equipment_id` ASC);

CREATE INDEX `TollForK_2` ON `repair_tools` (`capability_id` ASC);


-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `roles` ;

CREATE TABLE IF NOT EXISTS `roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `uk_roles_name` ON `roles` (`name` ASC);

CREATE UNIQUE INDEX `UK_nb4h0p6txrmfc0xbrd1kglp9t` ON `roles` (`name` ASC);


INSERT INTO `roles` VALUES (5,'ROLE_ADMIN');
INSERT INTO `roles` VALUES (4,'ROLE_USER');


-- -----------------------------------------------------
-- Table `tps`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tps` ;

CREATE TABLE IF NOT EXISTS `tps` (
  `tps_id` INT(11) NOT NULL AUTO_INCREMENT,
  `checksum` VARCHAR(50) NOT NULL,
  `checksum_type` VARCHAR(50) NOT NULL,
  `comments` VARCHAR(255) NULL DEFAULT NULL,
  `release_date` DATE NOT NULL,
  `release_notes` VARCHAR(255) NULL DEFAULT NULL,
  `tps_name` VARCHAR(255) NOT NULL,
  `version` VARCHAR(50) NOT NULL,
  `capability_id` INT(11) NOT NULL,
  `tps_part` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`tps_id`),
  CONSTRAINT `Capability`
    FOREIGN KEY (`capability_id`)
    REFERENCES `repair_capability` (`capability_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `CapabilityForK` ON `tps` (`capability_id` ASC);


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `username` VARCHAR(15) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  `updated_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `uk_users_username` ON `users` (`username` ASC);

CREATE UNIQUE INDEX `uk_users_email` ON `users` (`email` ASC);


INSERT INTO `users` VALUES (1,'admin','admin','admin@us.thalesgroup.com','$2a$10$q06tNBsQkn5uLaiKEbWA8OXNTyPWAxGl7sxSCC.F3vfH.wakiG.SS','2018-06-01 18:37:49','2018-06-01 18:37:49');

-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_roles` ;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_user_roles_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `roles` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_user_roles_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_user_rol_id` ON `user_roles` (`role_id` ASC);

INSERT INTO `user_roles` VALUES (1,5);



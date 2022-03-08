CREATE TABLE `clients` (
    `clientID` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NULL DEFAULT NULL,
    `lastName` VARCHAR(45) NULL DEFAULT NULL,
    `email` VARCHAR(45) NULL DEFAULT NULL,
    `phoneNumber` VARCHAR(25) NULL DEFAULT NULL,
    `address` VARCHAR(45) NULL DEFAULT NULL,
    `createdBy` VARCHAR(45) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
     PRIMARY KEY (`clientID`))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `employees` (
    `employeesID` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NULL DEFAULT NULL,
    `lastName` VARCHAR(45) NULL DEFAULT NULL,
    `dateofbirth` DATE NULL DEFAULT NULL,
    `email` VARCHAR(45) NULL DEFAULT NULL,
    `phoneNumber` VARCHAR(25) NULL DEFAULT NULL,
    `role` VARCHAR(25) NULL DEFAULT NULL,
    `user` VARCHAR(45) NULL DEFAULT NULL,
    `password` VARCHAR(45) NULL DEFAULT NULL,
    `salary` INT NULL DEFAULT NULL,
    `createdBy` VARCHAR(25) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`employeesID`),
    UNIQUE INDEX `User_UNIQUE` (`user` ASC),
    UNIQUE INDEX `Password_UNIQUE` (`password` ASC))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cartels` (
     `cartelID` INT NOT NULL AUTO_INCREMENT,
    `dataCreated` INT NULL DEFAULT NULL,
    `employeesId` INT NOT NULL,
    `clientID` INT NOT NULL,
    `createdBy` VARCHAR(45) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`cartelID`),
    INDEX `fk_Cartel_emploee1_idx` (`employeesId` ASC),
    INDEX `fk_Cartel_Client1_idx` (`clientID` ASC),
    CONSTRAINT `fk_Cartel_Client1`
    FOREIGN KEY (`clientID`)
    REFERENCES `techstore`.`clients` (`clientID`),
    CONSTRAINT `fk_Cartel_emploee1`
    FOREIGN KEY (`employeesId`)
    REFERENCES `techstore`.`employees` (`employeesID`))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suppliers` (
    `supplierID` INT NOT NULL AUTO_INCREMENT,
    `supplierCompanyName` VARCHAR(45) NULL DEFAULT NULL,
    `product` VARCHAR(45) NULL DEFAULT NULL,
    `quantity` INT NULL DEFAULT NULL,
    `price` INT NULL DEFAULT NULL,
    `createdBy` VARCHAR(45) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`supplierID`))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `computers` (
     `computerID` INT NOT NULL AUTO_INCREMENT,
     `computerName` VARCHAR(45) NULL DEFAULT NULL,
    `computerType` VARCHAR(45) NULL DEFAULT NULL,
    `isbn` VARCHAR(45) NULL DEFAULT NULL,
    `dateofPublication` DATETIME NULL DEFAULT NULL,
    `quantity` INT NULL DEFAULT NULL,
    `price` INT NULL DEFAULT NULL,
    `createdBy` VARCHAR(45) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
    `suppliers_supplierID` INT NOT NULL,
    PRIMARY KEY (`computerID`),
    UNIQUE INDEX `ISBN_UNIQUE` (`isbn` ASC),
    INDEX `fk_computers_suppliers1_idx` (`suppliers_supplierID` ASC),
    CONSTRAINT `fk_computers_suppliers1`
    FOREIGN KEY (`suppliers_supplierID`)
    REFERENCES `techstore`.`suppliers` (`supplierID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cartelrecords` (
                                               `cartelRecordID` INT NOT NULL AUTO_INCREMENT,
                                               `dataStarted` DATETIME NULL DEFAULT NULL,
                                               `endData` DATETIME NULL DEFAULT NULL,
                                               `createData` VARCHAR(45) NULL DEFAULT NULL,
    `computersID` INT NOT NULL,
    `createdBy` VARCHAR(45) NULL DEFAULT NULL,
    `createdOn` TIMESTAMP(6) NULL DEFAULT NULL,
    `modifiedBy` VARCHAR(45) NULL DEFAULT NULL,
    `cartelId` INT NOT NULL,
    PRIMARY KEY (`cartelRecordID`),
    INDEX `fk_CartelRecords_computers1_idx` (`computersID` ASC),
    INDEX `fk_cartel_idx` (`cartelId` ASC),
    CONSTRAINT `fk_cartel`
    FOREIGN KEY (`cartelId`)
    REFERENCES `techstore`.`cartels` (`cartelID`),
    CONSTRAINT `fk_CartelRecords_computers1`
    FOREIGN KEY (`computersID`)
    REFERENCES `techstore`.`computers` (`computerID`))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;


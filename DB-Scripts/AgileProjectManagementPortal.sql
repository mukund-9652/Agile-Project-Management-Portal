create database `Agile-Project-Management-Portal`;

CREATE TABLE clients(
	id BIGINT(10) PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    POC_FullName VARCHAR(20) NOT NULL,
    POC_PhoneNumber BIGINT(10) NOT NULL,
    POC_EmailAddress VARCHAR(100) NOT NULL
);

# DROP TABLE CLIENTS;

CREATE TABLE Projects(
	ProjectCode BIGINT(10) PRIMARY KEY,
    Title VARCHAR(50) NOT NULL,
    Budget BIGINT(50) NOT NULL,
    StartDate DATE NOT NULL,
    ExpectedEndDate DATE NOT NULL,
    CreatedOn DATE  DEFAULT (CURRENT_DATE),
    Status VARCHAR(20) NOT NULL,
    LastUpdatedOn DATE,
    ClientId BIGINT(10),
	FOREIGN KEY (ClientId) REFERENCES clients(id),
    CONSTRAINT CHECK_STATUS CHECK ((STATUS IN ('New','InProgress','Completed','Delayed','Cancelled'))) ENFORCED
);

# DROP TABLE PROJECTS;

DELIMITER $$
CREATE TRIGGER CHECK_PROJECTS
BEFORE INSERT ON Projects FOR EACH ROW
BEGIN
	IF NEW.ExpectedEndDate < NEW.StartDate THEN 
	SIGNAL SQLSTATE '45000' 
    SET MESSAGE_TEXT = 'An error occurred in Expected End Date.The expected end date must not be less than the Start date';
	END IF;
    
    IF LENGTH(NEW.Title)<3  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in Title. The title must not be greater than 6 characters';
	END IF;		
    
END;
$$
DELIMITER ;

# DROP TRIGGER CHECK_PROJECTS ;

CREATE TABLE Resources(
	UserId VARCHAR(6) PRIMARY KEY,
    FirstName VARCHAR(15) NOT NULL,
    LastName VARCHAR(15) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    PhoneNumber BIGINT(10) NOT NULL,
    Role VARCHAR(20) NOT NULL,
    ProjectCode BIGINT(10),
	FOREIGN KEY (ProjectCode) REFERENCES Projects(ProjectCode),
    CONSTRAINT CHECK_ROLE CHECK ((Role IN ('Developer','Tester'))) ENFORCED
);

DROP TABLE RESOURCES;

DELIMITER $$
CREATE TRIGGER CHECK_RESOURCES 
BEFORE INSERT ON Resources FOR EACH ROW
BEGIN

    IF LENGTH(NEW.UserId)!=6  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in First Name. The first name must not be greater than 6 characters';
	END IF;	
    
    IF LENGTH(NEW.FirstName)<3  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in First Name. The first name must not be greater than 6 characters';
	END IF;		
    
	IF LENGTH(NEW.LastName)<3  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in Last Name. The last name must not be greater than 6 characters';
	END IF;		
    
END;
$$
DELIMITER ;

# DROP TRIGGER CHECK_RESOURCES ;

INSERT INTO CLIENTS 
VALUES(1,'InfoTech Solutions','Ravikumar S',7845842789,'ravikumar.productmanager@its.com'),
(2,'Global Archade Systems','Seetharaman T',9845612378,'seetharaman.tl@gas.com'),
(3,'Kuppamal Industries','Nirmala Ravi S',7845670224,'nirmala.owner@ki.com'),
(4,'Internatial Women Boxing Championship League','Jaysree',8428139281,'jaysree.federationowner@iwbcl.com'),
(5,'Infosys','Kamalesh K',7648932984,'kamalesh@infosys.com');

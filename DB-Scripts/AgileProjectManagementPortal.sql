create database `Agile-Project-Management-Portal`;

CREATE TABLE clients(
	id BIGINT(10) PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    poc_full_name VARCHAR(20) NOT NULL,
    poc_phone_number BIGINT(10) NOT NULL,
    poc_email_address VARCHAR(100) NOT NULL
);

# DROP TABLE CLIENTS;

CREATE TABLE Projects(
	project_code BIGINT(10) PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    budget BIGINT(50) NOT NULL,
    start_date DATE NOT NULL,
    expected_end_date DATE NOT NULL,
    created_on DATE  DEFAULT (CURRENT_DATE),
    status VARCHAR(20) NOT NULL,
    last_updated_on DATE,
    client_id BIGINT(10),
	FOREIGN KEY (client_id) REFERENCES clients(id),
    CONSTRAINT CHECK_STATUS CHECK ((status IN ('New','InProgress','Completed','Delayed','Cancelled'))) ENFORCED
);

# DROP TABLE PROJECTS;

DELIMITER $$
CREATE TRIGGER CHECK_PROJECTS
BEFORE INSERT ON Projects FOR EACH ROW
BEGIN
	IF NEW.expected_end_date < NEW.start_date THEN 
	SIGNAL SQLSTATE '45000' 
    SET MESSAGE_TEXT = 'An error occurred in Expected End Date.The expected end date must not be less than the Start date';
	END IF;
    
    IF LENGTH(NEW.title)<3  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in Title. The title must not be greater than 6 characters';
	END IF;		
    
END;
$$
DELIMITER ;

# DROP TRIGGER CHECK_PROJECTS ;

CREATE TABLE Resources(
	user_id VARCHAR(6) PRIMARY KEY,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number BIGINT(10) NOT NULL,
    role VARCHAR(20) NOT NULL,
    project_code BIGINT(10),
	FOREIGN KEY (project_code) REFERENCES Projects(project_code),
    CONSTRAINT CHECK_ROLE CHECK ((Role IN ('Developer','Tester'))) ENFORCED
);

# DROP TABLE RESOURCES;

DELIMITER $$
CREATE TRIGGER CHECK_RESOURCES 
BEFORE INSERT ON Resources FOR EACH ROW
BEGIN

    IF LENGTH(NEW.user_id)!=6  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in First Name. The first name must not be greater than 6 characters';
	END IF;	
    
    IF LENGTH(NEW.first_name)<3  THEN
		SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'An error occurred in First Name. The first name must not be greater than 6 characters';
	END IF;		
    
	IF LENGTH(NEW.last_name)<3  THEN
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

INSERT INTO PROJECTS VALUES
(10001,'Agile Project Management',25000,'2023-01-01','2023-10-10','2023-01-01','New',Null,1),
(10002,'Recruitment Portal Management',25000,'2023-01-01','2023-10-10','2023-01-01','New',Null,2),
(10003,'Resource Management Portal',25000,'2023-01-01','2023-10-10','2023-01-01','New',Null,3),
(10004,'Competition Management Portal',25000,'2023-01-01','2023-10-10','2023-01-01','New',Null,4);


INSERT INTO RESOURCES VALUES
('MU1001','MUKUND','R S','mukund.rs.2001@gmail.com',7845159519,'Developer',10002);

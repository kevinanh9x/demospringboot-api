CREATE TABLE tbl_employees (
    `employeesId` INT(8),
    `fullName` VARCHAR(255) NOT NULL,
     `age` INT(11) NOT NULL,
     `address` VARCHAR(50) NOT NULL,
     `email` VARCHAR(50) NOT NULL,
     `salary` DOUBLE NOT NULL,
     `departmentId` INT(8),
    PRIMARY KEY (`employeesId`)
);
DROP TABLE IF EXISTS employees;

CREATE TABLE tbl_department (
    `departmentId` INT(8),
    `nameDepartments` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`departmentId`)
);


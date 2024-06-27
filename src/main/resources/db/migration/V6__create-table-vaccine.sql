CREATE TABLE vaccine_registration (
     id_vaccine INT PRIMARY KEY AUTO_INCREMENT,
     name_vaccine VARCHAR(255) NOT NULL,
     name_who_registered_vaccine VARCHAR(255) NOT NULL,
     registration_date_vaccine DATE NOT NULL,
     vaccine_function VARCHAR(255) NOT NULL,
     vaccine_batch VARCHAR(255) NOT NULL,
     vaccine_manufacturer VARCHAR(255) NOT NULL

);

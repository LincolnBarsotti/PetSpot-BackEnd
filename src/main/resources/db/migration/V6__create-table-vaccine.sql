CREATE TABLE vaccine_registration (
     id_vaccine INT PRIMARY KEY AUTO_INCREMENT,
     name_vaccine VARCHAR(255) ,
     name_who_registered_vaccine VARCHAR(255) ,
     registration_date_vaccine DATE ,
     vaccine_function VARCHAR(255) ,
     vaccine_batch VARCHAR(255) ,
     vaccine_manufacturer VARCHAR(255)
);

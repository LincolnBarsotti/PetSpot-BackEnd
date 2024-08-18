create table service_history(
    service_id VARCHAR(36) PRIMARY KEY,
    name_service VARCHAR(255),
    creation_date DATE,
    pet_id VARCHAR(36),
    FOREIGN KEY (pet_id) REFERENCES pet(id)
);
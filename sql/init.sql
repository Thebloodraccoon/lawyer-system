CREATE TABLE IF NOT EXISTS t_client (
                                                                                           id INT PRIMARY KEY AUTO_INCREMENT,
                                                                                           name VARCHAR(255) NOT NULL,
                                                                                           email VARCHAR(255) UNIQUE NOT NULL,
                                                                                           password VARCHAR(255) NOT NULL,
                                                                                           phone_num VARCHAR(40) NOT NULL
                                                    );

CREATE TABLE IF NOT EXISTS t_lawyer (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        name VARCHAR(255) NOT NULL,
                                        email VARCHAR(255) UNIQUE UNIQUE NOT NULL,
                                        password VARCHAR(255) NOT NULL,
                                        phone_num VARCHAR(40) NOT NULL,
                                        specialization ENUM('CIVIL_LAW', 'CRIMINAL_LAW', 'LABOR_LAW', 'FAMILY_LAW', 'REAL_ESTATE_AND_PROPERTY_LAW', 'CORPORATE_LAW', 'TAX_LAW', 'ADMINISTRATIVE_LAW', 'INTELLECTUAL_PROPERTY_LAW', 'BANKRUPTCY_AND_FINANCIAL_LAW') NOT NULL DEFAULT 'CIVIL_LAW',
                                        years_of_experience INT NOT NULL,
                                        license_number VARCHAR(255) NOT NULL,
                                        office_address VARCHAR(255),
                                        bio TEXT
);

CREATE TABLE IF NOT EXISTS t_consultation (
                                              id INT PRIMARY KEY AUTO_INCREMENT,
                                              consul_type ENUM('CIVIL_LAW', 'CRIMINAL_LAW', 'LABOR_LAW', 'FAMILY_LAW', 'REAL_ESTATE_AND_PROPERTY_LAW', 'CORPORATE_LAW', 'TAX_LAW', 'ADMINISTRATIVE_LAW', 'INTELLECTUAL_PROPERTY_LAW', 'BANKRUPTCY_AND_FINANCIAL_LAW') NOT NULL DEFAULT 'CIVIL_LAW',
                                              name VARCHAR(255) NOT NULL,
                                              date DATETIME  NOT NULL,
                                              cost DOUBLE NOT NULL,
                                              consultation_status ENUM('Planned', 'Canceled', 'Completed') NOT NULL DEFAULT 'Planned',
                                              lawyer_id INT NOT NULL,
                                              client_id INT NOT NULL,
                                              FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id),
                                              FOREIGN KEY (client_id) REFERENCES t_client(id)
);

CREATE TABLE IF NOT EXISTS t_payment (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          consultation_id INT NOT NULL,
                                          amount DOUBLE,
                                          payment_date DATE,
                                          payment_method VARCHAR(255),
                                          payment_status ENUM('Expected', 'Payed') NOT NULL DEFAULT 'Expected',
                                          FOREIGN KEY (consultation_id) REFERENCES t_consultation(id)
                                     );


CREATE TABLE IF NOT EXISTS t_schedule (
                                           id INT PRIMARY KEY AUTO_INCREMENT,
                                           date DATETIME  NOT NULL,
                                           lawyer_id INT NOT NULL,
                                           consultation_id INT NOT NULL,
                                           FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id),
                                           FOREIGN KEY (consultation_id) REFERENCES t_consultation(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS t_lawyer_salary (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          date DATE NOT NULL,
                                          lawyer_id INT NOT NULL,
                                          salary INT NOT NULL,
                                          FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id)
);




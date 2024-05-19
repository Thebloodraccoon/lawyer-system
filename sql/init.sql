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
                                        email VARCHAR(255) UNIQUE NOT NULL,
                                        password VARCHAR(255) NOT NULL,
                                        phone_num VARCHAR(40) NOT NULL,
                                        specialization VARCHAR(255) NOT NULL,
                                        years_of_experience INT NOT NULL,
                                        license_number VARCHAR(255) NOT NULL,
                                        office_address VARCHAR(255),
                                        bio TEXT
);

CREATE TABLE IF NOT EXISTS t_consultation (
                                              id INT PRIMARY KEY AUTO_INCREMENT,
                                              consul_type VARCHAR(255) NOT NULL,
                                              name VARCHAR(255) NOT NULL,
                                              date DATE NOT NULL,
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
                                           date DATE NOT NULL,
                                           lawyer_id INT NOT NULL,
                                           consultation_id INT NOT NULL,
                                           FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id),
                                           FOREIGN KEY (consultation_id) REFERENCES t_consultation(id) ON DELETE CASCADE
);



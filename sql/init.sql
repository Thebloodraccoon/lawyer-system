CREATE TABLE IF NOT EXISTS t_client (
                                                                                           id INT PRIMARY KEY AUTO_INCREMENT,
                                                                                           name VARCHAR(255) NOT NULL,
                                                                                           email VARCHAR(255) UNIQUE NOT NULL,
                                                                                           password_hash VARCHAR(255) NOT NULL,
                                                                                           phone_num VARCHAR(40) NOT NULL
                                                    );

CREATE TABLE IF NOT EXISTS t_lawyer (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        name VARCHAR(255) NOT NULL,
                                        email VARCHAR(255) UNIQUE NOT NULL,
                                        password_hash VARCHAR(255) NOT NULL,
                                        phone_num VARCHAR(40) NOT NULL,
                                        specialization VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS t_consultation (
                                              id INT PRIMARY KEY AUTO_INCREMENT,
                                              consul_type VARCHAR(255) NOT NULL,
                                              name VARCHAR(255) NOT NULL,
                                              date DATE NOT NULL,
                                              description TEXT,
                                              consultation_status ENUM('Запланована', 'Відмінена', 'Завершена') NOT NULL DEFAULT 'Запланована',
                                              lawyer_id INT NOT NULL,
                                              client_id INT NOT NULL,
                                              FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id),
                                              FOREIGN KEY (client_id) REFERENCES t_client(id)
);

CREATE TABLE IF NOT EXISTS t_payment (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          amount DOUBLE,
                                          payment_date DATE,
                                          payment_method VARCHAR(255),
                                          payment_status ENUM('Очікується', 'Оплачено', 'Скасовано') NOT NULL DEFAULT 'Очікується'
);


CREATE TABLE IF NOT EXISTS t_schedule (
                                           id INT PRIMARY KEY AUTO_INCREMENT,
                                           date DATE NOT NULL,
                                           lawyer_id INT NOT NULL,
                                           consultation_id INT NOT NULL,
                                           FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id),
                                           FOREIGN KEY (consultation_id) REFERENCES t_consultation(id)
);

CREATE TABLE IF NOT EXISTS t_consult_payment (
                                                  consultation_id INT UNIQUE NOT NULL,
                                                  payment_id INT NOT NULL,
                                                  PRIMARY KEY (consultation_id, payment_id),
                                                  FOREIGN KEY (payment_id) REFERENCES t_payment(id),
                                                  FOREIGN KEY (consultation_id) REFERENCES t_consultation(id)
);



CREATE TABLE IF NOT EXISTS t_lawyer_salary (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            payment_month INT NOT NULL,
                            lawyer_id INT NOT NULL,
                            payment_id INT NOT NULL,
                            FOREIGN KEY (payment_id) REFERENCES t_payment(id),
                            FOREIGN KEY (lawyer_id) REFERENCES t_lawyer(id)
    );

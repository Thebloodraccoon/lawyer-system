INSERT INTO t_client (name, email, password_hash, phone_num)
VALUES ('John Doe', 'john.doe@example.com', 'hashed_password', '123-456-7890'),
       ('Andrew Doe', 'andrew.doe@example.com', 'hashed_password', '124-412-7890'),
       ('Jane Smith', 'jane.smith@example.com', 'hashed_password', '987-654-3210');

INSERT INTO t_lawyer (name, email, password_hash, phone_num, specialization)
VALUES ('Lawyer 1', 'lawyer1@example.com', 'hashed_password', '111-222-3333', 'Corporate Law'),
       ('Lawyer 2', 'lawyer2@example.com', 'hashed_password', '444-555-6666', 'Family Law');

-- Вставка тестових даних для таблиці t_consultation
INSERT INTO t_consultation (consul_type, name, date, description, consultation_status, lawyer_id, client_id) VALUES
       ('Особиста', 'Порада з цивільного права', '2024-05-10', 'Поради стосовно спадщини', 'Запланована', 1, 1),
       ('Віддалена', 'Порада з кримінального права', '2024-05-15', 'Поради стосовно кримінальної справи', 'Запланована', 1, 2),
       ('Особиста', 'Порада з кримінального права', '2024-10-15', 'Поради кримінальної справи', 'Запланована', 2, 1);

-- Вставка тестових даних для таблиці t_payment
INSERT INTO t_payment (amount, payment_date, payment_method, payment_status) VALUES
                                                                                 (1000.00, '2024-05-08', 'Кредитна карта', 'Оплачено'),
                                                                                 (1500.00, '2024-05-12', 'Готівка', 'Очікується'),
                                                                                 (3000.00, '2024-05-19', 'Готівка', 'Оплачено'),
                                                                                 (4500.00, '2024-05-20', 'Готівка', 'Оплачено');

-- Вставка тестових даних для таблиці t_schedule
INSERT INTO t_schedule (date, lawyer_id, consultation_id) VALUES
                                                              ('2024-05-10', 1, 1),
                                                              ('2024-10-15', 1, 2),
                                                              ('2024-05-15', 2, 3);

-- Вставка тестових даних для таблиці t_consult_payment
INSERT INTO t_consult_payment (consultation_id, payment_id) VALUES
                                                                (1, 1),
                                                                (2, 2);

-- Вставка тестових даних для таблиці t_lawyer_salary
INSERT INTO t_lawyer_salary (payment_month, lawyer_id, payment_id) VALUES
                                                                       (5, 1, 3),
                                                                       (5, 2, 4);
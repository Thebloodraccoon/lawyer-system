-- Вставка тестовых данных для таблицы t_clients
INSERT INTO t_client (name, email, password_hash, address, phone_num)
VALUES ('John Doe', 'johndoe@example.com', 'hashed_password_1', '123 Main St', '123-456-7890'),
       ('Jane Smith', 'janesmith@example.com', 'hashed_password_2', '456 Elm St', '987-654-3210');

-- Вставка тестовых данных для таблицы t_lawyers
INSERT INTO t_lawyer (name, email, password_hash, address, phone_num, specialization)
VALUES ('Alice Johnson', 'alicejohnson@example.com', 'hashed_password_3', '789 Oak St', '321-654-9870', 'Family Law'),
       ('Bob Williams', 'bobwilliams@example.com', 'hashed_password_4', '101 Pine St', '789-456-1230', 'Corporate Law');

-- Вставка тестовых данных для таблицы t_consultations
INSERT INTO t_consultation (consul_type, name, date, description, consultation_status, lawyer_id, client_id)
VALUES ('Legal Advice', 'Consultation 1', '2024-05-01', 'Review legal documents', 'Запланована', 1, 1),
       ('Contract Review', 'Consultation 2', '2024-05-05', 'Review business contract', 'Запланована', 2, 2);

-- Вставка тестовых данных для таблицы t_payments
INSERT INTO t_payment (amount, payment_date, payment_method, payment_status)
VALUES (100.00, '2024-05-02', 'Credit Card', 'Оплачено'),
       (150.00, '2024-05-06', 'Bank Transfer', 'Очікується');

-- Вставка тестовых данных для таблицы t_schedules
INSERT INTO t_schedule (date, lawyer_id, consultation_id)
VALUES ('2024-05-01', 1, 1),
       ('2024-05-05', 2, 2);

-- Вставка тестовых данных для таблицы t_consult_payments
INSERT INTO t_consult_payment (consultation_id, payment_id)
VALUES (1, 1),
       (2, 2);

-- Вставка тестовых данных для таблицы t_administrators
INSERT INTO t_administrator (name, email, password_hash, address, phone_num)
VALUES ('Admin User', 'admin@example.com', 'hashed_password_admin', '789 Pine St', '456-789-1230');

-- Вставка тестовых данных для таблицы t_lawyer_payments
INSERT INTO t_lawyer_salary (administrator_id, lawyer_id, payment_id, payment_month)
VALUES (1, 1, 1, 9),
       (1, 2, 2, 9);
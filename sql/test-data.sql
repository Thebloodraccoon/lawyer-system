INSERT INTO t_client (name, email, password, phone_num) VALUES
                                                            ('John Doe', 'john.doe@example.com', 'password123', '123-456-7890'),
                                                            ('Jane Smith', 'jane.smith@example.com', 'password123', '234-567-8901'),
                                                            ('Alice Johnson', 'alice.johnson@example.com', 'password123', '345-678-9012');

-- Юристы
INSERT INTO t_lawyer (name, email, password, phone_num, specialization, years_of_experience, license_number, office_address, bio) VALUES
                                                                                                                                      ('Lawyer One', 'lawyer.one@example.com', 'password123', '456-789-0123', 'Family Law', 10, 'LIC123456', '123 Main St', 'Experienced family lawyer.'),
                                                                                                                                      ('Lawyer Two', 'lawyer.two@example.com', 'password123', '567-890-1234', 'Corporate Law', 15, 'LIC234567', '456 Elm St', 'Expert in corporate law.'),
                                                                                                                                      ('Lawyer Three', 'lawyer.three@example.com', 'password123', '678-901-2345', 'Criminal Law', 20, 'LIC345678', '789 Oak St', 'Criminal defense attorney with over 20 years of experience.');

-- Консультации
INSERT INTO t_consultation (consul_type, name, date, cost, consultation_status, lawyer_id, client_id) VALUES
                                                                                                          ('Legal Advice', 'Consultation 1', '2024-05-20', 100.0, 'Запланована', 1, 1),
                                                                                                          ('Legal Advice', 'Consultation 2', '2024-05-21', 150.0, 'Запланована', 2, 2),
                                                                                                          ('Legal Advice', 'Consultation 3', '2024-05-22', 200.0, 'Запланована', 3, 3);

-- Платежи
INSERT INTO t_payment (consultation_id, amount, payment_date, payment_method, payment_status) VALUES
                                                                                                  (1, 50.0, '2024-05-18', 'Credit Card', 'Оплачено'),
                                                                                                  (1, 50.0, '2024-05-19', 'Credit Card', 'Оплачено'),
                                                                                                  (2, 75.0, '2024-05-18', 'Credit Card', 'Оплачено'),
                                                                                                  (2, 75.0, '2024-05-19', 'Credit Card', 'Оплачено'),
                                                                                                  (3, 100.0, '2024-05-18', 'Credit Card', 'Оплачено'),
                                                                                                  (3, 100.0, '2024-05-19', 'Credit Card', 'Оплачено');

-- Расписания
INSERT INTO t_schedule (date, lawyer_id, consultation_id) VALUES
                                                              ('2024-05-20', 1, 1),
                                                              ('2024-05-21', 2, 2),
                                                              ('2024-05-22', 3, 3);
INSERT INTO t_client (name, email, password, phone_num) VALUES
                                                            ('John Doe', 'john.doe@example.com', 'password123', '123-456-7890'),
                                                            ('Jane Smith', 'jane.smith@example.com', 'password123', '234-567-8901'),
                                                            ('Alice Johnson', 'alice.johnson@example.com', 'password123', '345-678-9012');

-- Lawyers
INSERT INTO t_lawyer (name, email, password, phone_num, specialization, years_of_experience, license_number, office_address, bio) VALUES
                                                                                                                                      ('Lawyer One', 'lawyer.one@example.com', 'password123', '456-789-0123', 'FAMILY_LAW', 10, 'LIC123456', '123 Main St', 'Experienced family lawyer.'),
                                                                                                                                      ('Lawyer Two', 'lawyer.two@example.com', 'password123', '567-890-1234', 'CORPORATE_LAW', 15, 'LIC234567', '456 Elm St', 'Expert in corporate law.'),
                                                                                                                                      ('Lawyer Three', 'lawyer.three@example.com', 'password123', '678-901-2345', 'CRIMINAL_LAW', 20, 'LIC345678', '789 Oak St', 'Criminal defense attorney with over 20 years of experience.');

-- Consultations
INSERT INTO t_consultation (consul_type, name, date, cost, consultation_status, lawyer_id, client_id) VALUES
                                                                                                          ('FAMILY_LAW', 'Consultation 1', '2024-05-20 08:00:00', 100.0, 'Planned', 1, 1),
                                                                                                          ('CORPORATE_LAW', 'Consultation 2', '2024-05-21 12:30:00', 150.0, 'Planned', 2, 2),
                                                                                                          ('CRIMINAL_LAW', 'Consultation 3', '2024-05-22 10:00:00', 200.0, 'Planned', 3, 3);

-- Платежи
INSERT INTO t_payment (consultation_id, amount, payment_date, payment_method, payment_status) VALUES
                                                                                                  (1, 50.0, '2024-05-18', 'Credit Card', 'Payed'),
                                                                                                  (1, 50.0, '2024-05-19', 'Credit Card', 'Payed'),
                                                                                                  (2, 75.0, '2024-05-18', 'Credit Card', 'Payed'),
                                                                                                  (2, 75.0, '2024-05-19', 'Credit Card', 'Payed'),
                                                                                                  (3, 100.0, '2024-05-18', 'Credit Card', 'Payed'),
                                                                                                  (3, 100.0, '2024-05-19', 'Credit Card', 'Payed');

-- Расписания
INSERT INTO t_schedule (date, lawyer_id, consultation_id) VALUES
                                                              ('2024-05-20 08:00:00', 1, 1),
                                                              ('2024-05-21 12:30:00', 2, 2),
                                                              ('2024-05-22 10:00:00', 3, 3);
INSERT INTO t_client (name, email, password, phone_num) VALUES
                                                            ('John Doe', 'john.doe@example.com', 'password123', '123-456-7890'),
                                                            ('Jane Smith', 'jane.smith@email.com', 'pass321', '+9876543210'),
                                                            ('Alice Johnson', 'alice.johnson@email.com', 'securepwd', '+1112223333'),
                                                            ('Bob Brown', 'bob.brown@email.com', 'strongpass', '+4445556666'),
                                                            ('Emma Davis', 'emma.davis@email.com', 'secret123', '+1234567890'),
                                                            ('William Wilson', 'william.wilson@email.com', 'wil123', '+9998887776');

-- Lawyers
INSERT INTO t_lawyer (name, email, password, phone_num, specialization, years_of_experience, license_number, office_address, bio)
VALUES
    ('Michael White', 'michael.white@email.com', 'lawyerpass', '+9998887777', 'CIVIL_LAW', 8, 'ABC123456', '123 Law St., City', 'Experienced civil lawyer with a focus on contract disputes.'),
    ('Emily Green', 'emily.green@email.com', 'law123', '+1112223333', 'CRIMINAL_LAW', 5, 'DEF7891011', '456 Justice Ave., Town', 'Passionate criminal defense attorney dedicated to protecting clients.'),
    ('David Black', 'david.black@email.com', 'attorneypass', '+7778889999', 'LABOR_LAW', 10, 'GHI121314', '789 Legal Blvd., Village', 'Skilled labor lawyer advocating for employee rights.'),
    ('Olivia Brown', 'olivia.brown@email.com', 'passlawyer', '+2223334444', 'FAMILY_LAW', 6, 'JKL151617', '321 Family St., Suburb', 'Experienced family attorney specializing in child custody cases.'),
    ('Sophia Gray', 'sophia.gray@email.com', 'gray123', '+5556667777', 'REAL_ESTATE_AND_PROPERTY_LAW', 7, 'MNO181920', '567 Property Dr., Countryside', 'Knowledgeable real estate lawyer handling property transactions and disputes.'),
    ('Robert Green', 'robert.green@email.com', 'greenlaw', '+3334445555', 'CORPORATE_LAW', 9, 'PQR212223', '890 Corporate Blvd., Metro', 'Seasoned corporate attorney assisting businesses with legal matters.'),
    ('Jessica White', 'jessica.white@email.com', 'jesspass', '+8889990000', 'TAX_LAW', 4, 'STU242526', '123 Tax St., Capital', 'Dedicated tax attorney providing tax planning and representation services.'),
    ('Daniel Brown', 'daniel.brown@email.com', 'brownlaw', '+4445556666', 'ADMINISTRATIVE_LAW', 8, 'VWX272829', '456 Admin Dr., District', 'Experienced administrative lawyer handling regulatory issues and government matters.'),
    ('Sophie Green', 'sophie.green@email.com', 'greenpass', '+6667778888', 'INTELLECTUAL_PROPERTY_LAW', 5, 'YZA303132', '789 IP Ave., Technology Park', 'Specialist in intellectual property law, assisting clients with patents and trademarks.'),
    ('Nathan Black', 'nathan.black@email.com', 'nathan123', '+1112223333', 'BANKRUPTCY_AND_FINANCIAL_LAW', 7, 'BCD333435', '321 Finance St., Downtown', 'Experienced bankruptcy and financial attorney helping clients navigate financial challenges.');


-- Consultations
INSERT INTO t_consultation (consul_type, name, date, cost, consultation_status, lawyer_id, client_id)
VALUES
    ('FAMILY_LAW', 'Child Custody Advice', '2024-05-01 09:00:00', 250.00, 'Completed', 4, 1),
    ('CORPORATE_LAW', 'Corporate Legal Guidance', '2024-05-10 12:30:00', 190.00, 'Completed', 6, 1),
    ('FAMILY_LAW', 'Child Custody Advice', '2024-05-11 08:00:00', 250.00, 'Completed', 4, 2),
    ('CIVIL_LAW', 'Contract Review', '2024-05-15 10:00:00', 150.00, 'Completed', 1, 1),
    ('CRIMINAL_LAW', 'Defense Strategy', '2024-05-20 14:30:00', 200.00, 'Completed', 2, 2),
    ('ADMINISTRATIVE_LAW', 'Regulatory Compliance Consultation', '2024-06-20 09:30:00', 280.00, 'Planned', 8, 1),
    ('INTELLECTUAL_PROPERTY_LAW', 'Intellectual Property Review', '2024-06-25 14:00:00', 150.00, 'Planned', 9, 2),
    ('BANKRUPTCY_AND_FINANCIAL_LAW', 'Financial Recovery Strategy', '2024-06-30 10:30:00', 170.00, 'Planned', 10, 3),
    ('REAL_ESTATE_AND_PROPERTY_LAW', 'Property Purchase Consultation', '2024-07-05 15:45:00', 120.00, 'Planned', 5, 1);


-- Payments
INSERT INTO t_payment (consultation_id, amount, payment_date, payment_method, payment_status)
VALUES
    (1, 250.00, '2024-05-01', 'Cash', 'Payed'),
    (2, 190.00, '2024-05-10', 'PayPal', 'Payed'),
    (3, 250.00, '2024-05-11', 'Bank Transfer', 'Payed'),
    (4, 150.00, '2024-05-15', 'Credit Card', 'Payed'),
    (5, 200.00, '2024-05-20', 'PayPal', 'Payed'),
    (6, 280.00, '2024-06-20', 'Credit Card', 'Expected'),
    (7, 150.00, '2024-06-25', 'Cash', 'Expected'),
    (8, 170.00, '2024-06-30', 'Bank Transfer', 'Expected'),
    (9, 120.00, '2024-07-05', 'Credit Card', 'Expected');

-- Schedules
INSERT INTO t_schedule (date, lawyer_id, consultation_id)
VALUES
    ('2024-05-01 09:00:00', 4, 1),
    ('2024-05-10 12:30:00', 6, 2),
    ('2024-05-11 08:00:00', 4, 3),
    ('2024-05-15 10:00:00', 1, 4),
    ('2024-05-20 14:30:00', 2, 5),
    ('2024-06-20 09:30:00', 8, 6),
    ('2024-06-25 14:00:00', 9, 7),
    ('2024-06-30 10:30:00', 10, 8),
    ('2024-07-05 15:45:00', 5, 9);

-- Lawyer Salaries
INSERT INTO t_lawyer_salary (date, lawyer_id, salary)
VALUES
    ('2024-05-30', 1, 3000),
    ('2024-05-30', 2, 2500),
    ('2024-05-30', 3, 3500),
    ('2024-05-30', 4, 3200),
    ('2024-05-30', 5, 2800),
    ('2024-05-30', 6, 4000),
    ('2024-05-30', 7, 2700),
    ('2024-05-30', 8, 3000),
    ('2024-05-30', 9, 3200),
    ('2024-05-30', 10, 3500);
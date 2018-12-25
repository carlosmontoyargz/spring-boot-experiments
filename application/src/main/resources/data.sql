INSERT INTO company(id, legal_name, address)
VALUES (2001, 'Pitico', 'Costa Rica 5');

INSERT INTO company(id, legal_name, address)
VALUES (2002, 'Granda', 'Nicaragua 3');

INSERT INTO employee(id, first_name, last_name, birthday, company_id)
VALUES(1001, 'Carlos', 'Montoya', '1995-02-28'::DATE, 2001);

INSERT INTO employee(id, first_name, last_name, birthday, company_id)
VALUES(1002, 'Daniel', 'Gomez', '1992-12-09'::DATE, 2001);

INSERT INTO employee(id, first_name, last_name, birthday, company_id)
VALUES(1003, 'Oscar', 'Martinez', '1985-01-11'::DATE, 2002);
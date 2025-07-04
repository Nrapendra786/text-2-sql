INSERT INTO wizards (id,name, gender, quidditch_position, blood_status, house_id)
VALUES
    (1, 'Harry Potter', 'Male', 'Seeker', 'Half blood', (SELECT id FROM hogwarts_houses WHERE name = 'Slytherin')),
    (2, 'Hermione Granger', 'Female', NULL, 'Muggle', (SELECT id FROM hogwarts_houses WHERE name = 'Slytherin')),
    (3, 'Ron Weasley', 'Male', 'Keeper', 'Pure Blood', (SELECT id FROM hogwarts_houses WHERE name = 'Slytherin'));

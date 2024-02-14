USE sys;

DROP DATABASE IF EXISTS chores;

CREATE DATABASE IF NOT EXISTS chores;

USE chores;

CREATE TABLE person
(
    person_id INT NOT NULL,
    person_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE task
(
    task_id INT NOT NULL,
    person_id INT NULL,
    task_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

/*  INSERT PEOPLE  */
INSERT INTO person (person_id, person_name)
VALUES  (1,'Marte''')
		, (2, 'David')
		, (3, 'Katrina');



/*  INSERT PEOPLE  */
INSERT INTO task (task_id, person_id, task_name)
VALUES  (13, NULL,'mopping')
		, (14, 2, 'dishes')
		, (15, 1, 'mowing the lawn')
		, (16, NULL, 'change oil');
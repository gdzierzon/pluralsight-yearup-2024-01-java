USE chores;

-- inner join
SELECT *
FROM person AS p
INNER JOIN task AS t
	ON p.person_id = t.person_id;
    
-- LEFT outer join returns all rows
-- from the left table
-- and only related rows from the right table
SELECT *
FROM person AS p 
LEFT OUTER JOIN task AS t
	ON p.person_id = t.person_id;

-- RIGHT outer join returns all 
-- rows from the right table
SELECT *
FROM person AS p 
RIGHT OUTER JOIN task AS t
	ON p.person_id = t.person_id;
    
-- FULL outer join
-- returns all rows from BOTH tables
-- SELECT *
-- FROM person AS p 
-- FULL OUTER JOIN task AS t
-- 	ON p.person_id = t.person_id;

-- MySQL does not support FULL outer join
-- but you can use a UNION statement to combine
-- LEFT and RIGHT joins
SELECT *
FROM person AS p 
LEFT OUTER JOIN task AS t
	ON p.person_id = t.person_id

UNION -- combines the results of 2 queries

SELECT *
FROM person AS p 
RIGHT OUTER JOIN task AS t
	ON p.person_id = t.person_id;
    
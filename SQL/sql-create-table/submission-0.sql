
CREATE TABLE videos (
    id INT,
    name text,
    created_at Date ,
    published BOOLEAN 
);






-- Do not modify below this line --
SELECT table_name, column_name, data_type
FROM information_schema.columns
WHERE table_name = 'videos';

   -- CREATE USER "sanjana" WITH PASSWORD 'sanjax@102';

SELECT current_user;

-- CREATE DATABASE finance_manager;

-- USE finance_manager;

-- DROP TABLE IF EXISTS public.transactions;
-- DROP TABLE IF EXISTS transactions;

SELECT table_schema, table_name
FROM information_schema.tables
WHERE table_name = 'transactions';

SELECT * FROM pg_tables WHERE tablename = 'transactions';

SET search_path TO public;

SELECT * FROM public.transactions;

SELECT relname
FROM pg_class
WHERE relname = 'transactions';

SELECT current_database();

SELECT grantee, table_schema, table_name, privilege_type
FROM information_schema.role_table_grants
WHERE table_name = 'transactions';

GRANT ALL PRIVILEGES ON TABLE public.transactions TO "Sanjana Das";

SELECT c.relname, n.nspname
FROM pg_class c
JOIN pg_namespace n ON c.relnamespace = n.oid
WHERE c.relname = 'transactions' AND n.nspname = 'public';

SELECT conname
FROM pg_constraint
WHERE conrelid = 'transactions'::regclass;

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,      
    name VARCHAR(100) NOT NULL   
);

INSERT INTO categories (name)
VALUES ('Salary'), ('Groceries'), ('Rent');

ALTER TABLE public.transactions
ADD CONSTRAINT fk_category
FOREIGN KEY (category_id)
REFERENCES categories(id)
ON DELETE SET NULL;  


SELECT conname, conrelid::regclass AS table_name, a.attname AS column_name, 
       confrelid::regclass AS foreign_table_name, af.attname AS foreign_column_name
FROM pg_constraint c
JOIN pg_attribute a ON a.attnum = c.conkey[1] AND a.attrelid = c.conrelid
JOIN pg_attribute af ON af.attnum = c.confkey[1] AND af.attrelid = c.confrelid
WHERE c.conname = 'fk_category';  

-- DROP TABLE IF EXISTS transactions;

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,                 
    amount NUMERIC(10, 2) NOT NULL,         
    type VARCHAR(10) NOT NULL CHECK (type IN ('Debit', 'Credit')),  
    category_id INTEGER,                   
    date DATE NOT NULL,                     
    description TEXT, 
    CONSTRAINT fk_category FOREIGN KEY (category_id)
    REFERENCES categories(id)
);

SELECT table_schema, table_name
FROM information_schema.tables
WHERE table_name IN ('categories', 'transactions');

INSERT INTO transactions (amount, type, category_id, date, description)
VALUES 
    (1000.00, 'Credit', 1, '2024-11-07', 'Salary Payment'),
    (200.00, 'Debit', 2, '2024-11-08', 'Groceries'),
    (500.00, 'Debit', 3, '2024-11-09', 'Rent Payment');

SELECT * FROM categories;

SELECT * FROM transactions;
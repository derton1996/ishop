CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
CREATE SCHEMA ishop;

GRANT ALL PRIVILEGES ON ishop .* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
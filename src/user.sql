
CREATE USER 'jaruser'@'localhost' IDENTIFIED by 'password';
GRANT select ON jarcompany.* TO jaruser@localhost;

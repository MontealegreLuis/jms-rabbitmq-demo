INSERT INTO users (id, username, email, password) VALUES (100, 'MontealegreLuis', 'luis@example.com', 'luis');
INSERT INTO users (id, username, email, password) VALUES (101, 'ComPHPPuebla', 'hello@example.com', 'hello');

INSERT INTO projects (id, name, description, url, user_id) VALUES (100, 'YELP API V3 client', 'Java Client for Yelp Fusion', 'https://github.com/MontealegreLuis/yelpv3-java-client', 100);
INSERT INTO projects (id, name, description, url, user_id) VALUES (101, 'Doctrine DBAL fixtures', 'Fixtures management with Doctrine DBAL', 'https://github.com/ComPHPPuebla/dbal-fixtures', 101);
INSERT INTO projects (id, name, description, url, user_id) VALUES (102, 'Slim modules', 'Organize your Slim applications in a modular structure', 'https://github.com/ComPHPPuebla/slim-modules', 101);

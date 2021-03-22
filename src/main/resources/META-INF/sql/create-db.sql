
CREATE TABLE IF NOT EXISTS JAVAEE_TODO.TODO(
    id int AUTO_INCREMENT PRIMARY KEY,
    title varchar(100) NOT NULL,
    objective varchar(255),
    creation_date date,
    completed int DEFAULT 0
);
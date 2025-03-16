--liquibase formatted sql
--changeset arkadiy.tepman:create-todo-table

CREATE TABLE IF NOT EXISTS todo
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500) NULL,
    dueDate DATETIME NOT NULL,
    priority enum ('HIGH','LOW','MEDIUM') NOT NULL,
    status TINYINT NULL,
    createdDate DATETIME NOT NULL,
    updatedDate DATETIME NULL,
    userId BIGINT NOT NULL,

    unique index(title),
    check ('status' between 0 and 2)
) ENGINE=InnoDB;

--rollback DROP TABLE IF EXISTS todo;
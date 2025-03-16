--liquibase formatted sql
--changeset arkadiy.tepman:create-taskhistory-table

CREATE TABLE IF NOT EXISTS taskhistory
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    todo_id BIGINT NOT NULL,
    change_date DATETIME NOT NULL,
    old_state VARCHAR(255) NOT NULL,
    new_state VARCHAR(255) NOT NULL,
    changed_by VARCHAR(255) NOT NULL,

    index(todo_id),
    constraint FK1iji4pwd3r4ei05g9dy258kwi foreign key (todo_id) references todo (id)
) ENGINE=InnoDB;

--rollback DROP TABLE IF EXISTS taskhistory;
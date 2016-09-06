--liquibase formatted sql

--changeset powion:create_crew_table
CREATE TABLE crew(
    id TEXT primary key,
    swag_mail TEXT,
    normie_mail TEXT,
    route_id TEXT,
    timestamp TIMESTAMP
);
--rollback DROP TABLE crew;
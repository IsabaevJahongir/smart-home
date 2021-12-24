CREATE DATABASE auth;

CREATE TABLE roles(
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(32) NOT NULL
);

INSERT INTO roles VALUES (1, 'admin'), (2, 'worker'), (3, 'user');

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    login VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(32) NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    role_id INTEGER NOT NULL DEFAULT 3,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);



CREATE DATABASE server;

CREATE TABLE home(
    id SERIAL PRIMARY KEY,
    home_name VARCHAR(32) NOT NULL UNIQUE,
    home_owner VARCHAR(32)

);

CREATE TYPE alarm_state AS ENUM ('activate', 'deactivate', 'alert');

CREATE TABLE alarm(
    id SERIAL PRIMARY KEY,
    state alarm_state,
    home_id INTEGER NOT NULL,
    FOREIGN KEY (home_id) REFERENCES home(id)
);

CREATE TABLE room(
    id SERIAL PRIMARY KEY,
    room_name VARCHAR(32) NOT NULL
);

CREATE TABLE home_room(
    home_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    FOREIGN KEY (home_id) REFERENCES home(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE light(
    uuid VARCHAR(36) PRIMARY KEY,
    id VARCHAR(12) NOT NULL,
    is_on BOOLEAN NOT NULL
);

CREATE TABLE door(
    uuid VARCHAR(36) PRIMARY KEY,
    id VARCHAR(12) NOT NULL,
    is_open BOOLEAN NOT NULL
);

CREATE TABLE room_light(
    room_id INTEGER NOT NULL,
    light_uuid VARCHAR(36) NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id),
    FOREIGN KEY (light_uuid) REFERENCES light(uuid)
);

CREATE TABLE room_door(
    room_id INTEGER NOT NULL,
    door_uuid VARCHAR(36) NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id),
    FOREIGN KEY (door_uuid) REFERENCES door(uuid)
);



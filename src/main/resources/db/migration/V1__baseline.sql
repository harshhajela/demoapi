DROP TABLE IF EXISTS players;

CREATE TABLE players (
    player_id INT AUTO_INCREMENT PRIMARY KEY,
    username varchar NOT NULL,
    password varchar NOT NULL,
    real_money double,
    bonus_money double,
    registration_timestamp timestamp
);
CREATE TABLE participant_meetup(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username CHARACTER VARYING(255) NOT NULL,
    meet_id INTEGER NOT NULL,
    created_at timestamp not null,
    email CHARACTER VARYING(255) not null,
    FOREIGN KEY (meet_id) REFERENCES meetup (id)
);
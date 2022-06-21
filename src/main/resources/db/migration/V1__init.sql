CREATE TABLE meetup(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    reason CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255),
    status CHARACTER VARYING(255),
    date timestamp not null
)
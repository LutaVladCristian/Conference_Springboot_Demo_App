CREATE TABLE ticket_types
(
    ticket_type_code  varchar(1) PRIMARY KEY,
    ticket_type_name  varchar(30)  NOT NULL,
    description       varchar(100) NOT NULL,
    includes_workshop boolean      NOT NULL
);

CREATE TABLE pricing_categories
(
    pricing_category_code varchar(1) PRIMARY KEY,
    pricing_category_name varchar(20) NOT NULL,
    pricing_start_date    date        NOT NULL,
    pricing_end_date      date        NOT NULL
);

CREATE TABLE ticket_prices
(
    ticket_price_id       SERIAL PRIMARY KEY,
    ticket_type_code      varchar(1)    NOT NULL REFERENCES ticket_types (ticket_type_code),
    pricing_category_code varchar(1)    NOT NULL REFERENCES pricing_categories (pricing_category_code),
    base_price            numeric(8, 2) NOT NULL
);

CREATE TABLE time_slots
(
    time_slot_id         SERIAL PRIMARY KEY,
    time_slot_date       date                   NOT NULL,
    start_time           time  					NOT NULL,
    end_time             time  					NOT NULL,
    is_keynote_time_slot boolean default false  NOT NULL
);

CREATE TABLE sessions
(
    session_id          SERIAL PRIMARY KEY,
    session_name        varchar(80)   NOT NULL,
    session_description varchar(1024) NOT NULL,
    session_length      integer       NOT NULL
);

CREATE TABLE session_schedule
(
    schedule_id  SERIAL PRIMARY KEY,
    time_slot_id integer     NOT NULL REFERENCES time_slots (time_slot_id),
    session_id   integer     NOT NULL REFERENCES sessions (session_id),
    room         varchar(30) NOT NULL
);

CREATE TABLE tags
(
    tag_id      SERIAL PRIMARY KEY,
    description varchar(30) NOT NULL
);

CREATE TABLE speakers
(
    speaker_id    SERIAL PRIMARY KEY,
    first_name    varchar(30)   NOT NULL,
    last_name     varchar(30)   NOT NULL,
    title         varchar(40)   NOT NULL,
    company       varchar(50)   NOT NULL,
    speaker_bio   varchar(2000) NOT NULL,
    speaker_photo BLOB   		NULL
);

CREATE TABLE session_speakers
(
    session_id integer NOT NULL REFERENCES sessions (session_id),
    speaker_id integer NOT NULL REFERENCES speakers (speaker_id)
);

CREATE TABLE workshops
(
    workshop_id   SERIAL PRIMARY KEY,
    workshop_name varchar(60)   NOT NULL,
    description   varchar(1024) NOT NULL,
    requirements  varchar(1024) NOT NULL,
    room          varchar(30)   NOT NULL,
    capacity      integer       NOT NULL
);
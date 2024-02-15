CREATE TABLE film (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    genre TEXT NOT NULL,
    description TEXT NOT NULL,
    watched_date date
);
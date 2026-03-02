CREATE TABLE Organizations (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    organization_name TEXT,
    location_address TEXT,
    location_number INTEGER
);

CREATE TABLE Users (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    email TEXT,
    graduation_year INTEGER
);

CREATE TABLE volunteer_hours (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    organization_id INTEGER,
    date TEXT,
    hours INTEGER,
    CONSTRAINT volunteer_hours_Organizations_FK FOREIGN KEY (organization_id) REFERENCES Organizations(id),
    CONSTRAINT volunteer_hours_Users_FK FOREIGN KEY (user_id) REFERENCES Users(id)
);

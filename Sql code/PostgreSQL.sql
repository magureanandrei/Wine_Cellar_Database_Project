CREATE TABLE winetype (
    type_id INTEGER PRIMARY KEY,
    type_name VARCHAR(50)
);

CREATE TABLE region (
    region_id INTEGER PRIMARY KEY,
    region_name VARCHAR(100),
    country VARCHAR(50)
);

CREATE TABLE supplier (
    supplier_id INTEGER PRIMARY KEY,
    supplier_name VARCHAR(100),
    contact_email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(20)
);

CREATE TABLE wines (
    wine_id INTEGER PRIMARY KEY,
    name VARCHAR(100),
    type_id INTEGER,
    region_id INTEGER,
    vintage_year INTEGER,
    alcohol_percentage INTEGER,
    supplier_id INTEGER,
    FOREIGN KEY (type_id) REFERENCES winetype(type_id),
    FOREIGN KEY (region_id) REFERENCES region(region_id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);

CREATE TABLE cellarlocation (
    location_id INTEGER PRIMARY KEY,
    section VARCHAR(50),
    rack_number INTEGER,
    bottle_position INTEGER
);

CREATE TABLE inventory (
    inventory_id INTEGER PRIMARY KEY,
    wine_id INTEGER,
    location_id INTEGER,
    quantity INTEGER,
    bottle_size_ml INTEGER,
    FOREIGN KEY (wine_id) REFERENCES wines(wine_id),
    FOREIGN KEY (location_id) REFERENCES cellarlocation(location_id)
);

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    username VARCHAR(50),
    password_hash VARCHAR(255),
    role VARCHAR(20)
);

CREATE TABLE transactions (
    transaction_id INTEGER PRIMARY KEY,
    wine_id INTEGER,
    transaction_type VARCHAR(10),
    date DATE,
    quantity INTEGER,
    price_per_bottle INTEGER,
    user_id INTEGER,
    FOREIGN KEY (wine_id) REFERENCES wines(wine_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

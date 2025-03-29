CREATE TABLE winetype (
    type_id INT PRIMARY KEY,
    type_name VARCHAR(50)
);

CREATE TABLE region (
    region_id INT PRIMARY KEY,
    region_name VARCHAR(100),
    country VARCHAR(50)
);

CREATE TABLE supplier (
    supplier_id INT PRIMARY KEY,
    supplier_name VARCHAR(100),
    contact_email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(20)
);

CREATE TABLE wines (
    wine_id INT PRIMARY KEY,
    name VARCHAR(100),
    type_id INT,
    region_id INT,
    vintage_year INT,
    alcohol_percentage INT,
    supplier_id INT,
    FOREIGN KEY (type_id) REFERENCES WineType(type_id),
    FOREIGN KEY (region_id) REFERENCES Region(region_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

CREATE TABLE cellarlocation (
    location_id INT PRIMARY KEY,
    section VARCHAR(50),
    rack_number INT,
    bottle_position INT
);

CREATE TABLE inventory (
    inventory_id INT PRIMARY KEY,
    wine_id INT,
    location_id INT,
    quantity INT,
    bottle_size_ml INT,
    FOREIGN KEY (wine_id) REFERENCES Wines(wine_id),
    FOREIGN KEY (location_id) REFERENCES CellarLocation(location_id)
);

CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50),
    password_hash VARCHAR(255),
    role VARCHAR(20)
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    wine_id INT,
    transaction_type VARCHAR(10),
    date Date,
    quantity INT,
    price_per_bottle INT,
    user_id INT,
    FOREIGN KEY (wine_id) REFERENCES Wines(wine_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
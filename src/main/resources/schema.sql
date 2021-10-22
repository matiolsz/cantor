DROP TABLE IF EXISTS currency_exchange;

CREATE TABLE currency_exchange (
       id INT PRIMARY KEY,
       currency_from VARCHAR(250) NOT NULL,
       currency_to VARCHAR(250) NOT NULL,
       currency_multiplier INT DEFAULT NULL
    );
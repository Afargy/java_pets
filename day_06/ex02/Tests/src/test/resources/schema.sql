CREATE    SCHEMA IF NOT EXISTS products;

CREATE    TABLE IF NOT EXISTS products.product (
          "id" INT GENERATED BY DEFAULT AS IDENTITY (
          START
          WITH      1
          ) PRIMARY KEY,
          "name" VARCHAR(50) NOT NULL,
          "price" INT NOT NULL
          );

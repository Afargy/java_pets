DROP      SCHEMA IF EXISTS chat CASCADE;

CREATE    SCHEMA IF NOT EXISTS chat;

CREATE    TABLE IF NOT EXISTS chat.user (
          "id" SERIAL PRIMARY KEY,
          "login" VARCHAR(50) NOT NULL,
          "password" VARCHAR(50) NOT NULL
          );

CREATE    TABLE IF NOT EXISTS chat.chatroom (
          "id" SERIAL PRIMARY KEY,
          "name" VARCHAR(50) NOT NULL,
          "owner" INT,
          FOREIGN KEY ("owner") REFERENCES chat.user ("id")
          );

CREATE    TABLE IF NOT EXISTS chat.message (
          "id" SERIAL PRIMARY KEY,
          "author" INT,
          "room" INT,
          "text" TEXT,
          "date_and_time" TIMESTAMP,
          FOREIGN KEY ("author") REFERENCES chat.user ("id"),
          FOREIGN KEY ("room") REFERENCES chat.chatroom ("id")
          );

INSERT    INTO chat.user ("login", "password")
VALUES    ('user1', 'password1'),
          ('user2', 'password2'),
          ('user3', 'password3'),
          ('user4', 'password4'),
          ('user5', 'password5');

INSERT    INTO chat.chatroom ("name", "owner")
VALUES    ('Room 1', 1),
          ('Room 2', 2),
          ('Room 3', 3),
          ('Room 4', 4),
          ('Room 5', 5);

INSERT    INTO chat.message (author, room, "text", date_and_time)
VALUES    (1, 1, 'User 1. Room 1', NOW()),
          (2, 1, 'User 2. Room 1', NOW()),
          (3, 1, 'User 3. Room 1', NOW()),
          (4, 1, 'User 4. Room 1', NOW()),
          (5, 1, 'User 5. Room 1', NOW()),
          (1, 2, 'User 1. Room 2', NOW()),
          (2, 2, 'User 2. Room 2', NOW()),
          (3, 2, 'User 3. Room 2', NOW()),
          (4, 2, 'User 4. Room 2', NOW()),
          (5, 2, 'User 5. Room 2', NOW()),
          (1, 3, 'User 1. Room 3', NOW()),
          (2, 3, 'User 2. Room 3', NOW()),
          (3, 3, 'User 3. Room 3', NOW()),
          (4, 3, 'User 4. Room 3', NOW()),
          (5, 3, 'User 5. Room 3', NOW()),
          (1, 4, 'User 1. Room 4', NOW()),
          (2, 4, 'User 2. Room 4', NOW()),
          (3, 4, 'User 3. Room 4', NOW()),
          (4, 4, 'User 4. Room 4', NOW()),
          (5, 4, 'User 5. Room 4', NOW()),
          (1, 5, 'User 1. Room 5', NOW()),
          (2, 5, 'User 2. Room 5', NOW()),
          (3, 5, 'User 3. Room 5', NOW()),
          (4, 5, 'User 4. Room 5', NOW()),
          (5, 5, 'User 5. Room 5', NOW());

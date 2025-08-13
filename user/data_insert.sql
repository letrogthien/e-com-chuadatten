INSERT INTO `user_auth` (`id`, `username`, `email`, `password_hash`, `status`, `two_factor_enabled`, `is_kyc`, `two_factor_secret`, `created_at`, `updated_at`, `last_login_at`)
VALUES
    (uuid_to_bin('00000000-0000-0000-0000-000000000001'), 'user1', 'user1@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-01 10:00:00', '2025-08-13 10:00:00', '2025-08-13 09:55:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000002'), 'user2', 'user2@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 1, 1, 'secret2', '2025-01-02 11:00:00', '2025-08-13 10:01:00', '2025-08-12 15:30:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000003'), 'user3', 'user3@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'pending', 0, 0, NULL, '2025-01-03 12:00:00', '2025-01-03 12:00:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000004'), 'admin', 'admin@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 1, 1, 'secret-admin', '2025-01-04 13:00:00', '2025-08-13 10:02:00', '2025-08-13 10:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000005'), 'seller1', 'seller1@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 1, NULL, '2025-01-05 14:00:00', '2025-08-13 10:03:00', '2025-08-12 18:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000006'), 'seller2', 'seller2@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 1, 1, 'secret-seller2', '2025-01-06 15:00:00', '2025-08-13 10:04:00', '2025-08-13 08:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000007'), 'user7', 'user7@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'inactive', 0, 0, NULL, '2025-01-07 16:00:00', '2025-01-07 16:00:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000008'), 'user8', 'user8@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 1, NULL, '2025-01-08 17:00:00', '2025-08-13 10:05:00', '2025-08-11 12:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000009'), 'user9', 'user9@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-09 18:00:00', '2025-08-13 10:06:00', '2025-08-13 09:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000010'), 'user10', 'user10@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 1, 0, 'secret10', '2025-01-10 19:00:00', '2025-08-13 10:07:00', '2025-08-13 09:30:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000011'), 'user11', 'user11@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-11 20:00:00', '2025-08-13 10:08:00', '2025-08-13 09:45:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000012'), 'user12', 'user12@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-12 21:00:00', '2025-08-13 10:09:00', '2025-08-13 08:30:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000013'), 'user13', 'user13@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-13 22:00:00', '2025-08-13 10:10:00', '2025-08-13 07:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000014'), 'user14', 'user14@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-14 23:00:00', '2025-08-13 10:11:00', '2025-08-13 06:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000015'), 'user15', 'user15@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-15 00:00:00', '2025-08-13 10:12:00', '2025-08-13 05:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000016'), 'user16', 'user16@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-16 01:00:00', '2025-08-13 10:13:00', '2025-08-13 04:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000017'), 'user17', 'user17@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-17 02:00:00', '2025-08-13 10:14:00', '2025-08-13 03:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000018'), 'user18', 'user18@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-18 03:00:00', '2025-08-13 10:15:00', '2025-08-13 02:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000019'), 'user19', 'user19@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-19 04:00:00', '2025-08-13 10:16:00', '2025-08-13 01:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000020'), 'user20', 'user20@example.com', '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', 'active', 0, 0, NULL, '2025-01-20 05:00:00', '2025-08-13 10:17:00', '2025-08-13 00:00:00');



INSERT INTO `audit_logs` (`id`, `user_id`, `action`, `description`, `created_at`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), 'user_login', 'Successful login from user1', '2025-08-13 09:55:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000002'), 'user_update_profile', 'User2 updated their profile information', '2025-08-13 10:01:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000004'), 'admin_login', 'Successful login from admin', '2025-08-13 10:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000005'), 'seller_application_submit', 'Seller1 submitted a new seller application', '2025-08-12 18:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000006'), 'user_login', 'Successful login from seller2', '2025-08-13 08:00:00');



INSERT INTO `device_manager` (`id`, `created_at`, `device_name`, `device_type`, `last_login_at`, `user_id`)
VALUES
    (uuid_to_bin('10000000-0000-0000-0000-000000000001'), '2025-01-01 10:00:00', 'Laptop Chrome', 'Web', '2025-08-13 09:55:00', uuid_to_bin('00000000-0000-0000-0000-000000000001')),
    (uuid_to_bin('10000000-0000-0000-0000-000000000002'), '2025-01-02 11:00:00', 'iPhone 15', 'Mobile', '2025-08-12 15:30:00', uuid_to_bin('00000000-0000-0000-0000-000000000002')),
    (uuid_to_bin('10000000-0000-0000-0000-000000000003'), '2025-01-04 13:00:00', 'Desktop Edge', 'Web', '2025-08-13 10:00:00', uuid_to_bin('00000000-0000-0000-0000-000000000004')),
    (uuid_to_bin('10000000-0000-0000-0000-000000000004'), '2025-01-05 14:00:00', 'iPad Pro', 'Tablet', '2025-08-12 18:00:00', uuid_to_bin('00000000-0000-0000-0000-000000000005')),
    (uuid_to_bin('10000000-0000-0000-0000-000000000005'), '2025-01-06 15:00:00', 'Android S24', 'Mobile', '2025-08-13 08:00:00', uuid_to_bin('00000000-0000-0000-0000-000000000006'));


INSERT INTO `login_history` (`id`, `user_id`, `login_at`, `ip_address`, `device_info`, `success`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), '2025-08-13 09:55:00', '192.168.1.101', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000002'), '2025-08-12 15:30:00', '203.0.113.50', 'Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Mobile/15E148 Safari/604.1', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000004'), '2025-08-13 10:00:00', '10.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000005'), '2025-08-12 18:00:00', '203.0.113.100', 'Mozilla/5.0 (iPad; CPU OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/90.0.4430.216 Mobile/15E148 Safari/604.1', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000006'), '2025-08-13 08:00:00', '198.51.100.25', 'Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.79 Mobile Safari/537.36', 1);


INSERT INTO `password_history` (`id`, `user_id`, `password_hash`, `created_at`, `current_index`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', '2025-01-01 10:00:00', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000002'), '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', '2025-01-02 11:00:00', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000004'), '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', '2025-01-04 13:00:00', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000005'), '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', '2025-01-05 14:00:00', 1),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000006'), '$2a$10$eE0m1j3U30/f.5K5k619bO7W2Z3cE6x1p/Xf6h.w.2X5v.5V0t4V.4', '2025-01-06 15:00:00', 1);




INSERT INTO `user_roles` (`user_id`, `role_id`)
VALUES
    (uuid_to_bin('00000000-0000-0000-0000-000000000001'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000002'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000004'), (SELECT id FROM `roles` WHERE name = 'ROLE_ADMIN')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000005'), (SELECT id FROM `roles` WHERE name = 'ROLE_SELLER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000006'), (SELECT id FROM `roles` WHERE name = 'ROLE_SELLER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000008'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000009'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000010'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000011'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000012'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000013'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000014'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000015'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000016'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000017'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000018'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000019'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER')),
    (uuid_to_bin('00000000-0000-0000-0000-000000000020'), (SELECT id FROM `roles` WHERE name = 'ROLE_USER'));


INSERT INTO `user_inf` (`id`, `display_name`, `email`, `country`, `status`, `avatar_url`, `is_seller`, `seller_bio`, `created_at`, `updated_at`, `deleted_at`)
VALUES
    (uuid_to_bin('00000000-0000-0000-0000-000000000001'), 'John Doe', 'user1@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-01 10:00:00', '2025-08-13 10:00:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000002'), 'Jane Smith', 'user2@example.com', 'Canada', 'active', NULL, FALSE, NULL, '2025-01-02 11:00:00', '2025-08-13 10:01:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000003'), 'Peter Jones', 'user3@example.com', 'UK', 'pending', NULL, FALSE, NULL, '2025-01-03 12:00:00', '2025-01-03 12:00:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000004'), 'Admin User', 'admin@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-04 13:00:00', '2025-08-13 10:02:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000005'), 'Mike Ross', 'seller1@example.com', 'USA', 'active', NULL, TRUE, 'Selling high-quality digital goods', '2025-01-05 14:00:00', '2025-08-13 10:03:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000006'), 'Rachel Zane', 'seller2@example.com', 'Canada', 'active', NULL, TRUE, 'Handmade crafts from a local artist', '2025-01-06 15:00:00', '2025-08-13 10:04:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000007'), 'Harvey Specter', 'user7@example.com', 'USA', 'inactive', NULL, FALSE, NULL, '2025-01-07 16:00:00', '2025-01-07 16:00:00', '2025-08-01 10:00:00'),
    (uuid_to_bin('00000000-0000-0000-0000-000000000008'), 'Donna Paulsen', 'user8@example.com', 'UK', 'active', NULL, FALSE, NULL, '2025-01-08 17:00:00', '2025-08-13 10:05:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000009'), 'Louis Litt', 'user9@example.com', 'Canada', 'active', NULL, FALSE, NULL, '2025-01-09 18:00:00', '2025-08-13 10:06:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000010'), 'Jessica Pearson', 'user10@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-10 19:00:00', '2025-08-13 10:07:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000011'), 'Samantha Wheeler', 'user11@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-11 20:00:00', '2025-08-13 10:08:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000012'), 'Katrina Bennett', 'user12@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-12 21:00:00', '2025-08-13 10:09:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000013'), 'Brian Altman', 'user13@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-13 22:00:00', '2025-08-13 10:10:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000014'), 'Scottie', 'user14@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-14 23:00:00', '2025-08-13 10:11:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000015'), 'Zoe Lawford', 'user15@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-15 00:00:00', '2025-08-13 10:12:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000016'), 'Robert Zane', 'user16@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-16 01:00:00', '2025-08-13 10:13:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000017'), 'Dana Scott', 'user17@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-17 02:00:00', '2025-08-13 10:14:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000018'), 'Daniel Hardman', 'user18@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-18 03:00:00', '2025-08-13 10:15:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000019'), 'Jack Soloff', 'user19@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-19 04:00:00', '2025-08-13 10:16:00', NULL),
    (uuid_to_bin('00000000-0000-0000-0000-000000000020'), 'Jeff Malone', 'user20@example.com', 'USA', 'active', NULL, FALSE, NULL, '2025-01-20 05:00:00', '2025-08-13 10:17:00', NULL);

INSERT INTO `preferences` (`id`, `user_id`, `notification_email`, `notification_push`, `preferred_currency`, `preferred_platform`, `privacy_public_profile`, `created_at`, `updated_at`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), TRUE, TRUE, 'USD', 'Web', TRUE, '2025-01-01 10:00:00', '2025-08-13 10:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000002'), TRUE, FALSE, 'CAD', 'Mobile', TRUE, '2025-01-02 11:00:00', '2025-08-13 10:01:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000004'), FALSE, TRUE, 'USD', 'Web', FALSE, '2025-01-04 13:00:00', '2025-08-13 10:02:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000005'), TRUE, TRUE, 'USD', 'Mobile', TRUE, '2025-01-05 14:00:00', '2025-08-13 10:03:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000006'), TRUE, FALSE, 'CAD', 'Web', TRUE, '2025-01-06 15:00:00', '2025-08-13 10:04:00');


INSERT INTO `transactions` (`id`, `user_id`, `product_id`, `order_id`, `transaction_type`, `amount`, `status`, `created_at`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), uuid_to_bin('20000000-0000-0000-0000-000000000001'), uuid_to_bin('30000000-0000-0000-0000-000000000001'), 'purchase', 25.50, 'completed', '2025-08-10 11:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000002'), uuid_to_bin('20000000-0000-0000-0000-000000000002'), uuid_to_bin('30000000-0000-0000-0000-000000000002'), 'purchase', 50.00, 'completed', '2025-08-11 12:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000001'), uuid_to_bin('20000000-0000-0000-0000-000000000003'), uuid_to_bin('30000000-0000-0000-0000-000000000003'), 'purchase', 10.00, 'completed', '2025-08-12 13:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000008'), uuid_to_bin('20000000-0000-0000-0000-000000000004'), uuid_to_bin('30000000-0000-0000-0000-000000000004'), 'purchase', 15.75, 'pending', '2025-08-13 14:00:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000009'), uuid_to_bin('20000000-0000-0000-0000-000000000005'), uuid_to_bin('30000000-0000-0000-0000-000000000005'), 'purchase', 5.00, 'failed', '2025-08-13 15:00:00');


INSERT INTO `seller_ratings` (`id`, `seller_id`, `buyer_id`, `transaction_id`, `rating_score`, `review_text`, `created_at`)
VALUES
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000005'), uuid_to_bin('00000000-0000-0000-0000-000000000001'), (SELECT id FROM `transactions` WHERE user_id = uuid_to_bin('00000000-0000-0000-0000-000000000001') ORDER BY created_at LIMIT 1), 5, 'Great product, fast delivery!', '2025-08-11 11:30:00'),
    (uuid_to_bin(uuid()), uuid_to_bin('00000000-0000-0000-0000-000000000006'), uuid_to_bin('00000000-0000-0000-0000-000000000002'), (SELECT id FROM `transactions` WHERE user_id = uuid_to_bin('00000000-0000-0000-0000-000000000002') ORDER BY created_at LIMIT 1), 4, 'Good quality, but shipping was a bit slow.', '2025-08-12 12:30:00');
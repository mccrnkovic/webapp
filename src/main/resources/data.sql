DELETE FROM hardware;
INSERT INTO hardware VALUES (0, 'headphones', 229.0, 'OTHER', 11);
INSERT INTO hardware VALUES (1, 'motherboard', 899.0, 'MBO', 5);
INSERT INTO hardware VALUES (2, 'graphics card', 659.0, 'GPU', 29);

DELETE FROM review;
INSERT INTO review VALUES (0, 'Ok headphones', 'okay quality', 4, 0);
INSERT INTO review VALUES (1, 'great MBO', 'great Quality', 5, 1);
INSERT INTO review VALUES (2, 'bad quality MBO', 'very bad', 1, 1);
INSERT INTO review VALUES (3, 'fine GPU', 'it could be better', 3, 2);

DELETE FROM authority;
INSERT INTO authority VALUES (0, 'ROLE_ADMIN');
INSERT INTO authority VALUES (1, 'ROLE_USER');
INSERT INTO authority VALUES (2, 'ROLE_CREATOR');

DELETE FROM `user`;
INSERT INTO `user` VALUES(0, 'admin', '$2a$12$ta7Yyy0QehvXUAYzGDLAfeP/E5t1HDikWLwebKhzysYt7WEe.OnpS');
INSERT INTO `user` VALUES(1, 'user', '$2a$12$dT4JTx2gPPzh8q9MzypIXuoqS0teLeWvFnNBd4aPJWZ0lNYBW.aZ2');
INSERT INTO `user` VALUES(2, 'creator', '$2a$12$dT4JTx2gPPzh8q9MzypIXuoqS0teLeWvFnNBd4aPJWZ0lNYBW.aZ2');

DELETE FROM user_authority;
INSERT INTO user_authority VALUES(0, 0);
INSERT INTO user_authority VALUES(1, 1);
INSERT INTO user_authority VALUES(2, 2);
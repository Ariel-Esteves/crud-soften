INSERT INTO user(login, name, password)
VALUES ('Admin', 'Admin', 'Jb123');


INSERT INTO client(id, name, cpf, ie, cep, address, number, district, complement, city, state, user_id) VALUES ( 1, 'consumidor', 000000000000, '000000000', 00000000,'josé bonifacio', 000, 'St terezinha', 'casa', 'jb', 'SAO_PAULO', 1);

/* INSERT INTO order_sale_items( total_value) VALUES (0); */

  INSERT INTO product(id, name, cost_value, sale_value, user_id) VALUES (1, 'uva', 2.00, 4.00, 1);
INSERT INTO product(id, name, cost_value, sale_value, user_id) VALUES (2, 'mamão', 3.00, 5.00, 1);

/*INSERT INTO order_sale(amount, total_value, unitary_value, product) VALUES (0, 0, 0, 1); */

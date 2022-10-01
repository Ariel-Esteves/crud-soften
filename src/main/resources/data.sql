INSERT INTO user(login, name, password)
VALUES ('Admin', 'Admin', 'Jb123');

/* importante para criar o "consumidor" do pedido de venda mas gera problemas se usado com update no application.yml achei o liquibase para resolver isso mas resolvi não implementar para não me enrolar depois*/
INSERT INTO client(id, name, cpf, ie, cep, address, number, district, complement, city, state, user_id) VALUES ( 1, 'consumidor', 000000000000, '000000000', 00000000,'josé bonifacio', 000, 'St terezinha', 'casa', 'jb', 'SAO_PAULO', 1);


/* items abaixo usados para testes*/
  INSERT INTO product(id, name, cost_value, sale_value, user_id) VALUES (1, 'uva', 2.00, 4.00, 1);
INSERT INTO product(id, name, cost_value, sale_value, user_id) VALUES (2, 'mamão', 3.00, 5.00, 1);


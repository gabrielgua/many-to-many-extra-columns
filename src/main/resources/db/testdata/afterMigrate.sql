set foreign_key_checks = 0;

delete from jogo;
delete from usuario;
delete from pedido;
delete from jogo_pedido;
delete from jogo_usuario;

set foreign_key_checks = 1;

alter table jogo auto_increment = 1;
alter table usuario auto_increment = 1;
alter table pedido auto_increment = 1;
alter table jogo_pedido auto_increment = 1;
alter table jogo_usuario auto_increment = 1;

insert into jogo (id, nome) values
(1, "Dark souls Remastered"),
(2, "God of War (2018)"),
(3, "Red dead Redemption 2");

insert into usuario (id, email) values
(1, "gabriel@email.com"),
(2, "usuario@email.com");

insert into pedido (id, usuario_id) values
(1, 1),
(2, 2);

insert into jogo_pedido (jogo_id, pedido_id) values
(1, 1),
(2, 1),
(3, 2);

insert into jogo_usuario (id, jogo_id, usuario_id, data_criacao, chave) values
(1, 1, 1, utc_timestamp, "0a8721c4-36ee-11ee-be56-0242ac120002"),
(2, 2, 1, utc_timestamp, "05fcf776-9ac5-493c-8ff3-dd8a95d9e938"),
(3, 3, 2, utc_timestamp, "63b7b282-cbd3-4fbc-963c-e3e5c650a628");

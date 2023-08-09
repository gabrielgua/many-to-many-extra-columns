create table jogo (
    id bigint not null auto_increment,
    nome varchar(255) not null,

    primary key (id)
) engine=InnoDB default charset=UTF8MB4;

create table usuario (
    id bigint not null auto_increment,
    email varchar(255) not null,

    primary key (id)
) engine=InnoDB default charset=UTF8MB4;

create table pedido (
    id bigint not null auto_increment,
    usuario_id bigint not null,

    primary key (id),
    constraint fk_pedido_usuario foreign key (usuario_id) references usuario (id)
) engine=InnoDB default charset=UTF8MB4;

create table jogo_pedido (
    pedido_id bigint not null,
    jogo_id bigint not null,

    primary key (pedido_id, jogo_id),
    constraint fk_jogo_pedido_jogo foreign key (jogo_id) references jogo (id),
    constraint fk_jogo_pedido_pedido foreign key (pedido_id) references pedido (id)

) engine=InnoDB default charset=UTF8MB4;


create table jogo_usuario (
    id bigint not null auto_increment,
    data_criacao datetime not null,
    chave varchar(255) not null,

    jogo_id bigint not null,
    usuario_id bigint not null,

    primary key (id),

    constraint fk_jogo_usuario_jogo foreign key (jogo_id) references jogo (id),
    constraint fk_jogo_usuario_usuario foreign key (usuario_id) references usuario (id)
) engine=InnoDB default charset=UTF8MB4;
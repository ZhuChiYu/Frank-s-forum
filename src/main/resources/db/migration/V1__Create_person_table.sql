create table user
(
    id           bigint auto_increment
        primary key,
    name         varchar(50)  null,
    account_id   varchar(100) null,
    token        char(36)     null,
    gmt_creat    bigint       null,
    gmt_modified bigint       null
);
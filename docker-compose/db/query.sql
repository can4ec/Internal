create table users (
    id bigint primary key,
    name varchar(200)
);

insert into users (id, name)
 select g.x, 'test'||g.x
 from generate_series(1, 1000000) as g(x);

--сбор статистики
vacuum analyze users;

explain (analyze, costs off, buffers)
select * from users where name = 'test1';

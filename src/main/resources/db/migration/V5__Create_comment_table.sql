create table comment
(
	id bigint auto_increment,
	parent_id bigint,
	type int,
	commentor int,
	gmt_create bigint,
	gmt_modified bigint,
	like_count bigint default 0,
	constraint comment_pk
		primary key (id)
);

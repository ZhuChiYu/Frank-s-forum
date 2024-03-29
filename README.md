## Java 论坛项目


## 资料
[Spring 文档](https://spring.io/guides)  
[Spring web](https://spring.io/guides/gs/serving-web-content/)  
[okhttp](https://square.github.io/okhttp/)  
[数据库教程](https://www.runoob.com/mysql/mysql-tutorial.html)  
[Github OAuth](https://developer.github.com/apps/building-github-apps/)  
[thymeleaf模版官方教程](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)  
[MyBatis Generator](http://www.mybatis.org/generator/)  
[Mysql菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html) 



## 对标网站
https://elasticsearch.cn/

## 工具
[快速搭建前端框架](https://v3.bootcss.com/getting-started/)
 
官网下载 Bootstrap源码，并加入到resource/static目录中

[Flyway数据库整合](https://flywaydb.org/getstarted/)


## 脚本
```sql
创建user表
create table user
(
    id           bigint auto_increment
        primary key,
    name         varchar(50)  null,
    account_id   varchar(100) null,
    token        char(36)     null,
    gmt_creat    bigint       null,
    gmt_modified bigint       null,
    bio varchar (256) null,
    avatar_url varchar(100) null
);

创建question表
create table question
(
	id bigint auto_increment primary key,
	title varchar(50) null,
	description text null,
	gmt_create bigint null,
	gmt_modified bigint null,
	creator bigint null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(256) null
);

创建回复表
create table comment
(
    id bigint auto_increment primary key,
    parent_id bigint not null,
    type int not null,
    commentator bigint not null,
    gmt_create bigint not null,
    gmt_modified bigint not null,
    like_count bigint default 0,
    comment_count bigint default 0,
    content varchar(1024) not null
);
```
```bash
[数据库迁移脚本]
mvn flyway:migrate
[mybatis-generatory运行脚本]
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

[github push脚本]
git status
git add .
git commit -m "..."
git push




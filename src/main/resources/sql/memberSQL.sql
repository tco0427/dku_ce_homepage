CREATE TABLE ceHomepage.`member`(
    id varchar(12) not NULL,
    `password` varchar(15) not NULL,
    email varchar(30) not NULL,
    name varchar(10) not NULL,
    nickname varchar(10),
    passwordHint varchar(20) not NULL,
    studentID int not NULL,
    CONSTRAINT PK PRIMARY KEY (id)
);

alter table ceHomepage.`member` add permission varchar(7) not null;
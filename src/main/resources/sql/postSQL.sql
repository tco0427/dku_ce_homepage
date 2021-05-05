CREATE TABLE ceHomepage.POST(
                                postPK int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                memberID varchar(12) not NULL,
                                title varchar(20) not NULL,
                                content text,
                                creationDate date,
                                classification varchar(10) not NULL
);

alter table ceHomepage.POST
    add constraint memberID
        FOREIGN KEY(memberID) REFERENCES ceHomepage.`member`(id);
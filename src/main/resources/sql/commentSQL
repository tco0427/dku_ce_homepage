create table ceHomepage.comment(
	commentPk int not null AUTO_INCREMENT primary key,
	memberID varchar(12) not null,
	postPk int not null,
	creationDate date,
	content text
);


alter table ceHomepage.comment
add constraint memberIDForComment
FOREIGN KEY(memberID) REFERENCES ceHomepage.`member`(id);

alter table ceHomepage.comment
add constraint postPK
FOREIGN KEY(postPK) REFERENCES ceHomepage.POST(postPK);
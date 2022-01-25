// 유저생성
create user food identified by food;
grant connect, resource to food;

//Member
create table member
(
  userid varchar2(10) primary key,
  passwd varchar2(10) not null,
  username varchar2(10) not null,
  post varchar2(6) not null,
  addr1 varchar2(500) not null,
  addr2 varchar2(500) not null,
  phone1 varchar2(3) not null,
  phone2 varchar2(4) not null,
  phone3 varchar2(4) not null,
  email1 varchar2(20) not null,
  email2 varchar2(20) not null
);

//Menu
create table menu
(
restaurant varchar2(50) not null,
menu varchar2(50) not null,
genre varchar2(30) not null,
estyle varchar2(10) not null,
texture varchar2(30) not null,
taste varchar2(30) not null,
sauce varchar2(30) not null,
spice varchar2(30) not null,
carbo varchar2(30) not null,
meat varchar2(30) not null,
fat varchar2(30) not null,
vegi varchar2(30) not null,
image varchar(30) not null
);


//likes 테이블
create table likes
(
userid varchar2(50) not null,
genre varchar2(30) not null,
estyle varchar2(10) not null,
texture varchar2(30) not null,
taste varchar2(30) not null,
sauce varchar2(30) not null,
spice varchar2(30) not null,
carbo varchar2(30) not null,
meat varchar2(30) not null,
fat varchar2(30) not null,
vegi varchar2(30) not null
);

//제약조건 추가
ALTER TABLE member  DROP primary key;

ALTER TABLE MEMBER ADD CONSTRAINT member_userid_pk PRIMARY KEY(userid);

ALTER TABLE likes ADD CONSTRAINT likes_userid_fk_casdel FOREIGN KEY (userid) 
REFERENCES member(userid) on delete cascade;

commit;

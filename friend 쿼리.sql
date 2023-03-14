-- 2023년 2월 15일
-- spring5에서 작업함

create table friend(
name varchar2(30) NOT NULL,
age number(3) default 0,
phone varchar2(15) UNIQUE,
active VARCHAR2(10) DEFAULT '내성적');

insert into friend VALUES (
'손오공', 24, '010-1111-2222', '외향적'
);

SELECT
    *
FROM friend;

rollback;

-- 2023년 2월 15일
-- spring6에서 작업함

drop table guestbook;
drop SEQUENCE guestbook_seq;

create table guestbook(
seq number PRIMARY key,         -- 일련번호
writer VARCHAR2(30) NOT NULL,   -- 글쓴이
text VARCHAR2(200) NOT null,    -- 방명록 내용
regdate date DEFAULT sysdate    -- 글쓴 날짜
);

create SEQUENCE guestbook_seq;

insert into GUESTBOOK (seq, writer, text)
VALUES (GUESTBOOK_SEQ.NEXTVAL, '기노욱', '안녕!');

SELECT
    *
FROM GUESTBOOK;

commit;

SELECT seq, writer, text, to_char(regdate, 'YYYY/MM/DD hh:mm') as REGDATE
from guestbook
order by seq desc;

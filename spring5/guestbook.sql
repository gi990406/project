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

commit;

SELECT
    *
FROM GUESTBOOK;
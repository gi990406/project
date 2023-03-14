-- 2023년 2월 15일
-- spring5에서 작업함

create table friend(
                       name varchar2(30) NOT NULL,
                       age number(3) default 0,
                       phone varchar2(15) UNIQUE,
                       active VARCHAR2(10) DEFAULT '내성적');

-- 데이터 입력
insert into friend VALUES (
                              '손오공', 24, '010-1111-2222', '외향적'
                          );

SELECT
    *
FROM friend;

rollback;
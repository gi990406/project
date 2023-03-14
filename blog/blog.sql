--** blog를 위한 설계
--2023년 2월 27일

CREATE Table blog_member (
                             blogid varchar2(20) PRIMARY key,         -- 회원 ID
                             blogpwd varchar2(100) NOT NULL,           -- 비밀번호
                             blogername varchar2(20) NOT NUll,        -- 회원 이름
                             photo      number(1) DEFAULT 1,          -- 선택한 프로필 사진 번호 (1~4)
                             enabled NUMBER(1) DEFAULT 1
                                 CHECK (enabled in (0,1)),                -- 계정상태
                             rolename VARCHAR2(20) DEFAULT 'ROLE_USER'
                                 check (rolename in ('ROLE_USER','ROLE_ADMIN'))-- 사용자 구분
);


CREATE TABLE blog_board (
                            blogseq number PRIMARY key,                             -- 회원 ID
                            blogid VARCHAR2(20) REFERENCES blog_member(blogid)      -- blogid 참조
                                on delete cascade,
                            title varchar2(200) not null,                           -- 글 제목
                            blogtext varchar2(2000) not null,                       -- 글 내용
                            regdate date default sysdate,                           -- 작성 날짜
                            likecnt number default 0                                -- 추천 수
);
CREATE SEQUENCE blog_board_seq;

SELECT
    *
FROM BLOG_MEMBER;

drop table blog_board;
drop table blog_member;
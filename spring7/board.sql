--** 회원 전용 게시판 작성을 위한 설계
--2023년 2월 16일

DROP TABLE members;
DROP TABLE board;
DROP TABLE reply;

DROP SEQUENCE board_seq;
DROP SEQUENCE reply_seq;

-- 회원 테이블
CREATE TABLE members (
                         memberid VARCHAR2(20) PRIMARY KEY,                    -- 사용자 식별 아이디
                         memberpwd VARCHAR2(100) not null,                     -- 비밀번호
                         membername VARCHAR2(30) not null,                     -- 사용자 이름
                         email VARCHAR2(50),                                   -- 이메일
                         phone VARCHAR2(50),                                   -- 전화번호
                         address VARCHAR2(200),                                -- 집주소
                         enabled NUMBER(1) DEFAULT 1 CHECK (enabled in (0,1)), -- 계정상태
                         rolename VARCHAR2(20) DEFAULT 'ROLE_USER'
                             check (rolename in ('ROLE_USER','ROLE_ADMIN'))-- 사용자 구분
);

-- 게시판
CREATE TABLE board (
                       boardseq number PRIMARY KEY,                      -- 게시글 번호
                       memberid VARCHAR2(20) not null,                   -- 글쓴이
                       title VARCHAR2(200) default '제목없음' not null,    -- 글제목
                       boardtext VARCHAR2(3000) not null,                 -- 글 내용
                       regdate date DEFAULT sysdate,                     -- 글 등록일
                       hitcount number DEFAULT 0,                        -- 조회수
                       originalfile VARCHAR2(200),                       -- 첨부파일 원래 이름
                       savedfile VARCHAR2(200)                           -- 첨부파일이 서버에 저장될 때의 이름
);

CREATE SEQUENCE board_seq;

-- 댓글
CREATE TABLE reply(
                      replyseq NUMBER PRIMARY key,                    -- 댓글 번호
                      boardseq number REFERENCES board(boardseq)      -- 참조하는 게시판 글
                          on delete cascade,
                      memberid VARCHAR2(20),                          -- 댓글 작성자
                      replytext VARCHAR2(1000) not null,              -- 댓글 내용
                      regdate date DEFAULT sysdate                    -- 댓글 작성일
);

CREATE SEQUENCE reply_seq;
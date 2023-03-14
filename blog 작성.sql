--** blog�� ���� ����
--2023�� 2�� 27��

CREATE Table blog_member (
    blogid varchar2(20) PRIMARY key,         -- ȸ�� ID
    blogpwd varchar2(100) NOT NULL,           -- ��й�ȣ
    blogername varchar2(20) NOT NUll,        -- ȸ�� �̸�
    photo      number(1) DEFAULT 1,          -- ������ ������ ���� ��ȣ (1~4)
    enabled NUMBER(1) DEFAULT 1 
    CHECK (enabled in (0,1)),                -- �������� 
    rolename VARCHAR2(20) DEFAULT 'ROLE_USER' 
        check (rolename in ('ROLE_USER','ROLE_ADMIN'))-- ����� ����
);


CREATE TABLE blog_board (
    blogseq number PRIMARY key,                             -- ȸ�� ID
    blogid VARCHAR2(20) REFERENCES blog_member(blogid)      -- blogid ����
        on delete cascade,              
    title varchar2(200) not null,                           -- �� ����
    blogtext varchar2(2000) not null,                       -- �� ����
    regdate date default sysdate,                           -- �ۼ� ��¥
    likecnt number default 0                                -- ��õ ��
);
CREATE SEQUENCE blog_board_seq;

SELECT
    *
FROM BLOG_MEMBER;

drop table blog_board;
drop table blog_member;
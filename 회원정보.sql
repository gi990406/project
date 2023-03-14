--** ȸ�� ���� �Խ��� �ۼ��� ���� ����
--2023�� 2�� 16��

DROP TABLE members;
DROP TABLE board;
DROP TABLE reply;

DROP SEQUENCE board_seq;
DROP SEQUENCE reply_seq;

-- ȸ�� ���̺�
CREATE TABLE members (
memberid VARCHAR2(20) PRIMARY KEY,                    -- ����� �ĺ� ���̵�
memberpwd VARCHAR2(100) not null,                     -- ��й�ȣ
membername VARCHAR2(30) not null,                     -- ����� �̸�
email VARCHAR2(50),                                   -- �̸���
phone VARCHAR2(50),                                   -- ��ȭ��ȣ
address VARCHAR2(200),                                -- ���ּ�
enabled NUMBER(1) DEFAULT 1 CHECK (enabled in (0,1)), -- �������� 
rolename VARCHAR2(20) DEFAULT 'ROLE_USER' 
        check (rolename in ('ROLE_USER','ROLE_ADMIN'))-- ����� ����
);

-- �Խ���
CREATE TABLE board (
    boardseq number PRIMARY KEY,                      -- �Խñ� ��ȣ
    memberid VARCHAR2(20) not null,                   -- �۾���
    title VARCHAR2(200) default '�������' not null,    -- ������
    boardtext VARCHAR2(3000) not null,                 -- �� ����
    regdate date DEFAULT sysdate,                     -- �� �����
    hitcount number DEFAULT 0,                        -- ��ȸ��
    originalfile VARCHAR2(200),                       -- ÷������ ���� �̸�
    savedfile VARCHAR2(200)                           -- ÷�������� ������ ����� ���� �̸�
);

CREATE SEQUENCE board_seq;

-- ���
CREATE TABLE reply(
    replyseq NUMBER PRIMARY key,                    -- ��� ��ȣ
    boardseq number REFERENCES board(boardseq)      -- �����ϴ� �Խ��� ��
        on delete cascade,
    memberid VARCHAR2(20),                          -- ��� �ۼ���
    replytext VARCHAR2(1000) not null,              -- ��� ����
    regdate date DEFAULT sysdate                    -- ��� �ۼ���
);

CREATE SEQUENCE reply_seq;

SELECT
    *
FROM board;

SELECT * From (
SELECT rownum rnum, b.*
    FROM
(
SELECT
    boardseq, memberid, title, boardtext,
    to_char(regdate, 'YYYY-MM-DD') as regdate, hitcount
FROM board
WHERE
    <if test = "searchItem == 'title'">
        title LIKE '%' || #{searchWord} || '%'
    </if>
    <if test="searchItem == 'memberid'">
        memberid LIKE '%' || #{searchWord} || '%'
    </if>
    <if test="searchItem == 'boardtext'">
        boardtext LIKE '%' || #{searchWord} || '%'
    </if>
ORDER BY boardseq DESC, regdate DESC) b)
where rnum between #{startRecord} and #{endRecord};
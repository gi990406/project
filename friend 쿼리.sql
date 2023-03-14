-- 2023�� 2�� 15��
-- spring5���� �۾���

create table friend(
name varchar2(30) NOT NULL,
age number(3) default 0,
phone varchar2(15) UNIQUE,
active VARCHAR2(10) DEFAULT '������');

insert into friend VALUES (
'�տ���', 24, '010-1111-2222', '������'
);

SELECT
    *
FROM friend;

rollback;

-- 2023�� 2�� 15��
-- spring6���� �۾���

drop table guestbook;
drop SEQUENCE guestbook_seq;

create table guestbook(
seq number PRIMARY key,         -- �Ϸù�ȣ
writer VARCHAR2(30) NOT NULL,   -- �۾���
text VARCHAR2(200) NOT null,    -- ���� ����
regdate date DEFAULT sysdate    -- �۾� ��¥
);

create SEQUENCE guestbook_seq;

insert into GUESTBOOK (seq, writer, text)
VALUES (GUESTBOOK_SEQ.NEXTVAL, '����', '�ȳ�!');

SELECT
    *
FROM GUESTBOOK;

commit;

SELECT seq, writer, text, to_char(regdate, 'YYYY/MM/DD hh:mm') as REGDATE
from guestbook
order by seq desc;

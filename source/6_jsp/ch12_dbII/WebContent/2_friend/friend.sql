DROP TABLE FRIEND;
CREATE TABLE FRIEND (
    NO NUMBER(4),
    NAME VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(20),
    PRIMARY KEY(NO),
    UNIQUE(TEL));
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ MAXVALUE 9999 NOCYCLE NOCACHE;
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿','010-9999-9999');
SELECT * FROM FRIEND;
COMMIT;
-- �����Ͻ� ���� ���� �˻� ��ư �߰���
SELECT * FROM FRIEND WHERE NAME LIKE '%'||'��'||'%' AND TEL LIKE '%'||'8888'||'%';



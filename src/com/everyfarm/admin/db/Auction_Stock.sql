
CREATE TABLE "AUCTION" 
   (	"AUC_NO" NUMBER(15,0) NOT NULL ENABLE, 
	"STOCK_NO" NUMBER(15,0) NOT NULL ENABLE, 
	"AUC_STARTPRICE" NUMBER(20,0), 
	"AUC_NOWPRICE" NUMBER(20,0), 
	"AUC_STATUS" NUMBER(3,0), 
	"AUC_REGDATE" DATE DEFAULT SYSDATE, 
	"AUC_ENDDATE" DATE, 
	"AUC_JOIN" NUMBER(10,0) DEFAULT 0, 
	 CONSTRAINT "AUCTION_PK_AUC_NO" PRIMARY KEY ("AUC_NO")
   );

CREATE TABLE "STOCK" 
   (	"STOCK_NO" NUMBER(15,0) NOT NULL ENABLE, 
	"MEM_ID" VARCHAR2(30) NOT NULL ENABLE, 
	"STOCK_NAME" VARCHAR2(100) NOT NULL ENABLE, 
	"STOCK_DETAIL" VARCHAR2(500) NOT NULL ENABLE, 
	"STOCK_KG" NUMBER(10,0) NOT NULL ENABLE, 
	"STOCK_PRICE" NUMBER(10,0) NOT NULL ENABLE, 
	"STOCK_IMAGE" VARCHAR2(1000) NOT NULL ENABLE, 
	"STOCK_LOCATION" VARCHAR2(30) NOT NULL ENABLE, 
	"STOCK_KIND" NUMBER(5,0) NOT NULL ENABLE, 
	 CONSTRAINT "STOCK_PK_STOCK_NO" PRIMARY KEY ("STOCK_NO")
   );   
SELECT * FROM AUCTION;
SELECT * FROM STOCK;

INSERT INTO AUCTION (AUC_NO,STOCK_NO,AUC_STARTPRICE,AUC_NOWPRICE,AUC_STATUS,AUC_REGDATE,AUC_ENDDATE,AUC_JOIN) VALUES 
(1,1,600,4600,3,TIMESTAMP '2020-01-12 11:38:48.000000',TIMESTAMP '2020-02-01 00:00:00.000000',12)
;

INSERT INTO AUCTION (AUC_NO,STOCK_NO,AUC_STARTPRICE,AUC_NOWPRICE,AUC_STATUS,AUC_REGDATE,AUC_ENDDATE,AUC_JOIN) VALUES 
(2,2,1000,1000,1,TIMESTAMP '2020-02-01 12:00:37.000000',TIMESTAMP '2020-03-01 00:00:00.000000',0)
;

INSERT INTO AUCTION (AUC_NO,STOCK_NO,AUC_STARTPRICE,AUC_NOWPRICE,AUC_STATUS,AUC_REGDATE,AUC_ENDDATE,AUC_JOIN) VALUES 
(3,3,1200,2300,2,TIMESTAMP '2020-02-03 12:00:37.000000',TIMESTAMP '2020-03-05 00:00:00.000000',5)
;



INSERT INTO STOCK (STOCK_NO,MEM_ID,STOCK_NAME,STOCK_DETAIL,STOCK_KG,STOCK_PRICE,STOCK_IMAGE,STOCK_LOCATION,STOCK_KIND) VALUES 
(1,'user','연천시 바나나','바나나./바나나 정말 맛있습니다./귀요미 바나나/여러분께 제공합니다.',50,20000,'resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png','연천시',1)
;
INSERT INTO STOCK (STOCK_NO,MEM_ID,STOCK_NAME,STOCK_DETAIL,STOCK_KG,STOCK_PRICE,STOCK_IMAGE,STOCK_LOCATION,STOCK_KIND) VALUES 
(2,'user2','포천시 사과','맛있습니다.',50,20000,'resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png','연천시',1)
;
INSERT INTO STOCK (STOCK_NO,MEM_ID,STOCK_NAME,STOCK_DETAIL,STOCK_KG,STOCK_PRICE,STOCK_IMAGE,STOCK_LOCATION,STOCK_KIND) VALUES 
(3,'user3','남양주시 배','맛있습니다.',50,20000,'resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png/
					resources\images\productstorage\banana.png','연천시',1)
;	

SELECT ROWNUM AS RNUM, R.*
FROM	(
		SELECT *
		FROM STOCK S INNER JOIN AUCTION A ON S.STOCK_NO = A.STOCK_NO
		WHERE A.AUC_STATUS = 2
		ORDER BY A.AUC_REGDATE DESC
		)R
WHERE ROWNUM BETWEEN 1 AND 3
		
-- 미등록 승인 -> 진행중		
UPDATE AUCTION SET AUC_STATUS=2 WHERE AUC_NO=2
-- 원래대로 되돌리기
UPDATE AUCTION SET AUC_STATUS=1 WHERE AUC_NO=2


-----------------------  품목별 카운팅 -----------------------

SELECT * FROM STOCK
SELECT COUNT(*) FROM STOCK WHERE STOCK_KIND =2

INSERT INTO STOCK (STOCK_NO,MEM_ID,STOCK_NAME,STOCK_DETAIL,STOCK_KG,STOCK_PRICE,STOCK_IMAGE,STOCK_LOCATION,STOCK_KIND) VALUES 
(21,'user','연천시 바나나','바나나./바나나 정말 맛있습니다./귀요미 바나나/여러분께 제공합니다.',50,20000,'resources\images','연천시',6)
;


SELECT COUNT(*)
FROM STOCK S INNER JOIN FUND F ON S.STOCK_NO = F.STOCK_NO
LEFT JOIN AUCTION A ON S.STOCK_NO = A.STOCK_NO
WHERE STOCK_KIND = 1
   
   
----------------------- 진행중인 총액 계산 -----------------------

SELECT * FROM AUCTION

--진행중인 경매 현재가의 총합
SELECT SUM(AUC_NOWPRICE) FROM AUCTION WHERE AUC_STATUS = 2

--진행중인 경매 총 참여인원
SELECT SUM(AUC_JOIN) FROM AUCTION WHERE AUC_STATUS = 2

--진행중인 펀드 현재가의 총합
SELECT SUM(FUND_CURRENTPRICE) FROM FUND WHERE FUND_STATUS = 2

--진행중인 펀드 총 참여인원
SELECT SUM(FUND_JOIN) FROM FUND WHERE FUND_STATUS = 2
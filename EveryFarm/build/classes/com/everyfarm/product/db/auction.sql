DROP TABLE AUCTION;
CREATE SEQUENCE AUCTIONSEQ;
DROP SEQUENCE AUCTIONSEQ;
CREATE TABLE AUCTION(  --경매테이블
	auc_no NUMBER(15) NOT NULL,  --경매번호
	stock_no NUMBER(15) NOT NULL,  --상품번호
	auc_startPrice NUMBER(20),  --경매시작가
	auc_nowPrice NUMBER(20),    --현재경매가(회원이 경매참가한 순간,낙찰시 낙찰가)
	auc_status NUMBER(3),      --경매상태( (1)미등록 /(2)진행중/ (3)낙찰
	auc_regDate DATE DEFAULT SYSDATE,   --경매등록일
	auc_endDate DATE,    --경매 종료일     (남은시간계산 : 종료일-현재시간)
	auc_join NUMBER(10) DEFAULT 0, --경매 참여인원
	CONSTRAINT AUCTION_PK_auc_no PRIMARY KEY(auc_no),
	CONSTRAINT AUCTION_FK_stock_no FOREIGN KEY(stock_no) REFERENCES STOCK(stock_no) 
	
);

DELETE FROM AUCTION;
--더미 데이터 입력--
INSERT INTO AUCTION
VALUES(AUCTIONSEQ.NEXTVAL,17,98000,0,2,sysdate,to_date('2020/02/09 00:00:00','YYYY/MM/DD HH24:MI:SS'),1000);

select * from auction;

--일반경매 상품 select문
SELECT * FROM AUCTION FULL OUTER JOIN STOCK
ON AUCTION.stock_no = STOCK.stock_no;

--best경매 상품 4개 select문
SELECT * FROM
(SELECT * FROM AUCTION FULL OUTER JOIN STOCK
ON AUCTION.stock_no = STOCK.stock_no
ORDER BY auc_join DESC)
WHERE ROWNUM <= 4;
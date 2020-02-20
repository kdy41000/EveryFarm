CREATE TABLE "WEEKENDFARM" 
   (	"WFARM_KEY" NUMBER(10,0) NOT NULL ENABLE, 
	"MEM_ID" VARCHAR2(30) NOT NULL ENABLE, 
	"WFARM_TITLE" VARCHAR2(200), 
	"WFARM_ZONECODE" VARCHAR2(10), 
	"WFARM_ADDR" VARCHAR2(1000), 
	"WFARM_TOTALAREA" NUMBER(5,0), 
	"WFARM_PRICE" NUMBER(20,0), 
	"WFARM_STATUS" VARCHAR2(3), 
	"WFARM_REGDATE" DATE DEFAULT SYSDATE, 
	"WFARM_IMAGE" VARCHAR2(3000), 
	"WFARM_CONTENT" VARCHAR2(3000)
   );
	 CONSTRAINT "WEEKENDFARM_PK_WFARM_KEY" PRIMARY KEY ("WFARM_KEY") 
	 CONSTRAINT "WEEKENDFARM_FK_MEM_ID" FOREIGN KEY ("MEM_ID")
	  REFERENCES "BIGSEMI04"."MEMBER" ("MEM_ID") ENABLE

	  
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES 
(1,'user','주말농장','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:37:43.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(2,'user2','파스퇴르','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:37:55.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(3,'user','파스퇴르','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:38:04.000000','resources\images\farmimage\farm01-03.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(4,'user','에브리팜','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:39:32.000000','resources\images\farmimage\farm02-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(5,'user2','강남팜','01234','서울시 강남구',25,60000,'2',TIMESTAMP '2020-02-13 05:39:54.000000','resources\images\farmimage\farm03-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(6,'user2','팜팜이','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:25:16.000000','resources\images\farmimage\farm03.png/
resources\images\farmimage\farm02-01.png/
resources\images\farmimage\farm02-02.png/
resources\images\farmimage\farm02-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(7,'user2','팜팜이','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:25:20.000000','resources\images\farmimage\farm03.png/
resources\images\farmimage\farm02-01.png/
resources\images\farmimage\farm02-02.png/
resources\images\farmimage\farm02-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(8,'user3','에브리팜','01234','경기도 용인시',25,60000,'2',TIMESTAMP '2020-02-13 05:39:33.000000','resources\images\farmimage\farm02-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(9,'user3','강남팜','01234','서울시 강남구',32,60000,'2',TIMESTAMP '2020-02-14 05:10:54.000000','resources\images\farmimage\farm03-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(10,'user3','에이작스팜','01234','경기도 용인시 동천동 232',25,1000,'2',TIMESTAMP '2020-02-16 06:52:41.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(11,'user','에이작스팜','01234','경기도 용인시 동천동 232',25,1000,'2',TIMESTAMP '2020-02-16 06:52:41.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(12,'user2','에이작스팜','01234','경기도 용인시 동천동 232',25,1000,'2',TIMESTAMP '2020-02-16 06:52:41.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
INSERT INTO WEEKENDFARM (WFARM_KEY,MEM_ID,WFARM_TITLE,WFARM_ZONECODE,WFARM_ADDR,WFARM_TOTALAREA,WFARM_PRICE,WFARM_STATUS,WFARM_REGDATE,WFARM_IMAGE,WFARM_CONTENT) VALUES
(13,'user3','에이작스팜','01234','경기도 용인시 동천동 232',25,1000,'2',TIMESTAMP '2020-02-16 06:52:41.000000','resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-01.png/
resources\images\farmimage\farm01-02.png/
resources\images\farmimage\farm01-03.png','토지좋은 주말농장입니다./우리농장최고/농장01전경/농장02전경');
	    
SELECT * FROM WEEKENDFARM	 
SELECT * FROM MEMBER

SELECT BB.*
FROM	(
		SELECT 	ROWNUM AS RNUM, AA.*	
		FROM	(
				SELECT *
				FROM WEEKENDFARM
				ORDER BY WFARM_REGDATE DESC
				) AA
		) BB		
WHERE BB.RNUM BETWEEN 11 AND 20

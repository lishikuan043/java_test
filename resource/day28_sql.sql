/*
day28作业

一.创建一个数据库,day28

二.创建一个Test表,并使用

三.测试修改表的结构


四.按一下要求,完成以下操作   
1.创建一个学生表 id 主键  name age score  classroom(班级) 
2.给学生表中添加10条数据,逐渐自动增长
3.删除一条数据
4.修改一条数据
5.按照程序将序查询
6.统计所有的总成绩和平均成绩
7.统计不同班级的总成绩和平均成绩
*/

CREATE TABLE test (
  id INT PRIMARY KEY AUTO_INCREMENT,
  uname VARCHAR(10),
  age INT,
  score INT,
  classroom VARCHAR(10)
);

INSERT INTO test (uname,age,score,classroom) VALUES ('赵1',10,60,'3年1班');
INSERT INTO test (uname,age,score,classroom) VALUES ('赵2',12,78,'3年1班');
INSERT INTO test (uname,age,score,classroom) VALUES ('钱1',13,43,'3年1班');
INSERT INTO test (uname,age,score,classroom) VALUES ('钱2',14,88,'3年2班');
INSERT INTO test (uname,age,score,classroom) VALUES ('钱3',16,63,'3年2班');
INSERT INTO test (uname,age,score,classroom) VALUES ('孙1',20,64,'3年3班');
INSERT INTO test (uname,age,score,classroom) VALUES ('孙2',15,78,'3年3班');
INSERT INTO test (uname,age,score,classroom) VALUES ('李1',19,83,'3年4班');
INSERT INTO test (uname,age,score,classroom) VALUES ('李2',23,90,'3年4班');
INSERT INTO test (uname,age,score,classroom) VALUES ('李3',24,82,'3年4班');

UPDATE test SET uname='王1' WHERE uname='李3';

DELETE FROM test WHERE id=10;

SELECT uname AS '姓名', score FROM test
GROUP BY uname ORDER BY score;

SELECT SUM(score) AS sumscore FROM test;

SELECT AVG(score) AS averagescore FROM test;

SELECT classroom, SUM(score) AS sumscore,AVG(score) AS averagescore
FROM test GROUP BY classroom
ORDER BY classroom;







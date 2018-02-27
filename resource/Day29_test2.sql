CREATE TABLE student (
  sid INT(10) PRIMARY KEY AUTO_INCREMENT,
  sname VARCHAR(20),
  nsex VARCHAR(20),
  nscore INT(10)
);

INSERT INTO student(sname,nsex,nscore) VALUES ('李少荣','女','80'),
('邵凯','男','75'),
('周强','男','95'),
('王晓婷','女','55'),
('张秀花','女','68'),
('顾会','女','50'),
('赵大一','男','32');

SELECT COUNT(*) FROM student WHERE nsex='女' AND nscore>80;

INSERT INTO student(sname,nsex,nscore) VALUES ('张闪','男','82');

UPDATE student SET nscore=100 WHERE sname REGEXP '^张' AND nsex='男';

SELECT sname,nsex,nscore FROM student WHERE nsex='女' AND nscore>60;

SELECT AVG(nscore) FROM student WHERE nsex='男';

SELECT AVG(nscore) FROM student WHERE nsex='女';

SELECT AVG(nscore) FROM student;

SELECT * FROM student WHERE nscore>(SELECT AVG(nscore) FROM student) ORDER BY nscore;

DELETE FROM student WHERE sid=8;

`student`
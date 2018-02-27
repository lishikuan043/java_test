USE day29_jdbc;
    	CREATE TABLE userinfo(
    		id INT(10) PRIMARY KEY AUTO_INCREMENT,
    		username VARCHAR(200),
    		PASSWORD VARCHAR(200)
    	);  
 INSERT INTO userinfo(username,PASSWORD) VALUES ('zhao','123'),
 ('qian','456'),
 ('sun','789'),
 ('li','123456789');
 
 SELECT * FROM userinfo;
 
 SELECT * FROM userinfo WHERE username='zhao' AND PASSWORD='1423';
 
 INSERT INTO userinfo(username,PASSWORD) VALUES('wang','78956');
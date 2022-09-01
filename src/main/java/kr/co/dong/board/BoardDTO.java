package kr.co.dong.board;
/*
 *
 * 
 CREATE TABLE `scott`.`board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` varchar(100) NOT NULL,
  `id` varchar(20) NOT NULL,
  `regdate` datetime NOT NULL,
  `readcnt` int NOT NULL,
  `etc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
* 
 */

import lombok.Data;

@Data
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String id;
	private String regdate;
	private int readcnt;
	private String etc;
	private int del;
}




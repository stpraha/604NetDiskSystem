CREATE TABLE `t_file` (
  `fileid` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) NOT NULL,
  `filesize` int(11) NOT NULL,
  `filetime` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `fileowner` varchar(30) NOT NULL DEFAULT 'public',
  `filevisibility` tinyint(4) DEFAULT '0',
  `fileloc` varchar(60) NOT NULL,
  `filestorename` varchar(100) NOT NULL,
  PRIMARY KEY (`fileid`),
  UNIQUE KEY `filestorename_UNIQUE` (`filestorename`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

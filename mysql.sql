DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `bookId` int(11) NOT NULL auto_increment PRIMARY KEY ,
  `barcode` varchar(20) NOT NULL,
  `bookName` varchar(20) NOT NULL,
  `publish` varchar(20) default NULL,
  `bookAuthor` varchar(20) NOT NULL,
  `bookType` int(11) default NULL,
  `bookcount` int(11) NOT NULL,
  `nowcount` int(11) NOT NULL



)

DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `bookTypeId` int(11) NOT NULL auto_increment,
  `bookTypeName` varchar(18) NOT NULL,
  `days` int(11) NOT NULL

)
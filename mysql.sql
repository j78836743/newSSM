DROP TABLE IF EXISTS `t_bicycle`;
CREATE TABLE `t_bicycle` (
  `bicycleId` int(11) NOT NULL auto_increment PRIMARY KEY ,
  `bicyclecode` varchar(20) NOT NULL,
  `bicycleName` varchar(20) NOT NULL,
  `publish` varchar(20) default NULL,

  `bicycleType` int(11) default NULL,
  `bicyclecount` int(11) NOT NULL,
  `nowcount` int(11) NOT NULL



)

DROP TABLE IF EXISTS `t_bicycletype`;
CREATE TABLE `t_bicycletype` (
  `typeId` int(11) NOT NULL auto_increment PRIMARY KEY ,
  `bicycleTypeId` int(11) NOT NULL ,
  `bicycleTypeName` varchar(18) NOT NULL

)

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `orderId`     VARCHAR(36) NOT NULl,
  `bicyclecode` INT(11)     NOT NULL,
  `uName`       VARCHAR(18) NOT NULL,
  `uTel`        VARCHAR(18) NOT NULL,
  `useTime`     VARCHAR(18) NOT NULL,
  `terTime `    VARCHAR(18)
)
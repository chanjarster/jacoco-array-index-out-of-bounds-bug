SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for TB_B_DICTIONARY_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `TB_B_DICTIONARY_TYPE`;
CREATE TABLE `TB_B_DICTIONARY_TYPE`
(
  `ID`             varchar(64) COLLATE utf8_bin  NOT NULL,
  `ADD_ACCOUNT`    varchar(100) COLLATE utf8_bin      DEFAULT NULL,
  `ADD_TIME`       timestamp                     NULL DEFAULT NULL,
  `COMPANY_ID`     varchar(200) COLLATE utf8_bin      DEFAULT NULL,
  `DELETE_ACCOUNT` varchar(100) COLLATE utf8_bin      DEFAULT NULL,
  `DELETE_TIME`    timestamp                     NULL DEFAULT NULL,
  `DELETED`        int(1)                             DEFAULT '0',
  `EDIT_ACCOUNT`   varchar(100) COLLATE utf8_bin      DEFAULT NULL,
  `EDIT_TIME`      timestamp                     NULL DEFAULT NULL,
  `CODE`           varchar(120) COLLATE utf8_bin NOT NULL,
  `ENABLE`         int(1)                             DEFAULT '1',
  `IS_DATA_CENTER` int(1)                             DEFAULT '1',
  `MULTI_LEVEL`    int(1)                             DEFAULT '1',
  `NAME`           varchar(200) COLLATE utf8_bin NOT NULL,
  `SORT`           bigint(20)                         DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UKtbbcrrq6sxlu20h5618hrd51r` (`CODE`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


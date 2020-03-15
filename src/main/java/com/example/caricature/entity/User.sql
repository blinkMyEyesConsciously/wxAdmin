-- auto Generated on 2020-02-08
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id          INT(11) UNIQUE     NOT NULL AUTO_INCREMENT COMMENT 'id',
    login_flag  INT(11)            NOT NULL DEFAULT 0 COMMENT '0可以 ,1不可用',
    `name`      VARCHAR(50) UNIQUE NOT NULL DEFAULT '' COMMENT 'name',
    `password`  VARCHAR(50)        NOT NULL DEFAULT '' COMMENT 'password',
    create_time DATETIME           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    up_time     DATETIME           NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'upTime',
    money       DECIMAL(13, 4)              DEFAULT 0 COMMENT 'money',
    use_day     INT(11)                     DEFAULT 0 COMMENT '剩余使用天数',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'user';

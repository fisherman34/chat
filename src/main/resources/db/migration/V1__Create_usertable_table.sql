create table USERTABLE
(
    ID           INT AUTO_INCREMENT PRIMARY KEY,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    PASSWORD     VARCHAR(100)
);
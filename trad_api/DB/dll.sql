CREATE TABLE USERS (
    USER_ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(50),
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    PHONE VARCHAR(20),
    PASSWORD VARCHAR(256),
    ACCOUNT_VALIDATED BOOLEAN,
    CODE_VALIDATED VARCHAR(256)
);

CREATE TABLE BUDGET (
     BUDGET_ID INT AUTO_INCREMENT PRIMARY KEY,
     USER_ID INT,
     BUDGET_DATE_ID INT ,
     BUDGET_DATE TIMESTAMP,
     BUDGET_DATE_END DATE,
     BUDGET_VALUE INT NOT NULL,
     ACTIVE BOOLEAN DEFAULT TRUE,
     CONSTRAINT FK_USER_BUDGET FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE BUDGET_RECORD(
    RECORD_ID INT AUTO_INCREMENT PRIMARY KEY,
    BUDGET_ID INT,
    RECORD_VALUE INT NOT NULL,
    RECORD_DESCRIPTION VARCHAR(120),
    CONSTRAINT FK_BUDGET FOREIGN KEY (BUDGET_ID) REFERENCES BUDGET(BUDGET_ID)
);

CREATE TABLE BUDGET_CATEGORY(
    CATEGORY_ID INT AUTO_INCREMENT PRIMARY KEY,
    USER_ID INT,
    CATEGORY_NAME VARCHAR(35) NOT NULL,
    CONSTRAINT FK_USER_BUDGET_CATEGORY FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE CATEGORY_BUDGET_RECORD (
    RECORD_ID INT,
    CATEGORY_ID INT,
    ACTIVE BOOLEAN DEFAULT TRUE,
    CONSTRAINT PK_CATEGORY_BUDGET_RECORD PRIMARY KEY (RECORD_ID,CATEGORY_ID),
    CONSTRAINT FK_CATEGORY FOREIGN KEY(CATEGORY_ID) REFERENCES BUDGET_CATEGORY(CATEGORY_ID),
    CONSTRAINT FK_BUDGET_RECORD FOREIGN KEY(RECORD_ID) REFERENCES BUDGET_RECORD(RECORD_ID)
);




$2a$10$ajWZ1nh76udFlFnEIshdKOcuqYFdgtp4gPP7CUYHo8YSfzE.CNBGm

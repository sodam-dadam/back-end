CREATE TABLE tbl_user (
                          user_id        BIGINT AUTO_INCREMENT,
                          id             VARCHAR(255),
                          password     VARCHAR(255),
                          name    VARCHAR(255),
                          birth_date   date,
                          gender    VARCHAR(255),
                          email     VARCHAR(255),
                          phone     VARCHAR(255),
                          PRIMARY KEY(user_id)
);

CREATE TABLE tbl_noticepost (
                          notice_id        BIGINT AUTO_INCREMENT,
                          title             VARCHAR(255),
                          writer     VARCHAR(255),
                          content    VARCHAR(255),
                          notice_date   date,
                          view    BIGINT DEFAULT 0,
                          PRIMARY KEY(notice_id)
);

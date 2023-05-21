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


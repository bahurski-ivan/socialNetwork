CREATE TABLE IF NOT EXISTS ACCOUNTS(
    id IDENTITY PRIMARY KEY,
    user_name VARCHAR(32),
    password_md5 VARCHAR(32),
    creation_date DATETIME
);

CREATE TABLE IF NOT EXISTS ACCESS_TOKENS(
    account_id INT8,
    access_token VARCHAR(128) PRIMARY KEY,
    expiration_date DATETIME
);


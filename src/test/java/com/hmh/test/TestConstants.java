package com.hmh.test;

import org.apache.http.HttpStatus;

public interface TestConstants {
    int SUCCESS = HttpStatus.SC_OK;
    int CREATED = HttpStatus.SC_CREATED;
    int BAD_REQUEST = HttpStatus.SC_BAD_REQUEST;
    int ACCEPTED = HttpStatus.SC_ACCEPTED;
    int CONFLICT = HttpStatus.SC_CONFLICT;
    int GATEWAY_TIMEOUT = HttpStatus.SC_GATEWAY_TIMEOUT;
    int UNSUPPORTED_MEDIA_TYPE = HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE;
    int UNPROCESSABLE_ENTITY = HttpStatus.SC_UNPROCESSABLE_ENTITY;
    int NOT_FOUND = HttpStatus.SC_NOT_FOUND;
    String DEFAULT_USER = "SUPER_ADMIN";

    String USER_DEFAULT = "jaikiran.shekar@gmail.com;;81e94311d1419";
    String USER_AUTHORIZATION_HEADER="Token token=\"890a28370b666501260356216036ba61\"";

}
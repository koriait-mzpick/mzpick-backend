package com.koreait.mzpick_backend.dto.response;

public interface ResponseMessage {
    
    String SUCCESS = "Success.";

    String VALIDATION_FAIL = "Validation failed.";
    String DUPLICATED_USER_ID = "Duplicated user id.";
    String DUPLICATED_TEL_NUMBER = "Duplicated user tel number.";
    String NO_EXIST_USER_ID = "No exist user id.";
    String No_EXIST_COMMENT = "No exist comment";

    String TEL_AUTH_FAIL = "Tel number authentication failed.";
    String SIGN_IN_FAIL = "Sign in failed.";

    String AUTHENTICATION_FAIL = "Authentication fail.";

    String NO_PERMISSION = "No permission.";

    String MESSAGE_SEND_FAIL = "Auth number send failed.";
    String TOKEN_CREATE_FAIL = "Token creation failed.";
    String DATABASE_ERROR = "DBE";
    
    String NO_EXIST_BOARD = "No exist board";
    String NO_KEYWORD_INPUT = "No keyword input";
    String NO_KETWORD_USER_COUNT = "No keyword user count";

}

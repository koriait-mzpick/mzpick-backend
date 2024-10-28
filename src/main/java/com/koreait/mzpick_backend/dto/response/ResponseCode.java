package com.koreait.mzpick_backend.dto.response;

public interface ResponseCode {
    
    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String DUPLICATED_USER_ID = "DI";
    String DUPLICATED_TEL_NUMBER = "DT";
    String NO_EXIST_USER_ID = "NI";
    String NO_EXIST_BOARD = "NB";
    String No_EXIST_COMMENT = "NC";
    String TEL_AUTH_FAIL = "TAF";
    String SIGN_IN_FAIL = "SF";
    String AUTHENTICATION_FAIL = "AF";

    String NO_PERMISSION = "NP";

    String MESSAGE_SEND_FAIL = "TF";
    String TOKEN_CREATE_FAIL = "TCF";
    String DATABASE_ERROR = "DBE";

    String NO_KEYWORD_INPUT = "NK";
    String NO_KETWORD_USER_COUNT = "NKUC";
}

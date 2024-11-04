package com.koreait.mzpick_backend.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class CustomDatetime {
    public static LocalDateTime getLocalDatetime() {
        return LocalDateTime.now().plusHours(9).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime();
    }
}

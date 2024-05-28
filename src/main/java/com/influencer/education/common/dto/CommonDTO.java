package com.influencer.education.common.dto;

import java.time.LocalDateTime;

public class CommonDTO {

    private Object obj;

    private String message;

    private LocalDateTime datetime;

    public Object getObj() {
        return obj;
    }

    public CommonDTO setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public CommonDTO setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
        return this;
    }
}

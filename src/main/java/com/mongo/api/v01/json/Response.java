package com.mongo.api.v01.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    public static final int SUCCESS = 1;
    public static final int WARNING = 0;
    public static final int ERROR = -1;

    private int no;
    private String message;
    private T data;
}



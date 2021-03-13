package com.whole.night.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Result<T> {

    private boolean key;
    private String message;
    private T data;

    public Result(boolean key,String message){
        this(key,message,null);
    }

}

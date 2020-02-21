package com.ananops.provider.model;

import lombok.Data;

/**
 * Created by rongshuai on 2020/2/17 17:23
 */
@Data
public class Chat {

    private String to;
    private String from;
    private String content;

    public Chat(){

    }

    @Override
    public String toString() {
        return "to:" + to + ",from:" + from + ",content:" + content;
    }
}

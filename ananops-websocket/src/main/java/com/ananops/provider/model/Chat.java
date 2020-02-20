package com.ananops.provider.model;

/**
 * Created by rongshuai on 2020/2/17 17:23
 */
public class Chat {

    private String to;
    private String from;
    private String content;

    public Chat(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "to:" + to + ",from:" + from + ",content:" + content;
    }
}

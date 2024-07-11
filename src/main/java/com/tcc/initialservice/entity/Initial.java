package com.tcc.initialservice.entity;

public class Initial {

    private final long id;
    private final String content;

    public Initial(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }
}

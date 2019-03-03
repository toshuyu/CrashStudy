package com.example.finalproject.crashstudy;

public class ExceptionInfo {
    private String name;
    private int type;
    private String desc;

    public ExceptionInfo(String name, int type, String desc) {
        this.name = name;
        this.type = type;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

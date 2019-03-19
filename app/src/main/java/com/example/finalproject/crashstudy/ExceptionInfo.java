package com.example.finalproject.crashstudy;

public class ExceptionInfo {
    private String name;
    private int type;
    private String desc;
    private boolean isMainThread;
    private boolean isCatch;

    public ExceptionInfo(String name, int type, String desc, boolean isMainThread, boolean isCatch) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.isMainThread = isMainThread;
        this.isCatch = isCatch;
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

    public boolean isMainThread() {
        return isMainThread;
    }

    public boolean isCatch() {
        return isCatch;
    }
}

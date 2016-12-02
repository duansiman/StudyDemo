package com.devin.java.beans;

/**
 * Created by devin on 2016/12/2.
 */
public class Idref {

    private String targetName;

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public String toString() {
        return "Idref{" +
                "targetName='" + targetName + '\'' +
                '}';
    }
}

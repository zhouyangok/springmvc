package com.blog.entity;

import java.io.Serializable;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public class Category implements Serializable {

    private Integer cId;

    private String cName;

    private String cDescribe;

    private Integer cNum;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe;
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }
}

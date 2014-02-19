package com.querydslexample.hibernate.usertype;

import java.io.Serializable;

public class InternalAttr implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer attrValue;

    public InternalAttr() {
    }

    public Integer getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(Integer attrValue) {
        this.attrValue = attrValue;
    }

}

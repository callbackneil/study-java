package org.neil.domain;

import java.io.Serializable;

/**
 * @author neil
 * @date 2018/5/16
 */
public class TestDomain implements Serializable {

    private Integer id;
    private String field;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


}

package org.neil.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author neil
 * @date 2018/5/16
 */
public class TestDomain implements Serializable {

    private Integer id;
    private String field;
    private List<String> idList;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

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

    @Override
    public String toString() {
        return "TestDomain{" + "id=" + id + ", field='" + field + '\'' + ", idList=" + idList + '}';
    }
}

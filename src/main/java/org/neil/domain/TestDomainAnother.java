package org.neil.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author neil
 * @date 2018/5/16
 */
public class TestDomainAnother implements Serializable {

    private int          id;
    private String       field;
    private List<String> idList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    @Override
    public String toString() {
        return "TestDomainAnother{" + "id=" + id + ", field='" + field + '\'' + ", idList=" + idList + '}';
    }
}

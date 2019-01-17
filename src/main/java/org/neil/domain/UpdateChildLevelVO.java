package org.neil.domain;

import java.io.Serializable;

/**
 * @author neil
 * @date 2018/8/21
 */
public class UpdateChildLevelVO implements Serializable {
    private Integer id;
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

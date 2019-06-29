package org.neil.domain;

import java.io.Serializable;

/**
 * @author neil
 * @date 2018/7/13
 */
public class PC implements Serializable {

    private static final long serialVersionUID = 8581291945606301387L;
    private Long              pcId;
    private String            pcName;
    private Double            pcPrice;

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Double getPcPrice() {
        return pcPrice;
    }

    public void setPcPrice(Double pcPrice) {
        this.pcPrice = pcPrice;
    }
}

package org.neil.domain;

/**
 * @author neil
 * @date 2018/7/27
 */
public class ActivityGiftProductVO {
    private Integer giftSendCount;
    private Integer giftCount;
    private Integer count;

    public Integer getCount() {
        return count == null ? giftCount/giftSendCount : count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(Integer giftCount) {
        this.giftCount = giftCount;
    }

    public Integer getGiftSendCount() {
        return giftSendCount;
    }

    public void setGiftSendCount(Integer giftSendCount) {
        this.giftSendCount = giftSendCount;
    }
}

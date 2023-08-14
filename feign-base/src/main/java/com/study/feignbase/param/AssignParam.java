package com.study.feignbase.param;

import java.io.Serializable;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/8/14 下午4:08
 * @menu
 */
public class AssignParam implements Serializable {
    private Long clueId;
    private Long owerId;

    /**
     * Gets the value of clueId.
     *
     * @return the value of clueId
     */
    public Long getClueId() {
        return clueId;
    }

    /**
     * Sets the clueId. *
     * <p>You can use getClueId() to get the value of clueId</p>
     * * @param clueId clueId
     */
    public void setClueId(Long clueId) {
        this.clueId = clueId;
    }

    /**
     * Gets the value of owerId.
     *
     * @return the value of owerId
     */
    public Long getOwerId() {
        return owerId;
    }

    /**
     * Sets the owerId. *
     * <p>You can use getOwerId() to get the value of owerId</p>
     * * @param owerId owerId
     */
    public void setOwerId(Long owerId) {
        this.owerId = owerId;
    }
}

package com.nineteen.lostfound.dao.harmony.entity;

/**
 * Created by mengxu on 2018/1/3.
 */

import java.io.Serializable;


public class Address implements Serializable {
    private Integer pkid;

    private String memberid;

    private String receiveraddress;

    private String status;

    private String receiver;

    private String receiverphone;

    private static final long serialVersionUID = 1L;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone;
    }
}

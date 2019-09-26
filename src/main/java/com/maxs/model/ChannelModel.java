package com.maxs.model;

/**渠道表model
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 15:33
 */
public class ChannelModel {
    private int channelID;//渠道ID
    private String channelName;//渠道名称
    private String createTime;//新增时间
    private String updateTime;//修改时间
    private int adminID;//操作员
    private int status;//状态

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
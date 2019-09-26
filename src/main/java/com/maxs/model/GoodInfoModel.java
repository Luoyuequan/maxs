package com.maxs.model;

/**商品详情Model
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 15:45
 */
public class GoodInfoModel {
    private int infoID;//商品详情ID
    private int goodID;//商品ID
    private String brand;//品牌
    private String weight;//重量
    private String origin;//产地
    private String interfacePhone;//手机接口
    private int status;//状态

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getInterfacePhone() {
        return interfacePhone;
    }

    public void setInterfacePhone(String interfacePhone) {
        this.interfacePhone = interfacePhone;
    }
}

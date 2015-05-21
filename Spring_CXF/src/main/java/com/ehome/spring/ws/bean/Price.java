package com.ehome.spring.ws.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-05-21 16:12
 * @desc: 
 */

@XmlRootElement(name = "Price")
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {

    /**菜价ID**/
    private String specials;
    /**菜价名称**/
    private String sname;
    /**当前时间**/
    private Date recorddate;
    /**价格**/
    private Double price;
    /**市场ID**/
    private String farmid;
    /**市场名称**/
    private String fname;
    /**地区ID**/
    private String regionid;
    /**地区名称**/
    private String rname;
    /**菜品的分类ID**/
    private String littlekindid;
    /**菜品分类名称**/
    private String littlekind;

    /*********************************************/
    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFarmid() {
        return farmid;
    }

    public void setFarmid(String farmid) {
        this.farmid = farmid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getLittlekindid() {
        return littlekindid;
    }

    public void setLittlekindid(String littlekindid) {
        this.littlekindid = littlekindid;
    }

    public String getLittlekind() {
        return littlekind;
    }

    public void setLittlekind(String littlekind) {
        this.littlekind = littlekind;
    }
}

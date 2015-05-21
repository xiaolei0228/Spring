package com.ehome.spring.ws.wsservice.impl;

import com.ehome.spring.ws.bean.Price;
import com.ehome.spring.ws.wsservice.HelloWS;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring
 *
 * @author: 郝晓雷
 * @date: 2015-05-21 15:13
 * @desc:
 */

@WebService(endpointInterface = "com.ehome.spring.ws.wsservice.HelloWS")
public class HelloWSImpl implements HelloWS {
    public String sayHi(String text) {
        return "hello:" + text;
    }

    public String getPriceList() {
        Price price = new Price();
        List<Price> priceList = new ArrayList<Price>();
        priceList.add(price);
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<NewDataSet>");
        for (Price pr : priceList) {
            sb.append("<Table>");
            sb.append("    <SPECIALS>").append(pr.getSpecials()).append("</SPECIALS>");
            sb.append("    <SNAME>").append(pr.getSname()).append("</SNAME>");
            sb.append("    <RECORDDATE>").append(pr.getRecorddate()).append("</RECORDDATE>");
            sb.append("    <PRICE>").append(pr.getPrice()).append("</PRICE>");
            sb.append("    <FARMID>").append(pr.getFarmid()).append("</FARMID>");
            sb.append("    <FNAME>").append(pr.getFname()).append("</FNAME>");
            sb.append("    <REGIONID>").append(pr.getRegionid()).append("</REGIONID>");
            sb.append("    <RNAME>").append(pr.getRname()).append("</RNAME>");
            sb.append("    <LITTLEKINDID>").append(pr.getLittlekindid()).append("</LITTLEKINDID>");
            sb.append("    <LITTLEKIND>").append(pr.getLittlekind()).append("</LITTLEKIND>");
            sb.append("</Table>");
        }
        sb.append("</NewDataSet>");

        return sb.toString();
    }


}

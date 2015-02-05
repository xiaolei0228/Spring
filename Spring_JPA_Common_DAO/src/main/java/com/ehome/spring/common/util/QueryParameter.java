package com.ehome.spring.common.util;

/**
 * @author Administrator
 * @date 2015-02-05 23:51 To change this template use File | Settings | File Templates.
 *
 * 数据库查询条件对象包含三个参数，分别为参数名、查询条件表达式、参数值
 */
public class QueryParameter {
    public enum QueryOperateType {
        eq,     // ==
        in,     // in
        gt,     // >
        lt      // <
    }

    public String ParameterName;
    public Object ParameterValue;
    public QueryOperateType ParameterType;

    public QueryParameter() {

    }

    public QueryParameter(String parameterName, QueryOperateType parameterType, Object parameterValue) {
        this.ParameterName = parameterName;
        this.ParameterValue = parameterValue;
        this.ParameterType = parameterType;
    }

    public String getParameterName() {
        return ParameterName;
    }

    public QueryOperateType getParameterType() {
        return ParameterType;
    }

    public Object getParameterValue() {
        return ParameterValue;
    }

    public void setParameterName(String parameterName) {
        ParameterName = parameterName;
    }

    public void setParameterType(QueryOperateType parameterType) {
        this.ParameterType = parameterType;
    }

    public void setParameterValue(Object parameterValue) {
        ParameterValue = parameterValue;
    }
}

<#macro basePath>
    <#if springMacroRequestContext.getContextPath()=="/">
    <#else>${springMacroRequestContext.getContextPath()}
    </#if>
</#macro>
<#global contextPath><@basePath/></#global>
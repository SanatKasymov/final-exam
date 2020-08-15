<#import "/spring.ftl" as spring>
<div>
    <#if hasPrev>
        <a id="loadPrev" href="${prevPageLink!''}">&lt;&lt;&lt;<@spring.message "btn.prevPage" /></a>
    <#else>
        <span id="loadPrev"><@spring.message "btn.prevPage" /></span>
    </#if>

    <#if hasNext>
        <a id="loadNext" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!3}"><@spring.message "btn.nextPage" />&gt;&gt;&gt;</a>
    <#else>
        <span><@spring.message "btn.nextPage" /></span>
    </#if>
</div>
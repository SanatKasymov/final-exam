<#import 'partials/main.ftlh' as main>
<@main.renderWith>
  <div>
      <div>
          <h4>Places</h4>
          <#if places??>
              <#list places as place>
                    <a href="/topic/${place.id}">
                        <div class="flex-dir">
                          <p>${place.name}</p>
                          <p>${place.description}</p>
                          <p>${place.rating}</p>
                        </div>
                    </a>
              </#list>
          <#else>
              <h4>There is no places</h4>
          </#if>
      </div>


  </div>

</@main.renderWith>
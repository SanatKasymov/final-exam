<#import 'partials/main.ftlh' as main>
<@main.renderWith>
  <div>
      <div>
          <h4>Places</h4>
          <div class = "place-cards">
            <#if places??>
                <div class="wrapper">
                  <#list places as place>
                          <div class="place-card">
                              <a href="/places/${place.id}">
                                  <div class="flex-column box-400">
                                      <img class="place-image" src="${place.image}" alt="${place.name}">
                                      <p>${place.name}</p>
                                  </div>
                              </a>
                        </div>
                  </#list>
                </div>
            <#else>
                <h4>There is no places</h4>
            </#if>
          </div>
      </div>
  </div>
    <#include "partials/pagination.ftlh">


</@main.renderWith>
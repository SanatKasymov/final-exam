<#import 'partials/main.ftlh' as main>
<@main.renderWith>
  <div>
      <div>
          <h4>Places</h4>
          <div class = "place-cards">
            <#if places??>
                  <#list places as place>
                      <div class="flex flex-column box flex-v-center">
                          <a href="/places/${place.id}">
                              <div class="flex-column box-400">
                                  <img class="artwork-image" src="${place.image}" alt="${place.name}">
                                  <p>${place.name}</p>
                              </div>
                          </a>
                      </div>
                  </#list>
            <#else>
                <h4>There is no places</h4>
            </#if>
          </div>
          <#include "partials/pagination.ftlh">
      </div>
  </div>

</@main.renderWith>
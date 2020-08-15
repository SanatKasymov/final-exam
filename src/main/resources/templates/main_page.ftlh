<#import 'partials/main.ftlh' as main>
<@main.renderWith>
  <div>
      <div>
          <h4>Places</h4>
          <div class="card-deck">
            <#if places??>
              <#list places as place>
              <div class="card">
                  <img class="card-img-top" src="${place.image}" alt="${place.name}">
                  <div class="card-body">
                      <h5 class="card-title">${place.name}</h5>
                      <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                  </div>
              </div>
              </#list>
            <#else>
                <h4>There is no places</h4>
            </#if>
          </div>
      </div>
  </div>

</@main.renderWith>
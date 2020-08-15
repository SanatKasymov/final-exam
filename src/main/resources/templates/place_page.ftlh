<#import 'partials/main.ftlh' as main>
<@main.renderWith scripts=["/js/script.js"]>
    <h3>${place.name}</h3>
    <img class="place-image" src="${place.image}" alt="${place.name}">
    <p>${place.description}</p>
    <p>${place.rating}</p>

</@main.renderWith>
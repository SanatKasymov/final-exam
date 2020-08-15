<#macro renderWith title="Rating" scripts=["/js/script.js"] styles=["/css/main.css"]>
    <!doctype html>
    <html lang=en>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>
        <link rel="stylesheet" href="/css/main.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous"/>
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <header>
          <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/">Главная</a>
            <ul id="ulist" class="navbar-nav nav ">
                        <#if authorized??>
                        <ul class="nav ">
                            <li class="nav-item">
                                <form class="flex box-128" action="/logout" method="post">
                                    <#if _csrf??>
                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                                    </#if>
                                    <button class="btn btn-outline-light">Выйти</button>
                                </form>
                            </li>
                        </ul>
                        <ul class="nav ">
                            <li class="nav-item">
                                <a class="nav-link" href="/create_new_place">Добавить место</a>
                            </li>
                        </ul>
                            <#else>
                                <li class="nav-item">
                                    <a class="nav-link" href="/register">Регистрация</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/login">Войти</a>
                                </li>
                        </#if>
                          <div class="collapse navbar-collapse justify-content-end">
                <ul class="nav">
                        <li class="nav-item mr-2 form-inline">
                            <input type="search" id="search-input" class="form-control " placeholder="Поиск"/>
                            <button class="btn btn-outline-light ml-1" id="btn-search" onclick="search()">Поиск</button>
                        </li>
                        <li class="nav-item">
                            <form class="flex box-128" action="/logout" method="post">
                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                           value="${(_csrf.token)!'--no-token--'}"/>
                                </#if>
                            </form>
                        </li>
                </ul>
            </div>
            </ul>
        </div>
    </nav>

    </header>
    <body>
    <div class="container">
        <#nested>
        <#list scripts as scriptSource>
            <script src="${scriptSource}"></script>
        </#list>
    </div>
    </body>
    </html>

</#macro>
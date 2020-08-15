<#macro renderWith title="Rating" scripts=[] styles=[]>
    <!doctype html>
    <html lang=en>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>
        <link rel="stylesheet" href="/css/main.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
        <h1>Welcome to the forum!</h1>
    </head>
    <header>
        
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
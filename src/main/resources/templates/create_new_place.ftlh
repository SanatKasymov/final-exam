<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Добавить новое заведение!</h2>
    <div>
        <form id="form" name="form" enctype="multipart/form-data" action="/create_new_place" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Название заведения:</p>
                    <input type="text" name="place_name" placeholder="Название">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Описание:</p>
                    <input type="text" name="place_description" placeholder="Описание">
                </label>
            </div>
            <div class = "add-post-image">
                <input type="file" name="place_image" id="image">
            </div>
            <div>
                <button type="submit">Добавить заведение!</button>
            </div>
            <div>
                <#if errors?? >
                    <p>Errors in data!</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
            </div>
        </form>
    </div>
</@main.renderWith>
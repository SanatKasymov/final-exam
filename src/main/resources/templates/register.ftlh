<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Регистрация</h2>
    <div>
        <form action="/register" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <div>
                <label class="flex-v-center">
                    <p class="label-input-text">Имя:</p>
                    <input type="text" name="name" placeholder="Elon"  value="${(dto.name)!''}">
                </label>
            </div>
            <div>
                <label class="flex-v-center">
                    <p class="label-input-text">Email:</p>
                    <input type="text" name="email" placeholder="elon@gmail.com"  value="${(dto.email)!''}" >
                </label>
            </div>
            <div>
                <label class="flex-v-center">
                    <p class="label-input-text">Логин:</p>
                    <input type="text" name="login" placeholder="Musk123"  value="${(dto.login)!''}" >
                </label>
            </div>
            <div>
                <label class="flex-v-center">
                    <p class="label-input-text">Пароль:</p>
                    <input type="text" name="password" placeholder="password"  value="">
                </label>
            </div>
            <div>
                <button type="submit">Зарегистрироваться</button>
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
<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Авторизация</h2>
    <form action="/login" method="post">

        <div>
            <#if error!false >
                <p style="color:red">Неверное имя или пароль!</p>
            </#if>
        </div>
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center ">
                <span class="label-input-text">Email:</span>
                <input type="text" name="username" placeholder="email"  value="${(dto.email)!''}" autofocus >
            </label>
        </div>
        <div>
            <label class="flex flex-v-center label-input-text">
                <span class="label-input-text">Пароль:</span>
                <input type="text" name="password" placeholder="пароль" value="">
            </label>
        </div>
        <div class="login-btn">
            <button type="submit">Войти</button>
        </div>
    </form>
</@main.renderWith>

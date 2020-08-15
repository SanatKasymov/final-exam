<#import 'partials/main.ftlh' as main>
<@main.renderWith scripts=["/js/script.js"]>
    <h3>${place.name}</h3>
    <div class="place-body" id="place-body">
        <img class="place-image" src="${place.image}" alt="${place.name}">
        <p>${place.description}</p>
        <p>${place.rating}</p>
        <#if authorized??>
            <button type="button" onclick = "showModalWin()" class="add-post-button ml-auto text-uppercase" data-toggle="modal" data-target="#modal_window">Оставить отзыв</button>
        <#else>
            <p>Чтобы оставить отзыв Вам нужно авторизоваться</p>
        </#if>
        <#if comments??>
            <#list comments as comment>
                <div class="flex-dir">
                    <p>${comment.login}</p>
                    <p>${comment.content}</p>
                    <p>${comment.date}</p>
                    <p>${comment.time}</p>
                </div>
            </#list>
        <#else>
            <h4>There is no messages yet</h4>
        </#if>
        <div class="modal-dialog" id="modal_window" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ваш Отзыв</h5>
                </div>
                <div class="modal-body">
                    <form id="comment-form" class="commentForm" name="comment-form" enctype="form-data" action="/createComment" method="post">
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <input type="hidden" name="place_id" value="${place.id}"/>
                        <textarea type="text"  name="message_content" placeholder="Что вы думаете об этом заведении?" name="text" id="text"></textarea>
                        <div class = "add-message">
                            <button type="button" id="add-message">Отправить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</@main.renderWith>
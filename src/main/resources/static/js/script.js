'use strict';

function showModalWin() {

    var darkLayer = document.createElement('div');
    darkLayer.id = 'shadow';
    document.body.appendChild(darkLayer);

    var modalWin = document.getElementById('modal_window');
    modalWin.hidden = false;
    modalWin.style.display = 'block';

    darkLayer.onclick = function () {
        darkLayer.parentNode.removeChild(darkLayer);
        modalWin.style.display = 'none';
        return false;
    };
}

const saveButton = document.getElementById("add-message");
saveButton.addEventListener("click", function() {
    const messageForm = document.getElementById("comment-form");
    let data = new FormData(messageForm);
    let place_id = data.get("place_id");

    fetch("http://localhost:8080/createMessage", {
        method: 'POST',
        body: data
    }).then(r => r.json()).then(data => {window.location.href = "http://localhost:8080/place/"+place_id});
});
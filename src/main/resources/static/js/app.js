function updateScenes(data) {
    var scenes = JSON.parse(data.body);
    document.getElementById("scenes").innerHTML = String.raw`
<table class="mdl-cell mdl-cell--12-col mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric">Name</th>
        </tr>
    </thead>
    <tbody>
        ${scenes.map(scene => String.raw`
            <tr>
                <td class="mdl-data-table__cell--non-numeric">${scene.name}</td>
            </tr>
        `).join("")}
    </tbody>
</table>
`;
}

var socket = new WebSocket('ws://localhost:8080/obs-controller/websocket');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/scenes', updateScenes);
    stompClient.subscribe('/topic/obs', function(data) {
        console.log(data);
    });
});

window.addEventListener("DOMContentLoaded", function () {
    document.getElementById("enable").onclick = function () {
        stompClient.send("/queue/obs", {}, JSON.stringify({
            "request-type": "GetVersion",
            "message-id": new Date().getTime()
        }));
    };
    document.getElementById("disable").onclick = function () {
        stompClient.send("/queue/obs", {});
    };
}, false);


var stompClient = null;

function connect() {
    var socket = new SockJS('/wsendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/responses', function (data) {
            showData(data);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
}

function showData(content) {
    var contentBody = "" + content + "";
    var index = contentBody.indexOf("\"content\"");
    contentBody = contentBody.substring(index + 11, contentBody.length - 2);
    contentBody = contentBody.replaceAll("%20", " ");
    console.log(contentBody);

    var body = contentBody.toString().split("&");
    var obj = {};
    var keyArr = [];
    var dataArr = [];
    for (var key in body) {
        obj[body[key].split("=")[0]] = body[key].split("=")[1];
        keyArr.push(body[key].split("=")[0]);
        dataArr.push(body[key].split("=")[1]);
    }
    console.log(obj);
    console.log(keyArr);
    console.log(dataArr);

    var table = $('#responsesTable');
    var headRow = $('#responseHeadRow');

    var row = $('<tr></tr>');
    table.append(row);
    for (var i = 0; i < keyArr.length; i++) {
        var headRowData = $('<td></td>').text(keyArr[i]);
        var rowData = $('<td></td>').text(dataArr[i]);
        headRow.append(headRowData);
        row.append(rowData);
    }

}

String.prototype.replaceAll = function (search, replacement) {
    var target = this;
    return target.replace(new RegExp(search, 'g'), replacement);
};
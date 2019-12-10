$.getJSON(
    "http://localhost:8080/fields/getAllJson",
    function (data) {
        $.each(data, function (index, value) {
            //console.log(value);

            if (value.active !== false) {
                switch (value.type) {
                    case "SINGLE_LINE_TEXT" :
                        createSingleLineField(index, value);
                        break;
                    case "MULTILINE_TEXT" :
                        createMultiLineField(index, value);
                        break;
                    case "RADIO_BUTTON" :
                        createRadioButtonField(index, value);
                        break;
                    case "CHECKBOX" :
                        createCheckboxField(index, value);
                        break;
                    case "COMBOBOX" :
                        createComboboxField(index, value);
                        break;
                    case "DATE" :
                        createDateField(index, value);
                        break;
                }
            }
        })
    }
)
    .done(function () {
        console.log("success");
    })
    .fail(function () {
        console.log("error");
    })
    .always(function () {
        console.log("complete");
    });

function createSingleLineField(index, value) {

    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var div = document.createElement("div");
    div.setAttribute("class", "form-group");
    container.appendChild(div);

    var label = document.createElement("label");
    label.setAttribute("for", id);
    label.append(value.label);
    div.appendChild(label);

    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("class", "form-control");
    input.setAttribute("placeholder", value.label);
    if (value.required !== false)
        input.setAttribute("required", "true");
    input.setAttribute("id", id);
    input.setAttribute("name", name);
    div.appendChild(input);
}

function createMultiLineField(index, value) {
    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var div = document.createElement("div");
    div.setAttribute("class", "form-group");
    container.appendChild(div);

    var label = document.createElement("label");
    label.setAttribute("for", id);
    label.append(value.label);
    div.appendChild(label);

    var textarea = document.createElement("textarea");
    textarea.setAttribute("class", "form-control");
    textarea.setAttribute("rows", value.options);
    if (value.required !== false)
        textarea.setAttribute("required", "true");
    textarea.setAttribute("id", id);
    textarea.setAttribute("name", name);
    div.appendChild(textarea);
}

function createRadioButtonField(index, value) {
    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var options = value.options.split("\r\n");

    options.forEach(function (item, index, array) {
        var div = document.createElement("div");
        div.setAttribute("class", "custom-control custom-radio");
        container.appendChild(div);

        var input = document.createElement("input");
        input.setAttribute("type", "radio");
        input.setAttribute("class", "custom-control-input");
        input.setAttribute("value", item.toLowerCase());
        if (value.required !== false)
            input.setAttribute("required", "true");
        input.setAttribute("id", id + index);
        input.setAttribute("name", name);
        div.appendChild(input);

        var label = document.createElement("label");
        label.setAttribute("class", "custom-control-label");
        label.setAttribute("for", id + index);
        label.append(item);
        div.appendChild(label);

    });

    $(document.getElementById(id.concat("0"))).prop("checked", true);
}

function createComboboxField(index, value) {
    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var select = document.createElement("select");
    select.setAttribute("class", "custom-select");
    if (value.required !== false)
        select.setAttribute("required", "true");
    select.setAttribute("name", name);
    select.setAttribute("id", id);
    container.appendChild(select);

    var nameOption = document.createElement("option");
    nameOption.setAttribute("selected", "true");
    nameOption.append(value.label);
    select.appendChild(nameOption);

    var options = value.options.split("\r\n");

    options.forEach(function (item, index, array) {
        var option = document.createElement("option");
        option.setAttribute("value", item.toLowerCase());
        option.append(item);
        select.appendChild(option);
    });
}

function createCheckboxField(index, value) {

    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var div = document.createElement("div");
    div.setAttribute("class", "custom-control custom-checkbox");
    container.appendChild(div);

    var input = document.createElement("input");
    input.setAttribute("type", "checkbox");
    input.setAttribute("class", "custom-control-input");
    if (value.required !== false)
        input.setAttribute("required", "true");
    input.setAttribute("id", id);
    input.setAttribute("name", name);
    div.appendChild(input);

    var label = document.createElement("label");
    label.setAttribute("for", id);
    label.setAttribute("class", "custom-control-label");
    label.append(value.label);
    div.appendChild(label);

    $(document.getElementById(id)).prop("checked", true);
}

function createDateField(index, value) {
    var name = value.label.trim();
    var id = name.concat("-" + index.toString());

    var container = document.getElementById("dynamic-fields-container");

    var divGroup = document.createElement("div");
    divGroup.setAttribute("class", "form-group");
    container.appendChild(divGroup);

    var label = document.createElement("label");
    label.setAttribute("for", id);
    label.append(value.label);
    divGroup.appendChild(label);

    var div = document.createElement("div");
    div.setAttribute("class", "input-group date datepicker");
    divGroup.appendChild(div);

    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("class", "form-control");
    if (value.required !== false)
        input.setAttribute("required", "true");
    input.setAttribute("id", id);
    div.appendChild(input);

    var divAppend = document.createElement("div");
    divAppend.setAttribute("class", "input-group-append");
    div.appendChild(divAppend);

    var span = document.createElement("span");
    span.setAttribute("class", "input-group-text");
    divAppend.appendChild(span);

    var icon = document.createElement("i");
    icon.setAttribute("class", "material-icons");
    icon.append("date_range");
    span.appendChild(icon);

    $(function () {
        $(document.getElementById(id)).datetimepicker({
            format: 'LL'
        });
    });
}

function sendData() {
    var data = $('form').serialize();

    stompClient.send("/app/response", {}, JSON.stringify({'content': data}));
}

$(function () {

    $("#submitButton").click(function (event) {
        event.preventDefault();
        sendData();
    });
});
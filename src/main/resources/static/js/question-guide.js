let typeValues = [];
typeValues.push({
    name: '请选择隐患排查大项',
    value: '',
    selected: true
});

let itemValues = [];
itemValues.push({
    name: '请选择隐患排查小项',
    value: '',
    selected: true
});

let checkItemId = 0;

function load() {
    $('#progress').progress('increment');
    $('#guide').dropdown({
        onChange: function (value) {
            let checkId = value.split('.')[0];
            $.ajax({
                url: "/hiddenDangerCheck/getHiddenDangerCheckType",
                type: "GET",
                data: {checkId: checkId},
                success: function (data) {
                    typeValues = [];
                    typeValues.push({
                        name: '请选择隐患排查大项',
                        value: '',
                        selected: true
                    });
                    for (let i = 0;i < data.length; i++) {
                        typeValues.push({
                            name: data[i].checkTypeName,
                            value: data[i].id
                        });
                    }
                    $('#type').dropdown('change values', typeValues);
                }
            });
        }
    });

    $('#type').dropdown({
        values: typeValues,
        onChange: function (value) {
            $.ajax({
                url: "/hiddenDangerCheck/getHiddenDangerCheckItem",
                type: "GET",
                data: {checkTypeId: value},
                success: function (data) {
                    itemValues = [];
                    itemValues.push({
                        name: '请选择隐患排查小项',
                        value: '',
                        selected: true
                    });
                    for (let i = 0;i < data.length; i++) {
                        itemValues.push({
                            name: data[i].checkItemName,
                            value: data[i].id
                        });
                    }
                    $('#item').dropdown('change values', itemValues);
                }
            });
        }
    });

    $('#item').dropdown({
        values: itemValues,
        onChange: function (value) {
            $('#itemId').val(value);
        }
    });
}

window.onload = function () {
    load();
}




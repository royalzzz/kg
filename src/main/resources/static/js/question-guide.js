let categoryContent = [
    {category: 'South America', title: 'Brazil'},
    {category: 'South America', title: 'Peru'},
    {category: 'North America', title: 'Canada'},
    {category: 'Asia', title: 'South Korea'},
    {category: 'Asia', title: 'Japan'},
    {category: 'Asia', title: 'China'},
    {category: 'Europe', title: 'Denmark'},
    {category: 'Europe', title: 'England'},
    {category: 'Europe', title: 'France'},
    {category: 'Europe', title: 'Germany'},
    {category: 'Africa', title: 'Ethiopia'},
    {category: 'Africa', title: 'Nigeria'},
    {category: 'Africa', title: 'Zimbabwe'},
];

function load() {
    // $('#progress').progress({percent: 1});
    $('#progress').progress('increment');
    $('#selector1').dropdown({
        onChange: function(value, text, $selectedItem) {
            $('#input1').val(value);
        },
        values: [
            {
                name: '选择专业隐患排查',
                value: '',
                selected: true
            },
            {
                name: 'Male',
                value: 'male'
            },
            {
                name: 'Female',
                value: 'female'
            }
        ]
    });
    $('#selector2').dropdown({
        values: [
            {
                name: 'Male',
                value: 'male'
            },
            {
                name: 'Female',
                value: 'female',
                selected: true
            }
        ]
    });
    $('#selector3').dropdown({
        values: [
            {
                name: '发就是打开房间阿克苏将大幅拉升剪短发阿三开的就发了开始剪短发阿克苏将大幅拉开始剪短发水淀粉阿克苏的就发了开始地方阿克苏的就发拉开始剪短发阿斯顿快放假啦思考的就发阿三开的就发了开始的就发拉开',
                value: 'male'
            },
            {
                name: '发就是打开房间阿克苏将大幅拉升剪短发阿三开的就发了开始剪短发阿克苏将大幅拉开始剪短发水淀粉阿克苏的就发了开始地方阿克苏的就发拉开始剪短发阿斯顿快放假啦思考的就发阿三开的就发了开始的就发拉开',
                value: 'male1'
            },
            {
                name: '发就是打开房间阿克苏将大幅拉升剪短发阿三开的就发了开始剪短发阿克苏将大幅拉开始剪短发水淀粉阿克苏的就发了开始地方阿克苏的就发拉开始剪短发阿斯顿快放假啦思考的就发阿三开的就发了开始的就发拉开',
                value: 'male2'
            },
            {
                name: '发就是打开房间阿克苏将大幅拉升剪短发阿三开的就发了开始剪短发阿克苏将大幅拉开始剪短发水淀粉阿克苏的就发了开始地方阿克苏的就发拉开始剪短发阿斯顿快放假啦思考的就发阿三开的就发了开始的就发拉开',
                value: 'male3'
            },
            {
                name: '发就是打开房间阿克苏将大幅拉升剪短发阿三开的就发了开始剪短发阿克苏将大幅拉开始剪短发水淀粉阿克苏的就发了开始地方阿克苏的就发拉开始剪短发阿斯顿快放假啦思考的就发阿三开的就发了开始的就发拉开',
                value: 'male4'
            },
            {
                name: '阿斯顿发就阿莱克斯的肌肤阿克苏将大幅拉就是短发了阿快结束的浪费；就阿斯顿了；否阿三开将大幅拉升空间短发阿三开的就发了；思考大家风范卡洛斯剪短发啦',
                value: 'female',
                selected: true
            }
        ]
    });
    $('#search').search({
        type: 'category',
        source: categoryContent
    });
}

window.onload = function () {
    load();
}




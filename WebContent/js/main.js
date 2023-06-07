function execute() {
    $.ajax({
        type: 'post',
        async: true,
        url: 'http://localhost:8080/JSON_Test/showlist',
        dataType: 'text',
        data: {},
        success: function (data, textStatus) {
            alert(data);
            let info = JSON.parse(data);
            let output = '<h2>회원 정보</h2><hr />';
            for (let i in info.members) {
                output += '<p>' + 'ID: ' + info.members[i].id + '</p>';
                output += '<p>' + 'Password: ' + info.members[i].pw + '</p>';
                output += '<p>' + '이름: ' + info.members[i].name + '</p>';
                output += '<p>' + '나이: ' + info.members[i].age + '</p>';
            }
            $('#showlist').html(output);
        },
        error: function (data, textStatus) {
            alert('Error!');
        },
        complete: function (data, textStatus) {
            alert('Complete!');
        },
    });
}

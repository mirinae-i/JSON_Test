function execute() {
    $.ajax({
        type: 'post',
        async: true,
        url: 'http://localhost:8080/JSON_Test/showlist',
        dataType: 'text',
        data: {},
        success: function (data, textStatus) {
            // alert(data);
            let info = JSON.parse(data);
            let output = '<table><tr>' + '<td>ID</td><td>Password</td><td>이름</td><td>나이</td>' + '</tr>';
            for (let i in info.members) {
                output += '<tr><td>' + info.members[i].id + '</td>';
                output += '<td>' + info.members[i].pw + '</td>';
                output += '<td>' + info.members[i].name + '</td>';
                output += '<td>' + info.members[i].age + '</td></tr>';
            }
            output += '</table>';
            $('#showlist').html(output);
        },
        error: function (data, textStatus) {
            alert('Error!');
        },
        complete: function (data, textStatus) {
            // alert('Complete!');
        },
    });
}

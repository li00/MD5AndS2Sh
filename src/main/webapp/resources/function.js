$(function () {
$('input[name=name]').blur(function () {
        var n =  $('input[name=name]').val();
        var name =n.trim();
        if(name!= null && name !="") {
                $.ajax({
                        type: "post",
                        url: "/getUser",
                        data: {name: name},
                        dataType: 'json',
                        success: function (data) {
                                if (data == name) {
                                        $("#name").html("该用户已被注册！");
                                }
                        }
                });
        }
});
});

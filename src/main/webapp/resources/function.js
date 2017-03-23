$(function () {
        $('input[name=name]').blur(function () {
                var n =  $('input[name=name]').val();
                var name =n.trim();
                if(name!= null && name !="") {
                        $.ajax({
                                type: "post",
                                url: "/user/getUser",
                                data: {name: name},
                                dataType: 'json',
                                success: function (data) {
                                        alert(data);
                                        if(data==name) {
                                                $("#name").html("该用户已被注册！");
                                        }
                                },
                                error:function () {
                                        $("#name").html("😇");
                                }
                        });
                }
        });
        $("#validate").click(function () {
                $("#validate").attr('src', '/user/validate?' + Math.floor(Math.random()*100) );
        });
});

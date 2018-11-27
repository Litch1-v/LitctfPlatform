$().ready(function() {
    $("#loginForm").validate({
        errorPlacement : function(error, element) {
            $( element )
                .parent()
                .after( error );
        },
        rules : {
            username : {
                required : true,
                rangelength:[2,10]
            },
            password : {
                required : true,
                rangelength:[6,12]
            },
        },
        messages : {
            username : {
                required : '请输入姓名',
                rangelength:'长度在 {0} 到 {1} 之间'
            },
            password : {
                required : '请输入密码',
                minlength:'长度在 {0} 到 {1} 之间'
            },
        }
    });
});
$().ready(function() {
    $("#registerForm").validate({
        errorPlacement : function(error, element) {
            $( element )
                .parent()
                .after( error );
        },
        rules : {
            username : {
                required : true,
                rangelength:[2,10]
            },
            password : {
                required : true,
                rangelength:[6,12]
            },
            confirmpassword : {
                required : true,
                equalTo:"#password"
            },
            email : {
                required : true,
                email : true
            },
            classNumber : {
                required : true
            }
        },
        messages : {
            username : {
                required : '请输入姓名',
                rangelength:'长度在 {0} 到 {1} 之间'
            },
            password : {
                required : '请输入密码',
                minlength:'长度在 {0} 到 {1} 之间'
            },
            confirmpassword : {
                required : '请再次输入密码',
                equalTo:'两次输入的密码不一致'
            },
            email : {
                required :'请输入邮箱',
                email : '请输入有效的电子邮件地址'
            },
            classNumber : {
                required :'请输入班级'
            }
        }
    });
});

var n = false; //验证手机号
var f = false; //验证验证码
var p1 = false; //验证密码
var p2 = false; //验证确认密码

$(document).ready(function() {
	var phone = /^1[34578]\d{9}$/; //手机号正则表达式
	var pwd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,8}$/; //密码正则表达式
	//失去焦点事件
	$("#mobilPhone").blur(function() {
		var MobilPhone = $(this).val();
		if (MobilPhone != null && MobilPhone != "") {
			if (phone.test(MobilPhone)) {
				invalid($(this), true);
				$("#span1").html("");
				n = true;
			} else {
				invalid($(this), false);
				$("#span1").html("手机号输入错误，请重新输入");
				n = false;
			}
		} else {
			invalid($(this), false);
			$("#span1").html("手机号不能为空");
			n = false;
		}
	});

	$("#pas").blur(function() {
		var pas = $(this).val();
		if (pas == null || pas == "") {
			invalid($(this), false);
			$("#span2").html("请输入验证码");
			f = false;
		} else {
			invalid($(this), true);
			$("#span2").html("");
			f = true;
		}
	});

	$("#password").blur(function() {
		var password = $(this).val();
		if (password == null || password == "") {
			invalid($(this), false);
			$("#span1").html("密码不能为空");
			p1 = false;
		} else {
			if (pwd.test(password)) {
				invalid($(this), true);
				$("#span1").html("");
				p1 = true;
			} else {
				invalid($(this), false);
				$("#span1").html("请输入由数字和字母组成的6-8位密码");
				p1 = false;
			}
		}
	});
	$("#password2").blur(function() {
		var password2 = $(this).val();
		var password = $("#password").val();
		if (password2 != null && password2 != "") {
			if (password2 !== password) {
				invalid($(this), false);
				$("#span2").html("两次密码不相同");
				p2 = false;
			} else {
				invalid($(this), true);
				$("#span2").html("");
				p2 = true;
			}
		} else {
			invalid($(this), false);
			$("#span2").html("请进行密码确认！");
			p2 = false;
		}
	});

	//获取验证码按钮单击事件
	$("#button02").click(function() {
		var MobilPhone=$("#mobilPhone").val();
		if (n == true) {
			invalid($("#mobilPhone"),false);
			$.ajax({
				url:"/code?phone="+MobilPhone+"&reader="+1,
				methods:"get",
				success:function (e) {
					alert(e);
					if("000000"==e){
						$("#span1").html("该用户不存在");
					}else{
						timer(60);
					}
				},
				error:function () {
					alert("获取验证失败");
				}
			});

		} else {
			invalid($("#mobilPhone"), false);
			$("#span1").html("手机号不能为空");
			n = false;
		}
	});


	//判断是否通过验证码
	var phonea = $("#phone").html();
	if (phonea == null || phonea == "") {
		$("#form").show();
		$("#form2").hide();
	} else {
		$("#form").hide();
		$("#form2").show();
	}

});

//获取验证码按钮倒计时函数
function timer(time) {
	var btn = $("#button02");
	btn.attr("disabled", true); //按钮禁止点击
	var hander = setInterval(function() {
		if (time <= 0) {
			clearInterval(hander); //清除倒计时
			btn.html("获取验证码");
			btn.attr("disabled", false);
			return false;
		} else {
			btn.html("" + (time--) + "s");
		}
	}, 1000);


}
//点击确认时的数据验证函数
function onForm() {
	if (n == true && f == true) {
		invalid($(this), true);
		$("#span1").html("");
		return true;
	} else {
		if (n == false) {
			invalid($(this), false);
			$("#span1").html("手机号不能为空");
		}
		if (f == false) {
			invalid($(this), false);
			$("#span2").html("请输入验证码");
		}
		return false;
	}
};



function onForm2() {
	if (p1 == true && p2 == true) {
		return true;
	} else {
		if (p1 == false) {
			invalid($("#password"), false);
			$("#span1").html("密码不能为空");
		}
		if (p2 == false) {
			invalid($("#password2"), false);
			$("#span2").html("请进行密码确认！");
		}
	}
	return false;
}

	// is-invalid 表示填写错误
	// is-valid 表示填写正确
	
function invalid(id, r) {
	if (r == false) {
		$(id).removeClass("is-valid")
		$(id).addClass("is-invalid");
	} else {
		$(id).removeClass("is-invalid")
		$(id).addClass("is-valid");
	}
}

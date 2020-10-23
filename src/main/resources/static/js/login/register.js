var n = false; //验证手机号
var f = false; //验证验证码
var p1 = false; //验证密码
var p2 = false; //验证确认密码
var u = false; //验证用户名


$(document).ready(function() {
	var phones = /^1[34578]\d{9}$/; //手机号正则表达式
	var pwd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,8}$/; //密码正则表达式
	var phone = $("#phone").html();

	if (phone == null || phone == "") {
		$("#form").show();
		$("#form2").hide();
	} else {
		$("#form").hide();
		$("#form2").show();
	}

	// $("#span3").html("");

	var ph=$("#phone").val();
	var na=$("#userName").val();
	if(ph!=null){
		invalid($("#phone"),true);
		n=true;
	}else {
		n=false;
	}

	if (na!=null){
		invalid($("#userName"),true);
		u=false
	}else {
		u=true;
	}

	//input失去焦点事件
	$("#userName").blur(function() {
		var userName = $(this).val();
		if (userName != null && userName != "") {
			if (userName.length <= 10) {
				invalid($(this), true);
				$("#span1").html("");
				u = true;
			} else {
				invalid($(this), false);
				$("#span1").html("用户名超个10个字符");
				u = false;
			}
		} else {
			invalid($(this), false);
			$("#span1").html("用户名不允许为空");
			u = false;
		}
	});
	$("#mobilPhone").blur(function() {
		var mobilPhone = $(this).val();
		if (mobilPhone != null && mobilPhone != "") {
			if (phones.test(mobilPhone)) {
				invalid($(this), true);
				n = true;
				$("#span1").html("");
			} else {
				invalid($(this), false);
				n = false;
				$("#span1").html("请输入正确手机号");
			}
		} else {
			invalid($(this), false);
			n = false;
			$("#span1").html("请输入手机号");
		}
	});

	$("#password").blur(function() {
		var password = $(this).val();
		if (password != null && password != "") {
			if (pwd.test(password)) {
				invalid($(this), true);
				$("#span2").html("");
				p1 = true;
			} else {
				invalid($(this), false);
				$("#span2").html("密码格式不正确，由数字和字母组成的6-8位");
				p1 = false;
			}
		} else {
			invalid($(this), false);
			$("#span2").html("请输入密码");
			p1 = false;
		}

	});

	$("#password2").blur(function() {
		var password2 = $(this).val();
		var Password = $("#password").val();
		if (password2 != null && password2 != "") {
			if (password2 != Password) {
				invalid($(this), false);
				$("#span3").html("两次密码不相同");
				p2 = false;
			} else {
				invalid($(this), true);
				$("#span3").html("");
				p2 = true;
			}
		} else {
			invalid($(this), false);
			p2 = false;
			$("#span3").html("请进行密码确认");
		}
	});

	$("#pas").blur(function() {
		var pas = $(this).val();
		if (pas != null && pas != "") {
			invalid($(this), true);
			$("#span2").html("");
			f = true;
		} else {
			invalid($(this), false);
			f = false;
			$("#span2").html("请输入验证码");
		}
	});


	$("#submit2").click(function () {
		onForm2();
	});


	$("#button02").click(function() {
		var MobilPhone = $("#mobilPhone").val();
		if (MobilPhone != null && MobilPhone != "") {
			if (phones.test(MobilPhone)) {
				invalid($("#mobilPhone"), true);
				$.ajax({
					url:"/code?phone="+MobilPhone+"&reader="+0,
					methods:"get",
					success:function (e) {
						alert(e);
						if("000000"==e){
							$("#span1").html("该用户已被注册");
						}else{
							timer(30);
						}
					},
					error:function () {
						alert("获取验证失败");
					}
				});

			} else {
				invalid($("#mobilPhone"), false);
				$("#span1").html("请输入正确的手机号")
			}
		} else {
			invalid($("#mobilPhone"), false);
			$("#span1").html("手机号不能为空");
		}

	});
});

function invalid(id, r) {
	if (r == false) {
		$(id).removeClass("is-valid")
		$(id).addClass("is-invalid");
	} else {
		$(id).removeClass("is-invalid")
		$(id).addClass("is-valid");
	}
}

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
		return true;
	} else {
		if (n == false) {
			invalid($("#mobilPhone"), false);
			$("#span1").html("请输入手机号");
		}
		if (f == false) {
			invalid($("#pas"), false);
			$("#span2").html("请输入验证码");
		}
	}
	return false;
}

function onForm2() {
	if (u == true && p1 == true && p2 == true) {
		return true;
	} else {
		if (u == false) {
			invalid($("#userName"), false);
			$("#span1").html("请输入用户名");
		}
		if (p1 == false) {
			invalid($("#password "), false);
			$("#span2").html("请输入密码");
		}
		if (p2 == false) {
			invalid($("#password2"), false);
			$("#span3").html("请再次确认密码");
		}
		return false;
	}


}

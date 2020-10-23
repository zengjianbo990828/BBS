
var rea = false;
var der = false;

$(document).ready(function() {
	var name = /^1[3-9]\d{9}$/;
	var pwd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,8}$/;
	var Email = /^\d+@qq\.com$/;

	var us=$("#userName").val();
	var pa=$("#password").val();

	if (us!=null && us!=""){
		if(name.test(us)){
			invalid($(this),true);
			rea = true;
		}else {
			rea=false;
		}
	}else {
		rea=false;
	}

	if(pa!=null && pa!= ""){
		if(pwd.test(pa)){
			invalid($(this),true);
			der = true;
		}else {
			der=false;
		}
	}else {
		der=false;
	}

	
	$("#userName").blur(function() {
		var userName = $(this).val();
		if (userName != null && userName != "") {
			if (name.test(userName) || Email.test(userName)) {
				invalid($(this),true);
				$("#span1").html("");
				rea = true;
			} else {
				invalid($(this),false);
				$("#span1").html("手机号或者邮箱格式错误");
				rea = false;
			}
		} else {
			invalid($(this), false);
			$("#span1").html("请输入手机号或邮箱");
			rea = false;
		}

	});

	$("#password").blur(function() {
		var password = $(this).val();
		if (password != null && password != "") {
			if (pwd.test(password)) {
				invalid($(this), true);
				der = true;
			} else {
				invalid($(this), false);
				der = false;
				$("#span2").html("密码由数字和字母组成6-8位");
			}
		} else {
			invalid($(this), false);
			der = false;
			$("#span2").html("请输入密码");
		}
	});

	$("#submit").click(function() {
		if (rea != true && der != true) {
			if (rea == false) {
				invalid($("#userName"), false);
				$("#span1").html("请输入手机或者邮箱");
			}
			if (der == false) {
				invalid($("#password"), false);
				$("#span2").html("请输入密码");
			}
			return false;
		} else {
			return true;
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

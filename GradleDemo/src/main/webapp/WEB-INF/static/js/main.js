function checkupdate() {
	var temp;
	temp = new String(document.update.password.value);
	loginname = new String(document.update.loginName.value);
	if (document.update.loginName.value == "") {
		alert("请输入登录名!");
		document.update.loginName.focus();
		return false;
	} else if (loginname.length < 0 || loginname.length > 16) {
		alert("您的登录名不能超过16位!");
		document.update.loginName.focus();
		return false;
	}
	if (document.update.password.value == "") {
		alert("请输入密码!");
		document.update.password.focus();
		return false;
	} else if (temp.length < 3 || temp.length > 14) {
		alert("您的密码少于3位或多于14位!");
		document.update.password.focus();
		return;
	}
	if (document.update.confirmpassword.value == "") {
		alert("请再次输入密码!");
		document.update.confirmpassword.focus();
		return false;
	} else if (document.update.password.value != document.update.confirmpassword.value) {
		alert("您二次密码输入不一致!");
		document.update.password.value = "";
		document.update.confirmpassword.value = "";
		document.update.password.focus();
		return false;
	}
	if (document.update.questionPassword.value == "") {
		alert("请输入密码提示问题!");
		document.update.questionPassword.focus();
		return false;
	}
	if (document.update.answerPassword.value == "") {
		alert("请输入密码提示答案!");
		document.update.answerPassword.focus();
		return false;
	}
	if (document.update.email.value != ""
			& IsEmail(document.update.email.value)) {
		alert("您的E-mail不符合规范!");
		document.update.email.focus();
		return false;
	}
	document.forms[0].target = "rfFrame";
	document.update.submit();
}

function IsEmail(item) {
	var etext
	var elen
	var i
	var aa
	var uyear, umonth, uday
	etext = item;
	elen = etext.length;
	if (elen < 5)
		return true;
	i = etext.indexOf("@", 0)
	if (i == 0 || i == -1 || i == elen - 1)
		return true;
	else {
		if (etext.indexOf("@", i + 1) != -1)
			return true;
	}
	if (etext.indexOf("..", i + 1) != -1)
		return true;
	i = etext.indexOf(".", 0)
	if (i == 0 || i == -1 || etext.charAt(elen - 1) == '.')
		return true;
	if (etext.charAt(0) == '-' || etext.charAt(elen - 1) == '-')
		return true;
	if (etext.charAt(0) == '_' || etext.charAt(elen - 1) == '_')
		return true;
	for (i = 0; i <= elen - 1; i++) {
		aa = etext.charAt(i)
		if (!((aa == '.') || (aa == '@') || (aa == '-') || (aa == '_')
				|| (aa >= '0' && aa <= '9') || (aa >= 'a' && aa <= 'z') || (aa >= 'A' && aa <= 'Z')))
			return true;
	}
	return false;
}
function checkuinput() {
	if (document.input.medicineName.value == "") {
		alert("请输入药品名称!");
		document.input.medicineName.focus();
		return false;
	}
	if (document.input.producedDate.value == "") {
		alert("请输入生产日期!");
		document.input.producedDate.focus();
		return false;
	}
	if (document.input.limited.value == "") {
		alert("请输入有限期!");
		document.input.limited.focus();
		return false;
	}
	if (document.input.inputtime.value == "") {
		alert("请输入入库日期!");
		document.input.inputtime.focus();
		return false;
	}
	if (document.input.unitPrice.value == "") {
		alert("请输入入库单价!");
		document.input.unitPrice.focus();
		return false;
	}
	if (document.input.number.value == "") {
		alert("请输入数量!");
		document.input.inputNumber.focus();
		return false;
	}
	if (document.input.manufacturerId.value == "") {
		alert("请输入厂商名称!");
		document.input.manufacturerName.focus();
		return false;
	}
	document.forms[0].target = "rfFrame";
	document.input.submit();
}
function checkuoutput() {
	if (document.output.medicineId.value == "") {
		alert("请输入药品编号!");
		document.output.medicineId.focus();
		return false;
	}
	if (document.output.outTime.value == "") {
		alert("请输入出库日期!");
		document.output.outTime.focus();
		return false;
	}
	if (document.output.unitPrice.value == "") {
		alert("请输入出库单价!");
		document.output.unitPrice.focus();
		return false;
	}

	if (document.output.number.value == "") {
		alert("请输入数量!");
		document.output.number.focus();
		return false;
	}
	document.forms[0].target = "rfFrame";
	document.output.submit();
}

var LPValidation = function() {
};
LPValidation.checkAll = function() {
	var result = true;
	result = LPValidation.checkIdCardNo() && result;
	result = LPValidation.checkPhone() && result;

	if (result) {
		LPVueObj.applyNow.enable();
	}
};

LPValidation.checkIdCardNo = function() {
	var result = false;
	var idCardNo = $.trim($("#idCardNo").val());
	if (idCardNo) {
		if (!Validation.isIdentityCardNumber(idCardNo)) {
			LPVueObj.cardNo.show = "block";
			LPVueObj.cardNo.message = LPError.IdCardNo.invalid;
		} else {
			LPVueObj.cardNo.show = "none";
			result = true;
		}
	}
	return result;
};

LPValidation.checkPhone = function() {
	var result = false;
	var phone = $.trim($("#phone").val());
	if (phone) {
		if (!Validation.isPhoneNumber(phone)) {
			LPVueObj.phone.show = "block";
			LPVueObj.phone.message = LPError.Phone.invalid;
		} else {
			LPVueObj.phone.show = "none";
			result = true;
		}
	}
	return result;
};
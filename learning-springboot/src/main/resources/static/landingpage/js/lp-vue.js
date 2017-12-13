var LPVue = function() {
	this.cardNo = new Vue({
		el : "#cardNoArea",
		data : {
			value : "",
			show : "none",
			message : '',
		},
		methods : {
			idCardNoBlur : function() {
				var value = $.trim(this.value);
				if (value) {
					if (!Validation.isIdentityCardNumber(value)) {
						this.show = "block";
						this.message = LPError.IdCardNo.invalid;
						LPVueObj.applyNow.disable();
					} else {
						this.show = "none";
						LPValidation.checkAll();
					}
				} else {
					this.show = "none";
					LPVueObj.applyNow.disable();
				}
			},
			idCardNoInput : function() {
				var idCardNo = $.trim(this.value);
				if (idCardNo && idCardNo.length == 18) {
					if (idCardNo.indexOf("x") > 0) {
						this.value = idCardNo.toUpperCase();
					}
					LPValidation.checkAll();
				} else {
					LPVueObj.applyNow.disable();
				}
			}
		}
	});

	this.phone = new Vue({
		el : "#phoneArea",
		data : {
			value : "",
			show : "none",
			message : '',
		},
		methods : {
			phoneBlur : function() {
				var value = $.trim(this.value);
				if (value) {
					if (!Validation.isPhoneNumber(value)) {
						this.show = "block";
						this.message = LPError.Phone.invalid;
						LPVueObj.applyNow.disable();
					} else {
						this.show = "none";
						LPValidation.checkAll();
					}
				} else {
					this.show = "none";
					LPVueObj.applyNow.disable();
				}
			},
			phoneInput : function() {
				var phone = $.trim(this.value);
				if (phone && phone.length == 11) {
					LPValidation.checkAll();
				} else {
					LPVueObj.applyNow.disable();
				}
			}
		}
	});

	this.applyNow = new Vue({
		el : "#applyNowArea",
		methods : {
			disable : function() {
				$("#applyNow").addClass("disabled");
			},
			enable : function() {
				$("#applyNow").removeClass("disabled");
			},
			clickApplyNow : function() {
				alert("Hello Vue.js!");
			}
		}
	});
}
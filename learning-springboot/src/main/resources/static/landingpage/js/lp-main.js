var AppLP = (function(){
	$("#termsOfUse").load(appBase + "/static/common/html/TermsofUse_zh.htm");
});

var LPVueObj = null;  
$(document).ready(function() {
	"use strict";
    LPVueObj = new LPVue();
    new AppLP();
});
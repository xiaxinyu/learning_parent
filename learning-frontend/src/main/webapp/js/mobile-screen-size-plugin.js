var MobileScreen = {
	getDevicePixelRatio : function() {
		var dpr = window.devicePixelRatio;
		if (dpr == undefined) {
			throw "Don't support window.devicePixelRatio";
		}
		return dpr;
	},
	getPhysicalScreenWidth : function() {
		return window.screen.width;
	},
	getPhysicalScreenHeight : function() {
		return window.screen.height;
	},
	getBodyWidth : function() {
		return document.body.offsetWidth;
	},
	getBodyHeight : function() {
		return document.body.offsetHeight;
	},
	getPixelScreenWidth : function() {
		return MobileScreen.getDevicePixelRatio()
				* MobileScreen.getPhysicalScreenWidth();
	},
	getPixelScreenHeight : function() {
		return MobileScreen.getDevicePixelRatio()
				* MobileScreen.getPhysicalScreenHeight();
	},
	getGapWidth : function() {
		return MobileScreen.getPhysicalScreenWidth() - MobileScreen.getBodyWidth();
	},
	getGapHeight : function() {
		return MobileScreen.getPhysicalScreenHeight() - MobileScreen.getBodyHeight();
	}
}
(function(window, undefined) {
	// 节省查找window对象的时间；压缩的时候参数是可以压缩的
	// undefined在早期的浏览器中是可以重新赋值的，参数中添加undefined保证了undefined的值被固定，不会被重新赋值
	// Jerry的角色（对象和普通函数）
	var Permission = function(selector) {
		return new Permission.fn.init(selector);
	};
	// Jerry的原型对象
	Permission.fn = Permission.prototype = {
		constructor : Permission,
		init : function(selector) {
		},
		Permission : '1.0'
	};

	var status_allow_access = "allow_access", 
		status_no_permission = "no_permission", 
		status_no_device = "no_device", 
		status_no_support_error = "no_support_error",
		status_no_support_browser = "no_support_browser";
	Permission.check = function(callBack) {
		navigator.getUserMedia = navigator.getUserMedia
				|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
		if (navigator.getUserMedia) {
			navigator.getUserMedia({
				video : true,
				audio : false
			}, function(stream) {
				callBack(status_allow_access);
			}, function(error) {
				if (error.name == "DevicesNotFoundError") {
					callBack(status_no_device);
				} else if (error.name == "PermissionDeniedError") {
					callBack(status_no_permission);
				} else {
					callBack(status_no_support_error);
				}
			});
		} else {
			callBack(status_no_support_browser);
		}
	}

	function Counter() {
		this.counter = 0;
		this.calc = function() {
			this.counter++;
		}
		this.val = function() {
			return this.counter;
		}
		this.clean = function(){
			this.counter = 0;
		}
	}

	function Map() {
		this.container = {};
		this.put = function(key, value) {
			try {
				if (key != null && key != "")
					this.container[key] = value;
			} catch (e) {
				return e;
			}
		};
		this.get = function(key) {
			try {
				return this.container[key];
			} catch (e) {
				return e;
			}
		};
		this.containsKey = function(key) {
			try {
				for ( var p in this.container) {
					if (p == key)
						return true;
				}
				return false;
			} catch (e) {
				return e;
			}
		}
	}

	var map = new Map();
	var limitedCounter = 0;
	Permission.setlimitCounter = function(max){
		limitedCounter = max;
	}
	Permission.getlimitCounter = function(){
		return limitedCounter;
	}
	Permission.createCounter = function(key) {
		if (!map.containsKey(key)) {
			map.put(key, new Counter());
		} else {
			throw "don't same counter";
		}
	}
	Permission.getCounter = function(key){   
		var counter = map.get(key);
		if(counter != undefined){
			return counter;
		}else{
			throw "don't exist " + key + " counter";
		}
	}	

	// 改变init构造函数的原型指向
	Permission.fn.init.prototype = Permission.fn;
	// 向外部公开接口（实际上给window对象添加了两个属性$ 和 Jerry）
	window.Permission = Permission;
})(window);
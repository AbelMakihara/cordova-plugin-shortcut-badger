var exec = require('cordova/exec');

var noop = function(){};

window.shortcutBadger = {
	execute: function(action, params, successCallback, errorCallback) {
		exec(    
			successCallback, 
			errorCallback,
			'CordovaShortcutBadger',
			action,
			params
		)
	},
	set: function(successCallback, errorCallback ,params){
		successCallback = successCallback || noop;
		errorCallback = errorCallback || noop;
		this.execute('set', params, successCallback, errorCallback);
	},
	remove: function(successCallback, errorCallabck ,params){
		successCallback = successCallback || noop;
		errorCallabck = errorCallabck || noop;
		this.execute('remove', params, successCallback, errorCallabck);
	}
};
module.exports = window.shortcutBadger;
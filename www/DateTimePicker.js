module.exports = {
	
	showTimePicker: function(initialHour, initialMinute, successCallback, errorCallback) {
		initialHour = initialHour || 0;
		initialMinute = initialMinute || 0;
		errorCallback = errorCallback || this.errorCallback;
		
        cordova.exec(function(time) {
			if (typeof successCallback == "function") {
				successCallback(JSON.parse(time));
			}
		}, errorCallback, 'DateTimePicker', 'showTimePicker', [initialHour, initialMinute]);
	},
	
	showDatePicker: function(initialYear, initialMonth, initialDay, successCallback, errorCallback) {
		var now = new Date();
		initialYear = initialYear || now.getFullYear();
		initialMonth = initialMonth || now.getMonth();
		initialDay = initialDay || now.getDate();
		errorCallback = errorCallback || this.errorCallback;
        
		cordova.exec(function(date) {
			if (typeof successCallback == "function") {
				successCallback(JSON.parse(date));
			}
		}, errorCallback, 'DateTimePicker', 'showDatePicker', [initialYear, initialMonth, initialDay]);
	},
	
	errorCallback: function(error) {
		console.error("ERROR: " + error);
	}
}
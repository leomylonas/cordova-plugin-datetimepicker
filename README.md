# Cordova Date & Time Picker
This is a very simple Cordova plugin for Android to utilise the native date & time pickers.

### Licence
This is licenced under Creative Commons 4.0 International (http://creativecommons.org/licenses/by/4.0/)

You are free to:  
Share — copy and redistribute the material in any medium or format  
Adapt — remix, transform, and build upon the material for any purpose, even commercially.  
The licensor cannot revoke these freedoms as long as you follow the license terms.  

Attribution — You **must** give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.

### Requirements
* Android only (specific versions not tested, but known to be working on Android 7.0)
* Cordova >= 3.0.0

### Version
0.0.1

### Installation
```sh
$ cordova plugin add https://github.com/leomylonas/cordova-plugin-datetimepicker.git
```

### Uninstallation
```sh
cordova plugin remove cordova-plugin-datetimepicker
```

### Usage
```JavaScript
/**
 * Displays the native TimePicker
 *
 * @param initialHour	     - the default/initial hour (24hr) to pass to the timepicker dialog
 * @param initialMinute	     - the default/initial minute to pass to the timepicker dialog
 * @param successCallback    - the function to call when the time has been selected
 * @param errorCallback      - the function to call if an error occurs
 */
window.DateTimePicker.showTimePicker(initialHour, initialMinute, function(time) {
    /*
    Do something within this callback with the retrieved time.
    [time] will be an object of the following format:
	{
        "hour": int,
		"minute": int
	}
    */
}, function(error) {
    // do something within this callback if there was an error
});

/**
 * Displays the native DatePicker
 *
 * @param initialYear	     - the default/initial year to pass to the datepicker dialog
 * @param initialMonth	     - the default/initial month (n-1) to pass to the datepicker dialog
 * @param initialDay	     - the default/initial day/date to pass to the datepicker dialog
 * @param successCallback    - the function to call when the date has been selected
 * @param errorCallback      - the function to call if an error occurs
 */
window.DateTimePicker.showDatePicker(initialYear, initialMonth, initialDay, function(date) {
    /*
    Do something within this callback with the retrieved date.
    [date] will be an object of the following format:
	{
        "year": int,
		"month": int,
		"day": int
	}
    */
}, function(error) {
    // do something within this callback if there was an error
});
```
package co.mylonas.cordova.datetimepicker;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import android.content.Context;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import org.json.JSONException;
import org.json.JSONArray;

import java.util.logging.Logger;


public class DateTimePicker extends CordovaPlugin {
	
	private final Logger log = Logger.getLogger( this.getClass().getName() );
	private CallbackContext cordovaCallbackContext;
	
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		cordovaCallbackContext = callbackContext;
		log.info("Executing action: " + action);
		
		if (action.equals("showTimePicker")) {
			showTimePicker(args.getInt(0), args.getInt(1));
			return true;
		} else if (action.equals("showDatePicker")) {
			showDatePicker(args.getInt(0), args.getInt(1), args.getInt(2));
			return true;
		}
		
		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Invalid action"));
        return false;
    }

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
			log.info("Received onTimeSet: " + hourOfDay + ":" + minute);
			cordovaCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, "{\"hour\": "+hourOfDay+", \"minute\": "+minute+"}"));
		}
		
	};
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
			log.info("Received onDateSet: " + year + "-" + month + "-" + day);
			cordovaCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, "{\"year\": "+year+", \"month\": "+month+", \"day\": "+day+"}"));
		}
		
	};
	
	public void showDatePicker(int initialYear, int initialMonth, int initialDay) {
		try {
			new DatePickerDialog(this.cordova.getActivity(), mDateSetListener, initialYear, initialMonth, initialDay).show();
		} catch (Exception e) {
			e.printStackTrace();
			cordovaCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Unable to show DatePicker"));
		}
	}
	
	public void showTimePicker(int initialHour, int initialMinute) {
		try {
			new TimePickerDialog(this.cordova.getActivity(), mTimeSetListener, initialHour, initialMinute, false).show();
		} catch (Exception e) {
			e.printStackTrace();
			cordovaCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Unable to show TimePicker"));
		}
	}
	
	
}
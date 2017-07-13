package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class MyTime {
	
	private Calendar calendar;
	
	private SimpleDateFormat sdf;
	
	private String name;
	
	
	public MyTime (String name){
		this.name = name;
	}
	
	public String getCurrentDate(){
		String date;
		
		this.calendar = Calendar.getInstance();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.format(calendar.getTime());
		
		return date;
	}
	
	public String getCurrentTime(){
		String time;
		
		this.calendar = Calendar.getInstance();
		this.sdf = new SimpleDateFormat("HH:mm:ss");
		time = sdf.format(calendar.getTime());
		
		return time;
	}
	
	public String getName() {
		return this.name;
	}
}

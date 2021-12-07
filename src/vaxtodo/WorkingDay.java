package vaxtodo;

public class WorkingDay {

	private String date;
	private String startTime;
	private String endTime;

	public WorkingDay(String date, String startTime, String endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public WorkingDay(String infos) {
		String[] days = infos.split(",");
		
		this.date = days[0];
		this.startTime = days[1];
		this.endTime = days[2];
	}

	@Override
	public String toString() {
		return date + "," + startTime + "," + endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
package jaxtest.xml;

public class DateTime {

	public DateTime() {
		this.date = new Date();
		this.time = new Time();
	}

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	private Time time;
}

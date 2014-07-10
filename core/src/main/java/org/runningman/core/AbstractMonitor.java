package org.runningman.core;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMonitor implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(AbstractMonitor.class);
	private String id;
	private DateTime startTime;
	private DateTime endTime;
	private String note;
	private int frequency = 60;

	public AbstractMonitor(String id, String note) {
		this.id = id;
		this.note = note;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
		}
	}

	public String getStartTime() {
		return this.startTime.toString();
	}

	public void setStartTime(String startTimeStr) {
		if (startTimeStr != null) {
			this.startTime = new DateTime(startTimeStr);
		}
	}

	public String getEndTime() {
		return this.endTime.toString();
	}

	public void setEndTime(String endTimeStr) {
		if (endTimeStr != null) {
			this.endTime = new DateTime(endTimeStr);
		}
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		if (note != null) {
			this.note = note;
		}
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public void setFrequency(int freq) {
		if (freq > 0) {
			this.frequency = freq;
		}
	}
	
	public abstract String status();
	
	public abstract String monitor();

}
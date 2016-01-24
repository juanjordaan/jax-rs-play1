
package com.rtmdn.exam.wsd.timers;

import javax.ejb.ScheduleExpression;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name="scheduled-timer-info" )
@XmlType(name="", propOrder={"originalConfiguration", "timeRemaining", "nextTrigger" })
public class ScheduledTimerInfo
{
	@XmlTransient
	private String timerID;
	
	@XmlElement( name = "scheduleConfiguration" )
	private ScheduleConfiguration originalConfiguration;
	
	@XmlElement
	private long timeRemaining;
	
	@XmlElement
	private String nextTrigger;
	
	public ScheduledTimerInfo ( )
	{
		
	}
	
	public ScheduledTimerInfo ( String timerID, ScheduleExpression expression, long timeRemaining, String nextTrigger )
	{
		this.timerID = timerID;
		this.originalConfiguration = new ScheduleConfiguration ( expression );
		this.timeRemaining = timeRemaining;
		this.nextTrigger = nextTrigger;
	}
}

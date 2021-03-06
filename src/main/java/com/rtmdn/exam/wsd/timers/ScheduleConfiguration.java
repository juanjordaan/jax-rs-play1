
package com.rtmdn.exam.wsd.timers;

import javax.ejb.ScheduleExpression;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
@XmlType(name="schedule-configuration", propOrder={"second", "minute", "hour", "dayOfWeek", "dayOfMonth", "month", "year", "persistent"})
public class ScheduleConfiguration
{
	@XmlTransient
	private ScheduleExpression expression;
	
	private String second;
	private String minute;
	private String hour;
	private String dayOfWeek;
	private String dayOfMonth;
	private String month;
	private String year;
	
	private boolean persistent;
	
	public ScheduleConfiguration ( )
	{
		
	}
	
	public ScheduleConfiguration ( ScheduleExpression expression )
	{
		this.second = expression.getSecond ( );
		minute = expression.getMinute ( );
		hour = expression.getHour ( );
		dayOfWeek = expression.getDayOfWeek ( );
		dayOfMonth = expression.getDayOfMonth ( );
		month = expression.getMonth ( );
		year = expression.getYear ( );
	}
	
	public ScheduleExpression getScheduleExpression( )
	{
		return this.expression;
	}

	public boolean isPersistent( )
	{
		return persistent;
	}

	public String getSecond( )
	{
		return second;
	}

	public String getMinute( )
	{
		return minute;
	}

	public String getHour( )
	{
		return hour;
	}

	public String getDayOfWeek( )
	{
		return dayOfWeek;
	}

	public String getDayOfMonth( )
	{
		return dayOfMonth;
	}

	public String getMonth( )
	{
		return month;
	}

	public String getYear( )
	{
		return year;
	}

}

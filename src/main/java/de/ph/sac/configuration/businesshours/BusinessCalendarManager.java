package de.ph.sac.configuration.businesshours;

import org.camunda.bpm.engine.impl.calendar.DueDateBusinessCalendar;
import org.camunda.bpm.engine.impl.calendar.MapBusinessCalendarManager;

public class BusinessCalendarManager extends MapBusinessCalendarManager{

	public BusinessCalendarManager(){
		this.addBusinessCalendar(DueDateBusinessCalendar.NAME, new DueDateBusinessCalendar());
  	}
}

package de.ph.sac.configuration.businesshours;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DueDateBusinessCalendar extends org.camunda.bpm.engine.impl.calendar.DueDateBusinessCalendar {

    private Logger logger = LoggerFactory.getLogger(DueDateBusinessCalendar.class);

    @Override
    public Date resolveDuedate(String duedate, Date startDate) {
        
        logger.info("We could play with resolve due date here");

        return super.resolveDuedate(duedate, startDate);
    }
}

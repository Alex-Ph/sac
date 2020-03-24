package de.ph.sac.parserlistener;

import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityBehavior;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class TaskLoggerParseListener extends AbstractBpmnParseListener {

    @Override
    public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
        ActivityBehavior activityBehavior = activity.getActivityBehavior();

        if (activityBehavior instanceof UserTaskActivityBehavior) {
            UserTaskActivityBehavior userTaskActivityBehavior = (UserTaskActivityBehavior) activityBehavior;

            userTaskActivityBehavior.getTaskDefinition().addBuiltInTaskListener(TaskListener.EVENTNAME_CREATE,
                    new TaskLoggerTaskListener(TaskListener.EVENTNAME_CREATE));

            userTaskActivityBehavior.getTaskDefinition().addBuiltInTaskListener(TaskListener.EVENTNAME_ASSIGNMENT,
                    new TaskLoggerTaskListener(TaskListener.EVENTNAME_ASSIGNMENT));

            userTaskActivityBehavior.getTaskDefinition().addBuiltInTaskListener(TaskListener.EVENTNAME_COMPLETE,
                    new TaskLoggerTaskListener(TaskListener.EVENTNAME_COMPLETE));

            userTaskActivityBehavior.getTaskDefinition().addBuiltInTaskListener(TaskListener.EVENTNAME_DELETE,
                    new TaskLoggerTaskListener(TaskListener.EVENTNAME_DELETE));
        }
    }
}
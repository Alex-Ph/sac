project to learn more about SpringBoot and camunda. Before that I just used and enhanced the dockered wildfly container.

I created the repo sacclient to create dummy data and learn more about Angular :)

Prototype contains:
- Custom parseListeners (just log that we listen now)
- Custom DueDateBusinessCalendar ( just log that we "could" change due behaviour)
- Some controllers to list open tasks and completed tasks, 
- Also some controllers to start, complete and claim tasks the provided demo task
- An Integration test for one controller (more should come later, just want to see how it works for now)
- An unittest for one controller (more should come later, just want to see how it works for now)
- Automated test of the provided demo process -> intTest (more should come later, just want to see how it works for now)

ToDos:
- Check project against provided checkstyle.xml file
- Fix integTests execution (atm its triggered also in unittest context)
- Provide more tests and use a coverage tool
- Later: Add authentication and only return tasks user is allowed to claim / complete
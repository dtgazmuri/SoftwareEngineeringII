TEMPLATE FOR RETROSPECTIVE (Team P13)
=====================================

The retrospective should include _at least_ the following
sections:

- [process measures](#process-measures)
- [quality measures](#quality-measures)
- [general assessment](#assessment)

## PROCESS MEASURES 

### Macro statistics

- Number of stories committed vs done 		:	 4 committed (Officer - Notify System He's Free; Customer - Counter Notification; Customer - Ticket; Officer - Client Showing and Selection)
												3 done (we left out the Officer - Client Showing and Selection)
- Total points committed vs done 		:	13 (Officer - Client Showing and Selection) + 2 (Customer - Counter Notification) + 2 (Customer - Ticket) + 5 (Officer - Notify System He's Free)
												total of: 	 22 estimated
												total of:	9 done (really they are more; but we forgot to show the service type to the officer's view that was included and so all the story was't actually finished)
- Nr of hours planned vs spent (as a team)	:	48 hours planned
										 :
												3h + 3h + 1d 1h 45m + 4h + 3h 30m + 3h + 1d 1h 30m + 3h + 1h + 1h 30m + 2h + 30m + 1h + 1h + 1h + 30m + 1h = 48h 15m
												total of : 48 h 15 m  -> 6d 15m


										:		we worked 15 minutes (totally) more than the estimation

**Remember**  a story is done ONLY if it fits the Definition of Done:

- Unit Tests passing
- Code review completed
- Code present on VCS
- End-to-End tests performed

> Please refine your DoD 

### Detailed statistics

| Story                                        | # Tasks | Points | Hours est. | Hours actual |
| -------------------------------------------- | ------- | ------ | ---------- | ------------ |
| _#0_                                         | 9       | -      | 5d 1h      | 39h 45m      |
| #1  (Officer - Notify System He's Free)      | 1       | 5      | 30m        | 30m          |
| #2  (Customer - Counter Notification)        | 1       | 2      | 2h         | 1h           |
| #3  (Customer - Ticket)                      | 4       | 2      | 2h 30m     | 3h 30m       |
| #4  (Officer - Client showing and selection) | 3       | 13     | 2h         | 3h 30m       |


> place technical tasks corresponding to story `#0` and leave out story points (not applicable in this case)

- Hours per task (average, standard deviation) 		:   **average** = 48.25 / 18 = **2.68**

  ​                                                                                            **standard deviation** = **2.7184**

- Total task estimation error ratio: sum of total hours estimation / sum of total hours spent from previous table 		: 48 / 48.25 = **0.994**

  
  
  
  
  
## QUALITY MEASURES 

- Unit Testing:
  - Total hours estimated		:	3 h
  - Total hours spent			:	2 h 30 m + 30 m of manual test with prints and so on
  - Nr of automated unit test cases 	:	6 for the OfficeCounter Class; 
										  3 for the OfficeQueue Class; 
										  7 for the Office Class;
										  3 for the Ticket Class;
  - Coverage (if available)		:	we tested all the function with the exception of getter and setter; and Override methods (like the toString())

NOTE: we have tested also the basic function (excluded in the coverage) but we made no unit test so we didn't count them in the actual tests.

- E2E testing:
  - Total hours estimated		:	1 h
  - Total hours spent			:	1 h (on average 15 m each)

- Code review:
  - Total hours estimated 		:	included in the tasks; we considered:
											10 minutes for the 30 m tasks
											15 minutes for the 1 h tasks
											20 minutes for the 2 h tasks
											30 minutes for the 3 h tasks
										total of:
											175 m -> 2 h 55 m
		
  - Total hours spent			:	Lets say:
										 Guglielmo : 30m
										 Gabriele : 20m
										 Setareh: 20m
										 Stefano: 30m
										 Diego: 30m
										 Lorenzo: 30m

										with a total of : 160m

- Technical Debt management:
  - Total hours estimated 
  - Total hours spent
  - Hours estimated for remediation by SonarQube
  - Hours estimated for remediation by SonarQube only for the selected and planned issues 
  - Hours spent on remediation 
  - debt ratio (as reported by SonarQube under "Measures-Maintainability")
  - rating for each quality characteristic reported in SonarQube under "Measures" (namely reliability, security, maintainability )
  


## ASSESSMENT

- What caused your errors in estimation (if any)?
	We had errors in the estimation mainly due to the amount considered to re-learn (or learn from zero) Java basics and applying this to the graphic interfaces part of the project.

- What lessons did you learn (both positive and negative) in this sprint?
	We have to choose wisely which programming langugage to use in the future, in order to optimize the limited time we had to develop the project. However, we have taken this sprint as an opportunity to learn new tools for the future.

- Which improvement goals set in the previous retrospective were you able to achieve?
	We wanted to start well as a team and divide the work load properly. We think we managed to do this fairly well, assigning tasks according to each person's skill in the chosen programming language.

- Which ones you were not able to achieve? Why?
	We wanted to complete more stories, especially the one of the manager statistics. We even developed the database for this, but we weren't able to complete the story. Due to the estimations done by the Poker game, we realized it was hard to fit this story in the sprint.

- Improvement goals for the next sprint and how to achieve them (technical tasks, team coordination, etc.)
	In future sprints we would like to divide our time more precisely into development, testing and review. In the previous sprint we did not do this thoroughly, leading to some time being wasted.

- One thing you are proud of as a Team
	We are proud of the end product. We know there is a lot of work yet to be done, but we progressed a lot and have a functional product to show the stakeholders. We have also listened to the feedback received by them and have taken it as an opportunity to improve our product. We are also proud of the effort estimation done through the Planning Poker game, since it was pretty accurate and helped us a lot to plan.



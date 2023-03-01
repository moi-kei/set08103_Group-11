**USE CASE: 2 Produce a report on all the cities based on population**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

**CHARACTERISTIC INFORMATION**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Goal in Context**

As a PI Advisor I want to produce a report on all the cities so that I can develop a better understanding of city growth.

**Scope**

Organisation.

**Level**

Primary task.

**Preconditions**

Database contains all data of the cities in the world.

**Success End Condition**

* All the cities in the world, continent and region organised by largest population to smallest.
* The top N populated cities in the world, continent and region.

**Failed End Condition**

No report is produced.

**Primary Actor**

A Population Information Advisor.

**Trigger**

A request for countries information is sent to the organisation.

**MAIN SUCCESS SCENARIO**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

1. Request for cities information is sent.
2. Database data extraction of name, country, district and population.
3. Sorting information from largest to smallest.
4. Reports are produced.

**EXTENSIONS**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Incorrect character or number entered by the user Message of error is displayed.

**SUB-VARIATIONS**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

None.

**SCHEDULE**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**DUE DATE**: Release 1.0
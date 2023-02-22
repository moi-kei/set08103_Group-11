**USE CASE: 1 Produce a report on all the countries based on population**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

**CHARACTERISTIC INFORMATION**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Goal in Context**

As a PI Advisor I want to produce a report on all the countries so that I can develop a better understanding of population distribution

**Scope**

Company.

**Level**

Primary task.

**Preconditions**

Database contains all data of the countries in the world.

**Success End Condition**

* All the countries in the world, continent and region organised by largest population to smallest
* The top N populated countries in the world, continent and region

**Failed End Condition**

No report is produced.

**Primary Actor**

A Population Information Advisor.

**Trigger**

A request for countries information is sent to the organisation.

**MAIN SUCCESS SCENARIO**
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

1. Request for countries information is sent.
2. Database data extraction of code, name, continent, region, population and capital.
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
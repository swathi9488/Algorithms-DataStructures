package com.company;

/**
 * Created by swathi on 4/16/16.
 */
/*
Given a list of a company's employees in the form name,boss,title,year produce an organizational chart
by printing out each employee followed by everyone that employee manages indented by dashes.

Sample Input:

Download Sample Input
3
Fred,Karl,Technician,2010--Karl,Cathy,VP,2009--Cathy,NULL,CEO,2007
Adam,Karl,Technician,2010--Bob,Karl,Technician,2012--Cathy,Karl,Technician,2013--Karl,Nancy,Manager,2009--Wendy,Nancy,Technician,2012--Nancy,NULL,CEO,2007
Fred,Cathy,Technician,2010--Nancy,Wendy,Technician,2013--Vince,Karl,VP,2009--Bob,Susan,Manager,2010--Adam,Susan,Technician,2011--Ned,Wendy,Technician,2009--Liam,Wendy,Technician,2007--Dan,Ryan,Director,2008--Carl,Susan,Technician,2010--Ed,Wendy,Technician,2007--Patty,Wendy,Technician,2008--Tom,Susan,Technician,2011--Sam,Susan,Technician,2008--Lilly,Jack,Manager,2007--Amy,Jill,Technician,2012--Wendy,Dan,Manager,2010--Cathy,Vince,Director,2006--Susan,Vince,Director,2009--Betty,Cathy,Manager,2012--Oscar,Betty,Technician,2006--Jill,Dan,Manager,2012--Katie,Jill,Technician,2007--Paul,Bob,Technician,2007--Ryan,Karl,VP,2007--Mary,Lilly,Technician,2013--Matt,Jill,Technician,2007--Karl,NULL,CEO,2005--Jack,Ryan,Director,2009


Sample Output:

Download Sample Output
Case #1
Cathy (CEO) 2007
-Karl (VP) 2009
--Fred (Technician) 2010
Case #2
Nancy (CEO) 2007
-Karl (Manager) 2009
--Adam (Technician) 2010
--Bob (Technician) 2012
--Cathy (Technician) 2013
-Wendy (Technician) 2012
Case #3
Karl (CEO) 2005
-Ryan (VP) 2007
--Dan (Director) 2008
---Jill (Manager) 2012
----Amy (Technician) 2012
----Katie (Technician) 2007
----Matt (Technician) 2007
---Wendy (Manager) 2010
----Ed (Technician) 2007
----Liam (Technician) 2007
----Nancy (Technician) 2013
----Ned (Technician) 2009
----Patty (Technician) 2008
--Jack (Director) 2009
---Lilly (Manager) 2007
----Mary (Technician) 2013
-Vince (VP) 2009
--Cathy (Director) 2006
---Betty (Manager) 2012
----Oscar (Technician) 2006
---Fred (Technician) 2010
--Susan (Director) 2009
---Adam (Technician) 2011
---Bob (Manager) 2010
----Paul (Technician) 2007
---Carl (Technician) 2010
---Sam (Technician) 2008
---Tom (Technician) 2011


Input Format:

Read your input from a file. The first line of the file is N, the number of test cases. Following this are N lines l, one for each test case.

Each test case lists all the employees of a company on a single line and looks like this:
  name,boss,title,year--name,boss,title,year--name,boss,title,year

Each employee is separated by two dashes. Employee info is separated by commas.
- name: Name of the employee
- boss: Name of the employee's boss
- title: Job title
- year: Year the employee was hired

One employee at the company is the CEO and doesn't have a boss.
This employee has NULL as the boss and CEO as the title. For example:
  Jack,NULL,CEO,2010

Within a company, no two employees have the same name and each employee is listed once and only once.
Each employee's top most boss is the CEO.


Output Format:

For each test case:
On the first line, print 'Case #n' (without quotes), where n is the case number (starting from 1).
Starting with the CEO, print each employee followed by everyone that employee manages, indented by dashes.
      For example: Cathy manages Karl and Vince. Karl manages Fred.
Cathy (CEO) 2007
-Karl (VP) 2009
--Fred (Technician) 2010
-Vince (Technician) 2010
Each employee will be printed in alphabetical order underneath their boss. In the example, Karl comes before Vince alphabetically.
Each employee has the following format:
      name (title) year
The number of dashes that come before the employee's name is one more than the number of dashes of the employee's boss. The CEO will have no dashes, the employees that report directly to the CEO will have 1 dash, the people that report to them will have 2, and so on.

Bounds:

These are assumptions you can make about the input. You do not need to test for them.

1 <= N <= 100
1 <= length of l <= 10000
name and title consist only of letters [a-zA-Z]
year is a 4 digit number
 */
public class Employee {
    private String name;
    private String manager;
    private String title;
    private int year;

    public Employee(String[] employeeDetails) {
        this.name = employeeDetails[0];
        this.manager = employeeDetails[1];
        this.title = employeeDetails[2];
        this.year = Integer.parseInt(employeeDetails[3]);
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

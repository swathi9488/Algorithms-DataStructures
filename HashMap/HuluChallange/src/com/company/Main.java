package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PrintWriter out = null;
        if (args.length == 0) {
            System.out.println("Please pass input file as an argument");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){
            out = new PrintWriter(new FileWriter("org_chart.out"));

            // read the each input set and write into output file
            int totalTestCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= totalTestCases; i++) {

                // form function inputs
                String[] employeeList = (br.readLine()).split("--");

                // call the function that calculates the org chart
                computeOrganizationalChart(employeeList, out, i);
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void computeOrganizationalChart(String[] employeeList, PrintWriter out, int caseNumber) {
        Map<String, List<Employee>> managerMap = new HashMap<>();
        Employee ceoDetails = null;
        for (int i = 0; i < employeeList.length; i++) {
            // create a new Employee object
            Employee employee = new Employee(employeeList[i].split(","));
            String manager = employee.getManager();
            if (manager.equals("NULL")) {

                // printing of the organization chart starts from the CEO
                ceoDetails = employee;
            } else {
                List<Employee> directReports = managerMap.get(manager);
                if (directReports == null) {
                    directReports = new ArrayList<>();
                    directReports.add(employee);
                    managerMap.put(manager, directReports);
                } else {
                    directReports.add(employee);
                    managerMap.put(manager, directReports);
                }
            }
        }

        printOrganizationalChart(managerMap, ceoDetails, 0, out, caseNumber);
    }

    public static void printOrganizationalChart(Map<String, List<Employee>> managerMap,
                                                Employee employeeDetails, int position,
                                                PrintWriter out, int caseNumber) {

        // calculate the hyphens depending on how deep is the level of the employee
        String hyphens = getHyphens(position);

        if (position == 0) {
            out.println(String.format("Case #%d", caseNumber));
        }

        out.println(String.format("%s%s (%s) %s", hyphens, employeeDetails.getName(),
                employeeDetails.getTitle(), employeeDetails.getYear()));

        List<Employee> directReports = managerMap.get(employeeDetails.getName());

        if (directReports == null) {
            return;
        }

        List<Employee> sortedDirectReports = new LinkedList<>(directReports);
        Collections.sort(sortedDirectReports, (entry1, entry2) -> entry1.getName().compareTo(entry2.getName()));

        for (Employee directReport: sortedDirectReports) {
            printOrganizationalChart(managerMap, directReport, position+1, out, caseNumber);
        }
    }

    public static String getHyphens(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}


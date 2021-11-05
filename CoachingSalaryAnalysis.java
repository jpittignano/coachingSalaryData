import java.io.*;
import java.util.*;

public class CoachingSalaryAnalysis{
  public static final int schoolColumn = 2;
  public static final int payColumn = 3;
  public static final int conferenceColumn = 4;
  public static final int numColumns = 10;
  public static final int numConferences = 10;

  public static void main (String[] args) throws FileNotFoundException{
    System.out.println(bestConference("coachSalaries.csv"));
  }


  //gets an element
  public static String getElement(String pathname, int lineNumber, int col) throws FileNotFoundException{

    Scanner input = new Scanner (new File(pathname));
    input.useDelimiter(",");

    input.nextLine(); //skipping header

    int count = 0; //keeping track of row

    while (input.hasNextLine()){ //going through each line
      count++;
      if (count==lineNumber){ //if you are at the line you want
        String wholeLine = input.nextLine(); //save the line into a String
        String[] currentLine = new String[numColumns];
        currentLine = wholeLine.split(",", 0); //split into array
        String toRet = currentLine[col]; //getting the thing you want
        return toRet;
      }else{
        input.nextLine();
      }
    }
    return "hello"; //just in case --> computer needs this
  }


  //find the conference that has the highest average salaries
  public static String bestConference(String pathname) throws FileNotFoundException{
    //3 parallel arrays
    String[] conferenceNames = {"ACC", "Big 12", "Big Ten", "CUSA", "INDEP", "MAC", "MWC", "Pac-12", "SEC", "Sun Belt"};
    int[] numConferenceOccurance = new int[numConferences];
    int[] sumSalaries = new int[numConferences];


    Scanner input = new Scanner (new File(pathname));
    input.useDelimiter(",");


    input.nextLine(); //skipping header

    int count = 1;

    //depending on which conference, add to num of times it occurs, and to the total salaries of that conference
    while(input.hasNextLine()){
      String currentConference = getElement("coachSalaries.csv", count, 4);
      if (currentConference.equals("ACC")){
        numConferenceOccurance[0] = numConferenceOccurance[0] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[0] = sumSalaries[0] + salary;
        }
      }else if (currentConference.equals("Big 12")){
        numConferenceOccurance[1] = numConferenceOccurance[1] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[1] = sumSalaries[1] + salary;
        }
      }else if (currentConference.equals("Big Ten")){
        numConferenceOccurance[2] = numConferenceOccurance[2] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[2] = sumSalaries[2] + salary;
        }
      }else if (currentConference.equals("CUSA")){
        numConferenceOccurance[3] = numConferenceOccurance[3] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[3] = sumSalaries[3] + salary;
        }
      }else if (currentConference.equals("INDEP")){
        numConferenceOccurance[4] = numConferenceOccurance[4] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[4] = sumSalaries[4] + salary;
        }
      }else if (currentConference.equals("MAC")){
        numConferenceOccurance[5] = numConferenceOccurance[5] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[5] = sumSalaries[5] + salary;
        }
      }else if (currentConference.equals("MWC")){
        numConferenceOccurance[6] = numConferenceOccurance[6] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[6] = sumSalaries[6] + salary;
        }
      }else if (currentConference.equals("Pac-12")){
        numConferenceOccurance[7] = numConferenceOccurance[7] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[7] = sumSalaries[7] + salary;
        }
      }else if (currentConference.equals("SEC")){
        numConferenceOccurance[8] = numConferenceOccurance[8] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[8] = sumSalaries[8] + salary;
        }
      }else if (currentConference.equals("Sun Belt")){
        numConferenceOccurance[9] = numConferenceOccurance[9] + 1;
        String salaryString = getElement("coachSalaries.csv", count, 3);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[9] = sumSalaries[9] + salary;
        }
      }else{
      }
      count++;
      input.nextLine();
    }

    double[] averageConferenceSalary = new double[numConferences];
    for (int i=0; i<numConferences; i++){
      double average = (double)sumSalaries[i]/ numConferenceOccurance[i];
      averageConferenceSalary[i] = average;
    }

    double max = 0.0;
    int index = 0;

    for (int i=0; i<numConferences; i++){
      if (averageConferenceSalary[i]>max){
        max = averageConferenceSalary[i];
        index = i;
      }else{
      }
    }

    String toRet = "The conference with the highest average salary of all the head college football coaches is the " + conferenceNames[index] + " with the average salary being " + "$" + max;
    return toRet;
  }


  //find the number of schools that are in the top fifty size that have coaches that makes over 1 million
  public static int numSchoolsTopFiftySizeOverMil(){
    return 2;
  }

  //find the number of schools that are in the top fifty academic that have coaches that makes over 1 million
  public static int numSchoolsTopFiftyAcademicOverMil(){
    return 2;
  }


  //compare which has a larger correlation to salary amount, size or academics
  public static String compareSizeAndAcademics(){
    return "hello";
  }



}

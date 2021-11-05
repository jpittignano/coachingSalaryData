import java.io.*;
import java.util.*;

public class CoachingSalaryAnalysis{
  public static final int schoolColumn = 2;
  public static final int payColumn = 3;
  public static final int conferenceColumn = 4;
  public static final int numColumns = 10;
  public static final int numConferences = 10;

  public static void main (String[] args) throws FileNotFoundException{
    //Which conference has the highest average salary?
    System.out.println(bestConference("coachSalaries.csv"));


    //Is there a link between the size of a college and football coach salary?
    System.out.println(sizeAndSalaryConclusion());

  }


  //gets an element in the coachSalaries.csv (can use in other methods)
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
      String currentConference = getElement("coachSalaries.csv", count, conferenceColumn);
      if (currentConference.equals("ACC")){
        numConferenceOccurance[0] = numConferenceOccurance[0] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[0] = sumSalaries[0] + salary;
        }
      }else if (currentConference.equals("Big 12")){
        numConferenceOccurance[1] = numConferenceOccurance[1] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[1] = sumSalaries[1] + salary;
        }
      }else if (currentConference.equals("Big Ten")){
        numConferenceOccurance[2] = numConferenceOccurance[2] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[2] = sumSalaries[2] + salary;
        }
      }else if (currentConference.equals("CUSA")){
        numConferenceOccurance[3] = numConferenceOccurance[3] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[3] = sumSalaries[3] + salary;
        }
      }else if (currentConference.equals("INDEP")){
        numConferenceOccurance[4] = numConferenceOccurance[4] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[4] = sumSalaries[4] + salary;
        }
      }else if (currentConference.equals("MAC")){
        numConferenceOccurance[5] = numConferenceOccurance[5] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[5] = sumSalaries[5] + salary;
        }
      }else if (currentConference.equals("MWC")){
        numConferenceOccurance[6] = numConferenceOccurance[6] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[6] = sumSalaries[6] + salary;
        }
      }else if (currentConference.equals("Pac-12")){
        numConferenceOccurance[7] = numConferenceOccurance[7] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[7] = sumSalaries[7] + salary;
        }
      }else if (currentConference.equals("SEC")){
        numConferenceOccurance[8] = numConferenceOccurance[8] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[8] = sumSalaries[8] + salary;
        }
      }else if (currentConference.equals("Sun Belt")){
        numConferenceOccurance[9] = numConferenceOccurance[9] + 1;
        String salaryString = getElement("coachSalaries.csv", count, payColumn);
        if (!salaryString.equals("na")){
          int salary = Integer.parseInt(salaryString);
          sumSalaries[9] = sumSalaries[9] + salary;
        }
      }else{
      }
      count++;
      input.nextLine();
    }

    //finding averages and inputting them into another parallel array
    double[] averageConferenceSalary = new double[numConferences];
    for (int i=0; i<numConferences; i++){
      double average = (double)sumSalaries[i]/ numConferenceOccurance[i];
      averageConferenceSalary[i] = average;
    }

    double max = 0.0;
    int index = 0;

    //comparing and finding the largest average
    for (int i=0; i<numConferences; i++){
      if (averageConferenceSalary[i]>max){
        max = averageConferenceSalary[i];
        index = i;
      }else{
      }
    }

    //returning the conference with the largest average & extra info
    String toRet = "The conference with the highest average salary of all the head college football coaches is the " + conferenceNames[index] + " with the average salary being " + "$" + max;
    return toRet;
  }


  //finds the number of schools that are in the top fifty size and also have coaches that make over 1 million
  public static int numSchoolsTopFiftySizeOverMil(String regular1, String rankedList1) throws FileNotFoundException{
    //create scanner for csv
    Scanner regular = new Scanner (new File(regular1));
    regular.useDelimiter(",");
    //create scanner for rank txt
    Scanner rankedList = new Scanner (new File(rankedList1));
    String[] topFifty = new String[50];

    //make array with top 50 largest schools
    for (int k=0; k<topFifty.length; k++){
      topFifty[k] = rankedList.nextLine();
    }

    int totalNum = 0; //variable for total number of schools that meet the condition in this method
    ArrayList<String> listOfSchoolsOverMil = new ArrayList<>();
    int count = 1;

    regular.nextLine(); //skipping header

    //go through the file to find all the schools that have coaches that make over 1 mil and add to array list
    while(regular.hasNextLine()){
      String salaryString = getElement(regular1, count, payColumn);
      if(!salaryString.equals("na")){ //checking to make sure its not na
        int salary = Integer.parseInt(salaryString);
        String name = getElement(regular1, count, schoolColumn);
        if (salary>1000000){
          listOfSchoolsOverMil.add(name);
        }else{
        }
      }else{
      }
      count++;
      regular.nextLine();
    }

    ArrayList<String> schoolsValid = new ArrayList<>(); //array list that holds the schools that meet both conditions

    //checking which schools w/ salaries over 1 mil are also in the top 50 largest
    for(int i = 0; i<listOfSchoolsOverMil.size(); i++){
      for(int w = 0; w<topFifty.length; w++){
        if ((listOfSchoolsOverMil.get(i)).equals(topFifty[w])){
          totalNum++; //adding to the number of schools
          schoolsValid.add(topFifty[w]); //adding to array list
        }else{

        }
      }
    }

    //System.out.println(schoolsValid); --> could print the schools if I wanted to

    return totalNum;
  }


  //putting together the information about the size and salary correlation
  public static String sizeAndSalaryConclusion() throws FileNotFoundException{
    int numSchools = numSchoolsTopFiftySizeOverMil("coachSalaries.csv", "schoolSize.txt");

    String conclusion = "";

    if(numSchools > 25){
      conclusion = conclusion + "There is a correlation between size and college football coach salary. " + numSchools + " schools ranked top 50 for size also have coaches that make over 1 million dollars every year, which is a considerable amount of overlap.";
    }else{
      conclusion = conclusion + "There is not really a correlation between size and college football coach salary. " + numSchools + " schools ranked top 50 for size also have coaches that make over 1 million dollars every year, which is not a considerable amount of overlap.";
    }

    return conclusion;
  }


}

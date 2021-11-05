import java.io.*;
import java.util.*;

public class CoachingSalaryAnalysis{
  public static final int schoolColumn = 2;
  public static final int payColumn = 3;
  public static final int conferenceColumn = 4;
  public static final int numColumns = 10;

  public static void main (String[] args) throws FileNotFoundException{
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
        String[] currentLine = new String[numColumns]; //
        currentLine = wholeLine.split(",", 0); //split into array
        String toRet = currentLine[col]; //getting the thing you want
        return toRet;
      }else{
        input.nextLine();
      }
    }
    return "hello"; //just in case --> computer needs this
  }

/*
  //find the conference that has the highest average salaries
  public static String bestConference(String pathname) throws FileNotFoundException){

    Scanner input = new Scanner (new File(pathname));
    sc.useDelimiter(“,”);

    System.out.println(getElement("coachSalaries.csv", 2, 4));

    //variables for conferences
    int ACC = 0;
    int big12 = 0;
    int bigTen = 0;
    int conferenceUSA = 0;
    int independent = 0;
    int midAmerican = 0;
    int mountainWest = 0;
    int pac12 = 0;
    int SEC = 0;
    int sunBelt = 0;

    int ACCCount = 0;

    //do with parallel arrays

    for (int i = )

    //Integer.parseInt(String); --> converts string to int

    while(input.hasNextLine()){
      for (int i = 0; i<; i++){
        if(i==4){


        }else if (i==5){

        }

      }
    }

    //5


  }

  //find the number of schools that are in the top fifty size that have coaches that makes over 1 million
  public static int numSchoolsTopFiftySizeOverMil(){
  }

  //find the number of schools that are in the top fifty academic that have coaches that makes over 1 million
  public static int numSchoolsTopFiftyAcademicOverMil(){
  }

  //finds the average salary reduction for Texas schools
  public static int avgCovidReductionTexas(){
  }

  //finds the average salary reduction for other schools
  public static int avgCovidReductionOther(){
  }


  //compare which has a larger correlation to salary amount, size or academics
  public static String compareSizeAndAcademics(){

  }

  //compare average salary reduction due to COVID in texas schools versus every other schools
  public static String compareTexasAndOthers(){

  }
  */
}

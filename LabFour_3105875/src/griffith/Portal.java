//Mert Faruk Gunes - 3105875
package griffith;

public class Portal {
    public static void main(String[] args) {
    	//example deadline
        Deadline deadlineOne = new Deadline(2023, 12, 30, 23);
        Deadline deadlineTwo = new Deadline(2023, 11, 30, 23);
        Deadline deadlineThree = new Deadline(2023, 10, 30, 23);
        
        //example assignment        
        Assignment assignmentOne = new Assignment("First Assignment", 45, deadlineOne);
        Assignment assignmentTwo = new Assignment("Second Assignment", 55, deadlineTwo);
        Assignment assignmentThree = new Assignment("Third Assignment", 50, deadlineThree);

        //example test   
        Test testOne = new Test("Test 1", 65, deadlineOne);
        Test testTwo = new Test("Test 2", 75, deadlineTwo);
        Test testThree = new Test ("Test 3", 70, deadlineThree);

        //now testing
        assignmentOne.submit(1);
        assignmentOne.submit(2);
        assignmentTwo.submit(1);
        assignmentTwo.submit(2);
        assignmentThree.submit(1);
        assignmentThree.submit(2);
        
        //now testing "test"
        testOne.submit(1);
        testOne.submit(2);
        testTwo.submit(1);
        testTwo.submit(2);
        testThree.submit(1);
        testThree.submit(2);

        AssessmentLogger.getInstance().closeLog(Event.SUBMITTED);
        AssessmentLogger.getInstance().closeLog(Event.UPDATED);
        AssessmentLogger.getInstance().closeLog(Event.LATE_SUBMISSION);
    }
}

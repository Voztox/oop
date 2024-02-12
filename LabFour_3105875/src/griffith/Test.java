//Mert Faruk Gunes - 3105875
package griffith;

import java.time.LocalDate;

public class Test extends Assessment {
    private Deadline deadline;
    private boolean submitted;

    
    public Test(String title, int mark, Deadline deadline) {
        super(title, mark);
        this.deadline = deadline;
        submitted = false;
    }

    @Override
    public void submit(int studentID) {
        String message = "";
        //condition for tests. 
        //only difference with assignment is you can not update your submission.
        if (LocalDate.now().isBefore(LocalDate.of(deadline.getYear(), deadline.getMonth(), deadline.getDay())) && !submitted) {
            AssessmentLogger.getInstance().log(Event.SUBMITTED, getTitle() + " " + studentID);
            message = "Submitted";
            submitted = true;
        } else if (LocalDate.now().isAfter(LocalDate.of(deadline.getYear(), deadline.getMonth(), deadline.getDay())) && !submitted) {
            AssessmentLogger.getInstance().log(Event.LATE_SUBMISSION, getTitle() + " " + studentID);
            message = "Late submission";
            submitted = true;
        }

        System.out.println(message + " " + getTitle() + " for student " + studentID);
    }
}

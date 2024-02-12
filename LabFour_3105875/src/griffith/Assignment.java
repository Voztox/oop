//Mert Faruk Gunes - 3105875
package griffith;

import java.time.LocalDate;

public class Assignment extends Assessment {
    private Deadline deadline;
    private boolean firstSubmission;

    public Assignment(String title, int mark, Deadline deadline) {
        super(title, mark);
        this.deadline = deadline;
        firstSubmission = true;
    }

    public void submit(int studentID) {
        String message = "";
        //condition for comparing the dates with the current date with deadline date.
        //if its submitted, updated, or late submission.
        if (LocalDate.now().isBefore(LocalDate.of(deadline.getYear(), deadline.getMonth(), deadline.getDay())) && firstSubmission) {
            AssessmentLogger.getInstance().log(Event.SUBMITTED, getTitle() + " " + studentID);
            message = "Submitted";
            firstSubmission = false;
        } else if (LocalDate.now().isBefore(LocalDate.of(deadline.getYear(), deadline.getMonth(), deadline.getDay()))) {
            AssessmentLogger.getInstance().log(Event.UPDATED, getTitle() + " " + studentID);
            message = "Updated";
        } else {
            AssessmentLogger.getInstance().log(Event.LATE_SUBMISSION, getTitle() + " " + studentID);
            message = "Late submission";
        }

        System.out.println(message + " " + getTitle() + " for student " + studentID);
    }
}
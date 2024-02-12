//Mert Faruk Gunes - 3105875
package griffith;

public class Exercise extends Assessment {
    private boolean firstSubmission;

    public Exercise(String title, int mark) {
        super(title, mark);
        firstSubmission = true;
    }

    @Override
    public void submit(int studentID) {
        String message = "";

        if (firstSubmission) {
            AssessmentLogger.getInstance().log(Event.SUBMITTED, getTitle() + " " + studentID);
            message = "Submitted";
            firstSubmission = false;
        } else {
            AssessmentLogger.getInstance().log(Event.UPDATED, getTitle() + " " + studentID);
            message = "Updated";
        }

        System.out.println(message + " " + getTitle() + " for student " + studentID);
    }
}



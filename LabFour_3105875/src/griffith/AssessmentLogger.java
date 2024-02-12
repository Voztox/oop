//Mert Faruk Gunes - 3105875
package griffith;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AssessmentLogger {
    private static final AssessmentLogger INSTANCE = new AssessmentLogger();

    private PrintWriter submittedLog;
    private PrintWriter updatedLog;
    private PrintWriter lateSubmissionLog;

    private AssessmentLogger() {
        try {
            submittedLog = new PrintWriter(new FileWriter("submitted.log"));
            updatedLog = new PrintWriter(new FileWriter("updated.log"));
            lateSubmissionLog = new PrintWriter(new FileWriter("late_submission.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AssessmentLogger getInstance() {
        return INSTANCE;
    }
    //introducing the logs to events.
    public void log(Event event, String message) {
        PrintWriter log = null;

        switch (event) {
            case SUBMITTED:
                log = submittedLog;
                break;
            case UPDATED:
                log = updatedLog;
                break;
            case LATE_SUBMISSION:
                log = lateSubmissionLog;
                break;
        }

        if (log != null) {
            log.println(LocalDateTime.now() + " " + message);
            log.flush();
        }
    }
    //switch case for getting the log. 
    public PrintWriter getLog(Event event) {
        switch (event) {
            case SUBMITTED:
                return submittedLog;
            case UPDATED:
                return updatedLog;
            case LATE_SUBMISSION:
                return lateSubmissionLog;
            default:
                return null;
        }
    }
    //switch case for closing the log for each case.
    public void closeLog(Event event) {
        switch (event) {
            case SUBMITTED:
                submittedLog.close();
                break;
            case UPDATED:
                updatedLog.close();
                break;
            case LATE_SUBMISSION:
                lateSubmissionLog.close();
                break;
        }
    }
}

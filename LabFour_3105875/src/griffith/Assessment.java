//Mert Faruk Gunes - 3105875
package griffith;

public abstract class Assessment {
    private String title;
    private int mark;
    
    //variables and getters with setters.
    public Assessment(String title, int mark) {
        this.title = title;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public abstract void submit(int studentID);
}
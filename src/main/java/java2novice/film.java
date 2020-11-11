package java2novice;

public class film {
    private String title;
    private String des;
    private int year;
    private int duration;

    public film(String title, String des, int year, int duration){
        this.title = title;
        this.des = des;
        this.year = year;
        this.duration = duration;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString(){
        String s = " Title : " + this.title + " Description : " + this.des + " Realease year : " + this.year +
                " Rental duration : " + this.duration ;
        return s;
    }






}

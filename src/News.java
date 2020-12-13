import java.util.Date;
import java.util.*;

public class News extends Observable{
    protected Date publish_date;
    protected Date lastModified_date;
    protected String info;
    protected String author;
    protected int view_count = 0;

    // list of readers

    public News(String info, String author){
        this.publish_date = new Date();
        this.lastModified_date = this.publish_date;
        this.info = info;
        this.author = author;
    }
    public Date getDate(){
        return publish_date;
    }

    public void updateNews(){
        Date currentDate = new Date();

        this.lastModified_date = currentDate;
        setChanged();
        String msg = this.getClass().toString().split(" ")[1] + " published " + publish_date.toString() + " has been modified at " + lastModified_date.toString();
        notifyObservers(msg);
    }

    public void updateViews(){
        view_count++;
        setChanged();
        String msg = this.getClass().toString().split(" ")[1] + " published " + publish_date.toString() + " has been viewed " + view_count + " times";
        notifyObservers(msg);
    }

    public void delete(){
        setChanged();
        String msg = this.getClass().toString().split(" ")[1].toLowerCase()  + " from date " + this.getDate() + " has been deleted";
        notifyObservers(msg);
    }

    public int getViewCount(){

        return view_count;
    }

}
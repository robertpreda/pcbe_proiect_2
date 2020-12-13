import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {

    private String topicOfInterest;

    public Reader(String topicOfInterest){
        this.topicOfInterest = topicOfInterest;
    }

    public void readNews(News news){
        news.updateViews();
    }

    @Override
    public void update(Observable o, Object arg) {


        String topic = ((String)arg).split(" ")[1];
        if(topic.equals(this.topicOfInterest)){

            System.out.println(arg);
        }

    }

    public String getTopicOfInterest(){
        return this.topicOfInterest;
    }
}

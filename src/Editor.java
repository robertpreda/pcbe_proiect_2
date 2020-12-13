import java.io.ObjectStreamClass;
import java.util.*;

public class Editor extends Observable implements Observer{

    @Override
    public void update(Observable news, Object arg) {
        //News news_temp = (News)news;
        System.out.println(arg);
    }


    public void createNews(String category, List<News> lst){
        News temp;
        if(category.equals("sportsnews")){
            temp = new SportsNews("pierde Steaua", "ProTV", "FCSB");
            setChanged();
            String msg = "New " + temp.getClass().toString().toLowerCase().split(" ")[1] + " has been created at: " + temp.getDate();
            //System.out.println(msg);
            notifyObservers(msg);
            lst.add(temp);
            temp.addObserver(this);


        }else if(category.equals("weathernews")){
            temp = new WeatherNews("ninje ", "Busu", "Temeswar");
            setChanged();
            String msg = "New " + temp.getClass().toString().toLowerCase().split(" ")[1] + " has been created at: " + temp.getDate() ;
            //System.out.println(msg);
            notifyObservers(msg);
            lst.add(temp);
            temp.addObserver(this);

        }

    }

    public void deleteNews(List<News> newsList, News toDelete){
        newsList.remove(toDelete);
        toDelete.delete();

    }

    public void editNews(News toEdit){
        toEdit.updateNews();
    }


}

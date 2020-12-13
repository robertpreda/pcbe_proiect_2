import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        List<News> newsList = new LinkedList<News>();

        Reader r1 = new Reader("weathernews");
        Reader r2 = new Reader("sportsnews");
        Reader r3 = new Reader("sportsnews");
        Editor e1 = new Editor();


        System.out.println("Adding observers \n\n\n\n");

        e1.addObserver(r1);
        e1.addObserver(r2);
        e1.addObserver(r3);

        System.out.println("\n\n\n");


        // eveniment: creare stire
        e1.createNews("sportsnews", newsList);
        e1.createNews("weathernews", newsList);

        System.out.println("\n\n\n");

        // eveniment: citire stire
        for(News temp: newsList){

            if(r1.getTopicOfInterest().equals(temp.getClass().toString().toLowerCase().split(" ")[1])){
                r1.readNews(temp);
            }
            if(r2.getTopicOfInterest().equals(temp.getClass().toString().toLowerCase().split(" ")[1])){
                r2.readNews(temp);
            }
            if(r3.getTopicOfInterest().equals(temp.getClass().toString().toLowerCase().split(" ")[1])){
                r3.readNews(temp);
            }
        }

        // eveniment: edit stire

        for(News temp: newsList){
            e1.editNews(temp);
        }

        System.out.println("\n\n\n");
        //eveniment: delete stire

        for(int i=newsList.size()-1;i>=0;i--){

            e1.deleteNews(newsList, newsList.get(i));
        }






    }
}

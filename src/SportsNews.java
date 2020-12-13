public class SportsNews extends News{
    private String team;
    public SportsNews(String info, String author, String team){
        super(info, author);
        this.team = team;
    }
}

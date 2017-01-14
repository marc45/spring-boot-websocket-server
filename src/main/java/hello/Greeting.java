package hello;

public class Greeting {

    private String user;
    private String content;

    public Greeting() {
    }

    public Greeting(String user, String content) {
        this.user = user;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public String getUser() {
        return user;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setUser(String user) {
        this.user = user;
    }

}

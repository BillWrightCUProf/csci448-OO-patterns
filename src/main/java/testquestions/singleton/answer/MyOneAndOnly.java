package testquestions.singleton.answer;

// instance should be a private static variable
//the constructor should be private
public class MyOneAndOnly {
    private static MyOneAndOnly instance;

    private MyOneAndOnly() {}

    public static MyOneAndOnly getInstance() {
        if (instance == null) {
            instance = new MyOneAndOnly();
        }
        return instance;
    }

    public void doSomething() {}

}
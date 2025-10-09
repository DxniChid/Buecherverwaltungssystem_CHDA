public abstract class User {


    protected int id;
    protected String username;


    public User(String username) {

        this.username = username;

    }



    // abstrakte Methode → jede Unterklasse definiert ihr eigenes Menü
    public abstract void showMenu();


}


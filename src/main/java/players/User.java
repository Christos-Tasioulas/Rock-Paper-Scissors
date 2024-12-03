package players;

public abstract class User {

    String currentSelection;

    public User() {
    }

    public String getCurrentSelection() {
        return currentSelection;
    }

    public abstract void select();
}

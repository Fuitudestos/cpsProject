package interfaces;

public interface Player extends /*include*/ Entity
{
    //Observateurs
    public Command getLastCommand();
    public Mob getContent(int x, int y);
    //Pre : -1 <= x <= 1 and (y = -1 or y = 3)
    public Cell getNature(int x, int y);
    //Pre : -1 <= x <= 1 and (y = -1 or y = 3)
    public Cell viewable(int x, int y);
    //Pre : -1 <= x <= 1 and (y = -1 or y = 3)
}

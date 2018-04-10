package interfaces;

public interface Environment extends /*include*/ Map
{
    //Observateurs
    public Mob getCellContent(int x, int y);

    //Operateurs
    public Environment closeDoor(int x, int y);
    //Pre : M.getCellContent(x,y) == null
}

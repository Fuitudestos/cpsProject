package interfaces;

public interface EnvironmentService extends /*include*/ MapService
{
    //Observateurs
    public MotionlessObjectService getCellContent(int x, int y);
    // Pre : 0 <= x <= E.getWidth()
    //and 0 <= y <= E.getHeight()

    //Operateurs
    public void closeDoor(int x, int y);
    //Pre : M.getCellContent(x,y) == null
}

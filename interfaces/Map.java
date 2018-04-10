package interfaces;

public interface Map
{
    //Observateurs
    public int getHeight();
    public int getWidth();
    public Cell getCellNature(int x, int y );// Pre : 0 <= x <= Width && 0 <= y <= Height

    //Constructeur
    public Map init(int w, int h);           // Pre : 0 < w && 0 < h

    //Operateurs
    public Map openDoor(int x, int y);       // Pre : getCellNature(x,y) = DNC || DWC
    public Map closeDoor(int x, int y);      // Pre : getCellNature(x,y) = DNO || DWO

    //Observations

    //Invariants : aucun

    /*init : init(w,h).getHeight() = h
             init(w,h).getWidth() = w
    */

    /*openDoor : M.getCellNature(x,y) = DWC => M.openDoor(x,y).getCellNature(x,y) = DWO
                 M.getCellNature(x,y) = DNC => M.openDoor(x,y).getCellNature(x,y) = DNO
                 for(u = 0; u <= M.getWidth(); u++) for(v = 0; v <= M.getHeight(); v++)
                 with u != x && v != y
                 => M.openDoor(x,y).getCellNature(u,v) = M.getCellNature(u,v)
    */

    /*closeDoor : Similaire a openDoor*/
}

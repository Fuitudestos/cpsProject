package interfaces;

public interface EditMap extends /*refine*/ Map
{
    //Observateurs
    public boolean isReachable(int x1, int y1, int x2, int y2);
    //Pre : M.getCellNature(x1,y1) != Cell.WLL and
    //      M.getCellNature(x2,y2) != Cell.WLL
    public boolean isReady();

    //Operateurs
    public EditMap setNature(int x, int y, Cell cell);
    //Pre : 0 <= x < Width and 0 <= y < Height

    //Observations

    //Invariants :
    /*M.isReachable(x1,y1,x2,y2) = exists P in Array[int,int], P[0] = (x1,y1) and P[size(P)-1] = (x2,y2)
    and forall i in [1;size(P)-1], (P[i-1]=(u,v) and P[i]=(s,t)) implies (u−s) 2 + (v−t) 2 = 1
    and forall i in [1;size(P)-2], P[i-1]=(u,v) implies M.getCellNature(u,v) != Cell.WLL*/

    /*M.isReady() = exists xi,yi,xo,yo in int^4 ,
    M.getCellNature(xi,yi) = Cell.IN and M.getCellNature(xi,yi) = Cell.OUT
    and M.isReachable(xi,yi,xo,yo)
    and forall x,y in int^2 , x != xi or y != yi implies M.getCellNature(x,y) != Cell.IN
    and forall x,y in int^2 , x != xo or y != yo implies M.getCellNature(x,y) != Cell.OUT
    forall x,y in int, M.getCellNature(x,y) ∈ { Cell.DNO, Cell.DNC} implies
    M.getCellNature(x+1,y) = M.getCellNature(x-1,y) = Cell.EMP and
    M.getCellNature(x,y-1) = M.getCellNature(x,y+1) = Cell.WLL
    forall x,y in int, M.getCellNature(x,y) ∈ { Cell.DWO, Cell.DWC} implies
    M.getCellNature(x+1,y) = M.getCellNature(x-1,y) = Cell.WLL and
    M.getCellNature(x,y-1) = M.getCellNature(x,y+1) = Cell.EMP*/

    //setNature :
    /*M.setNature(x,y,whatever).getCellNature(x,y) = whatever
    forall u,v in int^2, u != x or v != y implies M.setNature(x,y,whatever).getCellNature(u,v) = M.getCellNature(u,v)*/
}

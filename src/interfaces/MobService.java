package interfaces;

public interface MobService extends /*include*/ MotionlessObjectService
{
    //Operateurs
    public void forward();
    public void backward();
    public void turnLeft();
    public void turnRight();
    public void strafeLeft();
    public void strafeRight();

    //Observations

    //Invariants

    //0 <= M.getCol() < M.getEnvironment().getWidth()
    //0 <= M.getRow() < M.getEnvironment().getHeight()
    //M.getEnvironment().getCellNature(M.getCol(), M.getRow()) != {WLL, DNC, DWC}

    //Post

    /*Init
    //init(env,x,y,dir).getCol() = x
    //init(env,x,y,dir).getRow() = y
    //init(env,x,y,dir).getDir() = dir
    //init(env,x,y,dir).getEnvironment() = env
    */

    /*Forward
    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) = {EMP, DWO}
    and M.getRow() + 1 < M.getEnvironment().getHeight()
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() +1 ) = Empty
    => M.forward().getRow() = M.getRow() + 1
    and M.forward().getCol() = M.getCol()

    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) != {EMP, DWO}
    or M.getRow() + 1 >= M.getEnvironment().getHeight()
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) != Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) = {EMP, DNO}
    and M.getCol() + 1 < M.getEnvironment().getWidth()
    and M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol() + 1

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) != {EMP, DNO}
    or M.getCol() + 1 >= M.getEnvironment().getWidth()
    or M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) != Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol()

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) = {EMP, DWO}
    and M.getRow() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Empty
    => M.forward().getRow() = M.getRow() - 1
    and M.forward().getCol() = M.getCol()

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) != {EMP, DWO}
    or M.getRow() - 1 < 0
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) != Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) = {EMP, DNO}
    and M.getCol() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol() - 1

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) != {EMP, DNO}
    or M.getCol() - 1 >= 0
    or M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) != Empty
    => M.forward().getRow() = M.getRow()
    and M.forward().getCol() = M.getCol()
    */

    /*Backward
    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) = {EMP, DWO}
    and M.getRow() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Empty
    => M.backward().getRow() = M.getRow() - 1
    and M.backward().getCol() = M.getCol()

    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) != {EMP, DWO}
    or M.getRow() - 1 < 0
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) != Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) = {EMP, DNO}
    and M.getCol() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol() - 1

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) != {EMP, DNO}
    or M.getCol() - 1 < 0
    or M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) != Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol()

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) = {EMP, DWO}
    and M.getRow() + 1 < M.getEnvironment().getHeight()
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) = Empty
    => M.backward().getRow() = M.getRow() + 1
    and M.backward().getCol() = M.getCol()

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) != {EMP, DWO}
    or M.getRow() + 1 >= M.getEnvironment().getHeight()
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) != Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) = {EMP, DNO}
    and M.getCol() + 1 < M.getEnvironment().getWidth()
    and M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol() + 1

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) != {EMP, DNO}
    or M.getCol() + 1 >= M.getEnvironment().getWidth()
    or M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) != Empty
    => M.backward().getRow() = M.getRow()
    and M.backward().getCol() = M.getCol()
    */

    /*strafeL
    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) = {EMP, DNO}
    and M.getCol() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol() - 1

    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) != {EMP, DNO}
    or M.getCol() + 1 < 0
    or M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) != Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) = {EMP, DWO}
    and M.getRow() + 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) = Empty
    => M.strafeL().getRow() = M.getRow() + 1
    and M.strafeL().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) != {EMP, DWO}
    or M.getRow() + 1 < 0
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) != Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol())

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) = {EMP, DNO}
    and M.getCol() + 1 < M.getEnvironment().getWidth()
    and M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol() + 1

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) != {EMP, DNO}
    or M.getCol() + 1 < M.getEnvironment().getWidth()
    or M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) != Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) = {EMP, DWO}
    and M.getRow() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Empty
    => M.strafeL().getRow() = M.getRow() - 1
    and M.strafeL().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) != {EMP, DWO}
    and M.getRow() - 1 < 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) != Empty
    => M.strafeL().getRow() = M.getRow()
    and M.strafeL().getCol() = M.getCol()
    */

    /*strafeR
    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) = {EMP, DNO}
    and M.getCol() + 1 < M.getEnvironment().getWidth()
    and M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) = Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol() + 1

    //M.getDir() = N =>
    M.getEnvironment().getCellNature(M.getCol() + 1, M.getRow()) != {EMP, DNO}
    or M.getCol() + 1 >= M.getEnvironment().getWidth()
    or M.getEnvironment().getCellContent(M.getCol() + 1, M.getRow()) != Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) = {EMP, DWO}
    and M.getRow() - 1 >= 0
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) = Empty
    => M.strafeR().getRow() = M.getRow() - 1
    and M.strafeR().getCol() = M.getCol()

    //M.getDir() = E =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() - 1) != {EMP, DWO}
    or M.getRow() - 1 < 0
    or M.getEnvironment().getCellContent(M.getCol(), M.getRow() - 1) != Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol())

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) = {EMP, DNO}
    and M.getCol() - 1  >= 0
    and M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) = Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol() - 1

    //M.getDir() = S =>
    M.getEnvironment().getCellNature(M.getCol() - 1, M.getRow()) != {EMP, DNO}
    or M.getCol() - 1 < 0
    or M.getEnvironment().getCellContent(M.getCol() - 1, M.getRow()) != Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) = {EMP, DWO}
    and M.getRow() + 1 < M.getEnvironment().getHeight()
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) = Empty
    => M.strafeR().getRow() = M.getRow() + 1
    and M.strafeR().getCol() = M.getCol()

    //M.getDir() = W =>
    M.getEnvironment().getCellNature(M.getCol(), M.getRow() + 1) != {EMP, DWO}
    and M.getRow() + 1 >= M.getEnvironment().getHeight()
    and M.getEnvironment().getCellContent(M.getCol(), M.getRow() + 1) != Empty
    => M.strafeR().getRow() = M.getRow()
    and M.strafeR().getCol() = M.getCol()
    */

    /*turnLeft
    //M.getDir() = N => M.turnLeft().getDir() = W
    //M.getDir() = W => M.turnLeft().getDir() = S
    //M.getDir() = S => M.turnLeft().getDir() = E
    //M.getDir() = E => M.turnLeft().getDir() = N
    */

    /*turnRight
    //M.getDir() = N => M.turnRight().getDir() = E
    //M.getDir() = E => M.turnRight().getDir() = S
    //M.getDir() = S => M.turnRight().getDir() = W
    //M.getDir() = W => M.turnRight().getDir() = N
    */

}

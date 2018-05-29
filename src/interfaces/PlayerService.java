package interfaces;

import implementation.ChestArmor;
import implementation.Helms;
import implementation.LegArmor;
import myType.Cell;
import myType.Command;

public interface PlayerService extends /*include*/ EntityService
{
    //Observateurs
    public Command getLastCommand();
    public MotionlessObjectService getContent(int x, int y);
    //Pre : -1 <= x <= 1 and -1 <= y <= 3
    public Cell getNature(int x, int y);
    //Pre : -1 <= x <= 1 and -1 <= y <= 3
    public Cell isViewable(int x, int y);
    public Cell getViewable(int x, int y);
    //Pre : -1 <= x <= 1 and -1 <= y <= 3

    //Operateurs
    public void setLastCommand(Command command);

    public void addLoot(LootObjectService loot);
    public void takeObject();
    public void drinkPotion();
    public int getNbPotion();

    public void equipHelm(Helms h);
    public void equipChest(ChestArmor ca);
    public void equipLeg(LegArmor la);
    public void equipRightHand(WeaponService w);
    public void equipLeftHand(WeaponService w);

    public void unequipHelm();
    public void unequipChest();
    public void unequipLeg();
    public void unequipRightHand();
    public void unequipLeftHand();

    public ArmorPieceService getHelm();
    public ArmorPieceService getChest();
    public ArmorPieceService getLeg();
    public WeaponService getRightHand();
    public WeaponService getLeftHand();

    //Observations

    //Invariants

    //P.getDir() = N => P.getCellContent(u,v) = P.getEnvironment().getCellContent(P.getCol() + u, P.getRow() + v)
    //P.getDir() = N => P.getCellNature(u,v) = P.getEnvironment().getCellNature(P.getCol() + u, P.getRow() + v)
    //P.getDir() = S => P.getCellContent(u,v) = P.getEnvironment().getCellContent(P.getCol() - u, P.getRow() - v)
    //P.getDir() = S => P.getCellNature(u,v) = P.getEnvironment().getCellNature(P.getCol() - u, P.getRow() - v)
    //P.getDir() = E => P.getCellContent(u,v) = P.getEnvironment().getCellContent(P.getCol() + v, P.getRow() - u)
    //P.getDir() = E => P.getCellNature(u,v) = P.getEnvironment().getCellNature(P.getCol() + v, P.getRow() - u)
    //P.getDir() = W => P.getCellContent(u,v) = P.getEnvironment().getCellContent(P.getCol() - v, P.getRow() + u)
    //P.getDir() = W => P.getCellNature(u,v) = P.getEnvironment().getCellNature(P.getCol() - v, P.getRow() + u)

    //for(u and v in [-1,1] × [-1,1]) ! P.viewable(u,v)
    //P.viewable(-1,2) = P.getCellNature(-1,1) != {WLL, DWC, DNC}
    //P.viewable(0,2) = P.getCellNature(0,1) != {WLL, DWC, DNC}
    //P.viewable(1,2) = P.getCellNature(1,1) != {WLL, DWC, DNC}
    //P.viewable(-1,3) = P.getCellNature(-1,2) != {WLL, DWC, DNC} and P.viewable(-1,2)
    //P.viewable(0,3) = P.getCellNature(0,2) != {WLL, DWC, DNC} and P.viewable(0,2)
    //P.viewable(1,3) = P.getCellNature(1,2) != {WLL, DWC, DNC} and P.viewable(1,2)

    /*Step
    //P.getLastCommand() = FF => P.step() = P.forward()
    //P.getLastCommand() = BB => P.step() = P.backward()
    //P.getLastCommand() = LL => P.step() = P.StrafeLeft()
    //P.getLastCommand() = RR => P.step() = P.strafeRight()
    //P.getLastCommand() = TL => P.step() = P.TurnLeft()
    //P.getLastCommand() = TR => P.step() = P.turnRight()*/
}

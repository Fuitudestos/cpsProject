package decorator;

import implementation.ChestArmor;
import implementation.Helms;
import implementation.LegArmor;
import interfaces.ArmorPieceService;
import interfaces.LootObjectService;
import interfaces.MotionlessObjectService;
import interfaces.PlayerService;
import interfaces.WeaponService;
import myType.Cell;
import myType.Command;

public class PlayerDecorator extends EntityDecorator implements PlayerService
{
    public PlayerDecorator(PlayerService delegate)
    {
        super(delegate);
    }

    public PlayerService getDelegate()
    {
        return (PlayerService) super.getDelegate();
    }

    @Override
    public Command getLastCommand()
    {
        return getDelegate().getLastCommand();
    }

    @Override
    public MotionlessObjectService getContent(int x, int y)
    {
        return getDelegate().getContent(x, y);
    }

    @Override
    public Cell getNature(int x, int y)
    {
        return getDelegate().getNature(x, y);
    }

    @Override
    public Cell isViewable(int x, int y)
    {
        return getDelegate().isViewable(x, y);
    }

    @Override
    public Cell getViewable(int x, int y)
    {
        return getDelegate().getViewable(x, y);
    }

    @Override
    public void setLastCommand(Command command)
    {
        getDelegate().setLastCommand(command);
    }

    @Override
    public void takeObject()
    {
        getDelegate().takeObject();
    }

    @Override
    public void drinkPotion()
    {
        getDelegate().drinkPotion();
    }

    @Override
    public int getNbPotion()
    {
        return getDelegate().getNbPotion();
    }

    @Override
    public void equipHelm(Helms h)
    {
        getDelegate().equipHelm(h);
    }

    @Override
    public void equipChest(ChestArmor ca)
    {
        getDelegate().equipChest(ca);
    }

    @Override
    public void equipLeg(LegArmor la)
    {
        getDelegate().equipLeg(la);
    }

    @Override
    public void equipRightHand(WeaponService w)
    {
        getDelegate().equipRightHand(w);
    }

    @Override
    public void equipLeftHand(WeaponService w)
    {
        getDelegate().equipLeftHand(w);
    }

    @Override
    public void unequipHelm()
    {
        getDelegate().unequipHelm();
    }

    @Override
    public void unequipChest()
    {
        getDelegate().unequipChest();
    }

    @Override
    public void unequipLeg()
    {
        getDelegate().unequipLeg();
    }

    @Override
    public void unequipRightHand()
    {
        getDelegate().unequipRightHand();
    }

    @Override
    public void unequipLeftHand()
    {
        getDelegate().unequipLeftHand();
    }

    @Override
    public ArmorPieceService getHelm()
    {
        return getDelegate().getHelm();
    }

    @Override
    public ArmorPieceService getChest()
    {
        return getDelegate().getChest();
    }

    @Override
    public ArmorPieceService getLeg()
    {
        return getDelegate().getLeg();
    }

    @Override
    public WeaponService getRightHand()
    {
        return getDelegate().getRightHand();
    }

    @Override
    public WeaponService getLeftHand()
    {
        return getDelegate().getLeftHand();
    }
    
    @Override
    public void addLoot(LootObjectService loot)
    {
    	getDelegate().addLoot(loot);
    }
}

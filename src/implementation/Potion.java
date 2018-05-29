package implementation;

import interfaces.PotionService;

public class Potion implements PotionService
{
    protected boolean isEmpty;

    public Potion()
    {
    	isEmpty = true;
    }

    public boolean isFull()
    {
        return !isEmpty;
    }

    public void getDrinked()
    {
        isEmpty = true;
    }

    public void getFilled()
    {
        isEmpty = false;
    }
}

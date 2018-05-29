package decorator;

import interfaces.PotionService;

public class PotionDecorator implements PotionService
{
    private PotionService delegate;

    public PotionDecorator(PotionService delegate)
    {
        this.delegate = delegate;
    }

    protected PotionService getDelegate()
    {
        return delegate;
    }

    @Override
    public boolean isFull()
    {
        return delegate.isFull();
    }

    @Override
    public void getDrinked()
    {
        delegate.getDrinked();
    }

    @Override
    public void getFilled()
    {
        delegate.getDrinked();
    }

}

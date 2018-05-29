package interfaces;

public interface CowService extends /*include*/ EntityService
{
    //Pre : 3<=hp<=4

    //Observations

    //Step
    //env.getCol() - 1 <= env.step().getCol() <= env.getCol() + 1
    //env.getRow() - 1 <= env.step().getRow() <= env.getRow() + 1
}

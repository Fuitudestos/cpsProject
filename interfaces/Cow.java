package interfaces;

public interface Cow extends /*include*/ Entity
{
    //Constructeur
    public Cow init(Environment env, int x, int y, Dir dir, int hp);
    //Pre : 3<=hp<=4

    //Observations

    //Step
    //env.getCol() - 1 <= env.step().getCol() <= env.getCol() + 1
    //env.getRow() - 1 <= env.step().getRow() <= env.getRow() + 1
}

package interfaces;

public interface PotionService extends /*include*/ LootObjectService
{
    //Observateurs
    public boolean isFull();

    //Operateurs
    public void getDrinked();
    //Pre : P.isFull() = T

    public void getFilled();

    //Observation

    //Post

    /*getDrinked
    //P.getDrinked().isFull() = F
    */

    /*getFilled
    P.isFull() = T => P.getFilled().isFull() = T
    P.isFull() = F => P.getFilled().isFull() = T
    */
}

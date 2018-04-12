package contrat;

import interfaces.Map;
import decorator.MapDecorator;

public class MapContrat extends MapDecorator
{
    Random rand;

    public MapContrat(Map delegate)
    {
        super(delegate);
        rand = new Random();
    }

    public void checkInvariant()
    {}

    public Map openDoor(int x, int y)
    {
        int i;
        Cell current;
        ArrayList<Int> randomX = new ArrayList<Int>();
        ArrayList<Int> randomY = new ArrayList<Int>();
        ArrayList<Cell> randomCell = new ArrayList<Cell>();

        current = getCellNature(x,y);

        for(i = 0; i < 3; i++)
        {
            randomX.add(rand.nextInt(getWidth()));
            randomY.add(rand.nextInt(getHeight()));
            randomCell.add(getCellNature(randomX.get(i)), getCellNature(randomY.get(i)));
        }

        //Pre
        if(current != Cell.DNC || current != Cell.DWC)
        {
            Contractor.defaultContractor().preconditionError("Map","openDoor","La cellule n'est pas une porte fermer");
        }

        checkInvariant();
        super.openDoor(x,y);
        checkInvariant();

        //Post
        if(current == Cell.DNC && getCellNature(x,y) != Cell.DNO)
        {
            Contractor.defaultContractor().postconditionError("Map","openDoor","La porte ne c'est pas ouverte");
        }

        if(current == Cell.DWC && getCellNature(x,y) != Cell.DWO)
        {
            Contractor.defaultContractor().postconditionError("Map","openDoor","La porte ne c'est pas ouverte");
        }

        for(i = 0; i < 3; i++)
        {
            if(randomCell(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("Map","openDoor","Une cellule autre que current a changer");
                break;
            }
        }
    }

    public Map closeDoor(int x, int y)
    {
        int i;
        Cell current;
        ArrayList<Int> randomX = new ArrayList<Int>();
        ArrayList<Int> randomY = new ArrayList<Int>();
        ArrayList<Cell> randomCell = new ArrayList<Cell>();

        current = getCellNature(x,y);

        for(i = 0; i < 3; i++)
        {
            randomX.add(rand.nextInt(getWidth()));
            randomY.add(rand.nextInt(getHeight()));
            randomCell.add(getCellNature(randomX.get(i)), getCellNature(randomY.get(i)));
        }

        //Pre
        if(current != Cell.DNO || current != Cell.DWO)
        {
            Contractor.defaultContractor().preconditionError("Map","closeDoor","La cellule n'est pas une porte ouverte");
        }

        checkInvariant();
        super.openDoor(x,y);
        checkInvariant();

        //Post
        if(current == Cell.DNO && getCellNature(x,y) != Cell.DNC)
        {
            Contractor.defaultContractor().postconditionError("Map","closeDoor","La porte ne c'est pas fermer");
        }

        if(current == Cell.DWO && getCellNature(x,y) != Cell.DWC)
        {
            Contractor.defaultContractor().postconditionError("Map","closeDoor","La porte ne c'est pas fermer");
        }

        for(i = 0; i < 3; i++)
        {
            if(randomCell(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("Map","closeDoor","Une cellule autre que current a changer");
                break;
            }
        }
    }
}

package contrat;

import interfaces.MapService;
import myType.Cell;

import java.util.ArrayList;
import java.util.Random;

import decorator.MapDecorator;
import exception.Contractor;

public class MapContract extends MapDecorator implements MapService
{
    Random rand;

    public MapContract(MapService delegate)
    {
        super(delegate);
        rand = new Random();
    }

    public void checkInvariant()
    {}

    @Override
    public int getWidth()
    {
        return super.getWidth();
    }

    @Override
    public int getHeight()
    {
        return super.getHeight();
    }

    @Override
    public Cell getCellNature(int x, int y)
    {
        if(x < 0 || x > getWidth())
        {
            Contractor.defaultContractor().preconditionError("Map","init","La largeur entrée n'est pas dans la map");
        }
        if(y < 0 || y > getHeight())
        {
            Contractor.defaultContractor().preconditionError("Map","init","La hauteur entrée n'est pas dans la map");
        }

        return super.getCellNature(x, y);
    }

    @Override
    public void init(int width, int height)
    {
        //Pre
        if(height <= 0)
        {
            Contractor.defaultContractor().preconditionError("Map","init","La hauteur de la map est négative ou nul");
        }
        if(width <= 0)
        {
            Contractor.defaultContractor().preconditionError("Map","init","La largeur de la map est négative ou nul");
        }

        checkInvariant();
        super.init(width, height);
        checkInvariant();

        if(getWidth() != width)
        {
            Contractor.defaultContractor().postconditionError("Map","init","La largeur n'est pas celle entrée");
        }
        if(getHeight() != height)
        {
            Contractor.defaultContractor().postconditionError("Map","init","La hauteur n'est pas celle entrée");
        }
    }

    @Override
    public void openDoor(int x, int y)
    {
        int i;
        Cell current;
        ArrayList<Integer> randomX = new ArrayList<Integer>();
        ArrayList<Integer> randomY = new ArrayList<Integer>();
        ArrayList<Cell> randomCell = new ArrayList<Cell>();

        current = getCellNature(x,y);

        for(i = 0; i < 3; i++)
        {
            randomX.add(rand.nextInt(getWidth()));
            randomY.add(rand.nextInt(getHeight()));
            randomCell.add(getCellNature(randomX.get(i), randomY.get(i)));
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
            if(randomCell.get(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("Map","openDoor","Une cellule autre que current a changer");
                break;
            }
        }
    }

    public void closeDoor(int x, int y)
    {
        int i;
        Cell current;
        ArrayList<Integer> randomX = new ArrayList<Integer>();
        ArrayList<Integer> randomY = new ArrayList<Integer>();
        ArrayList<Cell> randomCell = new ArrayList<Cell>();

        current = getCellNature(x,y);

        for(i = 0; i < 3; i++)
        {
            randomX.add(rand.nextInt(getWidth()));
            randomY.add(rand.nextInt(getHeight()));
            randomCell.add(getCellNature(randomX.get(i), randomY.get(i)));
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
            if(randomCell.get(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("Map","closeDoor","Une cellule autre que current a changer");
                break;
            }
        }
    }
}

package contrat;

import interfaces.EditMap;
import decorator.EditMapDecorator;

public class EditMapContract extends EditMapDecorator
{
    Random rand;

    public EditMapContract(EditMap delegate)
    {
        super(delegate);
        rand = new Random();
    }

    public void checkInvariant()
    {

    }

    public boolean isReachable(int x1, int y1, int x2, int y2)
    {
        if(getCellNature(x1,y1) == Cell.WLL)
        {
            Contractor.defaultContractor().preconditionError("EditMap","isReachable","L'entrée est un mur");
        }

        if(getCellNature(x2,y2) == Cell.WLL)
        {
            Contractor.defaultContractor().preconditionError("EditMap","isReachable","La sortie est un mur");
        }
    }

    public boolean isReady()
    {

    }

    public EditMap setNature(int x, int y, Cell cell)
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

        if(0 > x || getWidth() < x)
        {
            Contractor.defaultContractor().preconditionError("EditMap","setNature","Coordonnées x incorrect");
        }

        if(0 > y || getHeight() < y)
        {
            Contractor.defaultContractor().preconditionError("EditMap","setNature","Coordonnées y incorrect");
        }

        checkInvariant();
        super.setNature(x,y,cell);
        checkInvariant();

        if(getCellNature(x, y) != cell)
        {
            Contractor.defaultContractor().postconditionError("EditMap","setNature","La cellule ne c'est pas modifié correctement");
        }

        for(i = 0; i < 3; i++)
        {
            if(randomCell(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("EditMap","setNature","Une cellule autre que current a changer");
                break;
            }
        }
    }
}

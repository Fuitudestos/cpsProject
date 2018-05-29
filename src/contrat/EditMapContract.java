package contrat;

import interfaces.EditMapService;
import myType.Cell;

import java.util.ArrayList;
import java.util.Random;

import exception.Contractor;

public class EditMapContract extends MapContract implements EditMapService
{
    Random rand;

    public EditMapContract(EditMapService delegate)
    {
        super(delegate);
        rand = new Random();
    }

    protected EditMapService getDelegate()
    {
    	return (EditMapService) super.getDelegate();
    }

    public void checkInvariant()
    {
        super.checkInvariant();

        int x,y;
        int nbIn = 0;
        int nbOut = 0;
        int xIn = 0;
        int yIn = 0;
        int xOut =0;
        int yOut = 0;
        
        if(isReady())
        {
        	for(x = 0; x < getWidth(); x++)
        	{
        		for(y = 0; y < getHeight(); y++)
        		{
        			if(getCellNature(x, y) == Cell.IN)
        			{
        				nbIn++;
        				xIn = x;
        				yIn = y;
        			}
        			if(getCellNature(x, y) == Cell.OUT)
        			{
        				nbOut++;
        				xOut = x;
        				yOut = y;
        			}
        		}
        	}
        	
        	if(nbIn != 1)Contractor.defaultContractor().invariantError("EditMap", "Pas le bon nombre d'entrée");
        	if(nbOut != 1)Contractor.defaultContractor().invariantError("EditMap", "Pas le bon nombre de sortie");
        	if(!isReachable(xIn, yIn, xOut, yOut))Contractor.defaultContractor().invariantError("EditMap", "La sortie n'est pas ateignable depuis l'entrée");
        }

        for(x = 0; x < getWidth(); x++)
        {
            for(y = 0; y < getHeight(); y++)
            {
                if(getCellNature(x, y) == Cell.DNO || getCellNature(x, y) == Cell.DNC)
                {
                    if(getCellNature(x + 1, y) != getCellNature(x - 1, y) || getCellNature(x + 1, y) != Cell.EMP)
                    {
                        Contractor.defaultContractor().invariantError("EditMap", "Je ne peut pas sortir");
                    }
                    if(getCellNature(x, y + 1) != getCellNature(x, y - 1) || getCellNature(x, y + 1) != Cell.WLL)
                    {
                    	Contractor.defaultContractor().invariantError("EditMap", "La porte flote dans les air");
                    }
                }
                
                if(getCellNature(x, y) == Cell.DWO || getCellNature(x, y) == Cell.DWC)
                {
                    if(getCellNature(x + 1, y) != getCellNature(x - 1, y) || getCellNature(x + 1, y) != Cell.WLL)
                    {
                    	Contractor.defaultContractor().invariantError("EditMap", "La porte flote dans les air");
                    }
                    if(getCellNature(x, y + 1) != getCellNature(x, y - 1) || getCellNature(x, y + 1) != Cell.EMP)
                    {
                    	Contractor.defaultContractor().invariantError("EditMap", "Je ne peut pas sortir");
                    }
                }
            }
        }
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

        checkInvariant();
        boolean res = getDelegate().isReachable(x1,x2,y1,y2);
        checkInvariant();

        return res;
    }

    public boolean isReady()
    {
        checkInvariant();
        boolean res = getDelegate().isReady();
        checkInvariant();

        return res;
    }

    public void setNature(int x, int y, Cell cell)
    {
    	if(0 > x || getWidth() < x)
        {
            Contractor.defaultContractor().preconditionError("EditMap","setNature","Coordonnées x incorrect");
        }

        if(0 > y || getHeight() < y)
        {
            Contractor.defaultContractor().preconditionError("EditMap","setNature","Coordonnées y incorrect");
        }

        int i;
        ArrayList<Integer> randomX = new ArrayList<Integer>();
        ArrayList<Integer> randomY = new ArrayList<Integer>();
        ArrayList<Cell> randomCell = new ArrayList<Cell>();

        for(i = 0; i < 3; i++)
        {
            randomX.add(rand.nextInt(getWidth()));
            randomY.add(rand.nextInt(getHeight()));
            randomCell.add(getCellNature(randomX.get(i), randomY.get(i)));
        }

        checkInvariant();
        getDelegate().setNature(x,y,cell);
        checkInvariant();

        if(getCellNature(x, y) != cell)
        {
            Contractor.defaultContractor().postconditionError("EditMap","setNature","La cellule ne c'est pas modifié correctement");
        }

        for(i = 0; i < 3; i++)
        {
            if(randomCell.get(i) != getCellNature(randomX.get(i), randomY.get(i)) && (randomX.get(i) != x || randomY.get(i) != y))
            {
                Contractor.defaultContractor().postconditionError("EditMap","setNature","Une cellule autre que current a changer");
            }
        }
    }
}

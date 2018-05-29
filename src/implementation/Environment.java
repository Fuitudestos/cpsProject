package implementation;

import java.util.ArrayList;

import interfaces.EnvironmentService;
import interfaces.MobService;

public class Environment extends Map implements EnvironmentService
{
    private ArrayList<ArrayList<MobService>> content;

    public void init(int width, int height)
    {
        super.init(width, height);

        ArrayList<MobService> tmp = new ArrayList<MobService>();
        content = new ArrayList<ArrayList<MobService>>();

        for(int x = 0; x < width; x++)
        {
            tmp.add(null);
            for(int y = 0; y < height; y++)
            {
                content.add(tmp);
            }
        }
    }

    @Override
    public MobService getCellContent(int x, int y)
    {
        return content.get(y).get(x);
    }
}

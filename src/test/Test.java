package test;

import contrat.EnvironmentContract;
import contrat.MimicContract;
import contrat.PlayerContract;
import implementation.Environment;
import implementation.Mimic;
import implementation.Player;
import myType.Dir;

public class Test
{
    public static void main(String[] args)
    {
        /*MapContract map = new MapContract(new Map());
        map.init(5,5);*/
        
        EnvironmentContract env = new EnvironmentContract(new Environment());
        env.init(5, 5);
        
        PlayerContract player = new PlayerContract(new Player());
        player.init(env, 1, 1, Dir.N, 50, 180);
        
        MimicContract mimic = new MimicContract(new Mimic());
        mimic.init(env, 1, 2, Dir.S, 10);
        
        player.takeObject();
    }
}

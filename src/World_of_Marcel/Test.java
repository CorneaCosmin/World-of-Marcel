package World_of_Marcel;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) {
        Game game=Game.getInstance();
        try
        {
            game.run();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Fisierul nu a fost gasit!");
        }
        catch (IOException e)
        {
            System.err.println("Eroare la citirea din fisier!");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

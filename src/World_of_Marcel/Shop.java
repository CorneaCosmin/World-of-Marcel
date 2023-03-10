package World_of_Marcel;

import java.util.LinkedList;
import java.util.Random;

public class Shop implements CellElement
{
    LinkedList<Potion> potions;
    Random rand=new Random();
    public Shop()
    {
        potions=new LinkedList<Potion>();
        int nrAbilities= rand.nextInt(5-2)+2,contor=0;
        while(contor!=nrAbilities)
        {
            int val= rand.nextInt(2);
            if(val==0)
            {
                potions.add(new HealthPotion());
            }
            if(val==1)
            {
                potions.add(new ManaPotion());
            }
            contor++;
        }
    }
    @Override
    public char toCharacter() {
        return 'S';
    }

    Potion selectPotion(int index)
    {
        Potion potion=potions.get(index);
        potions.remove(index);
        return potion;
    }
}

package World_of_Marcel;

import java.util.LinkedList;

public class Inventory
{
    LinkedList<Potion> potions;
    int maxWeight;
    int currentWeight;
    int coins;
    public Inventory()
    {
        coins=0;
        currentWeight=0;
        potions=new LinkedList<Potion>();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "potions=" + potions +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                ", coins=" + coins +
                '}';
    }

    void addPotions(Potion potion)
    {
        if(currentWeight+potion.weightPotion()>maxWeight && coins>potion.pricePotion())
            return;
        else
        {
            potions.add(potion);
            coins-=potion.pricePotion();
            currentWeight+=potion.weightPotion();
        }
    }
    void removePotions(Potion potion)
    {
        if(potions==null)
            return;
        potions.remove(potion);
        currentWeight-=potion.weightPotion();
    }
    int calculateWeight()
    {
        return maxWeight-currentWeight;
    }
}

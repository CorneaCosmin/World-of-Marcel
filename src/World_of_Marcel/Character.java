package World_of_Marcel;

public abstract class Character extends Entity
{
    int nrEnemies=0;
    String name;
    int currentOx,currentOy;
    Inventory inventory;
    int experience;
    int level;
    int strength,charisma,dexterity;
    void buy(Potion potion)
    {
        if(inventory.coins>=potion.pricePotion()&&inventory.calculateWeight()>=potion.weightPotion())
        {
            inventory.coins-= potion.pricePotion();
            inventory.addPotions(potion);
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", currentLife=" + currentLife +
                ", currentManna=" + currentManna +
                ", inventory=" + inventory +
                ", abilities=" + abilities +
                ", ice=" + ice +
                ", fire=" + fire +
                ", earth=" + earth;
    }
}

class CharacterFactory
{
    public static Character factory(String charcaterName,String name, int level, int experience)
    {
        if(charcaterName.equals("Warrior"))
            return new Warrior(name,level,experience);
        if(charcaterName.equals("Rogue"))
            return new Rogue(name,level,experience);
        if(charcaterName.equals("Mage"))
            return new Mage(name,level,experience);
        return null;
    }
}

package World_of_Marcel;

import java.util.LinkedList;

public abstract class Entity implements Element
{
    LinkedList<Spell> abilities=new LinkedList<Spell>();
    int maxLife,currentLife;
    int maxManna,currentManna;
    boolean ice,fire,earth;
    abstract void receiveDamage(int damage);
    abstract int getDamage();
    void regenerateLife(int value)
    {
        if(currentLife+value>maxLife)
            currentLife=maxLife;
        else currentLife+=value;
    }
    void regenerateManna(int value)
    {
        if(currentManna+value>maxManna)
            currentManna=maxManna;
        else currentManna+=value;
    }

    void useAbility(Spell ability,Enemy enemy)
    {
        if(ability.costManna<currentManna)
        {
            enemy.receiveDamage(ability.damage);
            currentManna-=ability.costManna;
        }
    }
}

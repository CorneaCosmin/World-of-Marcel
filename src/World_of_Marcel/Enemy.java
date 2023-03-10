package World_of_Marcel;
import java.util.LinkedList;
import java.util.Random;

public class Enemy extends Entity implements CellElement
{
    Random rand=new Random();
    public Enemy()
    {
        maxLife= rand.nextInt(5000-1000)+1000;
        currentLife=maxLife;
        maxManna= rand.nextInt(1000-100)+100;
        currentManna=maxManna;
        this.ice=rand.nextBoolean();
        this.fire= rand.nextBoolean();
        this.earth= rand.nextBoolean();
        int nrAbilities= rand.nextInt(5-2)+2,contor=0;
        Fire fire=new Fire();
        fire.setCostManna();
        fire.setDamage();
        Ice ice=new Ice();
        ice.setCostManna();
        ice.setDamage();
        Earth earth=new Earth();
        earth.setCostManna();
        earth.setDamage();
        while(contor!=nrAbilities)
        {
            int val= rand.nextInt(3);
            if(val==0)
            {
                abilities.add(fire);
            }
            if(val==1)
            {
                abilities.add(ice);
            }
            if(val==2)
            {
                abilities.add(earth);
            }
            contor++;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Enemy: " +
                ", currentLife=" + currentLife +
                ", currentManna=" + currentManna +
                ", abilities=" + abilities +
                ", ice=" + ice +
                ", fire=" + fire +
                ", earth=" + earth;
    }

    @Override
    int getDamage()
    {
        int damage= rand.nextInt(500);
        int hit= rand.nextInt(1);
        if(hit==1)
            return 2*damage;
        return damage;
    }

    @Override
    void receiveDamage(int damage)
    {
        Random rand1=new Random();
        int avoid= rand1.nextInt(1);
        if(avoid==0)
            currentLife=currentLife-damage;
    }

    @Override
    void regenerateLife(int value) {
        super.regenerateLife(value);
    }

    @Override
    void regenerateManna(int value) {
        super.regenerateManna(value);
    }

    @Override
    void useAbility(Spell ability, Enemy enemy) {
        super.useAbility(ability, enemy);
    }

    @Override
    public char toCharacter() {
        return 'E';
    }

}

package World_of_Marcel;

import java.util.Random;

public class Mage extends Character
{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Mage(String name, int level, int experience)
    {
        currentOx=0;
        currentOy=0;
        Random rand=new Random();
        maxLife= rand.nextInt(5000-1000)+1000;
        currentLife=maxLife;
        maxManna= rand.nextInt(1000-100)+100;
        currentManna=maxManna;
        inventory=new Inventory();
        this.name=name;
        this.experience=experience;
        this.level=level;
        fire=false;
        ice=true;
        earth=false;
        strength=25+level*5;
        charisma=75+level*5;
        dexterity=50+level*5;
        inventory.maxWeight=2000;
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

    int getDamage()
    {
        Random rand=new Random();
        int high=charisma+charisma/2;
        int low=charisma-charisma/2;
        int check=rand.nextInt(high-low)+low;
        int damage=(charisma+(strength+dexterity)/4)*level/2;
        if(charisma>check)
            damage*=2;
        return damage;
    }

    void receiveDamage(int damage)
    {
        Random rand=new Random();
        int high=(strength+dexterity)+(strength+dexterity)/2;
        int low=(strength+dexterity)-(strength+dexterity)/2;
        int check=rand.nextInt(high-low)+low;
        if(strength+dexterity>check)
            damage/=2;
        currentLife-=damage;
    }

}

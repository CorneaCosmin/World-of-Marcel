package World_of_Marcel;

public class Fire extends Spell
{
    @Override
    void setDamage() {
        damage=850;
    }

    @Override
    public String toString() {
        return "Fire: damage=" + damage +
                ", costManna=" + costManna;
    }

    @Override
    public void visit(Entity entity) {
        if(entity.fire==true)
            damage=0;
    }

    @Override
    void setCostManna() {
        costManna=200;
    }
}

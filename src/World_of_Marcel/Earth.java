package World_of_Marcel;

public class Earth extends Spell
{
    @Override
    void setDamage() {
        damage=550;
    }

    @Override
    public String toString() {
        return "Earth: damage=" + damage +
                ", costManna=" + costManna;
    }

    @Override
    public void visit(Entity entity) {
        if(entity.earth==true)
            damage=0;
    }

    @Override
    void setCostManna() {
        costManna=100;
    }
}

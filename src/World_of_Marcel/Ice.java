package World_of_Marcel;

public class Ice extends Spell
{
    @Override
    void setDamage() {
        damage=700;
    }

    @Override
    public String toString() {
        return "Ice: damage=" + damage +
                ", costManna=" + costManna;
    }

    @Override
    public void visit(Entity entity) {
        if(entity.ice==true)
            damage=0;
    }

    @Override
    void setCostManna() {
        costManna=150;
    }
}

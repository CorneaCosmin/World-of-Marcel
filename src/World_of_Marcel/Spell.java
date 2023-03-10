package World_of_Marcel;

public abstract class Spell implements Visitor
{
    int damage;
    int costManna;
    abstract void setDamage();
    abstract void setCostManna();
}

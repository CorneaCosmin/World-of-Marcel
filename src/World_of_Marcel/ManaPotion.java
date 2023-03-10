package World_of_Marcel;

public class ManaPotion implements Potion
{
    private int price,weight,valueRegenerate;

    public ManaPotion()
    {
        price=350;
        weight=750;
        valueRegenerate=200;
    }

    @Override
    public String toString() {
        return "ManaPotion: " +
                "price=" + price +
                ", weight=" + weight +
                ", valueRegenerate=" + valueRegenerate;
    }

    @Override
    public void usePotion(Character character)
    {
        character.regenerateManna(valueRegenerate);
        character.inventory.removePotions(this);
    }

    @Override
    public int pricePotion() {
        return price;
    }

    @Override
    public int valueRegenerate() {
        return valueRegenerate;
    }

    @Override
    public int weightPotion() {
        return weight;
    }
}

package World_of_Marcel;

public class HealthPotion implements Potion
{
    private int price,weight,valueRegenerate;

    public HealthPotion()
    {
        price=250;
        weight=1000;
        valueRegenerate=1000;
    }

    @Override
    public String toString() {
        return "HealthPotion: " +
                "price=" + price +
                ", weight=" + weight +
                ", valueRegenerate=" + valueRegenerate;
    }

    @Override
    public void usePotion(Character character)
    {
        character.regenerateLife(valueRegenerate);
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

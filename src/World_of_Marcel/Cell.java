package World_of_Marcel;

public class Cell
{
    int ox;
    int oy;
    enum Type
    {
        EMPTY, ENEMY, SHOP, FINISH
    }
    CellElement element;
    boolean visited;
    String story;
    public Cell(int ox,int oy,CellElement element)
    {
        this.visited=false;
        this.ox=ox;
        this.oy=oy;
        this.element=element;
    }
}

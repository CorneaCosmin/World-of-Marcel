package World_of_Marcel;

public interface Visitor<T extends Entity>
{
    void visit(T entity);
}

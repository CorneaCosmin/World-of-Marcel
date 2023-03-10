package World_of_Marcel;

import World_of_Marcel.Entity;
import World_of_Marcel.Visitor;

public interface Element<T extends Entity>
{
    void accept(Visitor<T> visitor);
}

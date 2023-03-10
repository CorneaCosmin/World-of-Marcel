package World_of_Marcel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

public class Grid extends ArrayList<ArrayList<Cell>>
{
    int startOx,startOy;
    int length,width;
    Character player;
    Cell current;
    static Grid map=null;
    private Grid(int length,int width,Character player,Cell current,int startOx,int startOy)
    {
        this.current=current;
        this.player=player;
        this.length=length;
        this.width=width;
        this.startOx=startOx;
        this.startOy=startOy;
    }
    public static Grid generateMap(int length,int width,Character player,Cell current,int startOx,int startOy)  //de facut random
    {
        Random random=new Random();
        int numberShops= random.nextInt(length-2)+2;
        int numberEnemies= random.nextInt(width-4)+4;
        int count;
        Vector<Integer> oxShops=new Vector<>();
        Vector<Integer> oyShops=new Vector<>();
        Vector<Integer> oxEnemies=new Vector<>();
        Vector<Integer> oyEnemies=new Vector<>();
        for(count=0;count<numberShops;count++)
        {
            oxShops.add(random.nextInt(length));
            oyShops.add(random.nextInt(width));
        }
        for(count=0;count<numberEnemies;count++)
        {
            oxEnemies.add(random.nextInt(length));
            oyEnemies.add(random.nextInt(width));
        }
        if(map==null)
        {
            map=new Grid(length,width,player,current,startOx,startOy);
            int i,j;
            for(i=0;i<length;i++)
            {
                map.add(i,new ArrayList<Cell>());
                for(j=0;j<width;j++)
                {
                    if(i==startOx&&j==startOy)
                    {
                        map.get(i).add(j,new Cell(i, j, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'N';
                            }}));
                        map.get(i).get(j).visited=true;
                        map.current=map.get(i).get(j);
                    }
                    else {
                        map.get(i).add(j,new Cell(i, j, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'N';
                            }
                        }));
                        for(int k=0;k<numberShops;k++)
                        {
                            if(i==oxShops.get(k)&&j==oyShops.get(k))
                            {
                                map.get(i).set(j,new Cell(i,j,new Shop()));
                            }
                        }
                        for (int l=0;l<numberEnemies;l++)
                        {
                            if(i==oxEnemies.get(l)&&j==oyEnemies.get(l))
                            {
                                map.get(i).set(j, new Cell(i, j, new Enemy()));
                            }
                        }
                    }
                }
            }
            int checkfinal=0;
            while(checkfinal==0)
            {
                int oxFinal= random.nextInt(length);
                int oyFinal= random.nextInt(width);
                if(map.get(oxFinal).get(oyFinal).element.toCharacter()=='N' && oxFinal!=startOx && oyFinal!=startOy)
                {
                    map.get(oxFinal).set(oyFinal,new Cell(oxFinal, oyFinal, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'F';
                            }
                        }));
                    checkfinal=1;
                }
            }
        }
        return map;
    }

    public static Grid generateMapHardcoded(int length,int width,Character player,Cell current)
    {
        if(map==null)
        {
            map=new Grid(length,width,player,current,0,0);  //de creat mapa
            int i,j;
            for(i=0;i<length;i++)
            {
                map.add(i,new ArrayList<Cell>());
                for(j=0;j<width;j++)
                {
                    if(i==0&&j==0)
                    {
                        map.get(i).add(j,new Cell(i, j, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'N';
                            }}));
                        map.get(i).get(j).visited=true;
//                        current=map.get(i).get(j);
                    }
                    else if((i==0&&j==3)||(i==1&&j==3)||(i==2&&j==0))
                    {
                        map.get(i).add(j,new Cell(i,j,new Shop()));
                    }
                    else if((i==3&&j==4)||(i==2&&j==2)||(i==1&&j==1)||(i==2&&j==3))
                        map.get(i).add(j,new Cell(i,j,new Enemy()));
                    else if(i==4&&j==4)
                        map.get(i).add(j,new Cell(i, j, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'F';
                            }
                        }));
                    else map.get(i).add(j,new Cell(i, j, new CellElement() {
                            @Override
                            public char toCharacter() {
                                return 'N';
                            }
                        }));
                }
            }
        }
        return map;
    }

    void addStories(LinkedList<LinkedList<String>>stories)
    {
        Random rand=new Random();
        int i,j;
        for(i=0;i<length;i++)
            for(j=0;j<width;j++)
            {
                if (map.get(i).get(j).element.toCharacter() == 'N')
                    map.get(i).get(j).story = stories.get(0).get(rand.nextInt(stories.get(0).size()));
                if (map.get(i).get(j).element.toCharacter() == 'E')
                    map.get(i).get(j).story = stories.get(1).get(rand.nextInt(stories.get(1).size()));
                if (map.get(i).get(j).element.toCharacter() == 'S')
                    map.get(i).get(j).story = stories.get(2).get(rand.nextInt(stories.get(2).size()));
                if (map.get(i).get(j).element.toCharacter() == 'F')
                    map.get(i).get(j).story = stories.get(3).get(rand.nextInt(stories.get(3).size()));
//                System.out.println(map.get(i).get(j).story);
            }
    }

    void printMap()
    {
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<width;j++)
                if(map.current.ox==i && map.current.oy==j)
                    System.out.print("P"+map.get(i).get(j).element.toCharacter()+" ");
                else
                    if(map.get(i).get(j).visited==true)
                        System.out.print(map.get(i).get(j).element.toCharacter()+" ");
                    else System.out.print("? ");
            System.out.println("");
        }
    }

    void setCurrent(Cell current)
    {
        map.current=current;
    }

    void goNorth()
    {
        if(map.get(map.current.ox).get(map.current.oy).ox-1<0)
            System.out.println("Nu se poate deplasa la nord!");
        else
        {
            map.current = map.get(map.current.ox-1).get(map.current.oy);
            map.player.currentOx=map.current.ox;
        }

    }

    void goSouth()
    {
        if(map.get(map.current.ox).get(map.current.oy).ox+1>=length)
            System.out.println("Nu se poate deplasa la sud!");
        else
        {
            map.current = map.get(map.current.ox+1).get(map.current.oy);
            map.player.currentOx=map.current.ox;
        }
    }

    void goEast()
    {
        if(map.get(map.current.ox).get(map.current.oy).oy+1>=width)
            System.out.println("Nu se poate deplasa la est!");
        else
        {
            map.current = map.get(map.current.ox).get(map.current.oy+1);
            map.player.currentOy=map.current.oy;
        }
    }

    void goWest()
    {
        if(map.get(map.current.ox).get(map.current.oy).oy-1<0)
            System.out.println("Nu se poate deplasa la vest!");
        else
        {
            map.current = map.get(map.current.ox).get(map.current.oy-1);
            map.player.currentOy=map.current.oy;
        }
    }
}

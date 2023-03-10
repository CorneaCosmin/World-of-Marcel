package World_of_Marcel;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Game
{
    Scanner scanner=new Scanner(System.in);
    List<Account> accounts=new ArrayList<Account>();
    Map<Cell.Type,List<String>> dictionary=new HashMap<>();
    private Game()
    {
        System.out.println("Va incepe jocul!");
    }
    private static Game game=null;
    public static Game getInstance()
    {
        if(game==null)
            game=new Game();
        return game;
    }

    void run() throws Exception
    {
        boolean check;
        System.out.println("Alege modul de joc!");
        String input=scanner.nextLine();
        if(input.equals("terminal"))
        {
            parseAccountsJson();
            LinkedList<LinkedList<String>>stories=new LinkedList<>();
            stories.add(new LinkedList<String>());      //empty
            stories.add(new LinkedList<String>());      //enemy
            stories.add(new LinkedList<String>());      //shop
            stories.add(new LinkedList<String>());      //finish
            parseStoriesJson(stories);
            dictionary.put(Cell.Type.EMPTY,stories.get(0));
            dictionary.put(Cell.Type.ENEMY,stories.get(1));
            dictionary.put(Cell.Type.SHOP,stories.get(2));
            dictionary.put(Cell.Type.FINISH,stories.get(3));
            System.out.println();
            System.out.println("Introdu emailul si parola!");
            int i,nrCont=0;
            input=scanner.nextLine();
            String input2=scanner.nextLine();
            check=false;
            for(i=0;i<accounts.size();i++)
                if(input.equals(accounts.get(i).info.getCred().getEmail()) && input2.equals(accounts.get(i).info.getCred().getPassword()))
                {
                    check=true;
                    nrCont=i;
                }
            if(check==false)
                throw new InvalidCommandException("Adresa de email sau parola este incorecta!");
            System.out.println();
            System.out.println("Datele contului:");
            System.out.println("Nume: "+accounts.get(nrCont).info.getName()+"\nTara: "+accounts.get(nrCont).info.getCountry()
                    +"\nJocuri favorite: "+accounts.get(nrCont).info.getFavGames()+"\nMape completate: "+accounts.get(nrCont).numGames);
            System.out.println();
            System.out.println("Alege personajul!");
            for(i=0;i<accounts.get(nrCont).characters.size();i++)
                System.out.println("Nume: "+accounts.get(nrCont).characters.get(i).name+
                        "\nProfesie: "+accounts.get(nrCont).characters.get(i).getClass().getSimpleName()+
                        "\nLevel: "+accounts.get(nrCont).characters.get(i).level+
                        "\nExperienta: "+accounts.get(nrCont).characters.get(i).experience+"\n");
            int nrCaracter=0;
            Character character;
            check=false;
            String nameCharacter=scanner.nextLine();
            for(i=0;i<accounts.get(nrCont).characters.size();i++)
                if(accounts.get(nrCont).characters.get(i).name.equals(nameCharacter))
                {
                    nrCaracter=i;
                    check=true;
                }
            if(check==false)
                throw new InvalidCommandException("Personajul nu exista!");
            character=accounts.get(nrCont).characters.get(nrCaracter);
            System.out.println();
            System.out.println("Personajul ales este:");
            System.out.println("Nume: "+accounts.get(nrCont).characters.get(nrCaracter).name+
                    "\nProfesie: "+accounts.get(nrCont).characters.get(nrCaracter).getClass().getSimpleName()+
                    "\nLevel: "+accounts.get(nrCont).characters.get(nrCaracter).level+
                    "\nExperienta: "+accounts.get(nrCont).characters.get(nrCaracter).experience+
                    "\nAbilitati: "+accounts.get(nrCont).characters.get(nrCaracter).abilities+
                    "\nViata curenta: "+accounts.get(nrCont).characters.get(nrCaracter).currentLife+
                    "\nMana curenta: "+accounts.get(nrCont).characters.get(nrCaracter).currentManna+"\n");
            System.out.println("Incepe jocul!");
            Random random=new Random();
            int length=random.nextInt(9-3)+3;
            int width=random.nextInt(9-5)+5;
            int startOx=random.nextInt(length);
            int startOy=random.nextInt(width);
            Cell currentCell=new Cell(startOx, startOy, new CellElement() {
                @Override
                public char toCharacter() {
                    return 'N';
                }
            });
            currentCell.visited=true;
            Grid grid=Grid.generateMap(length,width,character,currentCell,startOx,startOy);
            grid.setCurrent(grid.get(startOx).get(startOy));
            grid.addStories(stories);
            grid.printMap();
            showOptions(grid);
            if(grid.current.element.toCharacter()=='F')
                System.out.println("Felicitari! Ai terminat jocul!");
            else if(grid.player.currentLife<0)
            {
                System.out.println("Ai pierdut! :(");
                System.exit(0);
            }
        }
        else if(input.equals("fereastra grafica"))
        {
            parseAccountsJson();
            LinkedList<LinkedList<String>>stories=new LinkedList<>();
            stories.add(new LinkedList<String>());      //empty
            stories.add(new LinkedList<String>());      //enemy
            stories.add(new LinkedList<String>());      //shop
            stories.add(new LinkedList<String>());      //finish
            parseStoriesJson(stories);
            Autentificare aut=new Autentificare("Autentification",accounts,stories);
        }
        else if(input.equals("metoda hardcodata"))
        {
            parseAccountsJson();
            LinkedList<LinkedList<String>>stories=new LinkedList<>();
            stories.add(new LinkedList<String>());      //empty
            stories.add(new LinkedList<String>());      //enemy
            stories.add(new LinkedList<String>());      //shop
            stories.add(new LinkedList<String>());      //finish
            parseStoriesJson(stories);
            dictionary.put(Cell.Type.EMPTY,stories.get(0));
            dictionary.put(Cell.Type.ENEMY,stories.get(1));
            dictionary.put(Cell.Type.SHOP,stories.get(2));
            dictionary.put(Cell.Type.FINISH,stories.get(3));
            System.out.println();
            System.out.println("Introdu emailul si parola!");
            int i,nrCont=0;
            input=scanner.nextLine();
            String input2=scanner.nextLine();
            check=false;
            for(i=0;i<accounts.size();i++)
                if(input.equals(accounts.get(i).info.getCred().getEmail()) && input2.equals(accounts.get(i).info.getCred().getPassword()))
                {
                    check=true;
                    nrCont=i;
                }
            if(check==false)
                throw new InvalidCommandException("Adresa de email sau parola este incorecta!");
            System.out.println();
            System.out.println("Datele contului:");
            System.out.println("Nume: "+accounts.get(nrCont).info.getName()+"\nTara: "+accounts.get(nrCont).info.getCountry()
                    +"\nJocuri favorite: "+accounts.get(nrCont).info.getFavGames()+"\nMape completate: "+accounts.get(nrCont).numGames);
            System.out.println();
            System.out.println("Alege personajul!");
            for(i=0;i<accounts.get(nrCont).characters.size();i++)
                System.out.println("Nume: "+accounts.get(nrCont).characters.get(i).name+
                        "\nProfesie: "+accounts.get(nrCont).characters.get(i).getClass().getSimpleName()+
                        "\nLevel: "+accounts.get(nrCont).characters.get(i).level+
                        "\nExperienta: "+accounts.get(nrCont).characters.get(i).experience+"\n");
            int nrCaracter=0;
            Character character;
            check=false;
            String nameCharacter=scanner.nextLine();
            for(i=0;i<accounts.get(nrCont).characters.size();i++)
                if(accounts.get(nrCont).characters.get(i).name.equals(nameCharacter))
                {
                    nrCaracter=i;
                    check=true;
                }
            if(check==false)
                throw new InvalidCommandException("Personajul nu exista!");
            character=accounts.get(nrCont).characters.get(nrCaracter);
            System.out.println();
            System.out.println("Personajul ales este:");
            System.out.println("Nume: "+accounts.get(nrCont).characters.get(nrCaracter).name+
                    "\nProfesie: "+accounts.get(nrCont).characters.get(nrCaracter).getClass().getSimpleName()+
                    "\nLevel: "+accounts.get(nrCont).characters.get(nrCaracter).level+
                    "\nExperienta: "+accounts.get(nrCont).characters.get(nrCaracter).experience+
                    "\nAbilitati: "+accounts.get(nrCont).characters.get(nrCaracter).abilities+
                    "\nViata curenta: "+accounts.get(nrCont).characters.get(nrCaracter).currentLife+
                    "\nMana curenta: "+accounts.get(nrCont).characters.get(nrCaracter).currentManna+"\n");
            System.out.println("Incepe jocul!");
            Cell currentCell=new Cell(0, 0, new CellElement() {
                @Override
                public char toCharacter() {
                    return 'N';
                }
            });
            currentCell.visited=true;
            character.inventory.coins=1000;
            Grid grid=Grid.generateMapHardcoded(5,5,character,currentCell);
            grid.setCurrent(grid.get(0).get(0));
            grid.addStories(stories);
            grid.printMap();
            hardcoded(grid);
            if(grid.current.element.toCharacter()=='F')
                System.out.println("Felicitari! Ai terminat jocul!");
            else if(grid.player.currentLife<0)
            {
                System.out.println("Ai pierdut! :(");
                System.exit(0);
            }

        }
        else throw new InvalidCommandException("Mod de joc incorect!");
    }

    void parseAccountsJson() throws Exception
    {
        Object obj=new JSONParser().parse(new FileReader("src\\World_of_Marcel\\accounts.json"));
        JSONObject jo=(JSONObject) obj;
        JSONArray account=(JSONArray)jo.get("accounts");
        Iterator itr1=account.iterator();
        while(itr1.hasNext())
        {
            Object obj1=new JSONParser().parse(itr1.next().toString());
            JSONObject jo1=(JSONObject) obj1;
            String country=(String) jo1.get("country");
            String name=(String) jo1.get("name");
            JSONArray favoriteGames=(JSONArray) jo1.get("favorite_games");
            TreeSet<String>favGames=new TreeSet<String>();
            Iterator itr2=favoriteGames.iterator();
            while(itr2.hasNext())
                favGames.add(itr2.next().toString());
            JSONObject jo2=(JSONObject) jo1.get("credentials");
            String email=(String)jo2.get("email");
            String password=(String)jo2.get("password");
            Credentials credentials=new Credentials(email,password);
            Integer mapsCompleted=Integer.parseInt((String) jo1.get("maps_completed"));
            LinkedList<Character> character=new LinkedList<Character>();
            JSONArray characters=(JSONArray) jo1.get("characters");
            Iterator itr3=characters.iterator();
            while(itr3.hasNext())
            {
                JSONObject jo3=(JSONObject) itr3.next();
                String profession=(String) jo3.get("profession");
                String name1=(String) jo3.get("name");
                Integer level=Integer.parseInt((String) jo3.get("level"));
                Integer experience=Integer.parseInt((jo3.get("experience").toString()));
                CharacterFactory characterFactory=new CharacterFactory();
                character.add(characterFactory.factory(profession,name1,level,experience));
            }
            Account.Information.InformationBuilder informationBuilder=new Account.Information.InformationBuilder(credentials,name);
            informationBuilder.favGames(favGames);
            informationBuilder.country(country);
            Account.Information information=informationBuilder.build();
            Account account1=new Account(information,character,mapsCompleted);
            accounts.add(account1);

        }
    }

    void parseStoriesJson(LinkedList<LinkedList<String>>stories) throws Exception
    {
        Object obj=new JSONParser().parse(new FileReader("src\\World_of_Marcel\\stories.json"));
        JSONObject jo=(JSONObject) obj;
        JSONArray account=(JSONArray)jo.get("stories");
        Iterator itr1=account.iterator();
        while(itr1.hasNext())
        {
            Object obj1=new JSONParser().parse(itr1.next().toString());
            JSONObject jo1=(JSONObject) obj1;
            String type=(String) jo1.get("type");
            if(type.equals("EMPTY"))
                stories.get(0).add((String) jo1.get("value"));
            if(type.equals("ENEMY"))
                stories.get(1).add((String) jo1.get("value"));
            if(type.equals("SHOP"))
                stories.get(2).add((String) jo1.get("value"));
            if(type.equals("FINISH"))
                stories.get(3).add((String) jo1.get("value"));
        }
    }

    void showOptions(Grid grid) throws InvalidCommandException
    {
        while(grid.current.element.toCharacter()!='F' && grid.player.currentLife>0)
        {
            System.out.println();
            System.out.println("Alege urmatoarea mutare!");
            String move=scanner.nextLine();
            if(move.equals("Nord"))
            {
                grid.goNorth();
            }
            else if(move.equals("Sud"))
            {
                grid.goSouth();
            }
            else if(move.equals("Est"))
            {
                grid.goEast();
            }
            else if(move.equals("Vest"))
            {
                grid.goWest();
            }
            else throw new InvalidCommandException("Mutarea aleasa este incorecta!");
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
            }
            if(grid.current.element.toCharacter()=='S') {
                System.out.println("Ai ajuns la magazin! Poti cumpara o potiune!");
                System.out.println("Ai " + grid.player.inventory.coins + " de banuti!");
                Shop shop = (Shop) grid.current.element;
                int i;
                String potion;
                do {
                    System.out.println();
                    if (shop.potions.isEmpty() == true)
                        break;
                    System.out.println("Lista cu potiuni este:");
                    for (i = 0; i < shop.potions.size(); i++)
                        System.out.println(i + 1 + ") " + shop.potions.get(i));
                    potion = scanner.nextLine();
                    if (!potion.equals("Nu cumpar") && (Integer.parseInt(potion) > shop.potions.size()))
                        throw new InvalidCommandException("Comanda aleasa este incorecta!");
                    if (potion.equals("Nu cumpar"))
                        break;
                    int nrPotion = Integer.parseInt(potion), checkMoney = 0;
                    System.out.println();
                    for (i = 0; i < shop.potions.size(); i++) {
                        if (grid.player.inventory.coins >= shop.potions.get(i).pricePotion())
                            checkMoney = 1;
                    }
                    if (checkMoney == 1) {
                        if (grid.player.inventory.coins >= shop.potions.get(nrPotion - 1).pricePotion()) {
                            System.out.println("Ati ales potiunea: ");
                            System.out.println(nrPotion + ") " + shop.potions.get(nrPotion - 1));
                            grid.player.inventory.addPotions(shop.selectPotion(nrPotion - 1));
                        } else System.out.println("Nu ai suficienti bani pentru a cumpara aceasta potiune!");
                    } else {
                        System.out.println("Nu ai suficienti bani pentru a cumpara o potiune!");
                        break;
                    }
                } while (true);
            }
            if(grid.current.visited==false)
            {
                if(grid.current.element.toCharacter()=='E')
                {
                    Random rand=new Random();
                    Enemy enemy=(Enemy) grid.current.element;
                    System.out.println("Ai intalnit un inamic! Sa inceapa batalia!");
                    System.out.println();
                    System.out.println("Caracterul tau este: "+grid.player);
                    System.out.println("Inamicul este: "+enemy);
                    int who=0;
                    while(grid.player.currentLife>0 && enemy.currentLife>0) {
                        if (who%2==0)
                        {
                            System.out.println("Randul tau!");
                            System.out.println("Alege modul de atac!");
                            String option=scanner.nextLine();
                            if(option.equals("Abilitate"))
                            {
                                if(grid.player.abilities.size()==0)
                                {
                                    System.out.println("Nu mai ai abilitati! Vei ataca normal!");
                                    int damage = grid.player.getDamage();
                                    enemy.receiveDamage(damage);
                                }
                                else {
                                    System.out.println("Alege tipul abilitatii!");
                                    String typeAbility = scanner.nextLine();
                                    for (int j = 0; j < grid.player.abilities.size(); j++)
                                        enemy.accept(grid.player.abilities.get(j));
                                    if (typeAbility.equals("Fire")) {
                                        int i;
                                        for (i = 0; i < grid.player.abilities.size(); i++)
                                            if (grid.player.abilities.get(i).getClass().getSimpleName().equals("Fire")) {
                                                {
                                                    if(grid.player.currentManna>=grid.player.abilities.get(i).costManna)
                                                    {enemy.receiveDamage(grid.player.abilities.get(i).damage);
                                                    grid.player.currentManna -= grid.player.abilities.get(i).costManna;
                                                    grid.player.abilities.remove(i);
                                                    break;}
                                                    else System.out.println("Nu ai suficienta mana!");
                                                }
                                            }
                                    }
                                    else if (typeAbility.equals("Ice")) {
                                        int i;
                                        for (i = 0; i < grid.player.abilities.size(); i++)
                                            if (grid.player.abilities.get(i).getClass().getSimpleName().equals("Ice")) {
                                                {
                                                    if(grid.player.currentManna>=grid.player.abilities.get(i).costManna)
                                                    {enemy.receiveDamage(grid.player.abilities.get(i).damage);
                                                    grid.player.currentManna -= grid.player.abilities.get(i).costManna;
                                                    grid.player.abilities.remove(i);
                                                    break;}
                                                    else System.out.println("Nu ai suficienta mana!");
                                                }
                                            }
                                    }
                                    else if (typeAbility.equals("Earth")) {
                                        int i;
                                        for (i = 0; i < grid.player.abilities.size(); i++)
                                            if (grid.player.abilities.get(i).getClass().getSimpleName().equals("Earth")) {
                                                {
                                                    if(grid.player.currentManna>=grid.player.abilities.get(i).costManna)
                                                    {enemy.receiveDamage(grid.player.abilities.get(i).damage);
                                                    grid.player.currentManna -= grid.player.abilities.get(i).costManna;
                                                    grid.player.abilities.remove(i);
                                                    break;}
                                                    else System.out.println("Nu ai suficienta mana!");
                                                }
                                            }
                                    }
                                    else throw new InvalidCommandException("Comanda este incorecta!");
                                }
                            }
                            else if(option.equals("Potiune"))
                            {
                                System.out.println("Alege tipul potiunii!");
                                String typePotion=scanner.nextLine();
                                if(typePotion.equals("ManaPotion"))
                                {
                                    int i;
                                    for(i=0;i<grid.player.inventory.potions.size();i++)
                                        if(grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("ManaPotion"))
                                        {
                                            grid.player.inventory.potions.get(i).usePotion(grid.player);
                                            break;
                                        }
                                }
                                if(typePotion.equals("HealthPotion"))
                                {
                                    int i;
                                    for(i=0;i<grid.player.inventory.potions.size();i++)
                                        if(grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("HealthPotion"))
                                        {
                                            grid.player.inventory.potions.get(i).usePotion(grid.player);
                                            break;
                                        }
                                }
                            }
                            else if(option.equals("Atac normal"))
                            {
                                int damage = grid.player.getDamage();
                                enemy.receiveDamage(damage);
                            }
                            else throw new InvalidCommandException("Comanda este incorecta!");
                            if(grid.player.currentLife>0 && enemy.currentLife>0)
                            {System.out.println(grid.player);
                            System.out.println(enemy);}
                            System.out.println();
                            if(grid.player.currentLife>0 && enemy.currentLife>0)
                                System.out.println("Randul inamicului!");
                        }
                        if (who%2==1)
                        {
                            int chanceAbility=rand.nextInt(2);
                            if(chanceAbility==1 && enemy.abilities.size()!=0)
                            {
                                int nrAbility= rand.nextInt(enemy.abilities.size());
                                grid.player.accept(enemy.abilities.get(nrAbility));
                                if(enemy.currentManna>=enemy.abilities.get(nrAbility).costManna)
                                {
                                    grid.player.receiveDamage(enemy.abilities.get(nrAbility).damage);
                                    enemy.currentManna-=enemy.abilities.get(nrAbility).costManna;
                                    enemy.abilities.remove(nrAbility);
                                }
                                else
                                {
                                    int damage= enemy.getDamage();
                                    grid.player.receiveDamage(damage);
                                }
                            }
                            else
                            {
                                int damage= enemy.getDamage();
                                grid.player.receiveDamage(damage);
                            }
                            if(grid.player.currentLife>0 && enemy.currentLife>0)
                            {System.out.println(grid.player);
                                System.out.println(enemy);}
                            System.out.println();
                        }
                        who++;
                    }
                    if(grid.player.currentLife>0)
                    {
                        System.out.println("Felicitari! Ai invins inamicul!");
                        int chance= rand.nextInt(5);
                        if(chance==0 || chance==1 || chance==2 || chance==4)
                        {
                            grid.player.inventory.coins+=500;
                            System.out.println("Felicitari! Ai primit 500 de banuti pentru ca ai invins inamicul!");
                        }
                        grid.player.experience+=rand.nextInt(100-50)+50;
                        if(grid.player.experience>=100)
                        {
                            grid.player.level++;
                            grid.player.experience-=100;
                        }
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }
    }

    void hardcoded(Grid grid) throws Exception
    {
        System.out.println("Alege urmatoarea mutare!");
        String move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goEast();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }
        else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goEast();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goEast();
            if(grid.current.visited==false)
            {
                showStory(grid);
            }
            if(grid.current.element.toCharacter()=='S') {
                System.out.println("Ai ajuns la magazin! Poti cumpara o potiune!");
                System.out.println("Ai " + grid.player.inventory.coins + " de banuti!");
                Shop shop = (Shop) grid.current.element;
                shop.potions.add(new ManaPotion());
                shop.potions.add(new HealthPotion());
                int i;
                String potion;
                System.out.println();
                System.out.println("Lista cu potiuni este:");
                for (i = 0; i < shop.potions.size(); i++)
                    System.out.println(i + 1 + ") " + shop.potions.get(i));
                potion = scanner.nextLine();
                if (!potion.equals("P"))
                        throw new InvalidCommandException("Comanda aleasa este incorecta!");
                System.out.println();
                System.out.println("Ati ales potiunile: ");
                System.out.println(shop.potions.size()-2 + ") " + shop.potions.get(shop.potions.size() - 2));
                System.out.println(shop.potions.size()-1 + ") " + shop.potions.get(shop.potions.size() - 1));
                grid.player.inventory.addPotions(shop.selectPotion(shop.potions.size() - 1));
                grid.player.inventory.addPotions(shop.selectPotion(shop.potions.size() - 2));
            }
            grid.current.visited = true;
            grid.printMap();
        }
        else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goEast();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goSouth();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }else throw new InvalidCommandException("Comanda este incorecta!");
//        System.out.println("Alege urmatoarea mutare!");
        //move=scanner.nextLine();
//        if(move.equals("P"))
//        {
//            grid.goSouth();
//            if(grid.current.visited==false) {
//                showStory(grid);
//                Random rand = new Random();
//                if (grid.current.element.toCharacter() == 'N') {
//                    int chance = rand.nextInt(5);
//                    if (chance == 3) {
//                        grid.player.inventory.coins += 500;
//                        System.out.println("Felicitari! Ai primit 500 de banuti!");
//                    }
//                }
//                grid.current.visited = true;
//            }
//            grid.printMap();
//        }else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goSouth();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
        }else throw new InvalidCommandException("Comanda este incorecta!");
        System.out.println("Alege urmatoarea mutare!");
        move=scanner.nextLine();
        if(move.equals("P"))
        {
            grid.goSouth();
            if(grid.current.visited==false) {
                showStory(grid);
                if (grid.current.element.toCharacter() == 'E') {
                    Random rand = new Random();
                    Enemy enemy = (Enemy) grid.current.element;
                    System.out.println("Ai intalnit un inamic! Sa inceapa batalia!");
                    System.out.println();
                    System.out.println("Caracterul tau este: " + grid.player);
                    System.out.println("Inamicul este: " + enemy);
                    int who = 0;
                    while (grid.player.currentLife > 0 && enemy.currentLife > 0) {
                        if (who % 2 == 0) {
                            int okLife=0,okMana=0;
                            for (int i = 0; i < grid.player.inventory.potions.size(); i++)
                                if (grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("HealthPotion")) {
                                    okLife = 1;
                                    break;
                                };
                            for (int i = 0; i < grid.player.inventory.potions.size(); i++)
                                if (grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("ManaPotion")) {
                                    okMana = 1;
                                    break;
                                };
                            System.out.println("Randul tau!");
                            System.out.println("Alege modul de atac!");
                            String option = scanner.nextLine();
                            if(option.equals("P"))
                            {
                                if(grid.player.currentLife!=grid.player.maxLife && okLife==1)
                                {
                                    int i;
                                    for (i = 0; i < grid.player.inventory.potions.size(); i++)
                                        if (grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("HealthPotion")) {
                                            grid.player.inventory.potions.get(i).usePotion(grid.player);
                                            break;
                                        }
                                }
                                else if(grid.player.currentManna!=grid.player.maxManna && okMana==1)
                                {
                                    int i;
                                    for (i = 0; i < grid.player.inventory.potions.size(); i++)
                                        if (grid.player.inventory.potions.get(i).getClass().getSimpleName().equals("ManaPotion")) {
                                            grid.player.inventory.potions.get(i).usePotion(grid.player);
                                            break;}
                                }
                                else if(grid.player.abilities.size()!=0 && grid.player.currentManna>=grid.player.abilities.get(0).costManna)
                                {
                                    enemy.accept(grid.player.abilities.get(0));
                                    enemy.receiveDamage(grid.player.abilities.get(0).damage);
                                    grid.player.currentManna -= grid.player.abilities.get(0).costManna;
                                    grid.player.abilities.remove(0);
                                }
                                else{
                                    int damage = grid.player.getDamage();
                                    enemy.receiveDamage(damage);
                                }
                            } else throw new InvalidCommandException("Comanda este incorecta!");
                            System.out.println(grid.player);
                            System.out.println(enemy);
                            System.out.println();
                            if (grid.player.currentLife > 0 && enemy.currentLife > 0)
                                System.out.println("Randul inamicului!");
                        }
                        if (who % 2 == 1) {
                            int chanceAbility = rand.nextInt(2);
                            if (chanceAbility == 1 && enemy.abilities.size() != 0) {
                                int nrAbility = rand.nextInt(enemy.abilities.size());
                                grid.player.accept(enemy.abilities.get(nrAbility));
                                grid.player.receiveDamage(enemy.abilities.get(nrAbility).damage);
                            } else {
                                int damage = enemy.getDamage();
                                grid.player.receiveDamage(damage);
                            }
                            if (grid.player.currentLife > 0 && enemy.currentLife > 0) {
                                System.out.println(grid.player);
                                System.out.println(enemy);
                            }
                            System.out.println();
                        }
                        who++;
                    }
                    if (grid.player.currentLife > 0) {
                        System.out.println("Felicitari! Ai invins inamicul!");
                        int chance = rand.nextInt(5);
                        if (chance == 0 || chance == 1 || chance == 2 || chance == 4) {
                            grid.player.inventory.coins += 500;
                            System.out.println("Felicitari! Ai primit 500 de banuti pentru ca ai invins inamicul!");
                        }
                        grid.player.experience += 50;
                        if (grid.player.experience >= 100) {
                            grid.player.level++;
                            grid.player.experience = 0;
                        }
                    }
                }
                grid.current.visited=true;
            }
            grid.printMap();
        }
        move=scanner.nextLine();
        System.out.println("Alege urmatoarea mutare!");
        if(move.equals("P"))
        {
            grid.goSouth();
            if(grid.current.visited==false) {
                showStory(grid);
                Random rand = new Random();
                if (grid.current.element.toCharacter() == 'N') {
                    int chance = rand.nextInt(5);
                    if (chance == 3) {
                        grid.player.inventory.coins += 500;
                        System.out.println("Felicitari! Ai primit 500 de banuti!");
                    }
                }
                grid.current.visited = true;
            }
            grid.printMap();
            if (grid.current.element.toCharacter() == 'F')
                return;
        }
        else throw new InvalidCommandException("Comanda este incorecta!");
    }

    void showStory(Grid grid)
    {
        System.out.println(grid.current.story);
    }
}

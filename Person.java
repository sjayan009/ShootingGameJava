public class Person 
{
    public String name;
    public int health;
    public String weapon;

    public Person(String name, String weapon)
    {
        health = 100;
        this.name = name;
        this.weapon = weapon;
    }

    public int attack(Weapon w, Person opponent)
    {
        if(w.getWeaponName().equals("Baseball Bat"))
        {
            int number = (int) ((Math.random() * 2) + 1);
            if(number == 1)
            {
                w.use(opponent);
                System.out.println("You have successfully dealt damage to your opponent.");
                boolean healthStatus = checkHealth();
                if(healthStatus == false)
                {
                    return 0;
                }
            }
            else
            {
                System.out.println("Your swung your bat too hard and missed. You didn't deal any damage to your opponent!");
            }
        }
        else
        {
            int number = (int) ((Math.random() * 3) + 1);
            if(number == 2)
            {
                w.use(opponent);
                System.out.println("You have successfully dealt damage to your opponent.");
                boolean healthStatus = checkHealth();
                if(healthStatus == false)
                {
                    return 0;
                }
            }
            else
            {
                System.out.println("Your bullet jammed. You didn't deal any damage to your opponent!");
            }
        }
        return health;
    }

    public boolean checkHealth()
    {
        if(health <= 0)
        {
            System.out.println("Game Over");
            return false; //returning false means that the player has negative or zero health
        }
        return true; //if false is not returned, that means that this player still has health left.
    }

    public String getWeaponName()
    {
        return this.weapon;
    }
}

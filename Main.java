import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        try
        {
            Scanner sc = new Scanner(System.in);
        
            String p1Weapon;
            String p2Weapon;
    
            int w1damage, w2damage;
            
    
            System.out.print("Enter Player 1 Name: ");
            String p1Name = sc.nextLine();
    
            System.out.print("Enter Player 2 Name: ");
            String p2Name = sc.nextLine();
    
            int randomNumber  = (int) (Math.random() * 2);
            if(randomNumber == 0)
            {
                p1Weapon = "Baseball Bat";
                w1damage = 30;
                p2Weapon = "Gun";
                w2damage = 50;
            }
            else
            {
                p1Weapon = "Gun";
                w1damage = 50;
                p2Weapon = "Baseball Bat";
                w2damage = 30;
            }
    
            Person p1 = new Person(p1Name, p1Weapon);
            Weapon w1 = new Weapon(p1Weapon, w1damage);
    
            Person p2 = new Person(p2Name, p2Weapon);
            Weapon w2 = new Weapon(p2Weapon, w2damage);
    
            System.out.println("\nPlayer 1, your weapon is " + p1.getWeaponName());
            System.out.println("Player 2, your weapon is " + p2.getWeaponName() + "\n");

            int p1dc = 0;
            int p2dc = 0;
    
            String p2Input = "";
            while(p1.health > 0 || p2.health > 0)
            {
                System.out.print("Player 1, type ATTACK or DODGE or FLEE. If you enter DODGE more than once, you lose 50 health: ");
                String p1Input = sc.nextLine();
                if(p1Input.equalsIgnoreCase("FLEE"))
                {
                    System.out.println("Game Over. Player 2 has won!");
                    break;
                }
                else if(p1Input.equalsIgnoreCase("DODGE"))
                {
                    if(p1dc != 1)
                    {
                        p1dc++;
                    }
                    else
                    {
                        System.out.println("You have already DODGED once. You will lose 50 hp and in your confusion, didn't use the weapon.");
                        p1.health -= 50;
                        p1Input = "ATTACK";
                    }
                }
                else
                {
                    if(p2Input.equals("DODGE"))
                    {
                        System.out.println("Player 2 has dodged the attack");
                    }
                    else
                    {
                        p1.attack(w1, p2);
                        System.out.println("Player 1 Health: " + p1.health);
                        System.out.println("Player 2 Health: " + p2.health);
                        if(p1.checkHealth() == false)
                        {
                            System.out.println("Game Over. Player 2 has won!");
                            break;
                        }
                        if(p2.checkHealth() == false)
                        {
                            System.out.println("Game Over. Player 1 has won!");
                            break;
                        }
                    }
                }
    
                System.out.print("\nPlayer 2, type ATTACK or DODGE or FLEE: ");
                p2Input = sc.nextLine();
                if(p2Input.equalsIgnoreCase("FLEE"))
                {
                    System.out.println("Game Over. Player 1 has won!");
                    break;
                }
                else if(p2Input.equalsIgnoreCase("DODGE"))
                {
                    if(p2dc != 1)
                    {
                        p2dc++;
                    }
                    else
                    {
                        System.out.println("You have already DODGED once. You will lose 50 hp and in your confusion, didn't use the weapon.");
                        p2.health -= 50;
                        p2Input = "ATTACK";
                    }
                }
                else
                {
                    if(p1Input.equals("DODGE"))
                    {
                        System.out.println("Player 2 had dodged your attack.");
                    }
                    else
                    {
                        p2.attack(w2, p1);
                        System.out.println("Player 1 Health: " + p1.health);
                        System.out.println("Player 2 Health: " + p2.health);
                        System.out.println("\n");
                        if(p1.checkHealth() == false)
                        {
                            System.out.println("Game Over. Player 2 has won!");
                            break;
                        }
                        if(p2.checkHealth() == false)
                        {
                            System.out.println("Game Over. Player 1 has won!");
                            break;
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Input Mismatch Exception. Please rerun the program.");
        }

    }    
}

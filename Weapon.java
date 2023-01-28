public class Weapon
{
    public String weaponName;
    public int damage;

    public Weapon(String name, int damage)
    {
        this.weaponName = name;
        this.damage = damage;
    }

    public void use(Person opponent)
    {
        opponent.health = opponent.health - this.damage;
    }

    public String getWeaponName()
    {
        return weaponName;
    }
}
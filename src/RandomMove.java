public class RandomMove
{
    public RandomMove() {}

    //Will randomly pick one player to go first
    public Player randomPlayer(Player person1, Player person2)
    {
        if (Math.random() * 10 > 6) //
        {
            return person1;
        }
        else
        {
            return person2;
        }
    }

    //Gets a random position within the game
    public int randomPos()
    {
        int pos = (int)(Math.random() * 10);
        while (pos == 0)
        {
            pos = (int)(Math.random() * 10);
        }
        return pos;
    }
}

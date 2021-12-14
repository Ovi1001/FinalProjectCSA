public class Player implements Comparable
{
    //Declaring variables
    private String name;
    private String symbol;
    private int points;

    //Constructors
    public Player(String name, String symbol)
    {
        this.name = name;
        this.symbol = symbol;
        this.points = 0;
    }
    public Player(String symbol)
    {
        this.name = "Unknown";
        this.symbol = symbol;
        this.points = 0;
    }

    //Getters
    public String getName()
    {
        return name;
    }
    public String getSymbol()
    {
        return symbol;
    }
    public int getPoints()
    {
        return points;
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public void addPoint()
    {
        points++;
    }

    //Comparing the ultimate winner
    @Override
    public int compareTo(Object otherPlayer)
    {
        int value = 0;
        if (this.points > ((Player)otherPlayer).getPoints())
        {
            value = 1;
        }
        else if (this.points < ((Player)otherPlayer).getPoints())
        {
            value = -1;
        }
        return value;
    }

    //toString method
    public String toString()
    {
        return "Name: " + name +
                "\nSymbol: " + symbol +
                "\nPoints: " + points;
    }
}//end of Player class

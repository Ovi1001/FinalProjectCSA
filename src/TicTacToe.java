public class TicTacToe
{
    private String[] symbolArr = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    //Constructor class
    public TicTacToe() {
    }

    //Checks to see if the chosen space is taken
    private boolean posOpen(int pos)
    {
        if (symbolArr[pos].equals(" "))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Empties the array and prepares for next round
    public void clearBoard()
    {
        for (int i = 0; i < 9; i++)
        {
            symbolArr[i] = " ";
        }
    }

    //Checks all of the different possibilities of wins... Yes, all of them...
    public boolean checkWin()
    {
        boolean ifWin = false;
        if (symbolArr[0] == symbolArr[1] && symbolArr[1] == symbolArr[2] && symbolArr[0] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[0] == symbolArr[4] && symbolArr[4] == symbolArr[8] && symbolArr[0] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[0] == symbolArr[3] && symbolArr[3] == symbolArr[6] && symbolArr[0] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[1] == symbolArr[4] && symbolArr[4] == symbolArr[7] && symbolArr[1] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[2] == symbolArr[5] && symbolArr[5] == symbolArr[8] && symbolArr[2] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[2] == symbolArr[4] && symbolArr[4] == symbolArr[6] && symbolArr[2] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[3] == symbolArr[4] && symbolArr[4] == symbolArr[5] && symbolArr[3] != " ")
        {
            ifWin = true;
        }
        else if (symbolArr[6] == symbolArr[7] && symbolArr[7] == symbolArr[8] && symbolArr[6] != " ")
        {
            ifWin = true;
        }
        if (checkTie() == true)
        {
            clearBoard();
        }
        return ifWin;
    }

    public boolean checkTie()
    {
        for (int i = 0; i < 9; i++)
        {
            if (symbolArr[i].equals(" "))
            {
                return false;
            }
        }
        return true;
    }

    //Will return a boolean if the move was successful
    public boolean nextMove(Player turn, int pos)
    {
        pos--;
        if (posOpen(pos) == false) //Checks to see if the space is open
        {
            symbolArr[pos] = turn.getSymbol();
            return true;
        }
        else //If false, the move fails
        {
            return false;
        }
    }

    //Prints the board screen
    public String toString()
    {
        return symbolArr[0] + " | " + symbolArr[1] + " | " + symbolArr[2] +
                         "\n---------\n" +
                         symbolArr[3] + " | " + symbolArr[4] + " | " + symbolArr[5] +
                         "\n---------\n" +
                         symbolArr[6] + " | " + symbolArr[7] + " | " + symbolArr[8];
    }
}//end of TicTacToe class

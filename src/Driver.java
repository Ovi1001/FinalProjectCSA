import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        int movePos = 0;
        boolean playAgain = true;
        Player nextPlayer;

        Player player1 = new Player("X");
        Player player2 = new Player("O");

        RandomMove random = new RandomMove();

        TicTacToe game = new TicTacToe();

        Scanner input = new Scanner(System.in);

        //Asking for player names for each player object
        System.out.print("Player one name: ");
        player1.setName(input.nextLine());
        System.out.print("Player two name: ");
        player2.setName(input.nextLine());

        while (playAgain == true)
        {
            //Random player goes first
            nextPlayer = random.randomPlayer(player1, player2);

            while (game.checkWin() == false)
            {
                System.out.println(game);
                System.out.print(nextPlayer.getName() + "'s turn. Please select a position to play (1 - 9; 0 - random): ");
                movePos = input.nextInt();
                //Random move
                if (movePos == 0)
                {
                    movePos = random.randomPos();
                }

                //Input validation
                while (movePos < 1 || movePos > 9)
                {
                    System.out.print("Please select a VALID position: ");
                    movePos = input.nextInt();
                }//end of input validation while loop

                //If the move fails, let the player go again
                if (game.nextMove(nextPlayer, movePos) == true)
                {
                    //Checks to see if they have the same address & changes the turn
                    if (nextPlayer == player1)
                    {
                        nextPlayer = player2;
                    }
                    else if (nextPlayer == player2)
                    {
                        nextPlayer = player1;
                    }
                }
                else
                {
                    System.out.println("Sorry, that space is taken. Try again.");
                }
                System.out.println();
            }//end of inner while loop

            System.out.println(game);

            if (nextPlayer == player1)
            {
                player2.addPoint();
                System.out.println(player2.getName() + " Wins! Points: " + player2.getPoints());
                System.out.println(player1.getName() + "'s Points: " + player1.getPoints());
            }
            else
            {
                player1.addPoint();
                System.out.println(player1.getName() + " Wins! Points: " + player1.getPoints());
                System.out.println(player2.getName() + "'s Points: " + player2.getPoints());
            }
            System.out.print("Play Again? (1 - yes, 0 - no): ");
            if (input.nextInt() != 1)
            {
                playAgain = false;
            }
            else
            {
                game.clearBoard();
            }
            System.out.println();
        }//end of outer while loop
        System.out.println("Thanks for playing!");
        if (player1.compareTo(player2) == 1)
        {
            System.out.println("In the end, " + player1.getName() + " took the ultimate victory home with a total points of "
                    + player1.getPoints() + " compared to " + player2.getName() + "'s points of " + player2.getPoints());
        }
        else if (player1.compareTo(player2) == -1)
        {
            System.out.println("In the end, " + player2.getName() + " took the ultimate victory home with a total points of "
                    + player2.getPoints() + " compared to " + player1.getName() + "'s points of " + player1.getPoints());
        }
        else
        {
            System.out.println("In the end, nobody won. It was a long and gruesome battle of TicTacToe with a neck to " +
                    "neck tie of " + player1.getPoints());
        }

    }//end main method
}//end Driver class

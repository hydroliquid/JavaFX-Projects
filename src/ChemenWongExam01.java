//  Chemen Wong, Professor Brian Bourgon, March 25, 2019, CIT230, Exam 01

import java.util.Scanner;

public class ChemenWongExam01
{
    public static void main(String[] args)
    {
        double amount = 0;
        int from = 0;
        int to = 0;
        double answer = 0;
        char choice = 'y';
        Scanner input = new Scanner(System.in);
        
        while (choice == 'y' || choice == 'Y')
        {
            System.out.print("Enter a starting measurement: ");
            from = input.nextInt();
            System.out.print("Enter an ending measurement: ");
            to = input.nextInt();
            System.out.print("Enter an amount: ");
            amount = input.nextDouble();
            answer = convert(amount, from, to);
            System.out.println("Answer: " + answer);
            input.nextLine();
            System.out.print("Do you want to continue(y/n): ");
            choice = input.nextLine().charAt(0);
        }
    }
    
    public static double convert(double amount, int from, int to)
    {
        double endAmount = 0.0;
        
        if (from == 0)
        {
            if (to == 1)
            {
                endAmount = amount / 3.0;
                //System.out.println(amount + " " + endAmount);
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount / 6.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount / 48.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount / 96.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount / 192.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 768.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else if (from == 1)
        {
            if (to == 0)
            {
                endAmount = amount * 3.0;
                
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount / 2.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount / 16.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount / 32.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount / 64.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 256.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else if (from == 2)
        {
            if (to == 0)
            {
                endAmount = amount * 6.0;
                
                return endAmount;
            }
            else if (to == 1)
            {
                endAmount = amount * 2.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount / 8.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount / 16.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount / 32.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 128.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else if (from == 3)
        {
            if (to == 0)
            {
                endAmount = amount * 48.0;
                
                return endAmount;
            }
            else if (to == 1)
            {
                endAmount = amount * 16.0;
                
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount * 8.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount / 2.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount / 4.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 16.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else if (from == 4)
        {
            if (to == 0)
            {
                endAmount = amount * 96.0;
                
                return endAmount;
            }
            else if (to == 1)
            {
                endAmount = amount * 32.0;
                
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount * 16.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount * 2.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount / 2.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 8.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else if (from == 5)
        {
            if (to == 0)
            {
                endAmount = amount * 192.0;
                
                return endAmount;
            }
            else if (to == 1)
            {
                endAmount = amount * 64.0;
                
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount * 32.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount * 4.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount * 2.0;
                
                return endAmount;
            }
            else if (to == 6)
            {
                endAmount = amount / 4.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
        else
        {
            if (to == 0)
            {
                endAmount = amount * 768.0;
                
                return endAmount;
            }
            else if (to == 1)
            {
                endAmount = amount * 256.0;
                
                return endAmount;
            }
            else if (to == 2)
            {
                endAmount = amount * 128.0;
                
                return endAmount;
            }
            else if (to == 3)
            {
                endAmount = amount * 16.0;
                
                return endAmount;
            }
            else if (to == 4)
            {
                endAmount = amount * 8.0;
                
                return endAmount;
            }
            else if (to == 5)
            {
                endAmount = amount * 4.0;
                
                return endAmount;
            }
            else
            {
                return amount;
            }
        }
    }
}

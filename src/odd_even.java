import java.util.*;
class odd_even
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter a Number to check Weather the number is || Odd || Even");
        num=in.nextInt();
        if(num%2==0)
        {
            System.out.println("Even Number");
        }
        else
        {
            System.out.println("Odd Number");
        }
    }
    
}

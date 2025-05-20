package Practise;

public class GenericAddMethodPractice {

	public static void main(String[] args) 
	{
		
		int sum=add(20,50);
		System.out.println(sum);
		System.out.println(add(sum,30));
		System.out.println(add(55,sum));
		System.out.println(add(60,sum));
		
	}
	public static int add(int a ,int b)
	{
		int c=a+b;
		return c;
	}

}

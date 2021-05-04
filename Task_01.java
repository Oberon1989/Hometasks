import java.lang.*;
import java.util.*;
 class Task_01
{
	static int width;
	static int length;
	static int count;
	
	
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите количество панелей");
		count = scanner.nextInt();
		System.out.println("Введите длину панели");
		length = scanner.nextInt();
		System.out.println("Введите ширину панели");
		width = scanner.nextInt();
		System.out.println(String.format("Для обработки указанного количество панелей (%s) с размером %s на %s метров необходимо %s нанограмм сульфида тория",count, width, length ,Calculate(width,length,count)));
	}
	public static int Calculate(int x,int y, int c)
	{
		return x*y*c;
	}
	
	
}

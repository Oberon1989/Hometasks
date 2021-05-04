import java.lang.*;
import java.util.*;
 class Task_01
{
	static float width;
	static float length;
	static float count;
	
	
	
	public static void main(String[] args)
	{
		String tmp="";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите количество панелей");
		tmp=scanner.nextLine().replace(',','.');
		count = Float.parseFloat(tmp);
		System.out.println("Введите длину панели");
		tmp=scanner.nextLine().replace(',','.');
		length = Float.parseFloat(tmp);
		System.out.println("Введите ширину панели");
		tmp=scanner.nextLine().replace(',','.');
		width = Float.parseFloat(tmp);
		System.out.println(String.format("Для обработки указанного количество панелей (%s) с размером %s на %s метров необходимо %.2f нанограмм сульфида тория",count, width, length ,Calculate(width,length,count)));
	}
	public static float Calculate(float x,float y, float c)
	{
		return x*y*c*2;
	}
	
	
}

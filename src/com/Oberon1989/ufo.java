
import java.util.Scanner;

public class ufo {
   public static void main(String[] args) {
     int field,ufo1,ufo2;
     Scanner scanner = new Scanner(System.in);
     field=scanner.nextInt();
     ufo1=scanner.nextInt();
     ufo2=scanner.nextInt();

         if (field >= ufo1 + ufo2) {

             System.out.println("YES");
         }

         else {
             System.out.println("NO");
         }
     }

    }


package exam07;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PrintCalendar {

   public static void getCalender(int year, int month) {
	   
	   if(month >= 12) {
			year ++;
			month %= 12;
		} //2022까지만 정상작동 그 이상 연도추가 안됨 
		
		if(month <= -1) {
			year --;			
			month += 12;
		}//2020까지만 정삭작동함 그 이하의 연도감소 안됨 
	   
      GregorianCalendar startDay = new GregorianCalendar();
      startDay.set(year, month, 1);
      int day = startDay.get(Calendar.DAY_OF_WEEK);

      int date = 28;
      int realMonth = month+1; //month가 0부터 시작하므로 +1 

      if(realMonth == 1 || realMonth == 3 || realMonth == 5 || realMonth == 7 || realMonth == 8 || realMonth == 10 || realMonth == 12) {
         date = 31;
      } else if (realMonth == 4 || realMonth == 6 || realMonth == 9 || realMonth == 11) {
         date = 30;
      }


      System.out.println(year + "년 " + (realMonth) + "월");
      //달력모양
      System.out.println("일\t월\t화\t수\t목\t금\t토");

      for (int i = 1; i < day; i++) {
         System.out.print("\t");
      }
      for (int i = 1; i <= date; i++) {
         System.out.print(i + "\t");

         if((i+day-1) % 7 == 0) {
            System.out.println();
         }
      }
   }


   public static void main(String[] args) {
      GregorianCalendar today = new GregorianCalendar();
      int year = today.get(Calendar.YEAR);
      int month = today.get(Calendar.MONTH);

      getCalender(year,month);

      while(true) {
         Scanner sc = new Scanner(System.in);
         System.out.print("\n 1. 이전달 달력 출력   2. 다음달 달력 출력     3. 종료 ====>");
         int num = sc.nextInt();

         if(num == 3) {
            break;
         }

         switch(num) {
         case 1: getCalender(year, (month-= 1) ); break;
         case 2:   getCalender(year, (month+= 1) ); break;
         }

      }

   }

}

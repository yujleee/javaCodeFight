import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PrintCalendar {

   public static void getCalender(int year, int month) {
	   
	   
      GregorianCalendar startDay = new GregorianCalendar();
      startDay.set(year, month, 1);
     
      int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
      int last = lastDate[month];
      
      //윤년일때의 경우
      if(month == 1 && startDay.isLeapYear(year)) {
    	  last ++;
      }

      int day = startDay.get(Calendar.DAY_OF_WEEK);
    

      System.out.println(year + "년 " + (month+1) + "월");
      //달력모양
      System.out.println("일\t월\t화\t수\t목\t금\t토");

      for (int i = 1; i < day; i++) {
         System.out.print("\t");
      }
      for (int i = 1; i <= last; i++) {
         System.out.print(i + "\t");

         if((i+day-1) % 7 == 0) {
            System.out.println();
         }
      }
      
      Scanner sc = new Scanner(System.in);
      System.out.print("\n 1. 이전달 달력 출력   2. 다음달 달력 출력     3. 종료 ====>");
      int num = sc.nextInt();

  
      switch(num) {
      case 1: month--; break;
      case 2: month++; break;
      case 3: return;
      }
      
  	// 작년, 내년으로 갈 경우
		if(month == -1) {
			year --;
			month = 11;
		}
		
		if(month == 12) {
			year ++;
			month = 0;
		}
		
		//재귀호출
		getCalender(year, month);
      
   }


   public static void main(String[] args) {
      GregorianCalendar today = new GregorianCalendar();
      int year = today.get(Calendar.YEAR);
      int month = today.get(Calendar.MONTH);

      getCalender(year,month);

   }

}

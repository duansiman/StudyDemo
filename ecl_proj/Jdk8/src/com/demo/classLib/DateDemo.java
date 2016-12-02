package com.demo.classLib;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class DateDemo {

	
	public static void main(String[] args) {
		/**
		 *  java 8 ����java.time��
		 *  
		 *  Clock ��ȡ��ǰ���ڣ�ʱ��
		 *  Duration �������ʱ��
		 *  
		 *  Instant ����һ�������ʱ�̣����嵽����
		 *  
		 *  LocalDate ������ʱ��������
		 */
		
		System.out.println(Clock.systemDefaultZone());
		Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
		Duration duration = Duration.ofSeconds(6000);
		System.out.println(duration.toDays());
		System.out.println(duration.toHours());
		System.out.println(duration.toMinutes());
		
		Instant instant = Instant.now();
		System.out.println(instant);
		System.out.println(instant.plusSeconds(6000));
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		Year year = Year.now();
		System.out.println(year);
		
		System.out.println(Month.JANUARY);
		
		String date = "1992-09-09 23:23:34";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(date, formatter);
		System.out.println(ldt);
	}
	
}

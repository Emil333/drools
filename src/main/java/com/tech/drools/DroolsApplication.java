package com.tech.drools;

import com.tech.drools.models.Fare;
import com.tech.drools.models.TaxiRide;
import com.tech.drools.service.TaxiFareCalculatorService;
import com.tech.drools.service.TaxiFareConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

@SpringBootApplication
public class DroolsApplication {




	public static void main(String[] args) throws NotSupportedException, NamingException, SystemException {
		ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
		TaxiFareCalculatorService taxiFareCalculatorService = (TaxiFareCalculatorService) context.getBean(TaxiFareCalculatorService.class);
		TaxiRide taxiRide = new TaxiRide();
		taxiRide.isNightSurcharge(true);
		taxiRide.setDistanceInMile(190L);
		Fare rideFare = new Fare();
		Long sessionId = taxiFareCalculatorService.calculateFare(null, taxiRide, rideFare);

		TaxiRide taxiRide1 = new TaxiRide();
		taxiRide1.isNightSurcharge(true);
		taxiRide1.setDistanceInMile(250L);
		Fare rideFare1 = new Fare();
		Long sessionId1 = taxiFareCalculatorService.calculateFare(null, taxiRide1, rideFare1);

		System.out.println("-------------------------------------------------------------------------------");
		taxiFareCalculatorService.calculateFare(sessionId, taxiRide, rideFare);
		taxiFareCalculatorService.calculateFare(sessionId1, taxiRide1, rideFare1);
	}
}

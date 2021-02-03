package com.tech.drools;

import com.tech.drools.models.Fare;
import com.tech.drools.models.TaxiRide;
import com.tech.drools.service.TaxiFareCalculatorService;
import com.tech.drools.service.TaxiFareConfiguration;
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
//		SpringApplication.run(DroolsApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
		TaxiFareCalculatorService taxiFareCalculatorService = (TaxiFareCalculatorService) context.getBean(TaxiFareCalculatorService.class);
		TaxiRide taxiRide = new TaxiRide();
		taxiRide.isNightSurcharge(true);
		taxiRide.setDistanceInMile(190L);
		Fare rideFare = new Fare();
		taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
	}

}

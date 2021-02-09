package com.tech.drools.service;

import com.tech.drools.models.Fare;
import com.tech.drools.models.TaxiRide;
import org.kie.api.KieBase;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.persistence.jpa.JPAKnowledgeService;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Service
public class TaxiFareCalculatorService {

//    @Autowired
//    private KieContainer kieContainer;

    //    @Autowired
    private Environment environment;

//    @Autowired
//    private KnowledgeBase knowledgeBase;


    private KieBase kieBase;

//    private KieSession session;

    public TaxiFareCalculatorService(KieBase kieBase, Environment environment) {
        this.kieBase = kieBase;
        this.environment = environment;
    }


    public Long calculateFare(Long kieSessionId, TaxiRide taxiRide, Fare rideFare) throws NamingException, SystemException, NotSupportedException {
        StatefulKnowledgeSession kSession;
        if (kieSessionId == null) {
            kSession = JPAKnowledgeService.newStatefulKnowledgeSession(kieBase, null, environment);
            kSession.setGlobal("rideFare", rideFare);
            kSession.insert(taxiRide);
        }else {
            kSession = JPAKnowledgeService.loadStatefulKnowledgeSession(kieSessionId, kieBase, null, environment);
        }
        Long sessionId = kSession.getIdentifier();
        kSession.fireAllRules();
        System.out.println("!! RIDE FARE !! " + rideFare.getTotalFare());
        return sessionId;
    }
}

package pl.poznan.put.cs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import pl.poznan.put.cs.sdm.Customer;
import pl.poznan.put.cs.sdm.RentalService;

@Aspect
public class Aspects {

	
	 @Before("call(* *.*(..)) && !within(pl.poznan.put.cs.aop..*)")
     public void anyCall(JoinPoint thisJoinPoint) {
		 System.out.println("Before execute: "+thisJoinPoint.getSignature());
		 
	 }
	 
	 @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
     public void anyCalla(JoinPoint thisJoinPoint,Throwable e) {
		System.out.println("Exception: "+e);
	 }
	 @Before("call(void pl.poznan.put.cs.sdm.Customer.addRental(..)) && target(cust) && !within(pl.poznan.put.cs.aop..*)")
     public void addRental(Customer cust) {
		// System.out.println("Before execute: "+cust+" "+RentalService.getBlackList().isCustomerBanned(cust));
		 if(RentalService.getBlackList().isCustomerBanned(cust)){
			 throw new RuntimeException(cust+" is banned");
		 }
	 }
}

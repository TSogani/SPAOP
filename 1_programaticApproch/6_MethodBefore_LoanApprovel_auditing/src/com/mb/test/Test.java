package com.mb.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mb.aspect.AuditLoanApproverAspect;
import com.mb.beans.LoanApproval;


public class Test {

	public static void main(String[] args) {

		ProxyFactory pfactory = new ProxyFactory();
			pfactory.setTarget(new LoanApproval());
		pfactory.addAdvice(new AuditLoanApproverAspect());
		LoanApproval proxy = (LoanApproval)pfactory.getProxy();
		// valid 9211
		boolean approver = proxy.approver(9211);
		if(approver)
		{
			System.out.println("loan approve");
		}
		else
		{
			System.out.println("loan denide");
		}

}
}
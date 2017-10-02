package com.mb.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mb.aspect.AuditAuthanticationAspect;
import com.mb.aspect.AuthAspect;
import com.mb.beans.LoanApproval;
import com.mb.util.AuthManager;

public class Test {
	public static void main(String[] args) {

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new LoanApproval());
		factory.addAdvice(new AuthAspect());
		factory.addAdvice(new AuditAuthanticationAspect());
		LoanApproval proxy = (LoanApproval) factory.getProxy();

		AuthManager authManager = AuthManager.getinstance();
		
		authManager.login("john1", "welcome");
		// authManager.login("john1","welcome1");
		
		boolean approver = proxy.approver(9211);
		// boolean approver1 = proxy.approver(9211);
		System.out.println(approver);
		// System.out.println(approver1);
		if (approver) {
			System.out.println("aprove");
		} else {
			System.out.println("Denide");
		}
	}
}

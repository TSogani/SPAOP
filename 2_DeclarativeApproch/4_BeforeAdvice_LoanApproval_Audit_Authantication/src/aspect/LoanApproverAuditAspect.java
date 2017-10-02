package aspect;

import org.aspectj.lang.JoinPoint;

import com.ba.util.AuthManager;

public class LoanApproverAuditAspect {

	AuthManager authManager; 
	
	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;
	}

	public void doAudit(JoinPoint jp){
		System.out.println("from doAudit");
		
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		// getting loggin user 
		System.out.println("called By : "+authManager.getLoggedUser());
		System.out.println("Enter into : "+methodName+" ("+args[0]+" )");
		
		
		
	
	}
}

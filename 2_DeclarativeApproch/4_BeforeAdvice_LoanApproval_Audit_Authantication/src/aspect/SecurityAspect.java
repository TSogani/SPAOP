package aspect;

import org.aspectj.lang.JoinPoint;

import com.ba.util.AuthManager;

public class SecurityAspect {
	
	AuthManager authManager ; 
	
	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;
	}

	// return type must be void 
	// joinPoint comes from org.aspectj.lang,JoinPoint
	
	public void doCheck(JoinPoint jp) throws IllegalAccessException{
		
		System.out.println("from docheck");
		if (authManager.authantication()== false) {
			throw new IllegalAccessException("enter correct username / password. ");
		}
	}
}
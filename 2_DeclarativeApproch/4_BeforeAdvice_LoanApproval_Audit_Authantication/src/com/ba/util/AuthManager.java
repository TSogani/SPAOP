package com.ba.util;

public class AuthManager {
	ThreadLocal<Cridential> cridentialWallet;
	Cridential cridential;

	public void setCridential(Cridential cridential) {
		this.cridential = cridential;
	}

	public AuthManager() {
		cridentialWallet = new ThreadLocal<Cridential>();
	}

	public void login(String username, String password) {
		cridential.setUserName(username);
		cridential.setPassword(password);
		cridentialWallet.set(cridential);
	}

	public void logout() {
		System.out.println("logOut : " + getLoggedUser());
		cridential = null;
	}

	public boolean authantication() {
		Cridential cridential = null;
		cridential = cridentialWallet.get();
		if (cridential != null) {
			if (cridential.getUserName().equals("john")
					&& cridential.getPassword().equals("welcome")) {
				return true;
			}
		}
		return false;
	}

	public String getLoggedUser() {
		Cridential cridential = null;
		String userName = null;
		cridential = cridentialWallet.get();
		if (cridential != null) {
			userName = cridential.getUserName();
			return userName;
		}
		return null;
	}
}

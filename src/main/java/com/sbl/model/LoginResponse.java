package com.sbl.model;

public class LoginResponse {
	private String token;

    private long expiresIn;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public LoginResponse(String token, long expiresIn) {
		super();
		this.token = token;
		this.expiresIn = expiresIn;
	}
    
    
}
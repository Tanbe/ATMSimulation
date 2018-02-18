package com.atm.sim.model;

public class ATM {
	
	
	private int current20Note;
	private int current50Note;
	private int currentBalance;
	private int user20Note;
	private int user50Note;
	private int userBalance;
	private int calculated20Note;
	private int calculated50Note;
    private String error;
    private String exception;
    private String numbers;
    
	public int getCurrent20Note() {
		return current20Note;
	}
	public void setCurrent20Note(int current20Note) {
		this.current20Note = current20Note;
	}
	public int getCurrent50Note() {
		return current50Note;
	}
	public void setCurrent50Note(int current50Note) {
		this.current50Note = current50Note;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	public int getUser20Note() {
		return user20Note;
	}
	public void setUser20Note(int user20Note) {
		this.user20Note = user20Note;
	}
	public int getUser50Note() {
		return user50Note;
	}
	public void setUser50Note(int user50Note) {
		this.user50Note = user50Note;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public int getCalculated20Note() {
		return calculated20Note;
	}
	public void setCalculated20Note(int calculated20Note) {
		this.calculated20Note = calculated20Note;
	}
	public int getCalculated50Note() {
		return calculated50Note;
	}
	public void setCalculated50Note(int calculated50Note) {
		this.calculated50Note = calculated50Note;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	
}

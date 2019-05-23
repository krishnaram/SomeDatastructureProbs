package com.example.amazon;

public enum WeekDays {
	 SUNDAY (0);
	 
	 private final int levelCode;

	 WeekDays(int levelCode) {
	        this.levelCode = levelCode;
	    }
	    
	    public int getLevelCode() {
	        return this.levelCode;
	    }
}

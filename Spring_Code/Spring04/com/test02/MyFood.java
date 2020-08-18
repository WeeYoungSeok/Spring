package com.test02;

public class MyFood {

	private Food favoriteFood;
	private Food unfavoriteFood;
	
	public MyFood() {
		
	}
	
	public MyFood(Food favoriteFood, Food unfavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unfavoriteFood = unfavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnfavoriteFood() {
		return unfavoriteFood;
	}

	public void setUnfavoriteFood(Food unfavoriteFood) {
		this.unfavoriteFood = unfavoriteFood;
	}
	
	public String toString() {
		return "favorite : " + favoriteFood + "\n" + "unfavortie : " + unfavoriteFood;
	}
}

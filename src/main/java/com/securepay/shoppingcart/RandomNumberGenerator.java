package com.securepay.shoppingcart;

import java.util.Random;

public class RandomNumberGenerator {

	public static double getRandomNumber(double min, double max, int precision) {
		double random = new Random().nextDouble();
		double convertedRandom = min + (random * (max - min));
		return formatDouble(convertedRandom, precision);
	}
	
	public static double formatDouble(double value, int precision) {
		return Double.parseDouble(String.format("%."+precision+"f", value));
	}
}

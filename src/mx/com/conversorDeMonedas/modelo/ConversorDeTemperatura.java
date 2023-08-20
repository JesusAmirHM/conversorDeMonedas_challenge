package mx.com.conversorDeMonedas.modelo;

public class ConversorDeTemperatura {

	/**
	 * Grados Celsisus (C) a difenetes temperaturas
	 * @param celsius
	 * @return
	 */

	public double celsiusToKelvin(double celsius) {
		double kelvin = (celsius + 273.1500000);
		return kelvin;
	}

	public double celsiusToFahrenheith(double celsius) {
		double fahrenheit = ((celsius * (9 / 5)) + 32);
		return fahrenheit;
	}

	public double celsiusToRankine(double celsius) {
		double rankine = ((celsius * (9 / 5)) + 491.67);
		return rankine;
	}

	/**
	 * Kelvin (K) a diferentes temperaturas
	 * @param kelvin
	 * @return
	 */

	public double kelvinToCelsius(double kelvin) {
		double celsius = (kelvin - (273.15));
		return celsius;
	}

	public double kelvinToFahrenheit(double kelvin) {
		double fahrenheit = (((kelvin - (273.15)) * 1.8) + 32);
		return fahrenheit;
	}

	public double kelvinToRankine(double kelvin) {
		double rankine = (kelvin * (1.8));
		return rankine;
	}

	/**
	 * Fahrenheit (F) a diferentes temperaturas
	 * @param fahrenheit
	 * @return
	 */

	public double fahrenheitToCelsius(double fahrenheit) {
		double celsius = ((fahrenheit - 32) / 1.8);
		return celsius;
	}

	public double fahrenheitToKelvin(double fahrenheit) {
		double kelvin = (((fahrenheit - 32) / 1.8) + 273.15);
		return kelvin;
	}

	public double fahrenheitToRankine(double fahrenheit) {
		double rankine = (fahrenheit + 459.67);
		return rankine;
	}

	/**
	 * Rankine (R) a diferentes temperaturas
	 * @param rankine
	 * @return
	 */

	public double rankineToCelsius(double rankine) {
		double celsius = ((rankine - 491.67) / 1.8);
		return celsius;
	}

	public double rankineToKelvin(double rankine) {
		double kelvin = (rankine / 1.8);
		return kelvin;
	}

	public double rankineToFahrenheit(double rankine) {
		double fahrenheit = (rankine - 459.67);
		return fahrenheit;
	}
}

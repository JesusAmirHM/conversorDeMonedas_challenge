package mx.com.conversorDeMonedas.modelo;

public class ConversorDeMonedas {

	/**
	 * Valor de 1 peso mexicano (MXN) en comparación de diferentes monedas (USD,
	 * EUR, GBP, JPY, KRW)
	 */

	double mxnUsd = 0.0599631;
	double mxnEur = 0.054427994;
	double mxnGbp = 0.046681032;
	double mxnJpy = 8.4678822;
	double mxnKrw = 76.359873;

	/**
	 * Metodos 1 Pesos mexicanos (MXN) ===> Dolar Estadounidense (USD) | Euros (EUR)
	 * 										| Libra Esterlina (GBP) | Yen Japones (JPY) | Won Sur Coreano (KRW)
	 * 
	 * @param cantidad
	 * @return
	 */

	public double pesosMexADolarUS(double cantidad) {
		double valor = cantidad * mxnUsd;
		return valor;
	}

	public double pesosMexAEuro(double cantidad) {
		double valor = cantidad * mxnEur;
		return valor;
	}

	public double pesosMexALibrasE(double cantidad) {
		double valor = cantidad * mxnGbp;
		return valor;
	}

	public double pesosMexAYen(double cantidad) {
		double valor = cantidad * mxnJpy;
		return valor;
	}

	public double pesosMexAWon(double cantidad) {
		double valor = cantidad * mxnKrw;
		return valor;
	}

	/**
	 * Metodos 2:          Dolar Estadounidense (USD) | Euros (EUR) 	===> Pesos Mexicanos (MXN) 
	 * Libra Esterlina (GBP) |Yen Japones (JPY) | Won Sur Coreano (KRW)
	 * 
	 * @param cantidad
	 * @return
	 */

	public double dolarUSAPesosMex(double cantidad) {
		double valor = cantidad / mxnUsd;
		return valor;
	}

	public double euroAPesosMex(double cantidad) {
		double valor = cantidad / mxnEur;
		return valor;
	}

	public double libraEAPesosMex(double cantidad) {
		double valor = cantidad / mxnGbp;
		return valor;
	}

	public double yenAPesosMex(double cantidad) {
		double valor = cantidad / mxnJpy;
		return valor;
	}

	public double wonAPesosMex(double cantidad) {
		double valor = cantidad / mxnKrw;
		return valor;
	}
}

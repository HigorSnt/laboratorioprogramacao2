package Prova1;

import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		LocalTime inicio = LocalTime.now();
		int hora = inicio.getHour();
		int min = inicio.getMinute();
		LocalTime fim = LocalTime.of(hora+1, min+1);
		System.out.println("Intervalo de tempo: " + (fim.getHour() - inicio.getHour()));

	}

}

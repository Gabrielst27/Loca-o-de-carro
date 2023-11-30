package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Locação;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Data inicial: ");
		String dataInicialStr = sc.nextLine();
		Date dataInicial = sdf.parse(dataInicialStr);
		System.out.print("Data final: ");
		String dataFinalStr = sc.nextLine();
		Date dataFinal = sdf.parse(dataFinalStr);
		System.out.print("Preço por hora: ");
		double valorPorHora = sc.nextDouble();
		System.out.print("Preço por dia: ");
		double valorPorDia = sc.nextDouble();
		
		Locação locação = new Locação(modelo, dataInicial, dataFinal, valorPorHora, valorPorDia);
		
		System.out.println("Valor Base: R$ " + String.format("%.2f", locação.valorBase()));
		System.out.println("Taxa: R$ " + String.format("%.2f", locação.taxa()));
		System.out.println("Valor Total: R$ " + String.format("%.2f", locação.valorTotal()));
		
		sc.close();
		
	}

}

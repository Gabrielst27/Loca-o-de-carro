package application;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Locação;
import entities.Veículo;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Dados do aluguel");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Retirada (dd/mm/yyyy/ hh:mm): ");
		LocalDateTime início = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/mm/yyyy/ hh:mm): ");
		LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);
		
		Locação locação = new Locação(início, fim, new Veículo(modelo));
		
		
		
		sc.close();
		
	}

}

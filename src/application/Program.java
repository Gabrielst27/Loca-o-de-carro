package application;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Locação;
import entities.Veículo;
import services.ServiçoLocação;
import services.TaxaBrasil;

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
		
		System.out.println("Preço por hora: ");
		double preçoPorHora = sc.nextDouble();
		System.out.println("Preço por dia: ");
		double preçoPorDia = sc.nextDouble();
		
		ServiçoLocação loc = new ServiçoLocação(preçoPorHora, preçoPorDia, new TaxaBrasil());
		
		loc.gerarFatura(locação);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento base: " + locação.getFatura().getValorBase());
		System.out.println("Imposto: " + locação.getFatura().getTaxa());
		System.out.println("Total: " + locação.getFatura().getValorTotal());
		
		sc.close();
		
	}

}

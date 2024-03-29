package com.pluralsight.bridge;

public class BridgeDemo {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("John Wick");
		movie.setRuntime("2:15");
		movie.setYear("2014");
		

		Formatter htmlFormatter = new HtmlFormatter();
		Formatter printFormatter = new PrintFormatter();
		
		Printer moviePrinter = new MoviePrinter(movie);
		
		String printedMaterial = moviePrinter.print(printFormatter);
		
		System.out.println(printedMaterial);
		
		String html = moviePrinter.print(htmlFormatter);
		
		System.out.println(html);
	}
}
package TravellingSalesman;
public class TravelMain {

	public static void main(String[] args) {
		int n = 1;
		TravelingSalesman salesman = new TravelingSalesman(13);
		salesman.printCosts(); 
		if(n==1){
			System.out.println("\n");
			Travel t = new Travel(salesman);
			t.run();
		} 
	}
}

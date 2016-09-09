package TravellingSalesman;

/**
 * This class encodes a traveling salesman problem in the form of n integer coordinates. 
 * 
 * @author Dinakar - http://www.theprojectspot.com/
 */
public class TravelingSalesman {
		
	private int[][] coordinates;
		
	private double[][] costs;
	int[] array = new int[11];
	int amountf=500;
	int amountc=300;//$500 for fuel and $300 for chemicals
	int amountr=120;//plane rent fee
	int amounth=100;//pilot fee per hour
	public int n;

	boolean[] visited;

	private static int[][] setCoordinates(int n) {
		int[][] coordinates = new int[13][3];
		coordinates[0][0] = 20; coordinates[1][0] = 84;coordinates[2][0] = 39; coordinates[3][0] = 84; coordinates[4][0] = 20; coordinates[5][0] = 34; coordinates[6][0] = 50; coordinates[7][0] = 95; coordinates[8][0] = 51; coordinates[9][0] = 1; coordinates[10][0] = 43; coordinates[11][0] = 78;    
		coordinates[0][1] = 20; coordinates[1][1] = 84;coordinates[2][1] = 39; coordinates[3][1] = 84; coordinates[4][1] = 20; coordinates[5][1] = 34; coordinates[6][1] = 50; coordinates[7][1] = 95; coordinates[8][1] = 51; coordinates[9][1] = 1; coordinates[10][1] = 43; coordinates[11][1] = 78;	
			
		return coordinates;
	}
	
	public TravelingSalesman(int[][] coordinates){
		this(coordinates, coordinates.length);
	}

	public TravelingSalesman(int n){
		this(setCoordinates(n));
	}
	
	public TravelingSalesman(int[][] coordinates, int n){
		this.n = n;
		
		visited = new boolean[n];
		costs = new double[n][n];
		
		this.coordinates = coordinates;

		initCostsByCoordinates();
	}

	private void initCostsByCoordinates() {
		for(int i = 0;i<coordinates.length;i++){
			for(int j = 0;j<coordinates.length;j++){
				costs[i][j] = calculateTravelCostsBetweenfields(i,j);
			}
		}
	}

	private double calculateTravelCostsBetweenfields(int i, int j){
		int dx = coordinates[i][0]-coordinates[j][0];
		int dy = coordinates[i][1]-coordinates[j][1];
		
		return Math.sqrt(dx*dx+dy*dy);
	}

	public double calculateCosts(int[] route){
		return calculateCosts(route, false);
	}
	
	public double calculateCosts(int[] route, boolean isVerbose){
		
		double travelCosts = 0;
		for (int i = 1; i < route.length; i++) {
			travelCosts += costs[route[i-1]][route[i]]; 
			
			if(isVerbose){
				System.out.println("costs from "+route[i-1]+" to "+route[i]+": "+costs[route[i-1]][route[i]]);
			}
			
		}
		travelCosts += costs[route[n-1]][route[0]];
		if(isVerbose){
			System.out.println("costs from "+route[n-1]+" to "+route[0]+": "+costs[route[n-1]][route[0]]);
		}
		return travelCosts;
	}
	
	public void printRoute(int[] route){
		System.out.println("Monday Flying Route:");
		System.out.print("0===>");
		for(int i = 1;i<route.length;i++){
			if(i%4==0){
				amountc=amountc + 300;
				
				System.out.print("0===>");
			}
			if(i%8==0){
				amountf = amountf + 500;
			}
			System.out.print(route[i]+"===>");
			
		}
		System.out.print("0\n");
		amountr=amountr+amountr; // plane rent for first trip
		amounth=amounth+amounth;
		int len = route.length;
		System.out.println("\nTuesday Flying Route:");
		System.out.print("0===>");
		for(int j = len-1;j>=1;j--){
			if(route[j]==1||route[j]==6||route[j]==4)
			{
				System.out.print("0===>");
			}
			if(j%4==0){
				amountc = amountc + 300;
	
			}
			if(j%8==0){
				amountf = amountf + 500;
			}
			System.out.print(route[j]+"===>");
			 // pilot fee for second trip
		}
		System.out.print("0\n");
		amountr=amountr+amountr; // plane rent for second trip
		amounth=amounth+amounth;
	
		int t= amountf+amountc+amountr+amounth;
		System.out.println("\n"+"Amount for fuel $"+amountf);
		System.out.println("Amount for chemicals $"+amountc);
		System.out.println("Amount for plane rent $"+amountr);
		System.out.println("Amount for pilot fee $"+amounth);
		System.out.println("Total amount for the two days of crop dusting $"+t);
		
	}
	
	public void printCosts(){
		System.out.println("Costs matrix for the airplane" + "\n");
		for(int i = 0;i<costs.length;i++){
			for(int j = 0;j<costs[i].length;j++){
				System.out.print(costs[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
}
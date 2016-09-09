package TravellingSalesman;

public class Travel {

	private TravelingSalesman salesman;
	
	private double minCosts;
	
	private int[] minRoute;
	
	private long count;
	
	public Travel(TravelingSalesman salesman){
		this.salesman = salesman;
	}

	public void run() {
		int[] route = new int[salesman.n];
		minRoute = new int[salesman.n];
		
		minCosts = -1;
		
		count = 0;
		
		route[0] = 0;
		
		for(int i = 1;i < salesman.n;i++){
			route[1] = i;
			checkRoute(route,2);
		}
		
		System.out.println("Minimum cost for travel: "+minCosts+" \n" + "Route through the fields starting from home(0):-  ");
		System.out.println("I have numbered the nodes on the graph as per the question (0 depicts farmer's home) \n ");
		salesman.printRoute(minRoute);
		
		
	}
	
	private void checkRoute(int[] route, int offset){
		
		if(offset == salesman.n){
			count++;
			
			if(count%100 == 0){
			
			}
			
			double cost = salesman.calculateCosts(route);
			if(minCosts < 0 || cost < minCosts){
				minCosts = cost;
				System.arraycopy(route,0,minRoute,0,route.length);
			}
			
			return;
		}
		
		loop: for(int i = 1;i<salesman.n;i++){
			for(int j = 0;j<offset;j++){
				if(route[j] == i){
					continue loop;
				}
			}
			
			route[offset] = i;
			checkRoute(route,offset+1);
		}
	}
}
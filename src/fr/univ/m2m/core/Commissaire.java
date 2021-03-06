package fr.univ.m2m.core;


public class Commissaire {

	//identifier for the agent
	private String id;
	private ObjectAuction obj = new ObjectAuction() ;
	//server side of the Agent to accept new communications with new agents
	private Incoming incoming = null;
	
	/**
	 * Constructor
	 * @param args 3 arguments: <id> <incoming port> <outgoing port>
	 */
	public Commissaire(String[] args) {
	
		//set the agent id
		id = args[0];
                this.obj.objectName = args[2];
                this.obj.objectPrice = Integer.parseInt(args[3]);
                this.obj.currentAuction = this.obj.objectPrice;
		
		//print some details
		System.out.println("Agent " + id + " is executed");
		
		//set the socket server for incoming messages
                
		incoming = new Incoming(args[1],this.obj);
		incoming.start();
		
                incoming = new Incoming("1235",this.obj);
		incoming.start();
			
                
                
		//if the agent id is Cartman, it initiates the protocol
		//with Kenny
                /*
		if (id.equals("Comissaire")) {
			
			Outgoing outgoing = new Outgoing("10.7.254.69", "1900");
			outgoing.start();
			
		} //if
		*/
	} //constructor
	
	/**
	 * Entry point for the Agent
	 * @param args 3 arguments have to be provided: id, incoming port
	 */
	public static void main(String[] args) {
	
		if (args.length == 4) 
			new Commissaire(args);
		else {
		
			System.out.println("Agent usage:");
			System.out.println("java Agent <id> <incoming port>");
			
		} //else
		
	} //main()
	
} //class Agent

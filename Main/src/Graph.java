
import java.io.*; 
import java.util.*; 

class Graph 
{ 
    int Sommet;  
	private int arcs;	
    private Integer[][] graphe; 
	private  List<List<Integer>> graphcircuit; 
 
    Graph(int v, int arc) { 
        Sommet = v;
        this.arcs= arc;
        graphe = new Integer [v][v];
      
        for(int i = 0; i< Sommet;i++)
		{
			for(int j = 0;j<Sommet; j++)
			{			
				graphe[i][j] = null;
			}
		
		}
  
		graphcircuit = new ArrayList<>(v); 
          
        for (int i = 0; i < v; i++) 
            graphcircuit.add(new LinkedList<>()); 
    } 

	void addEdge(Integer depart,Integer arrivee, int poids) 
	{  //c'est ici que tu dois enregistrer le graphs
        
		graphe[depart][arrivee] = poids;
		
		graphcircuit.get(depart).add(arrivee);
	
		
    } 

	
	
	void valeur_tab()
	{
		System.out.println("Matrice des valeurs");
		System.out.print("  ");
		for(int k = 0;k<Sommet; k++)
		{
			if(k<10)
			{
				System.out.print(" " +k + " ");
			}
			else 
				System.out.print(" "+k );
		}
		System.out.println("");
		for(int i = 0; i< Sommet;i++)
		{   System.out.print(i + " ");
			for(int j = 0;j<Sommet; j++)
			{
				if( i<10) 
				{
					if(graphe[i][j] == null)
					{
						System.out.print(" * ");
					}
					else 
						System.out.print(" "+graphe[i][j]+" ");
				}
				else 
					if(graphe[i][j] == null)
					{ 
						System.out.print("*  ");
					}
					else 
						System.out.print(graphe[i][j]+"  ");
				
					
				
			}
			System.out.println("");
		}
	}
	void adjacence_tab()
	{   
		
		System.out.println("Matrice d'adjacence");
		System.out.print("  ");
		for(int k = 0;k<Sommet; k++)
		{
			if(k<10)
			{
				System.out.print(" " +k + " ");
			}
			else 
				System.out.print(" "+k );
		}
		System.out.println("");
		for(int i = 0; i< Sommet;i++)
		{   System.out.print(i + " ");
			for(int j = 0;j<Sommet; j++)
			{
				if( i<10) 
				{
					if(graphe[i][j] == null)
					{
						System.out.print(" 0 ");
					}
					else 
						System.out.print(" 1 ");
				}
				else 
					if(graphe[i][j] == null)
					{
						System.out.print("0  ");
					}
					else 
						System.out.print("1  ");
				
			}
			System.out.println("");
		}
	}
    void affiche_rang(ArrayList<Integer> rang)
    {
    	System.out.println("Calcul rang par sommet : "); 
    	System.out.println("");
    	System.out.print("Sommet  ");	
    	for(int i =0 ; i< rang.size() ;i++)
    	{
    		System.out.print(i + "  ");
    	}
    	System.out.println("  ");
    	System.out.print("Rang    ");
    	for(int i =0 ; i< rang.size() ;i++)
    	{
    		
    		if(i>9)
    		{
    			System.out.print(" " +rang.get(i)+ "  ");
    		}
    		else
    			System.out.print( rang.get(i)+ "  ");
    	}
    }
    void affiche_plustot(ArrayList<Integer> ord)
    {
    	System.out.println("Calcul date au plus tot par sommet : ");
    	System.out.println("");
    	System.out.print("Sommet               ");	
    	for(int k =0 ; k< ord.size() ;k++)
    	{

			if(k<10)
			{
				System.out.print(" " +k + " ");
			}
			else 
				System.out.print(" "+k );
    	}
    	System.out.println("  ");
    	System.out.print("Date au plus tot      ");
    	for(int i =0 ; i< ord.size() ;i++)
    	{
    		
    		if(ord.get(i)<=9)
    		{
    			System.out.print(ord.get(i)+ "  " );
    		}
    		else
    			System.out.print( ord.get(i)+ " ");
    	}
    }
    void affiche_plustard(ArrayList<Integer> ord)
    {
    	System.out.println("\n\n Calcul date au plus tard par sommet : ");
    	System.out.println("");
    	System.out.print("Sommet               ");	
    	for(int k =0 ; k< ord.size() ;k++)
    	{

			if(k<10)
			{
				System.out.print(" " +k + " ");
			}
			else 
				System.out.print(" "+k );
    	}
    	System.out.println("  ");
    	System.out.print("Date au plus tard     ");
    	for(int i =0 ; i< ord.size() ;i++)
    	{
    		
    		if(ord.get(i)<=9)
    		{
    			System.out.print(ord.get(i)+ "  " );
    		}
    		else
    			System.out.print( ord.get(i)+ " ");
    	}
    }
    void affiche_marge(ArrayList<Integer> ord)
    {
    	System.out.println("\n\nMarge totale par sommet : ");
    	System.out.println("");
    	System.out.print("Sommet             ");	
    	for(int k =0 ; k< ord.size() ;k++)
    	{

			if(k<10)
			{
				System.out.print(" " +k + " ");
			}
			else 
				System.out.print(" "+k );
    	}
    	System.out.println("  ");
    	System.out.print("Marge totale        ");
    	for(int i =0 ; i< ord.size() ;i++)
    	{
    		
    		if(ord.get(i)<=9)
    		{
    			System.out.print(ord.get(i)+ "  " );
    		}
    		else
    			System.out.print( ord.get(i)+ " ");
    	}
    }
	void affiche_graph()
	{
		System.out.println("Sommets ="+this.Sommet);
		System.out.println("Arcs ="+this.arcs);
		for(int i =0 ; i<graphe.length; i++)
		{
			for(int j =0 ; j<graphe.length; j++)
			{
				if(graphe[i][j] != null)
				System.out.println(i+" -> "+j+" = " +graphe[i][j]);
			}
		}
		System.out.println("");
		
	}
	Integer [][] get_tab()
	{
		return graphe;
	}
    

    ArrayList<Integer> jinvoquelesprede(Integer sommet)
    {	
    	ArrayList<Integer>  aide = new ArrayList<>(); 
		
    	for(int i = 0; i < graphe.length; i++)
    	{
	    	if(graphe[i][sommet] != null)
	    	{ 
	    		aide.add(i);
	    	}   		
    	}
    	
    	return aide;     	
    }    
    
    ArrayList<Integer> jinvoquelessucc(Integer sommet)
    {	
    	ArrayList<Integer>  aide = new ArrayList<>(); 
		
    	for(int i = 0; i < graphe.length; i++)
    	{
	    	if(graphe[sommet][i] != null)
	    	{ 
	    		aide.add(i);
	    	}   		
    	}
    	
    	return aide;     	
    }
    
    
    ArrayList<Integer> Def_my_rank()
    {
		
    	ArrayList<Integer>  liste_rang = new ArrayList<>(); 
    	
    	for(int i = 0; i < graphe.length; i++)
    	{
	    	liste_rang.add(null); 		
    	}
    	for(int i = 0; i < graphe.length; i++)
    	{
	    	var pred = jinvoquelesprede(i);
	    	if(pred.isEmpty()) 
	    	{
	    		liste_rang.set(i, 0);
	    	}
    	}
    	while(liste_rang.contains(null)  )
    	{
    		
    		for(int i = 0 ; i< graphe.length; i++)
    		{
    			if(liste_rang.get(i) !=null )
    			{
    				continue;
    			}
    			
    			var pred = jinvoquelesprede(i);
    			boolean nul = false;
    			Integer max_rang = -1;
    			for(int j = 0; j < pred.size();j++)
    			{
    				if(liste_rang.get(pred.get(j)) == null)
    				{
    					nul = true;
    				}
    				else if(liste_rang.get(pred.get(j)) > max_rang)
    				{
    					max_rang = liste_rang.get(pred.get(j));
    				}
    			}
    			if (nul == true)
    			{
    				continue;
    			}
    			liste_rang.set(i, max_rang +1);
    				
    		}
    	}
    	return liste_rang;
    	
    }
    
    

    private boolean isCyclicUtil(int i, boolean[] deja_visite, 
            boolean[] pile_recursive) 
    { 

		if (pile_recursive[i]) 
		{
		return true; 
		}
		
		if (deja_visite[i]) 
		{
		return false;
		}
		
		deja_visite[i] = true; 
		pile_recursive[i] = true; 
		List<Integer> enfant = graphcircuit.get(i); 
		
		for (Integer c: enfant) 
		if (isCyclicUtil(c, deja_visite, pile_recursive)) 
		return true; 
		
		pile_recursive[i] = false; 
		
		return false; 
    } 

    
    private boolean isCyclic() 
    { 
        
        boolean[] deja_visite = new boolean[Sommet];
		boolean[] pile_recursive = new boolean[Sommet]; 		
        for (int i = 0; i < Sommet; i++) 
            deja_visite[i] = false; 
  
       
        for (int u = 0; u < Sommet; u++) 
            if (!deja_visite[u]) 
                if (isCyclicUtil(u, deja_visite, pile_recursive)) 
                    return true; 
  
        return false; 
    } 
      
    
    ArrayList<Integer> Liste_entree()
    {
    	ArrayList<Integer>  liste_entree = new ArrayList<>();    
    	for(int i = 0; i < graphe.length; i++)
    	{
    		
	    	var pred = jinvoquelesprede(i);
	    	if(pred.isEmpty()) 
	    	{
	    		liste_entree.add(i);
	    	}
    	}  	
    	return liste_entree;
    }
     
    ArrayList<Integer> Liste_sortie()
    {
    	ArrayList<Integer>  liste_sortie = new ArrayList<>(); 
    	for(int i = 0; i < graphe.length; i++)
    	{
    		
	    	var pred = jinvoquelessucc(i);
	    	if(pred.isEmpty()) 
	    	{
	    		liste_sortie.add(i);
	    	}
    	}  	
    	
    
    	return liste_sortie;
    	
    }
   
    
    ArrayList<Integer> plutotcall()
    { 
    	
    	
    	var ord = new ArrayList<Integer>();
    	var entree= Liste_entree().get(0);
    	for(int i = 0; i < Sommet; i++)
    	{
    		ord.add(null);
    	}	
		ord.set(entree, 0);
		var succ = jinvoquelessucc(entree);
		for(int j = 0 ; j<succ.size();j++)
		{
			 plutotbis(succ.get(j),ord);
		}
    	return ord;
  }
        
    void plutotbis(Integer Sommet, ArrayList<Integer> ord)
    {
		
    	var preds = jinvoquelesprede(Sommet);
    	
    	for(Integer pred : preds )
    	{
    		if(ord.get(pred)==null || ord.get(Sommet) != null )
    		{
    			return;
    		}
    		
    		
    	}
    	Integer max_ord = -1;
    	
    	for(Integer pred : preds )
    	{
    		var curr = ord.get(pred) + graphe[pred][Sommet];
    		
    		if (max_ord < curr)
    		{
    			max_ord = curr;   		
    		}
    	}
    	ord.set(Sommet, max_ord);
    	var succs = jinvoquelessucc(Sommet);
    	for(Integer succ : succs )
    	{
    		plutotbis(succ,ord);
    	}
  	
    }
   
   ArrayList<Integer> plutardcall(Integer plustotlast)
    { 
    	
    	
    	var ord = new ArrayList<Integer>();
    	var sortie= Liste_sortie().get(0);
    	for(int i = 0; i < Sommet; i++)
    	{
    		ord.add(null);
    	}	
		ord.set(sortie,plustotlast );
		var pred = jinvoquelesprede(sortie);
		for(int j = 0 ; j<pred.size();j++)
		{
			 plutardbis(pred.get(j),ord);
		}
    	return ord;
  }
    
    void plutardbis(Integer Sommet, ArrayList<Integer> ord)
    {
		
    	var succs = jinvoquelessucc(Sommet);
    	
    	for(Integer succ : succs  )
    	{
    		if(ord.get(succ)==null || ord.get(Sommet) != null )
    		{
    			return;
    		}
    		
    		
    	}
    	Integer min_ord = 9999;
    	
    	for(Integer succ : succs )
    	{
    		var curr = ord.get(succ) - graphe[Sommet][succ];
    		
    		if (min_ord > curr)
    		{
    			min_ord = curr;   		
    		}
    	}
    	ord.set(Sommet, min_ord);
    	var preds = jinvoquelesprede(Sommet);
    	for(Integer pred : preds )
    	{
    		plutardbis(pred,ord);
    	}
  	
    }
   
    ArrayList<Integer> marge_ord(ArrayList<Integer> plus_tot,ArrayList<Integer> plus_tard)
    {
		
    	var marge = new ArrayList<Integer>();
      	for(int i = 0; i < Sommet; i++)
    	{
    		marge.add(null);
    	}
      	
      	for(int i = 0; i < Sommet; i++)
      	{
      		marge.set(i, plus_tard.get(i) - plus_tot.get(i));
      	}
    	return marge;
    	
    }
 
    
    Integer sum_succ(Integer i)
    {
    	Integer Sum= 0 ;
    	var succ = jinvoquelessucc(i);   
    	
    	for(int j = 0; j < succ.size(); j++ )
    	{
    		if(graphe[i][succ.get(j)] != null)
    		{
    		    Sum += graphe[i][succ.get(j)];
    		}
    	}
    	
    	return Sum;
    }
    
    boolean val_id()
    {
    	
    	
    	for(int i = 0; i < graphe.length; i++)
    	{
    		if(Liste_entree().contains(i) || Liste_sortie().contains(i) ) 		
    		{

    			continue;
    		}
    		
    		else {
    			Integer tmp = graphe[i][jinvoquelessucc(i).get(0)];
    			for(int j = 0; j < jinvoquelessucc(i).size();j++)
    			{
    				if (tmp != graphe[i][jinvoquelessucc(i).get(j)])
    				{
    				
    					return false;
    				}
    				
    			}
    		}
    		
    		
    	}
		return true;
    	
    	
    } 
    
    boolean neg_arc()
    {
    	for(int i = 0 ; i< graphe.length;i++)
    	{
    		for(int j = 0 ; j< graphe.length;j++)
        	{
        		if(graphe[i][j] != null) 
        		{
        			if(graphe[i][j] < 0)
        			{
        				return false;
        			}
        		}
        	}
    	}
    	return true;
    }
    
     boolean Ordonnancement()
    {
    	 
      	if(Liste_entree().size() != 1)
      	{
      		System.out.println("Plusieurs entrées !");
      		return false;
      	}
     	if(Liste_sortie().size() != 1)
      	{
     		System.out.println("Plusieurs sorties !");
     		return false;
      	}
      	
      	if(isCyclic())
      	{
      		System.out.println(" Cycle !");
      		return false;
      	}
      	if(!val_id())
      	{
      		System.out.println("Pas de valeurs identiques pour tous les arcs incidents vers l’extérieur à un sommet");
      		return false;
      	}
      	if(sum_succ(Liste_entree().get(0))  != 0)
      	{
      		System.out.println("Entrée pas égales a 0");
      		return  false;
      	}
      	if(!neg_arc())
      	{
      		System.out.println("Poids négatif(s) !");
      		return false;
      	}
    	
    	return true;
    }
    public static void main(String[] args) throws IOException 
    { 
    	boolean continuer = false;
       do { 
    	Scanner sc = new Scanner(System.in);
		Integer sommet = 0;
		Integer arc = 0;
		System.out.println("Quel fichier ? :");
		String fichier = sc.nextLine();
		String path = "src\\graphes\\" + fichier;
	
		path.concat(fichier);
		System.out.println(path);
		System.out.println(fichier);
		BufferedReader br = null;
		
			br = new BufferedReader(new FileReader(path));
		
		String line;
		String[] mot;
		ArrayList<Integer> nombres = new ArrayList<Integer>();
		
			while ((line = br.readLine()) != null) 
			{
				  mot = line.split (" ");
			         for (int i = 0; i < mot.length; i++)
			         {
			             nombres.add(Integer.parseInt(mot[i]));
			         }
			}
		sommet = nombres.get(0);
		arc=nombres.get(1);
		Integer valeur =2;
		Graph graph = new Graph(sommet, arc); 
		System.out.println("");
		for(int i = 0 ; i < arc  ;i++)
		{
			graph.addEdge(nombres.get(valeur), nombres.get(valeur+1), nombres.get(valeur+2));
			valeur+=3;
		}
		br.close();
		graph.affiche_graph();
        graph.adjacence_tab();
        System.out.println("");
        graph.valeur_tab();
        System.out.println("");
        if(graph.isCyclic()) 
        {
            System.out.println("Le Graphe contient un circuit"); 
        }
        else
        {
        	
        	System.out.println("Le Graphes ne contient pas de circuits"); 
        	System.out.println("");
	        System.out.println("Suite..");
	        System.out.println("");
	        graph.affiche_rang(graph.Def_my_rank());
	        System.out.println("");
	        if (graph.Ordonnancement())
	        {
		        var plutot_appel = graph.plutotcall();
		        var tmp = plutot_appel.stream().max(Comparator.naturalOrder());
		        graph.affiche_plustot(plutot_appel);
		        var plutard_appel = graph.plutardcall(tmp.get());
		        graph.affiche_plustard(plutard_appel);
		        var marge_tot = graph.marge_ord(plutot_appel, plutard_appel);
		        graph.affiche_marge(marge_tot);
	        }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Continuer ? : true/false");
		 continuer = sc.nextBoolean();
       }while(continuer);
   
       
    } 
    
   
}  


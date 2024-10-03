/*Devoir 3 OOP 
 * Lokmen Abid 
 * */

package Exam;
import java.util.ArrayList;
import java.util.Scanner;



// La class GestionnaireMotos
public class GestionnaireMotos {
	
	private static ArrayList<Moto> listeMotos = new ArrayList<Moto>();
	private static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		/* ça nous permet de créer la liste et sa manipulation*/
		boolean condition = false;

		while (!condition) {
			int choixMenu = afficherMenu();

			switch (choixMenu) // ce switch permet d'effectuer les actions relatives au choix
			{
			case 1: //  Creer un nouveau Moto et l'ajouter à la liste
				creerAjouterMoto();
				break;
			case 2: //  Afficher tous les Motos de la liste
				afficherMoto();
				break;

			case 3: // Supprimer une moto
				supprimerMoto();
				break;
			case 4: // Augmenter le kilométrage d'une moto
				AugmenterKilometrageMoto();
				break;
			case 5: // Comparer les kilométrage entre les motos
				ComparaisonKilometrageMoto();
				break;
			case 6: // Creer et ajouter de 4 objet prédéfinies à la liste des motos
				createPredefinedMoto();
				break;
			case 0:
				condition = true;
				break;

			default:
				System.out.println("entrez un nombre entre 1 et 5");
				break;

			}
		}
		scan.close();
	}

	/**
	 * Affiche les choix du menu
	 */
	private static int afficherMenu() {
		System.out.println("\n\n--Menu de gestion de Moto--");
		System.out.println("Option\t|");
		System.out.println("1\t| Creer un nouveau Moto et l'ajouter à la liste");
		System.out.println("2\t| Afficher tous les Motos de la liste");
		System.out.println("3\t| Supprimer une moto");
		System.out.println("4\t| Augmenter le kilométrage d'une moto");
		System.out.println("5\t| Comparer les kilométrage entre les motos");
		System.out.println("6\t| Creer et ajouter de 4 objet prédéfinies à la liste des motos");
		System.out.println("\t|");
		System.out.println("0\t| quitter");

		// Saisie du choix
		int choix = -1;
		try {
			choix = Integer.parseInt(scan.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Cela n'est pas un nombre.");
		}

		return choix;
	}
	
	// méthode private permettant de créer un nouveau Moto et l'ajouter dans la liste 
	private static void creerAjouterMoto() {
		//nous permet de créer un sous menu pour les marques de moto 
		System.out.println("Entrez la marque de la moto : \n");
        afficherMarques();
        int choixMarque = scan.nextInt();
        Marques marque = Marques.values()[choixMarque - 1];
		
		// les variables locales dans la méthode 
		String modele;
		int annee;
		String couleur;
		double kilometrage; 

		// on demande de l'utilisateur de donner les valeurs de variables 
		System.out.println("Veuillez entrer Le Modèle de moto : \n");
		modele = scan.nextLine();
		System.out.println("Veuillez entrer Le Couleur de moto : \n");
		couleur = scan.nextLine();
		System.out.println("Veuillez entrer l'Annee de création de moto : \n");
		annee = scan.nextInt();
		System.out.println("Veuillez entrer le kilométrage de moto : \n");
		kilometrage = scan.nextDouble();

		scan.nextLine();
		
		// on ajout la moto créer dans la liste 
		listeMotos.add(new Moto(marque,modele, annee,couleur,kilometrage));
	}
	
	// cette méthode pour afficher les marques sous forme de sous-menu 
	private static void afficherMarques() {
        System.out.println("Marques disponibles :");
        Marques[] marques = Marques.values();
        for (int i = 0; i < marques.length; i++) {
            System.out.println((i + 1) + ". " + marques[i]);
        }
    }
	
	// cette méthode nous permet d'affchier tous les motos dans la liste  
	private static void afficherMoto() {
		int length = listeMotos.size(); 
		// cette partie de code pour vérifier si la liste est vide ou non 
		if (length == 0) {
			System.out.println("La liste des Motos est vide");
			return;
		}
		for (int i =0 ; i<length ; i++) {
			System.out.println(listeMotos.get(i));
		}
	}
	
	//cette méthode pour supprimer une moto choisi par l'utilisateur 
	  private static void supprimerMoto() {
			int length = listeMotos.size(); 
			// cette partie de code pour vérifier si la liste est vide ou non 
	        if (length == 0) {
	            System.out.println("Il n'y a pas de moto dans la liste.");
	        } else {
	            System.out.println("Entrez le numéro de la moto à supprimer :");
	            afficherMoto();// cette ligne pour afficher les motos comme sous-menu 
	            int choix = scan.nextInt();
	            if (choix > 0 && choix <= length) {
	                Moto moto_supp = listeMotos.remove(choix - 1);
	                System.out.println("Moto supprimée : " + moto_supp);
	            } else {
	                System.out.println("Numéro de moto invalide.");
	            }
	        }
	    }
	  
	  // cette méthode pour augmenter le kilometrage d'une moto 
	  private static void AugmenterKilometrageMoto() {
			int length = listeMotos.size(); 
			// cette partie de code pour vérifier si la liste est vide ou non 
	        if (length == 0) {
	            System.out.println("Il n'y a pas de moto dans la liste.");
	        } else {
	            System.out.println("Entrez le numéro de la moto à ajouter kilometrage :");
	            afficherMoto();// cette ligne pour afficher les motos comme sous-menu
	            int choix = scan.nextInt();
	            if (choix > 0 && choix <= length) {
	            	System.out.println("donner le kilometrage tu veux ajouter "); 
	            	double kilo =  scan.nextDouble();
	            	listeMotos.get(choix - 1).augmenterKilo(kilo);
	            } else {
	                System.out.println("Numéro de moto invalide.");
	            }
	        }
	    }
	  
	  // cette méthode pour faire une comparaison de kilometrage entre deux moto : 
	  private static void ComparaisonKilometrageMoto() {
			int length = listeMotos.size(); 
			// cette partie de code pour vérifier c'est la liste a deux ou plus de moto : 
	        if (length < 2) {
	            System.out.println("Il y a moins que deux moto dans la liste.");
	        }  
	            
	        System.out.println("Entrez le numéro de la 1er moto à comparer kilometrage:");
	        int moto1= scan.nextInt();
	        
	        System.out.println("Entrez le numéro de la 2eme moto à comparer kilometrage:");
	        int moto2= scan.nextInt();
	        
	        
	        double moto1_kilo = listeMotos.get(moto1-1).getKilometrage(); 
	        double moto2_kilo = listeMotos.get(moto2-1).getKilometrage(); 

	        if (Math.abs(moto1_kilo - moto2_kilo) <= 0.001)
				System.out.println("Les kilometrage des deux Motos sont consideres égaux");
			else if (moto1_kilo > moto2_kilo)
				System.out.println("Le kilometrage du Moto 1 est plus eleve");
			else
				System.out.println("Le kilometrage du Moto 2 est plus eleve");
	        
	    }
	  
	  
	  // cette méthode pour créer 4 objet de moto prédefinies et l'ajouter dans la liste : 
	  private static void createPredefinedMoto() {
		  Moto m1 = new Moto(Marques.Honda,"SupraFit",2019,"Noir",147.19); 
		  Moto m2 = new Moto(Marques.Kawasaki,"Ninja",2021,"Noir",160.87); 
		  Moto m3 = new Moto(Marques.Yamaha,"Nmax",2017,"Noir",187.94); 
		  Moto m4 = new Moto(Marques.Triumph,"Twin",2022,"Noir",69.47); 
		  
		  listeMotos.add(m1); 
		  listeMotos.add(m2); 
		  listeMotos.add(m3); 
		  listeMotos.add(m4); 
		  
		  System.out.println("Les Motos Prédefinies : \n" + m1 + "\n" + m2 + "\n" + 
		  m3 + "\n" + m4 );
		  
	  }
	  
	
}



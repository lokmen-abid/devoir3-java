/*Devoir 3 OOP 
 * Lokmen Abid 
 * */

package Exam;


//La class Moto
public class Moto {
	
	// on déclare les variables d'instance suivants : 
	private Marques marque ; 
	private String modele ; 
	private int annee ; 
	private String couleur ; 
	private double kilometrage ;
	
	
	// on déclare le constructeur avec tous les variables d'instances 
	public Moto(Marques marque, String modele, int annee, String couleur, double kilometrage) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.couleur = couleur;
		this.kilometrage = kilometrage;
	}
	
	// une méthode augmenterKilo qui nous permet d'augmenter la valeur de kilometrage initiale 
	public  void augmenterKilo(double X) {
		 this.kilometrage+= X; 
	}
	
	// La méthode ToString pour afficher l'objet Moto
	public String toString() {
		return "Moto [marque=" + marque + ", modele=" + modele + ", annee=" + annee + ", couleur=" + couleur
				+ ", kilometrage=" + kilometrage + "]";
	}


	// Ici tous les accesseur et les mutateurs pour tous les variables d'instances : 
	public Marques getMarque() {
		return marque;
	}


	public void setMarque(Marques marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public double getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}


}

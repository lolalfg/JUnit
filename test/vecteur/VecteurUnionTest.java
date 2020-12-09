package vecteur;

import java.util.Vector;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class VecteurUnionTest {

	// Definition du type de variable
	private Vector vecteur1;
	private Vector vecteur2;
	private Vector vecteurUnion;

	@BeforeAll
	void installationDonnee() {

		// Initialisation des variables
		vecteur1 = new Vector<>();
		vecteur2 = new Vector<>();
		vecteurUnion = new Vector<>();
		
		//Ajout d'elements dans les vecteurs
		vecteur1.addElement(1);
		vecteur1.addElement(2);
		vecteur1.addElement(3);
		vecteur1.addElement(4);
		vecteur1.addElement(5);

		//Ajout d'elements dans les vecteurs
		vecteur2.addElement(6);
		vecteur2.addElement(7);
		vecteur2.addElement(8);
		vecteur2.addElement(9);
		vecteur2.addElement(10);

		//Merge des deux vecteurs en un 
		vecteurUnion = VecteurUnion.unionSet(vecteur1, vecteur2);

	}

	@AfterAll
	public void destructionDonnee() {
		
		//Destruction des donnees
		vecteur1 = null;
		vecteur2 = null;
		vecteurUnion = null;
	}

	@Test
	void elementAt() {
		
		//On verifie si "nombre" est egale à i + 1 
		for (int i = 0; i < vecteurUnion.size(); i++) {
			Integer nombre = (Integer) vecteurUnion.elementAt(i);
			assertTrue(nombre.intValue() == i + 1);
		}
	}

	@Test
	void removeAndCheck() {
		
		//Supprime un element dans le "vecteurUnion"
		vecteurUnion.remove(4);
		int i = 1;

		//On verifie l'ordre final
		for (Object valeur : vecteurUnion) {
			if (i != 4) {
				assertTrue((int) valeur == i);
				i++;
			}
		}

	}

}

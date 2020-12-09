package vecteur;


import java.util.Vector;


public class VecteurUnion {

	    
	private Vector vecteur1;
    private Vector vecteur2;

    public static Vector<Object> unionSet(Vector<Object> vecteur1, Vector<Object> vecteur2) {
        Vector<Object> result = new Vector<Object>();
        result.addAll(vecteur1);
        result.addAll(vecteur2);
        return result;
    }

	}



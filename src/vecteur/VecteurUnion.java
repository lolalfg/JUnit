package vecteur;


import java.util.Vector;
import java.util.stream.Collectors;

public class VecteurUnion {

	    
	    public static Vector<Object> vecteurUnionSet(Vector<Object> vecteurA, Vector<Object> vecteurB) {
	        Vector<Object> m = new Vector<Object>();

	        m.addAll(vecteurA);
	        m.addAll(vecteurB);
	        m.stream().distinct().collect(Collectors.toCollection(Vector::new));
	        return m;
	    }

	    public static void main(String[] args) {
	        Vector<Object> test1 = new Vector<Object>() {
	            private static final long serialVersionUID = 1L;

	            {
	                add(1);
	                add("1");
	            }
	        };
	        Vector<Object> test2 = new Vector<Object>() {
	            private static final long serialVersionUID = 1L;

	            {
	                add(1.00);
	            }
	        };

	        Vector<Object> test3 = VecteurUnion.vecteurUnionSet(test1, test2);

	        System.out.println(test3.size());
	        System.out.println(test3);
	    }

	}



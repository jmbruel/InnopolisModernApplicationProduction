import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class MatriceEntierOperationsTest extends TestCase {
  static int totalAssertions = 0;
  static int bilanAssertions = 0;

  /*
   Types des operations du type MatriceEntier
  */
  public void test_type_new_MatriceEntier() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;

    totalAssertions++ ;
    assertEquals("new MatriceEntier(3,3) retourne une MatriceEntier", "MatriceEntier", m.getClass().getName());
    bilanAssertions++ ;
  }

  public void test_type_get() throws Exception {
    MatriceEntier m = new MatriceEntier(3,4) ;

    totalAssertions++ ;
    assertTrue("getNbLignes() > 0", m.getNbLignes() > 0);
    bilanAssertions++ ;

    totalAssertions++ ;
    assertTrue("getNbColonnes() > 0", m.getNbColonnes() > 0);
    bilanAssertions++ ;

    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertTrue("getElement() retourne un entier", (m.getElement(i,j) >= 0) || (m.getElement(i,j) < 0));
      bilanAssertions++ ;
     }
    }
  }

  public void test_type_som() throws Exception {
    MatriceEntier m = new MatriceEntier(3,4) ;

    for (int i=0; i<m.getNbLignes(); i++) {
      totalAssertions++ ;
      assertTrue("somLigne("+i+") >= 0", m.somLigne(i) >= 0);
      bilanAssertions++ ;
    }
    for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertTrue("somColonne("+j+") >= 0", m.somColonne(j) >= 0);
      bilanAssertions++ ;
    }
  }

  public void test_type_est() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;
    totalAssertions++ ;
    assertTrue("estCarree() retourne un booleen", (m.estCarree() == true) || (m.estCarree() == false));
    bilanAssertions++ ;

    totalAssertions++ ;
    assertTrue("estDiagonale() retourne un booleen", (m.estDiagonale() == true) || (m.estDiagonale() == false));
    bilanAssertions++ ;

    m.setElement(0,0,1) ;
    totalAssertions++ ;
    assertTrue("estDiagonale() retourne un booleen", (m.estDiagonale() == true) || (m.estDiagonale() == false));
    bilanAssertions++ ;

    m = new MatriceEntier(3,4) ;
    totalAssertions++ ;
    assertTrue("estCarree() retourne un booleen", (m.estCarree() == true) || (m.estCarree() == false));
    bilanAssertions++ ;
  }

  public void test_type_set_mul() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;

    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertEquals("setElement() retourne une MatriceEntier", "MatriceEntier", m.setElement(i,j,i+j).getClass().getName());
      bilanAssertions++ ;
     }
    }

    totalAssertions++ ;
    assertEquals("setPremiereDiagonale(99) retourne une MatriceEntier", "MatriceEntier", m.setPremiereDiagonale(99).getClass().getName());
    bilanAssertions++ ;

    totalAssertions++ ;
    assertEquals("setSecondeDiagonale(99) retourne une MatriceEntier", "MatriceEntier", m.setSecondeDiagonale(99).getClass().getName());
    bilanAssertions++ ;

    totalAssertions++ ;
    assertEquals("mulMatNombre() retourne une MatriceEntier", "MatriceEntier", m.mulMatNombre(33).getClass().getName());
    bilanAssertions++ ;
  }

  /*
   main() de la classe de Test
  */
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(MatriceEntierOperationsTest.class));
    if (bilanAssertions == totalAssertions) { System.out.print("Bravo !"); }
    else  { System.out.print("OUPS !"); }
    System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");
  } // fin main

} // fin MatriceEntierOperationsTest

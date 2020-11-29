import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class MatriceEntierAxiomesTest extends TestCase {
  static int totalAssertions = 0;
  static int bilanAssertions = 0;

  /*
   Axiomes du type MatriceEntier
  */
  public void test_get() throws Exception {
    MatriceEntier m = new MatriceEntier(3,4) ;
	  
    totalAssertions++ ;
    assertEquals("getNbLignes() == 3", 3, m.getNbLignes());
    bilanAssertions++ ;
	  
    totalAssertions++ ;
    assertEquals("getNbColonnes() == 4", 4, m.getNbColonnes());
    bilanAssertions++ ;
	  
    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertEquals("getElement("+i+","+j+") == 0", 0, m.getElement(i,j));
      bilanAssertions++ ;
     }
    }

    m = new MatriceEntier(3,3) ;
    totalAssertions++ ;
    assertEquals("setPremiereDiagonale(99).getNbLignes() == getNbLignes()", m.setPremiereDiagonale(99).getNbLignes(), m.getNbLignes());
    bilanAssertions++ ;
    
    totalAssertions++ ;
    assertEquals("setSecondeDiagonale(99).getNbLignes() == getNbLignes()", m.setSecondeDiagonale(99).getNbLignes(), m.getNbLignes());
    bilanAssertions++ ;
    
    m = new MatriceEntier(3,3) ;
    m.setPremiereDiagonale(99) ;
    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      if ( i == j ) {
        assertEquals("getElement("+i+","+i+") == 99", 99, m.getElement(i,i));
      } else {
        assertEquals("getElement("+i+","+j+") == 0", 0, m.getElement(i,j));
      }
      bilanAssertions++ ;
     }
    }
    
  } // fin test_get

  public void test_som() throws Exception {
    MatriceEntier m = new MatriceEntier(3,4) ;
	  
    for (int i=0; i<m.getNbLignes(); i++) {
      totalAssertions++ ;
      assertEquals("somLigne("+i+") == 0", 0, m.somLigne(i));
      bilanAssertions++ ;
    }
    for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertEquals("somColonne("+j+") == 0", 0, m.somColonne(j));
      bilanAssertions++ ;
    }	  
    
    m = new MatriceEntier(3,3) ;
    m.setPremiereDiagonale(99) ;
    for (int ij=0; ij<m.getNbLignes(); ij++) {
      totalAssertions = totalAssertions + 2 ; ;
      assertEquals("setPremiereDiagonale(99).somLigne("+ij+") == 99", 99, m.somLigne(ij));
      bilanAssertions++ ;
      assertEquals("setPremiereDiagonale(99).somColonne("+ij+") == 99", 99, m.somColonne(ij));
      bilanAssertions++ ;
    }
    
    m = new MatriceEntier(3,3) ;
    m.setSecondeDiagonale(99) ;
    for (int ij=0; ij<m.getNbLignes(); ij++) {
      totalAssertions = totalAssertions + 2 ; ;
      assertEquals("setSecondeDiagonale(99).somLigne("+ij+") == 99", 99, m.somLigne(ij));
      bilanAssertions++ ;
      assertEquals("setSecondeDiagonale(99).somColonne("+ij+") == 99", 99, m.somColonne(ij));
      bilanAssertions++ ;
    }
    
  } // fin test_som

  public void test_est() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;
    totalAssertions++ ;
    assertTrue("estCarree() == true", m.estCarree());
    bilanAssertions++ ;

    m = new MatriceEntier(2,3) ;
    totalAssertions++ ;
    assertFalse("estCarree() == false", m.estCarree());
    bilanAssertions++ ;

    m = new MatriceEntier(3,3) ;
    totalAssertions++ ;
    assertTrue("estDiagonale() == true", m.estDiagonale());
    bilanAssertions++ ;

    m.setPremiereDiagonale(99);
    totalAssertions++ ;
    assertTrue("setPremiereDiagonale(99).estDiagonale() == true", m.estDiagonale());
    bilanAssertions++ ;

    m.setSecondeDiagonale(99);
    totalAssertions++ ;
    assertFalse("setSecondeDiagonale(99).estDiagonale() == false", m.estDiagonale());
    bilanAssertions++ ;
    
  } // fin test_est

  public void test_mul() throws Exception {
    MatriceEntier m = new MatriceEntier(3,3) ;
    m.setPremiereDiagonale(1).mulMatNombre(99) ;
    for (int ij=0; ij<m.getNbLignes(); ij++) {
      totalAssertions = totalAssertions + 2 ; ;
      assertEquals("setPremiereDiagonale(1).mulMatNombre(99).somLigne("+ij+") == 99", 99, m.somLigne(ij));
      bilanAssertions++ ;
      assertEquals("setPremiereDiagonale(1).mulMatNombre(99).somColonne("+ij+") == 99", 99, m.somColonne(ij));
      bilanAssertions++ ;
    }
    
    m = new MatriceEntier(3,3) ;
    m.setSecondeDiagonale(1).mulMatNombre(99) ;
    for (int ij=0; ij<m.getNbLignes(); ij++) {
      totalAssertions = totalAssertions + 2 ; ;
      assertEquals("setSecondeDiagonale(1).mulMatNombre(99).somLigne("+ij+") == 99", 99, m.somLigne(ij));
      bilanAssertions++ ;
      assertEquals("setSecondeDiagonale(1).mulMatNombre(99).somColonne("+ij+") == 99", 99, m.somColonne(ij));
      bilanAssertions++ ;
    }
    
    MatriceEntier m_init = new MatriceEntier(3,3) ;
    m = new MatriceEntier(3,3) ;
    // Initialise m_init et m à {{0,1,2}{3,4,5}{6,7,8}}
    int k = 0 ;
    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
	m_init.setElement(i,j,k) ;
	m.setElement(i,j,k) ;
	k = k + 1 ;
     }
    }
    m.mulMatNombre(3) ;
    for (int i=0; i<m.getNbLignes(); i++) {
     for (int j=0; j<m.getNbColonnes(); j++) {
      totalAssertions++ ;
      assertEquals("m.mulMatNombre(3).getElement("+i+","+j+") == m.getElement("+i+","+j+") * 3", m_init.getElement(i,j) * 3, m.getElement(i,j));
      bilanAssertions++ ;
     }
    }
    
  } // fin test_mul
  
  /*
   main() de la classe de Test
  */
  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(MatriceEntierAxiomesTest.class));
    if (bilanAssertions == totalAssertions) { System.out.print("Bravo !"); }
    else  { System.out.print("OUPS !"); }
    System.out.println(" "+bilanAssertions+"/"+totalAssertions+" assertions verifiees");
  } // fin main

} // fin MatriceEntierAxiomesTest

package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI{

  public final static int TAILLE_PAR_DEFAUT = 5;

  private int[] zone;
  private int ptr;

  public Pile(int taille) {
    if (taille < 0)
      taille = TAILLE_PAR_DEFAUT;
    this.zone = new int[taille];
    this.ptr = 0;
  }

  public Pile() {
    this(TAILLE_PAR_DEFAUT);
  }

  public void empiler(int i) throws PilePleineException {
    if (estPleine())
      throw new PilePleineException();
    this.zone[this.ptr] = i;
    this.ptr++;
  }

  public int depiler() throws PileVideException {
    if (estVide())
      throw new PileVideException();
    this.ptr--;
    return zone[ptr];
  }

  public boolean estVide() {
    return ptr == 0;
  }

  public boolean estPleine() {
    return ptr == zone.length;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer("[");
    for (int i = ptr - 1; i >= 0; i--) {
      sb.append(Integer.toString(zone[i]));
      if (i > 0)
        sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }
}

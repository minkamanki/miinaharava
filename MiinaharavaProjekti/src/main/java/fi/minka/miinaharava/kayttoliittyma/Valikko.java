package fi.minka.miinaharava.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Luokassa luodaan aloitus valikko, jossa valitaan haluttu taso.
 *
 * @author tminka
 */
public class Valikko extends JPanel implements MouseListener {

    private JButton helppo;
    private JButton normi;
    private JButton vaikea;
    private final Kayttoliittyma kl;

    /**
     * Kostruktori.
     *
     * @param kl Kayttoliittyma luokan ilmantyma
     */
    public Valikko(Kayttoliittyma kl) {
        this.kl = kl;
    }

    /**
     * Metodi, jossa luodaan alsutalle kolmi nappia, jotka lisätään kuunneltaviksi.
     *
     */
    public void luoValikko() {
        setLayout(new GridLayout(1, 3));
        helppo = new JButton("Helppo");
        normi = new JButton("Normaali");
        vaikea = new JButton("Vaikea");
        add(helppo);
        add(normi);
        add(vaikea);
        helppo.addMouseListener(this);
        normi.addMouseListener(this);
        vaikea.addMouseListener(this);

    }

    /**
     * Metodi, joka vie tiedon klikatusta napista Kayttoliittymalle.
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == helppo) {
            kl.luoKentta(1);
        } else if (me.getSource() == normi) {
            kl.luoKentta(2);
        } else if (me.getSource() == vaikea) {
            kl.luoKentta(3);
        }
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {

    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }
}

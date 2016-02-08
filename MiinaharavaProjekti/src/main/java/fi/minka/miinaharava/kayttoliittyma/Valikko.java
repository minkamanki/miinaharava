package miinaharavaprojekti.miinaharavaprojekti.kayttoliityma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import miinaharavaprojekti.miinaharavaprojekti.pelilogiikka.Peli;

/**
 *
 * @author tminka
 */
public class Valikko extends JPanel implements ActionListener {

    private JButton helppo;
    private JButton normi;
    private JButton vaikea;
    public Peli peli;

    public Valikko(Peli peli) {
        super(new GridLayout(1, 3));
        helppo = new JButton("Helppo");
        normi = new JButton("Normaali");
        vaikea = new JButton("Vaikea");
        this.peli = peli;
        luoKomponentit();

    }

    private void luoKomponentit() {
        add(helppo);
        add(normi);
        add(vaikea);
        helppo.addActionListener(this);
        normi.addActionListener(this);
        vaikea.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src == helppo) {
            peli.pelaa(1);
        } else if (src == normi) {
            peli.pelaa(2);
        } else {
            peli.pelaa(3);
        }
        
        setVisible(false);

    }
}

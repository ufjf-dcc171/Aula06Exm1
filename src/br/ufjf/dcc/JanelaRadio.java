package br.ufjf.dcc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JanelaRadio extends JFrame {

    private final JTextField txtMensagem = new JTextField("UFJF DCC LABPROG3", 15);
    private final JRadioButton rbPlano = new JRadioButton("Plano", true);
    private final JRadioButton rbNegrito = new JRadioButton("Negrito", false);
    private final JRadioButton rbItalico = new JRadioButton("Itálico", false);
    private final JRadioButton rbNegritoItalico = new JRadioButton("Negrito+Itálico", false);
    private final Font fntPlana = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    private final Font fntItalico = new Font(Font.SANS_SERIF, Font.ITALIC, 14);
    private final Font fntNegrito = new Font(Font.SANS_SERIF, Font.BOLD, 14);
    private final Font fntNegritoItalico = new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 14);

    public JanelaRadio() throws HeadlessException {
        super("Radio!");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(txtMensagem);
        add(rbPlano);
        add(rbItalico);
        add(rbNegrito);
        add(rbNegritoItalico);
        
        ButtonGroup bgEstilo = new ButtonGroup();
        bgEstilo.add(rbPlano);
        bgEstilo.add(rbItalico);
        bgEstilo.add(rbNegrito);
        bgEstilo.add(rbNegritoItalico);

        rbPlano.addItemListener(new SelecaoTratador(fntPlana));
        rbNegrito.addItemListener(new SelecaoTratador(fntNegrito));
        rbItalico.addItemListener(new SelecaoTratador(fntItalico));
        rbNegritoItalico.addItemListener(new SelecaoTratador(fntNegritoItalico));

    }

    private class SelecaoTratador implements ItemListener {
        private final Font fonte;

        public SelecaoTratador(Font font) {
            
            this.fonte = font;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            txtMensagem.setFont(fonte);
        }
    }

}

package cliente.GestionarPedido;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditorPane extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField field;
    private JButton button;

    public EditorPane() {
        field = new JTextField(10);
        button = new JButton("X");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        add(field, gbc);
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx++;
        add(button, gbc);
    }

    @Override
    public void addNotify() {
        super.addNotify(); 
        field.requestFocusInWindow();
    }

    public void selectAll() {
        field.selectAll();
    }

    public void setText(String text) {
        field.setText(text);
    }

    public String getText() {
        return field.getText();
    }

    public void addActionListener(ActionListener listener) {
        field.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        field.removeActionListener(listener);
    }

}

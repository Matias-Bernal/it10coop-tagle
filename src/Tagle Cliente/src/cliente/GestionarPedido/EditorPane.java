/********************************************************
  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *********************************************************/
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

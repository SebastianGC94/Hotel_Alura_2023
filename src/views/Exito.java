package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Exito extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Exito dialog = new Exito();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Exito() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/iconoChulo240px.png")));
		setBounds(100, 100, 587, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/imgHotel300px.png")));
			lblNewLabel.setBounds(0, 11, 571, 210);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("¡Registros Guardados Exitosamente!");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
			lblNewLabel_1.setBounds(10, 232, 571, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bntConfirmar = new JButton("Confirmar");
				bntConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
				bntConfirmar.setForeground(Color.BLACK);
				bntConfirmar.setBackground(Color.GREEN);
				bntConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();// sirve para cerrar la ventana actual
						MenuUsuario usuario = new MenuUsuario();
						usuario.setVisible(true);
					}
				});
				bntConfirmar.setActionCommand("OK");
				buttonPane.add(bntConfirmar);
				getRootPane().setDefaultButton(bntConfirmar);
			}
		}
	}

}

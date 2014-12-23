package com.ufrpe.integrais.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblIntegrais = new JLabel("Integrais");
		lblIntegrais.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIntegrais.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrais.setBounds(10, 10, 414, 50);
		contentPanel.add(lblIntegrais);

		JLabel lblProjetoDesenvolvidoPor = new JLabel(
				"Projeto desenvolvido por:");
		lblProjetoDesenvolvidoPor.setBounds(10, 66, 200, 14);
		contentPanel.add(lblProjetoDesenvolvidoPor);

		JLabel lblAlessonRenato = new JLabel(" - Alesson Renato");
		lblAlessonRenato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlessonRenato.setBounds(10, 86, 200, 14);
		contentPanel.add(lblAlessonRenato);

		JLabel lblGuilhermeMelo = new JLabel(" - Guilherme Melo");
		lblGuilhermeMelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGuilhermeMelo.setBounds(10, 106, 200, 14);
		contentPanel.add(lblGuilhermeMelo);

		JLabel lblPauloMenezes = new JLabel(" - Paulo Menezes");
		lblPauloMenezes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPauloMenezes.setBounds(10, 126, 200, 14);
		contentPanel.add(lblPauloMenezes);

		JLabel lblLeandroMarques = new JLabel(" - Leandro Marques");
		lblLeandroMarques.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeandroMarques.setBounds(10, 166, 200, 14);
		contentPanel.add(lblLeandroMarques);

		JLabel lblProfessorResponsvel = new JLabel(
				"Professor respons\u00E1vel:");
		lblProfessorResponsvel.setBounds(10, 146, 200, 14);
		contentPanel.add(lblProfessorResponsvel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
	}

}

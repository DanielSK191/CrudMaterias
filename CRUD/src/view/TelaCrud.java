package view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.MateriasController;
import control.RadioMateriasController;
import model.Materias;

public class TelaCrud extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tfCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrud frame = new TelaCrud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCrud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnCadastro = new JRadioButton("Cadastro");
		rdbtnCadastro.setBounds(78, 25, 127, 25);
		contentPane.add(rdbtnCadastro);
		rdbtnCadastro.setSelected(true);
		
		JRadioButton rdbtnAtualiza = new JRadioButton("Atualiza");
		rdbtnAtualiza.setBounds(305, 25, 127, 25);
		contentPane.add(rdbtnAtualiza);
		
		JRadioButton rdbtnExclui = new JRadioButton("Exclui");
		rdbtnExclui.setBounds(541, 25, 127, 25);
		contentPane.add(rdbtnExclui);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnExclui);
		bg.add(rdbtnAtualiza);
		bg.add(rdbtnCadastro);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 167, 56, 16);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(88, 164, 116, 22);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 198, 56, 25);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(88, 201, 470, 22);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(12, 250, 56, 16);
		contentPane.add(lblCarga);
		
		tfCarga = new JTextField();
		tfCarga.setBounds(88, 247, 116, 22);
		contentPane.add(tfCarga);
		tfCarga.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(260, 304, 97, 25);
		contentPane.add(btnEnviar);
		
		JLabel lblMaterias = new JLabel("Materias");
		lblMaterias.setBounds(12, 103, 56, 16);
		contentPane.add(lblMaterias);
		lblMaterias.setVisible(false);
		
		JComboBox<Materias> comboBox = new JComboBox<Materias>();
		comboBox.setBounds(85, 100, 473, 22);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		
		MateriasController mController = new MateriasController(tfId);
		mController.proximoId(); 
		
		RadioMateriasController rmController = new RadioMateriasController(tfId, tfNome, tfCarga,
				lblId, lblNome, lblCarga, lblMaterias, rdbtnExclui, 
				rdbtnAtualiza, rdbtnCadastro, btnEnviar, comboBox);
		rdbtnAtualiza.addActionListener(rmController);
		rdbtnCadastro.addActionListener(rmController);
		rdbtnExclui.addActionListener(rmController);
	}
}

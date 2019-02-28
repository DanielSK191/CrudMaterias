package control;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Materias;
import persistence.MateriasDao;

public class MateriasController implements IMateriasController {
	
	private JComboBox<Materias> comboBox;
	private JTextField tfId; 
	
	public MateriasController(JComboBox<Materias> comboBox) {
		this.comboBox = comboBox;
	}
	
	public MateriasController(JTextField tfId) {
		this.tfId = tfId;
	}
	
	public MateriasController(JComboBox<Materias> comboBox, JTextField tfId) {
		this.comboBox = comboBox;
		this.tfId = tfId;
	}
	
	@Override
	public void proximoId() {
		try {
			MateriasDao mDao = new MateriasDao();
			tfId.setText(String.valueOf(mDao.proximoId()));
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void listaMaterias() {
		try {
			MateriasDao mDao = new MateriasDao();
			List<Materias> listaMaterias = mDao.consultaMaterias();
			if (comboBox.getItemCount() > 0) {
					comboBox.removeAllItems();
			}
			if (listaMaterias != null) {
				for (Materias m : listaMaterias) {
					comboBox.addItem(m);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}

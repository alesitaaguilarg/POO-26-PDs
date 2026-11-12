import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    // Componentes de la ventana
    private JTextField m_userInputTf  = new JTextField(5);
    private JTextField m_totalTf      = new JTextField(20);
    private JButton    m_multiplyBtn  = new JButton("Multiply");
    private JButton    m_addBtn       = new JButton("Add");       // NUEVO
    private JButton    m_subtractBtn  = new JButton("Subtract");  // NUEVO
    private JButton    m_clearBtn     = new JButton("Clear");

    private CalcModel m_model;

    CalcView(CalcModel model) {
        m_model = model;
        m_model.setValue(INITIAL_VALUE);

        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false); // El total no se puede escribir a mano

        // Se acomodan los componentes en un panel
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(m_addBtn);       // NUEVO
        content.add(m_subtractBtn);  // NUEVO
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        this.setContentPane(content);
        this.pack(); // Ajusta el tamaño de la ventana

        this.setTitle("Simple Calc - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar = terminar programa
    }

    // Los siguientes métodos los usa el controlador
    void reset() {
        m_totalTf.setText(INITIAL_VALUE);
    }

    String getUserInput() {
        return m_userInputTf.getText();
    }

    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    // Permiten que el controlador "escuche" los botones
    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }

    
    void addAddListener(ActionListener al) {
        m_addBtn.addActionListener(al);
    }

    
    void addSubtractListener(ActionListener sl) {
        m_subtractBtn.addActionListener(sl);
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
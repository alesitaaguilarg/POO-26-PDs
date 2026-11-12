import java.awt.event.*;

public class CalcController {
    // El controlador conoce al modelo y a la vista
    private CalcModel m_model;
    private CalcView  m_view;

    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view  = view;

        // Conecta cada botón con su acción
        view.addMultiplyListener(new MultiplyListener());
        view.addAddListener(new AddListener());           // NUEVO
        view.addSubtractListener(new SubtractListener()); // NUEVO
        view.addClearListener(new ClearListener());
    }

    // Se ejecuta al presionar "Multiply"
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput().trim(); // 1. Lee lo escrito
                m_model.multiplyBy(userInput);            // 2. El modelo multiplica
                m_view.setTotal(m_model.getValue());      // 3. La vista muestra el total
            } catch (NumberFormatException nfex) {
                // Si no es un número válido, muestra error
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    // se ejecuta al presionar "Add" (mismos pasos, pero suma)
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput().trim();
                m_model.addTo(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    // se ejecuta al presionar "Subtract" (mismos pasos, pero resta)
    class SubtractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput().trim();
                m_model.subtractBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    // Se ejecuta al presionar "Clear"
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}
import javax.swing.*;

public class CalcMVC {
    public static void main(String[] args) {
        // Se crea una sola copia de cada parte y se conectan entre sí
        CalcModel      model      = new CalcModel();
        CalcView       view       = new CalcView(model);
        CalcController controller = new CalcController(model, view);

        view.setVisible(true); // Muestra la ventana
    }
}
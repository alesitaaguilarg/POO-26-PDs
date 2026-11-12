import java.math.BigDecimal;

public class CalcModel {
    private static final String INITIAL_VALUE = "1";

    // BigDecimal permite enteros y decimales de cualquier tamaño
    private BigDecimal m_total;

    CalcModel() {
        reset();
    }

    // Regresa el total al valor inicial
    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE);
    }

    // Convierte el texto a número y lo multiplica por el total
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigDecimal(operand));
    }

    // suma el número al total
    public void addTo(String operand) {
        m_total = m_total.add(new BigDecimal(operand));
    }

    // resta el número al total
    public void subtractBy(String operand) {
        m_total = m_total.subtract(new BigDecimal(operand));
    }

    public void setValue(String value) {
        m_total = new BigDecimal(value);
    }

    // toPlainString evita que salga en notación científica
    public String getValue() {
        return m_total.toPlainString();
    }
}
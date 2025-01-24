import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class StatusRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check if the "Result Status" column is at index 6 (adjust the index as needed)
        if (column == 6) {
            String status = (String) value;
            if ("Pass".equals(status)) {
                cellComponent.setBackground(Color.GREEN);
            } else if ("Fail".equals(status)) {
                cellComponent.setBackground(Color.RED);
            }
        } else {
            // For other columns, use the default background color
             cellComponent.setBackground(table.getBackground());
        }

        return cellComponent;
    }
}

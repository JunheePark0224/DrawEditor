import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DrawingEditorUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create main frame
        JFrame frame = new JFrame("Drawing Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);

        // Standard menu size
        Dimension menuSize = new Dimension(150, 50);

        // File menu
        JMenu fileMenu = createMenu("File", "icons/file.png", menuSize);
        fileMenu.add(createMenuItem("Save", menuSize));
        fileMenu.add(createMenuItem("Load", menuSize));

        // Draw menu
        JMenu drawMenu = createMenu("Draw", "icons/draw.png", menuSize);
        drawMenu.add(createMenuItem("Circle", menuSize));
        drawMenu.add(createMenuItem("Rectangle", menuSize));
        drawMenu.add(createMenuItem("Line", menuSize));

        // Edit menu
        JMenu editMenu = createMenu("Edit", "icons/edit.png", menuSize);
        editMenu.add(createMenuItem("Ungrouping", menuSize));
        editMenu.add(createMenuItem("Grouping", menuSize));
        editMenu.add(createMenuItem("Copy&Paste", menuSize));

        // Redo/Undo menu
        JMenu redoUndoMenu = createMenu("Redo/Undo", "icons/redo_undo.png", menuSize);
        redoUndoMenu.add(createMenuItem("Undo", menuSize));
        redoUndoMenu.add(createMenuItem("Redo", menuSize));

        // Painting menu
        JMenu paintingMenu = createMenu("Painting", "icons/painting.png", menuSize);
        JMenuItem fillColorItem = createMenuItem("Fill color", menuSize);
        fillColorItem.addActionListener(e -> showColorPalette());
        paintingMenu.add(fillColorItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(drawMenu);
        menuBar.add(editMenu);
        menuBar.add(redoUndoMenu);
        menuBar.add(paintingMenu);

        // Add menu bar to frame
        frame.setJMenuBar(menuBar);

        // Canvas area
        JPanel canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        frame.add(canvas, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JMenu createMenu(String title, String iconPath, Dimension size) {
        JMenu menu = new JMenu(title);
        menu.setIcon(resizeIcon(new ImageIcon(iconPath), 32, 32));
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setPreferredSize(size); // Set menu size
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
        return menu;
    }

    private static JMenuItem createMenuItem(String title, Dimension size) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setPreferredSize(size); // Set size equal to parent menu
        menuItem.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
        return menuItem;
    }

    private static void showColorPalette() {
        JFrame colorFrame = new JFrame("Color Palette");
        colorFrame.setSize(500, 100);
        colorFrame.setLayout(new BorderLayout());

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setPreviewPanel(new JPanel());

        colorFrame.add(colorChooser, BorderLayout.CENTER);
        colorFrame.setVisible(true);
    }

    private static Icon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}

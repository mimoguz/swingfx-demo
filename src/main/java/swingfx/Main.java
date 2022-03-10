package swingfx;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // See FlatLaf.properties and FlatLafDark.properties files under resources
            FlatLaf.registerCustomDefaultsSource("swingfx.themes");
            FlatDarkLaf.setup();

            var titlePanel = new JFXPanel();
            var windowPanel = new JFXPanel();

            var frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("Swing Frame");
            frame.setSize(400, 300);

            var icon = new FlatSVGIcon("no_icon.svg", Main.class.getClassLoader());
            frame.setIconImage(icon.getImage());

            frame.add(windowPanel);

            var menuBar = new JMenuBar();
            menuBar.setBorder(BorderFactory.createEmptyBorder());
            menuBar.add(titlePanel);
            frame.getRootPane().setJMenuBar(menuBar);

            Platform.runLater(() -> {
                setupTitlePanel(titlePanel);
                setupWindowPanel(windowPanel);
            });

            frame.setVisible(true);
        });
    }

    public static void setupTitlePanel(JFXPanel panel) {
        var button = new Button("Title button");
        button.setPrefWidth(100.0);
        button.setMaxHeight(Double.MAX_VALUE);
        HBox.setHgrow(button, Priority.ALWAYS);

        var box = new HBox(button);

        var scene = new Scene(box);
        panel.setScene(scene);
    }

    public static void setupWindowPanel(JFXPanel panel) {
        var button = new Button("Button");

        var box = new VBox(button);
        box.setStyle("-fx-background-color: #191A21;");
        box.setAlignment(Pos.CENTER);

        var scene = new Scene(box);
        panel.setScene(scene);
    }
}

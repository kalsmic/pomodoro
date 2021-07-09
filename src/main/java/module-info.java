module pomodoro {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;

    opens com.github.kalsmic to javafx.fxml;
    opens com.github.kalsmic.controllers to javafx.fxml;
    opens com.github.kalsmic.model to javafx.fxml;
    exports com.github.kalsmic;
}
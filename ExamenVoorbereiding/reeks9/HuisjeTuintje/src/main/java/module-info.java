module be.ugent.oplossing {
    requires javafx.controls;
    requires javafx.fxml;


    opens huisjetuintje to javafx.fxml;
    exports huisjetuintje;
}

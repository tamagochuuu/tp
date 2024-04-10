package tutorpro.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import tutorpro.model.schedule.Event;

/**
 * A UI component that displays information of a {@code Event}.
 */
public class EventCard extends UiPart<Region> {

    private static final String FXML = "ReminderCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Event event;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label time;
    @FXML
    private Label duration;
    @FXML
    private Label notes;
    @FXML
    private Label people;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code ReminderCode} with the given {@code Reminder} and index to display.
     */
    public EventCard(Event event, int displayedIndex) {
        super(FXML);
        this.event = event;
        id.setText(displayedIndex + ". ");
        name.setText(event.getName());
        time.setText(event.getTime().toString());
        duration.setText(event.getDuration() + "");
        notes.setText(event.getNotes());

        String listOfPeople = " ";
        for (int i = 0; i < event.getPeople().size(); i++) {
            listOfPeople = i + 1 + ". " + event.getPeople().toArray()[i].toString() + "\n";
        }
        people.setText(listOfPeople);

        event.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }
}

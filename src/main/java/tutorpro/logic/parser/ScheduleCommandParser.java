package tutorpro.logic.parser;


import tutorpro.logic.commands.ScheduleCommand;
import tutorpro.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new FindCommand object
 */
public class ScheduleCommandParser implements Parser<ScheduleCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ScheduleCommand
     * and returns a ScheduleCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ScheduleCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        int numOfDays;
        ScheduleCommand command = ScheduleCommand.getInstance();
        if (!(trimmedArgs.isEmpty())) {
            numOfDays = Integer.parseInt(trimmedArgs);
            command.setNumOfDays(numOfDays);
        }
        return command;
    }

}

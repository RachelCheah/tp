package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;


import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.nio.file.Path;

/**
 * Parses input arguments and creates a new ExportCommand object
 */
public class ExportCommandParser implements Parser<ExportCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ExportCommand
     * and returns a ExportCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */

    public ExportCommand parse(String args) throws ParseException {

        try {
            Path filePath = ParserUtil.parseFilePath(args);
            return new ExportCommand(filePath);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));
        }
    }

}

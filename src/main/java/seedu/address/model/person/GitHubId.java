package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's GitHub ID in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGitHubId(String)}
 */
public class GitHubId {

    public static final String MESSAGE_CONSTRAINTS = "GitHub ID must be valid, and it should not be blank";

    /*
     * Regex for the GitHub ID.
     */
    public static final String VALIDATION_REGEX = "[a-zA-Z0-9]+(-{1}+[a-zA-Z0-9]{1,}){0,}";

    public final String value;

    /**
     * Constructs an {@code GitHubId}.
     *
     * @param gitHubId A valid GitHub ID.
     */
    public GitHubId(String gitHubId) {
        requireNonNull(gitHubId);
        checkArgument(isValidGitHubId(gitHubId), MESSAGE_CONSTRAINTS);
        value = gitHubId;
    }

    /**
     * Returns true if a given string is a valid GitHub ID.
     */
    public static boolean isValidGitHubId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GitHubId // instanceof handles nulls
                && value.equals(((GitHubId) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
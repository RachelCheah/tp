package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";
    private static final String INVALID_GITHUB_ID = "rachel-";
    private static final String INVALID_NUS_NETWORK_ID = "e000000";
    private static final String INVALID_TYPE = "teacher";
    private static final String INVALID_STUDENT_ID = "A000000X";
    private static final String INVALID_TUTORIAL_ID = "000";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_ADDRESS = "123 Main Street #0505";
    private static final String VALID_EMAIL = "e0123456@u.nus.edu";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";
    private static final String VALID_GITHUB_ID = "rachel-walker";
    private static final String VALID_NUS_NETWORK_ID = "e0123456";
    private static final String VALID_TYPE = "student";
    private static final String VALID_STUDENT_ID = "A0123456X";
    private static final String VALID_TUTORIAL_ID = "11";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    @Test
    public void parsePhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithoutWhitespace_returnsPhone() throws Exception {
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(VALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        String phoneWithWhitespace = WHITESPACE + VALID_PHONE + WHITESPACE;
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(phoneWithWhitespace));
    }

    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAddress((String) null));
    }

    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAddress(INVALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithoutWhitespace_returnsAddress() throws Exception {
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(VALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithWhitespace_returnsTrimmedAddress() throws Exception {
        String addressWithWhitespace = WHITESPACE + VALID_ADDRESS + WHITESPACE;
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(addressWithWhitespace));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(emailWithWhitespace));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }

    @Test
    public void parseGitHubId_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseGitHubId((String) null));
    }

    @Test
    public void parseGitHubId_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseGitHubId(INVALID_GITHUB_ID));
    }

    @Test
    public void parseGitHubId_validValueWithoutWhitespace_returnsGitHubId() throws Exception {
        GitHubId expectedGitHubId = new GitHubId(VALID_GITHUB_ID);
        assertEquals(expectedGitHubId, ParserUtil.parseGitHubId(VALID_GITHUB_ID));
    }

    @Test
    public void parseGitHubId_validValueWithWhitespace_returnsTrimmedGitHubId() throws Exception {
        String gitHubIdWithWhitespace = WHITESPACE + VALID_GITHUB_ID + WHITESPACE;
        GitHubId expectedGitHubId = new GitHubId(VALID_GITHUB_ID);
        assertEquals(expectedGitHubId, ParserUtil.parseGitHubId(gitHubIdWithWhitespace));
    }

    @Test
    public void parseNusNetworkId_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseNusNetworkId((String) null));
    }

    @Test
    public void parseNusNetworkId_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseNusNetworkId(INVALID_NUS_NETWORK_ID));
    }

    @Test
    public void parseNusNetworkId_validValueWithoutWhitespace_returnsNusNetworkId() throws Exception {
        NusNetworkId expectedNusNetworkId = new NusNetworkId(VALID_NUS_NETWORK_ID);
        assertEquals(expectedNusNetworkId, ParserUtil.parseNusNetworkId(VALID_NUS_NETWORK_ID));
    }

    @Test
    public void parseNusNetworkId_validValueWithWhitespace_returnsTrimmedNusNetworkId() throws Exception {
        String nusNetworkIdWithWhitespace = WHITESPACE + VALID_NUS_NETWORK_ID + WHITESPACE;
        NusNetworkId expectedNusNetworkId = new NusNetworkId(VALID_NUS_NETWORK_ID);
        assertEquals(expectedNusNetworkId, ParserUtil.parseNusNetworkId(nusNetworkIdWithWhitespace));
    }

    @Test
    public void parseType_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseType((String) null));
    }

    @Test
    public void parseType_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseType(INVALID_TYPE));
    }

    @Test
    public void parseType_validValueWithoutWhitespace_returnsType() throws Exception {
        Type expectedType = new Type(VALID_TYPE);
        assertEquals(expectedType, ParserUtil.parseType(VALID_TYPE));
    }

    @Test
    public void parseType_validValueWithWhitespace_returnsTrimmedType() throws Exception {
        String typeWithWhitespace = WHITESPACE + VALID_TYPE + WHITESPACE;
        Type expectedType = new Type(VALID_TYPE);
        assertEquals(expectedType, ParserUtil.parseType(typeWithWhitespace));
    }

    @Test
    public void parseStudentId_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseType((String) null));
    }

    @Test
    public void parseStudentId_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseStudentId(INVALID_STUDENT_ID));
    }

    @Test
    public void parseStudentId_validValueWithoutWhitespace_returnsStudentId() throws Exception {
        StudentId expectedStudentId = new StudentId(VALID_STUDENT_ID);
        assertEquals(expectedStudentId, ParserUtil.parseStudentId(VALID_STUDENT_ID));
    }

    @Test
    public void parseStudentId_validValueWithWhitespace_returnsTrimmedStudentId() throws Exception {
        String studentIdWithWhitespace = WHITESPACE + VALID_STUDENT_ID + WHITESPACE;
        StudentId expectedStudentId = new StudentId(VALID_STUDENT_ID);
        assertEquals(expectedStudentId, ParserUtil.parseStudentId(studentIdWithWhitespace));
    }

    @Test
    public void parseTutorialId_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTutorialId((String) null));
    }

    @Test
    public void parseTutorialId_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTutorialId(INVALID_TUTORIAL_ID));
    }

    @Test
    public void parseTutorialId_validValueWithoutWhitespace_returnsTutorialId() throws Exception {
        TutorialId expectedTutorialId = new TutorialId(VALID_TUTORIAL_ID);
        assertEquals(expectedTutorialId, ParserUtil.parseTutorialId(VALID_TUTORIAL_ID));
    }

    @Test
    public void parseTutorialId_validValueWithWhitespace_returnsTrimmedTutorialId() throws Exception {
        String tutorialIdWithWhitespace = WHITESPACE + VALID_TUTORIAL_ID + WHITESPACE;
        TutorialId expectedTutorialId = new TutorialId(VALID_TUTORIAL_ID);
        assertEquals(expectedTutorialId, ParserUtil.parseTutorialId(tutorialIdWithWhitespace));
    }
}

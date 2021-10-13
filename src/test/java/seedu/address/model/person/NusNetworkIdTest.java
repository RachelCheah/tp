package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NUS_NETWORK_ID_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NUS_NETWORK_ID_BOB;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NusNetworkIdTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new NusNetworkId(null));
    }

    @Test
    public void constructor_invalidNusNetworkId_throwsIllegalArgumentException() {
        String invalidNusNetworkId = "";
        assertThrows(IllegalArgumentException.class, () -> new NusNetworkId(invalidNusNetworkId));
    }

    @Test
    public void isValidNusNetworkId() {
        // null NusNetworkId
        assertThrows(NullPointerException.class, () -> NusNetworkId.isValidNusNetworkId(null));

        // blank NusNetworkId
        assertFalse(NusNetworkId.isValidNusNetworkId("")); // empty string
        assertFalse(NusNetworkId.isValidNusNetworkId(" ")); // spaces only

        // invalid NusNetworkId because e or E followed by 7 digits only
        assertFalse(NusNetworkId.isValidNusNetworkId("sid1234-")); // invalid because characters
        assertFalse(NusNetworkId.isValidNusNetworkId("e123456")); // invalid because fewer digits
        assertFalse(NusNetworkId.isValidNusNetworkId("A1234567")); // invalid because first character should be e or E
        assertFalse(NusNetworkId.isValidNusNetworkId("e-1234567")); // invalid because special characters not allowed

        // valid NusNetworkId
        assertTrue(NusNetworkId.isValidNusNetworkId("e0000000"));
        assertTrue(NusNetworkId.isValidNusNetworkId("E1234567"));
    }

    @Test
    public void isEqualNusNetworkId() {
        NusNetworkId nusNetworkId = new NusNetworkId("E1234567");
        NusNetworkId different_nusNetworkId = new NusNetworkId("e0000000");
        NusNetworkId same_nusNetworkId = new NusNetworkId("E1234567");

        // Different NusNetworkId
        assertFalse(nusNetworkId.equals(different_nusNetworkId));

        // Same Object
        assertTrue(nusNetworkId.equals(nusNetworkId));

        // Different Objects Same NusNetworkId
        assertTrue(nusNetworkId.equals(same_nusNetworkId));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(VALID_NUS_NETWORK_ID_AMY.hashCode(), VALID_NUS_NETWORK_ID_AMY.hashCode());
        assertNotEquals(VALID_NUS_NETWORK_ID_AMY.hashCode(), VALID_NUS_NETWORK_ID_BOB.hashCode());
    }
}

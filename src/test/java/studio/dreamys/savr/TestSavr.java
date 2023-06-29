package studio.dreamys.savr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSavr {
    @Test
    void TestSaveLoad() { //tests that the object saved is the same as the object loaded
        //arrange
        TestObject testObject = new TestObject();
        Savr<TestObject> savr = new Savr<>(TestObject.class, "test");

        //act
        savr.save(testObject);

        //assert
        assertEquals(testObject, savr.load());
    }
}

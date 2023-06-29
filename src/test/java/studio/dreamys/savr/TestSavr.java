package studio.dreamys.savr;

import org.junit.jupiter.api.Test;
import studio.dreamys.savr.object.TestStatic;
import studio.dreamys.savr.object.TestObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSavr {
    @Test
    void Test_SaveLoad_Object() { //tests that the object saved is the same as the object loaded
        //arrange
        TestObject testObject = new TestObject();
        Savr<TestObject> savr = new Savr<>(TestObject.class, "test_object");

        //act
        savr.save(testObject);

        //assert
        assertEquals(testObject, savr.load());
    }

    @Test
    void Test_SaveLoad_Static() { //tests that the static variables saved are the same as the static variables loaded
        //arrange
        Savr<TestStatic> savr = new Savr<>(TestStatic.class, "test_static");

        //act
        savr.save(new TestStatic());

        //assert
        assertEquals(new TestStatic(), savr.load());
    }
}

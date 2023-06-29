package studio.dreamys.savr;

import java.util.Objects;

public class TestObject {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    boolean bool;
    char c;
    String str;

    public TestObject() {
        b = 1;
        s = 2;
        i = 3;
        l = 4L;
        f = 5f;
        d = 6d;
        bool = true;
        c = 'a';
        str = "Hello, World!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObject)) return false;
        TestObject that = (TestObject) o;
        return b == that.b && s == that.s && i == that.i && l == that.l && Float.compare(that.f, f) == 0 && Double.compare(that.d, d) == 0 && bool == that.bool && c == that.c && Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, s, i, l, f, d, bool, c, str);
    }
}

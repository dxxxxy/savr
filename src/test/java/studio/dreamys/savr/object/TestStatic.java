package studio.dreamys.savr.object;

import java.util.Objects;

@SuppressWarnings({"ConstantValue", "AccessStaticViaInstance", "EqualsWithItself"})
public class TestStatic {
    static byte b = 1;
    static short s = 2;
    static int i = 3;
    static long l = 4L;
    static float f = 5f;
    static double d = 6d;
    static boolean bool = true;
    static char c = 'a';
    static String str = "Hello, World!";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestStatic)) return false;
        TestStatic that = (TestStatic) o;
        return b == that.b && s == that.s && i == that.i && l == that.l && Float.compare(that.f, f) == 0 && Double.compare(that.d, d) == 0 && bool == that.bool && c == that.c && Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, s, i, l, f, d, bool, c, str);
    }
}

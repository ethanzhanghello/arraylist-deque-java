import deque.Maximizer61B;
import deque.ArrayDeque61B;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class Maximizer61BTest {
    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    @Test
    public void basicTest() {
        ArrayDeque61B<String> ad = new ArrayDeque61B<>();
        ad.addFirst("");
        ad.addFirst("2");
        ad.addFirst("fury road");
        assertThat(Maximizer61B.max(ad, new StringLengthComparator())).isEqualTo("fury road");
    }

    @Test
    public void testMaxEmpty() {
        ArrayDeque61B<String> ad = new ArrayDeque61B<>();
        assertThat(Maximizer61B.max(ad)).isEqualTo(null);
    }

    @Test
    public void testMaxNoComp() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1);
        ad.addFirst(2);
        assertThat(Maximizer61B.max(ad)).isEqualTo(2);
    }

    @Test
    public void testMaxWithComp() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(3);
        ad.addLast(4);
        assertThat(Maximizer61B.max(ad, new IntegerLargerMod2Comparator())).isEqualTo(3);
    }

    private static class IntegerLargerMod2Comparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a % 2 == b % 2) {
                return 0;
            } else if (a % 2 > b % 2) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

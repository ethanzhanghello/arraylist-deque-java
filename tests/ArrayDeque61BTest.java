import deque.ArrayDeque61B;

import deque.Deque61B;
import deque.LinkedListDeque61B;
import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

    //      @Test
    //     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    //     void noNonTrivialFields() {
    //         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
    //                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
    //                 .toList();
    //
    //         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    //     }

    @Test
    public void testGet1() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addLast(1);
        a.addFirst(0);
        assertThat(a.get(1)).isEqualTo(1);
    }

    @Test
    public void testGetNeg() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        assertThat(a.get(-1)).isEqualTo(null);
    }

    @Test
    public void testGetBig() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        assertThat(a.get(1000)).isEqualTo(null);
    }

    @Test
    public void testEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        assertThat(a.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testNonEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(0);
        assertThat(a.isEmpty()).isEqualTo(false);
    }

    @Test
    public void testEmptySize() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        assertThat(a.size()).isEqualTo(0);
    }

    @Test
    public void testNonEmptySize() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(0);
        assertThat(a.size()).isEqualTo(1);
    }

    @Test
    public void testToListEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        assertThat(a.toList()).isEqualTo(null);
    }

    @Test
    public void testToListNonEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.addLast(2);
        a.addFirst(0);
        assertThat(a.toList()).containsExactly(0, 1, 2);
    }

    @Test
    public void testRemoveFirst() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.addFirst(0);
        int remove = a.removeFirst();
        assertThat(a.toList()).containsExactly(1);
        assertThat(remove).isEqualTo(0);
    }

    @Test
    public void testRemoveFirstToEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        int remove = a.removeFirst();
        assertThat(a.toList()).isEqualTo(null);
        assertThat(remove).isEqualTo(1);
        assertThat(a.size()).isEqualTo(0);
    }

    @Test
    public void testSizeAfterEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        assertThat(a.size()).isEqualTo(0);
    }

    @Test
    public void testSizeAfterRemoveEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.removeFirst();
        assertThat(a.size()).isEqualTo(0);
    }

    @Test
    public void testAddFirstAfterEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.removeFirst();
        a.addFirst(2);
        assertThat(a.toList()).containsExactly(2);
    }

    @Test
    public void testRemoveLast() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.addFirst(0);
        int remove = a.removeLast();
        assertThat(a.toList()).containsExactly(0);
        assertThat(remove).isEqualTo(1);
    }

    @Test
    public void testRemoveLastToEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        int remove = a.removeLast();
        assertThat(a.toList()).isEqualTo(null);
        assertThat(remove).isEqualTo(1);
        assertThat(a.size()).isEqualTo(0);
    }

    @Test
    public void testAddLastAfterEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(1);
        a.removeFirst();
        a.addLast(2);
        assertThat(a.toList()).containsExactly(2);
    }

    @Test
    public void testSizeUpAddLast() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addLast(8);
        assertThat(a.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void testSizeUpAddFirst() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(0);
        a.addFirst(8);
        a.addFirst(7);
        a.addFirst(6);
        a.addFirst(5);
        a.addFirst(4);
        a.addFirst(3);
        a.addFirst(2);
        a.addFirst(1);
        assertThat(a.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void testSizeUpMulTimes() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        for (int i = 0; i < 100; i++) {
            a.addLast(i);
        }
        assertThat(a.size()).isEqualTo(100);
    }

    @Test
    public void testSizeDownRemoveLast() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        for (int i = 0; i < 100; i++) {
            a.addLast(i);
        }
        for (int j = 0; j < 92; j++) {
            a.removeLast();
        }
        assertThat(a.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void testSizeDownRemoveFirst() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        for (int i = 0; i < 33; i++) {
            a.addLast(i);
        }
        for (int j = 0; j < 31; j++) {
            a.removeFirst();
        }
        assertThat(a.toList()).containsExactly(31, 32);
    }

    @Test
    public void testEqualsEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new ArrayDeque61B<>();
        assertThat(a.equals(b)).isEqualTo(true);
    }

    @Test
    public void testEqualsNonEmpty() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new ArrayDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        assertThat(a.equals(b)).isEqualTo(true);
    }

    @Test
    public void testEqualsDiffLengths() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new ArrayDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        assertThat(a.equals(b)).isEqualTo(false);
    }

    @Test
    public void testEqualsDiffNums() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new ArrayDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        b.addLast(2);
        assertThat(a.equals(b)).isEqualTo(false);
    }

    @Test
    public void testToString() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        System.out.println(a);
    }

    @Test
    public void testArrayEqsLL() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new LinkedListDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        assertThat(a.equals(b)).isEqualTo(true);
    }

    @Test
    public void testArrayNoEqsLL() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        Deque61B<Integer> b = new LinkedListDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        b.addLast(2);
        assertThat(a.equals(b)).isEqualTo(false);
    }

    @Test
    public void testLLEqsArray() {
        Deque61B<Integer> b = new ArrayDeque61B<>();
        Deque61B<Integer> a = new LinkedListDeque61B<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        assertThat(a.equals(b)).isEqualTo(true);
    }

    @Test
    public void testGetAutograder() {
        Deque61B<Integer> a = new ArrayDeque61B<>();
        a.addFirst(0);
        int get1 = a.get(0);
        a.addLast(2);
        int get2 = a.get(0);
        int remove1 = a.removeLast();
        a.addFirst(5);
        int remove2 = a.removeLast();
        int remove3 = a.removeLast();
        a.addFirst(8);
        assertThat(a.toList()).containsExactly(8);
        assertThat(get1).isEqualTo(0);
        assertThat(get2).isEqualTo(0);
        assertThat(remove1).isEqualTo(2);
        assertThat(remove2).isEqualTo(0);
        assertThat(remove3).isEqualTo(5);
    }

}

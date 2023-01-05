package com.jason.algs4ex.ch2_3;
/*
2.3.22 快速三向切分。（J. Bently, D. McIlroy）用将重复元素放置于子数组两端的方式实现一个信息量最优的排序算法。
使用两个索引p和q，使得a[lo..p-1]和a[q+1..hi]的元素都和a[lo]相等。使用另外两个索引i和j，使得a[p..i-1]小于a[lo],a[j+i..q]大于a[lo]。
在内循环中加入代码，在a[i]和v相当时将其与a[p]交换（并将p加1），在a[j]和v相等且a[i]和a[j]尚未和v进行比较之前将其与a[q]交换。
添加在切分循环结束后将和v相等的元素交换到正确位置的代码，如图2.3.6所示。
请注意：这里实现的代码和正文中给出的代码是等价的，因为这里额外的交换用于和切分元素相等的元素，而正文中的代码将额外的交换用于和切分元素不等的元素。
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex2_3_22 {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        QuickBentleyMcIlroy.sort(a);
        assert QuickBentleyMcIlroy.isSorted(a);
        QuickBentleyMcIlroy.show(a);
    }

    public static class QuickBentleyMcIlroy {
        private static final int INSERTION_SORT_CUTOFF = 8;

        // cutoff to median-of-3 partitioning
        private static final int MEDIAN_OF_3_CUTOFF = 40;

        // This class should not be instantiated.
        private QuickBentleyMcIlroy() {
        }

        /**
         * Rearranges the array in ascending order, using the natural order.
         *
         * @param a the array to be sorted
         */
        public static <T extends Comparable<T>> void sort(T[] a) {
            sort(a, 0, a.length - 1);
        }

        private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
            int n = hi - lo + 1;

            // cutoff to insertion sort
            if (n <= INSERTION_SORT_CUTOFF) {
                insertionSort(a, lo, hi);
                return;
            }

            // use median-of-3 as partitioning element
            else if (n <= MEDIAN_OF_3_CUTOFF) {
                int m = median3(a, lo, lo + n / 2, hi);
                exch(a, m, lo);
            }

            // use Tukey ninther as partitioning element
            else {
                int eps = n / 8;
                int mid = lo + n / 2;
                int m1 = median3(a, lo, lo + eps, lo + eps + eps);
                int m2 = median3(a, mid - eps, mid, mid + eps);
                int m3 = median3(a, hi - eps - eps, hi - eps, hi);
                int ninther = median3(a, m1, m2, m3);
                exch(a, ninther, lo);
            }

            // Bentley-McIlroy 3-way partitioning
            int i = lo, j = hi + 1;
            int p = lo, q = hi + 1;
            T v = a[lo];
            while (true) {
                while (less(a[++i], v))
                    if (i == hi) break;
                while (less(v, a[--j]))
                    if (j == lo) break;

                // pointers cross
                if (i == j && eq(a[i], v))
                    exch(a, ++p, i);
                if (i >= j) break;

                exch(a, i, j);
                if (eq(a[i], v)) exch(a, ++p, i);
                if (eq(a[j], v)) exch(a, --q, j);
            }


            i = j + 1;
            for (int k = lo; k <= p; k++)
                exch(a, k, j--);
            for (int k = hi; k >= q; k--)
                exch(a, k, i++);

            sort(a, lo, j);
            sort(a, i, hi);
        }


        // sort from a[lo] to a[hi] using insertion sort
        private static <T extends Comparable<T>> void insertionSort(T[] a, int lo, int hi) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                    exch(a, j, j - 1);
        }


        // return the index of the median element among a[i], a[j], and a[k]
        private static <T extends Comparable<T>> int median3(T[] a, int i, int j, int k) {
            return (less(a[i], a[j]) ?
                    (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                    (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
        }

        /***************************************************************************
         *  Helper sorting functions.
         ***************************************************************************/

        // is v < w ?
        private static <T extends Comparable<T>> boolean less(T v, T w) {
            if (v == w) return false;    // optimization when reference equal
            return v.compareTo(w) < 0;
        }

        // does v == w ?
        private static <T extends Comparable<T>> boolean eq(T v, T w) {
            if (v == w) return true;    // optimization when reference equal
            return v.compareTo(w) == 0;
        }

        // exchange a[i] and a[j]
        private static void exch(Object[] a, int i, int j) {
            Object swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }


        /***************************************************************************
         *  Check if array is sorted - useful for debugging.
         ***************************************************************************/
        private static <T extends Comparable<T>> boolean isSorted(T[] a) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1])) return false;
            return true;
        }

        // print array to standard output
        private static <T extends Comparable<T>> void show(T[] a) {
            for (T t : a) {
                StdOut.println(t);
            }
        }
    }
}

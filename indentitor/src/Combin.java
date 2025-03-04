import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created on 2017/2/24.
 */

public class Combin<T> implements Iterable<List<T>> {

    CombinationGenerator cGenerator;
    T[] elements;
    int[] indices;

    public Combin(List<T> list, int n) {
        cGenerator = new CombinationGenerator(list.size(), n);
        elements = (T[]) list.toArray();
    }

    public Iterator<List<T>> iterator() {
        return new Iterator<List<T>>() {

            int pos = 0;

            public boolean hasNext() {
                return cGenerator.hasMore();
            }

            public List<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                indices = cGenerator.getNext();
                List<T> combination = new ArrayList<T>();
                for (int i = 0; i < indices.length; i++) {
                    combination.add(elements[indices[i]]);
                }
                return combination;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private final class CombinationGenerator {

        private int[] a;
        private int n;
        private int r;
        private BigInteger numLeft;
        private BigInteger total;

        public CombinationGenerator(int n, int r) {
            if (n < 1) {
                throw new IllegalArgumentException("Set must have at least one element");
            }
            if (r > n) {
                throw new IllegalArgumentException("Subset length can not be greater than set length");
            }
            this.n = n;
            this.r = r;
            a = new int[r];
            BigInteger nFact = getFactorial(n);
            BigInteger rFact = getFactorial(r);
            BigInteger nminusrFact = getFactorial(n - r);
            total = nFact.divide(rFact.multiply(nminusrFact));
            reset();
        }

        public void reset() {
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            numLeft = new BigInteger(total.toString());
        }

        public BigInteger getNumLeft() {
            return numLeft;
        }

        
        public boolean hasMore() {
            return numLeft.compareTo(BigInteger.ZERO) == 1;
        }

       
        public BigInteger getTotal() {
            return total;
        }

        private BigInteger getFactorial(int n) {
            BigInteger fact = BigInteger.ONE;
            for (int i = n; i > 1; i--) {
                fact = fact.multiply(new BigInteger(Integer.toString(i)));
            }
            return fact;
        }

     
        public int[] getNext() {

            if (numLeft.equals(total)) {
                numLeft = numLeft.subtract(BigInteger.ONE);
                return a;
            }

            int i = r - 1;
            while (a[i] == n - r + i) {
                i--;
            }
            a[i] = a[i] + 1;
            for (int j = i + 1; j < r; j++) {
                a[j] = a[i] + j - i;
            }

            numLeft = numLeft.subtract(BigInteger.ONE);
            return a;

        }
    }
}

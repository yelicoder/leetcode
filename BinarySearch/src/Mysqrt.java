public class Mysqrt {

    public int mySqrt(int x) {

        int left = 0;
        int right = x;

        if (x==0) return 0;
        if(x==1) return 1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if ( (x/mid) == mid || ( (x/(mid+1) < (mid+1)) && (x/mid > mid))) {
                return mid;
            }

            if ( (x/mid) > mid ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

    public static void main (String[] args) {
        Mysqrt o = new Mysqrt();
        System.out.println(o.mySqrt(0));
        System.out.println(o.mySqrt(1));
        System.out.println(o.mySqrt(8));
    }
}

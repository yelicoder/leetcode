public class Mysqrt2 {

    public int mySqrt(int x) {

        if (x==0) return 0;
        if(x==1) return 1;

        int left = 0;
        int right = x/2;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if ( (x/mid) == mid ) {
                return mid;
            }

            if ( (x/mid) > mid ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;

    }

    public static void main (String[] args) {
        Mysqrt2 o = new Mysqrt2();
        System.out.println(o.mySqrt(0));
        System.out.println(o.mySqrt(1));
        System.out.println(o.mySqrt(8));
    }
}

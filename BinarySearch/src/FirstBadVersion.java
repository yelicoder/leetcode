public class FirstBadVersion {

    /*
        You are a product manager and currently leading a team to develop a new product. Unfortunately,
        the latest version of your product fails the quality check. Since each version is developed based
        on the previous version, all the versions after a bad version are also bad.

        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
        which causes all the following ones to be bad.

        You are given an API bool isBadVersion(version) which returns whether version is bad.
        Implement a function to find the first bad version. You should minimize the number of calls to the API.

        Example 1:

        Input: n = 5, bad = 4
        Output: 4
        Explanation:
        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true
        Then 4 is the first bad version.
        Example 2:

        Input: n = 1, bad = 1
        Output: 1

        Constraints:

        1 <= bad <= n <= 231 - 1
     */
    public boolean isBadVersion(int version) {

        if (version >= 2) {
            return true;
        } else {
            return false;
        }

    }

    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    public int binarySearch(int firstVersion, int lastVersion)
    {
        while (lastVersion >= firstVersion) {
            int mid = firstVersion + (lastVersion - firstVersion) / 2;

            // if mid is bad version and mid-1 is not bad version, then mid is the first bad version
            if (mid==1 && isBadVersion(mid)){
                return mid;
            }
            if (isBadVersion(mid) && !(isBadVersion(mid - 1)))
                return mid;

            // if mid is a bad version and mid-1 is a bad version, the first bad version can only be smaller than mid
            if (isBadVersion(mid) && (isBadVersion(mid - 1)))
                return binarySearch(firstVersion, mid - 1);

            return binarySearch(mid+1, lastVersion);
        }

        return -1;
    }

    public static void main (String[] args) {
        FirstBadVersion ob = new FirstBadVersion();
        System.out.println(ob.firstBadVersion(2));
    }
}

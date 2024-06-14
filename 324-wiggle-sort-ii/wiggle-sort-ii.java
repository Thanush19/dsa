import java.util.*;

class Solution {

//    WIGGLE SORT IDEA:
//    [S,S,S,M,M ,M,L,L,L]
//    [M,L, M,L S,L S,M S,M, S]

//    [0,  1, 2, 3,  4, 5, 6, 7]
//    [S1,S2,S3,M1, M2,L1,L2,l3] ORIGINAL
//    [M1,L3,S3,L2  S2,L1,S1,M2] SOLUTION
//    LEFT: mapped based on 2 * num prev pairs
//    M1: 3 -> 0
//    S3: 2 -> 2
//    S2: 1 -> 4
//    S1: 0 -> 6

//    RIGHT: each mapped to left partner id + 1
//    aka mapped based on (2 * num prev pairs) + 1
//    M2: 4 -> 7
//    L1: 5 -> 5
//    L2: 6 -> 3
//    L3: 7 -> 1

//    ODD -> ODD
//   EVEN -> EVEN


    //    [0,  1, 2, 3,  4, 5, 6, 7]
//    [S1,S2,S3,M1, M2,L1,L2,L3] ORIGINAL
//    [M1,L3,S3,L2, S2,L1,S1,M2] SOLUTION
    void solveDucthNatFlag(int median) {
        int largeId = 1; // where to put next large
        int curr = 0;
        int smallId = n % 2 == 0 ? n - 2 : n - 1; // where to put next small; ODD len => end with small

        // NOTE: // curr will pass over same IDs where it inserts into
        // make sure to SKIP items we have processed before
        while (curr < n) {
            boolean isEven = curr % 2 == 0;
            if (A[curr] < median && (curr < smallId || !isEven)) {
                swap(curr, smallId);
                smallId -= 2;
            } else if (A[curr] > median && (curr > largeId || isEven)) {
                swap(curr, largeId);
                largeId += 2;
            } else { // curr is at right place; either A[curr] == median OR previously processed
                curr++;
            }
        }
    }


    //    WIGGLE SORT IDEA:
    //    [S,S,S,M,M,L,L,L]

    //    [M,S,S,S,M,L,L,L]
    //    [M,S,S,S,L,L,L,M]

    //    [M,L,S,S,S,L,L,M]
    //    [M,L,S,L,S,S,L,M]
    //    [M,L,S,L,S,L,S,M]

    //    [M,L,S,L,S,L,S,M]

    //    [0,1,2,3,4,5,6,7]
    //    M, L, S, L, S, L, S, M
    //    3, 7, 2, 6, 1, 5, 0, 4


    // OPTIMISE THE BELOW: actually it does not matter which L and which S we use, just whether or not it is < > M
    // so we can do QUICKSELECT! O(N) to partition into SSSS M LLLLL, then we keep swapping and we are done in O(1) space


    // the other way to solve is to go LEFT -> RIGHT, choosing 2 pointers: start and median
    // S,S,M,M,M,L,L
    // ^,S,M,M,^,L,L
    // S,^,M,M,M,^,L
    // S,S,^,M,M,L,^
    // S,S,M,M,^,L,L
    // S,M,S,L,M,L,M
    // this way there is always a bigger one at the right pointer than the left pointer

    // N = 7
    // so the LEFT half is traversed by the left pointer
    // RIGHT half is traversed by the right pointer
    // all from LEFT move their indexes: i * 2
    // 0 -> 0
    // 1 -> 2
    // 2 -> 4
    // 3 -> 6

    // all from RIGHT move: (i * 2) + 1 % N
    // 4 -> 1
    // 5 -> 3
    // 6 -> 5

    // [1,2,3,4,5,6]

    // [3,2,1,4,5,6]


    // [3,6,2,5,1,4]

    // [1,2,3,4,4,4]
    // [3,4,2,4,1,4]

    // [1,1,2,2,3,3]
    // [2,3,1,3,1,2] sol

    // we want always to have a smaller and a bigger available so we start picking the smaller candidates from MIDDLE
    // and the bigger at the END, then we move both pointers to the LEFT, this way the bigger is always bigger than the
    // smaller

    // [1,1,2,3,3]
    // [2,3,1,3,1] sol

    // [1,2,1,2,1,2,1]
    // [1,1,1,1,2,2,2]
    // [1,2,1,2,1,2,1]


    // OPTIMISE THE BELOW: no need to sort, we only need to create 3 GROUPS:
    // SSSSS MMMM LLLLLL, sorting within a group makes no difference!!!!
    // we need median = (N/2)th elem in the sorted array so Kth smallest elem = QUICK SELECT O(N) in avg case, O(N^2) worst
    public void wiggleSort(int[] A) {
        this.A = A;
        this.n = A.length;
        if (n < 3) {
            Arrays.sort(A);
            return;
        }
        int l = (n - 1) / 2;

        quickSelect(l);

        //// ONLY NEEDED IF WE DO REGULAR SOLUTION (NOT FOR VIRTUAL INDEXES)
        //// After quick select, Kth smallest number is at its position
        //// all on left are smaller or equal and all on right are bigger and equal!
        //// BUT we might still have MSS MMMM LLLLM, and we want SSSSS MMMMM LLLLL
        //fixGroupsLeft(0, l - 1, A[l]);
        //fixGroupsRight(l + 1, n - 1, A[l]);

//        solveVirtualIndexing(A[l]);
        solveDucthNatFlag(A[l]);
    }


    // DUTCH NATIONAL FLAG PARTITION: l, curr, r; look at curr and swap it with L or R
    // usually converts to SSS MMMM LLLL
    // HERE ADD:
    // VIRTUAL INDEXING TECHNIQUE: go over real indexes and map them all to virtual ones to figure out the ordering
    //
//    void solveVirtualIndexing(int median) {
//        int l = 0;
//        int curr = 0;
//        int r = n - 1;
//        while (curr <= r) {
//            if (A[vId(curr)] > median) {
//                swap(vId(l), vId(curr));
//                l++;
//                curr++;
//            } else if (A[vId(curr)] < median) {
//                swap(vId(curr), vId(r));
//                r--;
//            } else { // curr == med; keep building MIDDLE
//                curr++;
//            }
//        }
//    }
//
//    int vId(int i) {
//        int firstOddAfterN = n | 1;
//        return (1 + 2 * i) % firstOddAfterN;
//    }


    // L = wrong, median too much to the left
    // R = insertId for the misplaced median
    void fixGroupsLeft(int l, int r, int median) {
        while (l < r) {
            while (l < r && A[l] < median) l++;
            while (l < r && A[r] == median) r--;
            swap(l, r);
            l++;
            r--;
        }
    }

    void fixGroupsRight(int l, int r, int median) {
        while (l < r) {
            while (l < r && A[l] == median) l++;
            while (l < r && A[r] > median) r--;
            swap(l, r);
            l++;
            r--;
        }
    }

    void quickSelect(int k) {
        int n = A.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int randId = new Random().nextInt(l, r + 1);
            int pivotId = partition(l, r, randId);
            if (pivotId > k) {
                r = pivotId - 1;
            } else if (pivotId < k) {
                l = pivotId + 1;
            } else {
                break;
            }
        }
    }

    int partition(int l, int r, int pivotId) {
        int startL = l;
        int pivot = A[pivotId];

        swap(startL, pivotId);
        l++;
        while (true) { // WHILE TRUE MOST IMPORTANT! make the logic force push R too much to the left, so we can swap it at the end
            while (l <= r && A[l] < pivot) l++;
            while (l <= r && A[r] > pivot) r--;
            if (l >= r) break;

            swap(l, r);
            l++;
            r--;
        }

        swap(r, startL);
        return r;
    }


    // Simple O(NLogN) O(N) space
//    WIGGLE SORT IDEA:
//    [S,S,S,M,M ,M,L,L,L]
//    [M,L, M,L S,L S,M S,M, S]
//
//
//    public void wiggleSort(int[] A) {
//        this.A = A;
//        Arrays.sort(A);
//        int n = A.length;
//
//        int[] ans = new int[n];
//        int lStart = (n - 1) / 2;
//        int l = lStart;
//        int r = n - 1;
//        for (int i = 0; i < n && l >= 0; i++) {
//            ans[i++] = A[l--];
//            if (i == n) break;
//            ans[i] = A[r--];
//        }
//
//        for (int i = 0; i < n; i++) A[i] = ans[i];
//    }

    void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    int n;

    int[] A;

}


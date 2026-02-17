import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);

        // if(intervals.length==0) return new int[][]{newInterval};

        // int left = 0;
        // int right = intervals.length-1;
        // int inidx = intervals.length;


        // while(left<=right){
        //     int mid = (left+ right)/2;
        //     if(intervals[mid][1]>=newInterval[0]){
        //         inidx = mid;
        //         right = mid-1;
        //     }
        //     else{
        //         left = mid+1;
        //     }
        // }

        // ArrayList<int[]> lst = new ArrayList<>();

        // for(int i=0;i<inidx;i++){
        //     lst.add(intervals[i]);
        // }

        // int s  = newInterval[0];
        // int e = newInterval[1];
        // int c = inidx;
        // int n = intervals.length;

        // while(c<n && intervals[c][0]<=e){
        //     s = Math.min(s,intervals[c][0]);
        //     e = Math.max(e,intervals[c][1]);
        //     c++;
        // }
        // lst.add(new int[]{s,e});

        // for(int i=c;i<n;i++){
        //     lst.add(intervals[i]);
        // }

        // return lst.toArray(new int[lst.size()][]);
        
    }
}

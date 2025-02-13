import java.util.PriorityQueue;
import java.util.Queue;

public class _3066_Min_Operations_To_Exceed_ThreshHoldValue
{
      public static int minOperations(int[] nums, int k) {
        
        int len=nums.length;
        Queue<Long> queue=new PriorityQueue<>();
        
        for(int i=0; i<len;i++)
        {
            queue.offer((long)nums[i]);
        }
        if(queue.peek()>=k)
        {
            return 0;
        }
        int count=0;
        while(queue.size()>=2 && queue.peek()<k)
        {
            long x=queue.poll();
            long y=queue.poll();
            long toAdd= (Math.min(x,y) *2 ) + Math.max(x,y);
            queue.offer(toAdd);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        
        int[] arr= { 1000000000,999999999,1000000000,999999999,1000000000,999999999};
        int k=1000000000 ;
        System.out.println(minOperations(arr, k));
    }
}
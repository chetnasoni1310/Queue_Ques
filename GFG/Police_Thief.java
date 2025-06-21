public class Police_Thief {
 public int catchThieves(char[] arr, int k) {
        // code here
        
        /* Make 2 queues of integers having chrwith its index in it 
        Compare the index , if (p) + k >= t  or p - k <= t  then 
                          we can have CTheif ++ and remove that theif from the queue
                          */
        
        Queue<Integer>  thief = new ArrayDeque<>();
        Queue<Integer>  police = new ArrayDeque<>();
        
        int CatchedThief = 0;
        
        //Fill the queue
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == 'P')
            {
                police.offer(i);
            }
            else
            {
                thief.offer(i);
            }
        }
        
        
        while(!police.isEmpty()  && !thief.isEmpty())
        {   
            int p = police.peek();
            int t = thief.peek();
            
            if(t >= p - k && t <= p + k)
            {
               CatchedThief++;
               police.poll();
               thief.poll();
            }
            else if(p<t)
            {
                police.poll();  
            }
            else
            {
              thief.poll();   
            }
               
        }
        
        return CatchedThief;
        
    }
}

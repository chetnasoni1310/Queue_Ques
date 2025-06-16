public class _649_Dota2_Senate{
     public String predictPartyVictory_MATHEMATICAL_LOGIC(String senate) {
        /**Dimaag lagane ka prayaas
        1. cr cr and br bd 
        count r and  d 
        banned r and d
        
        dekho jo bhi aaye 
        agar r hai toh cd-- and bd++
        agar d hai toh cr-- and br++
        
        fir compare krlena cr and cd ko
         */

        int cr = 0 , cd=0 ,bd=0 ,br=0;
        int len = senate.length(); 
        boolean[] banned = new boolean[len]; 

        for(int i=0;i<len;i++)
        { 
            

            if(senate.charAt(i)== 'R')
            {
                cr++;
            }
            else
            {
                cd++;
            }
        }
       
      
       while(cr!=0 && cd!=0 )
        {   
            for(int i=0;i<len;i++)
            {
                if( banned[i]) //Permanently ban hoga toh nhi use krna hai 
                continue;

                if(senate.charAt(i) == 'R')
                {
                    if(br == 0)
                    {
                        bd++;
                    }
                    else
                    {  
                        banned[i] = true;
                        cr--;
                        br--;
                    }
                    
                }
                else
                {
                    if(bd == 0)
                    {
                        br++;
                    }
                    else
                    {  
                        banned[i] = true;
                        cd--;
                        bd--;
                    }
                }
            }
        }
        
        return ( cr > cd ) ?  "Radiant" : "Dire";
        
    }


     public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> qr = new ArrayDeque<>();
        Queue<Integer> qd = new ArrayDeque<>();

       for(int i=0;i<n;i++)
       {
            if(senate.charAt(i) == 'R')
            {
                qr.offer(i);
            }
            else
            {
                qd.offer(i);
            }
       }   

       
       while(!qr.isEmpty()  && !qd.isEmpty())
       {
            int r = qr.poll();
            int d = qd.poll();
           
            if( d<r )
            {
            qd.offer(d + n);
            }
            else
            {
            qr.offer(r + n);
            }
       }

       if(!qr.isEmpty())
       return "Radiant";
       else
       return "Dire";
     }
}
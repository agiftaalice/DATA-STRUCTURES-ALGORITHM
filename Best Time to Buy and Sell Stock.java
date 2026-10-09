class Solution {    
    public int maxProfit(int[] prices) {   
             int minPrice = Integer.MAX_VALUE, profit = 0;     
                for (int p : prices) {         
                       minPrice = Math.min(minPrice, p);       
                            profit = Math.max(profit, p - minPrice);   
                                 }        return profit;   
                                  }
                                   }

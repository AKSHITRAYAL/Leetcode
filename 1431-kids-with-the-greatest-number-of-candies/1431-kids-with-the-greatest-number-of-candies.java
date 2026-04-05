import java.util.Arrays;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // int greatest = Arrays.stream(candies).max().getAsInt();
        int greatest = candies[0];
        for(int candy : candies){
            if(candy > greatest){
                greatest = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++){
        //     if(extraCandies + candies[i] >= greatest){
        //         result.add(true);
        //     } else{
        //         result.add(false);
        //     }
            result.add(candies[i] + extraCandies >= greatest);
        }
            
        return result;
    }
}
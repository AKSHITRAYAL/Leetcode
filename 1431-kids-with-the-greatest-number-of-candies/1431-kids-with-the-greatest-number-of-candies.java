import java.util.Arrays;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++){
            if(extraCandies + candies[i] >= greatest){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }
}
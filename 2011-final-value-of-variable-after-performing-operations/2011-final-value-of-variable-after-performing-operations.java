
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].charAt(1)=='+'){
            // if(operations[i].contains("+")){
            // this checks like a searching inside the loop of the string array at every position with a brute force method 
                x++;
            }
            else if(operations[i].charAt(1)=='-'){
                x--;
            }
        } return x;
    }
}
 

 
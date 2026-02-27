
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++){
            String operation = operations[i];
            if(operation.contains("+")){
                x++;
            }
            else if(operation.contains("-")){
                x--;
            }
        } return x;
    }
}
 

 
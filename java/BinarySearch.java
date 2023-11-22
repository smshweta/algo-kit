/*  Binary Search is used in sorted array.
    Time complexity = O(log N) N-> number of elements in array.
    Space Complexity = O(1) 
    
    For binary search in m * n matrix add below code.
        int n = matrix[0].length;  (column length)
        mid = (first + last) / 2;
        num = matrix[mid / n][mid % n];

    */

class BinarySearch{
    int binarySearch(int[] array, int value){
        int first = 0;
        int last = array.length-1;
        
        while(first<=last){
            
            int mid = first + (last-first)/2;       
            
            if(value==array[mid]){
                return mid;
            }else if(value > array[mid]){
                first = mid+1;   
            }else{
                last = mid -1;
            }
        }
        return -1; // If value is not present in the array
    }

    //Driver Code
    public static void main(String[] args){
        BinarySearch obj = new BinarySearch();
        int[] array = {1,2,3,4,5};
        int value = 2;
        int result = obj.binarySearch(array, value);
        if(result == -1)
            System.out.println("Value not found in array"); 
        else       
            System.out.println("Value is present at index " + result);
    }
}



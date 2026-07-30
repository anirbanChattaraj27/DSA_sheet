1. K CLosest element

public List<Integer> F1(int arr[], int k){
    int sum = 0;
    int e = arr.length - 1;
    for (int s=0; s<arr.length; s++){
        // sum = sum+arr[s];

        while(e-s+1 > k){
            if(Math.abs(arr[s] -x) > Math.abs(arr[e] -x)){
                s++;
            }
            else{
                e--;
            }
        }
    }

    List<Integer> list = new ArrayList<>();
    for(int i=left; i<right; i++){
        list.add(arr[i]);
    }
    return list;
}

2. shortest
public int f2(int[] A, int K) {
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    int s = 0;
    // int e = 0;

    for(int e=0; e<A.length; i++){
        sum += arr[e];

        while(sum > k){
            minLen = Math.min(minLen, e-s+1);
            sum -= arr[e];
        }
        if(sum >= K){
            minLen = Math.min(minLen, e-s+1);
        }

    }
    return minLen
}



LC 930
public int f3(int arr[], int k){
    int s=0, sum=0;

    for(int e=0; e<arr.length; e++){
        sum = sum+arr[e];

        while(sum > k){
            sum = sum - arr[s--];
        }
        count += r-l+1;
    }
    return count;
}
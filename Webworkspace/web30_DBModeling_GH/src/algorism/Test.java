package algorism;

public class Test {
	
	public static int[] solution(int [] arr) {
		
        int[] answer = {};
        int[] result= {};
        
        for(int i=0; i<arr.length;i++) {
        	for(int j=0; j<result.length; j++) {
        		if(result[j]==arr[i]) {
        			result[result.length] = arr[i];
        		}
        	}
        }
        
        answer = result;
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] input= {1,1,3,3,0,1,1};
		
		int[] answer= solution(input);
		
		for(int i=0; i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
	}
}


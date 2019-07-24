package D7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static String matrix[];
	
	static boolean isZeroRow(String str){
        return str.replaceAll("0", "").length() <= 0;
    }
	
	static String hexToBinary(String hex){
        String binaryStr = new BigInteger(hex, 16).toString(2);
        int count = Math.round((float)binaryStr.length()/8 + 0.5f);
        String temp = "";
        for(int i=0; i<count/2; i++){ 
        	temp += "0"; 
        }
        return temp + binaryStr + temp;
    }
	
	static int decode(String s){
        int len = s.length()/7;
        String t1 = "";
        String t2 = "";
        for(int i=0; i<len; i++){
            t1 += "0";
            t2 += "1";
        }
        String convertedCode = s.replaceAll(t1, "0").replaceAll(t2, "1");
        switch (convertedCode){
            case "0001101":
                return 0;
            case "0011001":
                return 1;
            case "0010011":
                return 2;
            case "0111101":
                return 3;
            case "0100011":
                return 4;
            case "0110001":
                return 5;
            case "0101111":
                return 6;
            case "0111011":
                return 7;
            case "0110111":
                return 8;
            case "0001011":
                return 9;
        }
        return -1;
    }
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int N = 0;
		int M = 0;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 배열 행 크기 : N
			M = Integer.parseInt(st.nextToken()); // 배열 열 크기 : M
			
			matrix = new String[N];
			ArrayList<String> set = new ArrayList<String>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				matrix[i] = st.nextToken();
				if (!isZeroRow(matrix[i])) {
					for(String code : set) {
						matrix[i] = matrix[i].replaceAll(code, "");
					}
					
					matrix[i] = matrix[i].replaceAll("0", " "); // 0을 " "로 변경
					matrix[i] = matrix[i].trim();	// 앞뒤 공백 제거 : 암호 사이 0은 공백으로 놔둠 
					matrix[i] = matrix[i].replaceAll(" ", "0"); // 암호 사이 공백을 0으로 변경
					
					if(matrix[i].equals(""))
						continue;
	
					String code2 = matrix[i].replaceAll("0000", " ");
		            code2 = code2.trim();
		            String empty = "";
		            for(char c : code2.toCharArray()){
		            	if (" ".equals(c + ""))
		            		empty += " ";
		            }
		            if("".equals(empty)){
		            	if(!matrix[i].equals(""))
		            		set.add(matrix[i]);
		            } 
		            else {
		            	for (String s : code2.split("\\s+")) {
		            		String tmp = s + "";
		            		tmp = tmp.replaceAll("0", " ");
		                    tmp = tmp.trim();
		                    tmp = tmp.replaceAll(" ", "0");
		                    if (!tmp.equals(""))
		                    	set.add(tmp);
		                    }
		            	}
		         }
			}

			// Hex -> Binary
			
			for(int i=0; i<set.size(); i++){
                for(int j=0; j<set.size(); j++){
                    if(j != i){
                        String temp = set.get(i);
                        temp = temp.replaceAll(set.get(j), "");
                        temp = temp.replaceAll("0", " ");
                        temp = temp.trim();
                        temp = temp.replaceAll(" ", "0");
                        set.set(i, temp);
                    }
                }
            }
			
			for(int i=0; i<set.size(); i++){
                String binary = hexToBinary(set.get(i));
                set.set(i, binary);
            }
			
			// Decode
			ArrayList<ArrayList<Integer>> convertedCodes = new ArrayList<>();
            for(String code : set) {
                int len = 0;
                int count = code.length()/56;
                len = count * 7;
                int flagIndex = 0;
                boolean isContinually = false;
                ArrayList<Integer> foundCode = new ArrayList<>();
                for (int i = 0; i < code.length() - len; i++) {
                    String str = code.substring(i, i + len);
                    int num = decode(str);
                    if (num >= 0 && !isContinually) {
                        isContinually = true;
                        flagIndex = i;
                        foundCode.add(num);
                        i += (len-1);
                    } else if (num < 0 && isContinually) {
                        foundCode.clear();
                        isContinually = false;
                        i = flagIndex;
                    } else {

                        if (num < 0) {
                            continue;
                        } else {
                            foundCode.add(num);
                            i += (len-1);
                        }
                    }
                    if (foundCode.size() >= 8) {
                        break;
                    }
                }
                if(foundCode.size() > 0)
                    convertedCodes.add(foundCode);
            }
            
            int result = 0;
            for(ArrayList<Integer> list : convertedCodes){
                int sumOfEven = 0, sumOfOdd = 0;
                for (int i = 0; i < 7; i++) {
                    if ((i + 1) % 2 == 0) {
                        sumOfOdd += list.get(i);
                    } else {
                        sumOfEven += list.get(i);
                    }
                }
                int parity = list.get(7);
                int check = sumOfEven * 3 + sumOfOdd + parity;
                if (check % 10 == 0) {
                    for(int i : list){
                        result += i;
                    }
                }
            }
            System.out.println("#" + ++t_num + " " + result);
		}
		br.close();				

	}
}

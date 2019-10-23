import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int maxValue = 0;
    static void print(int[][] map){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }
    static int[][] deepCopy(int[][] map){
        int[][] map2 = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map2[i][j] = map[i][j];
            }
        }
        return map2;
    }
    static void dfs(int count, int[][] map){
        if(count==5){
            updateMax(map);
            return;
        }
        for(int i=0; i<4; i++){
            int[][] nextMap = deepCopy(map);
            move(i, nextMap);
            dfs(count+1, nextMap);
        }
    }
    static void move(int dir, int[][] map){
        List<Integer> line;
        // 상
        if(dir==0){
            for(int i=1; i<=N; i++){
                line = new ArrayList<>();
                for(int j=1; j<=N; j++){
                    if(map[j][i]!=0) line.add(map[j][i]);
                    map[j][i]=0;
                }
                line = sumLine(line);
                for(int j=0; j<line.size(); j++) map[j+1][i] = line.get(j);
            }
        }
        // 우
        if(dir==1){
            for(int i=1; i<=N; i++){
                line = new ArrayList<>();
                for(int j=0; j<N; j++){
                    if(map[i][N-j]!=0) line.add(map[i][N-j]);
                    map[i][N-j]=0;
                }
                line = sumLine(line);
                for(int j=0; j<line.size(); j++) map[i][N-j] = line.get(j);
            }
        }
        // 하
        if(dir==2){
            for(int i=1; i<=N; i++){
                line = new ArrayList<>();
                for(int j=N; 1<=j; j--){
                    if(map[j][i]!=0) line.add(map[j][i]);
                    map[j][i]=0;
                }
                line = sumLine(line);
                for(int j=0; j<line.size(); j++) map[N-j][i] = line.get(j);
            }
        }
        // 좌
        if(dir==3){
            for(int i=1; i<=N; i++){
                line = new ArrayList<>();
                // 리스트 추출
                for(int j=1; j<=N; j++){
                    if(map[i][j]!=0) line.add(map[i][j]);
                    map[i][j]=0;
                }
                line = sumLine(line);
                // 행렬로 변환
                for(int j=0; j<line.size(); j++) map[i][j+1] = line.get(j);
            }
        }
    }
    // 한줄 리스트를 입력받아서 합쳐줌
    static List<Integer> sumLine(List<Integer> line){
        for(int i=0; i<line.size()-1; i++){
            if(line.get(i).equals( line.get(i+1) )){
                line.set(i, line.get(i)*2);
                line.remove(i+1);
            }
        }
        return line;
    }
    static void updateMax(int[][] map){

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                maxValue = Math.max(maxValue, map[i][j]);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, map);
        System.out.println(maxValue);
    }
}
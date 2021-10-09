import java.util.*;

class Table {
    int y, x;
    Table(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    final static int dy[] = { 0,-1, 0, 1};
    final static int dx[] = {-1, 0, 1, 0};
    static int answer;
    static Queue<Table> q;
    static int Y, X;
    static TreeMap<Integer, int[][]> tableMap = new TreeMap<>();
    static TreeMap<Integer, int[][]> boardMap = new TreeMap<>();
    static boolean visit[];
    

    static int getScore(int[][] a) {
        int score = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 1) {
                    score++;
                }
            }
        }
        return score;
    }

    static boolean checkTable(int[][] a, int[][] b) {       
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[r].length; c++) {
                if(b[r][c] == 1) {
                    maxY = Math.max(maxY, r);
                    minY = Math.min(minY, r);
                    maxX = Math.max(maxX, c);
                    minX = Math.min(minX, c);
                }
            }
        }
        int row = maxY - minY + 1;
        int col = maxX - minX + 1;
        if(isEqual(a, b)) {
            return true;
        }
        // 0: 90, 1: 180, 2: 270
        for (int i = 0; i < 3; i++) {
            int temp[][] = new int[6][6];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    temp[c][row-r-1] = b[r][c];
                }
            }
            row ^= col;
            col ^= row;
            row ^= col;
            b = deepCopy(temp);
            if(isEqual(a, b)) {
                return true;
            }
        }
        return false;
    }

    static int[][] deepCopy(int[][] b) {
        int a[][] = new int[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                a[i][j] = b[i][j];
            }
        }
        return a;
    }

    static boolean isEqual(int a[][], int b[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void makePuzzle(boolean isBoard, int matrix[][], TreeMap<Integer, int[][]> map) {
        int idx = 0;
        int value = isBoard?0:1;
        q = new LinkedList<Table>();
        boolean isPuzzle[][] = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(matrix[i][j] == value && !isPuzzle[i][j]) {
                    ArrayList<Table> list = new ArrayList<Table>();
                    q.offer(new Table(i, j));
                    list.add(new Table(i, j));
                    int ty = 0;
                    int tx = 0;
                    int minY = i;
                    int minX = j;
                    // 도형여부 bfs탐색
                    while(!q.isEmpty()) {
                        Table t = q.poll();
                        for (int d = 0; d < 4; d++) {
                            ty = t.y + dy[d];
                            tx = t.x + dx[d];
                            if(ty < 0 || ty >= Y || tx < 0 || tx >= X) continue;
                            if(isPuzzle[ty][tx]) continue;
                            if(matrix[ty][tx] != value) continue;
                            isPuzzle[ty][tx] = true;
                            q.offer(new Table(ty, tx));
                            list.add(new Table(ty, tx));
                            minY = Math.min(minY, ty);
                            minX = Math.min(minX, tx);
                        }
                    }
                    int[][] array = new int[6][6];
                    for (Table t : list) {
                        int r = t.y;
                        int c = t.x;
                        array[r-minY][c-minX] = 1;
                    }
                    map.put(idx++, array);
                }
            }
        }       
    }    
    
    public int solution(int[][] game_board, int[][] table) {
        Y = table.length;
        X = table[0].length;
        
        /** TODO : 1. 테이블 도형 체크 */
        makePuzzle(false, table, tableMap);
        
        /** TODO : 2. 게임보드에 도형저장 */
        makePuzzle(true, game_board, boardMap);
        
        /** TODO : 3. 도형 채우기 
         * 모든조각은 반드시 격자 칸에 딱 맞게 놓여있음 
         * */
        boolean isTable[] = new boolean[tableMap.keySet().size()];
        for (int i : boardMap.keySet()) {
            for (int j : tableMap.keySet()) {
                if(isTable[j]) continue;
                if(checkTable(boardMap.get(i), tableMap.get(j))) {
                    answer += getScore(boardMap.get(i));
                    isTable[j] = true;
                    break;
                }
            }
        }
        return answer;
    }
}
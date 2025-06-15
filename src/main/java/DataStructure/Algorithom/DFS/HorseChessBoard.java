package DataStructure.Algorithom.DFS;


import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    private static  int X;//棋盘的列
    private static  int Y;//棋盘的行，符合笛卡尔坐标系
    private static  boolean[] visited;// 记录棋盘各个位置是否被访问过
    private static  boolean finished;// 标记是否棋盘的所有位置都被访问

    public static void main(String[] args) {

        X = 8;
        Y = 8;
        int row = 1;
        int col = 1;
        int [][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        traversalChessboard(chessboard, 0, 0, 1);

        for (int[] rows : chessboard){
            for (int columns : rows){
                System.out.print(columns + "\t");
            }
            System.out.println();
        }
    }

    /***
     * 完成马踏棋盘问题
     * @param chessboard  棋盘
     * @param row  马儿当前位置的行， 0开始
     * @param col  马儿当前位置的列， 0开始
     * @param step  是第几步，初始位置就是第一步
     */
    public static void traversalChessboard(int [][] chessboard, int row, int col, int step){
        chessboard[row][col] = step;
        visited[row * X + col] = true;//标记该位置已经访问
        ArrayList<Point> ps = next(new Point(col, row));

        //使用贪心算法进行优化
        //对ps进行排序，排序的规则就是对ps的所有Point对象的下一步的位置的数目，进行非递减排序
        sort(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0);
            if(!visited[p.y * X + p.x]){//还没有被访问
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        /**
         * 判断马儿是否完成了任务，使用step和应该走的步数比较
         * 如果没有达到数量，则表示没有完成任务，将整个棋盘置 0
         * 注意： step < X*Y有两种情况
         * 1. 棋盘到目前位置，仍未走完
         * 2. 棋盘处于一个回溯过程
         */

        if(step < X*Y && !finished){
            chessboard[row][col] = 0;
            visited[row * X + col] = false;
        }else {
            finished = true;
        }
    }

    /***
     * 根据当前位置计算还有哪些位置可以移动，并放入一个集合中去，最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();

        //表示马可以走5这个位置
        if((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y-1) >= 0){
            ps.add(new Point(p1));
        }

        //表示马可以走6这个位置
        if((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y-2) >= 0){
            ps.add(new Point(p1));
        }

        //表示马可以走7这个位置
        if((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y-2) >= 0){
            ps.add(new Point(p1));
        }
        //表示马可以走0这个位置
        if((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y-1) >= 0){
            ps.add(new Point(p1));
        }
        //表示马可以走1这个位置
        if((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y+1) < Y){
            ps.add(new Point(p1));
        }
        //表示马可以走2这个位置
        if((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y+2) < Y){
            ps.add(new Point(p1));
        }
        //表示马可以走3这个位置
        if((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y+2) < Y){
            ps.add(new Point(p1));
        }
        //表示马可以走4这个位置
        if((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y+1) < Y){
            ps.add(new Point(p1));
        }

        return  ps;
    }

    //根据当前这一步的所有的下一步的选择位置，进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1的下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1 < count2){
                    return -1;
                }else if(count1 == count2){
                    return 0;
                }else {
                    return 1;
                }

            }
        });
    }
}

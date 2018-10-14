package HiredInTech;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WhereAmI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        char[][] grid = new char[n][m];
        char[][] surroundings = new char[p][q];
        Point goal = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < p; i++) {
            surroundings[i] = sc.nextLine().toCharArray();
        }
        System.out.println(findGoal(grid, n, m, surroundings, p, q, goal));
        sc.close();
    }

    private static int findGoal(char[][] grid, int n, int m, char[][] surroundings, int p, int q, Point goal) {
        int found = -1;
        Point robotPosition = findRobotInSurroundings(surroundings, p, q);
        int[][] distance = bfs(grid, goal, n, m);
        if(robotPosition == null) return -1;

        for (int i = 0; i <= n - p; i++) {
            for (int j = 0; j <= m - q; j++) {
                if (amIHere(grid, i, j, surroundings, p, q)) {
                    Point newRobot = new Point(robotPosition.y + i, robotPosition.x + j);
                    int dist = distance[newRobot.y][newRobot.x];
                    if (dist == -1) return -2;
                    if (dist > found) found = dist;
                }
            }
        }

        return found;
    }

    private static int[][] bfs(char[][] grid, Point end, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
        distance[end.y][end.x] = 0;
        Queue<Point> points = new LinkedList<>();

        points.add(end);
        while (!points.isEmpty()) {
            Point sPoint = points.poll();
            LinkedList<Point> neighbors = new LinkedList<>();

            //Check top
            if (sPoint.y > 0 && grid[sPoint.y - 1][sPoint.x] != '1' && !visited[sPoint.y - 1][sPoint.x]) {
                neighbors.add(new Point(sPoint.y - 1, sPoint.x));
            }
            //Check bottom
            if (sPoint.y < n -1 && grid[sPoint.y + 1][sPoint.x] != '1' && !visited[sPoint.y + 1][sPoint.x]) {
                neighbors.add(new Point(sPoint.y + 1, sPoint.x));
            }
            //Check right
            if (sPoint.x > 0 && grid[sPoint.y][sPoint.x - 1] != '1' && !visited[sPoint.y][sPoint.x - 1]) {
                neighbors.add(new Point(sPoint.y, sPoint.x - 1));
            }
            //Check left
            if (sPoint.x < m - 1 && grid[sPoint.y][sPoint.x + 1] != '1' && !visited[sPoint.y][sPoint.x + 1]) {
                neighbors.add(new Point(sPoint.y, sPoint.x + 1));
            }
            while (!neighbors.isEmpty()) {
                Point neighbor = neighbors.pop();
                points.add(neighbor);
                visited[neighbor.y][neighbor.x] = true;
                distance[neighbor.y][neighbor.x] = distance[sPoint.y][sPoint.x] + 1;
            }
        }

        return distance;
    }

    private static boolean amIHere(char[][] grid, int y, int x, char[][] surroundings, int p, int q) {
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (surroundings[i][j] != grid[y + i][x +j]) return false;
            }
        }

        return true;
    }

    private static Point findRobotInSurroundings(char[][] surroundings, int p, int q) {
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if(surroundings[i][j] == '2') {
                    surroundings[i][j] = '0';
                    return new Point(i, j);
                }
            }
        }

        return null;
    }

    private static class Point {
        private int x, y;

        private Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}

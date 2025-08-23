import java.util.Scanner;

public class floodFillAlgorithm {
    public static void solve(char[][] image, int sr, int sc, char preColour, char newColour) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != preColour) {
            return;
        }

        // recolor current cell
        image[sr][sc] = newColour;

        // recursive calls in 4 directions
        solve(image, sr - 1, sc, preColour, newColour); // up
        solve(image, sr + 1, sc, preColour, newColour); // down
        solve(image, sr, sc - 1, preColour, newColour); // left
        solve(image, sr, sc + 1, preColour, newColour); // right
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int rows = input.nextInt();   // number of rows
        int cols = input.nextInt();   // number of columns
        input.nextLine();             // consume leftover newline

        char[][] image = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = input.nextLine().trim();
            if (line.length() != cols) {   // validate row length
                System.out.println("Error: row " + (i+1) + " must have exactly " + cols + " characters.");
                return;
            }
            for (int j = 0; j < cols; j++) {
                image[i][j] = line.charAt(j);
            }
        }

        char newColour = input.next().charAt(0);  // new color
        int sr = input.nextInt();  // start row
        int sc = input.nextInt();  // start col

        char preColour = image[sr][sc];
        if (preColour != newColour) {
            solve(image, sr, sc, preColour, newColour);
        }

        // print result
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}

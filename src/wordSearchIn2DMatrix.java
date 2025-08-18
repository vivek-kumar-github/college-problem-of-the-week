public class wordSearchIn2DMatrix {
    public static boolean search(char[][] matrix, String word){
        int m = matrix.length;
        int n = matrix[0].length;

        //Search in each row
        for(int i = 0; i < m; i++){
            String rowStr = new String(matrix[i]);
            if (rowStr.contains(word)){
                return true;
            }
        }

        //Search in each column
        for(int j = 0; j < n; j++){
            StringBuilder colStr = new StringBuilder();
            for (int i = 0; i < m; i++) {
                colStr.append(matrix[i][j]);
            }
            if(colStr.toString().contains(word)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        String word = "FOAM";
        String word1 = "FACE";
        System.out.println(search(matrix, word));
        System.out.println(search(matrix, word1));
    }
}

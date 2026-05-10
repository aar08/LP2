class NQ {
    static int N = 4;

    static boolean safe(int b[][], int r, int c) {
        for (int i = 0; i < r; i++)
            if (b[i][c] == 1) return false;

        for (int i=r, j=c; i>=0 && j>=0; i--, j--)
            if (b[i][j] == 1) return false;

        for (int i=r, j=c; i>=0 && j<N; i--, j++)
            if (b[i][j] == 1) return false;

        return true;
    }

    static boolean solve(int b[][], int r) {
        if (r == N) return true;

        for (int c = 0; c < N; c++) {
            if (safe(b, r, c)) {
                b[r][c] = 1;
                if (solve(b, r + 1)) return true;
                b[r][c] = 0; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int b[][] = new int[N][N];

        solve(b, 0);

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++)
                System.out.print(b[i][j]+" ");
            System.out.println();
        }
    }
}
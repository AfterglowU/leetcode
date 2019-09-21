/**
 * 这个 trick 并不能用于 [74] 题.
 * 这是因为 [74] 题的矩阵是通过 stdin 读入后生成的, 那么肯定是如下结构
 *      matrix -> | matrix[0] | -> [x,x,...,x ]
 *                | matrix[0] | -> [x,x,...,x ]
 *                     ...              ...
 *                |matrix[m-1]| -> [x,x,...,x ]
 * 而不是像本文件中这样连续存储的
 *   matrix
 *      |
 *      v
 *    [[x,x,...x][x,x,...x]...[x,x,...x]]
 */

#include <stdio.h>

void traverse(int **p, int rowLen, int colLen) {
    int *tmp = (int *)p;
    int n = rowLen * colLen;
    for (int i = 0; i < n; i++) {
        printf("%d,", tmp[i]);
    }
    printf("\n");
}

int main() {
    int a[2][5] = {{0,1,2,3,4},
                   {5,6,7,8,9} };
    traverse(a,2,5);
    return 0;
}
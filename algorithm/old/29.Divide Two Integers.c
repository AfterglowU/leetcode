#include <stdio.h>

#define MAX_INT 2147483647
#define MIN_INT -MAX_INT-1

// An ALU's division operation simulator
int divide(int dividend, int divisor) {
    int sign_dividend = 0;
    int sign_divisor = 0;
    unsigned long remainder;
    unsigned long divisor_u;
    unsigned quotient = 0;

    if (dividend < 0) {
        if (dividend != MIN_INT)
            dividend = -dividend;
        sign_dividend = 1;
    }

    if (divisor < 0) {
        if (divisor != MIN_INT)
            divisor = -divisor;
        sign_divisor = 1;
    }
    
    remainder = (unsigned) dividend;
    divisor_u = (unsigned) divisor;
    divisor_u <<= 32;
    
    for (int i = 0; i < 33; i++) {
        if (remainder >= divisor_u) {
            remainder -= divisor_u;
            quotient <<= 1;
            quotient |= 1;
        } else {
            quotient <<= 1;
        }
        divisor_u >>= 1;
    }


    if (!(sign_dividend ^ sign_divisor)) {
        return (quotient == MIN_INT) ? MAX_INT : quotient;
    } else {
        return -quotient;
    }
}

int main() 
{
    int dividend, divisor;
    scanf("%d", &dividend);
    scanf("%d", &divisor);
    
    unsigned q = divide(dividend, divisor);
    printf("result = %d\n", q);

    return 0;
}
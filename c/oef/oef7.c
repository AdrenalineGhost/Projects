

/* LET OP! om zo min mogelijk zaken te herberekenen, bewaar je telkens de laatst gebruikte term (bvb -x^3/3!)
 *    en leid je daaruit de volgende term af.
 *    Anders zou je veel berekeningen opnieuw doen. Vergelijk:
 *        om x^5/5! rechtstreeks uit te rekenen, heb je volgende bewerkingen nodig:
 *                   x*x*x*x*x / (1*2*3*4*5)
 *
 *        om x^5/5! af te leiden uit -x^3/3! (het 'vorige resultaat'),  heb je volgende bewerkingen nodig:
 *		    ('vorige resultaat') * (-x*x)/(4*5)
 *
 * Dit verschil vergroot als je verder in de reeksontwikkeling bent. */

#include <stdio.h>
#include <math.h>
/*********************************** versie 1 *********************/
int main() {
    double x = 8.2;
    double term = x;
    double som = x;
    for (int i=2 ; i<20 ; i += 2) {
        term *= -x*x / (i*(i+1));
        som += term;
    }
    printf("sin(%.2lf) =  %.15lf \n",x,som);
    printf("controle     %.15lf \n",sin(x));
    return 0;
}

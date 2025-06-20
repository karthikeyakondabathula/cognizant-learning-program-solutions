public class Main {
public static void main(String[] args){
double sV = 100;
double rate = 0.7;
int years = 8;

double result = futureValue(sV, rate, years);
System.out.println("Future Value after " + years + " years: " + result);
}

static double futureValue(double value, double growth, int year){
if(year==0)return value;
return futureValue(value, growth, year-1)*(1+growth);
}
}

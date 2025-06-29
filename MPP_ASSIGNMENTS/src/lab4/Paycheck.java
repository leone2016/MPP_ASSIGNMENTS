package lab4;

public final class Paycheck {
    public double grossPay;
    public double fica ;
    public double state;
    public double local;
    public double mediCare;
    public double socialSecurity;

    public Paycheck(double grossPay) {
        this.grossPay = grossPay;
        this.fica = 0.23 * this.grossPay;
        this.state = 0.05 * this.grossPay;
        this.local = 0.01 * this.grossPay;
        this.mediCare = 0.03 * this.grossPay;
        this.socialSecurity = 0.075 * this.grossPay;
    }

    public void print(){
        System.out.printf("Gross Pay: %.2f\nNet Pay: %.2f\n", grossPay, getNetPay());
    }

    public double getNetPay(){
        return this.grossPay -  this.fica - this.state -  this.local - this.mediCare - this.socialSecurity;
    }
}

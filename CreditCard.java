public class CreditCard {
    private Money balance;
    private Money creditLimit;
    private Person owner;

    public CreditCard(Person newCardHolder, Money limit) {
        this.owner = newCardHolder;
        this.creditLimit = limit;
        this.balance = new Money(0);
    }

    public Money getBalance() {
        return new Money (balance);
    }

    public Money getCreditLimit() {
        return new Money (creditLimit);
    }

    public String getPersonals() {
        return owner.toString();
    }

    public void charge(Money amount) {
        Money newBalance = amount.add(balance);
        if(creditLimit.compareTo(newBalance) >= 0){
            balance = newBalance;
            System.out.printf("%s:%10s%n","Charge",amount);
        }else {
            System.out.println("Exceeds your credit limit");
        }
    }

    public void payment(Money amount) {
       balance = balance.subtract(amount);
        System.out.println("Payment: " + balance);
    }
}

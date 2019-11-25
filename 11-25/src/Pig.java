class Pig extends Animal{
    String house;

    Pig() {
        super();
    }

    @Override
    public void scream() {
        System.out.println("哼哼");
    }

    public static void main(String[] args) {
        Animal pig = new Pig();
        Pig p = new Pig();
        pig.scream();
    }
}

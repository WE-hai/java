class Dog extends Animal{
    String host;

    Dog() {
        super();
    }
    Dog(String host) {
        super(1,4);
        this.host = host;
    }

    @Override
    public void scream() {
        System.out.println("汪汪汪");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("a");
        Animal d = new Dog();
        dog.scream();
    }
}

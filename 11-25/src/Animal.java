class Animal {
    int color;
    int numberOfLegs;

    Animal() {
        color = 0;
        numberOfLegs = 2;
    }

    Animal(int color,int numberOfLegs) {
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public void scream() {
        System.out.println("我是一个动物！");
    }

    public int getNumberOfLegs() {
        return 4;
    }
}

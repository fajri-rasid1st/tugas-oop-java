package tugas3;

class Item {
    private String name;
    private int price;
    private String info;

    public Item(String name, int price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    public double[] use(int price, double damage, double energy, double hp) {
        double[] increase = new double[3];
        for (int idx = 0; idx < increase.length; idx++)
            if (price == 3210) {
                increase[idx] = (energy * 40) / 100;
            } else if (price == 4450) {
                increase[idx] = (damage * 30) / 100;
            } else if (price == 2980) {
                increase[idx] = (hp * 45) / 100;
            }
        return increase;
    }

    public boolean sell(int totalItem) {
        if (totalItem != 0) {
            System.out.println("\nSuccessfully sold the item");
            return true;
        } else {
            System.out.println("\nItem still empty");
            return false;
        }
    }

    public boolean destroy(int totalItem) {
        if (totalItem != 0) {
            System.out.println("\nSuccessfully destoyed the item");
            return true;
        } else {
            System.out.println("\nItem still empty");
            return false;
        }
    }
}
package tugas3;

import java.util.Arrays;
import java.lang.Thread;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Player {
    private String name;
    private String role;
    private int level;
    private double damage;
    private double hp;
    private double energy;
    private int money;
    private final Item[] items = new Item[3];
    // addeded some attributes
    private static Scanner sc = new Scanner(System.in);
    private double exp = 0;
    private double expLevelUp = 60;
    private int index = 0;

    public Player(String name, String role, double damage, int money) {
        this.name = name;
        this.role = role;
        this.level = 1;
        this.damage = damage;
        this.hp = 100;
        this.energy = 50;
        this.money = money;
    }

    public void showStatus() {
        System.out.printf("\nName \t: %s\n", this.name);
        System.out.printf("Role \t: %s\n", this.role);
        System.out.printf("Level \t: %d\n", this.level);
        System.out.printf("Damage \t: %.02f\n", this.damage);
        System.out.printf("HP \t: %.02f\n", this.hp);
        System.out.printf("Energy \t: %.02f\n", this.energy == 0 ? 0 : this.energy);
        System.out.printf("Money \t: Rp.%d\n", this.money);
    }

    public void showItems() {
        int i = 1;
        if (items[0] == null) {
            Arrays.fill(items, new Item("kosong", 0, "kosong"));
        }
        for (Item item : items) {
            System.out.printf("\nItem %d : %s | Rp.%d | %s", i, item.getName(), item.getPrice(), item.getInfo());
            i++;
        }

        Item itemUse = new Item();
        System.out.println("\n\n1. Use item");
        System.out.println("2. Destroy item");
        System.out.println("3. Sell item");
        System.out.println("0. Back/Exit");
        System.out.print("> ");
        int x = sc.nextInt();

        if (x == 1) {
            int totalItem = 0;
            for (int idx = 0; idx < items.length; idx++) {
                if (itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx] == (energy * 40) / 100) {
                    energy += itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx];
                } else if (itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx] == (damage * 30) / 100) {
                    damage += itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx];
                } else if (itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx] == (hp * 45) / 100) {
                    hp += itemUse.use(items[idx].getPrice(), damage, energy, hp)[idx];
                }
            }

            for (Item item : items) {
                totalItem += item.getPrice();
            }
            if (totalItem != 0) {
                System.out.println("\nSuccessfully used the item");
            } else {
                System.out.println("\nItem still empty");
            }
            Arrays.fill(items, new Item("kosong", 0, "kosong"));

        } else if (x == 2) {
            int totalItem = 0;
            for (Item item : items) {
                totalItem += item.getPrice();
            }
            if (itemUse.destroy(totalItem)) {
                Arrays.fill(items, new Item("kosong", 0, "kosong"));
            }

        } else if (x == 3) {
            int totalItem = 0;
            for (Item item : items) {
                totalItem += item.getPrice();
            }
            if (itemUse.sell(totalItem)) {
                money += totalItem;
                Arrays.fill(items, new Item("kosong", 0, "kosong"));
            }
        }
    }

    public boolean attack(Player opponent) {
        if (hp > 0 && energy > 0) {
            System.out.printf("\n%s from %s !", getDamage(opponent.getDamage()), opponent.getName());
            System.out.printf(" || %s's energy reduce %.02f", name, energy < energyReduce() ? energy : energyReduce());
            energy -= energy < energyReduce() ? energy : energyReduce();
            levelUp();
            Arrays.fill(items, new Item("kosong", 0, "kosong"));
            return true;
        } else if (energy <= 0) {
            System.out.printf("\n%s's energy is not enough to attack !", getName());
            return false;
        } else {
            return false;
        }
    }

    public String getDamage(double damagePower) {
        hp -= damagePower;
        return String.format("%s gets damage %.02f", getName(), damagePower);
    }

    public boolean healing(double hp) {
        if (hp < 20 && money >= 1000) {
            try {
                for (int i = 0; i < 7; i++) {
                    double d = ThreadLocalRandom.current().nextDouble(3, 5);
                    Thread.sleep(1000);
                    this.hp += d;
                    System.out.printf("\nRegen on process... +%.02fHP", d);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                System.out.println("\nRegen Successful");
                money -= 1000;
            }
            return true;
        } else if (money < 1000) {
            System.out.println("\nNot enough money");
            return false;
        } else {
            System.out.println("\nRegen can only be used when the HP is less than 20");
            return false;
        }
    }

    public boolean buy() {
        System.out.println("\nSelect the item you want to buy :");
        System.out.println("You have Rp." + money);
        System.out.println("1. Berserker's Fury : Rp.3210 : Increase energy 40%");
        System.out.println("2. Blade of Despair : Rp.4450 : Increase damage 30%");
        System.out.println("3. Healings Potions : Rp.2980 : Increase HP 45%");
        System.out.print("> ");
        int key = sc.nextInt();
        if (money > 0) {
            if (items[0] == null) {
                Arrays.fill(items, new Item("kosong", 0, "kosong"));
            }
            try {
                switch (key) {
                    case 1:
                        if (money >= 3210) {
                            items[index] = new Item("Berserker's Fury", 3210, "Increase energy 40%");
                            money -= items[index].getPrice();
                        } else {
                            index--;
                            System.out.println("\nNot enough money");
                        }
                        break;
                    case 2:
                        if (money >= 4450) {
                            items[index] = new Item("Blade of Despair", 4450, "Increase damage 30%");
                            money -= items[index].getPrice();
                        } else {
                            index--;
                            System.out.println("\nNot enough money");
                        }
                        break;
                    case 3:
                        if (money >= 2980) {
                            items[index] = new Item("Healings Potions", 2980, "Increase HP 45%");
                            money -= items[index].getPrice();
                        } else {
                            index--;
                            System.out.println("\nNot enough money");
                        }
                        break;
                    default:
                        break;
                }
            } catch (IndexOutOfBoundsException ioe) {
                System.out.print("\nCan only buy 3 items in one attack\n");
            }
            index++;
            return true;
        } else {
            index++;
            return false;
        }
    }

    // added some methods Setter and getter
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getDamage() {
        return damage;
    }

    public double getHp() {
        return hp;
    }

    public double getExp() {
        return exp;
    }

    public double getExLevelUp() {
        return expLevelUp;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // added some methods to handle levelUp and EnergyReduce
    public double energyReduce() {
        return ThreadLocalRandom.current().nextDouble(4, 5);
    }

    public void levelUp() {
        exp += damage;
        if (exp >= expLevelUp) {
            level++;
            System.out.print(" || " + name + " Level Up!");
            expLevelUp += ThreadLocalRandom.current().nextDouble(80, 82);
        }
        System.out.printf(" || XP : %.02f || XP To level Up : %.02f", exp, expLevelUp);
    }
}
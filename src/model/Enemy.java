package model;

import util.RpgUtil;


public class Enemy {

    private String name;
    private int level = 1;
    private int experience;
    private int hp;
    private int attack;
    private int defend;

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setNewHP(int hp) {
        this.hp = hp;
    }

    public Enemy(String name, int hp, int attack, int defend) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defend = defend;

    }

    public static Enemy randomEnemy() {
        int i;
        i = RpgUtil.randInt(1, 4);
        if (i == 1) {
            return new Enemy("            Minions", 50, 15, 10);
        } else if (i == 2) {
            return new Enemy("          Wild Animal", 40, 25, 10);
        } else if (i == 3) {
            return new Enemy("            Zombie", 100, 10, 10);
        } else {
            return new Enemy("             Giant", 200, 5, 5);
        }
      

    }

   public static Enemy spawnEnemy2()
   {
        return new Enemy("============Round-1============\n            Bandit",200,40,15);
         
   }
   public static Enemy spawnEnemy3()
   {
        return new Enemy("============Round-2============\n            Assasin",200,40,15);
         
   }
   public static Enemy spawnEnemy4()
   {
        return new Enemy("==========Final-Round==========\n            Bandit",250,50,15);
         
   }
   
   public static Enemy spawnEnemyHard(){
      int i;
        i = RpgUtil.randInt(1, 4);
        if (i == 1) {
            return new Enemy("         PIERRY RAJADI", 500, 70, 40);
        } else if (i == 2) {
            return new Enemy("            WILLIAM", 800, 40, 40);
        } else if (i == 3) {
            return new Enemy("         HENRY TANJAYA", 500, 75, 30);
        } else {
            return new Enemy("          Kenichi Xie", 600, 65, 45);
        }
      
   }
   public static Enemy Boss(){
       return new Enemy("            NARUTO",1000,100,80);
   }
   public static Enemy BossFail(){
       return new Enemy("",0,0,0);
   }
   

//        if (i == 1) {
//
//            hp = level * 50;
//            attack = level * 15;
//            defend = level * 10;
//            System.out.println("Minions");
//            System.out.println("WARNING!!!");
//        } else if (i == 2) {
//            hp = level * 40;
//            attack = level * 25;
//            defend = level * 10;
//            System.out.println("Wild Animal");
//            System.out.println("WARNING!!!");
//        } else if (i == 3) {
//            hp = level * 100;
//            attack = level * 10;
//            defend = level * 10;
//            System.out.println("Zombie");
//            System.out.println("WARNING!!!");
//        } else {
//            hp = level * 200;
//            attack = level * 5;
//            defend = level * 5;
//            System.out.println("Giant");
//            System.out.println("WARNING!!!");
//        }
//    }
}

//    public Enemy(){}
//    private Enemy(String name,int hp,int attack,int defend)
//    {
//        this.name=name;
//        this.hp=hp;
//        this.attack=attack;
//        this.defend=defend;
//    }


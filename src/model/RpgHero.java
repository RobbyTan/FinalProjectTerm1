package model;

import util.RpgUtil;
import model.Enemy;
import java.util.InputMismatchException;
import java.util.Scanner;
// gimana cara back ke menu
//gimana cara validasi

public class RpgHero {

    private String name;
    private int level = 1;
    private int experience = 0;
    private int hp = 100, maxHp = 100;
    private int attack = 20;
    private int defend = 10;
    private int money = 50;
//    private int level = 20;
//    private int experience = 0;
//    private int hp = 1000, maxHp = 1000;
//    private int attack = 5000;
//    private int defend = 60;
//    private int money = 5000;
    private int score = 0;
    private int days = 1;
    private int experienceUp = 100;
    private String skill;
    private int magicperk = 1;
    private int heroGetDamage, enemyGetDamage;
    private int enemyType;
    private int magic;
    private int mana = 0, maxMana = 0;
//    private int maxmana = 1000;
//    private int mana = 1000;
    private int charge;
    private int magicUp, magicUp1, magicUp2, magicUp3;
    private int magicAttackPlus = 0, magicDefendPlus = 2;
    private int heal = 0;
    private int ulang = 0;
    private int place;

    public boolean alive;
    Enemy musuh = null;

    public RpgHero() {
    }

    public RpgHero(String name2, int level, int experience, int hp, int maxHp, int attack, int defend,
            int money, int score, int days, int experienceUp, int mana, int maxMana,
            int magicAttackPlus, int magicDefendPlus, int heal) {
        this.name = name2;
        this.level = level;
        this.experience = experience;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defend = defend;
        this.money = money;
        this.score = score;
        this.days = days;
        this.experienceUp = experienceUp;
        this.mana = mana;
        this.maxMana = maxMana;
        this.magicAttackPlus = magicAttackPlus;
        this.magicDefendPlus = magicDefendPlus;
        this.heal = heal;

    }

    public void page1() {
        System.out.println(RpgUtil.ANSI_BG_BLUE + "                                                                       ");
        System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_WHITE + "                               UPH Medan                               ");
        System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_WHITE + "                                 16IS2                                 ");
        System.out.println(RpgUtil.ANSI_BG_BLUE + "                                                                       ");
        System.out.println("                                                                       ");
        System.out.println(RpgUtil.ANSI_BG_RED + "                                                                       ");
        System.out.println(RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_YELLOW + "                              NINJA WARRIOR                            ");
        System.out.println(RpgUtil.ANSI_BG_RED + "                                                                       ");
        System.out.println("                                                                       ");
        System.out.println(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + "                             1.START GAME                              ");
        System.out.println(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + "                             2.LOAD GAME                               ");
        System.out.println(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + "                             3. ABOUT                                  ");
        System.out.println(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + "                             4.EXIT GAME                               ");

    }

    public void spawnEnemy() {
        if (enemyType == 1) {
            System.out.println(RpgUtil.ANSI_GREEN + "You are Training in some wierd forest");
            System.out.println(RpgUtil.ANSI_GREEN + "And then suddenly you hear a sound ...");
            RpgUtil.delay(1500);
            musuh = Enemy.randomEnemy();

        } else if (enemyType == 2) {
            System.out.println(RpgUtil.ANSI_GREEN + "Your Sensei Give you a mission");
            System.out.println(RpgUtil.ANSI_GREEN + "Should you choose to accept it");
            System.out.println(RpgUtil.ANSI_GREEN + "Save his little daughter..");
            RpgUtil.delay(1500);
            musuh = Enemy.spawnEnemy2();
        } else if (enemyType == 3) {
            musuh = Enemy.spawnEnemy3();
        } else if (enemyType == 4) {
            musuh = Enemy.spawnEnemy4();
        } else if (enemyType == 5) {
            System.out.println(RpgUtil.ANSI_GREEN + "You go to Sinabung Mountain and you meet extraordinary people");
            System.out.println(RpgUtil.ANSI_GREEN + "Be careful they posses a strength that you have never seen before");
            System.out.println("");
            RpgUtil.delay(1500);
            musuh = Enemy.spawnEnemyHard();
        } else if (enemyType == 6) {
            System.out.println(RpgUtil.ANSI_GREEN + "Your Sensei ever told you once about the legendary ninja from KONOHA Village");
            System.out.println(RpgUtil.ANSI_GREEN + "Only the one who have an extraordinary strength can fight him");
            System.out.println(RpgUtil.ANSI_GREEN + "Are you the one?");
            RpgUtil.delay(1500);
            if (level >= 20) {
                System.out.println(RpgUtil.ANSI_BLUE + "Congratulation!!!");
                System.out.println(RpgUtil.ANSI_BLUE + "He choose to meet you");
                RpgUtil.delay(1500);
                System.out.println("");
                musuh = Enemy.Boss();
            } else {
                System.out.println(RpgUtil.ANSI_RED + "Sorry You Need To Be Level 20");
                System.out.println("");
                musuh = Enemy.BossFail();
                RpgUtil.delay(1200);
            }

        }
        System.out.println(RpgUtil.ANSI_RED + "          Warning!!!");
    }

    public void setEnemyType(int enemytype) {
        this.enemyType = enemytype;
    }

    public void setName(String name) {
        this.name = name;
//        this.level = level;
//        this.experience = experience;

    }

    public int getMana() {
        return mana;
    }

    public int getEnemyHp() {
        return musuh.getHp();
    }

    public int getHP() {
        return hp;
    }

    public int getNextDays() {
        return days = days + 1;
    }

    public int getScore() {
        return score;
    }

    public void newScore(int skor) {
        if (skor == 1) {
            score = score + 100;
        } else if (skor == 2) {
            score = score + 200;
        } else if (skor == 3) {
            score = score + 500;
        } else if (skor == 4) {
            score = score + 1000;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getExperience() {
        return experience;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }

    public int getMoney() {
        return money;
    }

    public int getDays() {
        return days;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMagicAttackPlus() {
        return magicAttackPlus;
    }

    public int getMagicDefendPlus() {
        return magicDefendPlus;
    }

    public int getHeal() {
        return heal;
    }

    public void newMoney(int uang) {
        if (uang == 1) {
            money = money + 50;
        } else if (uang == 2) {
            money = money + 100;
        } else if (uang == 3) {
            money = money + 800;
        }
    }

    public void newExp(int exp) {
        if (exp == 1) {
            experience = experience + 25;
        } else if (exp == 2) {
            experience = experience + 50;
        } else if (exp == 3) {
            experience = experience + 300;
        }
    }

    public int getUlang() {
        return ulang;
    }

    public void newExp4() {
        if (musuh.getHp() < 0) {
            experience = experience + 1000;
            money = money + 1500;
            System.out.println(RpgUtil.ANSI_YELLOW + "Congrats You Have Defeat The Legendary Ninja");
            System.out.println("");
        }
    }

    public int getExperienceup() {
        return experienceUp;
    }

    public void showStats() {
        if (level < 5) {
            System.out.println("Days  : " + days);
            System.out.println("Hero  : " + name);
            System.out.println("HP    : " + hp + "/" + maxHp);
            System.out.println("Level : " + level + " | Attack : " + attack + "| Defend : " + defend);
            System.out.println("Exp   : " + experience + "/" + experienceUp + " | Mana : " + mana);
            System.out.println("Money : " + money);
            System.out.println("Skill : ");
            System.out.println("You can unlock skill move in Level 5");
            System.out.println("");
        } else {
            System.out.println("Days : " + days);
            System.out.println("Hero : " + name);
            System.out.println("HP : " + hp + "/" + maxHp);
            System.out.println("Level : " + level + " | Attack : " + attack + "| Defend : " + defend);
            System.out.println("Exp : " + experience + "/" + experienceUp + " | Mana : " + mana + "/" + maxMana);
            System.out.println("Money : " + money);
            System.out.println("Skill : 3");
            System.out.println("");
        }

//      
//            days=days+1;
//            experience=experience+20;
        if (experience >= experienceUp) {
            level++;
            experience++;
            if (level > 5) {
                experienceUp = experienceUp + (level * 50);
            } else {
                experienceUp = experienceUp + (level * 100);
            }
            money = money + 100;
            if (level == 5) {
                mana = 100;
            }
            //this.money = (int) (money + (Math.random() * ((1000 - 500) + 1) + 500));
//            if (level >= 3) {
//                magicperk = magicperk + 1;
//
//            }
        }
    }

    public void rest() {
        System.out.println(RpgUtil.ANSI_GREEN + "Zzz.....");
        RpgUtil.delay(1000);
        System.out.println(RpgUtil.ANSI_GREEN + "Zzz.....");
        RpgUtil.delay(1000);
        System.out.println(RpgUtil.ANSI_GREEN + "Zzz.....");
        RpgUtil.delay(1000);
        this.hp = maxHp;
        this.mana = maxMana;
    }

    public void selectUpgrade() throws InterruptedException {
        int s;
        Scanner Nilai = new Scanner(System.in);
        System.out.println(RpgUtil.ANSI_YELLOW + "Level Up!!!");
        System.out.println(RpgUtil.ANSI_BLUE + "Which perk do you want to improve ?");
        System.out.println("1.HP");
        System.out.println("2.Attack");
        System.out.println("3.Defend");
        System.out.print("Choice :");
        s = Nilai.nextInt();
        if (s == 1) {
            this.maxHp = (level * 50);
            this.hp = maxHp;
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "HP UP!");
        } else if (s == 2) {
            this.attack = (level * 20);
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "Attack UP!");
        } else if (s == 3) {
            this.defend = (level * 20);
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "Defend UP!");
        }

    }

    public void selectUpgrade2() throws InterruptedException {
        int s;
        Scanner Nilai = new Scanner(System.in);
        System.out.println(RpgUtil.ANSI_YELLOW + "Level Up!!!");
        System.out.println(RpgUtil.ANSI_BLUE + "Which perk do you want to improve ?");
        System.out.println("1.HP");
        System.out.println("2.Attack");
        System.out.println("3.Defend");
        System.out.println("4.Mana");
        System.out.print("Choice :");
        s = Nilai.nextInt();
        if (s == 1) {
            this.maxHp = (level * 50);
            this.hp = maxHp;
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "HP UP!");
        } else if (s == 2) {
            this.attack = (level * 20);
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "Attack UP!");
        } else if (s == 3) {
            this.defend = (level * 20);
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "Defend UP!");
        } else {
            this.maxMana = maxMana + 20;
            this.mana = maxMana;
            RpgUtil.clearScreen();
            System.out.println(RpgUtil.ANSI_YELLOW + "Mana UP!");
        }
    }

    public void attack() {
        if (attack - musuh.getDefend() <= 0) {
            enemyGetDamage = 1;
        } else {
            enemyGetDamage = attack - musuh.getDefend();
        }
        musuh.setNewHP(musuh.getHp() - enemyGetDamage);
//        System.out.println("=====================================");
//        System.out.println("  X    XXX   XXX    X     XXX   X X        ");
//        System.out.println(" XXX    X     X    XXX    X     XX          ");
//        System.out.println("X   X   X     X   X   X   XXX   X X        ");
//        System.out.println("=====================================");
        System.out.println(RpgUtil.ANSI_BLUE + "Hero attack : " + attack);
        System.out.println(RpgUtil.ANSI_BLUE + "Enemy take : " + enemyGetDamage);
        System.out.println("");
    }

    public void enemyattack() {
        if (musuh.getAttack() - defend <= 0) {
            heroGetDamage = 1;
        } else {
            heroGetDamage = musuh.getAttack() - defend;
        }
        hp = hp - heroGetDamage;
        System.out.println(RpgUtil.ANSI_RED + "Ouch!");
        System.out.println(RpgUtil.ANSI_BLUE + "Enemy attack : " + musuh.getAttack());
        System.out.println(RpgUtil.ANSI_BLUE + "Hero take : " + heroGetDamage);
        System.out.println("");
    }

    public void showHeroStats() {
        if (hp <= 0) {
            System.out.println(RpgUtil.ANSI_RED + "Hero Died!");
        } else {
            System.out.println("---------------------------");
            System.out.println(RpgUtil.ANSI_BLUE + "        Hero stats : ");
            System.out.println(RpgUtil.ANSI_BLUE + "         HP : " + hp);
            System.out.println(RpgUtil.ANSI_BLUE + "     Attack : " + attack);
            System.out.println(RpgUtil.ANSI_BLUE + "     Defend : " + defend);
            System.out.println(RpgUtil.ANSI_BLUE + "       Mana :" + mana);
            System.out.println("---------------------------");
        }
    }

    public void showEnemyStats() {
        if (musuh.getHp() <= 0) {
            System.out.println(RpgUtil.ANSI_RED + "Enemy Died!");
            System.out.println(RpgUtil.ANSI_YELLOW + "YOU ROCK IT BABEH!");
            RpgUtil.delay(1200);
        } else {
            System.out.println("---------------------------");
            System.out.println(RpgUtil.ANSI_BLUE + "       Enemy stats :");
            System.out.println(RpgUtil.ANSI_BLUE + "          HP : " + musuh.getHp());
            System.out.println(RpgUtil.ANSI_BLUE + "      Attack : " + musuh.getAttack());
            System.out.println(RpgUtil.ANSI_BLUE + "      Defend : " + musuh.getDefend());
            System.out.println("---------------------------");
        }
    }

    public void getPlace() {
        System.out.println(RpgUtil.ANSI_BLUE + "Menu :                                                     ");
        System.out.println(RpgUtil.ANSI_BLUE + "1.Forest (easy) Level 1+                                   ");
        System.out.println(RpgUtil.ANSI_BLUE + "2.Save The Little Princes (Medium) Level 5+                ");
        System.out.println(RpgUtil.ANSI_BLUE + "3.Unpredictable Expedition(Hard) Level 10+                 ");
        System.out.println(RpgUtil.ANSI_BLUE + "4.Boss Fight(Insane) Level 20+                             ");
        System.out.println(RpgUtil.ANSI_BLUE + "5.Rest                                                     ");
        System.out.println(RpgUtil.ANSI_BLUE + "6.Shop                                                     ");
        System.out.println(RpgUtil.ANSI_BLUE + "7.Save Game                                                ");
        System.out.println(RpgUtil.ANSI_BLUE + "8.Exit                                                     ");
        System.out.print(RpgUtil.ANSI_GREEN + "Select :");

    }

    public void run() {
        alive = false;
        System.out.println("You ran from enemy you lost EXP : " + (experience + 20));
    }

    public void setAct() {
        System.out.println(musuh.getName());
        System.out.println(RpgUtil.ANSI_RED + "           BATTLE!");
        System.out.println(RpgUtil.ANSI_BLUE + "1.Attack");
        System.out.println(RpgUtil.ANSI_BLUE + "2.Defend (Increase defense by 2 times)");
        System.out.println(RpgUtil.ANSI_BLUE + "3.Magic (Level 5+)");
        System.out.println(RpgUtil.ANSI_BLUE + "4.Run");
        System.out.print("Choice : ");
    }

    public void heroDefend() {
        if (musuh.getAttack() - (defend * 2) <= 0) {
            heroGetDamage = 1;
        } else {
            heroGetDamage = musuh.getAttack() - defend * 2;
        }
        hp = hp - heroGetDamage;
        System.out.println(RpgUtil.ANSI_RED + "Ouch!");
        System.out.println(RpgUtil.ANSI_BLUE + "Enemy attack : " + (musuh.getAttack()));
        System.out.println(RpgUtil.ANSI_BLUE + "Hero take : " + heroGetDamage);
        System.out.println("");
    }

    public void selectMagic() {
        System.out.println("1.Fireball");
        System.out.println("2.Lightning Soul");
        System.out.println("3.Charge");
        System.out.println("4.Healing");
        System.out.print(RpgUtil.ANSI_GREEN + "Choice :");
    }

    public void errorMagic() {
        System.out.println(RpgUtil.ANSI_RED + "YOU NEED TO BE AT LEAST LEVEL 5 TO PLAY THIS!!!");
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void chargeMana(int charge) {

        this.charge = charge;
        if (charge == 1) {
            mana = mana + 50;
            if (mana > maxMana) {
                mana = maxMana;
            }
        } else {
            ulang = 2;
        }
    }

    public void magicAttack() {
        if (mana < 30) {
            System.out.println(RpgUtil.ANSI_RED + "Not Enough Mana!");
            if (mana < 0) {
                mana = 0;
            }
        } else if (mana > 30) {
            if (magic == 1) {
                System.out.println(RpgUtil.ANSI_RED + "Fireball!!!");
                mana = (mana - 30) - magicAttackPlus;
                if (attack - musuh.getDefend() <= 0) {
                    enemyGetDamage = 1;
                } else {
                    enemyGetDamage = (attack + (30 + magicAttackPlus) - musuh.getDefend());
                }
                musuh.setNewHP(musuh.getHp() - enemyGetDamage);
//        System.out.println("=====================================");
//        System.out.println("  X    XXX   XXX    X     XXX   X X        ");
//        System.out.println(" XXX    X     X    XXX    X     XX          ");
//        System.out.println("X   X   X     X   X   X   XXX   X X        ");
//        System.out.println("=====================================");
                System.out.println(RpgUtil.ANSI_BLUE + "Hero attack : " + (attack + (30 + magicAttackPlus)));
                System.out.println(RpgUtil.ANSI_BLUE + "Enemy take : " + enemyGetDamage);
                System.out.println("");
            } else if (magic == 2) {
                System.out.println(RpgUtil.ANSI_BLUE + "Call The Lighting Soul!!!");
                System.out.println(RpgUtil.ANSI_BLUE + "Now you got Lightning Barrier");
                mana = mana - 30;
                if (musuh.getAttack() - (defend * magicDefendPlus) <= 0) {
                    heroGetDamage = 1;
                } else {
                    heroGetDamage = musuh.getAttack() - (defend * magicDefendPlus);
                }
                hp = hp - heroGetDamage;
                System.out.println(RpgUtil.ANSI_RED + "Ouch!");
                System.out.println(RpgUtil.ANSI_BLUE + "Enemy attack : " + musuh.getAttack());
                System.out.println(RpgUtil.ANSI_BLUE + "Hero take : " + heroGetDamage);
                System.out.println("");
            } else if (magic == 3) {
                System.out.println("Charge");
                mana = mana + 50;

            } else if (magic == 4) {
                System.out.println("Healing");
                hp = hp + (30 + heal);
                mana = mana - (30 + heal);
            }
        }
    }

    public void shop() {
        System.out.println("");
        System.out.println(RpgUtil.ANSI_YELLOW + "SPEND YOUR MONEY HERE!");
        System.out.println("");
        System.out.println(RpgUtil.ANSI_BLUE + RpgUtil.ANSI_BG_BLACK + "1.Magic Upgrade(level 5+)");
        System.out.println(RpgUtil.ANSI_BLUE + RpgUtil.ANSI_BG_BLACK + "2.Back to Menu");
        System.out.print("Choice :");
    }

    public void setMagicUp1(int magicup1) throws InterruptedException {
        this.magicUp1 = magicup1;
        if (magicup1 == 0) {
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();

        } else if (magicup1 == 1) {
            if (money < 1000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 1000;
                magicAttackPlus = 10;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }

        } else if (magicup1 == 2) {
            if (money < 2000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 2000;
                magicAttackPlus = 20;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }

        } else if (money < 3000) {
            System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        } else {
            money = money - 3000;
            magicAttackPlus = 30;
            System.out.println("Thanks for buying!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        }
    }

    public void setMagicUp2(int magicup2) throws InterruptedException {
        this.magicUp2 = magicup2;
        if (magicup2 == 0) {
            ulang = 1;
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        } else if (magicup2 == 1) {
            if (money < 1000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 1000;
                magicDefendPlus = 3;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }
        } else if (magicup2 == 2) {
            if (money < 2000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 2000;
                magicDefendPlus = 4;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }
        } else if (money < 3000) {
            System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        } else {
            money = money - 3000;
            magicDefendPlus = 5;
            System.out.println("Thanks for buying!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        }
    }

    public void setMagicUp3(int magicup3) throws InterruptedException {
        this.magicUp3 = magicup3;
        if (magicup3 == 0) {
            ulang = 1;
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();

        } else if (magicup3 == 1) {
            if (money < 1000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 1000;
                heal = 10;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }
        } else if (magicup3 == 2) {
            if (money < 2000) {
                System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            } else {
                money = money - 2000;
                heal = 20;
                System.out.println("Thanks for buying!");
                RpgUtil.delay(1000);
                RpgUtil.clearScreen();
            }
        } else if (money < 3000) {
            System.out.println(RpgUtil.ANSI_RED + "YOU DIDN'T HAVE ENOUGH MONEY!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        } else {
            money = money - 3000;
            heal = 30;
            System.out.println("Thanks for buying!");
            RpgUtil.delay(1000);
            RpgUtil.clearScreen();
        }
    }

    public void selectMagicUp(int magicup) {
        this.magicUp = magicup;
    }

    public void magicUprgrade1() {

        if (magicUp == 1) {
            System.out.println(RpgUtil.ANSI_RED + "1.Fireball");
            System.out.println(RpgUtil.ANSI_YELLOW + "1. 1,000 = Damage+10");
            System.out.println(RpgUtil.ANSI_YELLOW + "2. 2,000 = Damage+20");
            System.out.println(RpgUtil.ANSI_YELLOW + "3. 3,000 = Damage+30(Ultimate)");
            System.out.print(RpgUtil.ANSI_GREEN + "Buy ? (0.Exit)");
        } else if (magicUp == 2) {
            System.out.println(RpgUtil.ANSI_BLUE + "2.Lighting Barrier");
            System.out.println(RpgUtil.ANSI_YELLOW + "1. 1,000 = Defend*3");
            System.out.println(RpgUtil.ANSI_YELLOW + "2. 2,000 = Defend*4");
            System.out.println(RpgUtil.ANSI_YELLOW + "3. 3,000 = Defend*5(Ultimate)");
            System.out.print(RpgUtil.ANSI_GREEN + "Buy ? (0.Exit)");
        } else if (magicUp == 3) {
            System.out.println(RpgUtil.ANSI_CYAN + "3.Healing");
            System.out.println(RpgUtil.ANSI_YELLOW + "1. 1,000 = Heal+10");
            System.out.println(RpgUtil.ANSI_YELLOW + "2. 2,000 = Heal+20");
            System.out.println(RpgUtil.ANSI_YELLOW + "3. 3,000 = Heal+30(Ultimate)");
            System.out.print(RpgUtil.ANSI_GREEN + "Buy ? (0.Exit)");
        }
    }

    public void magicKind() {
        if (level < 5) {
            System.out.println(RpgUtil.ANSI_RED + "You must at least level 5 to use magic!");
            System.out.println(RpgUtil.ANSI_RED + "Type 1 to back to menu!");
        } else if (level >= 5) {
            System.out.println(RpgUtil.ANSI_RED + "1.Fireball");
            System.out.println(RpgUtil.ANSI_BLUE + " 2.Lightning Barrier");
            System.out.println(RpgUtil.ANSI_CYAN + " 3.Healing");
            System.out.println(RpgUtil.ANSI_PURPLE + " 4.Back to Menu");
            System.out.print("Select : ");
        }
    }

    public void died() {
        System.out.println(RpgUtil.ANSI_RED + "                           YOU DIED!!!");
        System.out.println(RpgUtil.ANSI_BLUE + "                             " + name);
        System.out.println(RpgUtil.ANSI_BLUE + "                          Level : " + level);
        System.out.println(RpgUtil.ANSI_GREEN + "                     Experience : " + experience);
        System.out.println(RpgUtil.ANSI_GREEN + "                          Money : " + money);
        System.out.println(RpgUtil.ANSI_GREEN + "                          Score :" + score);
    }

    public void quoteOfTheDay() {
        int i;
        i = RpgUtil.randInt(1, 10);
        System.out.println("");
        System.out.println("Quote of the day =) ");
        System.out.println("");
        if (i == 1) {
            System.out.println(RpgUtil.ANSI_BLUE + "\"Every great dream begins with a dreamer. "
                    + RpgUtil.ANSI_BLUE + "\n Always remember, you have within you the strength, the patience, "
                    + RpgUtil.ANSI_BLUE + "\n and the passion to reach for the stars to change the world.\"");
        } else if (i == 2) {
            System.out.println(RpgUtil.ANSI_RED + "\"You take your life in your own hands, and what happens? A terrible thing, no one to blame.\"");
        } else if (i == 3) {
            System.out.println(RpgUtil.ANSI_GREEN + "\"Champions keep playing until they get it right.\"");
        } else if (i == 4) {
            System.out.println(RpgUtil.ANSI_BLUE + "\"Both my mother and I were determined that we weren’t going to stay on welfare. "
                    + RpgUtil.ANSI_BLUE + "\n We always worked toward doing better, toward having a better life."
                    + RpgUtil.ANSI_BLUE + "\n We never had any doubts that we would.\"");
        } else if (i == 5) {
            System.out.println(RpgUtil.ANSI_RED + "\"Most people give up just when they are about to achieve success. "
                    + RpgUtil.ANSI_RED + "\n They quit on the one-yard line. They give up at the last minute of the game, "
                    + RpgUtil.ANSI_RED + "\n one foot from a winning touchdown.\"");
        } else if (i == 6) {
            System.out.println(RpgUtil.ANSI_BLUE + "\"The one who falls and gets up is so much stronger than the one who never fell.\"");
        } else if (i == 7) {
            System.out.println(RpgUtil.ANSI_CYAN + "\"Data beats emotions\"");
        } else if (i == 8) {
            System.out.println(RpgUtil.ANSI_GREEN + "\"I never took a day off in my 20s. Not one.\"");
        } else if (i == 9) {
            System.out.println(RpgUtil.ANSI_CYAN + "\"Everything should be made as simple as possible, but not simpler.\"");
        } else if (i == 10) {
            System.out.println(RpgUtil.ANSI_RED + "\"Fall seven times and stand up eight.\"");
        }
    }

    public void allAttack() throws InterruptedException {
        Scanner Nilai = new Scanner(System.in);
        Scanner Huruf = new Scanner(System.in);
        int s = 0;
        int act = 0, magic = 0, charge = 10;
//            if (place==2) {
//                for (int i = 2; i <= 4; i++) {
//                    setEnemyType(i);
//                    spawnEnemy();
//                }
//            }
//      
        do {
            do {
                try {
                    Scanner Nilai1 = new Scanner(System.in);
                    setAct();
                    act = Nilai1.nextInt();
                    if (act < 1 || act > 4) {
                        throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 1-4!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            } while (act != 1 && act != 2 && act != 3 && act != 4);

            if (act == 1) {
                showHeroStats();
                attack();
                showEnemyStats();
                if (getEnemyHp() > 0) {
                    enemyattack();
                }
            } else if (act == 2) {
                showHeroStats();
                showEnemyStats();
                heroDefend();

            } else if (act == 3) {
                if (level < 5) {
                    errorMagic();
                    ulang = 2;
                } else {
                    selectMagic();
                    magic = Nilai.nextInt();
                    setMagic(magic);
                    magicAttack();
                    if (getMana() <= 30) {          
                        System.out.println(RpgUtil.ANSI_RED+"CHARGE YOUR MANA!");
//                        do {
//                            try {
//                                Scanner Nilai1 = new Scanner(System.in);
//                                System.out.println(RpgUtil.ANSI_GREEN + "Charge?(1.Yes | 0.No)");
//                                charge = Nilai1.nextInt();
//                                if (charge > 1 || charge < 0) {
//                                    throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 0 or 1!");
//                                }
//                            } catch (InputMismatchException e) {
//                                System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
//                            } catch (IllegalArgumentException e) {
//                                System.out.println(e.getLocalizedMessage());
//                            }
//                        } while (charge != 0 && charge != 1);
//
//                        chargeMana(charge);
                    }
                }
                showHeroStats();
                if (getEnemyHp() > 0 && magic != 2) {
                    enemyattack();
                }
                showEnemyStats();

            } else if (act == 4) {
                ulang = 1;
            }
        } while (ulang == 2 && hp > 0 && getEnemyHp() > 0);
    }
}

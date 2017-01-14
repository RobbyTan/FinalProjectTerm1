
import util.RpgUtil;
import model.RpgHero;
import java.util.InputMismatchException;
import java.util.Scanner;
import util.FileUtil;

public class RpgGame {
//buat point ke 4
//GAMAU BACK DI LEVEL SBLM 5

    public static void main(String[] args) throws InterruptedException {

        Scanner Nilai = new Scanner(System.in);
        Scanner Huruf = new Scanner(System.in);
        FileUtil futil = new FileUtil();
        int s = 0, ulang = 0, pilihan = 0;
        int place = 0, act = 0, magic, charge;
        String name = "";

        RpgHero hero = new RpgHero();
        do {
            RpgUtil.clearScreen();
            hero.page1();
            do {
                try {
                    System.out.printf(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + "                               Select : ");
                    Scanner Nilai1 = new Scanner(System.in);
                    s = Nilai1.nextInt();
                    if (s < 1 || s > 4) {
                        throw new IllegalArgumentException(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + RpgUtil.ANSI_RED + "                              INPUT 1-4!                              ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(RpgUtil.ANSI_BLACK + RpgUtil.ANSI_RED + "                        Must entry with numeric                       ");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            } while (s != 1 && s != 2 && s != 3 && s != 4);
            RpgUtil.clearScreen();
            if (s == 1) {

                System.out.println(RpgUtil.ANSI_BLUE + "           Introduction          ");
                System.out.println(RpgUtil.ANSI_BLUE + "Try not to be killed in this game");
                System.out.println("                                                                         ");
                System.out.print("Name : ");
                name = Huruf.nextLine();
                ulang = 0;
                RpgUtil.clearScreen();
            } else if (s == 2) {
                String load = futil.openReadFile("savegame.txt");
                System.out.println(load);
                int level = 0, experience = 0, hp = 0, maxHp = 0, attack = 0, defend = 0,
                        money = 0, score = 0, days = 0, experienceUp = 0, mana = 0, maxMana = 0,
                        magicAttackPlus = 0, magicDefendPlus = 0, heal = 0;
                while (futil.getReadScanner().hasNext()) {
                    String[] readLine = futil.getReadScanner().next().split(",");

                    name = readLine[0];
                    level = Integer.parseInt(readLine[1]);
                    experience = Integer.parseInt(readLine[2]);
                    hp = Integer.parseInt(readLine[3]);
                    maxHp = Integer.parseInt(readLine[4]);
                    attack = Integer.parseInt(readLine[5]);
                    defend = Integer.parseInt(readLine[6]);
                    money = Integer.parseInt(readLine[7]);
                    score = Integer.parseInt(readLine[8]);
                    days = Integer.parseInt(readLine[9]);
                    experienceUp = Integer.parseInt(readLine[10]);
                    mana = Integer.parseInt(readLine[11]);
                    maxMana = Integer.parseInt(readLine[12]);
                    magicAttackPlus = Integer.parseInt(readLine[13]);
                    magicDefendPlus = Integer.parseInt(readLine[14]);
                    heal = Integer.parseInt(readLine[15]);
                }
                String s3 = futil.closeReadFile();
                System.out.println(s3);
                hero = new RpgHero(name, level, experience, hp, maxHp, attack, defend,
                        money, score, days, experienceUp, mana, maxMana,
                        magicAttackPlus, magicDefendPlus, heal);
                ulang = 0;
            } else if (s == 3) {
                System.out.println(RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_WHITE + "===============MEET THE TEAM=================");
                System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_YELLOW + "            -Lavinia(00000022817)            ");
                System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_YELLOW + "            -Robby  (00000022809)            ");
                System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_WHITE + "            Type 1 to BACK TO MENU           ");
                System.out.println(RpgUtil.ANSI_BG_BLUE + RpgUtil.ANSI_WHITE + "               Type 2 to EXIT                ");
                do {
                    try {
                        System.out.print("                  Choose:");
                        Scanner Nilai1 = new Scanner(System.in);
                        pilihan = Nilai1.nextInt();
                        if (pilihan < 1 || pilihan > 2) {
                            throw new IllegalArgumentException(RpgUtil.ANSI_BG_WHITE + RpgUtil.ANSI_BLACK + RpgUtil.ANSI_RED + "                INPUT 1-2!                  ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(RpgUtil.ANSI_BLACK + RpgUtil.ANSI_RED + "           Must entry with numeric          ");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } while (pilihan != 1 && pilihan != 2);

                if (pilihan == 1) {
                    ulang = 1;
                } else {
                    RpgUtil.clearScreen();
                    System.out.println(RpgUtil.ANSI_RED + "THANKYOU FOR SEEING ABOUT US!");
                    System.out.println(RpgUtil.ANSI_RED + "   HOPE TO SEE YOU SOON!");
                    hero.quoteOfTheDay();
                    RpgUtil.delay(2000);
                    System.exit(0);
                }
            } else if (s == 4) {
                System.out.println(RpgUtil.ANSI_BLUE + "THANK YOU FOR PLAYING MY GAME");
                hero.quoteOfTheDay();
                RpgUtil.delay(2000);
                System.exit(0);
            }
        } while (ulang == 1);
        do {
            hero.setName(name);
            hero.showStats();
            do {
                try {

                    Scanner Nilai1 = new Scanner(System.in);
                    hero.getPlace();
                    place = Nilai1.nextInt();
                    if (place < 1 || place > 8) {
                        throw new IllegalArgumentException(RpgUtil.ANSI_RED + RpgUtil.ANSI_BG_YELLOW + "INPUT 1-8!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(RpgUtil.ANSI_RED + RpgUtil.ANSI_BG_YELLOW + "Must entry with numeric");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            } while (place != 1 && place != 2 && place != 3 && place != 4 && place != 5 && place != 6 && place != 7 && place != 8);
            if (place == 1) {
                RpgUtil.clearScreen();
                hero.setEnemyType(1);
                hero.spawnEnemy();
                do {
                    hero.allAttack();
                } while (hero.getHP() > 0 && hero.getEnemyHp() > 0 && hero.getUlang() == 0);
                RpgUtil.clearScreen();
                if (hero.getUlang() == 0 || hero.getUlang() == 2) {
                    if (hero.getHP() > 0) {
                        hero.newExp(1);
                        hero.newMoney(1);
                        hero.newScore(1);
                    }

                }

            } else if (place == 2) {
                RpgUtil.clearScreen();
                for (int i = 2; i <= 4; i++) {
                    hero.setEnemyType(i);
                    hero.spawnEnemy();
                    do {
                        hero.allAttack();
                        if (hero.getHP() < 0) {
                            RpgUtil.delay(1000);
                            RpgUtil.clearScreen();
                            hero.died();
                            System.exit(0);
                        }
                    } while (hero.getHP() > 0 && hero.getEnemyHp() > 0 && hero.getUlang() == 0);
                    RpgUtil.clearScreen();
//                    if (hero.getUlang() == 0 || hero.getUlang() == 2 && hero.getHP() > 0) {
                    if (hero.getUlang() == 0 || hero.getUlang() == 2) {
                        if (hero.getHP() > 0) {
                            hero.newExp(2);
                            hero.newMoney(2);
                            hero.newScore(2);
                        }
                    }
                }
            } else if (place == 3) {
                RpgUtil.clearScreen();
                hero.setEnemyType(5);
                hero.spawnEnemy();
                do {
                    hero.allAttack();
                } while (hero.getHP() > 0 && hero.getEnemyHp() > 0 && hero.getUlang() == 0);
                RpgUtil.clearScreen();
                if (hero.getUlang() == 0 || hero.getUlang() == 2) {
                    if (hero.getHP() > 0) {
                        hero.newExp(3);
                        hero.newMoney(3);
                        hero.newScore(3);
                    }
                }
            } else if (place == 4) {
                RpgUtil.clearScreen();
                hero.setEnemyType(6);
                hero.spawnEnemy();
                if (hero.getLevel() >= 20) {
                    do {
                        hero.allAttack();
                    } while (hero.getHP() > 0 && hero.getEnemyHp() > 0 && hero.getUlang() == 0);
                }
                RpgUtil.clearScreen();
                if (hero.getUlang() == 0 || hero.getUlang() == 2) {
                    if (hero.getHP() > 0) {
                        hero.newExp4();
                        hero.newScore(4);
                    }
                }
            } else if (place == 5) {
                RpgUtil.clearScreen();
                hero.rest();
                hero.showStats();
            } else if (place == 6) {
                RpgUtil.clearScreen();
                do {
                    int magicup = 0, magicup1 = 0, magicup2 = 0, magicup3 = 0;
                    hero.shop();
                    int shop = Nilai.nextInt();
                    if (shop == 1) {
                        do {
                            try {
                                Scanner Nilai1 = new Scanner(System.in);
                                hero.magicKind();
                                magicup = Nilai1.nextInt();
                                if (magicup < 1 || magicup > 4) {
                                    throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 1-4!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getLocalizedMessage());
                            }
                        } while (magicup != 1 && magicup != 2 && magicup != 3 && magicup != 4);
                        if (hero.getLevel() < 5) {
                            ulang = 2;
                        } else {
                            hero.selectMagicUp(magicup);
                            if (magicup == 1) {
                                do {
                                    do {
                                        try {
                                            Scanner Nilai1 = new Scanner(System.in);
                                            hero.magicUprgrade1();
                                            magicup1 = Nilai.nextInt();
                                            if (magicup1 < 0 || magicup1 > 3) {
                                                throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 0-3!");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getLocalizedMessage());
                                        }
                                    } while (magicup1 != 0 && magicup1 != 1 && magicup1 != 2 && magicup1 != 3);
                                    if (magicup1 == 0) {
                                        ulang = 1;
                                        RpgUtil.delay(1000);
                                        RpgUtil.clearScreen();
                                    } else {
                                        hero.setMagicUp1(magicup1);
                                        ulang = 1;
                                    }
                                } while (ulang == 0);
                            } else if (magicup == 2) {
                                do {
                                    do {
                                        try {
                                            Scanner Nilai1 = new Scanner(System.in);
                                            hero.magicUprgrade1();
                                            magicup2 = Nilai.nextInt();
                                            if (magicup2 < 0 || magicup2 > 3) {
                                                throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 0-3!");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getLocalizedMessage());
                                        }
                                    } while (magicup2 != 0 && magicup2 != 1 && magicup2 != 2 && magicup2 != 3);
                                    if (magicup2 == 0) {
                                        ulang = 1;
                                        RpgUtil.delay(1000);
                                        RpgUtil.clearScreen();
                                    } else {
                                        hero.setMagicUp2(magicup2);
                                        ulang = 1;
                                    }
                                } while (ulang == 0);
                            } else if (magicup == 3) {
                                do {
                                    do {
                                        try {
                                            Scanner Nilai1 = new Scanner(System.in);
                                            hero.magicUprgrade1();
                                            magicup3 = Nilai.nextInt();
                                            if (magicup3 < 0 || magicup3 > 3) {
                                                throw new IllegalArgumentException(RpgUtil.ANSI_RED + "INPUT 0-3!");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println(RpgUtil.ANSI_RED + "Must entry with numeric");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getLocalizedMessage());
                                        }
                                    } while (magicup3 != 0 && magicup3 != 1 && magicup3 != 2 && magicup3 != 3);
                                    if (magicup3 == 0) {
                                        ulang = 1;
                                        RpgUtil.delay(1000);
                                        RpgUtil.clearScreen();
                                    } else {
                                        hero.setMagicUp3(magicup3);
                                        ulang = 1;
                                    }
                                } while (ulang == 0 && hero.getUlang() == 0);
                            }
                        }
                    } else if (shop == 2) {
                        ulang = 1;
                        RpgUtil.delay(1000);
                        RpgUtil.clearScreen();
                    }
                } while (ulang == 0);
            } else if (place == 7) {
                RpgUtil.clearScreen();
                String s1 = futil.openWriteFile("savegame.txt");
                System.out.println(s1);
                String txtformat = "%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d";

                String s3 = futil.addWriteRecord(txtformat, hero.getName(), hero.getLevel(), hero.getExperience(), hero.getHP(),
                        hero.getMaxHp(), hero.getAttack(), hero.getDefend(), hero.getMoney(), hero.getScore(), hero.getDays(),
                        hero.getExperienceup(), hero.getMana(), hero.getMaxMana(), hero.getMagicAttackPlus(), hero.getMagicDefendPlus(), hero.getHeal());
                System.out.println(s3);

                String s4 = futil.closeWriteFile();
                System.out.println(s4);
            } else {
                RpgUtil.clearScreen();
                System.out.println(RpgUtil.ANSI_BLUE + "THANKYOU FOR PLAYING!");
                hero.quoteOfTheDay();
                RpgUtil.delay(2000);
                System.exit(0);
            }
            if (hero.getExperience() >= hero.getExperienceup() && hero.getHP() > 0) {
                hero.showStats();
                if (hero.getLevel() >= 5) {
                    hero.selectUpgrade2();
                } else {
                    hero.selectUpgrade();
                }
            }
            hero.getNextDays();

        } while (hero.getHP() > 0);
        RpgUtil.clearScreen();

        hero.died();

    }

}

package FinalExamOldExams;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroHpMpMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {

            String heroData = scanner.nextLine();
            String [] heroDataTypes = heroData.split(" ");
            String heroName = heroDataTypes[0];
            int heroHP = Integer.parseInt(heroDataTypes[1]);
            int heroMP = Integer.parseInt(heroDataTypes[2]);

            heroHpMpMap.putIfAbsent(heroName, new ArrayList<>());
            heroHpMpMap.get(heroName).add(heroHP);
            heroHpMpMap.get(heroName).add(heroMP);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String [] commandParts = command.split(" - ");
            String commandType = commandParts[0];
            String heroName = commandParts[1];

            switch (commandType){

                case"CastSpell":
                    int neededMP = Integer.parseInt(commandParts[2]);
                    String spellName = commandParts[3];
                    int currentMP = heroHpMpMap.get(heroName).get(1);
                    if(currentMP >= neededMP){
                        heroHpMpMap.get(heroName).set(1, currentMP - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMP - neededMP);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;

                case"TakeDamage":
                    int damage = Integer.parseInt(commandParts[2]);
                    String attacker = commandParts[3];

                    int currentHP = heroHpMpMap.get(heroName).get(0);
                    if(currentHP - damage > 0){
                        heroHpMpMap.get(heroName).set(0, currentHP - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP - damage);
                    }else{
                        heroHpMpMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;

                case"Recharge":
                    int rechargeMP = Integer.parseInt(commandParts[2]);
                    int currentManaPower = heroHpMpMap.get(heroName).get(1);
                    int totalNewMP = 0;
                    if(currentManaPower + rechargeMP > 200){
                        totalNewMP = 200;
                        System.out.printf("%s recharged for %d MP!%n", heroName, rechargeMP - (rechargeMP - (200 - currentManaPower)));
                    }else{
                        totalNewMP = currentManaPower + rechargeMP;
                        System.out.printf("%s recharged for %d MP!%n", heroName, rechargeMP);
                    }
                    heroHpMpMap.get(heroName).set(1, totalNewMP);
                    break;

                case"Heal":
                    int healedHP = Integer.parseInt(commandParts[2]);
                    int currentHealth = heroHpMpMap.get(heroName).get(0);
                    int totalNewHp = 0;

                    if(currentHealth + healedHP > 100){
                        totalNewHp = 100;
                        System.out.printf("%s healed for %s HP!%n", heroName, healedHP - (healedHP - (100 - currentHealth)));
                    }else{
                        totalNewHp = currentHealth + healedHP;
                        System.out.printf("%s healed for %s HP!%n", heroName, healedHP);
                    }
                    heroHpMpMap.get(heroName).set(0, totalNewHp);
                    break;

            }

            command = scanner.nextLine();
        }
        heroHpMpMap.entrySet().forEach(entry -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}

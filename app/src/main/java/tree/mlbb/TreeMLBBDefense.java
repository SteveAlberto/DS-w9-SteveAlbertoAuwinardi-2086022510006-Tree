package tree.mlbb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMLBBDefense {

    static class ItemNode {
        String name;
        String note;
        List<ItemNode> children;

        ItemNode(String name, String note) {
            this.name = name;
            this.note = note;
            this.children = new ArrayList<>();
        }

        void addChild(ItemNode child) {
            children.add(child);
        }
    }

    static void printTree(ItemNode node, int level) {
        if (node == null) return;
        String indent = "  ".repeat(level);
        System.out.println(indent + "+ " + node.name + " (" + node.note + ")");
        for (ItemNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;

        path.add(node.name);

        if (node.children.isEmpty()) {
            System.out.println(String.join(" -> ", path));
        } else {
            for (ItemNode child : node.children) {
                printAllBuildPaths(child, path);
            }
        }
        path.remove(path.size() - 1);
    }

    static int countNodes(ItemNode node) {
        if (node == null) return 0;
        
        int total = 1; 
        for (ItemNode child : node.children) {
            total += countNodes(child); 
        }
        return total;
    }

    static int countLeaves(ItemNode node) {
        if (node == null) return 0;
        
        if (node.children.isEmpty()) return 1; 
        
        int total = 0;
        for (ItemNode child : node.children) {
            total += countLeaves(child);
        }
        return total;
    }

    static int height(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1; 
        
        int maxChildHeight = 0;
        for (ItemNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    static boolean findPath(ItemNode node, String target, List<String> path) {
        if (node == null) return false;

        path.add(node.name);

        if (node.name.equalsIgnoreCase(target)) {
            return true;
        }

        for (ItemNode child : node.children) {
            if (findPath(child, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    // TASK 2
    static int countItemOccurrences(ItemNode node, String targetName) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.name.equalsIgnoreCase(targetName)) {
            count = 1;
        }
        
        for (ItemNode child : node.children) {
            count += countItemOccurrences(child, targetName);
        }
        return count;
    }

    // TASK 3
    static void printPathsEndingWith(ItemNode node, List<String> path, String targetLeaf) {
        if (node == null) return;
        path.add(node.name);

        if (node.children.isEmpty()) {
            if (node.name.equalsIgnoreCase(targetLeaf)) {
                System.out.println(String.join(" -> ", path));
            }
        } else {
            for (ItemNode child : node.children) {
                printPathsEndingWith(child, path, targetLeaf);
            }
        }
        path.remove(path.size() - 1); 
    }

    public static void main(String[] args) {
        ItemNode vitalityCrystal = new ItemNode("Vitality Crystal", "HP");
        ItemNode leatherJerkin = new ItemNode("Leather Jerkin", "Physical Def");
        ItemNode magicResistCloak = new ItemNode("Magic Resist Cloak", "Magic Def");
        ItemNode healingNecklace = new ItemNode("Healing Necklace", "HP Regen");
        ItemNode herosRing = new ItemNode("Hero's Ring", "CD Reduction");

        ItemNode aresBelt = new ItemNode("Ares Belt", "HP");
        aresBelt.addChild(vitalityCrystal);

        ItemNode dreadnaughtArmor = new ItemNode("Dreadnaught Armor", "Physical Def");
        dreadnaughtArmor.addChild(leatherJerkin);
        dreadnaughtArmor.addChild(leatherJerkin);

        ItemNode silenceRobe = new ItemNode("Silence Robe", "Magic Def");
        silenceRobe.addChild(magicResistCloak);
        silenceRobe.addChild(vitalityCrystal);

        ItemNode blackIceShield = new ItemNode("Black Ice Shield", "Physical Def & CD");
        blackIceShield.addChild(leatherJerkin);
        blackIceShield.addChild(herosRing);

        ItemNode steelLegplates = new ItemNode("Steel Legplates", "Physical Def");
        steelLegplates.addChild(leatherJerkin);

        ItemNode moltenEssence = new ItemNode("Molten Essence", "HP & Burning Aura");
        moltenEssence.addChild(vitalityCrystal);

        ItemNode fleetingTime = new ItemNode("Fleeting Time", "CD Reduction (New Defense Patch)");
        fleetingTime.addChild(herosRing);
        fleetingTime.addChild(magicResistCloak);

        ItemNode radiantArmor = new ItemNode("Radiant Armor", "Continuous Magic Def");
        radiantArmor.addChild(silenceRobe);
        radiantArmor.addChild(aresBelt);

        ItemNode chastisePauldron = new ItemNode("Chastise Pauldron", "True Damage Defense");
        chastisePauldron.addChild(aresBelt);
        chastisePauldron.addChild(steelLegplates);

        ItemNode bruteForce = new ItemNode("Brute Force Breastplate", "Movement Speed & Def");
        bruteForce.addChild(aresBelt);
        bruteForce.addChild(leatherJerkin);

        ItemNode immortality = new ItemNode("Immortality", "Resurrection");
        immortality.addChild(aresBelt);
        immortality.addChild(leatherJerkin);

        ItemNode dominanceIce = new ItemNode("Dominance Ice", "Anti-Heal & Atk Speed Reduc");
        dominanceIce.addChild(blackIceShield);
        dominanceIce.addChild(steelLegplates);

        ItemNode athenasShield = new ItemNode("Athena's Shield", "Magic Burst Def");
        athenasShield.addChild(silenceRobe);
        athenasShield.addChild(aresBelt);

        ItemNode oracle = new ItemNode("Oracle", "Heal & Shield Boost");
        oracle.addChild(silenceRobe);
        oracle.addChild(herosRing);

        ItemNode antiqueCuirass = new ItemNode("Antique Cuirass", "Physical Damage Reduc");
        antiqueCuirass.addChild(dreadnaughtArmor);
        antiqueCuirass.addChild(aresBelt);

        ItemNode guardianHelmet = new ItemNode("Guardian Helmet", "Massive HP Regen");
        guardianHelmet.addChild(aresBelt);
        guardianHelmet.addChild(aresBelt);
        guardianHelmet.addChild(healingNecklace);

        ItemNode cursedHelmet = new ItemNode("Cursed Helmet", "Burning Aura Damage");
        cursedHelmet.addChild(moltenEssence);
        cursedHelmet.addChild(magicResistCloak);

        ItemNode thunderBelt = new ItemNode("Thunder Belt", "True Damage Basic Attack");
        thunderBelt.addChild(aresBelt);
        thunderBelt.addChild(blackIceShield);

        ItemNode queensWings = new ItemNode("Queen's Wings", "Damage Reduc at Low HP");
        queensWings.addChild(aresBelt);
        queensWings.addChild(herosRing);

        ItemNode bladeArmor = new ItemNode("Blade Armor", "Damage Reflection");
        bladeArmor.addChild(steelLegplates);
        bladeArmor.addChild(leatherJerkin);


        ItemNode[] allFinalItems = {
            fleetingTime, radiantArmor, chastisePauldron, bruteForce, 
            immortality, dominanceIce, athenasShield, oracle, 
            antiqueCuirass, guardianHelmet, cursedHelmet, thunderBelt, 
            queensWings, bladeArmor
        };

        System.out.println("MLBB DEFENSE ITEM RECIPES\n");
        for (int i = 0; i < allFinalItems.length; i++) {
            System.out.println("[" + (i + 1) + "] " + allFinalItems[i].name.toUpperCase());
            printTree(allFinalItems[i], 0);
            System.out.println("-------------------------------------------------");
        }

        System.out.println("\nTES PART C: JALUR BUILD ANTIQUE CUIRASS");
        List<String> buildPath = new ArrayList<>();
        printAllBuildPaths(antiqueCuirass, buildPath);

        System.out.println("\nTES PART D & E: MENGANALISIS DOMINANCE ICE");
        System.out.println("Target Analisis: " + dominanceIce.name);
        System.out.println("Total Node (Semua komponen): " + countNodes(dominanceIce));
        System.out.println("Total Leaves (Mentahan dasar): " + countLeaves(dominanceIce));
        System.out.println("Tinggi Tree (Tahap crafting): " + height(dominanceIce));

        System.out.println("\nPENCARIAN ITEM (PATH)");
        List<String> searchPath = new ArrayList<>();
        String itemTarget = "Hero's Ring"; 
        
        boolean found = findPath(dominanceIce, itemTarget, searchPath);
        
        if (found) {
            System.out.println("Posisi " + itemTarget + " di dalam resep (Pohon) Dominance Ice:");
            System.out.println(String.join(" -> ", searchPath)); 
        } else {
            System.out.println("Item " + itemTarget + " tidak ditemukan dalam resep Dominance Ice.");
        }
    
        //EKSEKUSI TAKE HOME TASKS
        System.out.println("\nTASK 1: ADD NEW BRANCH");
        ItemNode newComponent = new ItemNode("New Magic Armor", "Magic Def");
        newComponent.addChild(magicResistCloak); 
        dominanceIce.addChild(newComponent); 
        System.out.println("Berhasil menambahkan cabang 'New Magic Armor' ke Dominance Ice.");
        printTree(dominanceIce, 0);


        System.out.println("\nTASK 2: COUNT ITEM OCCURRENCES");
        String itemToCount = "Leather Jerkin";
        int occurrences = countItemOccurrences(antiqueCuirass, itemToCount);
        System.out.println("Jumlah " + itemToCount + " di dalam Antique Cuirass: " + occurrences);


        System.out.println("\nTASK 3: PRINT PATHS ENDING WITH SPECIFIC ITEM");
        String targetEnding = "Vitality Crystal";
        System.out.println("Jalur pada Immortality yang berujung pada " + targetEnding + ":");
        List<String> specificPath = new ArrayList<>();
        printPathsEndingWith(immortality, specificPath, targetEnding);


        System.out.println("\nTASK 5: ADD ONE MORE LEVEL & OBSERVE HEIGHT");
        ItemNode ultimateDefense = new ItemNode("Aegis of The Immortal", "Ultimate Stats");
        ultimateDefense.addChild(antiqueCuirass);
        ultimateDefense.addChild(athenasShield);
        
        System.out.println("Tinggi Antique Cuirass (Sebelumnya): " + height(antiqueCuirass));
        System.out.println("Tinggi Aegis of The Immortal (Tier 4 Baru): " + height(ultimateDefense));

        System.out.println("\nTASK 4: SCANNER INPUT");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama mentahan yang ingin dicari di dalam Dominance Ice (cth: Hero's Ring): ");
        String userInput = scanner.nextLine();
        
        List<String> userSearchPath = new ArrayList<>();
        if (findPath(dominanceIce, userInput, userSearchPath)) {
            System.out.println("Jalur menuju " + userInput + ": " + String.join(" -> ", userSearchPath));
        } else {
            System.out.println(userInput + " tidak ditemukan di resep ini.");
        }
        scanner.close();
    }
}
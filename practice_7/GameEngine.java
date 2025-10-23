import java.util.Scanner;
import java.util.Map;

/**
 * Основной игровой движок
 */
public class GameEngine {
    private Scanner scanner;
    private CharacterFactory characterFactory;
    private ItemFactory itemFactory;
    private BattleSystem battleSystem;
    private Dungeon dungeon;
    private Hero currentHero;
    private CharacterLogger logger;
    
    public GameEngine() {
        this.scanner = new Scanner(System.in);
        this.characterFactory = new GameCharacterFactory();
        this.itemFactory = new ItemFactory();
        this.battleSystem = new InteractiveBattleSystem();
        this.dungeon = new Dungeon();
        this.logger = new CharacterLogger();
        initializeDungeon();
    }
    
    private void initializeDungeon() {
        // Комната 1 с гоблинами
        Room room1 = new Room("Вход в подземелье", "Темная комната с гоблинами");
        room1.addMonster(characterFactory.createMonster("goblin"));
        room1.addMonster(characterFactory.createMonster("goblin"));
        room1.addItem(itemFactory.createItem("potion"));
        dungeon.addRoom(room1);
        
        // Комната 2 с скелетами
        Room room2 = new Room("Костяная комната", "Комната, полная скелетов");
        room2.addMonster(characterFactory.createMonster("skeleton"));
        room2.addMonster(characterFactory.createMonster("skeleton"));
        room2.addItem(itemFactory.createItem("sword"));
        room2.addItem(itemFactory.createItem("shield"));
        dungeon.addRoom(room2);
        
        // Комната 3 с драконом (босс)
        Room room3 = new Room("Логово дракона", "Огромная пещера с драконом");
        room3.addMonster(characterFactory.createMonster("dragon"));
        room3.addItem(itemFactory.createItem("firesword"));
        room3.addItem(itemFactory.createItem("greaterpotion"));
        dungeon.addRoom(room3);
    }
    
    public void startGame() {
        System.out.println("-- ДОБРО ПОЖАЛОВАТЬ В ПОДЗЕМЕЛЬЕ! --");
        System.out.println("Мини RPG==Битва=в=подземелье==");
        System.out.println();
        
        // создние героя 
        createHero();
        
        // игровоей цикл 
        gameLoop();
        
        // завершение 
        endGame();
    }
    
    /**
     * Создание героя
     */
    private void createHero() {
        System.out.println("Создание героя:");
        System.out.println("Выберите класс героя:");
        System.out.println("1. Воин (высокое HP, средняя атака, высокая защита)");
        System.out.println("2. Маг (низкое HP, высокая атака, низкая защита)");
        System.out.println("3. Лучник (среднее HP, средняя атака, средняя защита)");
        
        System.out.print("Введите номер класса (1-3): ");
        int classChoice = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Введите имя героя: ");
        String heroName = scanner.nextLine();
        
        String heroType;
        switch (classChoice) {
            case 1:
                heroType = "warrior";
                break;
            case 2:
                heroType = "mage";
                break;
            case 3:
                heroType = "archer";
                break;
            default:
                heroType = "warrior";
                System.out.println("Неверный выбор! Создан воин.");
        }
        
        currentHero = characterFactory.createHero(heroType, heroName);
        System.out.println("\nСоздан герой: " + currentHero);
        System.out.println();
    }
    
    /**
     * Основной игровой цикл
     */
    private void gameLoop() {
        while (currentHero.isAlive() && dungeon.hasMoreRooms()) {
            Room currentRoom = dungeon.getCurrentRoom();
            
            System.out.println("\n=== " + currentRoom.getName().toUpperCase() + " ===");
            System.out.println(currentRoom.getDescription());
            
            if (!currentRoom.isVisited()) {
                // Исследование комнаты
                exploreRoom(currentRoom);
                currentRoom.setVisited(true);
            }
            
            // Бой с монстрами в комнате
            if (!battleMonstersInRoom(currentRoom)) {
                break; // Герой погиб
            }
            
            // Переход в следующую комнату
            if (dungeon.moveToNextRoom()) {
                System.out.println("\nВы переходите в следующую комнату...");
            }
        }
        
        // Финальная проверка
        if (currentHero.isAlive()) {
            System.out.println("\n🎉 ПОЗДРАВЛЯЕМ! Вы прошли все подземелье!");
            dungeon.updatePlayerRanking(currentHero.getName(), 1);
        }
    }
    
    /**
     * Исследование комнаты
     */
    private void exploreRoom(Room room) {
        System.out.println("\nВы исследуете комнату...");
        
        // Поиск предметов
        Item foundItem = room.getRandomItem();
        if (foundItem != null) {
            System.out.println("Вы нашли предмет: " + foundItem.getName());
            System.out.println("Описание: " + foundItem.getDescription());
            
            System.out.print("Взять предмет? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();
            
            if (choice.equals("y") || choice.equals("yes")) {
                try {
                    currentHero.addItem(foundItem);
                    System.out.println("Предмет добавлен в инвентарь!");
                } catch (InventoryFullException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
        
        // Информация о монстрах
        if (!room.getMonsters().isEmpty()) {
            System.out.println("\nВ комнате обнаружены монстры:");
            for (Monster monster : room.getMonsters()) {
                System.out.println("- " + monster.getName() + " (HP: " + monster.getHealth() + ")");
            }
        }
    }
    
    /**
     * Бой с монстрами в комнате
     */
    private boolean battleMonstersInRoom(Room room) {
        for (Monster monster : room.getMonsters()) {
            if (!monster.isAlive()) {
                continue;
            }
            
            System.out.println("\n⚔️ БОЙ С " + monster.getName().toUpperCase() + "!");
            
            boolean victory = battleSystem.fight(currentHero, monster);
            if (!victory) {
                return false; // Герой погиб
            }
            
            // Небольшая пауза между боями
            System.out.println("\nВы отдыхаете после боя...");
            currentHero.heal(10); // Небольшое восстановление между боями
        }
        
        return true; // Все монстры побеждены
    }
    
    /**
     * Завершение игры
     */
    private void endGame() {
        System.out.println("\n=== ИГРА ЗАВЕРШЕНА ===");
        System.out.println("Финальная статистика:");
        System.out.println(currentHero);
        
        if (!currentHero.getInventory().isEmpty()) {
            System.out.println("\nИнвентарь:");
            for (int i = 0; i < currentHero.getInventory().size(); i++) {
                System.out.println((i + 1) + ". " + currentHero.getInventory().get(i));
            }
        }
        
        System.out.println("\nРейтинг игроков:");
        Map<String, Integer> rankings = dungeon.getPlayerRankings();
        if (rankings.isEmpty()) {
            System.out.println("Пока нет записей в рейтинге.");
        } else {
            for (Map.Entry<String, Integer> entry : rankings.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " побед");
            }
        }
        
        scanner.close();
    }
}

# Мини-RPG: Битва в подземелье
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/971ff5dd-a828-44e5-a368-7b9d7505199b" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/0ff508b1-2060-41d4-845a-202553b49e9c" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/9c12d379-6b8d-4de5-ab53-13a95a919433" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/bd928bf0-1c11-4ea5-96f3-9f874ae6f942" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/bbe28068-0d67-459f-9462-578041d6686d" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/bc9cb524-43e0-4e10-8ce6-7e0252b45f7d" />
<img width="1268" height="932" alt="image" src="https://github.com/user-attachments/assets/7f5e0dc9-a285-41cc-b5be-c30ada7dbbde" />

## Реализованные паттерны проектирования

### 1. Factory Method / Abstract Factory
- `CharacterFactory` - абстрактная фабрика для создания персонажей
- `GameCharacterFactory` - конкретная реализация фабрики
- `ItemFactory` - фабрика для создания предметов

### 2. Strategy Pattern
- `AttackStrategy` - интерфейс стратегии атаки
- `MeleeAttack`, `MagicAttack`, `RangedAttack` - конкретные стратегии
- Герои используют разные стратегии атаки

### 3. Template Method
- `BattleSystem` - абстрактный класс с шаблоном боя
- `InteractiveBattleSystem` - конкретная реализация с интерактивным управлением

### 4. Decorator Pattern
- `BaseItem` - базовый класс для предметов
- `Potion`, `GreaterPotion` - зелья лечения
- `Sword`, `FireSword` - мечи с разными эффектами
- `Shield` - щит для защиты

### 5. Observer Pattern
- `CharacterObserver` - интерфейс наблюдателя
- `CharacterLogger` - конкретный наблюдатель для логирования

## Структура классов

### Персонажи
- `Character` - базовый класс для всех персонажей
- `Hero` - базовый класс для героев
- `Monster` - базовый класс для монстров
- `Warrior`, `Mage`, `Archer` - конкретные классы героев
- `Goblin`, `Skeleton`, `Dragon` - конкретные классы монстров

### Предметы
- `Item` - интерфейс для всех предметов
- `BaseItem` - базовый класс предметов
- `Potion`, `GreaterPotion` - зелья лечения
- `Sword`, `FireSword` - мечи
- `Shield` - щит

### Игровая система
- `GameEngine` - основной игровой движок
- `Dungeon` - управление подземельем
- `Room` - представление комнаты
- `BattleSystem` - система боя

### Исключения
- `LowHealthException` - низкое здоровье героя
- `InventoryFullException` - переполненный инвентарь
- `DragonFireException` - особая атака дракона

## Коллекции и итераторы
- `List<Item>` - инвентарь героя
- `List<Monster>` - монстры в комнате
- `Map<String, Integer>` - рейтинг игроков
- Использование `Iterator` для обхода коллекций

## Запуск игры
```bash
javac *.java
java Main
```

- Рейтинговая система

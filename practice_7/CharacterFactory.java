/**
 * Абстрактная фабрика для создания персонажей
 */
public abstract class CharacterFactory {
    
    /**
     * Создает героя указанного типа
     * @param heroType тип героя
     * @param name имя героя
     * @return созданный герой
     */
    public abstract Hero createHero(String heroType, String name);
    
    /**
     * Создает монстра указанного типа
     * @param monsterType тип монстра
     * @return созданный монстр
     */
    public abstract Monster createMonster(String monsterType);
    
    /**
     * Создает случайного монстра
     * @return случайный монстр
     */
    public abstract Monster createRandomMonster();
}

// интерфейс Observer для отслеживания изменений характеристик героя
public interface CharacterObserver {
    // вызывается при изменении характеристик персонажа
    // character персонаж, характеристики которого изменились
    // changeType тип изменения 
    // oldValue старое значение
    // newValue новое значение
    void onCharacterChanged(Character character, String changeType, int oldValue, int newValue);
}

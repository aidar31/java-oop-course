/**
 * Простой Observer для логирования изменений персонажа
 */
public class CharacterLogger implements CharacterObserver {
    
    @Override
    public void onCharacterChanged(Character character, String changeType, int oldValue, int newValue) {
        System.out.println("[ЛОГ] " + character.getName() + ": " + changeType + 
                          " изменилось с " + oldValue + " на " + newValue);
    }
}

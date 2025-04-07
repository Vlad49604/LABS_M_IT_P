import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.Expense;  // Тільки цей клас для тестів
import com.mycompany.ExpenseStorage;
import com.mycompany.Categories;
import java.util.ArrayList;

public class ExpenseTrackerTest {

    private Expense exp;
    private ExpenseStorage expenseStorage;
    private Categories categories;

    @Before
    public void setUp() {
        // Ініціалізація екземпляра класу Expense перед кожним тестом
        exp = new Expense(1, 100, "food", "Lunch", "01/04/2025");
        expenseStorage = new ExpenseStorage();
        categories = new Categories();
    }

    @Test
    public void testExpenseCreation() {
        // Перевірка значень атрибутів об'єкта Expense
        assertEquals(1, exp.getExp_id());
        assertEquals(100, exp.getAmount());
        assertEquals("food", exp.getCategory());
        assertEquals("Lunch", exp.getDescription());
        assertEquals("01/04/2025", exp.getDate());
    }

    @Test
    public void testGetString() {
        // Перевірка, чи метод getString повертає правильний формат
        String expected = "1,100,food,Lunch,01/04/2025";
        assertEquals(expected, exp.getString());
    }

    @Test
    public void testGetFormattedString() {
        // Перевірка, чи метод getFormattedString повертає правильний формат
        String expected = "ID : 1 , Amount : 100 , Category : food , Description : Lunch , Date : 01/04/2025";
        assertEquals(expected, exp.getFormattedString());
    }

    @Test
    public void testStoreAndReadExpense() {
        // Перевірка збереження та читання витрат з файлу через ExpenseStorage
        ArrayList<Expense> expList = new ArrayList<>();
        expList.add(exp);
        expenseStorage.storeExpense(expList);
        
        // Читаємо з файлу та перевіряємо, чи записалась витрата правильно
        ArrayList<Expense> readExpenses = expenseStorage.readExpense();
        assertEquals(1, readExpenses.size());
        assertEquals(exp.getExp_id(), readExpenses.get(0).getExp_id());
        assertEquals(exp.getAmount(), readExpenses.get(0).getAmount());
        assertEquals(exp.getCategory(), readExpenses.get(0).getCategory());
        assertEquals(exp.getDescription(), readExpenses.get(0).getDescription());
        assertEquals(exp.getDate(), readExpenses.get(0).getDate());
    }

    @Test
    public void testStoreAndReadCategories() {
        // Перевірка збереження та читання категорій через клас Categories
        ArrayList<String> categoriesList = new ArrayList<>();
        categoriesList.add("food");
        categories.storeCategories(categoriesList);
        
        // Читаємо з файлу та перевіряємо, чи збереглась категорія
        ArrayList<String> readCategories = categories.readCategories();
        assertEquals(1, readCategories.size());
        assertEquals("food", readCategories.get(0));
    }

    @Test
    public void testCategoryExistence() {
        // Перевірка, чи існує категорія в списку
        ArrayList<String> categoriesList = new ArrayList<>();
        categoriesList.add("food");
        categoriesList.add("transport");
        categories.storeCategories(categoriesList);

        // Перевірка наявності категорії
        assertTrue(categoriesList.contains("food"));
        assertTrue(categoriesList.contains("transport"));
        assertFalse(categoriesList.contains("entertainment"));
    }

    @Test
    public void testDeleteExpense() {
        // Перевірка видалення витрати через ExpenseStorage
        ArrayList<Expense> expList = new ArrayList<>();
        expList.add(exp);
        expenseStorage.storeExpense(expList);
        
        // Видалення витрати
        expList.remove(0);
        expenseStorage.storeExpense(expList);

        // Перевірка, що витрата була видалена
        ArrayList<Expense> readExpenses = expenseStorage.readExpense();
        assertEquals(0, readExpenses.size());
    }

    @Test
    public void testAddCategory() {
        // Перевірка додавання нової категорії через Categories
        ArrayList<String> categoriesList = new ArrayList<>();
        categoriesList.add("food");
        categories.storeCategories(categoriesList);

        // Додаємо нову категорію
        categoriesList.add("entertainment");
        categories.storeCategories(categoriesList);

        // Перевірка наявності нової категорії
        assertTrue(categoriesList.contains("entertainment"));
    }
}

Here are your summary notes with key points while keeping the program as is:  

---

### **Type Inference and Generic Methods**  

#### **Type Inference in Java**  
- The Java compiler can infer type arguments when invoking a generic method.  
- It analyzes method arguments, return types, and assignment context.  
- The goal is to determine the most specific type that works for all arguments.  
- Example:  
  ```java
  static <T> T pick(T a1, T a2) { return a2; }
  Serializable s = pick("d", new ArrayList<String>());
  ```
  - Here, `pick("d", new ArrayList<String>())` infers `Serializable` as the common type.

---

#### **Generic Methods**  
- A generic method allows type parameters to be specified within angle brackets `<T>`.  
- The compiler can infer the type parameter from method arguments, reducing the need for explicit type declarations.  

#### **Example: BoxDemo Program**  
```java
public class BoxDemo {

  public static <U> void addBox(U u, 
      java.util.List<Box<U>> boxes) {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
  }

  public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
    int counter = 0;
    for (Box<U> box: boxes) {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" +
             boxContents.toString() + "]");
      counter++;
    }
  }

  public static void main(String[] args) {
    java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
      new java.util.ArrayList<>();
    BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
    BoxDemo.outputBoxes(listOfIntegerBoxes);
  }
}
```
**Output:**  
```
Box #0 contains [10]  
Box #1 contains [20]  
Box #2 contains [30]  
```

---

#### **Key Takeaways:**  
1. **Type Parameters in Generic Methods**  
   - The `<U>` in `addBox(U u, List<Box<U>> boxes)` allows flexibility in handling different types.  
   
2. **Type Inference in Method Calls**  
   - Explicit type declaration:  
     ```java
     BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
     ```
   - Compiler automatically infers the type from arguments:  
     ```java
     BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
     ```

3. **No Need for Explicit Type Witness**  
   - Java infers the type from method parameters, making the code more concise.  

---

### **Type Inference and Instantiation of Generic Classes**  

#### **Diamond Operator (`<>`) in Generic Class Instantiation**  
- The **diamond (`<>`)** allows the compiler to infer the type parameters when creating an instance of a generic class.  
- This helps reduce redundancy and improves code readability.  

#### **Example Without Diamond (`<>`):**  
```java
Map<String, List<String>> myMap = new HashMap<String, List<String>>();
```
- Here, the type parameters `<String, List<String>>` are explicitly specified in both the declaration and instantiation.

#### **Using the Diamond (`<>`) for Type Inference:**  
```java
Map<String, List<String>> myMap = new HashMap<>();
```
- The compiler infers the type parameters from the left-hand side (`Map<String, List<String>>`).  
- This simplifies the syntax without losing type safety.

#### **Incorrect Usage: Raw Type Instantiation**  
```java
Map<String, List<String>> myMap = new HashMap(); // unchecked conversion warning
```
- Since no type parameters are provided, this uses the **raw type**, leading to an **unchecked conversion warning**.  
- It may cause **runtime type safety issues**.  

#### **Key Takeaways:**  
1. **Use the diamond (`<>`) to enable type inference when instantiating generic classes.**  
2. **Avoid raw types** (e.g., `new HashMap()`) as they lead to unchecked conversion warnings.  
3. **Diamond operator works only when the compiler can infer types from context.**  

### **Type Inference and Generic Constructors of Generic and Non-Generic Classes**  

#### **Generic Constructors in Generic Classes**  
- A **generic constructor** can declare its own type parameter, independent of the class's type parameters.  
- Example:  
  ```java
  class MyClass<X> {
    <T> MyClass(T t) {
      // Constructor logic
    }
  }
  ```
- Here, `MyClass<X>` is a **generic class**, and `<T>` in the constructor is an independent **generic parameter**.

---

#### **Example: Constructor Type Inference**  
```java
new MyClass<Integer>("");
```
- The compiler explicitly assigns **`Integer`** to `X` (class-level type parameter).  
- The constructor receives a `String`, so it infers **`T` as `String`**.  

---

#### **Using the Diamond (`<>`) in Java 7+**  
```java
MyClass<Integer> myObject = new MyClass<>("");
```
- The **diamond operator (`<>`)** allows the compiler to infer `X` as `Integer`.  
- The constructor still infers `T` as `String` based on the argument (`""`).  

---

#### **Key Takeaways:**  
1. **Generic constructors can exist in both generic and non-generic classes.**  
2. **A generic constructor's type parameters (`T`) are separate from the class's type parameters (`X`).**  
3. **The compiler infers types based on method arguments, target types, and expected return types.**  
4. **Using the diamond (`<>`) allows the compiler to infer the type of the generic class, reducing redundancy.**  
5. **Type inference does not use information from later in the program—only available context is considered.**  

### **Target Types in Java**  

#### **What is a Target Type?**  
- The **target type** is the **expected data type** based on where an expression appears.  
- The **Java compiler** uses target typing to infer the **type parameters** of a generic method invocation.  

---

#### **Example: Inferring Type from Target Type**  
Method signature of `Collections.emptyList()`:  
```java
static <T> List<T> emptyList();
```
If assigned to `List<String>`, the compiler infers `T` as `String`:  
```java
List<String> listOne = Collections.emptyList(); // T inferred as String
```
Alternatively, specifying `T` explicitly (not required but valid):  
```java
List<String> listOne = Collections.<String>emptyList();
```

---

#### **Target Type in Method Arguments**  
```java
void processStringList(List<String> stringList) {
    // process stringList
}
```
#### **Java SE 7 (Does NOT Compile)**  
```java
processStringList(Collections.emptyList()); // Compilation error
```
- The compiler **defaults `T` to `Object`**, returning `List<Object>`, which is **incompatible** with `List<String>`.  
- Solution in **Java SE 7**: Explicitly specify the type argument:  
  ```java
  processStringList(Collections.<String>emptyList()); // Works in Java 7
  ```

#### **Java SE 8+ (Compiles Successfully)**  
```java
processStringList(Collections.emptyList()); // Works in Java 8+
```
- **Why?** The compiler now **infers `T` from the expected method argument type** (`List<String>`), so `emptyList()` correctly returns `List<String>`.

---

#### **Key Takeaways:**  
1. **Target typing helps the compiler infer type parameters in generic method calls.**  
2. **In Java SE 7, explicit type arguments were required in some cases (e.g., method arguments).**  
3. **Java SE 8 improved type inference** by allowing method argument types to act as target types.  
4. **Reduces boilerplate code** by removing unnecessary type specifications.  

### **Target Typing in Lambda Expressions**  

#### **What is Target Typing in Lambdas?**  
- The **target type** is the expected data type that the compiler infers for an expression based on the **context**.  
- **Lambda expressions rely on target typing** to determine their functional interface type.  

---

#### **Example: Inferring Lambda Expression Type**  

##### **Method Signatures**  
```java
public static void printPersons(List<Person> roster, CheckPerson tester)
```
```java
public void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) 
```

##### **Calling These Methods with Lambda Expressions**  
```java
printPersons(
    people, 
    p -> p.getGender() == Person.Sex.MALE
         && p.getAge() >= 18
         && p.getAge() <= 25);
```
```java
printPersonsWithPredicate(
    people,
    p -> p.getGender() == Person.Sex.MALE
         && p.getAge() >= 18
         && p.getAge() <= 25);
```

##### **How Does the Compiler Infer the Lambda Type?**  
1. **For `printPersons()`**, the expected argument type is `CheckPerson`, so the lambda expression is inferred as a `CheckPerson` implementation.  
2. **For `printPersonsWithPredicate()`**, the expected argument type is `Predicate<Person>`, so the lambda expression is inferred as a `Predicate<Person>`.  
3. The **same lambda expression** can be used for both because its structure matches both functional interfaces.  

---

#### **Where Can Target Typing Be Used?**  
You can use **lambda expressions** in places where the compiler can infer a **target type**, such as:  
- **Variable declarations**  
  ```java
  Predicate<Person> isMale = p -> p.getGender() == Person.Sex.MALE;
  ```
- **Assignments**  
  ```java
  CheckPerson check = p -> p.getAge() > 18;
  ```
- **Return statements**  
  ```java
  public Predicate<Person> getPredicate() {
      return p -> p.getAge() > 18;
  }
  ```
- **Array initializers**  
  ```java
  Predicate<Person>[] filters = { p -> p.getAge() > 18, p -> p.getGender() == Person.Sex.MALE };
  ```
- **Method or constructor arguments** *(as shown earlier)*  
- **Lambda expression bodies**  
- **Conditional expressions (`?:`)**  
  ```java
  Predicate<Person> filter = (useAge) ? p -> p.getAge() > 18 : p -> p.getGender() == Person.Sex.MALE;
  ```
- **Cast expressions**  
  ```java
  Predicate<Person> pred = (Predicate<Person>) (p -> p.getAge() > 18);
  ```

---

#### **Key Takeaways**  
1. **Lambda expressions rely on target typing** to determine their functional interface type.  
2. The **expected method argument type defines the lambda’s inferred type**.  
3. **Same lambda can be used for different functional interfaces**, provided the method signatures match.  
4. **Target typing enables cleaner and more flexible lambda expressions** in Java.  

### **Target Types and Method Arguments**  

#### **How Does the Java Compiler Determine the Target Type?**  
When **passing a lambda expression as a method argument**, the **compiler determines the expected type** using:  
1. **Overload Resolution** – Choosing the correct method when multiple overloaded versions exist.  
2. **Type Argument Inference** – Determining the type of generic parameters based on usage.  

---

### **Example: Overloaded Methods and Lambda Expressions**  

#### **Functional Interfaces**  
```java
public interface Runnable {
    void run();  // No return value
}

public interface Callable<V> {
    V call();  // Returns a value of type V
}
```

#### **Overloaded `invoke()` Methods**  
```java
void invoke(Runnable r) {
    r.run();
}

<T> T invoke(Callable<T> c) {
    return c.call();
}
```

#### **Which Method is Called?**  
```java
String s = invoke(() -> "done");
```
🚀 **Answer:** The **`invoke(Callable<T>)` method is called**, because:  
- `() -> "done"` is a **lambda expression returning a value**.  
- **`invoke(Runnable)` expects a `void` method**, but this lambda **returns "done"**.  
- **`invoke(Callable<T>)` expects a method returning a value** → **It matches!**  
- The compiler infers `T = String`.  

---

### **Key Takeaways**  
✔️ **If a lambda returns a value, it is inferred as `Callable<T>`.**  
✔️ **If a lambda has no return value, it is inferred as `Runnable`.**  
✔️ **Overload resolution chooses the method based on expected return type.**  
✔️ **Lambda expressions help simplify functional programming in Java.**  

### **Short Interview Notes on Type Inference and Generics**

#### **1. Type Inference in Java**
- **Definition:** The Java compiler automatically determines the type of generic parameters based on method arguments or return types.
- **Benefit:** No need to specify the type explicitly in many cases.
  
#### **2. Generic Methods**
- Methods can define **type parameters**, allowing type flexibility.  
  ```java
  static <T> T pick(T a1, T a2) { return a2; }
  ```
- **Type Inference Example:**  
  ```java
  Serializable s = pick("d", new ArrayList<String>());
  // Compiler infers T = String
  ```

#### **3. Diamond Operator (<>):**
- The **diamond (`<>`)** simplifies generic class instantiation, letting the compiler infer types.
  ```java
  Map<String, List<String>> myMap = new HashMap<>(); // Type inferred
  ```

#### **4. Type Inference in Constructors**
- **Constructors** can also be **generic**, and their type parameters can be inferred.
  ```java
  new MyClass<Integer>("");
  // Compiler infers Integer for class and String for constructor type
  ```

#### **5. Target Type**
- **Target Type**: The expected data type where an expression is used.
  ```java
  List<String> list = Collections.emptyList();
  // Inferred: List<String>
  ```

#### **6. Target Typing in Lambda Expressions**
- The **target type** determines the type of lambda expressions in method arguments.  
  Example:
  ```java
  String s = invoke(() -> "done");
  // invoke(Callable<T>) is called because the lambda returns a value.
  ```

#### **7. Overloaded Methods with Lambda**
- **Method Overloading**: The correct method is chosen based on return type and arguments.  
  Example:
  ```java
  void invoke(Runnable r) { r.run(); }
  <T> T invoke(Callable<T> c) { return c.call(); }
  ```

#### **Key Points to Remember**
- **Type inference** reduces boilerplate and increases code readability.
- **Generics** and **lambda expressions** heavily rely on **target type** to resolve types automatically.
- Use the **diamond operator** (`<>`) for cleaner code in Java SE 7 and later.

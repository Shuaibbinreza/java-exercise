Here are the **summary notes** for the provided content on **Upper Bounded Wildcards**, including examples and preserving programs as-is:

---

### ✅ **Upper Bounded Wildcards - Summary Notes**

#### 🔸 Purpose:
- Used to **relax restrictions** on generic types.
- Allows a method to **accept a type and its subclasses**.

#### 🔸 Syntax:
```java
List<? extends Type>
```
- `?` is a wildcard.
- `extends` is used for both **inheritance** (classes) and **implementation** (interfaces).

#### 🔸 Key Point:
- `List<? extends Number>` allows `List<Integer>`, `List<Double>`, `List<Float>`, etc.
- `List<Number>` is more **restrictive** (only allows `List<Number>`).

#### 🔸 Example 1 – Generic method that processes any subtype of `Foo`:
```java
public static void process(List<? extends Foo> list) {
    for (Foo elem : list) {
        // ...
    }
}
```
- Iterates through the list as `Foo`, allowing access to `Foo` methods.

#### 🔸 Example 2 – `sumOfList()` method using upper bounded wildcard:
```java
public static double sumOfList(List<? extends Number> list) {
    double s = 0.0;
    for (Number n : list)
        s += n.doubleValue();
    return s;
}
```

#### 🔸 Example usage:
```java
List<Integer> li = Arrays.asList(1, 2, 3);
System.out.println("sum = " + sumOfList(li)); // Output: sum = 6.0

List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
System.out.println("sum = " + sumOfList(ld)); // Output: sum = 7.0
```

#### 📌 When to Use:
- When you want to **read from** a list of unknown subtype of a specific class (e.g., Number).
- **Cannot add** elements to such a list (except `null`), but you can safely read them.

---


### ✅ **Unbounded Wildcards - Summary Notes**

#### 🔸 Purpose:
- Allows working with **lists of unknown types**.
- Useful when the code works with **methods not dependent on type parameter** or **Object class functionality**.

#### 🔸 Syntax:
```java
List<?>
```
- Called a **list of unknown type**.

---

### 🔸 When to Use:
1. You only use methods from **Object** class (e.g., `toString()`, `equals()`, etc.).
2. You use methods that **don’t depend on type parameter**, e.g.:
   - `list.size()`
   - `list.clear()`

---

### 🔸 Common Mistake – Using `List<Object>`:
```java
public static void printList(List<Object> list) {
    for (Object elem : list)
        System.out.println(elem + " ");
    System.out.println();
}
```
- ❌ Works **only for List<Object>**, **not for** `List<Integer>`, `List<String>`, etc.

---

### ✅ Correct Way – Using `List<?>`:
```java
public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
}
```
- ✅ Can print lists of **any type**.

#### 🧪 Example Usage:
```java
List<Integer> li = Arrays.asList(1, 2, 3);
List<String>  ls = Arrays.asList("one", "two", "three");

printList(li);  // prints: 1 2 3
printList(ls);  // prints: one two three
```

---

### ❗ Note:
- `List<Object>` ≠ `List<?>`
  - `List<Object>`: You **can insert** any `Object`.
  - `List<?>`: You **can’t insert** anything **except `null`**.

---


### ✅ **Lower Bounded Wildcards - Summary Notes**

#### 🔸 Purpose:
- Allows a method to accept a list of a **specific type or any of its supertypes**.

#### 🔸 Syntax:
```java
List<? super Type>
```
- `?` = wildcard  
- `super` = used to define a **lower bound**

---

### 🔸 Key Concept:
- **Upper bounded** wildcard: `<? extends A>` → A and its subtypes  
- **Lower bounded** wildcard: `<? super A>` → A and its supertypes  
- You **cannot** use both `extends` and `super` at once.

---

### 🔸 When to Use:
- When you want to **add** elements to a collection.
- Especially useful for **writing** data into generic structures.

---

### 🔸 Example – Method that accepts list of Integer and its supertypes:
```java
public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
        list.add(i);
    }
}
```

#### ✅ Works with:
- `List<Integer>`
- `List<Number>`
- `List<Object>`

#### ❌ More restrictive version:
```java
List<Integer> // Only accepts Integer
```

---

### 🧪 Use Case:
- Need a method to **insert `Integer` values**, so use `List<? super Integer>` for **maximum flexibility**.

---


### ✅ **Wildcards and Subtyping - Summary Notes**

#### 🔸 Key Point:
- **Generics do not follow normal inheritance rules**.
- Just because `B` extends `A` doesn't mean `List<B>` is a subtype of `List<A>`.

---

### 🔸 Example – Regular Inheritance (Non-Generic):
```java
class A { /* ... */ }
class B extends A { /* ... */ }

B b = new B();
A a = b;  // ✅ OK - B is a subtype of A
```

---

### 🔸 ❌ This does NOT apply to generic types:
```java
List<B> lb = new ArrayList<>();
List<A> la = lb;  // ❌ Compile-time error
```

Even though `B` is a subtype of `A`, `List<B>` is **not** a subtype of `List<A>`.

---

### 🔸 Wildcards Help Bridge the Gap

#### ✅ Use **upper bounded wildcard** to relate generic types:
```java
List<? extends Integer> intList = new ArrayList<>();
List<? extends Number> numList = intList;  // ✅ OK
```
- `Integer` is a subtype of `Number`, so `List<? extends Integer>` can be assigned to `List<? extends Number>`.
- Allows **read-only** access to elements as `Number`.

---

### 🔸 Common Parent of Generic Types:
- `List<?>` is the **common parent** of `List<Number>`, `List<Integer>`, etc.
- Useful when the exact type is **unknown or irrelevant**.

---

### 🔸 Lower Bounded Relationship:
```java
List<? super Integer> superList;
List<Integer> intList;
```
- `List<Integer>` **is a subtype of** `List<? super Integer>`.

---

### 📊 Wildcard Relationships Summary:

| Relationship Type      | Example                                 | Notes                                             |
|------------------------|-----------------------------------------|---------------------------------------------------|
| Upper Bounded Wildcard | `List<? extends Number>`                | Accepts `List<Number>`, `List<Integer>`, etc.     |
| Lower Bounded Wildcard | `List<? super Integer>`                 | Accepts `List<Integer>`, `List<Number>`, `List<Object>` |
| Common Parent          | `List<?>`                               | Accepts any `List<T>` regardless of `T`           |
| Not Related Directly   | `List<Integer>` ≠ `List<Number>`        | No inheritance relationship                       |

---


## ✅ **Wildcard Capture & Helper Methods – Summary Notes**

### 🔹 What is Wildcard Capture?
- Sometimes, when using wildcards like `<?>`, the **Java compiler can infer** the actual type.
- This inferred type is called a **capture variable** (like `CAP#1`, `CAP#2`).
- If the compiler can’t determine the exact type for an operation, it throws a **capture error**.

---

## 🔹 ❌ Problem Example: WildcardError
```java
void foo(List<?> i) {
    i.set(0, i.get(0)); // ❌ Compile-time error
}
```
- ❗You **can’t insert** elements into a `List<?>` because the actual type is unknown.
- `i.get(0)` returns an `Object`, but `i.set()` expects a value of the unknown captured type `CAP#1`.

🧠 **Compiler Message Highlights:**
```
required: CAP#1
found: Object
```

---

## ✅ Fix Using a Helper Method: WildcardFixed
```java
void foo(List<?> i) {
    fooHelper(i);
}

private <T> void fooHelper(List<T> l) {
    l.set(0, l.get(0)); // ✅ Compiles fine
}
```
- The helper method **captures the wildcard** using `<T>`, allowing proper type inference.
- Compiler now knows `T` is the same on both sides of `set()`.

---

## 🔹 Invalid Example: WildcardErrorBad

```java
void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
    Number temp = l1.get(0);
    l1.set(0, l2.get(0)); // ❌ Compile error
    l2.set(0, temp);      // ❌ Compile error
}
```

### ❌ Why It Fails:
- `List<? extends Number>` may be `List<Integer>` or `List<Double>`, which are **not interchangeable**.
- Even though both extend `Number`, their **capture types** are different.

🧠 **Compiler Message Example:**
```
expected: CAP#1 extends Number
found: Number
```

---

### 🔹 Real-World Risk:
```java
List<Integer> li = Arrays.asList(1, 2, 3);
List<Double>  ld = Arrays.asList(10.1, 20.2, 30.3);
swapFirst(li, ld); // ❌ Unsafe and invalid
```
- Trying to move an `Integer` into a `Double` list – not type-safe!

---

## 🔚 Conclusion:
| Situation | Wildcard Type | Safe to Modify? | Fix with Helper? |
|-----------|----------------|------------------|-------------------|
| Want to read from any type | `List<?>` or `List<? extends T>` | ✅ Read-only | ✅ Use helper to infer |
| Want to write values | `List<? super T>` | ✅ Can add `T` or subtypes | ❌ No helper needed |
| Need to swap between wildcards | ❌ Different capture types | ❌ Unsafe | ❌ Fundamentally invalid |

---

## ✅ **Guidelines for Wildcard Use – Summary Notes**

### 🧠 Core Idea: Use Wildcards Based on **"In" and "Out"** Behavior

---

## 🔹 **1. Upper Bounded Wildcards (`? extends T`)**
### 👉 Use when you only **read** from the variable → it's "in"
```java
List<? extends Number> nums; // can read elements as Number
```

| You Can | You Cannot |
|---------|------------|
| Read elements as type `T` | Add elements (except `null`) |
| Call Object methods | Store `T` values directly |
| Use for **input** only | — |

> Think of it as **producer** — it *produces* data (you read from it).

✅ **Example:**
```java
void printNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }
}
```

---

## 🔹 **2. Lower Bounded Wildcards (`? super T`)**
### 👉 Use when you only **write** to the variable → it's "out"
```java
List<? super Integer> nums; // can add Integers
```

| You Can | You Cannot |
|---------|------------|
| Add values of `T` or subclasses | Read elements as anything more specific than `Object` |
| Store values | — |
| Use for **output** | — |

> Think of it as **consumer** — it *consumes* data (you write into it).

✅ **Example:**
```java
void addIntegers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}
```

---

## 🔹 **3. Unbounded Wildcards (`<?>`)**
### 👉 Use when you don’t care about the type, but want to **read Object-level methods** only
```java
List<?> unknowns;
```

| You Can | You Cannot |
|---------|------------|
| Read as `Object` | Add anything (except `null`) |
| Pass to methods that work with any type | — |

✅ **Example:**
```java
void printList(List<?> list) {
    for (Object o : list) {
        System.out.println(o);
    }
}
```

---

## 🔹 **4. No Wildcard**
### 👉 Use when you need to **read and write** exact type
```java
List<String> list;
```

✅ **Example:**
```java
void fillAndPrint(List<String> list) {
    list.add("Hello");
    System.out.println(list.get(0));
}
```

---

## 🔹 Example: Upper Bound with Inheritance
```java
class NaturalNumber {
    int i;
    NaturalNumber(int i) { this.i = i; }
}

class EvenNumber extends NaturalNumber {
    EvenNumber(int i) { super(i); }
}

List<EvenNumber> le = new ArrayList<>();
List<? extends NaturalNumber> ln = le;

ln.add(new NaturalNumber(5)); // ❌ Compile-time error
ln.add(null);                 // ✅ Allowed
```
- `ln` is read-only in practice because it **might** be a list of `EvenNumber`, and adding a general `NaturalNumber` could break type safety.

---

## 🔁 Summary Table

| Wildcard           | Usage Type | Read | Write | Use Case                             |
|--------------------|------------|------|-------|--------------------------------------|
| `? extends T`      | "in"       | ✅   | ❌    | Reading data (e.g., producers)       |
| `? super T`        | "out"      | ⚠️*  | ✅    | Writing data (e.g., consumers)       |
| `<?>`              | "in" (Object only) | ✅   | ❌    | Totally unknown type (read-only)     |
| Exact type (`T`)   | "in & out" | ✅   | ✅    | Full access (read and write)         |

⚠️* You can only read elements as `Object` when using `? super T`.

---


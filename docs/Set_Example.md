# **SET**

**Key Points**

1. **Set Interface Inherits from Collection** – It does not introduce new methods.
2. **HashSet is the Main Implementation** – The Java Collections Framework provides HashSet as a concrete implementation.
3. **Uses HashMap Internally** – HashSet internally wraps an instance of HashMap to store elements.
4. **Prevents Duplicates** – Unlike List, Set ensures uniqueness.
5. **No Guaranteed Order** – Elements in a Set are stored in an unpredictable order.
6. **Iteration Order is Uncertain** – Unlike List, the insertion order is **not** maintained.

**Basic Operations**
1.	Creating a Set:<be>
```Set<String> set = new HashSet<>();```
3.	Add <be>
```set.add("Apple"); ```
     ```set.add("Banana"); ```
    ``` set.add("Cherry");```
4.	Removing Elements (remove())<be>
```set.remove("Banana");```
5.	Checking if an Element Exists (contains())<be>
```boolean exists = set.contains("Apple");  // true```
6.	Iterate using foreach<be>
```set.forEach(System.out::println);```
7.	Clearing a Set (clear())<be>
```set.clear();  // Removes all elements```
8.	Checking if Set is Empty (isEmpty())<be>
```boolean empty = set.isEmpty();  // true if set is empty```
9.	Adding All Elements from Another Collection (addAll())<be>
```Set<String> set2 = new HashSet<>(List.of("Mango", "Orange"));```
```set.addAll(set2);```
9.	Removing All Elements (removeAll())<be>
```set.removeAll(set2);  // Removes all elements in set2 from set```
10.	Retaining Common Elements (retainAll())<be>
```set.retainAll(Set.of("Apple", "Mango"));  // Keeps only these elements```
11.	Covert to list<be>
```List<String> list = new ArrayList<>(set);```

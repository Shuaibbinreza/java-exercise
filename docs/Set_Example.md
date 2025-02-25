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
```
Set<String> set = new HashSet<>();
```
3.	Add <br>
```
set.add("Apple"); 
set.add("Banana"); 
set.add("Cherry");
```
5.	Removing Elements (remove())<br>
```
set.remove("Banana");
```
7.	Checking if an Element Exists (contains())<br>
```
boolean exists = set.contains("Apple");  // true
```
9.	Iterate using foreach<br>
```
set.forEach(System.out::println);
```
11.	Clearing a Set (clear())<br>
```
set.clear();  // Removes all elements
```
13.	Checking if Set is Empty (isEmpty())<br>
```
boolean empty = set.isEmpty();  // true if set is empty
```
15.	Adding All Elements from Another Collection (addAll())<br>
```
Set<String> set2 = new HashSet<>(List.of("Mango", "Orange"));
set.addAll(set2);
```
9.	Removing All Elements (removeAll())<br>
```
set.removeAll(set2);  // Removes all elements in set2 from set
```
11.	Retaining Common Elements (retainAll())<br>
```
set.retainAll(Set.of("Apple", "Mango"));  // Keeps only these elements
```
13.	Covert to list<br>
```
List<String> list = new ArrayList<>(set);
```

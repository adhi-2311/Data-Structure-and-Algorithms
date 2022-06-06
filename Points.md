- hm.keySet() would return a set of all keys in hashmap. Use it to your advantage for easy iteration.
- Default ordering of priority queue in java is minHeap.
- Queue<Integer> maxHeap = new PriorityQueue<>((a,b) ->b-a)
  
- ``` Collections.binarySearch ``` returns index of an element in a list if it's present there,
  or (-(position where the element would be inserted) - 1) if the element is not in the list.
  You can just regard negative result as element missing in a list
``` 
List<Integer> list = Arrays.asList(5, 7, 9, 13, 17, 22);
System.out.println(Collections.binarySearch(list, 13)); // prints 3
System.out.println(Collections.binarySearch(list, 15)); // -5
System.out.println(Collections.binarySearch(list, 22)); // 5
System.out.println(Collections.binarySearch(list, 5));  // 0
 ```

- [Java Collections Time Complexity](https://www.baeldung.com/java-collections-complexity)

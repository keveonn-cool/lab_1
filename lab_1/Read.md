# Search Algorithm
Author: Gopal Sharma 

## Question - 1 
Implemented as per the instructions


## Question - 2 - Compare their running times and show them. Which one performed better and why?
1) Faster convergence: Interpolation search calculates the probable position of the target element based on the values at the ends of the array. It uses this information to make a more informed guess about where the target element is likely to be. This allows for faster convergence towards the target element, especially when the elements are uniformly distributed.

2) Effective for sorted arrays: Interpolation search requires the array to be sorted in ascending order, but if the array is already sorted, it can exploit this property to quickly locate the target element. On the other hand, linear search has to examine every element in the array sequentially, regardless of the order.



## Question - 3 - Try to improve the running time of the linear search by at least 20% and explain your logic.
The existing Linear search algorithm is improved by approximately 89.71 using following approaches:
1) The given array is sorted first.
2) The sorted data is then divided in two parts using binary algorithm and then resultant array is further processed using linear search algorithm.



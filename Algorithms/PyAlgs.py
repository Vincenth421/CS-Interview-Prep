import random

#Sorting algorithms

#Classic mergesort - DONE
def mergesort(arr):

    #merge helper function
    def merge(a, b):
        #variables to keep track of where in a and b we are
        ai = 0
        bi = 0

        #resulting array to add to
        res = []

        #while indices in bounds of both arrays
        while ai < len(a) and bi < len(b):

            #if element in a is less than or equal to b, put that in the array first
            if a[ai] <= b[bi]:
                res.append(a[ai])
                ai = ai + 1
            else:
                res.append(b[bi])
                bi = bi + 1

        #clean up unseen elements
        while ai < len(a):
            res.append(a[ai])
            ai = ai + 1

        while bi < len(b):
            res.append(b[bi])
            bi = bi + 1

        return res

    #split array into halves
    a = arr[0:len(arr) // 2]
    b = arr[len(arr) // 2:]

    #if any half has more than 1 element, recursively sort it
    if len(a) > 1:
        a = mergesort(a)

    if len(b) > 1:
        b = mergesort(b)

    #merge now sorted a and b, return result
    return merge(a, b)

#Quicksort - DONE
def quicksort(arr, low, high):

    #helper method using Lomuto Partitioning
    def partition(arr, low, high):
        #Pivot is always the last item
        pivot = arr[high]

        #start tracker at low index
        j = low

        #only partition for set boundaries
        for i in range(low, high):

            #if current item is less than pivot, put on left side
            if arr[i] < pivot:
                temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp

                j = j + 1

        #swap pivot to the middle
        arr[high] = arr[j]
        arr[j] = pivot

        #return the new pivot index
        return j

    #if partition needs to be done, partition
    if low < high:
        part = partition(arr, low, high)

        quicksort(arr, low, part - 1)
        quicksort(arr, part + 1, high)

    return arr

#Quickselect: efficiently get the kth smallest elt. in unsorted array.
#Useful for better quicksort
def quickselect(arr, k):
    #less, equal to, and greater than arrays
    sl = []
    sv = []
    sr = []

    v = random.choice(arr)

    #add elements into their respective arrays
    for x in arr:
        if x < v:
            sl.append(x)
        elif x == v:
            sv.append(x)
        else:
            sr.append(x)

    #if kth smallest is still in sl, recurse on sl
    if k <= len(sl):
        return quickselect(sl, k)

    #if kth smallest is greater than sl but within sv and sl, return v
    elif len(sl) < k and k <= len(sv) + len(sl):
        return v

    #if kth smallest is in greater than array, recurse on sr, modifying k
    elif k > len(sl) + len(sv):
        return quickselect(sr, k - len(sl) - len(sv))

#Graph algorithms

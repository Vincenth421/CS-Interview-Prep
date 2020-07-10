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

#Quicksort
def quicksort(arr):

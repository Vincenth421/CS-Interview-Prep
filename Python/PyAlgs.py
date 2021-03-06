###Sorting algorithms

#Classic mergesort - DONE
def mergesort(arr):

    if len(arr) == 0:
        return

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

    if len(arr) == 0:
        return

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
    if len(arr) == 0:
        return

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

###Graph algorithms
#All graphs here are assumed to be represented in an nxn matrix form, where n is the number of vertices.

#Standard BFS
def BFS(G, s):

    if len(G) == 0:
        return

    #queue for bfs
    queue = []

    #checking if vertices are visited
    visited = [False] * len(G[0])

    #put source node in queue and visited
    queue.append(s)
    visited[s] = True

    #keep visiting unvisited vertices
    while not len(queue) == 0:

        #dequeue next node
        v = queue.pop(0)

        #put whatever functions here
        print(v)

        #view neighbors
        for i in range(len(G[v])):

            #for every unvisited neighbor, add to queue and visit them.
            if G[v][i] == 1 and not visited[i]:
                #queue vertex and visit
                queue.append(i)
                visited[i] = True

#Standard DFS. The explore function recursively does DFS on the graph. - DONE
def DFS(G):

    #explore helper function
    def explore(G, s, visited):
        visited[s] = True

        #previsit function
        print(s)

        #for every neighbor of s, explore them if they are unvisited
        for vert in range(len(G[s])):
            if G[s][vert] == 1 and not visited[vert]:
                explore(G, vert, visited)

        #postvisit function here

    if len(G) == 0:
        return

    visited = [False] * len(G)

    for vert in range(len(G[0])):
        if not visited[vert]:
            explore(G, vert, visited)

#Strongly connected components function. Returns a list of lists, where each SCC is a list of vertices in the SCC. - DONE
def SCC(G):

    #reuse DFS explore function, but add stack and a connected components list. Both are None by default, we only add to them if needed.
    def explore(G, s, visited, stk=None, cc=None):
        #mark s as visited and append to stack
        visited[s] = True

        #if we pass in cc and call this function, we know that s is in the cc.
        if cc != None:
            cc.append(s)

        #previsit function

        #for every neighbor of s, explore them if they are unvisited
        for vert in range(len(G[s])):
            if G[s][vert] == 1 and not visited[vert]:
                explore(G, vert, visited, stk, cc)

        #postvisit function

        #when we are done exploring the neighbors, add s to the stack.
        if stk != None:
            stk.append(s)

    #initialize scc list.
    sccs = []

    #if graph is empty, return empty list
    if len(G) == 0:
        return sccs

    #init stack and visited list
    stack = []
    visited = [False] * len(G)

    #run DFS with new explore function
    for vert in range(len(G[0])):
        if not visited[vert]:
            explore(G, vert, visited, stk=stack)

    #reverse the graph
    G_reverse = [[G[j][i] for j in range(len(G))] for i in range(len(G[0]))]

    #reset the visited array
    visited = [False] * len(G)

    #iterate through the entire stack
    while not len(stack) == 0:
        #get the next vertex
        v = stack.pop()

        #if we haven't visited the vertex, create a new temp list to store the SCC vertices, explore the vertex, and append the SCC vertices to the overall list.
        if not visited[v]:
            temp = []
            explore(G_reverse, v, visited, cc=temp)
            sccs.append(temp)

    return sccs

#Graph G is an nxn matrix, where G[i][j] indicates the length of an edge between i and j. A value of 0 means there is no edge. - DONE
def Dijkstras(G, s):
    if len(G) == 0:
        return []

    #initialize lists to use
    queue = []
    dist = []

    #initialize each distance to a large value
    for vertex in range(len(G)):
        queue.append(vertex)
        dist.append(10000000000)

    #set source vertex distance to 0
    dist[s] = 0

    #iterate until queue is empty
    while len(queue) != 0:
        #initialize the minimum distance to the max distance + 1
        min_dist = max(dist) + 1
        min_vertex = 0

        #for every vertex that is in the queue, find the smallest one
        for vert in queue:
            if dist[vert] < min_dist:
                min_dist = dist[vert]
                min_vertex = vert

        #remove it from the queue
        queue.remove(min_vertex)

        #for each neighbor of min_vertex, calculate new distances
        for vert in range(len(G[vertex])):

            #only calculate if there is an edge
            if G[min_vertex][vert] > 0:

                #distance of edge from min_vertex to a neighbor
                vv_dist = G[min_vertex][vert]

                #if the distance to min_vertex + the edge to neighbor is smaller than the current distance to the neighbor, update distance to the neighbor.
                if dist[min_vertex] + vv_dist < dist[vert]:
                    dist[vert] = dist[min_vertex] + vv_dist

    return dist

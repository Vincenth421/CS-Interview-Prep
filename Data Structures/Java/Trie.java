class Trie {
     TrieNode trie;

     /** Initialize your data structure here. */
     public Trie() {
          trie = new TrieNode();
     }

     /** Inserts a word into the trie. */
     public void insert(String word) {

          //use pointer node
          TrieNode pCrawl = trie;

          //go through word letter by letter, "levels" in a trie
          for (int level = 0; level < word.length(); level++)
          {
               //get the index of current letter
               int index = (int) word.charAt(level) - 'a';

               //if there is no node at index, make a new node
               if (pCrawl.children[index] == null) pCrawl.children[index] = new TrieNode();

               //advance pointer to next letter node
               pCrawl = pCrawl.children[index];
          }

          // mark last node as end of the word
          pCrawl.end = true;
     }

     /** Returns if the word is in the trie. */
     public boolean search(String word) {

          //use pointer
          TrieNode pCrawl = trie;

          //go through word letter by letter, "levels" in a trie
          for (int level = 0; level < word.length(); level++)
          {
               //get the index
               int index = (int) word.charAt(level) - 'a';

               //if the letter doesn't exist in the children, the word isn't in the trie, so return false
               if (pCrawl.children[index] == null) return false;

               //go to next node
               pCrawl = pCrawl.children[index];
          }

          //return last node exists and is an end of a word
          return (pCrawl != null && pCrawl.end);
     }

     /** Returns if there is any word in the trie that starts with the given prefix. */
     public boolean startsWith(String prefix) {

          //use pointer
          TrieNode pCrawl = trie;

          //go through word letter by letter, "levels" in a trie
          for (int level = 0; level < prefix.length; level++)
          {
               int index = (int) prefix.charAt(level) - 'a';

               //if letter doesn't exist, prefix isn't in the trie, so return false
               if (pCrawl.children[index] == null) return false;

               //go to next letter node
               pCrawl = pCrawl.children[index];
          }

          //if last letter exists, then the prefix is in the trie
          return pCrawl != null;
     }

     private class TrieNode
     {
          //all the children of current node
          TrieNode[] children;

          //indicates if this node is the end of a word
          boolean end;

          public TrieNode()
          {
               children = new TrieNode[26];

               //node is not an end by default
               end = false;

               //initialize all children to null
               for(int i = 0; i < children.length; i++)
               {
                    children[i] = null;
               }
          }
     }
}

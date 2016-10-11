;; gorilla-repl.fileformat = 1

;; **
;;; Below are solutions to most of the non-utterly-trivial programming problems posted at 4clojure.com. You can find me as user jomicoll on the website.
;; **

;; @@
;;Difficulty:	Easy
;;Topics:	seqs

(defn pen [coll] ((comp first next reverse) coll))

;;Write a function which returns the second to last element from a sequence.
(= (pen (list 1 2 3 4 5)) 4)
(= (pen ["a" "b" "c"]) "b")
(= (pen [[1 2] [3 4]]) [1 2])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Difficulty:	Easy
;;Topics:	seqs core-functions

(defn nth* [coll n]
  (if (= n 0) (first coll) (recur (next coll) (dec n))))

;; Write a function which returns the Nth element from a sequence.
(= (nth* '(4 5 6 7) 2) 6)
(= (nth* [:a :b :c] 0) :a)
(= (nth* [1 2 3 4] 1) 2)
(= (nth* '([1 2] [3 4] [5 6]) 2) [5 6])
(= (nth* '([1 2] [3 4] [5 6]) 2) [5 6])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Difficulty:	Easy
;; Topics:	seqs core-functions

(defn cnt [coll]
  (letfn [(mycount [coll cnt]
                (if (empty? coll)
                  cnt
                  (recur (next coll) (inc cnt))))]
    (mycount coll 0)))

;; Write a function which returns the total number of elements in a sequence.
(= (cnt '(1 2 3 3 1)) 5)
(= (cnt "Hello World") 11)
(= (cnt [[1 2] [3 4] [5 6]]) 3)
(= (cnt '(13)) 1)
(= (cnt '(:a :b :c)) 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@

;;Difficulty:	Easy
;; Topics:	seqs

(def sum (partial reduce +))

;;Write a function which returns the sum of a sequence of numbers.
(= (sum [1 2 3]) 6)
(= (sum (list 0 -2 5 5)) 8)
(= (sum #{4 2 1}) 7)
(= (sum '(0 0 -1)) -1)
(= (sum '(1 10 3)) 14)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Difficulty:	Easy
;; Topics:	seqs

(def odd (partial filter odd?))

;; Write a function which returns only the odd numbers from a sequence.
(= (odd #{1 2 3 4 5}) '(1 3 5))
(= (odd [4 2 1 6]) '(1))
(= (odd [2 2 4 6]) '())
(= (odd [1 1 1 3]) '(1 1 1 3))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Reverse a Sequence
;;Difficulty:	Easy
;;Topics:	seqs core-functions

(defn rev [coll] 
  (apply conj nil coll))

;;Write a function which reverses a sequence.
(= (rev [1 2 3 4 5]) [5 4 3 2 1])
(= (rev (sorted-set 5 7 2 7)) '(7 5 2))
(= (rev [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Palindrome Detector
;;Difficulty:	Easy
;;Topics:	seqs

;;Write a function which returns true if the given sequence is a palindrome.

;;Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

(def pal #(= (seq %1) (reverse %1)))

(false? (pal '(1 2 3 4 5)))
(true?  (pal "racecar"))
(true?  (pal [:foo :bar :foo]))
(true?  (pal '(1 1 3 3 1 1)))
(false? (pal '(:a :b :c)))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Fibonacci Sequence
;;Difficulty:	Easy
;;Topics:	Fibonacci seqs

(defn fib [n]
  (letfn [(fibs []
                ((fn next-fib [a b]
                   (cons a (lazy-seq (next-fib b (+ a b)))))
                 0 1))]
    (take n (next (fibs)))))

;;Write a function which returns the first X fibonacci numbers.
(= (fib 3) '(1 1 2))
(= (fib 6) '(1 1 2 3 5 8))
(= (fib 8) '(1 1 2 3 5 8 13 21))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Maximum value
;;Difficulty:	Easy
;;Topics:	core-functions


;;Write a function which takes a variable number of parameters and returns the maximum value.

(defn max* [& coll]
  (reduce (fn [res x]
            (if (> x res)
              x
              res))
          (first coll)
          (next coll)))


(= (max* 1 8 3 4) 8)
(= (max* 30 20) 30)
(= (max* 45 67 11) 67)
(= (max* 45 67 11) 67)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Get the Caps
;; Difficulty:	Easy
;; Topics:	strings

;; Write a function which takes a string and returns a new string containing only the capital letters.

(defn caps [s] (apply str (filter #(Character/isUpperCase %) s)))


(= (caps "HeLlO, WoRlD!") "HLOWRD")
(empty? (caps "nothing"))
(= (caps "$#A(*&987Zf") "AZ")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Duplicate a Sequence
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which duplicates each element of a sequence.

(defn dup [coll] (apply concat (map (fn [a b] (list a b)) coll coll)))


(= (dup [1 2 3]) '(1 1 2 2 3 3))
(= (dup [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (dup [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (dup [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Intro to some
;; Difficulty:	Easy
;; Topics:	


;; The some function takes a predicate function and a collection. It returns the first logical 
;; true value of (predicate x) where x is an item in the collection.

(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Implement range
;; Difficulty:	Easy
;; Topics:	seqs core-functions

(defn range* [start end]
  (lazy-seq 
    (if (>= start end) ni
      (cons start (range* (inc start) end)))))

;; Write a function which creates a list of all integers in a given range.


(= (range* 1 4) '(1 2 3))
(= (range* -2 2) '(-2 -1 0 1))
(= (range* 5 8) '(5 6 7))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Compress a Sequence
;; Difficulty:	Easy
;; Topics:	seqs

;;Write a function which removes consecutive duplicates from a sequence.

(defn compress [coll] 
  (reduce (fn [res x]         
            (if (= (peek res) x)       
              res
              (conj res x)))
          []
          coll))

(= (apply str (compress "Leeeeeerrroyyy")) "Leroy")
(= (compress [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (compress [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Factorial FunSolutions
;; Difficulty:	Easy
;; Topics:	math

;; Write a function which calculates factorials.

(defn fac [n]
  (reduce * (range 1 (inc n))))

(= (fac 1) 1)
(= (fac 3) 6)
(= (fac 5) 120)
(= (fac 8) 40320)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Interleave Two Seqs
;; Difficulty:	Easy
;; Topics:	seqs core-functions

;;Write a function which takes two sequences and returns the first item from each, then the
;;second item from each, then the third, etc.

(defn interleave* [coll1 coll2] 
  (apply concat (map list coll1 coll2)))

(= (interleave* [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (interleave* [1 2] [3 4 5 6]) '(1 3 2 4))
(= (interleave* [1 2 3 4] [5]) [1 5])
(= (interleave* [30 20] [25 15]) [30 25 20 15])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Flatten a SequenceSolutions
;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Write a function which flattens a sequence.

(defn flat [coll]
  (lazy-seq 
    (if (sequential? coll)
      (apply concat (map flat coll))
      (list coll))))

(= (flat '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (flat ["a" ["b"] "c"]) '("a" "b" "c"))
(= (flat '((((:a))))) '(:a))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Replicate a Sequence
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which replicates each element of a sequence a variable number of times.

(defn rep [coll n] 
  (mapcat (partial repeat n) coll))

(= (rep [1 2 3] 2) '(1 1 2 2 3 3))
(= (rep [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (rep [4 5 6] 1) '(4 5 6))
(= (rep [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (rep [44 33] 2) [44 44 33 33])

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Difficulty:	Easy
;; Topics:	seqs


;; The iterate function can be used to produce an infinite lazy sequence.
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Contain Yourself
;; Difficulty:	Easy
;; Topics:	

(def sol 4)

;;The contains? function checks if a KEY is present in a given collection. This often leads beginner 
;; clojurians to use it incorrectly with numerically indexed collections like vectors and lists.


(contains? #{4 5 6} sol)
(contains? [1 1 1 1 1] sol)
(contains? {4 :a 2 :b} sol)
(not (contains? [1 2 4] sol))



;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Interpose a Seq
;; Difficulty:	Easy
;; Topics:	seqs core-functions


;; Write a function which separates the items of a sequence by an arbitrary value.

(defn ipose [x coll]
  (lazy-seq 
    (if (empty? (rest coll))
      (if (first coll) (list (first coll)) nil)
      (cons (first coll) (cons x (ipose x (rest coll)))))))

(= (ipose 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (ipose ", " ["one" "two" "three"])) "one, two, three")
(= (ipose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
(= (ipose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Pack a Sequence
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which packs consecutive duplicates into sub-lists.

(def pack (partial partition-by identity))

(= (pack [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (pack [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (pack [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Drop Every Nth Item
;; Difficulty:	Easy
;; Topics:	seqs

;;Write a function which drops every Nth item from a sequence.

(defn drop-nth [coll n]
  (apply concat (partition (dec n) n [] coll)))

(= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (drop-nth [:a :b :c :d :e :f] 2) [:a :c :e])
(= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])



;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Split a sequence
;; Difficulty:	Easy
;; Topics:	seqs core-functions

(defn split [n coll]
  (list (take n coll) (drop n coll)))

;;Write a function which will split a sequence into two parts.
(= (split 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
(= (split 1 [:a :b :c :d]) [[:a] [:b :c :d]])
(= (split 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Advanced Destructuring
;; Difficulty:	Easy
;; Topics:	destructuring

;; Here is an example of some more sophisticated destructuring.

(def sol [1 2 3 4 5])

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] sol] [a b c d]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Map Construction
;;Difficulty:	Easy
;;Topics:	core-functions

;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.

(defn to-map [ks vs]
  (into {} (map vector ks vs)))

(= (to-map [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
(= (to-map [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
(= (to-map [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Greatest Common Divisor
;;;Difficulty:	Easy
;;Topics:	

;;Given two integers, write a function which returns the greatest common divisor.

(defn gcd [x y]
  (reduce (fn [gcd n]
            (if (and (zero? (mod x n)) 
                     (zero? (mod y n)))
              n
              gcd))
          (range 1 (inc (min x y)))))

(= (gcd 2 4) 2)
(= (gcd 10 5) 5)
(= (gcd 5 7) 1)
(= (gcd 1023 858) 33)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Set Intersection
;; Difficulty:	Easy
;; Topics:	set-theory


;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.

(defn intersection [set1 set2]
  (set (filter set1 set2)))

(= (intersection #{0 1 2 3} #{2 3 4 5}) #{2 3})
(= (intersection #{0 1 2} #{3 4 5}) #{})
(= (intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Comparisons
;; Difficulty:	Easy
;; Topics:

;; For any orderable data type it's possible to derive all of the basic comparison operations (<, ≤, =, ≠, ≥, and >) 
;; from a single operation (any operator but = or ≠ will work). Write a function that takes three arguments, a less 
;; than operator for the data and two items to compare. The function should return a keyword describing the relationship 
;; between the two items. The keywords for the relationship between x and y are as follows:
;; x = y → :eq
;; x > y → :gt
;l x < y → :lt


(defn cmp [cmp x y]
  (cond (and  (not (cmp x y))
              (not (cmp y x)))
   
        :eq
   
        (cmp y x)
        :gt
   
        :else
        :lt))

(= :gt (cmp < 5 1))
(= :eq (cmp (fn [x y] (< (count x) (count y))) "pear" "plum"))
(= :lt (cmp (fn [x y] (< (mod x 5) (mod y 5))) 21 3))
(= :gt (cmp > 0 2))
 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Re-implement IterateSolutions
;; Difficulty:	Easy
;; Topics:	seqs core-functions


;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.

(defn iter [f x]
  (lazy-seq (cons x (iter f (f x)))))

(= (take 5 (iter #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 (iter inc 0)) (take 100 (range)))
(= (take 9 (iter #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Simple closures
;; Difficulty:	Easy
;; Topics:	higher-order-functions math


;; Lexical scope and first-class functions are two of the most basic building blocks of a functional language 
;; like Clojure. When you combine the two together, you get something very powerful called lexical closures. With 
;; these, you can exercise a great deal of control over the lifetime of your local bindings, saving their values
;; for use later, long after the code you're running now has finished.

;; It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer n, return a
;; function (f x) which computes xn. Observe that the effect of this is to preserve the value of n for use outside 
;; the scope in which it is defined.

(def closure 
  (fn [n]
    (fn [x]
      (reduce * (repeat n x)))))


(= 256 ((closure 2) 16),
       ((closure 8) 2))
(= [1 8 27 64] (map (closure 3) [1 2 3 4]))
(= [1 2 4 8 16] (map #((closure %) 2) [0 1 2 3 4]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Cartesian Product
;; Difficulty:	Easy
;; Topics:	set-theory

;;Write a function which calculates the Cartesian product of two sets.

(defn cp [a b]
  (into #{}
        (for [x a
              y b]
          [x y])))


(= (cp #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= (cp #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (cp (into #{} (range 10))
                  (into #{} (range 30)))))

(= 300 (count (cp (into #{} (range 10))
                  (into #{} (range 30)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Group a Sequence
;; Difficulty:	Easy
;; Topics:	core-functions


;; Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f applied 
;; to each item in s. The value at each key should be a vector of corresponding items in the order they appear in s.


(defn group-by* [f coll]
  (reduce (fn [ret x]
            (update ret (f x) #(conj (or % []) x)))
          {}
          coll))

(= (group-by* #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
(= (group-by* #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (group-by* count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Symmetric Difference
;;Difficulty:	Easy
;;Topics:	set-theory

;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items 
;; belonging to one but not both of the two sets.


(defn sym-diff [s1 s2]
  (clojure.set/union
   (clojure.set/difference s1 s2)
   (clojure.set/difference s2 s1)))

(= (sym-diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (sym-diff #{:a :b :c} #{}) #{:a :b :c})
(= (sym-diff #{} #{4 5 6}) #{4 5 6})
(= (sym-diff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Read a binary number
;;Difficulty:	Easy
;;Topics:	

;;Convert a binary number, provided in the form of a string, to its numerical value.

;; Hacks
(defn read-binary [s] (read-string (str "2r" s)))


(= 0     (read-binary "0"))
(= 7     (read-binary "111"))
(= 8     (read-binary "1000"))
(= 9     (read-binary "1001"))
(= 255   (read-binary "11111111"))
(= 1365  (read-binary "10101010101"))
(= 65535 (read-binary "1111111111111111"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Infix Calculator
;; Difficulty:	Easy
;; Topics:	higher-order-functions math


;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily 
;; write a function that does math using the infix notation. Is your favorite language that flexible, Joe? Write a 
;; function that accepts a variable length mathematical expression consisting of numbers and the operations +, -, *, 
;; and /. Assume a simple calculator that does not do precedence and instead just calculates left to right.

(defn f 
  ([x] x)
  ([x o y & expr]
   (apply f (o x y) expr)))

(= 7  (f 2 + 5))
(= 42 (f 38 + 48 - 2 / 2))
(= 8  (f 10 / 2 - 1 * 2))
(= 72 (f 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Indexing Sequences
;; Difficulty:	Easy
;; Topics:	seqs


;; Transform a sequence into a sequence of pairs containing the original elements along with their index.

(defn indexed [coll]
  (map vector coll (range)))

(= (indexed [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
(= (indexed [0 1 3]) '((0 0) (1 1) (3 2)))
(= (indexed [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Re-implement MapSolutions
;; Difficulty:	Easy
;; Topics:	core-seqs


;; Map is one of the core elements of a functional programming language. Given a function f and an input sequence 
;; s, return a lazy sequence of (f x) for each element x in s.

(defn map* [f coll]
  (lazy-seq
   (when-not (empty? coll)
    (cons (f (first coll)) (map* f (rest coll))))))

(= [3 4 5 6 7]
   (map* inc [2 3 4 5 6]))
(= (repeat 10 nil)
   (map* (fn [_] nil) (range 10)))
(= [1000000 1000001]
   (->> (map* inc (range))
        (drop (dec 1000000))
        (take 2)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Sum of square of digits
;; Difficulty:	Easy
;; Topics:	math


;; Write a function which takes a collection of integers as an argument. Return the count of how many elements are 
;; smaller than the sum of their squared component digits. For example: 10 is larger than 1 squared plus 0 squared; 
;; whereas 15 is smaller than 1 squared plus 5 squared.

(defn sum-of-squares [coll]
  (letfn [(ss 
            ([n] (ss n 0))
            ([n ret]
              (let [r (rem n 10)
                    ret (+ ret (* r r))]
                (if (< n 10) ret
                  (recur (quot n 10) ret)))))]         
    (count (filter (fn [n] (< n (ss n))) coll))))


(= 8 (sum-of-squares  (range 10)))
(= 19 (sum-of-squares (range 30)))
(= 50 (sum-of-squares (range 100)))
(= 50 (sum-of-squares (range 1000)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Intro to Destructuring 2
;; Difficulty:	Easy
;; Topics:	Destructuring


;; Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): 
;; (let [bindings* ] exprs*) Complete the bindings so all let-parts evaluate to 3.

(= 3
  (let [[f xs] [+ (range 3)]] (apply f xs))
  (let [[[f xs] b] [[+ 1] 2]] (f xs b))
  (let [[f xs] [inc 2]] (f xs)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Trees into tables
;; Difficulty:	Easy
;; Topics:	seqs maps


;; Because Clojure's for macro allows you to "walk" over multiple sequences in a nested fashion, it is excellent for 
;; transforming all sorts of sequences. If you don't want a sequence as your final output (say you want a map), you 
;; are often still best-off using for, because you can produce a sequence and feed it into a map, for example.

;; For this problem, your goal is to "flatten" a map of hashmaps. Each key in your output map should be the "path"
;; that you would have to take in the original map to get to a value, so for example {1 {2 3}} should result in {[1 2] 3}. 
;; You only need to flatten one level of maps: if one of the values is a map, just leave it alone.

;;1 That is, (get-in original [k1 k2]) should be the same as (get result [k1 k2])

(defn tree-to-table [m]
  (into {}
        (for [[k v] m
              [k2 v2] v]
          [[k k2] v2])))


(= (tree-to-table 
     '{a {p 1, q 2}
       b {m 3, n 4}})
     '{[a p] 1, [a q] 2
     [b m] 3, [b n] 4})
(= (tree-to-table 
     '{[1] {a b c d}
       [2] {q r s t u v w x}})
     '{[[1] a] b, [[1] c] d,
     [[2] q] r, [[2] s] t,
     [[2] u] v, [[2] w] x})
(= (tree-to-table 
     '{m {1 [a b c] 3 nil}})
     '{[m 1] [a b c], [m 3] nil})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Balancing Brackets
;; Difficulty:	Medium
;; Topics:	parsing


;; When parsing a snippet of code it's often a good idea to do a sanity check to see if all the brackets match up. Write a 
;; function that takes in a string and returns truthy if all square [ ] round ( ) and curly { } brackets are properly 
;; paired and legally nested, or returns falsey otherwise.

(defn balanced? [s]
  (let [cleaned (filter #{\[ \] \( \) \{ \}} s)
        close->open {\] \[ 
                     \) \( 
                     \} \{}]
    (empty? (reduce (fn [stack x]
                       (if-let [opp (close->open x)]
                         (if (or (empty? stack)
                                 (not= (peek stack) opp))
                           (reduced [:not-empty])
                           (pop stack))
                         (conj stack x)))
                     []
                     cleaned))))

(balanced? "This string has no brackets.")

(balanced? "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")

(not (balanced? "(start, end]"))

(not (balanced? "())"))

(not (balanced? "[ { ] } "))

(balanced? "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")

(not (balanced? "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))

(not (balanced? "["))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Decurry
;; Difficulty:	Medium
;; Topics:	partial-functions


;; Write a function that accepts a curried function of unknown arity n. Return an equivalent 
;; function of n arguments. 


(defn decurry [curried-fn]
  (fn [& args]
    (reduce (fn [f arg] (f arg)) curried-fn args)))

(= 10 ((decurry 
         (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (+ a b c d))))))
       1 2 3 4))

(= 24 ((decurry
           (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (* a b c d))))))
       1 2 3 4))

(= 25 ((decurry
           (fn [a]
             (fn [b]
               (* a b))))
       5 5))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Prime Numbers
;; Difficulty:	Medium
;; Topics:	primes


;; Write a function which returns the first x number of prime numbers.

(defn primes [n]
  (take n 
        (mapcat #(loop [i 2]      
                   (if (= i %) (list %)      
                     (when (> (mod % i) 0)
                       (recur (inc i)))))
                (iterate inc 2))))

(= (primes 2) [2 3])

(= (primes 5) [2 3 5 7 11])

(= (last (primes 100)) 541)



;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Rotate a Sequence
;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function which can rotate a sequence in either direction.

(defn rotate [n coll]  
  (let [idx (mod n (count coll))]
     (concat (drop idx coll) (take idx coll))))

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= (rotate 1 '(:a :b :c)) '(:b :c :a))

(= (rotate -4 '(:a :b :c)) '(:c :a :b))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Reverse Interleave
;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function which reverses the interleave process into x number of subsequences.

(defn f [coll n]
  (apply map list (partition n coll)))

(= (f [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= (f (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= (f (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
(= (f (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Split by Type
;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function which takes a sequence consisting of items with different types and splits them up into a 
;; set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the
;; sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).

(defn split-by-type [coll] (vals (group-by type coll)))

(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Sequence of pronunciations
;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function that returns a lazy sequence of "pronunciations" of a sequence of numbers. A pronunciation of 
;; each element in the sequence consists of the number of repeating identical numbers and the number itself. For
;; example, [1 1] is pronounced as [2 1] ("two ones"), which in turn is pronounced as [1 2 1 1] ("one two, one one").

;; Your function should accept an initial sequence of numbers, and return an infinite lazy sequence of pronunciations, 
;; each element being a pronunciation of the previous element.

(defn pronounce [coll]
  (letfn [(gen-next
            [coll]
            (->> coll
                 (partition-by identity)
                 (mapcat (fn [coll]
                           [(count coll) (first coll)]))))]
    (iterate gen-next (gen-next coll))))


(= [[1 1] [2 1] [1 2 1 1]] (take 3 (pronounce [1])))

(= [3 1 2 4] (first (pronounce [1 1 1 4 4])))

(= [1 1 1 3 2 1 3 2 1 1] (nth (pronounce [1]) 6))

(= 338 (count (nth (pronounce [3 2]) 15)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Partially Flatten a Sequence
;; Difficulty:	Medium
;; Topics:	seqs


;; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.), but maintains 
;; the lowest level sequential items. The result should be a sequence of sequences with only one level of nesting.

(defn almost-flatten [coll]
  (lazy-seq
    (if-not (sequential? (first coll))
      (conj (empty coll) coll)
      (mapcat almost-flatten coll))))

(= (almost-flatten [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])

(= (almost-flatten [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])

(= (almost-flatten '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Sequs Horribilis
;; Difficulty:	Medium
;; Topics:	seqs


;; Create a function which takes an integer and a nested collection of integers as arguments. Analyze the elements of the 
;; input collection and return a sequence which maintains the nested structure, and which includes all elements starting 
;; from the head whose sum is less than or equal to the input integer.

;; Sadly seeems to be horrendously dificult to preserve 
;; arbitrarily nested collection types.
(defn sequs-horribilis [n coll]
  (letfn [(walk 
            [sum ret coll]
            (let [x (first coll)]
              (cond
                (or (empty? coll)
                    (and (number? x)
                         (> (+ sum x) n))) 
                [sum ret]
                
                (number? x)
                (recur (+ sum x)
                       (conj ret x)
                       (next coll))
                 
                :else
                (let [[new-sum result] (walk sum [] x)]
                  (recur new-sum
                         (conj ret result)
                         (next coll))))))]
    (second (walk 0 [] coll))))

(=  (sequs-horribilis 10 [1 2 [3 [4 5] 6] 7])
   '(1 2 (3 (4))))

(=  (sequs-horribilis 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
   '(1 2 (3 (4 (5 (6 (7)))))))

(=  (sequs-horribilis 9 (range))
   '(0 1 2 3))

(=  (sequs-horribilis 1 [[[[[1]]]]])
   '(((((1))))))
(=  (sequs-horribilis 1 [[[[[1]]]]])
   '(((((1))))))

(=  (sequs-horribilis 0 [1 2 [3 [4 5] 6] 7])
   '())

(=  (sequs-horribilis 0 [0 0 [0 [0]]])
   '(0 0 (0 (0))))

(=  (sequs-horribilis 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
   '(-10 (1 (2 3 (4)))))







;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Generating k-combinations
;; Difficulty:	Medium
;; Topics:	seqs combinatorics


;; Given a sequence S consisting of n elements generate all k-combinations of S, i. e. generate all possible sets 
;; consisting of k distinct elements taken from S. The number of k-combinations for a sequence is equal to the binomial 
;; coefficient.

(defn combinations
  [k coll]
  (letfn [(comb-aux
	       [m start]
	       (if (= 1 m)
	         (for [x (range start (count coll))]
	           (list x))
	         (for [x (range start (count coll))
		           xs (comb-aux (dec m) (inc x))]
	           (cons x xs))))]
    (let [indices (comb-aux k 0)
          coll (vec coll)]
      (into #{} (map (fn [idxs] (into #{} (map coll idxs))) indices)))))

(= (combinations 1 #{4 5 6}) #{#{4} #{5} #{6}})

(= (combinations 10 #{4 5 6}) #{})

(= (combinations 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})

(= (combinations 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                         #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})

(= (combinations 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}})

(= (combinations 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                    #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Count Occurrences
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.

(defn count-occurences [coll]
  (into {}
        (map (fn [[k v]] [k (count v)])
             (group-by identity coll))))

(= (count-occurences [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})

(= (count-occurences [:b :a :b :a :b]) {:a 2, :b 3})

(= (count-occurences '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Find Distinct Items
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.

(defn dedupe* [coll] 
  (loop [found #{}
         result (empty coll)
         curr coll]
    (if (empty? curr)
      (if (list? result) (reverse result) result)
      (if (contains? found (first curr))
        (recur found
               result
               (rest curr))
        (recur (conj found (first curr))
               (conj result (first curr))
               (rest curr))))))

(= (dedupe* [1 2 1 3 1 2 4]) [1 2 3 4])

(= (dedupe* [:a :a :b :b :c :c]) [:a :b :c])

(= (dedupe* '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))

(= (dedupe* (range 50)) (range 50))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Partition a Sequence
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be 
;; returned.

(defn partition* [n coll]
  (let [section (take n coll)]
   (when (= (count section) n) 
     (cons section (partition* n (drop n coll))))))

(= (partition* 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))

(= (partition* 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))

(= (partition* 3 (range 8)) '((0 1 2) (3 4 5)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Sequence Reductions
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must
;; accept either two or three arguments, and the return sequence must be lazy.

(defn reductions*
  ([f coll] (reductions* f (first coll) (rest coll)))
  ([f init coll]
   (lazy-seq 
    (if (empty? coll)
      (list init)
      (cons init
        (reductions* f (f init (first coll)) (rest coll)))))))

(= (take 5 (reductions* + (range))) [0 1 3 6 10])

(= (reductions* conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

(= (last (reductions* * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Insert between two items
;; Difficulty:	Medium
;; Topics:	seqs core-functions


;; Write a function that takes a two-argument predicate, a value, and a collection; and returns a new collection where the 
;; value is inserted between every two items that satisfy the predicate.

(defn insert-between [pred x coll]
  (mapcat (fn [[a b :as xs]]
            (cond (= b :end) [a]
                  (pred a b) [a x]
                  :else [a]))
          (partition 2 1 (concat coll (list :end)))))

(= '(1 :less 6 :less 7 4 3) (insert-between < :less [1 6 7 4 3]))

(= '(2) (insert-between > :more [2]))

(= [0 1 :x 2 :x 3 :x 4]  (insert-between #(and (pos? %) (< % %2)) :x (range 5)))

(empty? (insert-between > :more ()))

(= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
   (take 12 (->> [0 1]
                 (iterate (fn [[a b]] [b (+ a b)]))
                 (map first) ; fibonacci numbers
                 (insert-between 
                   (fn [a b] ; both even or both odd
                       (= (mod a 2) (mod b 2)))
                     :same))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Global take-while
;; Difficulty:	Medium
;; Topics:	seqs higher-order-functions


;; take-while is great for filtering sequences, but it limited: you can only examine a single item of the sequence at a time. What if 
;; you need to keep track of some state as you go over the sequence?

;; Write a function which accepts an integer n, a predicate p, and a sequence. It should return a lazy sequence of items in the list 
;; up to, but not including, the nth item that satisfies the predicate.

(defn global-take-while 
  [n pred coll]
  (lazy-seq 
    (let [[a b] (split-with (comp not pred) coll)
          n (dec n)]
      (concat a (if (== n 0) nil          
                  (cons (first b) 
                        (global-take-while n pred (rest b))))))))


(= [2 3 5 7 11 13]
   (global-take-while 4 #(= 2 (mod % 3))
         [2 3 5 7 11 13 17 19 23]))

(= ["this" "is" "a" "sentence"]
   (global-take-while 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"]))


(= ["this" "is"]
   (global-take-while 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Equivalence Classes
;; Difficulty:	Medium
;; Topics:	


;; A function f defined on a domain D induces an equivalence relation on D, as follows: a is equivalent to b with respect to f if and only 
;; if (f a) is equal to (f b). Write a function with arguments f and D that computes the equivalence classes of D with respect to f.

(def eq-classes (comp set #(map set %) vals group-by))

(= (eq-classes #(* % %) #{-2 -1 0 1 2})
   #{#{0} #{1 -1} #{2 -2}})
(= (eq-classes #(rem % 3) #{0 1 2 3 4 5 })
   #{#{0 3} #{1 4} #{2 5}})
(= (eq-classes identity #{0 1 2 3 4})
   #{#{0} #{1} #{2} #{3} #{4}})
(= (eq-classes (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})
(= (eq-classes (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(defn oscilrate [init & fs]
  (lazy-seq
    (when fs
      (cons init  (apply oscilrate 
                         ((first fs) init)
                         (rest fs))))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/oscilrate</span>","value":"#'user/oscilrate"}
;; <=

;; @@
;; Power Set
;; Difficulty:	Medium
;; Topics:	set-theory


;; Write a function which generates the power set of a given set. The power set of a set x is the set of all subsets of x, including the empty 
;; set and x itself.

(defn power-set [coll]
  (let [n (count coll)
        coll-vec (vec coll)]
    (letfn [(comb-iter 
              [k start]
              (if (== k 1)
                (for [x (range start n)]
                  (list x))
                (for [x  (range start n)
                      xs (comb-iter (dec k) (inc x))]
                  (cons x xs))))]
      (->> (for [k (range (inc n))]
             (comb-iter k 0))
           (map set)
           (mapcat (fn [s] (map #(into #{} (map coll-vec %)) s)))
           (into #{#{}})))))

(= (power-set #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})

(= (power-set #{}) #{#{}})

(= (power-set #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(= (count (power-set (into #{} (range 10)))) 1024)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Word Sorting
;; Difficulty:	Medium
;; Topics:	sorting


;; Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order and punctuation 
;; should be ignored.

(defn word-sorting [s]
  (sort-by (fn [s] (clojure.string/lower-case s))
           (map (fn [s]
                  (clojure.string/replace s #"[^a-zA-Z]+" ""))
                (clojure.string/split s #" "))))

(= (word-sorting  "Have a nice day.")
   ["a" "day" "Have" "nice"])

(= (word-sorting  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])

(= (word-sorting  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; intoCamelCase
;; Difficulty:	Medium
;; Topics:	strings


;; When working with java, you often need to create an object with fieldsLikeThis, but you'd rather work with a hashmap that has :keys-like-this 
;; until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.

(defn to-camel [s]
  (loop [ret []
         s s]
    (cond (empty? s) 
          (apply str ret)
          
          (= (first s) \-)
          (let [x1 (first s)
                x2 (second s)]
            (if (nil? x2)
              (apply str (conj ret x1))
              (recur (conj ret (clojure.string/upper-case x2))
                     (nnext s))))
          
          :else
          (recur (conj ret (first s))
                 (next s)))))

(= (to-camel "something") "something")

(= (to-camel "multi-word-key") "multiWordKey")

(= (to-camel "leaveMeAlone") "leaveMeAlone")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Write Roman Numerals
;; Difficulty:	Medium
;; Topics:	strings math


;; This is the inverse of Problem 92, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral 
;; in uppercase, adhering to the subtractive principle.

(defn roman-numeral [n]
  (let [table [1000 \M 500 \D 100 \C 50 \L 10 \X 5 \V 1 \I]]
    (loop [n n ret [] table table]
      (let [[x0 r0 x1 r1 x2 r2] table]
        (cond (<= n 0) (apply str ret)
                
              (>= n x0)
              (recur (- n x0) (conj ret r0) table)
                
              (or (and (= r0 \L) (>= n (- x0 x1)))
                  (and (= r0 \V) (>= n (- x0 x1))))
              (recur (- n (- x0 x1)) (conj ret r1 r0) (subvec table 2))
                
                
              (and (not (nil? x2)) 
                   (>= n (- x0 x2)))
              (recur (- n (- x0 x2)) (conj ret r2 r0) (subvec table 2))
                
              :else
              (recur n ret (subvec table 2)))))))

(= "I" (roman-numeral 1))

(= "XXX" (roman-numeral 30))

(= "IV" (roman-numeral 4))

(= "CXL" (roman-numeral 140))

(= "DCCCXXVII" (roman-numeral 827))

(= "MMMCMXCIX" (roman-numeral 3999))

(= "XLVIII" (roman-numeral 48))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Oscilrate
;; Difficulty:	Medium
;; Topics:	sequences

;; Write an oscillating iterate: a function that takes an initial value and a variable number of functions. It should return a 
;; lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.

(defn oscilrate [init & fs]
  (letfn [(step
            [init & fs]
            (lazy-seq
              (cons init
                    (when fs
                      (apply oscilrate 
                             ((first fs) init)
                             (rest fs))))))]
    (apply step 
           init 
           (apply concat 
                  (repeat fs)))))

;; Better solution is:
(fn [init & fs]
  (reductions (fn [a f] (reduced (f a))) init (cycle fs)))

;; Reductions takes 


(= (take 3 (oscilrate 3.14 int double)) [3.14 3 3.0])
(= (take 5 (oscilrate 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])
(= (take 12 (oscilrate 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Sum Some Set Subsets
;;Difficulty:	Medium
;;Topics:	math


;;Given a variable number of sets of integers, create a function which returns true iff all of the sets have a non-empty 
;;subset with an equivalent summation.

(defn subset-sum [& colls]
  (let [vecs (mapv vec colls)
        smallest (reduce max (map #(reduce + (filter neg? %)) colls))
        largest (reduce min (map #(reduce + (filter pos? %)) colls))
        subset-sum? (fn [g [x & xs] s] (when x (or (= x s) (g g xs s) (g g xs (- s x)))))
        g (memoize subset-sum?)]
    (boolean (first (for [s (range smallest (inc largest))
                          :when (every? true? (map #(g g % s) vecs))]
                      s)))))


(= true  (subset-sum #{-1 1 99} 
             #{-2 2 888}
             #{-3 3 7777})) ; ex. all sets have a subset which sums to zero

(= false (subset-sum #{1}
             #{2}
             #{3}
             #{4}))

(= true  (subset-sum #{1}))

(= false (subset-sum #{1 -3 51 9} 
             #{0} 
             #{9 2 81 33}))

(= true  (subset-sum #{1 3 5}
             #{9 11 4}
             #{-3 12 3}
             #{-3 4 -2 10}))

(= false (subset-sum #{-1 -2 -3 -4 -5 -6}
             #{1 2 3 4 5 6 7 8 9}))

(= true  (subset-sum #{1 3 5 7}
             #{2 4 6 8}))

(= true  (subset-sum #{-1 3 -5 7 -9 11 -13 15}
             #{1 -3 5 -7 9 -11 13 -15}
             #{1 -1 2 -2 4 -4 8 -8}))

(= true  (subset-sum #{-10 9 -8 7 -6 5 -4 3 -2 1}
             #{10 -9 8 -7 6 -5 4 -3 2 -1}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; The Big Divide
;; Difficulty:	Medium
;; Topics:	math


;; Write a function which calculates the sum of all natural numbers under n (first argument) which are evenly divisible 
;; by at least one of a and b (second and third argument). Numbers a and b are guaranteed to be coprimes.

;; Note: Some test cases have a very large n, so the most obvious solution will exceed the time limit.


(defn big-divide [n a b]
   (let [n (dec n)
         n_a (bigint (/ (- n (rem n a)) a))
         n_b (bigint (/ (- n (rem n b)) b))
         ab  (* a b)
         n_ab (bigint (/ (- n (rem n ab)) ab))]
     (- (+ (* (/ (* n_a (inc n_a)) 2) a)
           (* (/ (* n_b (inc n_b)) 2) b))
        (+ (* (/ (* n_ab (inc n_ab)) 2) ab)))))

(= 0 (big-divide 3 17 11))

(= 23 (big-divide 10 3 5))

(= 233168 (big-divide 1000 3 5))

(= "2333333316666668" (str (big-divide 100000000 3 5)))

(= "110389610389889610389610"
  (str (big-divide (* 10000 10000 10000) 7 11)))

(= "1277732511922987429116"
  (str (big-divide (* 10000 10000 10000) 757 809)))

(= "4530161696788274281"
  (str (big-divide (* 10000 10000 1000) 1597 3571)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Prime Sandwitch
;; Difficulty:	Medium
;; Topics:	math


;; A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence 
;; of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime.

;; My horrible solution.
(defn prime-sandwich? [n]
  (letfn [(binary-search [n x]
            "adapted from:
             http://stackoverflow.com/questions/8949837/binary-
             search-in-clojure-implementation-performance"
            (loop [l 0 h (unchecked-dec n)]
              (if (<= h (inc l))
                (cond
                  (== (* l x) n) l
                  (== (* h x) n) h
                  :else nil)
                (let [m (unchecked-add l (bit-shift-right 
                                    (unchecked-subtract h l) 1))]
                  (if (< (* m x) n)
                    (recur (unchecked-inc m) h)
                    (recur l m))))))
          
          (prime? 
            [n]
            (if (< n 2) false      
              (loop [x 2]
                (cond (> x (/ n 2)) true
                (binary-search n x) false
                :else (recur (unchecked-inc x))))))
          
          (nearest-lesser-prime [n]
            (loop [x (unchecked-dec n)]
              (cond
                (<= x 2) nil
                (prime? x) x
                :else (recur (unchecked-dec x)))))
          
          (nearest-greater-prime 
            [n]
            (loop [x (unchecked-inc n)]
              (if (prime? x) x
                (recur (unchecked-inc x)))))
          
          (prime-sandwitch?* [n]
            (cond
              (== n 0) false
              (== n 1) false
              (== n 2) false
              (== n 3) false
              (not (prime? n)) false
              :else
              (let [x (nearest-lesser-prime n)
                    y (nearest-greater-prime n)]
                (= n (/ (+ x y) 2)))))]
    
    (prime-sandwitch?* n)))



(= false (prime-sandwich? 4))

(= true (prime-sandwich? 563))

(= 1103 (nth (filter prime-sandwich? (range)) 15))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Digits and bases
;; Difficulty:	Medium
;; Topics:	math


;; Write a function which returns a sequence of digits of a non-negative number (first argument) in numerical system with an 
;; arbitrary base (second argument). Digits should be represented with their integer values, e.g. 15 would be [1 5] in base 
;; 10, [1 1 1 1] in base 2 and [15] in base 16. 

(defn convert [n base]
  (if (< n base)
    [n]
    (into (convert (quot n base) base)
          (convert (rem n base) base))))

(= [1 2 3 4 5 0 1] (convert 1234501 10))

(= [0] (convert 0 11))

(= [1 0 0 1] (convert 9 2))

(= [1 0] (let [n (rand-int 100000)](convert n n)))

(= [16 18 5 24 15 1] (convert Integer/MAX_VALUE 42))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; The Balance of N
;; Difficulty:	Medium
;; Topics:	math


;; A balanced number is one whose component digits have the same sum on the left and right halves of the number. Write a function 
;; which accepts an integer n, and returns true iff n is balanced.

(defn balance-of-n [n]
  (let [s (str n)
        digits-cnt (count s)
        mid (unchecked-divide-int digits-cnt 2)]
    (if (even? digits-cnt)
      (= (apply + (map int (take mid s)))
         (apply + (map int (drop mid s))))
      
      (= (apply + (map int (take mid s)))
         (apply + (map int (drop (inc mid) s)))))))

(= true (balance-of-n 11))

(= true (balance-of-n 121))

(= false (balance-of-n 123))

(= true (balance-of-n 0))

(= false (balance-of-n 88099))

(= true (balance-of-n 89098))

(= true (balance-of-n 89089))

(= (take 20 (filter balance-of-n (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])  
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Happy numbers
;; Difficulty:	Medium
;; Topics:	math


;; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and 
;; then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose 
;; squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a 
;; function that determines if a number is happy or not.

(defn happy-numbers [n]
  (let [m {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9}
        parse-digits
        (fn [n] (mapv m (str n)))
        sum-of-squares
        (fn [nums]
          (apply + (map #(* % %) nums)))]
    (loop [ret n vists #{} cnt 0]
      (cond
        (= ret 1) true
        (contains? vists ret) false
        :else
        (recur (sum-of-squares (parse-digits ret)) 
               (conj vists ret) (inc cnt))))))

(= (happy-numbers 7) true)

(= (happy-numbers 986543210) true)

(= (happy-numbers 2) false)

(= (happy-numbers 3) false)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Identify keys and values
;; Difficulty:	Medium
;; Topics:	maps seqs


;; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value 
;; is a sequence of all the numbers (if any) between it and the next keyword in the sequence.


(defn id-kvs [coll]
  (->> (reduce (fn [ret x]
                 (if (number? x)
                   (conj (pop ret) (conj (peek ret) x))
                   (conj ret x [])))
               []
               coll)
       (partition 2)
       (map vec)
       (into {})))

(= {} (id-kvs []))

(= {:a [1]} (id-kvs [:a 1]))

(= {:a [1], :b [2]} (id-kvs [:a 1, :b 2]))

(= {:a [1 2 3], :b [], :c [4]} (id-kvs [:a 1 2 3 :b :c 4]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Juxtaposition
;; Difficulty:	Medium
;; Topics:	higher-order-functions core-functions


;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence 
;; containing the result of applying each function left-to-right to the argument list.

(defn juxt* [& fs]
  (fn [& args]
    (map #(apply % args) fs)))

(= [21 6 1] ((juxt* + max min) 2 3 5 1 6 4))

(= ["HELLO" 5] ((juxt* #(.toUpperCase %) count) "hello"))

(= [2 6 4] ((juxt* :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Function Composition
;; Difficulty:	Medium
;; Topics:	higher-order-functions core-functions


;; Write a function which allows you to create function compositions. The parameter list should take a variable number 
;; of functions, and create a function that applies them from right-to-left.


(defn comp* [& fns]
  (fn [& xs]
    ((fn call [fns]
       (if (empty? (rest fns)) 
         (apply (first fns) xs)
         ((first fns) (call (rest fns)))))  
     fns)))

(= [3 2 1] ((comp* rest reverse) [1 2 3 4]))

(= 5 ((comp* (partial + 3) second) [1 2 3 4]))

(= true ((comp* zero? #(mod % 8) +) 3 5 7 9))

(= "HELLO" ((comp* #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Flipping out
;; Difficulty:	Medium
;; Topics:	higher-order-functions

;; Write a higher-order function which flips the order of the arguments of an input function.

(defn flip [f]
  (fn [& args]
    (apply f (reverse args))))


(= 3 ((flip nth) 2 [1 2 3 4 5]))

(= true ((flip >) 7 8))

(= 4 ((flip quot) 2 8))

(= [1 2 3] ((flip take) [1 2 3 4 5] 3))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Tricky card games
;; Difficulty:	Medium
;; Topics:	game cards


;; In trick-taking card games such as bridge, spades, or hearts, cards are played in groups known as "tricks" - each player 
;; plays a single card, in order; the first player is said to "lead" to the trick. After all players have played, one card 
;; is said to have "won" the trick. How the winner is determined will vary by game, but generally the winner is the highest
;; card played in the suit that was led. Sometimes (again varying by game), a particular suit will be designated "trump", 
;; meaning that its cards are more powerful than any others: if there is a trump suit, and any trumps are played, then the 
;; highest trump wins regardless of what was led.

;;Your goal is to devise a function that can determine which of a number of cards has won a trick. You should accept a trump 
;;suit, and return a function winner. Winner will be called on a sequence of cards, and should return the one which wins the 
;;trick. Cards will be represented in the format returned by Problem 128, Recognize Playing Cards: a hash-map of :suit and a 
;;numeric :rank. Cards with a larger rank are stronger.


(defn winner [trump]
  (fn [[{lead-suit :suit} :as cards]]
    (println lead-suit)
    (->> cards
         (apply sorted-set-by 
                (fn [a b]
                  (> (+ (:rank a)
                        (if (= (:suit a) lead-suit) 14 0)
                        (if (= (:suit a) trump) 26 0))
                     (+ (:rank b)
                        (if (= (:suit b) lead-suit) 14 0)
                        (if (= (:suit b) trump) 26 0)))))
         first)))


(let [notrump (winner nil)]
  (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                           {:suit :club :rank 9}]))
       (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                           {:suit :club :rank 10}]))))

(= {:suit :club :rank 10} ((winner :club) [{:suit :spade :rank 2}
                                           {:suit :club :rank 10}]))

(= {:suit :heart :rank 8}
   ((winner :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                     {:suit :diamond :rank 10} {:suit :heart :rank 4}]))
;; @@
;; ->
;;; :club
;;; :spade
;;; :spade
;;; :heart
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Universal Computation Engine
;; Difficulty:	Medium
;; Topics:	functions


;; Given a mathematical formula in prefix notation, return a function that calculates the value of the formula. The formula can 
;; contain nested calculations using the four basic mathematical operators, numeric constants, and symbols representing variables.
;; The returned function has to accept a single parameter containing the map of variable names to their values. 

(defn universal-compute [form]
  (fn [m]
    (letfn [(evaluate 
              [form]
              (cond
                (number? form) form
                (list? form)        
                (let [op (first form)]
                  (case op
                    / (apply / (map evaluate (next form))) 
                    * (apply * (map evaluate (next form)))
                    + (apply + (map evaluate (next form)))
                    - (apply - (map evaluate (next form)))))
                :else
                (m form)))]
      (evaluate form))))

(= 2 ((universal-compute 
       '(/ a b))
       '{b 8 a 16}))

(= 8 ((universal-compute
        '(+ a b 2))
        '{a 2 b 4}))

(= [6 0 -4]
     (map (universal-compute
            '(* (+ 2 a)
                  (- 10 b)))
            '[{a 1 b 8}
              {b 5 a -2}
              {a 2 b 11}]))

(= 1 ((universal-compute
             '(/ (+ x 2)
              (* 3 (+ y 1))))
      '{x 4 y 1}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Reimplement Trampoline
;; Difficulty:	Medium
;; Topics:	core-functions

;; Reimplement the function described in "Intro to Trampoline".

(defn tramp [f & args]
  (loop [x (apply f args)]
    (if (fn? x) (recur (x)) x)))

(= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
    (tramp triple 2))
  82)

(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial tramp my-even?) (range 6)))
  [true false true false true false])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Merge with a Function
;; Difficulty:	Medium
;; Topics:	core-functions


;; Write a function which takes a function f and a variable number of maps. Your function should return 
;; a map that consists of the rest of the maps conj-ed onto the first. If a key occurs in more than one
;; map, the mapping(s) from the latter (left-to-right) should be combined with the mapping in the result 
;; by calling (f val-in-result val-in-latter)


(defn merge-with* [f & ms]
  (reduce (fn walk [res [[k v] & xs]]
            (if k
              (if (res k)
                (recur (assoc res k (f (res k) v)) xs)
                (recur (assoc res k v) xs))
              res))
          (first ms)
          (map vec (next ms))))


(= (merge-with* * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})

(= (merge-with* - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})

(= (merge-with* concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})

(= (merge-with* concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Intervals
;; Difficulty:	Medium
;; Topics:	


;; Write a function that takes a sequence of integers and returns a sequence of "intervals". Each interval is 
;; a a vector of two integers, start and end, such that all integers between start and end (inclusive) are 
;; contained in the input sequence.

(defn intervals [coll]
  (let [sorted (sort coll)
        prev   (first sorted)]
    (if (nil? prev) []
      (loop [coll (next sorted) prev prev ret [[prev]]]
        (cond 
          (empty? coll)
          ret
      
          (>= (inc prev) (first coll))
          (recur (next coll)
                 (first coll)
                 (assoc-in ret [(-> ret count dec) 1] (first coll)))
          
          
      
          :else
          (recur (next coll)
                 (first coll)
                 (conj ret [(first coll) (first coll)])))))))

(= (intervals [1 2 3]) [[1 3]])

(= (intervals [10 9 8 1 2 3]) [[1 3] [8 10]])

(= (intervals [1 1 1 1 1 1 1]) [[1 1]])

(= (intervals []) [])

(= (intervals [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
              [[1 4] [6 6] [9 11] [13 17] [19 19]])
 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Euler's Totient Function
;; Difficulty:	Medium
;; Topics:	


;; Two numbers are coprime if their greatest common divisor equals 1. Euler's totient function f(x) is defined as the 
;; number of positive integers less than x which are coprime to x. The special case f(1) equals 1. Write a function 
;; which calculates Euler's totient function.

(defn totient  [x]
  (letfn [(gcd [x y] (if (zero? y) x (recur y (mod x y))))]
    (if (= x 1) 1
      (count (filter #(= % 1) (map gcd (repeat x) (range 1 x)))))))

(= (totient 1) 1)

(= (totient 10) (count '(1 3 7 9)) 4)

(= (totient 40) 16)

(= (totient 99) 60)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Perfect Numbers
;; Difficulty:	Medium
;; Topics:	


;; A number is "perfect" if the sum of its divisors equal the number itself. 6 is a perfect number because 1+2+3=6. 
;; Write a function which returns true for perfect numbers and false otherwise.

(defn perfect-numbers [n]
  (letfn [(divisors [n] (filter #(zero? (mod n %)) (range 1  n)))]
    (= (reduce + (divisors n)) n)))

(= (perfect-numbers 6) true)

(= (perfect-numbers 7) false)

(= (perfect-numbers 496) true)

(= (perfect-numbers 500) false)

(= (perfect-numbers 8128) true)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Anagram Finder
;; Difficulty:	Medium
;; Topics:	


;; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y 
;; if all the letters in x can be rearranged in a different order to form y. Your function should return a 
;; set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should 
;; have at least two words. Words without any anagrams should not be included in the result.

;; original solution.
#_(defn anagram-finder [words]
  (letfn [(rotate
           [coll]
           (conj (subvec coll 1) (first coll)))
          (rotations
           [coll]
           (take (count coll) (iterate rotate coll)))
          (rotate-and-join
           [coll idx]
           (let [[l r] (split-at idx coll)]
            (map #(concat % r) (rotations (vec l)))))
          (permutations
           [coll]
           (reduce 
            (fn [res idx] 
              (mapcat rotate-and-join res (repeat idx)))
            [coll]
            (range (count coll) 1 -1)))]
     (loop [words (set words)
            result #{}]
       (let [word  (first words)
             chs   (seq word)
             perms (into #{} (map (partial apply str) (permutations chs)))]
         (if (empty? words)
           (clojure.set/select #(> (count %) 1) result)
           (recur
            (clojure.set/difference words perms #{word})
            (conj result (cloure.set/intersection perms words))))))))

;; Turns ou anagrams have equivalent histograms:
(defn anagrams [words]
  (->> words (group-by frequencies) vals (map set) (filter #(> (count %) 1)) set))

(= (anagrams ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (anagrams ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Filter Perfect Squares
;; Difficulty:	Medium
;; Topics:	


;; Given a string of comma separated integers, write a function which returns a new comma 
;; separated string that only contains the numbers which are perfect squares.


(defn perfect-squares [s]
  (let [nums 
        (map (fn [s] (. Integer parseInt s))     
             (clojure.string/split s #","))
        
        perfect-square
        (fn [n]
          (loop [x 1]
           (if (>= x n) nil
            (if (and (= (/ n x) x) (zero? (mod n x)))
              n
              (recur (inc x))))))]
    (clojure.string/join ","                    
     (map str (filter perfect-square nums)))))

(= (perfect-squares "4,5,6,7,8,9") "4,9")

(= (perfect-squares "15,16,25,36,37") "16,25,36")

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Palindromic Numbers
;; Difficulty:	Medium
;;; Topics:	seqs math


;;A palindromic number is a number that is the same when written forwards or backwards (e.g., 3, 99, 14341).
;; Write a function which takes an integer n, as its only argument, and returns an increasing lazy sequence of 
;; all palindromic numbers that are not less than n.

;; The most simple solution will exceed the time limit!


;; My solution is below. Don't konw why its timing out
#_(defn pals [n] 
  (let [even-digits? #(even? (count %)) 
        left-middle #(if (even-digits? %) 
                       (subs % 0 (quot (count % ) 2) ) 
                       (subs % 0 (inc (quot (count % ) 2)))) 
        mirror (fn [[num dig]]
                 (loop [a num r (if (= dig :even) num (quot num 10))]
                   (if (= 0 r)
                     a
                     (recur (+ (* a 10) (mod r 10)) (quot r 10)))))
        init #(let [s (left-middle %)] 
                (vector (Long/parseLong s) 
                        (if (even-digits? %) :even :odd) 
                        (long (Math/pow 10 (count s)))))
        nextp (fn [[num even goal]] 
               (let [m (inc num)] 
                 (if (= m goal)
                   (if (= even :even)
                     [goal :odd (* 10 goal)]
                     [(/ goal 10) :even goal])
                   [m even goal] )))
        i  (init (str n)) 
        palindromes (iterate nextp i) ] 
    (filter (partial <= n ) (map mirror palindromes))))

;; finishes on my machine in 300ms... idk 
(defn pals [n]
  (letfn [(n->start [n]
            (loop [ret n mlt 10]
              (if (< ret mlt) ret
                (recur (/ (- ret (mod ret 10)) 10)
                       (* mlt 10)))))
          (inc-order [n]
            (loop [ret 1 n n]
              (if (== n 0) ret
                (recur (* 10 ret) (quot n 10)))))
          (even-pal [n]
            (loop [ret n n n]
              (if (== n 0) ret
                (recur (+ (* 10 ret) (mod n 10)) (quot n 10)))))
          (odd-pal [n]
            (loop [ret n n (quot n 10)]
              (if (== n 0) ret
                (recur (+ (* 10 ret) (mod n 10)) (quot n 10)))))
          (even-pals [n]
            (for [x (range n (inc-order n))]
              (even-pal x)))
          (odd-pals [n]
            (for [x (range n (inc-order n))]
              (odd-pal x)))]
    (let [start (n->start n)
          digits (str n)]
      (drop-while #(< % n)
        (if (even? (count digits))
          (apply concat
                 (for [x (iterate inc-order start)]
                   (concat (even-pals x) (odd-pals x))))
          (apply concat
                 (if (= start 0) (list 0) nil)
                 (for [x (iterate inc-order (if (= start 0) 1 start))]
                   (concat (odd-pals x) (even-pals x)))))))))

(= (take 26 (pals 0))
   [0 1 2 3 4 5 6 7 8 9 
    11 22 33 44 55 66 77 88 99 
    101 111 121 131 141 151 161])

(= (take 16 (pals 162))
   [171 181 191 202 
    212 222 232 242 
    252 262 272 282 
    292 303 313 323])

(= (take 6 (pals 1234550000))
   [1234554321 1234664321 1234774321 
    1234884321 1234994321 1235005321])

(= (first (pals (* 111111111 111111111)))
   (* 111111111 111111111))

(= (set (take 199 (pals 0)))
   (set (map #(first (pals %)) (range 0 10000))))

(= true 
   (apply < (take 6666 (pals 9999999))))

(= (nth (pals 0) 10101)
   9102019)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;;Infinite Matrix
;;Difficulty:	Medium
;;Topics:	seqs recursion math


;;In what follows, m, n, s, t denote nonnegative integers, f denotes a function that accepts two arguments 
;; and is defined for all nonnegative integers in both arguments.

;;In mathematics, the function f can be interpreted as an infinite matrix with infinitely many rows and 
;;columns that, when written, looks like an ordinary matrix but its rows and columns cannot be written 
;;down completely, so are terminated with ellipses. In Clojure, such infinite matrix can be represented 
;;as an infinite lazy sequence of infinite lazy sequences, where the inner sequences represent rows.

;;Write a function that accepts 1, 3 and 5 arguments

;; - with the argument f, it returns the infinite matrix A that has the entry in the i-th row and
;;   the j-th column equal to f(i,j) for i,j = 0,1,2,...;
;; - with the arguments f, m, n, it returns the infinite matrix B that equals the remainder of 
;;   the matrix A after the removal of the first m rows and the first n columns;
;; - with the arguments f, m, n, s, t, it returns the finite s-by-t matrix that consists of the first t 
;;   entries of each of the first s rows of the matrix B or, equivalently, that consists of the first s 
;;   entries of each of the first t columns of the matrix B.


(defn infinite-matrix 
  ([f] (letfn [(inf-range
                 ([idx]
                  (lazy-seq
                    (cons idx (inf-range (inc idx)))))
                 ([]
                  (inf-range 0)))]
         (map (fn [column] 
                (map (fn [row] (f column row))
                     (inf-range)))
              (inf-range))))
  ([f m n]
   (let [mat (infinite-matrix f)      
         my-drop
         (fn [n coll]
           (if (pos? n)
             (recur (dec n) (rest coll))
             coll))]
     (lazy-seq (my-drop m (map #(my-drop n %) mat)))))
  ([f m n s t]
   (let [mat (infinite-matrix f m n)]
     (take s (map #(take t %) mat)))))
	

(= (take 6 (map #(take 5 %) (infinite-matrix str 3 2)))
   [["32" "33" "34" "35" "36"]
    ["42" "43" "44" "45" "46"]
    ["52" "53" "54" "55" "56"]
    ["62" "63" "64" "65" "66"]
    ["72" "73" "74" "75" "76"]
    ["82" "83" "84" "85" "86"]])

(= (infinite-matrix * 3 5 5 7)
   [[15 18 21 24 27 30 33]
    [20 24 28 32 36 40 44]
    [25 30 35 40 45 50 55]
    [30 36 42 48 54 60 66]
    [35 42 49 56 63 70 77]])

(= (infinite-matrix #(/ % (inc %2)) 1 0 6 4)
   [[1/1 1/2 1/3 1/4]
    [2/1 2/2 2/3 1/2]
    [3/1 3/2 3/3 3/4]
    [4/1 4/2 4/3 4/4]
    [5/1 5/2 5/3 5/4]
    [6/1 6/2 6/3 6/4]])

(= (class (infinite-matrix (juxt bit-or bit-xor)))
   (class (infinite-matrix (juxt quot mod) 13 21))
   (class (lazy-seq)))

(= (class (nth (infinite-matrix (constantly 10946)) 34))
   (class (nth (infinite-matrix (constantly 0) 5 8) 55))
   (class (lazy-seq)))

(= (let [m 377 n 610 w 987
         check (fn [f s] (every? true? (map-indexed f s)))
         row (take w (nth (infinite-matrix vector) m))
         column (take w (map first (infinite-matrix vector m n)))
         diagonal (map-indexed #(nth %2 %) 
                               (infinite-matrix vector m n w w))]
     (and (check #(= %2 [m %]) row)
          (check #(= %2 [(+ m %) n]) column)
          (check #(= %2 [(+ m %) (+ n %)]) diagonal)))
   true)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Black Box Testing
;; Difficulty:	Medium
;; Topics:	seqs testing


;; Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a 
;; uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance 
;; differences so that you know which kind is appropriate for your application.

;; Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of 
;; collection it was given.
;; You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them 
;; and understand their behavior.

;; weirdest problem ever?
(defn bbt [coll]
  (cond 
   (= (empty coll) #{})
   :set

   (= (empty coll) {})
   :map

   :else  
   (if (= (last (conj coll :hello :world)) :world)  
     :vector
     :list)))

(= :map (bbt {:a 1, :b 2}))

(= :list (bbt (range (rand-int 20))))

(= :vector (bbt [1 2 3 4 5 6]))

(= :set (bbt #{10 (rand-int 5)}))

(= [:map :set :vector :list] (map bbt [{} #{} [] ()]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Parentheses... Again
;; Difficulty:	Medium
;; Topics:	math combinatorics


;; In a family of languages like Lisp, having balanced parentheses is a defining feature of the language. 
;; Luckily, Lisp has almost no syntax, except for these "delimiters" -- and that hardly qualifies as "syntax", 
;; at least in any useful computer programming sense.

;; It is not a difficult exercise to find all the combinations of well-formed parentheses if we only have N pairs 
;; to work with. For instance, if we only have 2 pairs, we only have two possible combinations: "()()" and "(())".
;; Any other combination of length 4 is ill-formed. Can you see why?

;; Generate all possible combinations of well-formed parentheses of length 2n (n pairs of parentheses). For this problem,
;; we only consider '(' and ')', but the answer is similar if you work with only {} or only [].

;;There is an interesting pattern in the numbers!


(defn parens 
  ([n]
   (set (parens n n [])))
  ([l r ret]
   (cond (= r 0) (list (apply str ret))
         (> l 0) (concat (parens (dec l) r (conj ret \())
                         (when (> r l)
                           (parens l (dec r) (conj ret \)))))
         :else (parens l (dec r) (conj ret \))))))


(= [#{""} #{"()"} #{"()()" "(())"}] (map (fn [n] (parens n)) [0 1 2]))

(= #{"((()))" "()()()" "()(())" "(())()" "(()())"} (parens 3))

(= 16796 (count (parens 10)))

(= (nth (sort (filter #(.contains ^String % "(()()()())") (parens 9))) 6) "(((()()()())(())))")

(= (nth (sort (parens 12)) 5000) "(((((()()()()()))))(()))")



;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Longest Increasing Sub-Seq
;; Difficulty:	Hard
;; Topics:	seqs


;; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the 
;; same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.

(defn lis [coll]
  (letfn [(rf [[current longest] e]
	       (if (= (dec e) (peek current))
                 (let [current (conj current e)]
                   [current (if (> (count current) (count longest))
                              current
                              longest)])
                 [[e] longest]))]
         (get (reduce rf [[] []] coll) 1)))


(= (lis [1 0 1 2 3 0 4 5]) [0 1 2 3])

(= (lis [5 6 1 3 2 7]) [5 6])

(= (lis [2 3 3 4 5]) [3 4 5])

(= (lis [7 6 5 4]) [])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Analyze a Tic-Tac-Toe Board
;; Difficulty:	Hard
;; Topics:	game


;; A tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty 
;; is represented by :e. A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row. Write a 
;; function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.

(defn solve [board]
  (letfn [(transpose [matrix]
                     (apply mapv vector matrix))
          (trace [matrix]
                 (mapv (fn [coll idx] (nth coll idx)) 
                       matrix (range)))
          (rotate [coll]
                  (conj (subvec coll 1) (first coll)))
          (rotate-n [coll n]
                    ((apply comp (repeat n rotate)) coll))
          (symmetric-trace [matrix]
                           (->>
                            (trace
                             [(rotate-n (first matrix) 2)
                              (second matrix)
                              (rotate-n (last matrix) 1)])
                            (conj [] (trace matrix))))]
    (let [x-win [:x :x :x]
          o-win [:o :o :o]]
      (if (or (contains? (set board) x-win)
              (contains? (set (transpose board)) x-win)
              (contains? (set (symmetric-trace board)) x-win))
        :x
        (if (or (contains? (set board) o-win)
                (contains? (set (transpose board)) o-win)
                (contains? (set (symmetric-trace board)) o-win))
          :o
          nil)))))

(= nil (solve [[:e :e :e]
               [:e :e :e]
               [:e :e :e]]))

(= :x (solve [[:x :e :o]
              [:x :e :e]
              [:x :e :o]]))

(= :o (solve [[:e :x :e]
              [:o :o :o]
              [:x :e :x]]))

(= nil (solve [[:x :e :o]
               [:x :x :e]
               [:o :x :o]]))

(= :x (solve [[:x :e :e]
              [:o :x :e]
              [:o :e :x]]))

(= :o (solve [[:x :e :o]
              [:x :o :e]
              [:o :e :x]]))

(= nil (solve [[:x :o :x]
               [:x :o :x]
               [:o :x :o]]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Read Roman numerals
;; Difficulty:	Hard
;; Topics:	strings math


;; Roman numerals are easy to recognize, but not everyone knows all the rules necessary to work with them. Write a function to 
;; parse a Roman-numeral string and return the number it represents. 

;; You can assume that the input will be well-formed, in upper-case, and follow the subtractive principle. You don't need to
;; handle any numbers greater than MMMCMXCIX (3999), the largest number representable with ordinary letters.

(defn roman-numeral [s]
  (let [table {\I 1 \V 5
               \X 10 \L 50
               \C 100 \D 500
               \M 1000}]
    (loop [s s ret 0]
      (if (empty? s) ret
        (let [x1 (first s)
              x2 (second s)]
          (cond (nil? x2)
                (+ ret (table x1))
                
                (< (table x1) (table x2))
                (recur (next s)
                       (- ret (table x1)))
                
                :else
                (recur (next s)
                       (+ ret (table x1)))))))))

(= 14 (roman-numeral "XIV"))

(= 827 (roman-numeral "DCCCXXVII"))

(= 3999 (roman-numeral "MMMCMXCIX"))

(= 48 (roman-numeral "XLVIII"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Triangle Minimal Path
;; Difficulty:	Hard
;; Topics:	graph-theory


;; Write a function which calculates the sum of the minimal path through a triangle. The triangle is represented as a 
;; collection of vectors. The path should start at the top of the triangle and move to an adjacent number on the next 
;; row until the bottom of the triangle is reached.

(defn min-path [triangle]
  (letfn [(walk 
           [g i j]
           (if (= (inc i) (count g))
             ((g i) j)
             (+ ((g i) j) (min (walk g (inc i) j)
                               (walk g (inc i) (inc j))))))]
    (walk (vec triangle) 0 0)))

(= 7 (min-path '([1]
                [2 4]
               [5 1 4]
              [2 3 4 5]))) ; 1->2->1->3

(= 20 (min-path '([3]
                 [2 4]
                [1 9 3]
               [9 9 2 4]
              [4 6 6 7 8]
             [5 7 3 5 1 4]))) ; 3->4->3->2->7->1
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Transitive Closure
;; Difficulty:	Hard
;; Topics:	set-theory


;; Write a function which generates the transitive closure of a binary relation. The relation will be represented 
;; as a set of 2 item vectors.

(defn transitive-closure [rel]
  (let [nxt (into #{}
              (for [[x y1 :as r] rel
                    [y2 z] rel]
                (if (= y1 y2) [x z] r)))]
    (if (= nxt rel) rel
      (recur nxt))))


(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= (transitive-closure divides) 
     #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))

(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (transitive-closure more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))

(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (transitive-closure progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Word Chains
;; Difficulty:	Hard
;; Topics:	seqs


;; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly 
;; before and after it. The one letter difference can be either an insertion, a deletion, or a substitution. Here is an 
;; example word chain:

;; cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog

;; Write a function which takes a sequence of words, and returns true if they can be arranged into one continous word 
;; chain, and false if they cannot.

(defn word-chain? [words]
  (letfn [(adjacent?
            ([a b] (adjacent? a b 0))
            ([a b dist]
             (cond (> dist 1) false
                   (and (nil? a) (nil? b)) true
                   
                   (= (first a) (first b))
                   (adjacent? (next a) (next b) dist)
                   
                   :else
                   (or (adjacent? (next a) (next b) (inc dist))
                       (adjacent? a (next b) (inc dist))
                       (adjacent? (next a) b (inc dist))))))
          
          (connected? 
            [mat node]
            (letfn [(walk 
                      [node visits]
                      (let [tgts      (mat node)
                            visits    (conj visits node)
                            unvisited (clojure.set/difference 
                                        tgts visits)]
                        (if (== (count words) (count visits)) true
                          (some true? (map #(walk % visits) 
                                           unvisited)))))]
            (walk node #{})))
          
          (adjacency-mat 
            [words]
            (reduce (fn [ret [a b]]
                      (-> (update-in ret [a] conj b)
                          (update-in [b] conj a)))
                    (into {} (map #(vector % #{}) words))
                    (for [i (range (count words))
                          j (range (inc i) (count words))
                          :let [a (words i)
                                b (words j)]
                          :when (adjacent? a b)]
                      [a b])))]
    (let [words-vec (vec words)
          mat (adjacency-mat words-vec)]
      (boolean (some (partial connected? mat) words)))))


(= true (word-chain? 
          #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

(= false (word-chain? #{"cot" "hot" "bat" "fat"}))

(= false (word-chain? #{"to" "top" "stop" "tops" "toss"}))

(= true (word-chain? #{"spout" "do" "pot" "pout" "spot" "dot"}))

(= true (word-chain? #{"share" "hares" "shares" "hare" "are"}))

(= false (word-chain? #{"share" "hares" "hare" "are"}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Graph Connectivity
;; Difficulty:	Hard
;; Topics:	graph-theory


;; Given a graph, determine whether the graph is connected. A connected graph is such that a path exists 
;; between any two given nodes.

;; -Your function must return true if the graph is connected and false otherwise.

;; -You will be given a set of tuples representing the edges of a graph. Each member of a tuple being a 
;; vertex/node in the graph.

;; -Each edge is undirected (can be traversed either direction). 

(defn connected? [edges]
  (let [nodes (set (apply concat edges))
        num-nodes (count nodes)
        adjacency-mat
        (reduce (fn [ret [x y :as edge]]
                  (-> (update-in ret [x] conj y)
                      (update-in [y] conj x)))
                (into {} (map vector nodes (repeat #{})))
                edges)
        walk
        (fn walk [visited node]
          (lazy-seq
            (let [neighbors (adjacency-mat node)
                  visited   (conj visited node)
                  unvisited (clojure.set/difference neighbors visited)]
              (cond (= num-nodes (count visited)) (list true)
                    (empty? unvisited) (list nil)
                    :else
                    (mapcat (partial walk visited) unvisited)))))]
    (boolean (some true? (walk #{} (first nodes))))))


(= true (connected? #{[:a :a]}))

(= true (connected? #{[:a :b]}))

(= false (connected? #{[1 2] [2 3] [3 1]
                       [4 5] [5 6] [6 4]}))

(= true (connected? #{[1 2] [2 3] [3 1]
                      [4 5] [5 6] [6 4] [3 4]}))

(= false (connected? #{[:a :b] [:b :c] [:c :d]
                       [:x :y] [:d :a] [:b :e]}))

(= true (connected? #{[:a :b] [:b :c] [:c :d]
                      [:x :y] [:d :a] [:b :e] [:x :a]}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Game of Life
;; Difficulty:	Hard
;; Topics:	game


;; The game of life is a cellular automaton devised by mathematician John Conway. 

;; The 'board' consists of both live (#) and dead ( ) cells. Each cell interacts with its eight neighbours 
;; (horizontal, vertical, diagonal), and its next state is dependent on the following rules:

;; 1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.
;; 2) Any live cell with two or three live neighbours lives on to the next generation.
;; 3) Any live cell with more than three live neighbours dies, as if by overcrowding.
;; 4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

;; Write a function that accepts a board, and returns a board representing the next generation of cells.

(defn game-of-life [world]
  (let [living (for [i (range (count world))
                     j (range (count (world i)))
                     :when (= (get-in world [i j]) \#)]
                 [i j])
        
        dead? (fn [cell]
                     (= (get-in world cell) \space))
        
        living? (fn [cell]
                  (= (get-in world cell) \#))
        
        neighbors (for [[i j] living
                        k (range -1 2)
                        l (range -1 2)
                        :when (not (= k l 0))]
                    [(+ i k) (+ j l)])
        
        counts (reduce (fn [ret cell]
                         (update-in ret [cell] #(inc (or % 0))))
                       {}
                       neighbors)
        
        births (reduce (fn [world cell]
                         (assoc-in world cell \#))
                       (mapv vec world)
                       (for [[cell cnt] counts
                             :when (and (dead? cell) (= cnt 3))]
                         cell))
        
        deaths (reduce (fn [world cell]
                         (assoc-in world cell \space))
                       births
                       (for [[cell cnt] counts
                             :when (and (living? cell)
                                        (or (> cnt 3) (< cnt 2)))]
                         cell))]
    (mapv #(apply str %) deaths)))

(= (game-of-life 
     ["      "  
      " ##   "
      " ##   "
      "   ## "
      "   ## "
      "      "])
   ["      "  
    " ##   "
    " #    "
    "    # "
    "   ## "
    "      "])

(= (game-of-life
     ["     "
      "     "
      " ### "
      "     "
      "     "])
   ["     "
    "  #  "
    "  #  "
    "  #  "
    "     "])

(= (game-of-life
     ["      "
      "      "
      "  ### "
      " ###  "
      "      "
      "      "])
   ["      "
    "   #  "
    " #  # "
    " #  # "
    "  #   "
    "      "])

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Number Maze
;; Difficulty:	Hard
;; Topics:	numbers


;; Given a pair of numbers, the start and end point, find a path between the two using only three possible operations:
;; double
;; halve (odd numbers cannot be halved)
;; add 2

;; Find the shortest path through the "maze". Because there are multiple shortest paths, you must return the length 
;; of the shortest path, not the path itself.

(defn number-maze [x y]
  (letfn [(walk [n ret depth]
                (cond (== depth 0) Double/POSITIVE_INFINITY
                      (== n y) (inc (count ret))
                      :else
                      (min  (walk (* n 2)
                                  (conj ret n)
                                  (dec depth))
                            (if (even? n)
                              (walk (/ n 2)
                                    (conj ret n)
                                    (dec depth))
                              Double/POSITIVE_INFINITY)
                            (walk (+ n 2)
                                  (conj ret n)
                                  (dec depth)))))]
    (loop [i 1
           ret (walk x [] i)]
      (if (< ret Double/POSITIVE_INFINITY)
        ret
        (recur (inc i)
               (walk x [] (inc i)))))))

(= 1 (number-maze 1 1))  ; 1

(= 3 (number-maze 3 12)) ; 3 6 12

(= 3 (number-maze 12 3)) ; 12 6 3

(= 3 (number-maze 5 9))  ; 5 7 9

(= 9 (number-maze 9 2))  ; 9 18 20 10 12 6 8 4 2

(= 5 (number-maze 9 12)) ; 9 11 22 24 12
 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Levenshtein Distance
;; Difficulty:	Hard
;; Topics:	seqs


;; Given two sequences x and y, calculate the Levenshtein distance of x and y, i. e. the minimum number of edits
;; needed to transform x into y. The allowed edits are:

;; - insert a single item
;; - delete a single item
;; - replace a single item with another item

;; WARNING: Some of the test cases may timeout if you write an inefficient solution!

(defn distance [a b]
  (letfn [(walk
           [f a b]
           (cond
             (or (nil? a) (nil? b))
             (+ (count a) (count b))
             
             (= (first a) (first b))
             (f f (next a) (next b))
            
             :else
             (inc (min (f f (next a) (next b))
                       (f f (next a) b)
                       (f f a (next b))))))]
    (walk (memoize walk) a b)))

(= (distance "kitten" "sitting") 3)

(= (distance "closure" "clojure") (distance "clojure" "closure") 1)

(= (distance "xyx" "xyyyx") 2)

(= (distance "" "123456") 6)

(= (distance "Clojure" "Clojure") (distance "" "") (distance [] []) 0)

(= (distance [1 2 3 4] [0 2 3 4 5]) 2)

(= (distance '(:a :b :c :d) '(:a :d)) 2)

(= (distance "ttttattttctg" "tcaaccctaccat") 10)

(= (distance "gaattctaatctc" "caaacaaaaaattt") 9)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Graph Tour
;; Difficulty:	Hard
;; Topics:	graph-theory


;; Starting with a graph you must write a function that returns true if it is possible to make a tour of 
;; the graph in which every edge is visited exactly once.

;; The graph is represented by a vector of tuples, where each tuple represents a single edge.

;; The rules are:

;; - You can start at any node.
;; - You must visit each edge exactly once.
;; - All edges are undirected.

(defn graph-tour [edges]
  (let [nodes (into #{} (apply concat edges))
        num-edges (count edges)
        adjacency-mat
        (reduce (fn [mat [a b :as edge]]
                  (-> (update-in mat [a] conj (set edge))
                      (update-in [b] conj (set edge))))
                (into {} (map vector nodes (repeat #{})))
                edges)
        walk
        (fn walk [visited node]
          (lazy-seq
            (let [edges     (adjacency-mat node)
                  unvisited (clojure.set/difference edges visited)]
              (cond
                (= (count visited) num-edges) (list true)
                (empty? unvisited)            (list nil)
                :else
                (mapcat #(walk (conj visited %) 
                               (first (disj % node))) unvisited)))))]
    (boolean (some true? (walk #{} (ffirst edges))))))

(= true (graph-tour [[:a :b]]))

(= false (graph-tour [[:a :a] [:b :b]]))

(= false (graph-tour [[:a :b] [:a :b] [:a :c] [:c :a]
                      [:a :d] [:b :d] [:c :d]]))

(= true (graph-tour [[1 2] [2 3] [3 4] [4 1]]))

(= true (graph-tour [[:a :b] [:a :c] [:c :b] [:a :e]
                     [:b :e] [:a :d] [:b :d] [:c :e]
                     [:d :e] [:c :f] [:d :f]]))

(= false (graph-tour [[1 2] [2 3] [2 4] [2 5]]))
(= false (graph-tour [[1 2] [2 3] [2 4] [2 5]]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Win at Tic-Tac-Toe
;; Difficulty:	Hard
;; Topics:	game


;; As in Problem 73, a tic-tac-toe board is represented by a two dimensional vector. X is represented by 
;; :x, O is represented by :o, and empty is represented by :e. Create a function that accepts a game piece 
;; and board as arguments, and returns a set (possibly empty) of all valid board placements of the game piece 
;; which would result in an immediate win.

;; Board coordinates should be as in calls to get-in. For example, [0 1] is the topmost row, center position.

(defn winning-moves [player board]
  (letfn [(column-indices 
            [rows]
            (partition (count rows)
                     (for [row    (range (count rows))
                           column (range (count rows))]
                       [column row])))
          (row-indices [rows]
            (partition (count rows)
                       (for [row    (range (count rows))
                             column (range (count rows))]
                         [row column])))
          (diagonal-indices [rows]
            (->> (for [row (range (count rows))]
                   [[row row]
                   [(- (count rows) row 1) row]])
                 (apply map vector)))]
  (let [rows (row-indices board)
        columns (column-indices board)
        diagonals (diagonal-indices board)]
    (->> (concat rows columns diagonals)
         (filter (fn [indices]
                   (let [elems (map #(get-in board %) indices)
                         freqs (frequencies elems)]
                     (and (= (player freqs) 2)
                          (= (:e freqs) 1)))))
         (apply concat)
         (filter #(= (get-in board %) :e))
         set))))


(= (winning-moves :x [[:o :e :e] 
                      [:o :x :o] 
                      [:x :x :e]])
   #{[2 2] [0 1] [0 2]})

(= (winning-moves :x [[:x :o :o] 
                      [:x :x :e] 
                      [:e :o :e]])
   #{[2 2] [1 2] [2 0]})

(= (winning-moves :x [[:x :e :x] 
                      [:o :x :o] 
                      [:e :o :e]])
   #{[2 2] [0 1] [2 0]})

(= (winning-moves :x [[:x :x :o] 
                      [:e :e :e] 
                      [:e :e :e]])
   #{})

(= (winning-moves :o [[:x :x :o] 
                      [:o :e :o] 
                      [:x :e :e]])
   #{[2 2] [1 1]})
(= (winning-moves :o [[:x :x :o] 
                      [:o :e :o] 
                      [:x :e :e]])
   #{[2 2] [1 1]})

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; For Science!
;; Difficulty:	Hard
;; Topics:	game


;; A mad scientist with tenure has created an experiment tracking mice in a maze. Several mazes have been 
;; randomly generated, and you've been tasked with writing a program to determine the mazes in which it's 
;; possible for the mouse to reach the cheesy endpoint. Write a function which accepts a maze in the form 
;; of a collection of rows, each row is a string where:
;; -spaces represent areas where the mouse can walk freely
;; -hashes (#) represent walls where the mouse can not walk
;; -M represents the mouse's starting point
;; -C represents the cheese which the mouse must reach

;; The mouse is not allowed to travel diagonally in the maze (only up/down/left/right), nor can he escape 
;; the edge of the maze. Your function must return true iff the maze is solvable by the mouse.

(defn for-science! [maze-data]
  (letfn [(build-maze 
           [maze-data]
            (let [side-length (+ (count (first maze-data)) 2)]
              (conj (into [(vec (repeat side-length \#))]
                           (for [row (mapv vec maze-data)]
                             (into [\#] (conj row \#))))
                    (vec (repeat side-length \#)))))
          
          (locate-cell [maze value]
            (first (filter #(= (get-in maze %) value)
                          (for [i (range (count maze))
                                j (range (count (maze i)))]
                            [i j]))))
          
          
          (distance
            [p1 p2]
            (let [dx (- (first p1) (first p2))
                  dy (- (second p1) (second p2))]
              (Math/sqrt (+ (* dx dx) (* dy dy)))))
          
          (actions 
            [[x y] goal-point]
            (into (sorted-map)
                  (group-by (partial distance goal-point) 
                  [[(inc x) y]
                   [x (inc y)]
                   [x (dec y)]
                   [(dec x) y]])))
          
          (legal-action? [maze point]
            (not= (get-in maze point) \#))
          
          (rank-actions 
            [maze my-pos goal-pos]
            (let [possible-actions (actions my-pos goal-pos)
                  legal-action?* (partial legal-action? maze)]
              (->> possible-actions
                   (mapcat (fn [[dist actions]] actions))
                   (filter legal-action?*)
                   (into []))))
          
          (walk 
            ([maze]
             (let [my-pos (locate-cell maze \M)
                   goal-pos (locate-cell maze \C)]
               (walk maze my-pos goal-pos #{})))
            ([maze my-pos goal-pos visited]
               (if (= my-pos goal-pos) :muhahaha
                 (let [action-seq (rank-actions maze my-pos goal-pos)
                       visited (conj visited my-pos)
                       next-steps (remove visited action-seq)]
                   (if (empty? next-steps) visited
                     ;; No fold-right????
                     (loop [visited visited next-steps next-steps]
                       (cond (= visited :muhahaha) visited
                             (empty? next-steps) visited
                             :else
                             (recur (walk maze
                                          (first next-steps)
                                          goal-pos
                                          visited)
                                    (next next-steps)))))))))]
    
    (= (walk (build-maze maze-data)) :muhahaha)))

(= true  (for-science! ["M   C"]))

(= false (for-science! ["M # C"]))

(= true  (for-science! ["#######"
                        "#     #"
                        "#  #  #"
                        "#M # C#"
                        "#######"]))

(= false (for-science! 
             ["########"
              "#M  #  #"
              "#   #  #"
              "# # #  #"
              "#   #  #"
              "#  #   #"
              "#  # # #"
              "#  #   #"
              "#  #  C#"
              "########"]))

(= false (for-science!
             ["M     "
              "      "
              "      "
              "      "
              "    ##"
              "    #C"]))

(= true  (for-science! 
             ["C######"
              " #     "
              " #   # "
              " #   #M"
              "     # "]))

(= true  (for-science! 
             ["C# # # #"
              "        "
              "# # # # "
              "        "
              " # # # #"
              "        "
              "# # # #M"]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Making Data Dance
;; Difficulty:	Hard
;; Topics:	types


;; Write a function that takes a variable number of integer arguments. If the output is coerced into a string, it should return a 
;; comma (and space) separated list of the inputs sorted smallest to largest. If the output is coerced into a sequence, it should 
;; return a seq of unique input elements in the same order as they were entered.

;; don't understand the question...
(defn dance! [& coll]
  (reify 
    clojure.lang.Seqable
    (seq [this] 
         (seq (distinct coll)))
    Object
    (toString [this] (apply str (interpose ", " (sort coll))))))


(= "1, 2, 3" (str (dance! 2 1 3)))

(= '(2 1 3) (seq (dance! 2 1 3)))

(= '(2 1 3) (seq (dance! 2 1 3 3 1 2)))

(= '(1) (seq (apply dance! (repeat 5 1))))

(= "1, 1, 1, 1, 1" (str (apply dance! (repeat 5 1))))

(and (= nil (seq (dance!)))
     (=  "" (str (dance!))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Crossword puzzle
;; Difficulty:	Hard
;; Topics:	game


;; Write a function that takes a string and a partially-filled crossword puzzle board, and determines if the input string 
;; can be legally placed onto the board. 

;; The crossword puzzle board consists of a collection of partially-filled rows. Empty spaces are denoted with an underscore 
;; (_), unusable spaces are denoted with a hash symbol (#), and pre-filled spaces have a character in place; the whitespace 
;; characters are for legibility and should be ignored. 

;; For a word to be legally placed on the board: 
;; - It may use empty spaces (underscores) 
;; - It may use but must not conflict with any pre-filled characters. 
;; - It must not use any unusable spaces (hashes). 
;; - There must be no empty spaces (underscores) or extra characters    before or after the word (the word may be bound by unusable spaces though). 
;; - Characters are not case-sensitive. 
;; - Words may be placed vertically (proceeding top-down only), or horizontally (proceeding left-right only).

(defn crossword-puzzle [word puzzle]
  (letfn [(solve-puzzle
            [puzzle]
            (->> puzzle
                 (concat (apply mapv str puzzle))
                 (mapcat #(clojure.string/split % #"#"))
                 (some   (comp #(if (= % word) word nil)
                               #(re-find % word)
                               re-pattern
                               #(clojure.string/replace % "_" ".{1}")
                               #(clojure.string/replace % " " "")))
                 boolean))]
    (solve-puzzle puzzle)))

(= true  (crossword-puzzle "the" ["_ # _ _ e"]))

(= false (crossword-puzzle 
             "the" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"]))

(= true  (crossword-puzzle
             "joy" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"]))

(= false (crossword-puzzle
             "joy" ["c o n j"
                    "_ _ y _"
                    "r _ _ #"]))

(= true  (crossword-puzzle
             "clojure" ["_ _ _ # j o y"
                        "_ _ o _ _ _ _"
                        "_ _ f _ # _ _"]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Gus' Quinundrum
;; Difficulty:	Hard
;; Topics:	logic fun brain-teaser


;; Create a function of no arguments which returns a string that is an exact copy of the function itself. 

;; Hint: read this if you get stuck (this question is harder than it first appears); but it's worth the 
;; effort to solve it independently if you can! 

;; Fun fact: Gus is the name of the 4Clojure dragon.

(fn [] ((fn [x] (str (list (quote fn) [] (list x (list (quote quote) x))))) (quote (fn [x]  (str (list (quote fn) [] (list x (list (quote quote) x))))))))



(= (str '(fn [] ((fn [x] (str (list (quote fn) [] 
                           (list x (list (quote quote) x))))) 
        (quote (fn [x]  (str (list (quote fn) [] 
                                   (list x (list (quote quote) x))))))))) ((fn [] ((fn [x] (str (list (quote fn) [] 
                           (list x (list (quote quote) x))))) 
        (quote (fn [x]  (str (list (quote fn) [] 
                                   (list x (list (quote quote) x))))))))))


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Best Hand
;; Difficulty:	Hard
;; Topics:	strings game


;; Following on from Recognize Playing Cards, determine the best poker hand that can be made with five cards. 
;; The hand rankings are listed below for your convenience.

;; Straight flush: All cards in the same suit, and in sequence
;; Four of a kind: Four of the cards have the same rank
;; Full House: Three cards of one rank, the other two of another rank
;; Flush: All cards in the same suit
;; Straight: All cards in sequence (aces can be high or low, but not both   at once)
;; Three of a kind: Three of the cards have the same rank
;; Two pair: Two pairs of cards have the same rank
;; Pair: Two cards have the same rank
;; High card: None of the above conditions are met

(defn best-hand [hand-data]
  (let [parse-hand 
        (fn [hand-data]
          (let [split-cards (map vec hand-data)
                suits       (mapv first split-cards)
                ranks (->> split-cards
                           (map (comp #({\J 11 \Q 12 
                                         \K 13 \A 14
                                         \T 10 \9 9
                                         \8 8  \7 7 
                                         \6 6  \5 5 
                                         \4 4  \3 3
                                         \2 2} % %)
                                         second))
                           sort
                           vec)]
            {:suits suits
             :ranks ranks}))
         
        in-sequence?
        (fn [{:keys [ranks]}]
          (let [comparison 
                (= ranks (range (first ranks) 
                                (+ (first ranks)
                                   (count ranks))))]
            (if (= (last ranks) 14)
              (or (= (butlast ranks) (range 2 (inc (count ranks))))
                  comparison)
              comparison)))
         
        same-suit?
        (fn [{:keys [suits]}]
          (println suits)
            (= (count (set suits)) 1))
        
        order 
        {:straight-flush 0
         :four-of-a-kind 1
         :full-house 2
         :flush 3
         :straight 4
         :three-of-a-kind 5
         :two-pair 6
         :pair 7
         :high-card 8}
        
        
        classifier
        (sorted-map-by (fn [a b]
                         (< (order a) (order b)))
           :straight-flush
           (fn [hand] (and (same-suit? hand)
                           (in-sequence? hand)))
           :four-of-a-kind
           (fn [{:keys [ranks]}] 
             (some (fn [[k v]] (>= (count v) 4))
                   (group-by identity ranks)))
         
           :full-house 
           (fn [{:keys [ranks]}]
              (let [[a b & xs] (vals (group-by identity ranks))]
               (and a b (not xs) 
                    (or (= (count a) 2)
                        (= (count b) 2)))))
         
           :flush
           (fn [hand]
             (same-suit? hand))
         
           :straight
           (fn [hand]
             (in-sequence? hand))
         
           :three-of-a-kind
           (fn [{:keys [ranks]}]
             (contains? (->> ranks
                             (group-by identity)
                             vals
                             (map count)
                             set)
                        3))
         
           :two-pair
           (fn [{:keys [ranks]}]
             (= (->> ranks
                     (group-by identity)
                     vals
                     (map count)
                     (filter #(= % 2))
                     count)
                2))
         
           :pair
           (fn [{:keys [ranks]}]
             (= (->> ranks
                     (group-by identity)
                     vals
                     (map count)
                     (filter #(= % 2))
                     count)
                1))
         
           :high-card (fn [hand] true))
        
        parsed-hand (parse-hand hand-data)]
    (loop [classifier (seq classifier)]
      (let [[type* pred] (first classifier)]
        (if (pred parsed-hand)
          type*
          (recur (next classifier)))))))


(= :high-card (best-hand ["HA" "D2" "H3" "C9" "DJ"]))

(= :pair (best-hand ["HA" "HQ" "SJ" "DA" "HT"]))

(= :two-pair (best-hand ["HA" "DA" "HQ" "SQ" "HT"]))

(= :three-of-a-kind (best-hand ["HA" "DA" "CA" "HJ" "HT"]))

(= :straight (best-hand ["HA" "DK" "HQ" "HJ" "HT"]))

(= :straight (best-hand ["HA" "H2" "S3" "D4" "C5"]))

(= :flush (best-hand ["HA" "HK" "H2" "H4" "HT"]))

(= :full-house (best-hand ["HA" "DA" "CA" "HJ" "DJ"]))

(= :four-of-a-kind (best-hand ["HA" "DA" "CA" "SA" "DJ"]))

(= :straight-flush (best-hand ["HA" "HK" "HQ" "HJ" "HT"]))
;; @@
;; ->
;;; [H D H C D]
;;; [H D H C D]
;;; [H H S D H]
;;; [H H S D H]
;;; [H D H S H]
;;; [H D H S H]
;;; [H D C H H]
;;; [H D C H H]
;;; [H D H H H]
;;; [H D H H H]
;;; [H H S D C]
;;; [H H S D C]
;;; [H H H H H]
;;; [H H H H H]
;;; [H D C H D]
;;; [H D C S D]
;;; [H H H H H]
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Analyze Reversi
;; Difficulty:	Hard
;; Topics:	game


;; Reversi is normally played on an 8 by 8 board. In this problem, a 4 by 4 board is represented as a two-dimensional 
;; vector with black, white, and empty pieces represented by 'b, 'w, and 'e, respectively. Create a function that accepts
;; a game board and color as arguments, and returns a map of legal moves for that color. Each key should be the coordinates 
;; of a legal move, and its value a set of the coordinates of the pieces flipped by that move.

;; Board coordinates should be as in calls to get-in. For example, [0 1] is the topmost row, second column from the left.


;; Not the prettiest....
(defn analyze-reversi [board player]
  (letfn [(diagonals
            [board]
            (->> (for [i (range (count board))]
                   (for [j (range (inc i))]
                     (let [k (- i j)
                           n (dec (count board))
                           l (- n i)]
                      [[(get-in board [k j]) k j]
                       [(get-in board [(- n k) (- n j)]) (- n k) (- n j)]
                       [(get-in board [j l]) j l]
                       [(get-in board [(+ l j) j]) (+ l j) j]])))
                 (mapcat #(apply mapv vector %))))
          (rows 
            [board]
            (for [i (range (count board))]
              (for [j (range (count board))]
                [(get-in board [i j]) i j])))
          
          (columns 
            [board]
            (for [i (range (count board))]
              (for [j (range (count board))]
                [(get-in board [j i]) j i])))
         
          (legal-moves
            [player opponent string]
            (->> (re-seq 
                  (re-pattern 
                   (str player "\\d+" \( opponent "\\d+" \) \+ 'e "\\d+"))       
                  string)
                 (map first)))
          
          (opponent [player]
                    (if (= player 'w) 'b 'w))]
    (->> (concat (diagonals board) 
                 (rows board) 
                 (columns board))
         (map (comp (partial legal-moves player (opponent player))
                    #(apply str %)
                    #(apply concat %)
                    #(apply concat %)
                    #(vector % (reverse %))))
         (remove empty?)
         (apply concat)
         (map (comp (fn [coll] [(vec (peek coll)) 
                                (set (map vec (pop coll)))])
                    vec
                    next
                    #(partition 2 %)
                    #(remove nil? %)
                    #(map {\0 0 \1 1 \2 2 \3 3} %)
                    #(next %)))
         
         (into {}))))

(= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
   (analyze-reversi '[[e e e e]
                      [e w b e]
                      [e b w e]
                      [e e e e]] 'w))

(= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
   (analyze-reversi '[[e e e e]
                      [e w b e]
                      [w w w e]
                      [e e e e]] 'b))

(= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
   (analyze-reversi '[[e e e e]
                      [e w b e]
                      [w w b e]
                      [e e b e]] 'w))

(= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
   (analyze-reversi '[[e e w e]
                      [b b w e]
                      [b w w e]
                      [b w w w]] 'b))

(= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
   (analyze-reversi '[[e e w e]
                      [b b w e]
                      [b w w e]
                      [b w w w]] 'b))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Tree reparenting
;; Difficulty:	Hard
;; Topics:	tree


;; Every node of a tree is connected to each of its children as well as its parent. One can imagine grabbing one 
;; node of a tree and dragging it up to the root position, leaving all connections intact. For example, below on the 
;; left is a binary tree. By pulling the "c" node up to the root, we obtain the tree on the right. 
 
;; Note it is no longer binary as "c" had three connections total -- two children and one parent. Each node is 
;; represented as a vector, which always has at least one element giving the name of the node as a symbol. 
;; Subsequent items in the vector represent the children of the node. Because the children are ordered it's important 
;; that the tree you return keeps the children of each node in order and that the old parent node, if any, is appended 
;; on the right. Your function will be given two args -- the name of the node that should become the new root, and the 
;; tree to transform. 


(defn reparent [new-root tree]
  (letfn [(reverse-arrow [parent child]
            (let [[a b] (split-with #(not (identical? % child)) parent)]
              (concat (first b) (list (concat a (rest b))))))
          (walk [parent]
            (lazy-seq
              (cons parent
                    (mapcat (fn [child]
                              (if (= (count child) 1)
                                (list (reverse-arrow parent child))
                                (walk (reverse-arrow parent child))))
                            (rest parent)))))]
    (first (filter #(= (first %) new-root) (walk tree)))))

(= '(n)
   (reparent 'n '(n)))

(= '(a (t (e)))
   (reparent 'a '(t (e) (a))))

(= '(e (t (a)))
   (reparent 'e '(a (t (e)))))

(= '(a (b (c)))
   (reparent 'a '(c (b (a)))))

(= '(d 
      (b
        (c)
        (e)
        (a 
          (f 
            (g) 
            (h)))))
  (reparent 
     'd '(a
            (b 
              (c) 
              (d) 
              (e))
            (f 
              (g)
              (h)))))

(= '(c 
      (d) 
      (e) 
      (b
        (f 
          (g) 
          (h))
        (a
          (i
          (j
            (k)
            (l))
          (m
            (n)
            (o))))))
   (reparent
     'c '(a
             (b
               (c
                 (d)
                 (e))
               (f
                 (g)
                 (h)))
             (i
               (j
                 (k)
                 (l))
               (m
                 (n)
                 (o))))))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Squares Squared
;; Difficulty:	Hard
;; Topics:	data-juggling


;; Create a function of two integer arguments: the start and end, respectively. You must create a vector of strings which 
;; renders a 45° rotated square of integers which are successive squares from the start point up to and including the end 
;; point. If a number comprises multiple digits, wrap them around the shape individually. If there are not enough digits to 
;; complete the shape, fill in the rest with asterisk characters. The direction of the drawing should be clockwise, starting 
;; from the center of the shape and working outwards, with the initial direction being down and to the right.

(defn data-juggle [start end]
  (letfn [(left [[pos & stack]]
                (conj stack (update-in pos [1] dec)))
          
          (right [[pos & stack]]
                 (conj stack (update-in pos [1] inc)))
          
          (up [[pos & stack]]
              (conj stack (update-in pos [0] dec)))
          
          (down [[pos & stack]]
                (conj stack (update-in pos [0] inc)))
          
          (dup [[pos :as stack]]
               (conj stack pos))
          
          (move [f n positions]
                ((apply comp
                        (interleave (repeat n f)
                                    (repeat n dup)))
                 positions))
          
          (out-of-bounds? [n [x y]]
                          (or (>= x n) (< x 0)
                              (>= y n) (< y 0)))
          
          (run [action-sequence n]
               (loop [[action arg & acs :as as] action-sequence
                      stack '()
                      positions '()]
                 (if (and (not (empty? stack))
                          (or (out-of-bounds? n (peek positions))
                              (empty? as)))
                   
                   (reverse (drop-while (partial out-of-bounds? n) 
                                        positions))
                   
                   (case action
                     :up    (recur acs
                                   (conj stack arg action)
                                   (move (comp up right) arg positions))
                     
                     :down  (recur acs
                                   (conj stack arg action)
                                   (move (comp down left) arg positions))
                     
                     :left  (recur acs
                                   (conj stack arg action)
                                   (move (comp left up) arg positions))
                     
                     :right (recur acs
                                   (conj stack arg action)
                                   (move (comp right down) arg 
                                         positions))
                     
                     :recur (recur (conj (apply arg (take 2 stack)) 
                                         action arg)
                                   (-> stack pop pop)
                                   positions)
                     
                     :start (recur acs
                                   (conj stack arg action)
                                   (conj positions arg))))))
          
          (empty-grid [n] (vec (repeat n (vec (repeat n \space)))))
          
          (squares [start end]
                   (loop [n start
                          squares []]
                     (if (> n end) squares
                       (recur (* n n)
                              (conj squares n)))))
          
          (rotated-grid-size [n] (- (* 2 n) 1))
          
          (square-container-size 
            [m]
            (loop [n 1]
              (if (>= (* n n) m) n
                (recur (inc n)))))
          
          (nav-expression
            [start-pos]
            [:start start-pos
             :right 1 
             :down 1
             :recur (fn [t n]
                      (case t
                        :down [:left  (inc n) :up   (inc n)]
                        :up   [:right (inc n) :down (inc n)]))])]
    
    (let [squares (apply str (squares start end))
          grid-size (square-container-size (count squares))
          n (rotated-grid-size grid-size)
          grid (empty-grid n)
          start-pos [(if (odd? (/ (- n 1) 2))
                       (dec (/ (- n 1) 2))
                       (/ (- n 1) 2))
                     (/ (- n 1) 2)]
          expr (nav-expression start-pos)
          indices (run expr n)]
      (->> (reduce (fn [grid [pos elem]]
                     (assoc-in grid pos elem))
                   grid
                   (map vector indices
                      (concat squares (repeat \*))))
           (map (fn [coll]
                  (apply str coll)))
           vec))))

(= (data-juggle 2 2) ["2"])

(= (data-juggle 2 4) [" 2 "
                      "* 4"
                      " * "])

(= (data-juggle 3 81) [" 3 "
                       "1 9"
                       " 8 "])

(= (data-juggle 4 20) [" 4 "
                       "* 1"
                       " 6 "])

(= (data-juggle 2 256) ["  6  "
                        " 5 * "
                        "2 2 *"
                        " 6 4 "
                        "  1  "])

(= (data-juggle 10 10000) ["   0   "
                           "  1 0  "
                           " 0 1 0 "
                           "* 0 0 0"
                           " * 1 * "
                           "  * *  "
                           "   *   "])


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Language of a DFA
;; Difficulty:	Hard
;; Topics:	automata seqs


;; A deterministic finite automaton (DFA) is an abstract machine that recognizes a regular language. Usually a DFA is defined by a 5-tuple, 
;; but instead we'll use a map with 5 keys:
;; :states is the set of states for the DFA.
;; :alphabet is the set of symbols included in the language recognized by the DFA.
;; :start is the start state of the DFA.
;; :accepts is the set of accept states in the DFA.
;; :transitions is the transition function for the DFA, mapping :states ⨯ :alphabet onto :states.
;;
;; Write a function that takes as input a DFA definition (as described above) and returns a sequence enumerating all strings in the language 
;; recognized by the DFA. Note: Although the DFA itself is finite and only recognizes finite-length strings it can still recognize an infinite 
;; set of finite-length strings. And because stack space is finite, make sure you don't get stuck in an infinite loop that's not producing 
;; results every so often!

(defn state-machine [machine]
  (letfn [(gen-strings 
            [{:keys [transitions accepts start]}]
            (letfn [(step [paths]
                          (lazy-seq 
                            (when-not (empty? paths)
                              (let [accepted (filter (comp accepts peek) paths)
                                    accepted-strings (map (comp #(apply str %) pop) accepted)]
                                (concat accepted-strings
                                        (step (for [path paths
                                                    [letter nxt] (transitions (peek path))]
                                                (conj (pop path) letter nxt))))))))]
              (step [[start]])))]
    (gen-strings machine)))

(= #{"a" "ab" "abc"}
   (set (state-machine '{:states #{q0 q1 q2 q3}
                         :alphabet #{a b c}
                         :start q0
                         :accepts #{q1 q2 q3}
                         :transitions {q0 {a q1}
                                       q1 {b q2}
                                       q2 {c q3}}})))

(= #{"hi" "hey" "hello"}
   (set (state-machine '{:states #{q0 q1 q2 q3 q4 q5 q6 q7}
                         :alphabet #{e h i l o y}
                         :start q0
                         :accepts #{q2 q4 q7}
                         :transitions {q0 {h q1}
                                       q1 {i q2, e q3}
                                       q3 {l q5, y q4}
                                       q5 {l q6}
                                       q6 {o q7}}})))

(= (set (let [ss "vwxyz"] (for [i ss, j ss, k ss, l ss] (str i j k l))))
   (set (state-machine '{:states #{q0 q1 q2 q3 q4}
                         :alphabet #{v w x y z}
                         :start q0
                         :accepts #{q4}
                         :transitions {q0 {v q1, w q1, x q1, y q1, z q1}
                                       q1 {v q2, w q2, x q2, y q2, z q2}
                                       q2 {v q3, w q3, x q3, y q3, z q3}
                                       q3 {v q4, w q4, x q4, y q4, z q4}}})))

(let [res (take 2000 (state-machine '{:states #{q0 q1}
                                      :alphabet #{0 1}
                                      :start q0
                                      :accepts #{q0}
                                      :transitions {q0 {0 q0, 1 q1}
                                                    q1 {0 q1, 1 q0}}}))]
  (and (every? (partial re-matches #"0*(?:10*10*)*") res)
       (= res (distinct res)))
  
  (let [res (take 2000 (state-machine '{:states #{q0 q1}
                                        :alphabet #{n m}
                                        :start q0
                                        :accepts #{q1}
                                        :transitions {q0 {n q0, m q1}}}))]
  (and (every? (partial re-matches #"n*m") res)
       (= res (distinct res)))))

(let [res (take 2000 (state-machine '{:states #{q0 q1 q2 q3 q4 q5 q6 q7 q8 q9}
                                      :alphabet #{i l o m p t}
                                      :start q0
                                      :accepts #{q5 q8}
                                      :transitions {q0 {l q1}
                                                    q1 {i q2, o q6}
                                                    q2 {m q3}
                                                    q3 {i q4}
                                                    q4 {t q5}
                                                    q6 {o q7}
                                                    q7 {p q8}
                                                    q8 {l q9}
                                                    q9 {o q6}}}))]
  (and (every? (partial re-matches #"limit|(?:loop)+") res)
       (= res (distinct res))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Love Triangle
;; Difficulty:	Hard
;; Topics:	search data-juggling


;; Everyone loves triangles, and it's easy to understand why—they're so wonderfully symmetric (except scalenes, they suck). 

;; Your passion for triangles has led you to become a miner (and part-time Clojure programmer) where you work all day to 
;; chip out isosceles-shaped minerals from rocks gathered in a nearby open-pit mine. There are too many rocks coming from 
;; the mine to harvest them all so you've been tasked with writing a program to analyze the mineral patterns of each rock, 
;; and determine which rocks have the biggest minerals. 

;; Someone has already written a computer-vision system for the mine. It images each rock as it comes into the processing 
;; center and creates a cross-sectional bitmap of mineral (1) and rock (0) concentrations for each one. 

;; You must now create a function which accepts a collection of integers, each integer when read in base-2 gives the 
;; bit-representation of the rock (again, 1s are mineral and 0s are worthless scalene-like rock). You must return the
;; cross-sectional area of the largest harvestable mineral from the input rock, as follows: 
;; The minerals only have smooth faces when sheared vertically or horizontally from the rock's cross-section
;; The mine is only concerned with harvesting isosceles triangles (such that one or two sides can be sheared)
;; If only one face of the mineral is sheared, its opposing vertex must be a point (ie. the smooth face must 
;;    be of odd length), and its two equal-length sides must intersect the shear face at 45° 
;;    (ie. those sides must cut even-diagonally)
;; The harvested mineral may not contain any traces of rock
;; The mineral may lie in any orientation in the plane
;; Area should be calculated as the sum of 1s that comprise the mineral
;; Minerals must have a minimum of three measures of area to be harvested
;; If no minerals can be harvested from the rock, your function should return nil

(defn love-triangle [nums]
  (letfn [(to-binary [n]
           (loop [ret () n n]
             (if (zero? n) ret
               (recur (conj ret (rem n 2))
                      (quot n 2)))))
          (pad [colls]
               (let [row-size (apply max (map count colls))]
                 (mapv (fn [coll]
                         (vec (concat (repeat (- row-size (count coll)) 0) coll)))
                       colls)))
          
          (mine-one [mine [row column :as pos]]
            {pos (count (for [i (range)
                              :while (and (< (+ row i) (count mine))
                                          (< (+ column i) (count (mine (+ row i)))))
                              :let [mineral-slice  (subvec (mine (+ row i)) 
                                                           column 
                                                           (+ column (inc i)))]
                              :while (apply = 1 mineral-slice)]
                          mineral-slice))})
                 
          (mine-all [mine]
            (apply merge
                   (for [i (range (count mine))
                         j (range (count (mine i)))
                         :when (= 1 ((mine i) j))]
                     (mine-one mine [i j]))))
          (triangular-series [n]
            (/ (* n (+ n 1)) 2))
                 
          (transpose [colls]
            (apply mapv vector colls))
          
          (invert [colls]
            (vec (rseq colls)))
                 
          (mrg [mine m1 m2]
            (concat (map triangular-series (vals m2))
                    (vec (for [[[row col] n] m2
                               :let [m (m2 [row (- (dec (count (mine row))) col)])]]
                           (if (and m (= n m))
                             (* n n)
                             (triangular-series n))))))]
    
    (let [grid (pad (map to-binary nums))
          map-invert (partial mapv invert)]
      
      (->> (concat (mrg grid
                        (mine-all grid)
                        (-> grid map-invert mine-all))
                   (mrg (-> grid transpose invert)
                        (-> grid transpose invert mine-all)
                        (-> grid transpose invert map-invert mine-all))
                   (mrg (invert grid)
                        (-> grid invert mine-all)
                        (-> grid invert map-invert mine-all))
                   (mrg (transpose grid)
                        (-> grid transpose mine-all) 
                        (-> grid transpose map-invert mine-all)))
           (apply max)
           ((fn [x] (if (> x 2) x nil)))))))


(= 10 (love-triangle [15 15 15 15 15]))
; 1111      1111
; 1111      *111
; 1111  ->  **11
; 1111      ***1
; 1111      ****

(= 15 (love-triangle [1 3 7 15 31]))
; 00001      0000*
; 00011      000**
; 00111  ->  00***
; 01111      0****
; 11111      *****

(= 3 (love-triangle [3 3]))
; 11      *1
; 11  ->  **

(= 4 (love-triangle [7 3]))
; 111      ***
; 011  ->  0*1

(= 6 (love-triangle [17 22 6 14 22]))
; 10001      10001
; 10110      101*0
; 00110  ->  00**0
; 01110      0***0
; 10110      10110

(= 6 (love-triangle [17 22 6 14 22]))
; 10001      10001
; 10110      101*0
; 00110  ->  00**0
; 01110      0***0
; 10110      10110

(= 9 (love-triangle [18 7 14 14 6 3]))
; 10010      10010
; 00111      001*0
; 01110      01**0
; 01110  ->  0***0
; 00110      00**0
; 00011      000*1

(= nil (love-triangle [21 10 21 10]))
; 10101      10101
; 01010      01010
; 10101  ->  10101
; 01010      01010

(= nil (love-triangle [0 31 0 31 0]))
; 00000      00000
; 11111      11111
; 00000  ->  00000
; 11111      11111
; 00000      00000
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Latin Square Slicing
;; Difficulty:	Hard
;; Topics:	data-analysis math


;; A Latin square of order n is an n x n array that contains n different elements, each occurring exactly 
;; once in each row, and exactly once in each column. For example, among the following arrays only the first 
;; one forms a Latin square:


;; A B C    A B C    A B C
;; B C A    B C A    B D A
;; C A B    C A C    C A B
 
;; Let V be a vector of such vectors1 that they may differ in length2. We will say that an arrangement of 
;; vectors of V in consecutive rows is an alignment (of vectors) of V if the following conditions are satisfied:

;; All vectors of V are used.
;; Each row contains just one vector.
;; The order of V is preserved.
;; All vectors of maximal length are horizontally aligned each other.
;; If a vector is not of maximal length then all its elements are aligned with elements of some subvector 
;; of a vector of maximal length.

;; Let L denote a Latin square of order 2 or greater. We will say that L is included in V or that V includes L 
;; iff there exists an alignment       of V such that contains a subsquare that is equal to L.

;; For example, if V equals [[1 2 3][2 3 1 2 1][3 1 2]] then there are nine alignments of V (brackets omitted):

 
;;        1              2              3
 
;;      1 2 3          1 2 3          1 2 3
;;  A   2 3 1 2 1    2 3 1 2 1    2 3 1 2 1
;;      3 1 2        3 1 2        3 1 2
 
;;      1 2 3          1 2 3          1 2 3
;;  B   2 3 1 2 1    2 3 1 2 1    2 3 1 2 1
;;        3 1 2        3 1 2        3 1 2
 
;;      1 2 3          1 2 3          1 2 3
;;  C   2 3 1 2 1    2 3 1 2 1    2 3 1 2 1
;;          3 1 2        3 1 2        3 1 2
 
;; Alignment A1 contains Latin square [[1 2 3][2 3 1][3 1 2]], alignments A2, A3, B1, B2, B3 contain no
;; Latin squares, and alignments C1, C2, C3 contain [[2 1][1 2]]. Thus in this case V includes one Latin 
;; square of order 3 and one of order 2 which is included three times.

;; Our aim is to implement a function which accepts a vector of vectors V as an argument, and returns a map 
;; which keys and values are integers. Each key should be the order of a Latin square included in V, and its 
;; value a count of different Latin squares of that order included in V. If V does not include any Latin squares 
;; an empty map should be returned. In the previous example the correct output of such a function is {3 1, 2 1} 
;; and not {3 1, 2 3}.

;; [1] Of course, we can consider sequences instead of vectors. 
;; [2] Length of a vector is the number of elements in the vector.


;; A rather horrifying solution
(defn find-latin-squares [colls]
  (letfn [(latin-square? [colls]
            (let [t (map set colls)]
              (and (apply = t)
                   (apply = (map set (apply map list colls)))
                   (= (map count t) (map count colls)))))
          (alignments [colls]
            (let [longest (apply max (map count colls))]
              (for [[i coll] (mapv vector (range) colls)]
                (for [j (range (- (inc longest) (count coll)))]
                  [i j]))))
          (product [colls]
            (if (empty? colls) (list nil)
              (for [x (first colls)
                    xs (product (rest colls))]
                (cons x xs))))
          (squares [colls]
            (let [mx (apply max (map count colls))]
              (for [alignment (product (alignments colls))]
                (reduce (fn [ret [row offset]]
                          (update-in ret 
                                     [row] 
                                     (fn [coll] 
                                       (concat (repeat offset 0) 
                                               coll
                                               (repeat (- mx (+ offset (count coll))) 0))))) 
                        colls
                        alignment))))]
    (let [squares (squares colls)
          longest-row (apply max (map count colls))]
      (->> (for [square squares
                 size (range 2 (inc longest-row))]
             (map #(apply mapv vector %) 
                  (partition size 1 
                             (map (partial partition size 1) square))))
           (apply concat)
           (apply concat)
           (remove #(some (fn [x] (= x 0)) (apply concat %)))
           (filter latin-square?)
           set
           (map (comp count set))
           frequencies))))


(= (find-latin-squares 
       '[[A B C D]
         [A C D B]
         [B A D C]
         [D C A B]])
   {})

(= (find-latin-squares
       '[[A B C D E F]
         [B C D E F A]
         [C D E F A B]
         [D E F A B C]
         [E F A B C D]
         [F A B C D E]])
   {6 1})

(= (find-latin-squares
       '[[A B C D]
         [B A D C]
         [D C B A]
         [C D A B]])
   {4 1, 2 4})

(= (find-latin-squares
       '[[B D A C B]
         [D A B C A]
         [A B C A B]
         [B C A B C] 
         [A D B C A]])
   {3 3})

(= (find-latin-squares
       [  [2 4 6 3]
        [3 4 6 2]
          [6 2 4]  ])
   {})

(= (find-latin-squares
       [[1]
        [1 2 1 2]
        [2 1 2 1]
        [1 2 1 2]
        []       ])
   {2 2})

(= (find-latin-squares
       [[3 1 2]
        [1 2 3 1 3 4]
        [2 3 1 3]    ])
   {3 1, 2 2})

(= (find-latin-squares
       [[8 6 7 3 2 5 1 4]
        [6 8 3 7]
        [7 3 8 6]
        [3 7 6 8 1 4 5 2]
              [1 8 5 2 4]
              [8 1 2 4 5]])
   {4 1, 3 1, 2 7})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; Veitch, Please!
;; Difficulty:	Hard
;; Topics:	math circuit-design


;; Create a function which accepts as input a boolean algebra function in the form of a set of sets, where the inner sets 
;; are collections of symbols corresponding to the input boolean variables which satisfy the function (the inputs of the 
;; inner sets are conjoint, and the sets themselves are disjoint... also known as canonical minterms). Note: capitalized 
;; symbols represent truth, and lower-case symbols represent negation of the inputs. Your function must return the minimal 
;; function which is logically equivalent to the input. 

;; PS — You may want to give this a read before proceeding: K-Maps


(defn veitch [terms]                                                                                                    
  (letfn [(mrg [ret [a b]]                                                                                              
            (let [ab (clojure.set/intersection a b)]                                                                    
              (if (and (= (count ab) (dec (count a)))                                                                   
                       (= (.toLowerCase (str (first (clojure.set/difference a ab))))                                    
                          (.toLowerCase (str (first (clojure.set/difference b ab))))))                                  
                (disj (conj ret ab) a b)                                                                                
                ret)))
          (reduce-pairwise [terms]                                                                                      
            (let [v (vec terms)]                                                                                        
              (reduce mrg                                                                                               
                      terms                                                                                             
                      (for [i (range (count v))                                                                         
                            j (range (inc i) (count v))]                                                                
                        [(v i) (v j)]))))                                                                               
          (tautology? [expr]                                                                                            
            (let [vars (apply clojure.set/union expr)                                                                             
                  complement* {'a 'A 'A 'A 'b 'B 'B 'b 'C                                                               
                               'c 'c 'C 'd 'D 'D 'd}]                                                                   
              (and (not (empty? vars))                                                                                  
                   (every? #(contains? vars (complement* %)) vars))))                                                   
          (remove-tautologies [expr]                                                                                    
            (reduce (fn [ret term]                                                                                      
                      (let [e (->> (disj ret term)                                                                      
                                   (map (fn [t] (clojure.set/difference t term)))                                                       
                                   set)]                                                                                
                        (if (tautology? e) (disj ret term) ret)))                                                       
                    expr
                    expr))] 
    (->> terms                                                                                                          
         (iterate reduce-pairwise)                                                                                      
         (partition 2 1)                                                                                                
         (drop-while (partial apply not=))                                                                           
         ffirst                                                                                                         
         remove-tautologies)))




(= (veitch
       #{#{'a 'B 'C 'd}
         #{'A 'b 'c 'd}
         #{'A 'b 'c 'D}
         #{'A 'b 'C 'd}
         #{'A 'b 'C 'D}
         #{'A 'B 'c 'd}
         #{'A 'B 'c 'D}
         #{'A 'B 'C 'd}})
   #{#{'A 'c} 
     #{'A 'b}
     #{'B 'C 'd}})

(= (veitch
       #{#{'A 'B 'C 'D}
         #{'A 'B 'C 'd}})
   #{#{'A 'B 'C}})

(= (veitch
       #{#{'a 'b 'c 'd}
         #{'a 'B 'c 'd}
         #{'a 'b 'c 'D}
         #{'a 'B 'c 'D}
         #{'A 'B 'C 'd}
         #{'A 'B 'C 'D}
         #{'A 'b 'C 'd}
         #{'A 'b 'C 'D}})
   #{#{'a 'c}
     #{'A 'C}})

	

(= (veitch
       #{#{'a 'b 'c} 
         #{'a 'B 'c}
         #{'a 'b 'C}
         #{'a 'B 'C}})
   #{#{'a}})


(= (veitch
       #{#{'a 'B 'c 'd}
         #{'A 'B 'c 'D}
         #{'A 'b 'C 'D}
         #{'a 'b 'c 'D}
         #{'a 'B 'C 'D}
         #{'A 'B 'C 'd}})
   #{#{'a 'B 'c 'd}
     #{'A 'B 'c 'D}
     #{'A 'b 'C 'D}
     #{'a 'b 'c 'D}
     #{'a 'B 'C 'D}
     #{'A 'B 'C 'd}})

(= (veitch
       #{#{'a 'b 'c 'd}
         #{'a 'B 'c 'd}
         #{'A 'B 'c 'd}
         #{'a 'b 'c 'D}
         #{'a 'B 'c 'D}
         #{'A 'B 'c 'D}})
   #{#{'a 'c}
     #{'B 'c}})

(= (veitch
       #{#{'a 'B 'c 'd}
         #{'A 'B 'c 'd}
         #{'a 'b 'c 'D}
         #{'a 'b 'C 'D}
         #{'A 'b 'c 'D}
         #{'A 'b 'C 'D}
         #{'a 'B 'C 'd}
         #{'A 'B 'C 'd}})
   #{#{'B 'd}
     #{'b 'D}})

(= (veitch
       #{#{'a 'b 'c 'd}
         #{'A 'b 'c 'd}
         #{'a 'B 'c 'D}
         #{'A 'B 'c 'D}
         #{'a 'B 'C 'D}
         #{'A 'B 'C 'D}
         #{'a 'b 'C 'd}
         #{'A 'b 'C 'd}})
   #{#{'B 'D}
     #{'b 'd}})


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

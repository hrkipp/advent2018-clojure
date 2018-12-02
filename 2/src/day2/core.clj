(ns day2.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn has-n-dups [n string]
  (seq (filter #(= (second %) n) (frequencies string))))

(defn checksum [strings] 
  (* 
    (count (filter (partial has-n-dups 3) strings))
    (count (filter (partial has-n-dups 2) strings))))

(defn distance [[s1 s2]]
  (count (filter false? (map = s1 s2))))

(defn all-pairs [sq] (for [i sq j sq] [i j]))

(defn diff [[s1 s2]] 
  (str/join (map #(if (= %1 %2) %1 "") s1 s2)))

(defn -main [& args]
  (let [strings (str/split (slurp "input") #"\n")]
    (println (checksum strings))
    (println (diff (first (filter #(= 1 (distance %)) (all-pairs strings)))))))

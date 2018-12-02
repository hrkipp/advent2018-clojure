(ns day1.core
  (:require [clojure.string :as str])
  (:gen-class))

(def numbers (map read-string (str/split (slurp "input") #"\n")))

(defn loop-forever [numbers] (flatten (repeat numbers)))

(defn first-dup
  "Returns the first duplicate entry in the sequence"
  ([numbers]
   (first-dup numbers #{}))
  ([numbers seen]
   (let [x (first numbers)]
     (if (contains? seen x)
       x
       (recur (rest numbers) (conj seen x))))))

(defn -main [& args]
  (println (reduce + numbers))
  (println (first-dup (reductions + (loop-forever numbers)))))

(ns square-clojure.api.employees
  (:require [square-clojure.core :refer :all]))

(defn square-employees [token]
  (parse-string (square-get "me/employees?status=ACTIVE" token)))

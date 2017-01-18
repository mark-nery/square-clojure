(ns square-clojure.api.employees
  (:require [square-clojure.core :refer :all]))

(defn list-employees [token]
  (square-get "me/employees?status=ACTIVE" token))

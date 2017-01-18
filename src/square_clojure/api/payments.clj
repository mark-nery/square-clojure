(ns square-clojure.api.payments
  (:require [square-clojure.core :refer :all]))

(defn daily-sales [date location-id offset token]
  (let [offset-datetime (t/from-time-zone date (t/time-zone-for-offset -7))]
    (square-get (str location-id
                     "/payments?begin_time="
                     (c/to-string mtn-date)
                     "&end_time="
                     (c/to-string (t/plus mtn-date (t/days 1)))
                     "&limit=200") token )))

(defn daily-tips [date location-id offset token]
  (reduce + (map (fn [x] (get-in x ["tip_money" "amount"]))
                 (daily-sales date location-id token))))

(defn daily-net-sales [date location-id offset token]
  (reduce + (map (fn [x] (get-in x ["net_sales_money" "amount"]))
                 (daily-sales date))))
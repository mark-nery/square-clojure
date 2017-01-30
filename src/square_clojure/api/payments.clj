(ns square-clojure.api.payments
  (:require [square-clojure.core :refer :all]
            [clj-time.core :as t]
            [clj-time.coerce :as c]))

(defn daily-sales [date location-id offset token]
  (let [offset-datetime (t/from-time-zone date (t/time-zone-for-offset offset))]
    (square-get (str
                 location-id
                 "/payments?begin_time="
                 (c/to-string offset-datetime)
                 "&end_time="
                 (c/to-string (t/plus offset-datetime (t/days 1)))
                 "&limit=200") token )))

(defn daily-tips [date location-id offset token]
  (reduce + (map (fn [x] (get-in x ["tip_money" "amount"]))
                 (daily-sales date location-id token))))

(defn daily-net-sales [date location-id offset token]
  (reduce + (map (fn [x] (get-in x ["net_sales_money" "amount"]))
                 (daily-sales date))))

(ns square-clojure.api.timecards
  (:require [square-clojure.core :refer :all]))

(defn daily-timecard [date token offset]
  (let [offset-datetime (t/from-time-zone date (t/time-zone-for-offset offset))]
    (square-get (str "me/timecards?begin_clockin_time="
                     (c/to-string offset-datetime)
                     "&end_clockin_time="
                     (c/to-string (t/plus offset-datetime (t/days 1)))
                     "&limit=200"
                     )
                token)))

(defn daily-employee-minutes [date token offset]
  (map
   (fn [x] (hash-map :employee-id (get x "employee_id"),
                    :minutes (t/in-minutes (t/interval
                                            (c/from-string (get x "clockin_time"))
                                            (c/from-string (get x "clockout_time"))))))
   (daily-timecard date token offet)))

(ns square-clojure.core
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]
            [clj-time.core :as t]
            [clj-time.format :as f]
            [clj-time.coerce :as c]
            [clj-time.periodic :as time-period]
            [square-clojure.api :refer :all]))


(defn square-get [endpoint token]
  (parse-string (get (client/get
                      (str "https://connect.squareup.com/v1/" endpoint)
                      {:headers {(str "Authorization" "Bearer " token)}})
                     :body)))

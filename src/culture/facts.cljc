(ns culture.facts
  "Regional-culture catalog for Manila -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto this
  municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"manila"
   [{:culture/id "manila.dish.adobo"
     :culture/name "Philippine adobo"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :dish
     :culture/summary "Meat or seafood cooked in vinegar, soy sauce, garlic and spices, often considered the unofficial national dish of the Philippines rather than a Manila-specific one."
     :culture/url "https://en.wikipedia.org/wiki/Philippine_adobo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.dish.sinigang"
     :culture/name "Sinigang"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :dish
     :culture/summary "Filipino sour soup or stew, present nationwide and seen as culturally Tagalog in origin."
     :culture/url "https://en.wikipedia.org/wiki/Sinigang"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.dish.pancit-malabon"
     :culture/name "Pancit Malabon"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :dish
     :culture/summary "Type of pancit with thick rice noodles and a yellow-orange sauce of annatto, shrimp broth, fish sauce and crab fat, originating from Malabon in Metro Manila."
     :culture/url "https://en.wikipedia.org/wiki/Pancit_Malabon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.dish.halo-halo"
     :culture/name "Halo-halo"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :dish
     :culture/summary "Popular cold shaved-ice dessert considered the unofficial national dessert of the Philippines, whose development is linked to Quiapo, Manila."
     :culture/url "https://en.wikipedia.org/wiki/Halo-halo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.beverage.san-miguel-beer"
     :culture/name "San Miguel Beer"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :beverage
     :culture/summary "Beer whose original brewery, La Fabrica de Cerveza San Miguel, was founded in 1890 in San Miguel, Manila, by Enrique Maria Barreto."
     :culture/url "https://en.wikipedia.org/wiki/San_Miguel_Beer"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.product.manila-hemp"
     :culture/name "Manila hemp"
     :culture/name-local "abaka"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :product
     :culture/summary "Fiber extracted from the leaf-stems of abaca, a plant endemic to the Philippines, named 'Manila hemp' after the capital city and historically used for rope and textiles."
     :culture/url "https://en.wikipedia.org/wiki/Manila_hemp"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.festival.feast-of-the-black-nazarene"
     :culture/name "Feast of the Black Nazarene"
     :culture/name-local "Pista ng Itim na Nazareno"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :festival
     :culture/summary "Feast of the dark statue of Jesus Christ enshrined at Quiapo Church in Manila; its annual Traslacion procession on January 9 attracts millions of devotees."
     :culture/url "https://en.wikipedia.org/wiki/Black_Nazarene"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.heritage.intramuros"
     :culture/name "Intramuros"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :heritage
     :culture/summary "Historic 0.67 km2 walled area within the city of Manila, established in 1571 by Miguel Lopez de Legazpi as the capital of Spain's Philippine colony."
     :culture/url "https://en.wikipedia.org/wiki/Intramuros"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "manila.heritage.san-agustin-church"
     :culture/name "San Agustin Church"
     :culture/name-local "Simbahan ng San Agustin"
     :culture/municipality "manila"
     :culture/country "PHL"
     :culture/kind :heritage
     :culture/summary "Oldest stone church in the Philippines (completed 1607), in Manila, a UNESCO World Heritage Site since 1993 as part of the Baroque Churches of the Philippines."
     :culture/url "https://en.wikipedia.org/wiki/San_Agustin_Church_(Manila)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-phl-manila culture catalog "
                 "(ADR-2607171400): " (count (get catalog "manila"))
                 " Manila entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))

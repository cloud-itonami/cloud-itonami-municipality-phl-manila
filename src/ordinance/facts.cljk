(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Manila -- the
  THIRTY-FIFTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta for the first thirty-four) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Manila's capital status was regained via presidential order in 1976
  after Quezon City briefly served as capital (1948-1976) -- the
  pre-existing organization.edn's Manila designation correctly
  matches this current, post-1976 status, similar in spirit to the
  Vietnam Hanoi/Hue and Indonesia Jakarta/Nusantara capital-history
  checks earlier this session.

  Republic Act No. 409 (Revised Charter of the City of Manila) --
  title/number confirmed via lawphil.net (a well-established Philippine
  legal database); the exact 18 June 1949 approval date is corroborated
  via the Official Gazette's own permalink URL structure
  (officialgazette.gov.ph/1949/06/18/republic-act-no-409/ -- the page
  itself returned HTTP 403, but the Gazette's URLs are structured by
  actual publication date, not arbitrary). City Ordinance No. 9107
  (prohibiting misuse of 4Ps conditional-cash-transfer program cards)
  -- title, number, and exact date (11 April 2025) directly confirmed
  via citycouncilofmanila.com.ph's own HTML ordinance-listing page for
  the 12th City Council.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"manila"
   [{:ordinance/id "manila.republic-act-409-revised-charter-1949"
     :ordinance/title "Revised Charter of the City of Manila (Republic Act No. 409)"
     :ordinance/municipality "manila"
     :ordinance/country "PHL"
     :ordinance/kind :local-act
     :ordinance/number "Republic Act No. 409"
     :ordinance/url "https://lawphil.net/statutes/repacts/ra1949/ra_409_1949.html"
     :ordinance/url-provenance :lawphil-net-legal-database
     :ordinance/enacted-date "1949-06-18"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "manila.ordinance-9107-2025-4ps-cash-cards"
     :ordinance/title "City Ordinance No. 9107 prohibiting misuse of 4Ps cash cards"
     :ordinance/municipality "manila"
     :ordinance/country "PHL"
     :ordinance/kind :ordinance
     :ordinance/number "No. 9107"
     :ordinance/url "https://citycouncilofmanila.com.ph/council_number/12th-city-council/"
     :ordinance/url-provenance :official-citycouncilofmanila-com-ph
     :ordinance/enacted-date "2025-04-11"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:consumer-protection}}]})

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
      :note (str "cloud-itonami-municipality-phl-manila Wave 0 (ADR-2607141700): "
                 (count (get catalog "manila")) " Manila entries seeded "
                 "with lawphil.net/citycouncilofmanila.com.ph citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))

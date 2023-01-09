<template>
    <div id="content">
      <div id="divTitle">
        <p class="title">Katalog naciągów</p>
      </div>
      <div id="contentRacketStringsWithPagination" v-if="loaded">
        <div id="contentRacketStrings" class="box">
          <div id="cols" class="columns">
            <div class="column">
              <itemTile
                v-for="racketString in this.splitToThreeColumns(
                  paginatedRacketStrings
                )[0]"
                :key="racketString.name"
                :item="racketString"
                style="cursor: pointer"
              />
            </div>
            <div class="column">
              <itemTile
                v-for="racketString in this.splitToThreeColumns(
                  paginatedRacketStrings
                )[1]"
                :key="racketString.name"
                :item="racketString"
                style="cursor: pointer"
              />
            </div>
            <div class="column">
              <itemTile
                v-for="racketString in this.splitToThreeColumns(
                  paginatedRacketStrings
                )[2]"
                :key="racketString.name"
                :item="racketString"
                style="cursor: pointer"
              />
            </div>
          </div>
        </div>
  
        <br />
  
        <div id="contentPagination" class="columns">
          <div class="column is-two-thirds"></div>
          <div class="box column is-one-third">
            <b-pagination
              order="is-centered"
              :total="racketStrings.length"
              :per-page="perPage"
              :current.sync="current"
              @change="scrollToTop"
            ></b-pagination>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { mapActions, mapState } from "vuex";
  import itemTile from "../item/itemTile.vue";
  
  export default {
    name: "racketStringsCatalog",
    components: {
      itemTile,
    },
  
    data() {
      return {
        loaded: false,
        current: 1,
        perPage: 42,
        pageOfItems: [],
      };
    },
  
    methods: {
      ...mapActions("racketString", ["getRacketStrings"]),
  
      splitToThreeColumns(racketStrings) {
        let firstColumn = [];
        let secondColumn = [];
        let thirdColumn = [];
  
        for (let i = 0; i < racketStrings.length; i++) {
          if (i % 3 == 0) {
            firstColumn.push(racketStrings[i]);
          } else if (i % 3 == 1) {
            secondColumn.push(racketStrings[i]);
          } else {
            thirdColumn.push(racketStrings[i]);
          }
        }
  
        return [firstColumn, secondColumn, thirdColumn];
      },
  
      onChangePage(pageOfItems) {
        this.pageOfItems = pageOfItems;
      },
  
      scrollToTop() {
        document.querySelector("#contentRacketStrings").scrollTo(0, 0);
      },
    },
  
    computed: {
      ...mapState({
        racketStrings: (state) => state.racketString.racketStrings,
      }),
  
      paginatedRacketStrings() {
        let page_number = this.current - 1;
  
        return this.racketStrings.slice(
          page_number * this.perPage,
          (page_number + 1) * this.perPage
        );
      },
    },
  
    mounted() {
      this.getRacketStrings().then(() => (this.loaded = true));
    },
  };
  </script>
  
  <style scoped>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  
  #content {
    display: flex;
    flex-flow: column;
    position: relative;
    padding: 10px;
    height: 100%;
    word-wrap: anywhere;
    white-space: normal;
    background-color: green;
  }
  
  #divTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    justify-content: space-between;
  }
  
  .title {
    margin-bottom: 20px;
    padding: 10px;
    font-size: 40px;
    text-align: left;
  }
  
  #contentRacketStringsWithPagination {
    display: flex;
    flex: 1 0 0px;
    flex-flow: column;
    margin: 0;
    padding: 0; 
    width: 100%;
    height: 77vh;
    overflow: hidden;
  }
  
  #contentRacketStrings {
    flex: 1 0 0px;
    margin: 10px;
    /* min-height: 70%; */
    background-color: white;
    box-shadow: black;
    overflow: auto;
  }
  
  #contentPagination {
    display: flex;
    padding-bottom: 20px; 
    padding-right: 5px;
    width: 100%; 
  }
  
  #cols {
    margin: 0;
  }
  </style>
  
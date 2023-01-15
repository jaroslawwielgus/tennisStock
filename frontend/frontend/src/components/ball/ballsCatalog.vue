<template>
    <div id="contentCatalog">
      <div id="divTitle">
        <p class="title">Katalog piłek</p>
      </div>
      <div id="contentItemsWithPagination" v-if="loaded">
        <div id="contentItems" class="box">
          <div id="cols" class="columns">
            <div class="column">
              <itemTile
                v-for="ball in this.splitToFourColumns(
                  paginatedBalls
                )[0]"
                :key="ball.name"
                :item="ball"
                style="cursor: pointer"
                @click.native="moveToBall(ball.id)"
              />
            </div>
            <div class="column">
              <itemTile
                v-for="ball in this.splitToFourColumns(
                  paginatedBalls
                )[1]"
                :key="ball.name"
                :item="ball"
                style="cursor: pointer"
                @click.native="moveToBall(ball.id)"
              />
            </div>
            <div class="column">
              <itemTile
                v-for="ball in this.splitToFourColumns(
                  paginatedBalls
                )[2]"
                :key="ball.name"
                :item="ball"
                style="cursor: pointer"
                @click.native="moveToBall(ball.id)"
              />
            </div>
            <div class="column">
              <itemTile
                v-for="ball in this.splitToFourColumns(
                  paginatedBalls
                )[3]"
                :key="ball.name"
                :item="ball"
                style="cursor: pointer"
                @click.native="moveToBall(ball.id)"
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
              :total="balls.length"
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
    name: "ballsCatalog",
    components: {
      itemTile,
    },
  
    data() {
      return {
        loaded: false,
        current: 1,
        perPage: 20,
        pageOfItems: [],
      };
    },
  
    methods: {
      ...mapActions("ball", ["getBalls"]),
  
      splitToFourColumns(balls) {
        let firstColumn = [];
        let secondColumn = [];
        let thirdColumn = [];
        let fourthColumn = [];
  
        for (let i = 0; i < balls.length; i++) {
          if (i % 4 == 0) {
            firstColumn.push(balls[i]);
          } else if (i % 4 == 1) {
            secondColumn.push(balls[i]);
          } else if (i % 4 == 2) {
            thirdColumn.push(balls[i]);
          } else {
            fourthColumn.push(balls[i]);
          }
        }
  
        return [firstColumn, secondColumn, thirdColumn, fourthColumn];
      },
  
      onChangePage(pageOfItems) {
        this.pageOfItems = pageOfItems;
      },

      moveToBall(ballId) {
        this.$router.push(`/ball/${ballId}`);
      },
  
      scrollToTop() {
        document.querySelector("#contentItems").scrollTo(0, 0);
      },
    },
  
    computed: {
      ...mapState({
        balls: (state) => state.ball.balls,
      }),
  
      paginatedBalls() {
        let page_number = this.current - 1;
  
        return this.balls.slice(
          page_number * this.perPage,
          (page_number + 1) * this.perPage
        );
      },
    },
  
    mounted() {
      document.title = "Piłki - TennisStock";
      this.getBalls().then(() => (this.loaded = true));
    },
  };
  </script>
  
  <style>
  #contentCatalog {
    display: flex;
    flex-flow: column;
    position: relative;
    padding: 10px;
    height: 100%;
    word-wrap: anywhere;
    white-space: normal;
  }
  
  .title {
    margin-bottom: 20px;
    padding: 10px;
    font-size: 36px;
    text-align: left;
  }
  
  #contentItemsWithPagination {
    display: flex;
    flex: 1 0 0px;
    flex-flow: column;
    margin: 0;
    padding: 0; 
    width: 100%;
    height: 77vh;
    overflow: hidden;
  }
  
  #contentItems {
    flex: 1 0 0px;
    margin: 10px;
    /* min-height: 70%; */
    box-shadow: var(--box-shadow);
    overflow: auto;
  }
  
  #contentPagination {
    display: flex;
    padding: 20px 0; 
    padding-right: 5px;
    width: 100%; 
  }
  
  #cols {
    margin: 0;
  }
  </style>

  <style scoped>
  #divTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    justify-content: space-between;
  }
  </style>
  
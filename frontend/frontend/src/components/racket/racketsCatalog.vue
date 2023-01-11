<template>
  <div id="content">
    <div id="divTitle">
      <p class="title">Katalog rakiet</p>
    </div>
    <div id="contentRacketsWithPagination" v-if="loaded">
      <div id="contentRackets" class="box">
        <div id="cols" class="columns">
          <div class="column">
            <itemTile
              v-for="racket in this.splitToFourColumns(
                paginatedRackets
              )[0]"
              :key="racket.name"
              :item="racket"
              style="cursor: pointer"
              @click.native="moveToRacket(racket.id)"
            />
          </div>
          <div class="column">
            <itemTile
              v-for="racket in this.splitToFourColumns(
                paginatedRackets
              )[1]"
              :key="racket.name"
              :item="racket"
              style="cursor: pointer"
              @click.native="moveToRacket(racket.id)"
            />
          </div>
          <div class="column">
            <itemTile
              v-for="racket in this.splitToFourColumns(
                paginatedRackets
              )[2]"
              :key="racket.name"
              :item="racket"
              style="cursor: pointer"
              @click.native="moveToRacket(racket.id)"
            />
          </div>
          <div class="column">
            <itemTile
              v-for="racket in this.splitToFourColumns(
                paginatedRackets
              )[3]"
              :key="racket.name"
              :item="racket"
              style="cursor: pointer"
              @click.native="moveToRacket(racket.id)"
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
            :total="rackets.length"
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
  name: "racketsCatalog",
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
    ...mapActions("racket", ["getRackets"]),

    splitToFourColumns(rackets) {
      let firstColumn = [];
      let secondColumn = [];
      let thirdColumn = [];
      let fourthColumn = [];

      for (let i = 0; i < rackets.length; i++) {
        if (i % 4 == 0) {
          firstColumn.push(rackets[i]);
        } else if (i % 4 == 1) {
          secondColumn.push(rackets[i]);
        } else if (i % 4 == 2) {
          thirdColumn.push(rackets[i]);
        } else {
          fourthColumn.push(rackets[i]);
        }
      }

      return [firstColumn, secondColumn, thirdColumn, fourthColumn];
    },

    onChangePage(pageOfItems) {
      this.pageOfItems = pageOfItems;
    },

    moveToRacket(racketId) {
      this.$router.push(`/racket/${racketId}`);
    },

    scrollToTop() {
      document.querySelector("#contentRackets").scrollTo(0, 0);
    },
  },

  computed: {
    ...mapState({
      rackets: (state) => state.racket.rackets,
    }),

    paginatedRackets() {
      let page_number = this.current - 1;

      return this.rackets.slice(
        page_number * this.perPage,
        (page_number + 1) * this.perPage
      );
    },
  },

  mounted() {
    this.getRackets().then(() => (this.loaded = true));
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

#contentRacketsWithPagination {
  display: flex;
  flex: 1 0 0px;
  flex-flow: column;
  margin: 0;
  padding: 0; 
  width: 100%;
  height: 77vh;
  overflow: hidden;
}

#contentRackets {
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

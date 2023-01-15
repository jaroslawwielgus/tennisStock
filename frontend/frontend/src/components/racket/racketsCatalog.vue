<template>
  <div id="contentCatalog">
    <div id="divTitle">
      <p class="title">Katalog rakiet</p>
    </div>
    <div id="contentItemsWithPagination" v-if="loaded">
      <div id="contentItems" class="box">
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
      document.querySelector("#contentItems").scrollTo(0, 0);
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
    document.title = "Rakiety - TennisStock";
    this.getRackets().then(() => (this.loaded = true));
  },
};
</script>

<style></style>

<style scoped>
#divTitle {
    display: flex;
    width: 100%;
    flex-direction: row;
    justify-content: space-between;
}
</style>

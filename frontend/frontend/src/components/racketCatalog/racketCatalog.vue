<template>
  <div id="container">
    <div>
      <p class="title">Katalog rakiet</p>
    </div>
    <div id="content">
      <div id="contentOuter" class="columns" v-if="loaded">
        <div
          id="contentInner"
          class="box column"
        >
          <div id="cols" class="columns">
            <div class="column">
              <racketTile
                v-for="racket in this.splitToThreeColumns(
                  rackets
                )[0]"
                :key="racket.name"
                :racket="racket"
                style="cursor: pointer"
                @click.native="chooseRacket(racket)"
              />
            </div>
            <div class="column">
              <racketTile
                v-for="racket in this.splitToThreeColumns(
                  rackets
                )[1]"
                :key="racket.name"
                :racket="racket"
                style="cursor: pointer"
                @click.native="chooseRacket(racket)"
              />
            </div>
            <div class="column">
              <racketTile
                v-for="racket in this.splitToThreeColumns(
                  rackets
                )[2]"
                :key="racket.name"
                :racket="racket"
                style="cursor: pointer"
                @click.native="chooseRacket(racket)"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import racketTile from "./racketTile.vue";

export default {
  name: "racketsCatalog",
  components: {
    racketTile,
  },

  data() {
    return {
      loaded: false,
      chosenRacket: null,
    };
  },

  methods: {
    ...mapActions("racket", ["getRackets"]),
    splitToThreeColumns(rackets) {
      let firstColumn = [];
      let secondColumn = [];
      let thirdColumn = [];

      for (let i = 0; i < rackets.length; i++) {
        if (i % 3 == 0) {
          firstColumn.push(rackets[i]);
        } else if (i % 3 == 1) {
          secondColumn.push(rackets[i]);
        } else {
          thirdColumn.push(rackets[i]);
        }
      }

      return [firstColumn, secondColumn, thirdColumn];
    },

    chooseRacket(racket) {
      this.chosenRacket = racket;
    },
  },

  computed: {
    ...mapState({
      rackets: (state) => state.racket.rackets,
    }),
  },

  mounted() {
    this.getRackets().then(() => (this.loaded = true));
  },
};
</script>

<style scoped>
#container {
  display: flex; 
  flex-flow: column;
  padding: 10px;
  height: 100%;
  position: relative;
  word-wrap: anywhere;
  white-space: normal;
  background-color: green;
}

.title {
  font-size: 40px;
  padding: 10px;
  text-align: left;
}

#content{
  overflow: auto; 
  height: 100%;
}

#contentOuter {
  height: 100%; 
  width: 100%;
  margin: 0;
}

#contentInner {
  max-height: 100%; 
  overflow: auto;
}

#cols {
  margin: 0;
}
</style>
<template>
  <div id="content">
    <div id="divTitle">
      <p class="name n-p">{{ racket.name }}</p>
      <p class="price n-p">{{ racket.price }} zł</p>
    </div>
    <div id="divImage">
      <img id="i" v-bind:src="racket.image" v-bind:alt="racket.name">
    </div>
    <div id="divDescWithSpecs">
      <div id="divDescOuter">
        <p class="d-s">Opis</p>
        <div id="divDescInner" class="box">
          <p class="desc-content">{{ racket.description }}</p>
        </div>
      </div>
      <div id="divSpecsOuter">
        <p class="d-s">Specyfikacja</p>
        <div id="divSpecsInner" class="box">
          <table id="tab">
            <tr>
              <td id="col1">Waga z naciągiem: </td>
              <td id="col2">{{ racket.strungWeight }} g</td>
            </tr>
            <tr>
              <td id="col1">Balans z naciągiem: </td>
              <td id="col2">{{ racket.balance }} cm</td>
            </tr>
            <tr>
              <td id="col1">Powierzchnia główki: </td>
              <td id="col2">{{ racket.headSize }} cm2</td>
            </tr>
            <tr>
              <td id="col1">Układ strun: </td>
              <td id="col2">{{ racket.stringPattern }}</td>
            </tr>
            <tr>
              <td id="col1">Długość: </td>
              <td id="col2">{{ racket.length }} cm</td>
            </tr>
            <tr>
              <td id="col1">Profil ramy: </td>
              <td id="col2">{{ racket.beamWidth }} mm</td>
            </tr>
            <tr>
              <td id="col1">Sztywność: </td>
              <td id="col2">{{ racket.stiffness }}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

export default {
  name: "racketPanel",
  data() {
    return {
      loaded: false,
    }
  },
  mounted() {
    this.getRacket(this.$route.params.id).then(() => {
      this.loaded = true;
    })
    document.title = "Rakieta " + this.$route.params.id + " - TennisStock";
  },
  methods: {
    ...mapActions("racket", ["getRacket"])
  },
  watch: {
    $route() {
      this.loaded = false;
      this.getRacket(this.$route.params.id).then(() => {
        this.loaded = true;
      });
    }
  },
  computed: {
    ...mapState({
      racket: (state) => state.racket.racket,
    }),
  }
}
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
  text-align: center;
  /* background-color: green; */
}

#divTitle {
  display: flex;
  margin-bottom: 20px;
  width: 100%;
  flex-direction: row;
  justify-content: space-between;
}

.n-p {
  padding: 10px;
  font-size: 40px;
  font-weight: 600;
  color: #363636;
  line-height: 1.125;
}
.name {
  text-align: left;
}

.price {
  text-align: right;
}

#divImage {
  padding-top: 2px;
  width: 100%;
}

#i {
  height: 400px;
  object-fit: contain;
  filter: brightness(98%);
  border-radius: 6px;
  box-shadow: var(--box-shadow);
}

#divDescWithSpecs {
  display: flex;
  margin-top: 10px;
  width: 100%;
  flex-direction: row;
  justify-content: space-between;
}

#divDescOuter {
  width: 75%;
  padding: 10px;
}

#divSpecsOuter {
  width: 25%;
  padding: 10px;
}

.d-s {
  padding: 10px;
  text-align: left;
  font-size: 32px;
  font-weight: 600;
  color: #363636;
  line-height: 1.125;
}

#divDescInner {
  background-color: var(--first-color);
  box-shadow: var(--box-shadow);
}

.desc-content {
  text-align: justify;
  color: #000;
  font-size: 18px;
}

#divSpecsInner {
  background-color: var(--first-color);
  box-shadow: var(--box-shadow);
  text-align: justify;
  color: #000;
  font-size: 18px;
}

#tab {
  width: 100%;
}

#col1 {
  padding-left: 5px;
  width: 50%;
}

#col2 {
  padding-left: 5px;
}

tr:nth-child(even) {
  background-color: var(--fourth-color);
}

</style>
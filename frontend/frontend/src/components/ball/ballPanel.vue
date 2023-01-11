<template>
  <div id="content">
    <div id="divTitle">
      <p class="name n-p">{{ ball.name }}</p>
      <p class="price n-p">{{ ball.price }} zł</p>
    </div>
    <div id="divImage">
      <img id="i" v-bind:src="ball.image" v-bind:alt="ball.name">
    </div>
    <div id="divDescWithSpecs">
      <div id="divDescOuter">
        <p class="d-s">Opis</p>
        <div id="divDescInner" class="box">
          <p class="desc-content">{{ ball.description }}</p>
        </div>
      </div>
      <div id="divSpecsOuter">
        <p class="d-s">Specyfikacja</p>
        <div id="divSpecsInner" class="box">
          <table id="tab">
            <tr>
              <td id="col1">Nawierzchnia: </td>
              <td id="col2">{{ ball.surface }}</td>
            </tr>
            <tr>
              <td id="col1">Typ: </td>
              <td id="col2">{{ ball.ballType }}</td>
            </tr>
            <tr>
              <td id="col1">Klasa: </td>
              <td id="col2">{{ ball.ballClass }}</td>
            </tr>
            <tr>
              <td id="col1">Liczba piłek: </td>
              <td id="col2">{{ ball.quantity }}</td>
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
  name: "ballPanel",
  data() {
    return {
      loaded: false,
    }
  },
  mounted() {
    this.getBall(this.$route.params.id).then(() => {
      this.loaded = true;
    })
    document.title = "Piłka " + this.$route.params.id + " - TennisStock";
  },
  methods: {
    ...mapActions("ball", ["getBall"])
  },
  watch: {
    $route() {
      this.loaded = false;
      this.getBall(this.$route.params.id).then(() => {
        this.loaded = true;
      });
    }
  },
  computed: {
    ...mapState({
      ball: (state) => state.ball.ball,
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
  background-color: white;
  box-shadow: black;
}

.desc-content {
  text-align: justify;
  color: black;
  font-size: 18px;
}

#divSpecsInner {
  background-color: white;
  box-shadow: black;
  text-align: justify;
  color: black;
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
  background-color: #DCDCDC;
}

</style>
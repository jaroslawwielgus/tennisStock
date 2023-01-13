<template>
  <div id="content">
    <itemPanelNamePriceImage :item="racket"/>
    <div id="divDescWithSpecs">
      <itemPanelDescription :item="racket"/>
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
import itemPanelNamePriceImage from '../item/itemPanelNamePriceImage.vue';
import itemPanelDescription from '../item/itemPanelDescription.vue';

export default {
  name: "racketPanel",
  components: {
    itemPanelNamePriceImage,
    itemPanelDescription
  },
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
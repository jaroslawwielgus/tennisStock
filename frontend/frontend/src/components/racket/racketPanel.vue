<template>
  <div id="contentPanel">
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

<style></style>
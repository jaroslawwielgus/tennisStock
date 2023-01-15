<template>
  <div id="contentPanel">
    <itemPanelNamePriceImage :item="racketString"/>
    <div id="divDescWithSpecs">
      <itemPanelDescription :item="racketString"/>
      <div id="divSpecsOuter">
        <p class="d-s">Specyfikacja</p>
        <div id="divSpecsInner" class="box">
          <table id="tab">
            <tr>
              <td id="col1">Typ: </td>
              <td id="col2" class="enum">{{ racketString.type }}</td>
            </tr>
            <tr>
              <td id="col1">Średnica: </td>
              <td id="col2">{{ racketString.diameter }} mm</td>
            </tr>
            <tr>
              <td id="col1">Długość: </td>
              <td id="col2">{{ racketString.length }} m</td>
            </tr>
            <tr>
              <td id="col1">Kolor: </td>
              <td id="col2" class="enum">{{ racketString.color }}</td>
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
  name: "racketStringPanel",
  components: {
    itemPanelNamePriceImage,
    itemPanelDescription,
  },
  data() {
    return {
      loaded: false,
    }
  },
  mounted() {
    this.getRacketString(this.$route.params.id).then(() => {
      this.loaded = true;
    })
    document.title = "Naciąg " + this.$route.params.id + " - TennisStock";
  },
  methods: {
    ...mapActions("racketString", ["getRacketString"])
  },
  watch: {
    $route() {
      this.loaded = false;
      this.getRacketString(this.$route.params.id).then(() => {
        this.loaded = true;
      });
    }
  },
  computed: {
    ...mapState({
      racketString: (state) => state.racketString.racketString,
    }),
  }
}
</script>

<style></style>
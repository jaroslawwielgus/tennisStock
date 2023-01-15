<template>
  <div id="contentPanel">
   <itemPanelNamePriceImage :item="ball"/>
    <div id="divDescWithSpecs">
      <itemPanelDescription :item="ball"/>
      <div id="divSpecsOuter">
        <p class="d-s">Specyfikacja</p>
        <div id="divSpecsInner" class="box">
          <table id="tab">
            <tr>
              <td id="col1">Nawierzchnia: </td>
              <td id="col2" class="enum">{{ ball.surface }}</td>
            </tr>
            <tr>
              <td id="col1">Typ: </td>
              <td id="col2" class="enum">{{ ball.ballType }}</td>
            </tr>
            <tr>
              <td id="col1">Klasa: </td>
              <td id="col2" class="enum">{{ ball.ballClass }}</td>
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
import itemPanelNamePriceImage from '../item/itemPanelNamePriceImage.vue'
import itemPanelDescription from '../item/itemPanelDescription.vue'

export default {
  name: "ballPanel",
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

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#contentPanel {
  display: flex;
  flex-flow: column;
  position: relative;
  padding: 10px;
  height: 100%;
  text-align: center;
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
  color: var(--second-color);
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

.enum {
  text-transform: lowercase;
}

tr:nth-child(even) {
  background-color: #E8E8E8;
}

</style>
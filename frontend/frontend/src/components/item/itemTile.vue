<template>
  <div id="tile" class="box">
    <div class="tile-container">
      <div class="tile-name-with-price">
        <p class="tile-name">{{ item.name }}</p>
        <p class="tile-price">{{ item.price.toFixed(2) }} zł</p>
      </div>
      <div class="tile-image">
        <img id="i" v-bind:src="item.image" v-bind:alt="item.name">
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "itemTile",
    props: {
        item: { type: Object},
    },
};
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#tile {
  width: 100%;
  height: fit-content;
  min-height: 150px;
  background-color: var(--first-color);
  border-color: #a8a8a8;
  border-style: solid;
  color: #000;
  text-align: center;
}

.tile-container {
  width: auto;
  height: 85%;
}

.tile-name-with-price {
  display: flex;
  width: 100%;
  height: 30%;
}

.tile-name {
  padding-left: 5px;
  flex: 1;
  text-align: left;
  font-weight: bold;
  font-size: 23px;
}

.tile-price {
  margin-left: 10px;
  padding-right: 5px;
  width: fit-content;
  text-align: right;
  font-weight: bold;
  font-size: 23px;
  word-wrap: break-word;
}

.tile-image {
  padding-top: 10px;
  width: 100%;
  height: 70%;
}

#i {
  height: 200px;
  object-fit: contain;
}
</style>
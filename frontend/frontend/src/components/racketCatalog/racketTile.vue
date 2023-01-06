<template>
  <div id="racketTile" class="box">
    <div class="racket-tile-container">
      <div class="racket-tile-name-container">
        <p class="racket-tile-name">{{ racket.name }}</p>
        <p class="racket-tile-price">{{ racket.price }} zł</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "racketTile",
    props: {
        racket: { type: Object},
    },
};
</script>

<style scoped>
#racketTile {
  background-color: white;
  border-color: black;
  border-style: solid;
  color: black;
  width: 100%;
  height: fit-content;
  min-height: 150px;
  text-align: center;
}

.racket-tile-container {
  width: auto;
  height: 85%;
}

.racket-tile-name-container {
  display: flex;
  width: 100%;
  height: 30%;
}

.racket-tile-name {
  flex: 1;
  text-align: left;
  padding-left: 5px;
  font-weight: bold;
  font-size: 25px;
}

.racket-tile-price {
  color: rgb(139, 139, 139);
  padding-right: 5px;
  text-align: right;
  font-weight: bold;
  font-size: 25px;
  width: fit-content;
  margin-left: 10px;
  word-wrap: break-word;
  float: right;
}
</style>
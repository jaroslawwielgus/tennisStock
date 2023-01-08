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
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#racketTile {
  width: 100%;
  height: fit-content;
  min-height: 150px;
  background-color: white;
  border-color: black;
  border-style: solid;
  color: black;
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
  padding-left: 5px;
  flex: 1;
  text-align: left;
  font-weight: bold;
  font-size: 25px;
}

.racket-tile-price {
  margin-left: 10px;
  padding-right: 5px;
  width: fit-content;
  color: rgb(139, 139, 139);
  text-align: right;
  font-weight: bold;
  font-size: 25px;
  word-wrap: break-word;
}
</style>
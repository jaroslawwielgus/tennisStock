<template>
  <div id="divDescOuter">
    <p class="d-s">Opis</p>
    <div id="divDescInner" class="box">
      <p class="desc-content">{{ item.description }}</p>
    </div>
  </div>
</template>
  
  <script>
  export default {
    name: "itemPanelDescription",
    props: {
        item: { type: Object},
    },
  }
  </script>
  
  <style scoped>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  
  #divDescOuter {
    width: 75%;
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
  
  #divDescInner {
    background-color: var(--first-color);
    box-shadow: var(--box-shadow);
  }
  
  .desc-content {
    text-align: justify;
    color: #000;
    font-size: 18px;
  }
  
  </style>
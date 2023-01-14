<template>
  <div>
    <div id="divTitle">
      <p class="name n-p">{{ item.name }}</p>
      <p class="price n-p">{{ item?.price?.toFixed(2) }} zł</p>
    </div>
    <div id="divImage">
      <img id="i" v-bind:src="item.image" v-bind:alt="item.name">
    </div>
  </div>
</template>
  
  <script>
  export default {
    name: "itemPanelNamePriceImage",
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
    color: var(--second-color);
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

  </style>
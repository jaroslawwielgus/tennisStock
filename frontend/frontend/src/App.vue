<template>
  <div id="app">
    <NavBar/>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
var head = document.getElementsByTagName("head")[0];
var mdiLink = document.createElement("link");
mdiLink.id = "MaterialDesign";
mdiLink.rel = "stylesheet";
mdiLink.type = "text/css";
mdiLink.media = "all";

var mdiRequest = new Request(
  "https://cdn.materialdesignicons.com/5.8.55/css/materialdesignicons.min.css"
);

fetch(mdiRequest)
  .then(function (value) {
    if (value.status == 404) {
      throw new Error("Redirected page not found");
    }
    mdiLink.href =
      "https://cdn.materialdesignicons.com/5.8.55/css/materialdesignicons.min.css";
  })
  .catch(() => {
    mdiLink.href =
      "https://cdnjs.cloudflare.com/ajax/libs/materialDesign-Webfont/5.8.55/css/materialdesignicons.min.css";
  });

head.appendChild(mdiLink);

import NavBar from "./components/layout/NavBar.vue";

export default {
  name: 'App',
  components: {
    NavBar,
  },
}
</script>

<style scoped>
@import '@/styles/colors.css';

html {
  overflow: auto;
  background-color: var(--first-color);
}

html,
body {
  height: 100%;
}

#navbar {
  position: sticky;
  top: 0;
}

#app {
  height: 100vh;
  display: flex;
  flex-flow: column;
}

#content {
  padding: 10px;
  height: 100%;
  position: relative;
  word-wrap: anywhere;
  white-space: normal;
  background-color: var(--first-color);
}
</style>

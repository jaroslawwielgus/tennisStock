<template>
  <div id="app">
    <NavBar/>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
import NavBar from "./components/layout/NavBar.vue";

export default {
  name: 'App',
  components: {
    NavBar,
  },
}
</script>

<style scoped>
html {
  overflow: auto;
  background-color: white;
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
  height: 100%;
  display: flex;
  flex-flow: column;
}

#content {
  padding: 10px;
  height: 100%;
  position: relative;
  word-wrap: anywhere;
  white-space: normal;
  background-color: green;
}
</style>

<template>
    <b-navbar>
      <template #brand>
        <b-navbar-item tag="router-link" :to="{ name: 'rackets' }">
          <img id="i" src="../../assets/logo.png" alt="Logo"/>
        </b-navbar-item>
      </template>
  
      <template #start>
        <b-navbar-item :to="{ name: 'ballsCatalog' }" tag="router-link">
          <strong>Piłki</strong>
        </b-navbar-item>
        <b-navbar-item :to="{ name: 'racketStringsCatalog' }" tag="router-link">
          <strong>Naciągi</strong>
        </b-navbar-item>
      </template>
    </b-navbar>
  </template>
  
  <script>
  export default {
    name: "NavBar",
  };
  </script>
  
  <style scoped>
  .navbar {
    background-color: var(--third-color);
  }

  a {
    color: #fff;
  }

  a.navbar-item:hover,
  a.navbar-item:focus {
      color: var(--third-color);
  }

  #i {
    transform: scale(1.5); 
    margin-left: 10px; 
    margin-right: 10px;
  }
  </style>
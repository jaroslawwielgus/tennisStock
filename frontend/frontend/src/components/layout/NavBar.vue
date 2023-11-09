<template>
	<b-navbar centered class="is-black">
		<template #start>
			<b-navbar-item :to="{ name: 'rackets' }" tag="router-link">
				<strong>Rakiety</strong>
			</b-navbar-item>
			<b-navbar-item
				:to="{ name: 'ballsCatalog' }"
				tag="router-link"
				class="second-navbar-item"
			>
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
	padding: 0 100px;
	/* color: var(--first-color); */
}

a:hover,
a:focus {
	background-color: var(--first-color) !important;
	color: var(--third-color) !important;
}

#i {
	transform: scale(1.5);
	margin-left: 10px;
	margin-right: 10px;
}
</style>

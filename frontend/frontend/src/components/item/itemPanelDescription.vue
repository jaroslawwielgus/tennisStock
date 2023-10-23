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
		item: { type: Object },
	},
};
</script>

<style scoped>
#divDescOuter {
	width: 100%;
	padding: 10px;
}

#divDescInner {
	background-color: var(--first-color);
	box-shadow: var(--box-shadow);
}

.desc-content {
	text-align: justify;
	color: #000;
	font-size: 12px;
}

@media (min-width: 576px) {
	.desc-content {
		font-size: 18px;
	}
}

@media (min-width: 1200px) {
	#divDescOuter {
		width: 75%;
	}
}
</style>

<template>
	<div id="tile" class="box">
		<div class="tile-container">
			<div class="tile-name-with-price">
				<p class="tile-name" :class="{ 'add-space': item.name.length < 30 }">
					{{ truncatedName }}
				</p>

				<p class="tile-price">{{ item.price.toFixed(2) }} zł</p>
			</div>
			<div class="tile-image">
				<img id="i" v-bind:src="item.image" v-bind:alt="item.name" />
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: "itemTile",
	props: {
		item: { type: Object },
	},
	computed: {
		truncatedName() {
			let originalName = this.item.name;
			if (originalName.length > 30) {
				return originalName.slice(0, 30 - 3) + "...";
			} else if (originalName.length < 30) {
				let spacesToAdd = 30 - originalName.length;
				return originalName + " ".repeat(spacesToAdd);
			} else {
				return originalName;
			}
		},
	},
};
</script>

<style scoped>
#i {
	height: 120px;
	object-fit: contain;
}

#tile {
	width: 100%;
	height: fit-content;
	min-height: 150px;
	background-color: var(--first-color);
	box-shadow: var(--box-shadow);
	color: #000;
	text-align: center;
	border: 2px solid transparent;
}

#tile:hover {
	border-color: black;
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
	font-size: 18px;
	white-space: pre-wrap;
	display: inline;
}

.tile-price {
	margin-left: 10px;
	padding-right: 5px;
	width: fit-content;
	text-align: right;
	font-weight: bold;
	font-size: 18px;
	word-wrap: break-word;
}

.tile-image {
	padding-top: 10px;
	width: 100%;
	height: 70%;
}
.add-space::after {
	content: "\00a0";
}

.tile-name {
	white-space: pre-wrap;
}

.tile-name.add-space::after {
	content: "\00a0";
}

@media (min-width: 576px) {
	#i {
		height: 200px;
	}

	.tile-name {
		font-size: 23px;
	}

	.tile-price {
		font-size: 23px;
	}
}
</style>

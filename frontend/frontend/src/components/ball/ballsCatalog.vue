<template>
	<div id="contentCatalog">
		<div id="divTitle">
			<p class="title">Katalog piłek</p>
		</div>
		<div id="contentItemsWithPagination" v-if="loaded">
			<div id="contentItems" class="box">
				<div id="cols" class="columns">
					<div class="column">
						<itemTile
							v-for="ball in pBalls[0]"
							:key="ball.name"
							:item="ball"
							style="cursor: pointer"
							@click.native="moveToBall(ball.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="ball in pBalls[1]"
							:key="ball.name"
							:item="ball"
							style="cursor: pointer"
							@click.native="moveToBall(ball.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="ball in pBalls[2]"
							:key="ball.name"
							:item="ball"
							style="cursor: pointer"
							@click.native="moveToBall(ball.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="ball in pBalls[3]"
							:key="ball.name"
							:item="ball"
							style="cursor: pointer"
							@click.native="moveToBall(ball.id)"
						/>
					</div>
				</div>
			</div>

			<br />

			<div id="contentPagination" class="columns">
				<div class="column is-two-thirds"></div>
				<div class="box column is-one-third">
					<b-pagination
						order="is-centered"
						:total="balls.length"
						:per-page="perPage"
						:current.sync="current"
						@change="scrollToTop"
					></b-pagination>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import itemTile from "../item/itemTile.vue";

export default {
	name: "ballsCatalog",
	components: {
		itemTile,
	},

	data() {
		return {
			loaded: false,
			current: 1,
			perPage: 20,
			pageOfItems: [],
			pBalls: [],
		};
	},

	methods: {
		...mapActions("ball", ["getBalls"]),

		splitToFourColumns(balls) {
			let firstColumn = [];
			let secondColumn = [];
			let thirdColumn = [];
			let fourthColumn = [];

			if (window.innerWidth < 768) {
				for (let i = 0; i < balls.length; i++) {
					firstColumn.push(balls[i]);
				}
			} else if (window.innerWidth >= 768 && window.innerWidth < 1200) {
				for (let i = 0; i < balls.length; i++) {
					if (i % 2 == 0) {
						firstColumn.push(balls[i]);
					} else {
						secondColumn.push(balls[i]);
					}
				}
			} else if (window.innerWidth >= 1200 && window.innerWidth < 1400) {
				for (let i = 0; i < balls.length; i++) {
					if (i % 3 == 0) {
						firstColumn.push(balls[i]);
					} else if (i % 3 == 1) {
						secondColumn.push(balls[i]);
					} else {
						thirdColumn.push(balls[i]);
					}
				}
			} else {
				for (let i = 0; i < balls.length; i++) {
					if (i % 4 == 0) {
						firstColumn.push(balls[i]);
					} else if (i % 4 == 1) {
						secondColumn.push(balls[i]);
					} else if (i % 4 == 2) {
						thirdColumn.push(balls[i]);
					} else {
						fourthColumn.push(balls[i]);
					}
				}
			}

			this.pBalls = [firstColumn, secondColumn, thirdColumn, fourthColumn];
		},

		onChangePage(pageOfItems) {
			this.pageOfItems = pageOfItems;
		},

		moveToBall(ballId) {
			this.$router.push(`/ball/${ballId}`);
		},

		scrollToTop() {
			document.querySelector("#contentItems").scrollTo(0, 0);
		},
	},

	computed: {
		...mapState({
			balls: (state) => state.ball.balls,
		}),

		paginatedBalls() {
			let page_number = this.current - 1;

			return this.balls.slice(
				page_number * this.perPage,
				(page_number + 1) * this.perPage
			);
		},
	},

	mounted() {
		document.title = "Piłki - TennisStock";
		this.getBalls().then(() => (this.loaded = true));
		setInterval(() => {
			this.splitToFourColumns(this.paginatedBalls);
		}, 1);
	},
};
</script>

<style>
#contentCatalog {
	display: flex;
	flex-flow: column;
	position: relative;
	padding: 0 10px 10px 10px;
	height: 100%;
	word-wrap: anywhere;
	white-space: normal;
}

#divTitle .title {
	/* margin-bottom: 20px; */
	padding: 0 10px;
	font-size: 26px;
	text-align: left;
}

#contentItemsWithPagination {
	display: flex;
	flex: 1 0 0px;
	flex-flow: column;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 77vh;
	overflow: hidden;
}

#contentItems {
	flex: 1 0 0px;
	margin: 10px;
	/* min-height: 70%; */
	box-shadow: var(--box-shadow);
	overflow: auto;
}

#contentPagination {
	display: flex;
	padding-bottom: 20px;
	padding-right: 5px;
	width: 100%;
	justify-content: right;
}

#contentPagination .is-one-third {
}

#cols {
	margin: 0;
}

@media (min-width: 576px) {
	#contentCatalog {
		padding-top: 10px;
	}

	#divTitle .title {
		margin-bottom: 20px;
		padding: 10px;
		font-size: 36px;
	}

	#contentPagination {
		padding-top: 20px;
	}
}

@media (min-width: 768px) {
	#cols {
		display: flex;
		flex-wrap: wrap;
	}

	.column {
		width: 50%;
		box-sizing: border-box;
		flex-basis: 50% !important;
		max-width: calc(50% - 20px);
	}
}

@media (min-width: 1200px) {
	#cols {
		display: flex;
		flex-wrap: wrap;
	}

	.column {
		width: 33.33%;
		box-sizing: border-box;
		flex-basis: calc(33.33% - 20px) !important;
		max-width: calc(33.33% - 20px);
	}
}

@media (min-width: 1400px) {
	.column {
		width: 25%;
		box-sizing: border-box;
		flex-basis: calc(25% - 20px) !important;
		max-width: calc(25% - 20px);
	}
}
</style>

<style scoped>
#divTitle {
	display: flex;
	width: 100%;
	flex-direction: row;
	justify-content: space-between;
}
</style>

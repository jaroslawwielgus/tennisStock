<template>
	<div id="contentCatalog">
		<div id="divTitle">
			<p class="title">Katalog rakiet</p>
		</div>
		<div id="contentItemsWithPagination" v-if="loaded">
			<div id="contentItems" class="box">
				<div id="cols" class="columns">
					<div class="column">
						<itemTile
							v-for="racket in pRackets[0]"
							:key="racket[0].name"
							:item="racket[0]"
							style="cursor: pointer"
							@click.native="moveToRacket(racket[0].id)"
							:class="{ 'item-tile': racket[1] === 0 }"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racket in pRackets[1]"
							:key="racket[0].name"
							:item="racket[0]"
							style="cursor: pointer"
							@click.native="moveToRacket(racket[0].id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racket in pRackets[2]"
							:key="racket[0].name"
							:item="racket[0]"
							style="cursor: pointer"
							@click.native="moveToRacket(racket[0].id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racket in pRackets[3]"
							:key="racket[0].name"
							:item="racket[0]"
							style="cursor: pointer"
							@click.native="moveToRacket(racket[0].id)"
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
						:total="rackets.length"
						:per-page="perPage"
						:current.sync="current"
						@change="scrollToTop"
						@hook:mounted="addSecondPaginationLinkClass"
					>
					</b-pagination>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import itemTile from "../item/itemTile.vue";

export default {
	name: "racketsCatalog",
	components: {
		itemTile,
	},

	data() {
		return {
			loaded: false,
			current: 1,
			perPage: 20,
			pageOfItems: [],
			pRackets: [],
		};
	},

	methods: {
		...mapActions("racket", ["getRackets"]),

		selectAndAddClassToFirstItemTile() {
			const firstItemTile = this.$refs.firstItemTile;

			if (firstItemTile) {
				firstItemTile.$el.classlist.add("item-tile");
			}
		},

		splitToFourColumns(rackets) {
			let firstColumn = [];
			let secondColumn = [];
			let thirdColumn = [];
			let fourthColumn = [];

			if (window.innerWidth < 768) {
				for (let i = 0; i < rackets.length; i++) {
					firstColumn.push([rackets[i], i]);
				}
			} else if (window.innerWidth >= 768 && window.innerWidth < 1200) {
				for (let i = 0; i < rackets.length; i++) {
					if (i % 2 == 0) {
						firstColumn.push([rackets[i], i]);
					} else {
						secondColumn.push([rackets[i], i]);
					}
				}
			} else if (window.innerWidth >= 1200 && window.innerWidth < 1400) {
				for (let i = 0; i < rackets.length; i++) {
					if (i % 3 == 0) {
						firstColumn.push([rackets[i], i]);
					} else if (i % 3 == 1) {
						secondColumn.push([rackets[i], i]);
					} else {
						thirdColumn.push([rackets[i], i]);
					}
				}
			} else {
				for (let i = 0; i < rackets.length; i++) {
					if (i % 4 == 0) {
						firstColumn.push([rackets[i], i]);
					} else if (i % 4 == 1) {
						secondColumn.push([rackets[i], i]);
					} else if (i % 4 == 2) {
						thirdColumn.push([rackets[i], i]);
					} else {
						fourthColumn.push([rackets[i], i]);
					}
				}
			}

			this.pRackets = [firstColumn, secondColumn, thirdColumn, fourthColumn];
		},

		onChangePage(pageOfItems) {
			this.pageOfItems = pageOfItems;
		},

		moveToRacket(racketId) {
			this.$router.push(`/racket/${racketId}`);
		},

		scrollToTop() {
			document.querySelector("#contentItems").scrollTo(0, 0);
		},

		addSecondPaginationLinkClass() {
			const secondPaginationLink = document.querySelector(
				".pagination-link:nth-child(2)"
			);

			if (secondPaginationLink) {
				secondPaginationLink.classList.add("second-pagination-link");
			}
		},
	},

	computed: {
		...mapState({
			rackets: (state) => state.racket.rackets,
		}),

		paginatedRackets() {
			let page_number = this.current - 1;

			return this.rackets.slice(
				page_number * this.perPage,
				(page_number + 1) * this.perPage
			);
		},
	},

	mounted() {
		document.title = "Rakiety - TennisStock";
		this.getRackets().then(() => (this.loaded = true));
		setInterval(() => {
			this.splitToFourColumns(this.paginatedRackets);
		}, 1);
		this.selectAndAddClassToFirstItemTile();
		this.pag();
	},
};
</script>

<style></style>

<style scoped>
#divTitle {
	display: flex;
	width: 100%;
	flex-direction: row;
	justify-content: space-between;
}
</style>

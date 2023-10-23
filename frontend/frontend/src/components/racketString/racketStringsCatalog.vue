<template>
	<div id="contentCatalog">
		<div id="divTitle">
			<p class="title">Katalog naciągów</p>
		</div>
		<div id="contentItemsWithPagination" v-if="loaded">
			<div id="contentItems" class="box">
				<div id="cols" class="columns">
					<div class="column">
						<itemTile
							v-for="racketString in pRacketStrings[0]"
							:key="racketString.name"
							:item="racketString"
							style="cursor: pointer"
							@click.native="moveToRacketString(racketString.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racketString in pRacketStrings[1]"
							:key="racketString.name"
							:item="racketString"
							style="cursor: pointer"
							@click.native="moveToRacketString(racketString.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racketString in pRacketStrings[2]"
							:key="racketString.name"
							:item="racketString"
							style="cursor: pointer"
							@click.native="moveToRacketString(racketString.id)"
						/>
					</div>
					<div class="column">
						<itemTile
							v-for="racketString in pRacketStrings[3]"
							:key="racketString.name"
							:item="racketString"
							style="cursor: pointer"
							@click.native="moveToRacketString(racketString.id)"
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
						:total="racketStrings.length"
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
	name: "racketStringsCatalog",
	components: {
		itemTile,
	},

	data() {
		return {
			loaded: false,
			current: 1,
			perPage: 20,
			pageOfItems: [],
			pRacketStrings: [],
		};
	},

	methods: {
		...mapActions("racketString", ["getRacketStrings"]),

		splitToFourColumns(racketStrings) {
			let firstColumn = [];
			let secondColumn = [];
			let thirdColumn = [];
			let fourthColumn = [];

			if (window.innerWidth < 768) {
				for (let i = 0; i < racketStrings.length; i++) {
					firstColumn.push(racketStrings[i]);
				}
			} else if (window.innerWidth >= 768 && window.innerWidth < 1200) {
				for (let i = 0; i < racketStrings.length; i++) {
					if (i % 2 == 0) {
						firstColumn.push(racketStrings[i]);
					} else {
						secondColumn.push(racketStrings[i]);
					}
				}
			} else if (window.innerWidth >= 1200 && window.innerWidth < 1400) {
				for (let i = 0; i < racketStrings.length; i++) {
					if (i % 3 == 0) {
						firstColumn.push(racketStrings[i]);
					} else if (i % 3 == 1) {
						secondColumn.push(racketStrings[i]);
					} else {
						thirdColumn.push(racketStrings[i]);
					}
				}
			} else {
				for (let i = 0; i < racketStrings.length; i++) {
					if (i % 4 == 0) {
						firstColumn.push(racketStrings[i]);
					} else if (i % 4 == 1) {
						secondColumn.push(racketStrings[i]);
					} else if (i % 4 == 2) {
						thirdColumn.push(racketStrings[i]);
					} else {
						fourthColumn.push(racketStrings[i]);
					}
				}
			}
			this.pRacketStrings = [
				firstColumn,
				secondColumn,
				thirdColumn,
				fourthColumn,
			];
		},

		onChangePage(pageOfItems) {
			this.pageOfItems = pageOfItems;
		},

		moveToRacketString(racketStringId) {
			this.$router.push(`/racket-string/${racketStringId}`);
		},

		scrollToTop() {
			document.querySelector("#contentItems").scrollTo(0, 0);
		},
	},

	computed: {
		...mapState({
			racketStrings: (state) => state.racketString.racketStrings,
		}),

		paginatedRacketStrings() {
			let page_number = this.current - 1;

			return this.racketStrings.slice(
				page_number * this.perPage,
				(page_number + 1) * this.perPage
			);
		},
	},

	mounted() {
		document.title = "Naciągi - TennisStock";
		this.getRacketStrings().then(() => (this.loaded = true));
		setInterval(() => {
			this.splitToFourColumns(this.paginatedRacketStrings);
		}, 1);
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

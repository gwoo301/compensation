<template>
    <div>
        <v-card-title v-if="editMode">
            {{label}}
        </v-card-title>
        <v-card-text v-if="value">
            <div v-if="editMode">
                <v-text-field type="number" label="Amount" v-model="value.amount"/>
            </div>
            <div v-if="editMode">
                <v-text-field label="Currency" v-model="value.currency"/>
            </div>
            <div v-else>
                <v-card
                    class="mx-auto"
                    color="surface"
                    dark
                    min-width="200"
                    max-width="400"
                    style="padding:10px 15px 10px 15px; font-weight:500; font-size:20px; text-align:center;"> 
                    {{value.amount}} {{value.currency}} 
                </v-card>
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name:"Money",
        props: {
            editMode: Boolean,
            value : Object,
            label : String,
        },
        created(){
            if(!this.value) {
                this.value = {
                    'amount': 0,
                    'currency': '',
                };
            }

            this.value.amount = this.value.amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },
    }
</script>

<style scoped>
</style>
<template>
    <div id="searchBoxItemBox" style="padding: 5px">
        <div style="display: flex;justify-content: left;flex-direction: row;align-items: center">
            <h4 style="border-right: 2px solid #484c50;padding-right: 10px;">{{ title }}</h4>
            <template v-for="i in context">
                <div class="searchBoxItem">{{ i.name }}</div>
            </template>
        </div>
    </div>
</template>

<script>
export default {
    name: "SearchBoxItem",
    props: {
        context: null,
        title: String
    }
}
</script>

<style scoped>

.searchBoxItem {
    margin: 0 10px;
}

#searchBoxItemBox:hover {
    background-color: #c1d6e0;
    animation: colorAnimation 0.2s;
}


@keyframes colorAnimation {
    0%, 10% {
        background-image: linear-gradient(to right, #fafcfa, #fafcfa, #fafcfa, #fafcfa, #fafcfa, #fafcfa);
    }
    20%, 30% {
        background-image: linear-gradient(to right, #9cf2c7, #fafcfa, #fafcfa, #fafcfa, #fafcfa, #fafcfa);
    }
    40%, 50% {
        background-image: linear-gradient(to right, #9cf2c7, #9cf2c7, #fafcfa, #fafcfa, #fafcfa, #fafcfa);
    }
    60%, 70% {
        background-image: linear-gradient(to right, #9cf2c7, #9cf2c7, #9cf2c7, #fafcfa, #fafcfa, #fafcfa);
    }
    80%, 90% {
        background-image: linear-gradient(to right, #9cf2c7, #9cf2c7, #9cf2c7, #9cf2c7, #9cf2c7, #fafcfa);
    }
    100% {
        background-image: linear-gradient(to right, #9cf2c7, #9cf2c7, #9cf2c7, #9cf2c7, #9cf2c7, #9cf2c7);
    }
}






</style>

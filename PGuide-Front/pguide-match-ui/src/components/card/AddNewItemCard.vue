<template>
    <div class="userGroupInfoNew"
         style="width:100%;height:100%;border-radius: 10px;border: 3px dashed lightgreen;
                        display: flex;justify-content: center;align-items: center;flex-direction: column"
         @mouseenter="mouseOnUserGroupInfoNewBody"
         @mouseleave="mouseLeaveUserGroupInfoNewBody"
    >
        <div class="userGroupInfoNewBody" ref="userGroupInfoNewBody"
        >
            <p> +</p>
            <p class="userGroupInfoNewP" ref="userGroupInfoNewP">
                创建
            </p>
        </div>

    </div>
</template>

<script>
export default {
    name: "AddNewItemCard",

    methods:{
        mouseOnUserGroupInfoNewBody(){
            this.$refs["userGroupInfoNewBody"].style = this.$refs["userGroupInfoNewBody"].style + "color: lime;border: 2px solid lime;box-shadow:0px 0px 100px lightgreen;transition: box-shadow 0.5s;"
        },
        mouseLeaveUserGroupInfoNewBody(){
            this.$refs["userGroupInfoNewBody"].style = "";
        }
    }
}
</script>

<style scoped>
.userGroupInfoNew:hover{
    background-color: #e6e6e6;
    transition: background-color 0.5s;
}

.userGroupInfoNewP{
    font-size: 14px
}

.userGroupInfoNewPHover{
    color: lime;
    border: 2px dashed lime;
}

.userGroupInfoNewBody{
    width: 20%;height: 40%;border-radius: 50% 50% 50% 50% / 50% 50% 50% 50%;color: lightgreen;
    font-size: 28px;border: 2px dashed lightgreen;
    display: flex;justify-content: center;align-items: center;flex-direction: column;
}
</style>

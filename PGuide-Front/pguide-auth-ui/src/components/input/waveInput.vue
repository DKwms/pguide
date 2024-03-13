<template>
    <div class="inputBox">
        <input type="text" required>
        <label id="waveLabel" class="waveLabel">password </label>
    </div>
</template>

<script>
export default {
    name: "waveInput",
    mounted() {
        const labels = document.getElementsByClassName('waveLabel')
        for (const label of labels) {
            label.innerHTML = label.innerText.split('').map((letters, i) => `<span style="transition-delay: ${i * 30}ms; filter:hue-rotate(${i*10}deg);">${letters}</span>`).join('')
        }
    }
}
</script>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    /*font-family: 'Poppins', sans-serif;*/
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: #29313a;
}

.inputBox {
    position: relative;
    width: 400px;
    text-align: center;
}

.inputBox input {
    position: relative;
    width: 100%;
    padding: 10px 0;
    background-color: transparent;
    border: none;
    outline: none;
    border-bottom: 2px solid #999;
    color: #fff;
    letter-spacing: .05em;
    font-size: 1.25em;
    transition: .5s;
}

.inputBox label {
    position: absolute;
    left: 0;
    font-size: 1.25em;
    pointer-events: none;
    color: #666;
    user-select: none;
}

.inputBox label span {
    position: relative;
    display: inline-flex;
    flex-direction: row;
    font-size: 1.25em;
    letter-spacing: .05em;
    transition: .25s cubic-bezier(0.5, 1, 0.5, 1.5);
}

.inputBox input:focus ~ label span,
.inputBox input:valid ~ label span {
    color: #0f0;
    text-shadow: 0 0 5px #0f0,
    0 0 10px #0f0,
    0 0 30px #0f0;
    transform: translateY(-30px);
}

.inputBox input:focus,
.inputBox input:valid {
    border-bottom-color: #fff;
}
</style>

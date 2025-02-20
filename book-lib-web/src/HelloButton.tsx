export const HelloButton = () => {
    return <button onClick={handleClick}>
        Hello
    </button>
}

const handleClick = () => {
    alert("Clicked!" + '\n' + 'API URL: ' + process.env.API_BASE_URL)
}

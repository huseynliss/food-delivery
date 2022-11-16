
    document.querySelector('#search-input').addEventListener('input', filterList);

    function filterList() {
    const searchInput = document.querySelector('#search-input');
    const filter = searchInput.value.toLowerCase();
    const listItems = document.querySelectorAll('#productName');

    listItems.forEach((item) => {
    let text = item.textContent;
    if (text.toLowerCase().includes(filter.toLowerCase())) {
    item.parentElement.parentElement.style.display = "";
} else {
    item.parentElement.parentElement.style.display = "none";

}
});
}

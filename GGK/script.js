// JavaScript for carousel functionality
const chevLeft = document.getElementById('chev-left');
const chevRight = document.getElementById('chev-right');
const seasonImgs = document.querySelectorAll('.season-img img');
const seasonBgs = document.querySelectorAll('.season-bg');

let currentIndex = 0;

// Show initial season
showSeason(currentIndex);

// Function to show the current season
function showSeason(index) {
    // Hide all seasons
    seasonBgs.forEach(seasonBg => {
        seasonBg.style.display = 'none';
    });
    // Show the current season
    seasonBgs[index].style.display = 'block';
    // Update current index
    currentIndex = index;

    // Show the corresponding image
    seasonImgs.forEach((img, i) => {
        if (i === index) {
            img.style.display = 'block';
        } else {
            img.style.display = 'none';
        }
    });
}

// Event listeners for navigation arrows
chevLeft.addEventListener('click', () => {
    currentIndex = (currentIndex === 0) ? seasonBgs.length - 1 : currentIndex - 1;
    showSeason(currentIndex);
});

chevRight.addEventListener('click', () => {
    currentIndex = (currentIndex === seasonBgs.length - 1) ? 0 : currentIndex + 1;
    showSeason(currentIndex);
});

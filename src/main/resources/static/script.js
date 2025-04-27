document.getElementById('fetchLaptops').addEventListener('click', fetchLaptops);

function fetchLaptops() {
    fetch('http://localhost:8081/advisor/laptops')
        .then(response => response.json())
        .then(data => {
            const laptopsDiv = document.getElementById('laptops');
            laptopsDiv.innerHTML = ''; // Clear previous content

            data.forEach(laptop => {
                const laptopDiv = document.createElement('div');
                laptopDiv.className = 'laptop';

                laptopDiv.innerHTML = `
                    <h3>${laptop.brand} ${laptop.model}</h3>
                    <p>Processor: ${laptop.processor}</p>
                    <p>RAM: ${laptop.ram} GB</p>
                    <p>Storage: ${laptop.storage} GB</p>
                    <p>Price: $${laptop.price}</p>
                    <p>Status: ${laptop.reserved ? 'Reserved' : 'Available'}</p>
                    <button class="reserve-btn" ${laptop.reserved ? 'disabled' : ''} onclick="reserveLaptop(${laptop.id})">
                        ${laptop.reserved ? 'Reserved' : 'Reserve'}
                    </button>
                `;

                laptopsDiv.appendChild(laptopDiv);
            });
        })
        .catch(error => console.error('Error fetching laptops:', error));
}

function reserveLaptop(id) {
    fetch(`http://localhost:8081/advisor/laptops/${id}/reserve`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.ok) {
                alert('Laptop reserved successfully!');
                fetchLaptops(); // Refresh the list
            } else {
                alert('Failed to reserve the laptop. It might already be reserved.');
            }
        })
        .catch(error => console.error('Error reserving laptop:', error));
}
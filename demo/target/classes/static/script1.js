function capitalizeWords(name) {
        return name.replace(/\b\w/g, function (char) {
            return char.toUpperCase();
        });
    }

function formatName() {
        const nameInput = document.getElementById('name');
        let name = nameInput.value.trim(); // Trim whitespace from the input
        
        // Check if the name is all caps
        if (name === name.toUpperCase()) {
            // Convert to camel case
            name = name.toLowerCase().replace(/\b\w/g, function(char) {
                return char.toUpperCase();
            });
        } else {
            // Capitalize the first letter of each word
            name = capitalizeWords(name);
        }
        
        nameInput.value = name;
    }

    function validatePhoneNumber(phoneNumber) {
        const phonePattern = /^\d{10}$/;
        return phonePattern.test(phoneNumber);
    }

    function onSubmitHandler(event) {
        formatName();
        const phoneInput = document.getElementById('phone');
        if (!validatePhoneNumber(phoneInput.value)) {
            alert('Phone number must be exactly 10 digits.');
            event.preventDefault();
        }
    }

    window.onload = function() {
        const today = new Date().toISOString().split('T')[0];
        const dateInput = document.getElementById('dob');
        dateInput.setAttribute('max', today);
    }
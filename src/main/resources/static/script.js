const state = {
  selectedProductId: 0,
  products: [],
  checkoutFormValue: {
    fullName: '',
    address: '',
    shippingOption: ''
  }
};

function updateTable(products) {
  const tableBody = document.querySelector('tbody');
  tableBody.innerHTML = '';

  products.forEach(product => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${product.name}</td>
      <td>${product.brandName}</td>
      <td>${product.price}</td>
      <td>
          <button class="btn btn-primary" onclick="redirectToCheckout(${product.id})">SATIN AL</button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

function getProducts() {
  fetch('/product/list')
    .then(response => response.json())
    .then(products => {
      state.products = products;
      updateTable(products);
    })
    .catch(error => {
      console.error('Hata oluştu:', error);
    });
}

function redirectToCheckout(productId) {
  state.selectedProductId = productId;

  const checkoutFormContainer = document.getElementById('checkoutFormContainer');
  const productTable = document.getElementById('table');

  checkoutFormContainer.style.display = 'block';
  productTable.style.display = 'none';
}

function redirectToTable() {
  const checkoutFormContainer = document.getElementById('checkoutFormContainer');
  const productTable = document.getElementById('table');

  checkoutFormContainer.style.display = 'none';
  productTable.style.display = 'block';

  const form = document.getElementById('checkoutForm');
  form.reset();
}

function validateForm() {
  state.checkoutFormValue.fullName = document.getElementById('fullName').value;
  state.checkoutFormValue.address = document.getElementById('address').value;
  state.checkoutFormValue.shippingOption = document.getElementById('shippingOption').value;

  const form = document.getElementById('checkoutForm');
  const creditCardNumber = document.getElementById('creditCardNumber').value;


  if (creditCardNumber.length !== 16) {
      alert('Geçersiz kredi kartı numarası. Lütfen 16 haneli bir numara girin.');
      return false;
  }

  if (!/^\d+$/.test(creditCardNumber)) {
      alert('Kredi kartı numarası sadece sayılardan oluşmalıdır.');
      return false;
  }

  if (!form.checkValidity()) {
    alert('Lütfen tüm alanları doldurun ve geçerli bir kredi kartı numarası girin.');
    return false;
  }

  buyProduct();
  return false;
}

function buyProduct() {
  let product = state.products.find(product => product.id === state.selectedProductId);
  const sellProductDto = {
    productId: product.id,
    price: product.price,
    fullName: state.checkoutFormValue.fullName,
    address: state.checkoutFormValue.address,
    cargoPrice: parseFloat(state.checkoutFormValue.shippingOption)
  };

  fetch('/order/create', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(sellProductDto)
  })
    .then(response => response.json())
    .then(order => {
        alert('Satış işlemi tamamlandı. Sipariş ID: ' + order.id);
    })
    .catch(error => {
      console.error('Hata oluştu:', error);
    });
}

getProducts();
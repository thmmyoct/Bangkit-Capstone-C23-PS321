const express = require('express');
const admin = require('firebase-admin');

// Inisialisasi Firebase App
admin.initializeApp();

const app = express();
app.use(express.json());

// Mengirim permintaan layanan
app.post('/api/service-requests', async (req, res) => {
  try {
    const serviceRequestData = req.body;

    // Membuat dokumen baru di koleksi "service-requests"
    const serviceRequestRef = await admin.firestore().collection('service-requests').add(serviceRequestData);

    // Mengembalikan response dengan status keberhasilan dan ID permintaan layanan baru
    res.status(200).json({
      success: true,
      requestId: serviceRequestRef.id
    });
  } catch (error) {
    // Mengembalikan response dengan status kegagalan dan pesan error
    res.status(500).json({
      success: false,
      message: 'Failed to create service request',
      error: error.message
    });
  }
});

// Mengambil data permintaan layanan berdasarkan ID
app.get('/api/service-requests/:requestId', async (req, res) => {
  try {
    const requestId = req.params.requestId;

    // Mengambil dokumen permintaan layanan dari Firestore berdasarkan ID
    const serviceRequestDoc = await admin.firestore().collection('service-requests').doc(requestId).get();

    // Memeriksa apakah dokumen ditemukan
    if (serviceRequestDoc.exists) {
      // Mendapatkan data permintaan layanan dari dokumen
      const serviceRequestData = serviceRequestDoc.data();

      // Mengembalikan response dengan data permintaan layanan yang diambil
      res.status(200).json(serviceRequestData);
    } else {
      // Mengembalikan response dengan status 404 jika permintaan layanan tidak ditemukan
      res.status(404).json({
        success: false,
        message: 'Service request not found'
      });
    }
  } catch (error) {
    // Mengembalikan response dengan status kegagalan dan pesan error
    res.status(500).json({
      success: false,
      message: 'Failed to retrieve service request',
      error: error.message
    });
  }
});


// Port server
const port = 3000;

// Menjalankan server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});

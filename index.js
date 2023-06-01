const express = require('express');
const bodyParser = require('body-parser');
const admin = require('firebase-admin');


const serviceAccount = require('./serviceAccountKey.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
});


const app = express();
app.use(bodyParser.json());

const usersCollection = admin.firestore().collection('users'); 
const techniciansCollection = admin.firestore().collection('technicians'); 


app.post('/api/users/register', (req, res) => {

  const { nama, email, password, alamat } = req.body;

  
  admin
    .auth()
    .createUser({
      email,
      password
    })
    .then((userRecord) => {
    
      const user = {
        id: userRecord.uid,
        email,
        nama,
        alamat,
        role: 'user' 
      };

      return usersCollection.doc(userRecord.uid).set(user);
    })
    .then(() => {

      res.json({ message: 'User registered successfully' });
    })
    .catch((error) => {
      console.error('Error registering user:', error);
      res.status(500).json({ error: 'Failed to register user' });
    });
});


app.post('/api/technicians/register', (req, res) => {
  
  const { nama, email, password, noHandphone, keahlian, linkSertifikasi, linkPortofolio, jenisKeahlian } = req.body;

  admin
    .auth()
    .createUser({
      email,
      password
    })
    .then((userRecord) => {
     
      const technician = {
        id: userRecord.uid,
        nama,
        email,
        noHandphone,
        keahlian,
        linkSertifikasi,
        linkPortofolio,
        jenisKeahlian,
        role: 'technician' 
      };

      
      return techniciansCollection.doc(userRecord.uid).set(technician);
    })
    .then(() => {
    
      res.json({ message: 'Technician registered successfully' });
    })
    .catch((error) => {
      console.error('Error registering technician:', error);
      res.status(500).json({ error: 'Failed to register technician' });
    });
});

// Endpoint untuk mengambil semua data pengguna (users)
app.get('/api/users', (req, res) => {
  usersCollection
    .get()
    .then((snapshot) => {
      const users = [];
      snapshot.forEach((doc) => {
        users.push(doc.data());
      });
      res.json(users);
    })
    .catch((error) => {
      console.error('Error getting users:', error);
      res.status(500).json({ error: 'Failed to get users' });
    });
});

// Endpoint untuk mengambil semua data teknisi (technicians)
app.get('/api/technicians', (req, res) => {
  techniciansCollection
    .get()
    .then((snapshot) => {
      const technicians = [];
      snapshot.forEach((doc) => {
        technicians.push(doc.data());
      });
      res.json(technicians);
    })
    .catch((error) => {
      console.error('Error getting technicians:', error);
      res.status(500).json({ error: 'Failed to get technicians' });
    });
});

//get data berdasarkan jenis keahlian
app.get('/api/technicians', (req, res) => {
  const { jenisKeahlian } = req.query;

  techniciansCollection
    .where('jenisKeahlian', '==', jenisKeahlian)
    .get()
    .then((snapshot) => {
      const technicians = [];
      snapshot.forEach((doc) => {
        const technician = {
          nama: doc.data().nama,
          jenisKeahlian: doc.data().jenisKeahlian,
        };
        technicians.push(technician);
      });
      res.json(technicians);
    })
    .catch((error) => {
      console.error('Error getting technicians:', error);
      res.status(500).json({ error: 'Failed to get technicians' });
    });
});

//get user data berdasarkan email
app.get('/api/users/:email', (req, res) => {
  const email = req.params.email;

  usersCollection
    .where('email', '==', email)
    .get()
    .then((snapshot) => {
      if (snapshot.empty) {
        res.status(404).json({ error: 'User not found' });
      } else {
        const users = [];
        snapshot.forEach((doc) => {
          const user = doc.data();
          users.push(user);
        });
        res.json(users);
      }
    })
    .catch((error) => {
      console.error('Error getting users:', error);
      res.status(500).json({ error: 'Failed to get users' });
    });
});

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


app.listen(3000, () => {
  console.log('Server berjalan pada port 3000');
});

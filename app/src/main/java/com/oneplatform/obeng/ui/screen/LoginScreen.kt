@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.oneplatform.obeng.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.oneplatform.obeng.ui.screen.components.HeaderView
import com.oneplatform.obeng.ui.screen.components.LoginFormTechnician
import com.oneplatform.obeng.ui.screen.components.LoginFormUser
import com.oneplatform.obeng.ui.theme.ObengTheme
import com.oneplatform.obeng.ui.theme.White10

@Composable
fun LoginScreen(openDashboard: () -> Unit) {
    ObengTheme() {
        val loginPages = listOf("Customer", "Technician")
        val selectedTabIndex = rememberSaveable { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {
                when (selectedTabIndex.value) {
                    0 -> CustomerLoginPage(openDashboard)
                    1 -> TechnicianLoginPage(openDashboard)
                }
            }

            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {
                loginPages.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        onClick = { selectedTabIndex.value = index },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CustomerLoginPage(openDashboard: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ConstraintLayout {
                val (image, loginForm) = createRefs()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(image) {
                            top.linkTo(loginForm.top)
                            bottom.linkTo(loginForm.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    LoginScreenHeader()
                }
                Card(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = White10
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 100.dp)
                        .constrainAs(loginForm) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                ) {
                    LoginFormUser()
                }
            }
        }
    }
}

@Composable
fun TechnicianLoginPage(openDashboard: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ConstraintLayout {
                val (image, loginForm) = createRefs()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .constrainAs(image) {
                            top.linkTo(loginForm.top)
                            bottom.linkTo(loginForm.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    LoginScreenHeader()
                }
                Card(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = White10
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 100.dp)
                        .constrainAs(loginForm) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                ) {
                    LoginFormTechnician()
                }

            }
        }
    }
}

@Composable
fun LoginScreenHeader() {
    HeaderView()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen(openDashboard = {})
}


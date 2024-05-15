/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.snowdrop.example;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
        // Load an existing wallet holding identities used to access the network.
        /*Path walletDirectory = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletDirectory);
        //# fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/signcerts/User1@org1.example.com-cert.pem
        // readX509Certificate("-----BEGIN CERTIFICATE-----\n" +
        // "MIICUzCCAfmgAwIBAgIUTtWAhpFM1PFbofxMrhQ7uGxwGHkwCgYIKoZIzj0EAwIw\n" +
        // "ajELMAkGA1UEBhMCRVMxETAPBgNVBAcTCEFsaWNhbnRlMREwDwYDVQQJEwhBbGlj\n" +
        // "YW50ZTEZMBcGA1UEChMQS3VuZyBGdSBTb2Z0d2FyZTENMAsGA1UECxMEVGVjaDEL\n" +
        // "MAkGA1UEAxMCY2EwHhcNMjIwNTE4MTAzMTAwWhcNMjMwNTE4MTAzNjAwWjAgMQ4w\n" +
        // "DAYDVQQLEwVhZG1pbjEOMAwGA1UEAxMFYWRtaW4wWTATBgcqhkjOPQIBBggqhkjO\n" +
        // "PQMBBwNCAATV8QXgCYQtHqQgyK0vGarCHMwCflpYZblfYsE7/3J1klFMjpVH8BvP\n" +
        // "akihnBuFiCKpII4j0wLzggGDkyJVmkZio4HGMIHDMA4GA1UdDwEB/wQEAwIHgDAM\n" +
        // "BgNVHRMBAf8EAjAAMB0GA1UdDgQWBBQSkrNdXm9Zy6tM99wZgD199fYqhzArBgNV\n" +
        // "HSMEJDAigCDDCxRmTUzb7qnLr8oDiHNbmOo7mFC+Fr8bno3GmSvxUjBXBggqAwQF\n" +
        // "BgcIAQRLeyJhdHRycyI6eyJoZi5BZmZpbGlhdGlvbiI6IiIsImhmLkVucm9sbG1l\n" +
        // "bnRJRCI6ImFkbWluIiwiaGYuVHlwZSI6ImFkbWluIn19MAoGCCqGSM49BAMCA0gA\n" +
        // "MEUCIQDDcwBxEyNrN507liq1XOC7h0rGd7ua48T/PX2LGaLFcgIgawI5hELfVITj\n" +
        // "4IUzEU5AyenkEZGJ9jGSDz7Co8ZrC6U=\n" +
        // "-----END CERTIFICATE-----");
        // # fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/keystore/priv_sk
        // PrivateKey privateKey = readPrivateKey("-----BEGIN PRIVATE KEY-----\n" +
        // "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgupYb2Gr8ZaRpGmVj\n" +
        // "VFyxxlKUGoi6LX69Xwhbk7EbQIShRANCAATV8QXgCYQtHqQgyK0vGarCHMwCflpY\n" +
        // "ZblfYsE7/3J1klFMjpVH8BvPakihnBuFiCKpII4j0wLzggGDkyJVmkZi\n" +
        // "-----END PRIVATE KEY-----");
        BufferedReader certReader = new BufferedReader(new FileReader("conf/peer0-org1.apps.ocp4.yichengpai.cn/peer/cert.pem"));
		X509Certificate certificate = Identities.readX509Certificate(certReader);
        BufferedReader keyReader  = new BufferedReader(new FileReader("conf/peer0-org1.apps.ocp4.yichengpai.cn/peer/priv.key"));
		PrivateKey privateKey = Identities.readPrivateKey(keyReader);
        X509Identity identity = Identities.newX509Identity("Org1MSP", certificate, privateKey);
        wallet.put("user1", identity);

        // Path to a common connection profile describing the network.
        Path networkConfigFile = Paths.get("conf/connection.json");

        // Configure the gateway connection used to access the network.
        Gateway.Builder builder = Gateway.createBuilder()
                .identity(wallet, "user1")
                .networkConfig(networkConfigFile);

        // Create a gateway connection
        try (Gateway gateway = builder.connect()) {

            // Obtain a smart contract deployed on the network.
            Network network = gateway.getNetwork("mychannel");
            Contract contract = network.getContract("fabcar-chaincode");

            // Submit transactions that store state to the ledger.
            byte[] createCarResult = contract.createTransaction("createCar")
                    .submit("CAR13", "VW", "Polo", "Grey", "linhuanbin");
            System.out.println("*******createCar*******"+new String(createCarResult, StandardCharsets.UTF_8));

            // Evaluate transactions that query state from the ledger.
            byte[] queryAllCarsResult = contract.evaluateTransaction("queryAllCars");
            System.out.println("*******queryAllCars*******"+new String(queryAllCarsResult, StandardCharsets.UTF_8));

        } catch (ContractException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}

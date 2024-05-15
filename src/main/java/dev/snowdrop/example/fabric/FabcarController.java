package dev.snowdrop.example.fabric;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.Peer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 *
 * @author zlt
 * @version 1.0
 * @date 2022/2/21
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@RestController
public class FabcarController {
    @Resource
    private Contract contract;

    @Resource
    private Network network;

    @GetMapping("/queryCar")
    public String getCar(String key) throws ContractException {
        byte[] queryAResultBefore = contract.evaluateTransaction("queryCar", key);
        return new String(queryAResultBefore, StandardCharsets.UTF_8);
    }

    @GetMapping("/queryByOwner")
    public String queryByOwner(String owner) throws ContractException {
        byte[] queryAResultBefore = contract.evaluateTransaction("queryByOwner", owner);
        return new String(queryAResultBefore, StandardCharsets.UTF_8);
    }

    @GetMapping("/createCar")
    public String addCar(String key, String make, String model, String color, String owner) throws ContractException, InterruptedException, TimeoutException {
        byte[] invokeResult = contract.createTransaction("createCar2")
                .setEndorsingPeers(network.getChannel().getPeers(EnumSet.of(Peer.PeerRole.ENDORSING_PEER)))
                .submit(key, make, model, color, owner);//"CAR13", "VW", "Polo", "Grey", "Brian"
        String txId = new String(invokeResult, StandardCharsets.UTF_8);
        return txId;
    }

    @GetMapping("/queryAll")
    public String queryAll() throws ContractException {
        byte[] queryAResultBefore = contract.evaluateTransaction("queryAllCars");
        return new String(queryAResultBefore, StandardCharsets.UTF_8);
    }

    @GetMapping("/init")
    public String initLedger() throws ContractException, TimeoutException,
    InterruptedException {
        byte[] queryAResultBefore = contract.submitTransaction("initLedger");
        return new String(queryAResultBefore, StandardCharsets.UTF_8);
    }

    @GetMapping("/changeCarOwner")
    public String changeOwner(String key, String newOwner) throws ContractException, TimeoutException,
            InterruptedException {
        byte[] queryAResultBefore = contract.submitTransaction("changeCarOwner", key, newOwner);
        return new String(queryAResultBefore, StandardCharsets.UTF_8);
    }
}
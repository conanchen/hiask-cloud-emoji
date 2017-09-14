package org.ditto.emoji.grpc;

import io.grpc.stub.StreamObserver;
import org.ditto.emoji.model.Emoji;
import org.ditto.emoji.repository.EmojiRepository;
import org.ditto.grpc.emoji.EmojiGrpc;
import org.ditto.grpc.emoji.EmojiOuterClass;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

@GRpcService(interceptors = {LogInterceptor.class})
public class EmojiGrpcService extends EmojiGrpc.EmojiImplBase {
    @Autowired
    private EmojiRepository emojiRepository;

    @Override
    public void listEmojis(EmojiOuterClass.EmojiRequest request, StreamObserver<EmojiOuterClass.EmojiResponse> responseObserver) {

        Iterable<Emoji> emojiIterable = emojiRepository.findAll();
        Iterator<Emoji> emojiIterator = emojiIterable.iterator();
        int count = 0;
        while (emojiIterator.hasNext() && count < request.getPageSize()) {
            Emoji emoji = emojiIterator.next();
            EmojiOuterClass.EmojiResponse.Builder replyBuilder = EmojiOuterClass.EmojiResponse
                    .newBuilder()
                    .setCodepoint(emoji.codepoint)
                    .setCodepointu16(emoji.codepointu16)
                    .setGroupId(emoji.groupId)
                    .setSubgroupId(emoji.subgroupId)
                    .setName(emoji.name)
                    .setSequence(emoji.sequence)
                    .setLastUpdated(emoji.lastUpdated)
                    .setActive(emoji.active);
            responseObserver.onNext(replyBuilder.build());
            count++;
        }
        responseObserver.onCompleted();
    }
}

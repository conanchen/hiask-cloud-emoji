package org.ditto.emoji.data;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.ditto.emoji.model.Emoji;
import org.ditto.emoji.model.Emojigroup;
import org.ditto.emoji.repository.BreedRepository;
import org.ditto.emoji.repository.EmojiRepository;
import org.ditto.emoji.repository.EmojigroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务启动执行
 */
@Component
@Slf4j
public class EmojiDataImportRunner implements CommandLineRunner {

    @Autowired
    private Ignite ignite;
    @Autowired
    private EmojigroupRepository emojigroupRepository;
    @Autowired
    private EmojiRepository emojiRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Start EmojiDataImportRunner服务启动执行，执行Emoji数据导入");
        List<Object> emojiDatas = EmojiTextConverter.processEmojiText(EmojiText.emojiLines);
        for (Object emojiData : emojiDatas) {
            if (emojiData instanceof Emojigroup) {
                Emojigroup emojigroup = (Emojigroup) emojiData;
                emojigroupRepository.save(emojigroup.id, emojigroup);
            } else if (emojiData instanceof Emoji) {
                Emoji emoji = (Emoji) emojiData;
                emojiRepository.save(emoji.codepoint, emoji);
            }
        }
        log.info("End   EmojiDataImportRunner服务启动执行，执行Emoji数据导入");
    }
}

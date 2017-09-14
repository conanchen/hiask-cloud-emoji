package org.ditto.emoji.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.emoji.model.Dog;
import org.ditto.emoji.model.Emoji;

import java.util.List;

@RepositoryConfig(cacheName = "EmojiCache")
public interface EmojiRepository extends IgniteRepository<Emoji, String> {
}
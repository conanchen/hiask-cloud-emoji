package org.ditto.emoji.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.emoji.model.Emoji;
import org.ditto.emoji.model.Emojigroup;

@RepositoryConfig(cacheName = "EmojigroupCache")
public interface EmojigroupRepository extends IgniteRepository<Emojigroup, String> {
}
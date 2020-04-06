package org.jetbrains.dokka.model

import org.jetbrains.dokka.model.properties.ExtraProperty

class DefaultValue(val value: String): ExtraProperty<DParameter> {
    companion object : ExtraProperty.Key<DParameter, DefaultValue>

    override val key: ExtraProperty.Key<DParameter, *>
        get() = Companion
}
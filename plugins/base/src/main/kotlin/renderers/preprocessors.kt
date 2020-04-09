package org.jetbrains.dokka.base.renderers

import org.jetbrains.dokka.pages.*
import org.jetbrains.dokka.plugability.DokkaContext
import org.jetbrains.dokka.transformers.pages.PageTransformer

object RootCreator : PageTransformer {
    override fun invoke(input: RootPageNode) =
        RendererSpecificRootPage("", listOf(input), RenderingStrategy.DoNothing)
}


class PackageListCreator(val context: DokkaContext, val format: String, val linkExtension: String) : PageTransformer {
    override fun invoke(input: RootPageNode) = input.modified(children = input.children + packageList(input))

    private fun packageList(pageNode: RootPageNode) =
        RendererSpecificRootPage(
            "${pageNode.name}/package-list",
            emptyList(),
            RenderingStrategy.Write(PackageListService(context).formatPackageList(pageNode, format, linkExtension))
        )
}


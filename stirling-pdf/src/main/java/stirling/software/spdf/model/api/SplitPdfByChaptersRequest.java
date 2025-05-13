package stirling.software.spdf.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import lombok.EqualsAndHashCode;
import stirling.software.common.model.api.PDFFile;

@Data
@EqualsAndHashCode(callSuper = false)
public class SplitPdfByChaptersRequest extends PDFFile {
    @Schema(description = "Whether to include Metadata or not", example = "true")
    private Boolean includeMetadata;

    @Schema(description = "Whether to allow duplicates or not", example = "true")
    private Boolean allowDuplicates;

    @Schema(description = "Maximum bookmark level required", example = "2")
    private Integer bookmarkLevel;
}

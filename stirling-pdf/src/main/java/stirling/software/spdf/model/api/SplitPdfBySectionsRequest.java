package stirling.software.spdf.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import lombok.EqualsAndHashCode;

import stirling.software.common.model.api.PDFFile;

@Data
@EqualsAndHashCode(callSuper = true)
public class SplitPdfBySectionsRequest extends PDFFile {
    @Schema(description = "Number of horizontal divisions for each PDF page", example = "2")
    private int horizontalDivisions;

    @Schema(description = "Number of vertical divisions for each PDF page", example = "2")
    private int verticalDivisions;

    @Schema(description = "Merge the split documents into a single PDF", example = "true")
    private boolean merge;
}

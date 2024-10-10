package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwaptionPhysicalSettlementTypeFormatValidator implements Validator<SwaptionPhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(SwaptionPhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SwaptionPhysicalSettlement> validate(RosettaPath path, SwaptionPhysicalSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SwaptionPhysicalSettlement", ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "", error);
		}
		return success("SwaptionPhysicalSettlement", ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionPhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwaptionPhysicalSettlement", ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "", res.getError());
				}
				return success("SwaptionPhysicalSettlement", ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}

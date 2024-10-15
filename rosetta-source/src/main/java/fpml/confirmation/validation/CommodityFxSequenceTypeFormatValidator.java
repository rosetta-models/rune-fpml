package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityFxSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFxSequenceTypeFormatValidator implements Validator<CommodityFxSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityFxSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityFxSequence> validate(RosettaPath path, CommodityFxSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFxSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequence", path, "", error);
		}
		return success("CommodityFxSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFxSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFxSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequence", path, "", res.getError());
				}
				return success("CommodityFxSequence", ValidationType.TYPE_FORMAT, "CommodityFxSequence", path, "");
			})
			.collect(toList());
	}

}
